package hibernate.entity;

import hibernate.util.Iban;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Account")
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "IBAN")
    private String iban;
    @Enumerated(EnumType.STRING)
    @Column(name = "accountType")
    private accountType accountType;
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="transaction_id")
    private List<TransactionHistory> transactionHistory;

    public Account() {
    }

    public Account(int id, String iban, accountType accountType,Customer customer, List<TransactionHistory> transactionHistory) {
        this.id = id;
        this.iban = iban;
        this.accountType = accountType;
        this.customer = customer;
        this.transactionHistory = transactionHistory;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban() {
        this.iban = Iban.ibanGenerator();
    }

    public hibernate.entity.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        switch (accountType) {
            case "CREDIT EURO":
                   this.accountType = hibernate.entity.accountType.CREDIT_EURO;
                   break;
            case "CREDIT RON":
                    this.accountType = hibernate.entity.accountType.CREDIT_RON;
            case "DEBIT EURO":
                    this.accountType = hibernate.entity.accountType.DEBIT_EURO;
            case "DEBIT RON":
                    this.accountType = hibernate.entity.accountType.DEBIT_RON;
        }
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistory;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistory = transactionHistoryList;
    }

    public void addTransactions(TransactionHistory tempTransaction) {

        if (transactionHistory == null) {
            transactionHistory = new ArrayList<>();
        }
        transactionHistory.add(tempTransaction);
        tempTransaction.setAccount(this);
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", accountType='" + accountType + '\'' +
                ", customer=" + customer +
                ", transactionHistoryList=" + transactionHistory +
                '}';
    }
}

