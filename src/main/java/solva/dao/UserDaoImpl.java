package solva.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solva.entity.All_transactions;
import solva.entity.Users;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Users> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Users> query = session.createQuery("from Users ", Users.class);
        List<Users> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public int setTransaction(int id, double transaction_limit) {
        Session session = sessionFactory.getCurrentSession();
        Users user = session.get(Users.class, id);
        double d = user.getCash();
        d = d - transaction_limit * 446;
        if(d < 0){
            return 1;
        }
        else {
            Query query2 = session.createQuery("from All_transactions where user_id =: id order by id desc ").setParameter("id", id);
            List<All_transactions> transactions = query2.getResultList();
            double newTransaction = transactions.get(0).getTransaction_amount() + transaction_limit;
            Query query = session.createQuery("update Users set transaction_limit = :transaction where id = :uId");
            query.setParameter("transaction", newTransaction);
            query.setParameter("uId", id);
            Query query1 = session.createQuery("update Users set cash =: newCash where id =: uId");
            query1.setParameter("newCash", d);
            query1.setParameter("uId", id);
            query.executeUpdate();
            query1.executeUpdate();
            return 0;
        }
    }

    @Override
    public Users getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Users user = session.get(Users.class, id);
        return user;
    }

    @Override
    public void payment(int id, double payment) {
        Session session = sessionFactory.getCurrentSession();
        Session session1 = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select transaction_limit from Users where id =: idz");
        query.setParameter("idz", id);
        List<Double> res = query.getResultList();
        System.out.println(res.get(0));
        double after_payment = res.get(0) - payment;
        if(after_payment > 0){
            Query query1 = session1.createQuery("update Users set transaction_limit =:after where id =: idzz");
            query1.setParameter("idzz", id);
            query1.setParameter("after", after_payment);
            query1.executeUpdate();

        }
    }

    @Override
    public int checkPass(String password){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select id from Users  where pin_code =: pincode");
        query.setParameter("pincode", password);
        List<Integer> resList = query.getResultList();
        if(resList.isEmpty()){
            return 0;
        }
        return resList.get(0);
    }
}
