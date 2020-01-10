import java.util.Scanner;

public class ModificationTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz zmodyfikować ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj typ wpisu ");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji ");
        String description = scanner.nextLine();

        System.out.println("Podaj kwotę transakcji ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji ");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(id, type, description, amount, date);
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.modification(transaction);
    }
}
