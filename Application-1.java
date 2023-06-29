import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    @SuppressWarnings("unused")
    public static void main(String args[]) throws SQLException {

        //TODO: once connection is established a user needs to sign in
        Connection conn = null;
        try {
            //Step 1: Load the JDBC driver(You have to have the connector Jar file in your project Class path)
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connect to the database(Change the URL)
            //Everything before ?server is where you paste your DB URL
            String url = "jdbc:mysql://127.0.0.1:3306/cs331_project_task3?serverTimezone=UTC&useSSL=TRUE";
            //Can ask for credentials but I (Jenny) just put in my own username and password for Mysql
            String user, pass;
            /*user = "student";
            pass = "password";
            */

            //Accepts inputed UserID and Password
            user = readEntry("UserID: ");
            pass = readEntry("Password: ");

            //Connecting to the DB with my info
            conn = DriverManager.getConnection(url, user, pass);

            //Prints out if connection is successful
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());

                mainMenu();
                mainMenuSwitchCase(conn);
            } else {
                System.out.println("Couldn't connect to server");
            }

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Could not load the driver");
        }


    }//Jenny

    static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }

    private static void mainMenu() {
        System.out.println("*****************************************************************************");
        String h = "Welcome to Clean-and-Go Shop \n";
        String option1 = "1. Equipment and Supplies \n";
        String option2 = "2. Customers and Services \n";
        String option3 = "3. Employees \n";
        String option4 = "4. Update \n";
        String option5 = "5. quit \n";
        System.out.printf("%50s", h);
        System.out.println("*****************************************************************************");
        System.out.printf("%50s", option1);


        System.out.printf("%50s", option2);


        System.out.printf("%40s", option3);


        System.out.printf("%40s", option4);

        System.out.printf("%40s", option5);

    }//Dayna

    private static void option1Menu(Connection conn) {
    }

    private static void option1Analyze(Connection conn) {
        System.out.println("******************************************************************************");
        String h = "Welcome to Clean-and-Go Shop\n";
        String s = "1. Analyze the progress of the business \n";
        System.out.printf("%50s", h);
        System.out.printf("%50s", "\033[0;1s" + s);
        System.out.println("******************************************************************************");
        System.out.printf("%50s", "A. Total number of new customers\n");
        System.out.printf("%50s", "B. Total number of service transactions\n");
        System.out.printf("%40s", "Q. Quit\n");
    }

    private static void option2Menu(Connection conn) {
        System.out.println("******************************************************************************");
        String h = "Welcome to Clean-and-Go Shop\n";
        String s = "2. Customers & Services\n";
        System.out.printf("%50s", h);
        System.out.printf("%50s", "\033[0;1s" + s);
        System.out.println("******************************************************************************");
        System.out.printf("%50s", "1. Analyze the progress of the business\n");
        System.out.printf("%50s", "2. Services\n");
        System.out.printf("%60s", "3. Customers\n");
        System.out.printf("%40s", "4. quit\n");
    }
    private static void option2MenuForService(Connection conn) {
        System.out.println("******************************************************************************");
        String h = "Welcome to Clean-and-Go Shop\n";
        String s = "2. Services\n";
        System.out.printf("%50s", h);
        System.out.printf("%50s", "\033[0;1s" + s);
        System.out.println("******************************************************************************");
        System.out.printf("%50s", "A. Requested services\n");
        System.out.printf("%50s", "B. Service transactions\n");
        System.out.printf("%60s", "C. Annual revenues from services\n");
        System.out.printf("%40s", "4. quit\n");
    }

    private static void option3MenuForCustomers(Connection conn) {
        System.out.println("******************************************************************************");
        String h = "Welcome to Clean-and-Go Shop\n";
        String s = "3. Customers\n";
        System.out.printf("%50s", h);
        System.out.printf("%50s", "\033[0;1s" + s);
        System.out.println("******************************************************************************");
        System.out.printf("%50s", "A. Customer list for a service\n");
        System.out.printf("%50s", "B. Customer number\n");
        System.out.printf("%40s", "4. quit\n");
    }


    private static void option3Menu(Connection conn) { }

    private static void option4Menu(Connection conn) {
        System.out.println("*****************************************************************************");
        String h = "Welcome to Clean-and-Go Shop \n";
        String m = "4. Update \n";
        System.out.printf("%50s", h);
        System.out.printf("%50s", "\033[0;1m" + m);
        System.out.println("******************************************************************************");
        System.out.printf("%50s", "1. Delete service\n");
        System.out.printf("%50s", "2. Delete equipment\n");
        System.out.printf("%60s", "3. Delete customer information\n");
        System.out.printf("%55s", "4. Delete employee information\n");
        System.out.printf("%40s", "q. quit\n");

    }//Leo

    private static void mainMenuSwitchCase(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an option from the menu or q for Quit:  ");
        String choice = reader.readLine();

        boolean done = false;
        switch (choice.charAt(0)) {
            case '1':
                option1Menu(conn);
                break;
            case '2':
                option2Menu(conn);
                option2SwitchCase(conn);
                break;
            case '3':
                employeeSchedule(conn);
                option3Menu(conn);
                break;
            case '4':
                option4Menu(conn);
                option4SwitchCase(conn);
                break;
            case 'q':
                done = true;
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }

    private static void option3SwitchCase(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Choose one of the ID's to view their schedule or 4 for quit:  ");
        String choice = reader.readLine();

        boolean done = false;
        switch (choice.charAt(0)) {
            case '3':
                employeeSchedule(conn);
                break;
            case 'Q':
            case 'q':
                mainMenu();
                mainMenuSwitchCase(conn);
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }

    private static void option1SwitchCase(Connection conn) throws IOException, SQLException {
        //TODO needs user input and connection to DB

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an option from the menu or q for Quit:  ");
        String choice = reader.readLine();


        boolean done = false;
        switch (choice.charAt(0)) {
            case 'A':
                option1Menu(conn);
                //add (Total number of new customers):
                break;
            case 'B':
                option2Menu(conn);
                //add (Total number of service transactions)
                break;
            case 'Q':
                mainMenu();
                mainMenuSwitchCase(conn);
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }

    private static void option2SwitchCase(Connection conn) throws IOException, SQLException {
        //TODO needs user input and connection to DB

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an option from the menu or q for Quit:  ");
        String choice = reader.readLine();

        boolean done = false;
        switch (choice.charAt(0)) {
            case '1':
                option1Analyze(conn);
                analyze_business(conn);
                break;
            case '2':
                option2Menu(conn);
                option2MenuForService(conn);
                option2InsideService(conn);
                break;
            case '3':
                option3Menu(conn);
                option3MenuForCustomers(conn);
                option2InsideCustomers(conn);
                break;
            case '4':
                option2Menu(conn);
                mainMenuSwitchCase(conn);
                mainMenu();
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }
    private static void option2InsideCustomers(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an option from the menu or 4 to return to Menu: ");
        String choice = reader.readLine();
        boolean done = false;

        switch (choice.charAt(0)) {
            case 'A':
            case 'a':
                option1Menu(conn);
                customerListForAService(conn);
                break;
            case 'B':
            case 'b':
                option2Menu(conn);
                customerNumber(conn);
                break;
            case '4':
                mainMenu();
                mainMenuSwitchCase(conn);
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }

    private static void option2InsideService(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an option from the menu or 4 to return to Menu: ");
        String choice = reader.readLine();
        boolean done = false;

        switch (choice.charAt(0)) {
            case 'A':
            case 'a':
                option1Menu(conn);
                requestedService(conn);
                break;
            case 'B':
            case 'b':
                option2Menu(conn);
                serviceTransaction(conn);
                break;
            case 'C':
            case 'c':
                option3Menu(conn);
                annualRevenuesFromServices(conn);
                break;
            case '4':
                option2Menu(conn);
                mainMenuSwitchCase(conn);
                mainMenu();
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }

    public static void analyze_business(Connection conn) throws SQLException, IOException{ // Leo, In progress
        boolean done = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Type in your option: ");
        do {
            System.out.flush();
            String ch = reader.readLine();
            System.out.println();
            switch (ch.charAt(0)) {
                case 'A':
                case 'a':
                    new_customers(conn); // function for new customer
                    done = true;
                    break;
                case 'B':
                case 'b':
                    number_service_transactions(conn);  // function for number of service tran
                    done = true;
                    break;
                case 'Q':
                case 'q':
                    done = true;
                    mainMenuSwitchCase(conn);
                    mainMenu();
                    break;
                default:
                    System.out.println(" Not a valid option ");
            } //switch
        } while (!done);
    }

    public static void number_service_transactions(Connection conn) throws SQLException, IOException{
        if(conn == null){
            System.out.println("server issue");
        }
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT COUNT(service_ID) FROM ServiceProvided WHERE date BETWEEN '2021-11-30' AND '2021-12-31';");
        while(rset.next()){
            System.out.println("\n Dec_Service : \n ");
            System.out.println(rset.getDouble(1));//number of customer
        }
    }


    private static void option4SwitchCase(Connection conn) throws IOException, SQLException {
        //TODO needs user input and connection to DB

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an option from the menu or q for Quit:  ");
        String choice = reader.readLine();


        boolean done = false;
        switch (choice.charAt(0)) {
            case '1':
                option1Menu(conn);
                showService(conn);
                break;
            case '2':
                option2Menu(conn);
                showEquipment(conn);
                break;
            case '3':
                option3Menu(conn);
                showCustomer(conn);
                break;
            case '4':
                option4Menu(conn);
                showEmployee(conn);
                break;
            case 'q':
                done = true;
                break;
            default:
                System.out.println(" Not a valid option ");
        }
    }


    private static void showEquipment(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String listEquipID = "SELECT Equipment.ID_number FROM Equipment ";
        ResultSet rset = stmt.executeQuery(listEquipID);

        while (rset.next()) {
            String id = rset.getString(1);

            System.out.println(id);
        }

        System.out.println("*************************************************************");

        System.out.print("Enter an equipment ID for deletion:  ");
        String choice = reader.readLine();

        deleteEquipment(choice, conn);
    }

    private static void showService(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String listEquipID = "SELECT Service.ID_number FROM Service ";
        ResultSet rset = stmt.executeQuery(listEquipID);

        while (rset.next()) {
            String id = rset.getString(1);

            System.out.println(id);
        }

        System.out.println("*************************************************************");

        System.out.print("Enter a Service ID for deletion:  ");
        String choice = reader.readLine();

        deleteService(choice, conn);
    }

    private static void showCustomer(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String listEquipID = "SELECT Customer.ID_number FROM Customer ";
        ResultSet rset = stmt.executeQuery(listEquipID);

        while (rset.next()) {
            String id = rset.getString(1);

            System.out.println(id);
        }

        System.out.println("*************************************************************");

        System.out.print("Enter an Customer ID for deletion:  ");
        String choice = reader.readLine();

        deleteCustomer(choice, conn);
    }

    private static void showEmployee(Connection conn) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String listEquipID = "SELECT Employee.ID_number FROM Employee ";
        ResultSet rset = stmt.executeQuery(listEquipID);

        while (rset.next()) {
            String id = rset.getString(1);

            System.out.println(id);
        }

        System.out.println("*************************************************************");

        System.out.print("Enter an equipment ID for deletion:  ");
        String choice = reader.readLine();

        deleteEmployee(choice, conn);
    }

    /* creates a statement that is null
     * a new string that deletes an ID from Equipment
     * and updates the string delEquip
     * print "Deleted Successfully"
     * prints out the list of Equipment ID's after deletion
     */
    private static void deleteEquipment(String equipID, Connection conn) throws SQLException, IOException {
        Statement stmt = null;
        stmt = conn.createStatement();

        String delEquip = "delete from Equipment " + "where Equipment.ID_number = " + equipID;
        stmt.executeUpdate(delEquip);
        System.out.println("Deleted Successfully");
        showEquipment(conn);
    }

    /* creates a statement that is null
     * a new string that deletes an ID from Service
     * and updates the string delServ
     * print "Deleted Successfully"
     * prints out the list of service ID's after deletion
     */
    private static void deleteService(String servID, Connection conn) throws SQLException, IOException {
        Statement stmt = null;
        stmt = conn.createStatement();

        String delServ = "delete from Service " + "where Service.ID_number = " + servID;
        stmt.executeUpdate(delServ);
        System.out.println("Deleted Successfully");
        showService(conn);
    }

    /* creates a statement that is null
     * a new string that deletes an ID from Customer
     * and updates the string delCus
     * print "Deleted Successfully"
     * prints out the list of Customer ID's after deletion
     */
    private static void deleteCustomer(String custID, Connection conn) throws SQLException, IOException {
        Statement stmt = null;
        stmt = conn.createStatement();

        String delCus = "delete from Customer " + "where Customer.ID_number = " + custID;
        stmt.executeUpdate(delCus);
        System.out.println("Deleted Successfully");
        showCustomer(conn);

    }

    /* creates a statement that is null
     * a new string that deletes an ID from Employee
     * and updates the string delEmp
     * print "Deleted Successfully"
     * prints out the list of Employee ID's after deletion
     */
    private static void deleteEmployee(String EmpID, Connection conn) throws SQLException, IOException {
        Statement stmt = null;
        stmt = conn.createStatement();

        String delEmp = "delete from Employee " + "where Employee.ID_number = " + EmpID;
        stmt.executeUpdate(delEmp);
        System.out.println("Deleted Successfully");
        showEmployee(conn);
    }

    /*--------------------------------------------SECOND SCENARIO---------------------------------------------------- */
    /*--------------------------------------------NUMBER ONE--------------------------------------------------------- */
    private static void new_customers(Connection conn) throws SQLException, IOException{  // Leo not tested
        if(conn == null){
            System.out.println("server issue");
        }
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT COUNT(ID_Number) FROM Customer WHERE Joined_date BETWEEN '2020-12-31' AND '2022-01-01';");
        while(rset.next()){
            System.out.println("\n New Customer : \n ");
            System.out.println(rset.getDouble(1));//number of customer
        }
    }

    private static void totalNumberOfServiceTransaction(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt;
        stmt = conn.createStatement();

        String qr = "";
        PreparedStatement ps = conn.prepareStatement(qr);

        ps.clearParameters();

        ResultSet rs = ps.executeQuery();

        System.out.println("Most request service type: \n");
        System.out.println("----------------------------------------------------------");

        while (rs.next()) {
            String name = rs.getString(1);
            int count = rs.getInt(2);
            System.out.println(name + " " + count);
        }
        stmt.close();
    }

    /*--------------------------------------------NUMBER TWO--------------------------------------------------------- */
    private static void requestedService(Connection conn) throws SQLException, IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Statement stmt = null;
            stmt = conn.createStatement();

            String qr = "SELECT service_ID, count(service_ID) FROM ServiceProvided GROUP by service_ID;";
            PreparedStatement stm = conn.prepareStatement(qr);
            ResultSet res = stm.executeQuery();
            res.next();
            String c = res.getString(1);

            String q2 = " SELECT name FROM Service WHERE ID_Number = " + c;

            PreparedStatement mf = conn.prepareStatement(q2);
            ResultSet F = mf.executeQuery();
            F.next();
            System.out.println("requestedService: \n" + F.getString(1));
            stmt.close();
        }

    private static void serviceTransaction(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String qr = "SELECT Month,SUM(amountCharged) FROM ServiceProvided group by Month";
        PreparedStatement stm = conn.prepareStatement(qr);
        ResultSet res = stm.executeQuery();

        int B = 0;
        while (res.next()) {
            int c = res.getInt(1);
            int m = res.getInt(2);
            System.out.println(c + " " + m);
        }
        stmt.close();
    }

    private static void annualRevenuesFromServices(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String qr = "SELECT name,SUM(amountCharged) FROM ServiceProvided p JOIN Service s ON p.service_ID = s.ID_Number  group by p.service_ID";
        PreparedStatement ps = conn.prepareStatement(qr);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Float am = rs.getFloat(2);
            String na = rs.getString(1);
            System.out.println("Service Name : " + na + '\n');
            System.out.println("Total revenue: " + am + '\n');
        }
        stmt.close();
    }

    /*--------------------------------------------NUMBER THREE--------------------------------------------------------- */
    //option 3, A
    private static void customerListForAService(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt;
        stmt = conn.createStatement();
        String qr = "SELECT DISTINCT service_ID FROM ServiceProvided";
        ResultSet rset = stmt.executeQuery(qr);

        while (rset.next()) {
            String id = rset.getString(1);
            System.out.println(id);
        }

        System.out.println("Please Choose one of the above ID's: ");
        String choice = reader.readLine();
        String query = "SELECT * FROM Customer c JOIN ServiceProvided s ON s.customer_ID = c.ID_Number WHERE service_ID = " + choice;


        PreparedStatement ps = conn.prepareStatement(query);

        ps.clearParameters();


        ResultSet rs = ps.executeQuery();

        System.out.println("Customer List For the Service: \n");


        while (rs.next()) {
            String cusName = rs.getString(2);
            System.out.println(cusName);
        }


    }

    //option 3, B
    //need query, add to menu and print statement
    private static void customerNumber(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Statement stmt;
        stmt = conn.createStatement();

        String qr = "SELECT MONTH(Joined_date) AS Month_, name FROM Customer";

        PreparedStatement ps = conn.prepareStatement(qr);
        ps.clearParameters();

        ResultSet r = ps.executeQuery();

        while (r.next()) {
            int count = r.getInt(1);
            String month = r.getString(2);

            System.out.println(count + " " + month);
        }
        stmt.close();
    }

    /*--------------------------------------------THIRD SCENARIO---------------------------------------------------- */

    private static void employeeSchedule(Connection conn) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Statement stmt = null;
        stmt = conn.createStatement();

        String listEmpID = "SELECT ID_Number FROM Employee ";
        ResultSet rset = stmt.executeQuery(listEmpID);

        while (rset.next()) {
            String id = rset.getString(1);
            System.out.println(id);
        }

        System.out.println("*************************************************************");

        System.out.print("Enter an employee ID to view their schedule:  ");
        String choice = reader.readLine();
        Statement smt = null;
        smt = conn.createStatement();

        String reqSchedule = "SELECT startTime,endTime FROM schedule WHERE ID_Number = " + choice;
        ResultSet r = smt.executeQuery(reqSchedule);
        if(r.next() == false){
            System.out.println("Schedule is empty");
        }
        while (r.next()) {
             String s_Schedule = r.getString(1);
             String e_Schedule = r.getString(2);
             System.out.println("Start :" + s_Schedule + "\n" );
             System.out.println("END :" + e_Schedule + '\n');
        }
    }

}