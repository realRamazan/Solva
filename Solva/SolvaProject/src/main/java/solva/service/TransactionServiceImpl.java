package solva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solva.dao.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDao transactionDao;

    @Override
    @Transactional
    public int setTransaction(int id, double transaction_limit) {
        return transactionDao.setTransaction(id, transaction_limit);
    }

    @Override
    @Transactional
    public int payment(int id, double payment) {
       return transactionDao.payment(id, payment);
    }
}
