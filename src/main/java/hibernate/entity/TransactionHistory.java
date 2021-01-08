package hibernate.entity;

import javax.persistence.*;

@Entity(name = "TransactionHistory")
@Table(name = "transactionhistory")

public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,updatable = false, nullable = false)
    private int id;
    @Column(name = "deposit")
    private double deposit;
    @Column(name = "amount")
    private double amount;
    @Column(name = "withdraw")
    private double withdraw;
    @Column(name = "currency")
    private String currency;
    @Column(name = "balanceAtTheTimeOfTransaction")
    private double balanceAtTheTimeOfTransaction;
    @Column(name = "changed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date changed_at;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="account_id")
    private Account account;

    public TransactionHistory() {
    }
    public TransactionHistory(int id, double deposit, double amount, double withdraw,String currency, double balanceAtTheTimeOfTransaction, java.util.Date changed_at) {
        this.id = id;
        this.deposit = deposit;
        this.amount = amount;
        this.withdraw = withdraw;
        this.currency=currency;
        this.balanceAtTheTimeOfTransaction = balanceAtTheTimeOfTransaction;
        this.changed_at = changed_at;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getBalance() {
        return balanceAtTheTimeOfTransaction;
    }

    public void setBalance(double balance) {
        this.balanceAtTheTimeOfTransaction = balance;
    }


    public java.util.Date getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(java.util.Date changed_at) {
        this.changed_at = changed_at;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "id=" + id +
                ", deposit=" + deposit +
                ", amount=" + amount +
                ", withdraw=" + withdraw +
                ", currency='" + currency + '\'' +
                ", balanceAtTheTimeOfTransaction=" + balanceAtTheTimeOfTransaction +
                ", changed_at=" + changed_at +
                ", account=" + account +
                '}';
    }
}


