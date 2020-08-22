import java.util.Map;

/**
 * @author Bogdan Kostevich.
 * Interface related with console input.
 */

public interface Console {
    /**
     * @return object type Account.
     * Method for inputs data, exactly PIN - code and requisites a specific user.
     */
    Account inputData();

    /**
     * Simple print five operations for select.
     */
    void printOperation();

    /**
     * @return string value selected operation.
     * User select operations from list in method printOperation().
     */
    String inputOperation();

    /**
     * @param entry - specific user from data base.
     * @param topUpBalance - sum balance for top up in your account.
     * Method top up balance for your account.
     */
    void setBalance(Map.Entry<Long, Account> entry, int topUpBalance);

    /**
     * @param entry - show sum of specific balance.
     * Prints your balance from your card or other words - from requisites.
     */
    void printBalance(Map.Entry<Long, Account> entry);
}
