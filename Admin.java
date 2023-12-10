public class Admin {

    public void  add_operator(String name,String pass,int shift) {

        database_handle.insertOperatorData(name,pass,shift); // we need to modify into database handle file the parameters

    }
    public void  add_customer(int entry_id,int plate_number,String transaction_date){
        database_handle.insertCustomerData(entry_id,plate_number,transaction_date);
    }
    public void addSpot(int spot, String spot_free){
        database_handle.insertSpot(spot,spot_free);
    }
    public void retrievePayment(String table){
        database_handle.retrieveData(table);
    }
}
