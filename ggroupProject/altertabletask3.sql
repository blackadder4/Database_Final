ALTER TABLE `cs331_project_task3`.`supplierTransaction`
DROP COLUMN AmountDue;

ALTER TABLE `cs331_project_task3`.`supplierTransaction`
ADD AmountDue float;

ALTER TABLE `cs331_project_task3`.`ServiceProvided`
ADD CONSTRAINT `employee_ID` FOREIGN KEY (`employee_ID`) 
REFERENCES `cs331_project_task3`.`Employee`(`ID_Number`) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE `cs331_project_task3`.`schedule`
ADD CONSTRAINT `ID_Number` FOREIGN KEY (`ID_Number`) 
REFERENCES `cs331_project_task3`.`Employee`(`ID_Number`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `cs331_project_task3`.`Customer_has_ServiceProvided`
ADD CONSTRAINT `ServiceProvided_employee_ID` FOREIGN KEY (`ServiceProvided_employee_ID`) 
REFERENCES `cs331_project_task3`.`Employee`(`ID_Number`) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE `cs331_project_task3`.`mainSchedule`
ADD CONSTRAINT `Employee_ID_Number` FOREIGN KEY (`Employee_ID_Number`) 
REFERENCES `cs331_project_task3`.`Employee`(`ID_Number`) ON UPDATE CASCADE ON DELETE CASCADE;