package solva.service;

import solva.entity.Users;

import java.util.List;

public interface UserService {
    public Users getUser(int id);

    public int setTransaction(int id, double transaction_limit);

    public List<Users> getAllUsers();

    public void payment(int id, double payment);

    public int checkPass(String pass);
}
