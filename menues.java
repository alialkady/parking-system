import java.util*;
public class menues(){

    public static void homeMenue(){
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Parking System Menu =====");
            System.out.println("1. Customer");
            System.out.println("2. Operator in Entry Station");
            System.out.println("3. Operator in Exit Station");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    entryStationOperatorMenu();
                    break;
                case 3:
                    exitStationOperatorMenu();
                    break;
                case 4:
                    if (adminLogin()) {
                        adminMenu();
                    } else {
                        System.out.println("Admin login failed. Access denied.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Parking System. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
    }
}