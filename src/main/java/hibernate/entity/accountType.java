package hibernate.entity;

public enum accountType {
    DEBIT_EURO("DEBIT EURO"),
    DEBIT_RON("DEBIT RON"),
    CREDIT_EURO("CREDIT EURO"),
    CREDIT_RON("CREDIT RON");
    String accountType;

    accountType(String accountType) {
        this.accountType = accountType;
    }

}
