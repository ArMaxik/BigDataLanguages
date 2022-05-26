import java.util.ArrayList;
import java.util.Scanner;

public class Laba2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Account> accounts = new ArrayList<Account>();
        
        for (int i = 0; i < 10; i++) {
            Account account = new Account();
            accounts.add(account);
            account.start();
        }

        Bank bank = new Bank(accounts);
        bank.start();

        Scanner in = new Scanner(System.in);
        String command;

        do {
            command = in.nextLine();

            if ("accounts".equals(command)) {
                bank.getAccounts();
            }
            else if (command.startsWith("transfer")) {
                String[] splitted = command.split(" ");

                bank.makeTransaction(new Transaction(
                    splitted[1],
                    splitted[2],
                    Integer.parseInt(splitted[3])
                ));
            }

        } while (!"exit".equals(command));

        bank.stopThreads();
        in.close();
    }
}
