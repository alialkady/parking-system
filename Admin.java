import java.util.*;

public class Admin {
    private String Username;
    private String Password;
    //Constructor for logging into the system
    public Admin(){
        // creating two strings to hold the entered login info
        String user ="";
        String pass ="";
        //Scanning the login info
        Scanner adminCheckScan = new Scanner(System.in);
        System.out.print("Username: ");
        user += adminCheckScan.nextLine();
        System.out.print("Password: ");
        pass += adminCheckScan.nextLine();
        //passing login info to the login check method
        file.adminCheck("Admin", user, pass);
    }

    // Constructor for add or signing up a new admin to the system
    public Admin(String user, String pass){
        Username = user;
        Password = pass;
        // Add new admin's info to the admins file
        file.appendFile("Admin", Username);
        file.appendFile("Admin", Password);
    }

    // Admin username setter
    public void setUsername(String user) {
        Username = user;
        Scanner userInputScanner = new Scanner(System.in);
        //Scan login info to edit them
        System.out.print("Enter the old username: ");
        String oldUsername = userInputScanner.nextLine();
        System.out.print("Enter the old password: ");
        String oldPassword = userInputScanner.nextLine();
        //passing login info to the edit file method
        file.editFile("Admin", oldUsername, oldPassword);
    }

    // Admin password setter
    public void setPassword(String password) {
        Password = password;
        Scanner userInputScanner = new Scanner(System.in);
        //Scan login info to edit them
        System.out.print("Enter the old username: ");
        String oldUsername = userInputScanner.nextLine();
        System.out.print("Enter the old password: ");
        String oldPassword = userInputScanner.nextLine();
        //passing login info to the edit file method
        file.editFile("Admin", oldUsername, oldPassword);
    }

    // Admin username getter
    public String getUsername() {
        return Username;
    }

    // Admin password getter
    private String getPassword() {
        return Password;
    }

    //Admin add spots to the parking area
    public String addSpots(int spotId){
        database_handle.insertSpot(spotId, "free");
        return "spot added successfully";
    }

    //Admin view total spots in the parking area
    public void viewTotalSpots(){
        database_handle.retrieveData("spots");

    }

    // Admin add customer
    public String addCustomer(String entry_id,String plate_number){
        database_handle.insertCustomerData(entry_id,plate_number);
        return "added successfully";
    }
    //admin add operator
    public String addOperator(String name, String pass,int shift){
        database_handle.insertOperatorData(name,pass,shift);
        return "added successfully";
    }
    //admin update user_id
    public String updateUser(int id,int newID){
        database_handle.updateCustomerId(id,newID);
        return "Updated successfully";
    }
    //admin update operator_name
    public String updateOperatorName(String oldName,String newName){
        database_handle.updateOperatorUser(oldName,newName);
        return "Updated successfully";
    }
    //admin update operator_password
    public String updateOperatorPass(String oldPass,String newPass){
        database_handle.updateOperatorPass(oldPass,newPass);
        return "Updated successfully";
    }
    //admin update shiftPayment
    public String updatePayment(int shift, double payment){
        database_handle.updatePayment(shift,payment);
        return "Updated successfully" ;
    }
    //admin delete customerData
    public String deleteCustomer(int entry_id){
        database_handle.deleteCustomerData(entry_id);
        return "Deleted successfully";
    }
    //admin delete OperatorData
    public String deleteOperator(String name){
        database_handle.deleteOperatorData(name);
        return "deleted successfully";
    }
}
