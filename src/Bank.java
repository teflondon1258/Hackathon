import java.util.Map;

public interface Bank {
    void createAccount(long requisites, String name, String subName, int PIN);

    void dataBase();

    void checkPIN();

    void testPrint();

    void printAllClient();
}
