import java.util.Scanner;

public class DeleteTransaction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji którą chcesz usunąć ");
        long id = scanner.nextLong();
        scanner.nextLine();

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.deleteTransaction(id);
        System.out.println("Usunięto!");
    }
}
