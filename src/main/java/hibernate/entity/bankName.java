package hibernate.entity;

public enum bankName {
    SDA_BUCURESTI("SDA BUCURESTI BANK"),
    SDA_CLUJ("SDA CLUJ BANK"),
    SDA_CONSTANTA("SDA CONSTANTA BANK"),
    SDA_CRAIOVA("SDA CRAIOVA BANK"),
    SDA_SIBIU("SDA SIBIU BANK"),
    SDA_IASI("SDA IASI BANK"),
    SDA_TIMISOARA("SDA TIMISOARA BANK"),
    SDA_INTERNATIONAL("SDA INTERNATIONAL BANK");
    String bankName;

    bankName(String bankName) {
        this.bankName = bankName;
    }
    }

