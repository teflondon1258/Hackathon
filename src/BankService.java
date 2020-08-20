import java.util.HashMap;
import java.util.Map;

public class BankService {
    Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(long requisites, String name, String subName, int PIN) {
        Account account = new Account(requisites, name, subName, PIN);
        accounts.put(account.getPIN(), account);
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

    public void testPrintDataBase() {
        dataBase();

        for (Map.Entry<Integer, Account> accountEntry : accounts.entrySet()) {
            System.out.println("---------------------------------------------------------------------\n" +
                    "PIN-код: " + accountEntry.getKey() + "\nДанные о пользователе " +
                    accountEntry.getValue().getREQUISITES() + "   " + accountEntry.getValue().getNAME() + "   " +
                    accountEntry.getValue().getSUB_NAME());
        }
    }
}
