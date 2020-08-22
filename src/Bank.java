import java.util.Map;

/**
 * @author Bogdan Kostevich.
 * Interface with operation related to the bank.
 */

public interface Bank {
    /**
     * @param requisites - details of a specific user. Digital format: **** **** **** **** without space.
     * @param name - name of a specific user.
     * @param subName - or surname of a specific user.
     * @param PIN - it's PIN - code for authorization in the system. Digital format ****.
     *
     * Method which create database in hashMap of each account.
     */
    void createAccount(long requisites, String name, String subName, int PIN);

    /**
     * Method which working in related with method create account.
     * This method simply calls the createAccount method and passes the appropriate parameters to it.
     */
    void dataBase();

    /**
     * The main method that is responsible for checking the PIN - code.
     * If the PIN - code is correct, then it will call a certain operation depending on the user input.
     */
    void checkPIN();

    /**
     * Method calls method create data base and check PIN - code.
     */
    void testPrint();

    /**
     * Simple method which print all user from hashMap.
     */
    void printAllClient();

    /**
     * @param entryFrom - object from map.
     * Transferring money between users.
     * Main task is a type correct requisites specific user and balance which will be credited to the account of another client.
     * Warning! The account that transfers money must have an amount sufficient for the transfer.
     */
    void refreshBalance(Map.Entry<Long, Account> entryFrom);

    /**
     * @param entry - object from map.
     * Withdrawing some money which input a user.
     * Warning! The account that withdrawing money must have an amount sufficient for withdrawing.
     */
    void getSomeMoney(Map.Entry<Long, Account> entry);
}
