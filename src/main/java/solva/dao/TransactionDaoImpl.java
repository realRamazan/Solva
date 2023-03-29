package solva.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solva.entity.All_transactions;
import solva.entity.Users;


import java.util.Date;
import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int setTransaction(int id, double transaction_limit) {
        Session session = sessionFactory.getCurrentSession();
        Date date = new Date();
        Query query1 = session.createQuery("from Users where id =: idd");
        query1.setParameter("idd", id);
        List<Users> usersList = query1.getResultList();
        if(usersList.get(0).getCash() < transaction_limit*446){
            return 1;
        }
        else {
            double tr = usersList.get(0).getCash() - transaction_limit * 446;
            All_transactions transaction = new All_transactions();
            Query query = session.createQuery("from All_transactions where user_id =: id order by id desc");
            query.setParameter("id", id);
            List<All_transactions> transactions = query.getResultList();
            double newtransaction = transactions.get(0).getTotal_t_amount() + transaction_limit;
            transaction.setS_t_date(date);
            transaction.setUser_id(id);
            transaction.setTransaction_amount(newtransaction);
            transaction.setTotal_t_amount(newtransaction);
            session.save(transaction);
            return 0;
        }
    }

    @Override
    public int payment(int id, double payment) {
        Session session = sessionFactory.getCurrentSession();
        Date date = new Date();
        All_transactions transaction = new All_transactions();
        Query query = session.createQuery("from All_transactions where user_id =: idd order by id desc ");
        query.setParameter("idd", id);
        List<All_transactions> transactions = query.getResultList();
        double after_payment = transactions.get(0).getTotal_t_amount() - payment;
        transaction.setUser_id(id);
        transaction.setPayment(payment);
        if(after_payment < 0){
            transaction.setLimit_exceeded(true);
            transaction.setTotal_t_amount(transactions.get(0).getTotal_t_amount());
            transaction.setTransaction_amount(transactions.get(0).getTotal_t_amount());
            transaction.setPayment_date(date);
            session.saveOrUpdate(transaction);
            return 1;
        }
        else {
            transaction.setLimit_exceeded(false);
            transaction.setTotal_t_amount(after_payment);
            transaction.setTransaction_amount(after_payment);
            transaction.setPayment_date(date);
            session.saveOrUpdate(transaction);
            return 0;
        }
    }
}
