import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz jedną z poniższych opcji");
            System.out.println("1. Dodawanie transakcji");
            System.out.println("2. Modyfikacja transakcji");
            System.out.println("3. Usuwanie transakcji");
            System.out.println("4. Wyświetanie wszystkich przychodów");
            System.out.println("5. Wyświetanie wszystkich wydatków");
            System.out.println("0. Koniec");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    AddTransaction.main(new String[0]);
                    break;
                case "2":
                    ModificationTransaction.main(new String[0]);
                    break;
                case "3":
                    DeleteTransaction.main(new String[0]);
                    break;
                case "4":
                    ShowAllRevenue.main(new String[0]);
                    break;
                case "5":
                    ShowAllExpenses.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Błędny wybór");
            }
        }
    }
}
