import java.util.Objects;

public class Account {
    private long REQUISITES;
    private String NAME;
    private String SUB_NAME;
    private int PIN;

    public Account(long REQUISITES, String NAME, String SUB_NAME, int PIN) {
        this.REQUISITES = REQUISITES;
        this.NAME = NAME;
        this.SUB_NAME = SUB_NAME;
        this.PIN = PIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return PIN == account.PIN;
    }

    @Override
    public int hashCode() {
        int result = PIN;
        result = 31 * result + (PIN != 0 ? PIN + 1 : 0);
        return result;
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

    public void setREQUISITES(long REQUISITES) {
        this.REQUISITES = REQUISITES;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setSUB_NAME(String SUB_NAME) {
        this.SUB_NAME = SUB_NAME;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
}
