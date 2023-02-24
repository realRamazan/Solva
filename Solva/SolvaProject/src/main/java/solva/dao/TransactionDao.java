package solva.dao;

public interface TransactionDao {
    public int setTransaction(int id, double transaction_limit);
    public int payment(int id, double payment);
}
