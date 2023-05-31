USE consentmanagement;

DROP TABLE IF EXISTS `Authorities`;
CREATE TABLE `Authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `Authorities` (`authority`) VALUES
  ('ROLE_DOCTOR'),
  ('ROLE_PATIENT'),
  ('profile_patient:read'),
  ('profile_patient:write'),
  ('profile_doctor:read'),
  ('profile_doctor:write'),
  ('records_doctor:read'),
  ('records_patient:read');

DROP TABLE IF EXISTS `Patient_Authorities`;
CREATE TABLE `Patient_Authorities` (
  `patient_meta_id` varchar(200) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`patient_meta_id`, `authorities_id`),
  FOREIGN KEY (`patient_meta_id`) REFERENCES `Patient` (`meta_id`),
  FOREIGN KEY (`authorities_id`) REFERENCES `Authorities` (`id`)
);
-- INSERT INTO `Patient_Authorities` VALUES
-- ('1234', 2),
-- ('3421', 2),
-- ('5422', 2),
-- ('8231', 2),
-- ('8989', 2),
-- ('1234', 4),
-- ('3421', 4),
-- ('5422', 4),
-- ('8231', 4),
-- ('8989', 4);


DROP TABLE IF EXISTS `Doctor_Authorities`;
CREATE TABLE `Doctor_Authorities` (
  `Doctor_meta_id` varchar(200) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Doctor_meta_id`, `authorities_id`),
  CONSTRAINT `fk_doctor_authorities_doctor` FOREIGN KEY (`Doctor_meta_id`) REFERENCES `Doctor` (`meta_id`),
  CONSTRAINT `fk_doctor_authorities_authorities` FOREIGN KEY (`authorities_id`) REFERENCES `Authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- INSERT INTO `Doctor_Authorities` (`Doctor_meta_id`, `authorities_id`) VALUES
--   ('1290', 1),
--   ('1290', 5),
--   ('1290', 6),
--   ('1290', 7),
--   ('5663', 1),
--   ('5892', 1),
--   ('6554', 1),
--   ('9669', 1),
--   ('9669', 7);
