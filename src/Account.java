import java.util.Objects;

public class Account {
    private final long REQUISITES;
    private final String NAME;
    private final String SUB_NAME;
    private final int PIN;

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
        return Objects.hash(PIN);
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
}
