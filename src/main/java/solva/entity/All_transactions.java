package solva.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "all_transactions")
public class All_transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "transaction_amount")
    private double transaction_amount;

    @Column(name = "s_t_date")
    private Date s_t_date;

    @Column(name = "payment")
    private Double payment;

    @Column(name = "payment_date")
    private Date payment_date;

    @Column(name = "limit_exceeded")
    private boolean limit_exceeded;

    @Column(name = "total_t_amount")
    private double total_t_amount;

    @Column(name = "exchange_rate")
    private double exchange_rate;


    public All_transactions() {
    }

    public All_transactions(int id, int user_id, double transaction_amount, Date s_t_date, double total_t_amount) {
        this.id = id;
        this.user_id = user_id;
        this.transaction_amount = transaction_amount;
        this.s_t_date = s_t_date;
        this.total_t_amount = total_t_amount;
    }

    public All_transactions(int id, int user_id, double transaction_amount, Date s_t_date, Double payment,
                            Date payment_date, boolean limit_exceeded, double total_t_amount, double exchange_rate) {
        this.id = id;
        this.user_id = user_id;
        this.transaction_amount = transaction_amount;
        this.s_t_date = s_t_date;
        this.payment = payment;
        this.payment_date = payment_date;
        this.limit_exceeded = limit_exceeded;
        this.total_t_amount = total_t_amount;
        this.exchange_rate = exchange_rate;
    }

    @Override
    public String toString() {
        return "All_transactions{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", transaction_amount=" + transaction_amount +
                ", s_t_date=" + s_t_date +
                ", payment=" + payment +
                ", payment_date=" + payment_date +
                ", limit_exceeded=" + limit_exceeded +
                ", total_t_amount=" + total_t_amount +
                ", exchange_rate=" + exchange_rate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public Date getS_t_date() {
        return s_t_date;
    }

    public void setS_t_date(Date s_t_date) {
        this.s_t_date = s_t_date;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public boolean isLimit_exceeded() {
        return limit_exceeded;
    }

    public void setLimit_exceeded(boolean limit_exceeded) {
        this.limit_exceeded = limit_exceeded;
    }

    public double getTotal_t_amount() {
        return total_t_amount;
    }

    public void setTotal_t_amount(double total_t_amount) {
        this.total_t_amount = total_t_amount;
    }

    public double getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }
}
