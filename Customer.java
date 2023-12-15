public class Customer{
    public String CallingOperator(String platenumber){
        Operator operator=new Operator();
        operator.generateEntryID(platenumber);
        operator.assignedSlot(platenumber);
        return operator.entryTicket(platenumber);
    }
}