INSERT INTO `cs331_project_task3`.`CleaningSupply`(`name`,`descriptionOfUsage` ,`currentInventory` ,`safetyStockLevel`)
VALUES
("mop", "used to wipe away liquid on the surfaces", 10, 5),
("bleach", "basic chemical used to remove color from fabric or to clean stains", 20, 5),
("Windex", "an American brand of glass and hard-surface cleaner", 20 , 10),
("brush", "a common tool with bristles, wire or other filaments.", 10 , 5),
("Broom", "a cleaning tool consisting of usually stiff fibers ", 10, 5),
("Glove", "a garment covering the hand.", 20 , 20),
("Baking Soda", "a chemical compound used for cleaning", 10, 15);

INSERT INTO `cs331_project_task3`.`Customer`( `ID_Number`,`name`,`address`,`email`,`telephoneNumber`,`creditCardInfo`,`currentBalance`,`Joined_date`)
VALUES
("2990204172786553", "Ginger J Farmer", "3151 Goodwin Avenue, Richland WA 99352", "bhknkikdsaq@temporary-mail.net", "509-373-2683", "MasterCard: 5256787269958551", 320.00,"2021-12-01"),
("3132768449811804", "Eric B Gentry", "472 Elliot Avenue, Seattle WA 98015", "7av3527l8ze@temporary-mail.net", "206-598-3338", "Visa: 4916198771234389", 0.00,"2021-01-03"),
("6172041234232440", "Edmundo D Fletcher", "4353 Sun Valley Road, Kennewick WA 99336", "vn6kj0hs78t@temporary-mail.net", "509-735-1806", "Visa: 4556235484169018", 250.00,"2021-11-03"),
("3208688665553773", "Natalia R Cusumano", "1763 Mutton Town Road, Vancouver WA 98663", "i3vfxtsthlp@temporary-mail.net", "360-693-9193", "MasterCard: 5511390805916232", 300.00,"2021-06-29"),
("6400374551165279", "Christi D Fouche", "2573 Melrose Street, Spokane Valley WA 99206", "jq9v92mnrpk@temporary-mail.net", "509-944-6225", "AmericanExpress: 4916067369444496", 250.00,"2020-12-01"),
("1355627094162777", "Hattie K Harold", "1397 Mutton Town Road, longview WA 98632", "vd6yeitwdi@temporary-mail.net", "360-636-9661", "Visa: 4485359965948975", 1000.00,"2021-08-09"),
("8232302576338099", "Randy V Terrazas", "3145 Elliot Avenue, Seattle WA 98101", "4i4zxcwmayh@temporary-mail.net", "206-623-8521", "MasterCard: 5544396239848363", 0.00,"2021-09-30");

INSERT INTO `cs331_project_task3`.`ServiceProvided`  (`customer_ID`,`service_ID`,`employee_ID`,`date`,`amountCharged`,`description`,`satisfaction`,`Month`)
VALUES
("2990204172786553", "0794785041261926", "413429585", "2020-06-09", "160.00", "Ginger J Farmer got ", "4/5","7"),
("3132768449811804", "0794785041261926", "098385769", "2020-04-08", "160.00", "Eric B Gentry got Night_General_Clean", "4/5","7"),
("8232302576338099", "0794785041261926", "597306361", "2020-02-10", "160.00", "Randy V Terrazas got Night_General_Clean", "4/5","8"),
("6172041234232440", "4239568513702589", "098385769", "2020-02-09", "600.00", "Edmundo D Fletcher got Deep_Clean", "3/5","9"),
("2990204172786553", "8081391425423787", "413429585", "2020-12-10", "120.00", "Ginger J Farmer got Day_General_Clean", "4/5","10"),
("8232302576338099", "2880238554131920", "413429585", "2021-04-09", "750.00", "Randy V Terrazas got Floor_Clean", "5/5","11"),
("6172041234232440", "2483493537084313", "413429585", "2021-08-16", "300.00", "Edmundo D Fletcher got Carpet_Clean", "3/5","12");

INSERT INTO `cs331_project_task3`.`Employee`(`ID_Number`,`name`,`address`,`gender`,`dateOfEmployment`,`positionHiredFor`,`schedule`)
VALUES
("019145693", "Travis C Noble", "2206 Stockert Hollow Road, Kirkland WA 98033", "male", "2020-01-01", "founder", "schedule"),
("117663863", "Kelly L Olson", "2702 Mudlick Road, Leavenworth WA 98826", "female", "2020-09-24", "reception", "schedule"),
("098385769", "John J Ryerson", "223 Pinnickinick Street, Enumclaw WA 98022", "male", "2020-08-10", "associate", "schedule"),
("310880576", "Mimi J Muse", "3067 Hazelwood Avenue, AUBURN WA 98001", "female", "2020-08-10", "manager", "schedule"),
("597306361", "Lydia D Falk", "2795 Dale Avenue, Tukwila WA 98188", "female", "2020-02-01", "associate", "schedule"),
("004135982", "Rosemary J Pollack", "4797 Sunrise Road, AUBURN WA 98001", "female", "2020-01-01", "co-founder", "schedule"),
("413429585", "Joseph T McDonald", "1953 Pooh Bear Lane, AUBURN WA 98001", "male", "2020-01-01", "associate", "schedule");

INSERT INTO `cs331_project_task3`.`Equipment`(  `ID_Number`,`brandName`,`purchaseDate`,`purchasePrice`,`type`)
VALUES 
("159486990", "Dyson", "2020-11-09", 599.99, "Portable vacuum"),
("266558660", "LG", "2021-01-04", 599.99, "Portable vacuum"),
("931883022", "Samsung", "2021-05-04", 299.99, "Floor polisher"),
("302444114", "GE", "2021-08-24", 449.99, "Carpet washer"),
("276981375", "LG", "2021-05-24" , 1199.99, "Pressure washer"),
("353131609", "GE", "2021-11-30" , 999.99, "Plug in vacuum"),
("604361465", "GE", "2021-11-30" , 599.99, "Vapor cleaner");

SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `cs331_project_task3`.`schedule`(  `day`,`startTime`,`endTime`,`ID_Number`)
VALUES
("2021-12-12", "00:47:02", "05:30:00", "098385769"),
("2021-12-05", "06:20:20", "00:00:00", "597306361"),
("2021-12-24", "18:46:55", "20:30:00", "310880576"),
("2021-12-08", "18:42:33", "00:00:00", "117663863"),
("2021-12-09", "01:42:47", "10:30:00", "098385769"),
("2021-11-30", "11:36:12", "20:30:00", "597306361"),
("2021-12-20", "11:30:50", "00:00:00", "597306361");

SET FOREIGN_KEY_CHECKS=1;

INSERT INTO `cs331_project_task3`.`Service`(`ID_Number`,`name`,`description`,`rateCharged`,`duration`)
VALUES 
("0794785041261926", "Night_General_Clean", "General cleaning after 18:00", "80/hr", "2"),
("8081391425423787", "Day_General_Clean", "General cleaning before 18:00", "40/hr", "3"),
("4239568513702589", "Deep_Clean", "thorough cleaning", "100/hr", "6"), 
("2181848796492252", "Combo_Clean", "Steam and Deep_Clean","200/hr", "10"), 
("2483493537084313", "Carpet_Clean", "Wash,Clean and vacuum carpet", "100/hr", "3"),
("7462672656824805", "Window_Clean", "clean all window", "50/hr", "2"), 
("2880238554131920", "Floor_Clean", "pressure wash outside floor", "150/hr", "5");

INSERT INTO `cs331_project_task3`.`supplierTransaction`(`ID_Number`,`date`,`itemPurchased`,`quantityPurchased`,`amountDue`,`dueDate`,`description`,`deliveryDate`)
VALUES 
("0509312426406003", "2020-04-11", "mop", 10 , 129.80, "2020-04-12", "mop fully delivered", "2020-04-12"),
("8242914204084319", "2020-06-10", "bleach", 30, 185.70, "2020-06-11", "bleach fully delivered", "2020-06-11"),
("7658592222894933", "2020-08-04", "Vapor Cleaner", 1, 139.99, "2020-08-04", "Vapor Cleaner fully delivered", "2020-08-04"),
("1954860298638201", "2020-08-04", "brush", 15, 59.85, "2020-08-10", "brush partial delivered", "2021-12-20"),
("4892376170010952", "2021-05-24", "Broom", 10, 109.90, "2021-05-26", "Broom fully delivered", "2021-05-26"),
("6727135296421522", "2021-07-01", "Glove", 30, 53.70, "2021-08-01", "Glove fully delivered", "2021-08-01"),
("7115997061269126", "2021-11-15", "Baking Soda", 50, 49.50, "2021-11-15", "Baking Soda fully delivered", "2021-11-15");