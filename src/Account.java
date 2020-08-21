import java.util.Objects;

public class Account {
    // must have fields
    private long REQUISITES;
    private String NAME;
    private String SUB_NAME;
    private int PIN;

    // fields for client
    private int balance = 0;

    public Account(long REQUISITES, String NAME, String SUB_NAME, int PIN) {
        this.REQUISITES = REQUISITES;
        this.NAME = NAME;
        this.SUB_NAME = SUB_NAME;
        this.PIN = PIN;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSUB_NAME() {
        return SUB_NAME;
    }

    public long getREQUISITES() {
        return REQUISITES;
    }

    public int getPIN() {
        return PIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (REQUISITES != account.REQUISITES) return false;
        return PIN == account.PIN;
    }

    @Override
    public int hashCode() {
        int result = (int) (REQUISITES ^ (REQUISITES >>> 32));
        result = 31 * result + PIN;
        return result;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }
}
