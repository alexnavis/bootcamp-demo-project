variable "region" {}
variable "shared_credentials_file" {}
variable "profile" {}
variable "amis" {
  type = map(string)
}
variable "user_public_key" {}

provider "aws" {
  region = var.region
  shared_credentials_file = var.shared_credentials_file
  profile = var.profile
}

# Create a VPC to launch our instances into
resource "aws_vpc" "default" {
  cidr_block = "10.0.0.0/16"
}

# Create an internet gateway to give our subnet access to the outside world
resource "aws_internet_gateway" "default" {
  vpc_id = aws_vpc.default.id
}

resource "aws_route" "internet_access" {
  route_table_id         = aws_vpc.default.main_route_table_id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.default.id
}

resource "aws_subnet" "default" {
  vpc_id                  = aws_vpc.default.id
  cidr_block              = "10.0.1.0/24"
  map_public_ip_on_launch = true
}

resource "aws_security_group" "bootcamp_security_group" {
  name = "bootcamp_security_group"
  description = "default VPC security group"
  vpc_id      = aws_vpc.default.id

  # SSH access from anywhere
  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = [
      "0.0.0.0/0"]
  }

  # HTTP access from anywhere
  ingress {
    from_port = 80
    to_port = 80
    protocol = "tcp"
    cidr_blocks = [
      "0.0.0.0/0"]
  }

  ingress {
    from_port = 8080
    to_port = 8080
    protocol = "tcp"
    cidr_blocks = [
      "0.0.0.0/0"]
  }

  # outbound internet access
  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = [
      "0.0.0.0/0"]
  }
}

resource "aws_key_pair" "bootcamp_user_pair" {
  key_name = "bootcamp_user_key"
  public_key = var.user_public_key
}

resource "aws_instance" "web" {
  connection {
    # The default username for our AMI
    user = "ubuntu"
    host = self.public_ip
    # The connection will use the local SSH agent for authentication.
  }

  ami = lookup(var.amis, var.region)
  instance_type = "t2.micro"
  tags = {
    Name = "bootcamp"
  }
  key_name = aws_key_pair.bootcamp_user_pair.id
  vpc_security_group_ids = [
    aws_security_group.bootcamp_security_group.id]
  subnet_id = aws_subnet.default.id

  provisioner "remote-exec" {
    inline = [
      "sudo apt-get -y update",
      "sudo apt-get -y install nginx",
      "sudo service nginx start",
      "sudo apt-get -y install openjdk-8-jre-headless",
    ]
  }
}