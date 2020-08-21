import java.util.Map;

public interface Console {
    Account inputData();

    void printOperation();

    String inputOperation();

    void setBalance(Map.Entry<Long, Account> entry, int topUpBalance);

    void printBalance(Map.Entry<Long, Account> entry);
}
