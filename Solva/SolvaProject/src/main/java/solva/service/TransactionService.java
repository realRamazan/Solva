package solva.service;

public interface TransactionService {
    public int setTransaction(int id, double transaction_limit);

    public int payment(int id, double payment);
}
