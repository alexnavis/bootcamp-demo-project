CREATE TABLE `project` 
	(`id` int(11) NOT NULL AUTO_INCREMENT, 
	`name` varchar(255) NOT NULL,
	`sector` varchar(255) NOT NULL,
	`start_date` date DEFAULT NULL,
	is_active boolean DEFAULT NULL,
	PRIMARY KEY (`id`));

-- V2__CreateSampleTable