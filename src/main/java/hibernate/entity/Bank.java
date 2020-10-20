package hibernate.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Bank")
@Table(name = "bank")

public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "bankName")
    bankName bankName;
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="bank_customer",
            joinColumns=@JoinColumn(name="bank_id"),
            inverseJoinColumns=@JoinColumn(name="customer_id")
    )
    private List<Customer>customers;

    public Bank() {
    }
    public Bank(bankName bankName,  List<Customer>customers) {
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public bankName getBankName() {
        return bankName;
    }

    public String setBankName(String bankName) {
            switch(bankName) {
                case "BUCURESTI":
                    this.bankName= hibernate.entity.bankName.SDA_BUCURESTI;
                    break;
                case "CLUJ":
                    this.bankName= hibernate.entity.bankName.SDA_CLUJ;
                    break;
                case "CONSTANTA":
                    this.bankName= hibernate.entity.bankName.SDA_CONSTANTA;
                    break;
                case "CRAIOVA":
                    this.bankName= hibernate.entity.bankName.SDA_CRAIOVA;
                    break;
                case "SIBIU":
                    this.bankName= hibernate.entity.bankName.SDA_SIBIU;
                    break;
                case "IASI":
                    this.bankName= hibernate.entity.bankName.SDA_IASI;
                    break;
                case "TIMISOARA":
                    this.bankName= hibernate.entity.bankName.SDA_TIMISOARA;
                    break;
                case "INTERNATIONAL":
                    this.bankName= hibernate.entity.bankName.SDA_INTERNATIONAL;
                    break;

            }
            return bankName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public void addCustomers(Customer theCustomer) {

        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(theCustomer);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", customers=" + customers +
                '}';
    }
}



