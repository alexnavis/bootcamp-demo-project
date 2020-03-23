#ssh ubuntu@3.230.118.77 -i ~/.ssh/bootcamp_rsa "rm /home/ubuntu/demo_project-0.0.1-SNAPSHOT.jar"
#scp -i ~/.ssh/bootcamp_rsa ../build/libs/demo_project-0.0.1-SNAPSHOT.jar ubuntu@3.230.118.77:/home/ubuntu/
ssh ubuntu@3.230.118.77 -i ~/.ssh/bootcamp_rsa "echo Kill existing process.. && killall -9 java"
ssh ubuntu@3.230.118.77 -i ~/.ssh/bootcamp_rsa "SPRING_PROFILES_ACTIVE=prod nohup java -jar demo_project-0.0.1-SNAPSHOT.jar > nohup.out &"
ssh ubuntu@3.230.118.77 -i ~/.ssh/bootcamp_rsa "cat nohup.out"