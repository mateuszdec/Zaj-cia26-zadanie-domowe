import java.util.Scanner;

public class ShowAllRevenue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj typ operacji: ");
        String type = scanner.nextLine();
        TransactionDao transactionDao = new TransactionDao();
        Transaction transaction = transactionDao.showRevenue(type);
        System.out.println(transaction);
    }
}
