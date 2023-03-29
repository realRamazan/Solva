package solva.dao;

import solva.entity.Users;

import java.util.List;

public interface UserDao {
    public List<Users> getAllUsers();

    public int setTransaction(int id, double transaction_limit);

    public Users getUser(int id);

    public void payment(int id, double payment);

    public int checkPass(String pass);
}
