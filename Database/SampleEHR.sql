--
-- Table structure for table `Doctor`
--
CREATE DATABASE consentmanagement;
Use consentmanagement;

DROP TABLE IF EXISTS `Doctor`;
CREATE TABLE `Doctor` (
  `meta_id` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `specialization` VARCHAR(255),
  `doctor_license` VARCHAR(255) NOT NULL,
  `doctor_image` VARCHAR(255),
  `password` VARCHAR(255),
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Doctor`
--

INSERT INTO `Doctor` VALUES (1290,'rajev12@yahoo.co.in','Male','Rajeev','8843922129','','#DC7865','',''),(5663,'arun@yahoo.com','Male','Arun','5485932012','','#DC7865','',''),(5892,'ram231@gmail.com','Male','Ramesh','9002100210','','#DC7865','',''),(6554,'bharathy@gmail.com','Female','Bharathy','6784392112','','#DC7865','',''),(9669,'lok@gmail.com','Male','Lokesh','4354352222','','#DC7865','','');

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
CREATE TABLE `Patient` (
  `meta_id` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `patient_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `abha_id` varchar(100) DEFAULT NULL,
  `patient_image` text DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
);

--
-- Dumping data for table `Patient`
--
INSERT INTO `Patient` VALUES (1234,'mudit@gmail.com','Male','Mudit','8574932920', '70424638979356', '', ''),(3421,'arpita@yahoo.com','Female','Arpitha','6429482291', '70424638979356', '', ''),(5422,'saxsy@gmail.com','Male','Saksham','9545323431', '70424638979356', '', ''),(8231,'mrinal@yahoo.co.in','Male','Mrinal','8493238493', '70424638979356', '', ''),(8989,'jan@gmail.com','Female','Janvi','7433232398', '70424638979356', '', '');
--
-- Table structure for table `records`
--

CREATE DATABASE narayana_hospital_db;
USE narayana_hospital_db;

DROP TABLE IF EXISTS `EHealth_Records`;
CREATE TABLE `EHealth_Records` (
  `ehr_id` int NOT NULL,
  `abha_id` VARCHAR(255) NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `prescription` varchar(200) DEFAULT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `patient_phone` varchar(10) NOT NULL,
  `doctor_license` VARCHAR(255),
  `date` DATE,
  PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `EHealth_Records` VALUES (1,'70424638979356','Narayana Hospital','Mudit','Arun','Nexium','Ulcer','8574932920','#DC7865','2022-09-07'),(2,'70424638979356','Narayana Hospital','Nachiappan','Arun','Amoxicillin','Dental abscesses','9658492942','#DC7865','2022-09-07'),(3,'70424638979356','Narayana Hospital','Saksham','Bharathy','Dolo','Fever','9545323431','#DC7865','2022-09-07'),(4,'70424638979356','Narayana Hospital','Mudit','Bharathy','Nexium','Heartburn','8574932920','#DC7865','2022-09-07');

CREATE DATABASE fortis_hospital_db;
USE fortis_hospital_db;

DROP TABLE IF EXISTS `EHealth_Records`;
CREATE TABLE `EHealth_Records` (
    `ehr_id` int NOT NULL,
    `abha_id` VARCHAR(255) NOT NULL,
    `hospital_name` varchar(100) NOT NULL,
    `patient_name` varchar(100) NOT NULL,
    `doctor_name` varchar(100) NOT NULL,
    `prescription` varchar(200) DEFAULT NULL,
    `diagnosis` varchar(200) DEFAULT NULL,
    `patient_phone` varchar(10) NOT NULL,
    `doctor_license` VARCHAR(255),
    `date` DATE,
    PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `EHealth_Records` VALUES (5,'70424638979356','Fortis Hospital','Mudit','Rahul','Nexium','Ulcer','8574932920','#DC7865','2022-09-07'),(6,'70424638979356','Fortis Hospital','Saksham','Rahul','Metformin','Diabetics','9545323431','#DC7865','2022-09-07'),(7,'70424638979356','Fortis Hospital','Mudit','Lokesh','Crestor','Cholestrol','8574932920','#DC7865','2022-09-07'),(8,'70424638979356','Fortis Hospital','Asilata','Lokesh','Nexium','Gastric Trouble','6837921994','#DC7865','2022-09-07'),(9,'70424638979356','Fortis Hospital','Pankaj','Lokesh','Metformin','Diabetics','7388532932','#DC7865','2022-09-07');


CREATE DATABASE kavery_hospital_db;
USE kavery_hospital_db;

DROP TABLE IF EXISTS `EHealth_Records`;
CREATE TABLE `EHealth_Records` (
    `ehr_id` int NOT NULL,
    `abha_id` VARCHAR(255) NOT NULL,
    `hospital_name` varchar(100) NOT NULL,
    `patient_name` varchar(100) NOT NULL,
    `doctor_name` varchar(100) NOT NULL,
    `prescription` varchar(200) DEFAULT NULL,
    `diagnosis` varchar(200) DEFAULT NULL,
    `patient_phone` varchar(10) NOT NULL,
    `doctor_license` VARCHAR(255),
    `date` DATE,
    PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `EHealth_Records` VALUES (10,'70424638979356','Kavery Hospital','Janvi','Ramesh','Dolo','Body Pain','7433232398','#DC7865','2022-09-07'),(11,'70424638979356','Kavery Hospital','Mrinal','Ramesh','Crestor','Cholestrol','8493238493','#DC7865','2022-09-07'),(12,'70424638979356','Apollo Hospital','Omkar','Renjith','Robafen','Common Cold','6648292221','#DC7865','2022-09-07'),(13,'70424638979356','Kavery Hospital','Sriram','Ramesh','Robafen','Bronchitis','9992332999','#DC7865','2022-09-07');
