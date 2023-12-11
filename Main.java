public class Main {
    public static void main(String[] args){
        // Create a new instance of the class 'Main'
        Operator freeSpots=new Operator();
        String slot= freeSpots.displayFreeSpots();
        System.out.println("Number of Free Spots: "+ slot);
    }
}
