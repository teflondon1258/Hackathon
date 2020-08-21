import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BankService implements Console, Bank {
    Map<Long, Account> accounts = new HashMap<>();
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;

    @Override
    public void createAccount(long requisites, String name, String subName, int PIN) {
        Account account = new Account(requisites, name, subName, PIN);
        accounts.put(account.getREQUISITES(), account);
        count++;
    }

    @Override
    public void dataBase() {
        createAccount(4142_4884_3999_2555L,"Василий","Куприянович",1234);
        createAccount(4142_4884_3191_2454L,"Арсен","Ватулин",1248); // Одинаковый PIN (2)
        createAccount(4142_4884_3891_2158L,"Ольга","Брунькина",2121); // Одинаковый PIN (3)
        createAccount(5153_4141_6591_9748L,"Ирина","Стреп",5252); // Одинаковый PIN (1)
        createAccount(1555_9883_1706_3535L,"Ирина","Янакова",5252); // Одинаковый PIN (1)
        createAccount(5154_6311_1991_3705L,"Ольга","Вуйчич",1111);
        createAccount(9874_2525_1118_3535L,"Олег","Яценко",1248); // Одинаковый PIN (2)
        createAccount(4149_2525_5191_5535L,"Тимур","Зухараев",1248); // Одинаковый PIN (2)
        createAccount(9381_1247_4571_7252L,"Алиев","Марджин",1005);
        createAccount(5153_4673_7423_1633L,"Бек","Сарсенбек",1025);
        createAccount(1192_9392_7423_9459L,"Джамбулат","Зукхариев",2121); // Одинаковый PIN (3)
    }

    @Override
    public Account inputData() {
        Account createAccount = null;
        try {
            System.out.println("Введите Ваш PIN-код");
            int PIN = Integer.parseInt(bf.readLine());

            System.out.println("Введите Ваши реквизиты");
            long requisites = Long.parseLong(bf.readLine());

            createAccount = new Account(requisites,"","",PIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createAccount;
    }

    @Override
    public void printOperation() {
        System.out.println("Select your variant of operation");
        System.out.println("1. Show your balance\n" +
                "2. Refresh balance\n" +
                "3. Get some money\n" +
                "4. Top up balance\n" +
                "5. Exit");
    }

    @Override
    public String inputOperation() {
        printOperation();

        String operation = "";
        try {
            operation = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return operation;
    }

    @Override
    public void setBalance(Map.Entry<Long, Account> entry, int topUpBalance) {
        entry.getValue().setBalance(topUpBalance);
    }

    @Override
    public void checkPIN() {
        Account account = inputData();
        int operation = Integer.parseInt(inputOperation());


        while (operation != 5) {
            for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
                // Continue my logic. Oevole your task is 3rd. Anna your task is 2nd.

                if (account.hashCode() == entry.getValue().hashCode() && operation == 1) {
                    // Operation for show balance
                    printBalance(entry);
                } else if (account.hashCode() == entry.getValue().hashCode() && operation == 4) {
                    int newBalance = 0;

                    try {
                        newBalance = Integer.parseInt(bf.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setBalance(entry, newBalance);
                }
            }

            operation = Integer.parseInt(inputOperation());
        }
    }

    @Override
    public void testPrint() {
        dataBase();
        checkPIN();
    }

    @Override
    public void printAllClient() {
        for (Map.Entry<Long, Account> accountEntry : accounts.entrySet()) {
            System.out.println("---------------------------------------------------------------------\n" +
                    "PIN-код: " + accountEntry.getKey() + "\nДанные о пользователе " +
                    accountEntry.getValue().getREQUISITES() + "   " + accountEntry.getValue().getNAME() + "   " +
                    accountEntry.getValue().getSUB_NAME());
        }
    }

    @Override
    public void printBalance(Map.Entry<Long, Account> entry) {
        System.out.println("Hello, " + entry.getValue().getNAME());
        System.out.println("Your balance is " + entry.getValue().getBalance());
    }
}
