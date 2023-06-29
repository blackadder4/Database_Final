DELETE FROM `cs331_project_task3`.`Equipment` WHERE `ID_Number` LIKE '266558660' ;

SELECT `ID_Number`
FROM `cs331_project_task3`.`Equipment`
WHERE `ID_Number` LIKE '266558660'; 


DELETE FROM `cs331_project_task3`.`Service` WHERE `ID_Number` LIKE '0794785041261926' ;

SELECT `ID_Number`
FROM `cs331_project_task3`.`Service`
WHERE `ID_Number` LIKE '0794785041261926'; 

DELETE FROM  `cs331_project_task3`.`Customer` WHERE `ID_Number` LIKE '2990204172786553' ; 

SELECT `ID_Number`
FROM `cs331_project_task3`.`Customer`
WHERE `ID_Number` LIKE '2990204172786553'; 

DELETE FROM `cs331_project_task3`.`Customer_has_ServiceProvided` WHERE `Customer_ID_Number` LIKE '6172041234232440' ;

SELECT `Customer_ID_Number`
FROM `cs331_project_task3`.`Customer_has_ServiceProvided`
WHERE `Customer_ID_Number` LIKE '6172041234232440';

DELETE FROM `cs331_project_task3`.`Employee` WHERE `ID_Number`LIKE '019145693' ; 

SELECT `ID_Number` 
FROM `cs331_project_task3`.`Employee`
WHERE `ID_Number` LIKE '019145693';

DELETE FROM `cs331_project_task3`.`mainSchedule` WHERE `Employee_ID_Number` LIKE '117663863' ; 

SELECT `Employee_ID_Number`
FROM `cs331_project_task3`.`mainSchedule` 
WHERE `Employee_ID_Number` LIKE '117663863'; 

