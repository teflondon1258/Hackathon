import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    Map<Long, Account> accounts = new HashMap<>();
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;

    public void createAccount(long requisites, String name, String subName, int PIN) {
        Account account = new Account(requisites, name, subName, PIN);
        accounts.put(account.getREQUISITES(), account);
        count++;
        /*System.out.println(account.hashCode() + "   первый хэш");
        Account account1 = accounts.get(account.getPIN());
        System.out.println(account1.hashCode() + "   Второй хэш");*/

        /*arrayListAccount.add(account);*/
    }

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

    public String[] inputData() {
        String[] askStr = new String[2];
        try {
            System.out.println("Введите Ваш PIN-код");
            askStr[0] = bf.readLine();

            System.out.println("Введите Ваши реквизиты");
            askStr[1] = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return askStr;
    }

    public Account[] createArrayOfAccount() {
       String[] data = inputData();

        Account[] accountOfArray = new Account[count];
        int index = 0;

        for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
            /*System.out.println(entry.getValue().getREQUISITES());*/
            // установка заполненной мапы
            accountOfArray[index].setSUB_NAME(entry.getValue().getSUB_NAME());
            accountOfArray[index].setNAME(entry.getValue().getNAME());
            // установка данных со стринга
            accountOfArray[index].setREQUISITES(Long.parseLong(data[0]));
            accountOfArray[index].setPIN(Integer.parseInt(data[1]));

            index++;
        }

        return accountOfArray;
    }

    public void checkPIN() {
        Account[] accountForCheck = createArrayOfAccount();

        for (int i = 0; i < accountForCheck.length; i++) {
            for (Map.Entry<Long, Account> entry : accounts.entrySet()) {
                if (entry.getValue().hashCode() == accountForCheck[i].hashCode()) {
                    System.out.println(accountForCheck[i].getREQUISITES());
                    break;
                }
            }
        }
    }

    public void testPrintDataBase() {
        dataBase();
        checkPIN();

        for (Map.Entry<Long, Account> accountEntry : accounts.entrySet()) {
            System.out.println("---------------------------------------------------------------------\n" +
                    "PIN-код: " + accountEntry.getKey() + "\nДанные о пользователе " +
                    accountEntry.getValue().getREQUISITES() + "   " + accountEntry.getValue().getNAME() + "   " +
                    accountEntry.getValue().getSUB_NAME());
        }
    }
}
