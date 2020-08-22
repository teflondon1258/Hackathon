/**
 * @author Bogdan Kostevich.
 * Interface related with account.
 */

public interface Client {
    /**
     * @param account - it's a specific user account.
     * @param balance - balance a specific user.
     * Transferring money between users.
     * It's method working in related with method refreshBalance(Map.Entry<Long, Account> entryFrom) in interface Bank.
     */
    void transfer(Account account, int balance);

    /**
     * @param balance - balance a specific user.
     * Withdrawing some money.
     * It's method working in related with method getSomeMoney(Map.Entry<Long, Account> entry) in interface Bank.
     */
    void withdrawing (int balance);
}
