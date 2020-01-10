public class ShowAllRevenue {
    public static void main(String[] args) {

        TransactionDao transactionDao = new TransactionDao();
        System.out.println(transactionDao.showRevenue());
    }
}
