package solva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solva.dao.UserDao;
import solva.entity.Users;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Users getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public int setTransaction(int id, double transaction_limit) {
        return userDao.setTransaction(id, transaction_limit);
    }

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void payment(int id, double payment){
        userDao.payment(id, payment);
    }

    @Override
    @Transactional
    public int checkPass(String pass) {
        return userDao.checkPass(pass);
    }
}
