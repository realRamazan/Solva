package solva.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_surname")
    private String user_surname;

    @Column(name = "cash")
    private double cash;

    @Column(name = "transaction_limit")
    private double transaction_limit;

    @Column(name = "pin_code")
    private String pin_code;


    public Users() {
    }

    public Users(int id, String user_name, String user_surname, double cash, double transaction_limit, String pin_code) {
        this.id = id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.cash = cash;
        this.transaction_limit = transaction_limit;
        this.pin_code = pin_code;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", user_surname='" + user_surname + '\'' +
                ", cash=" + cash +
                ", transaction_limit=" + transaction_limit +
                ", pin_code=" + pin_code +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getTransaction_limit() {
        return transaction_limit;
    }

    public void setTransaction_limit(double transaction_limit) {
        this.transaction_limit = transaction_limit;
    }


}
