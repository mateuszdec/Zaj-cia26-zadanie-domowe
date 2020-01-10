import java.util.Scanner;

public class AddTransaction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj typ wpisu ");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji ");
        String description = scanner.nextLine();

        System.out.println("Podaj kwotę transakcji ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę transakcji ");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.add(transaction);

    }
}
