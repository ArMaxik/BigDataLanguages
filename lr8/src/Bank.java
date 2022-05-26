import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Bank extends Thread {
    private BlockingQueue<Transaction> transactions;
    private ArrayList<Account> accounts;

    Bank() {
        this.transactions = new LinkedBlockingDeque<Transaction>();
        this.accounts = new ArrayList<Account>();
    }

    Bank(ArrayList<Account> accounts) {
        this.transactions = new LinkedBlockingDeque<Transaction>();
        this.accounts = accounts;
    }

    public void stopThreads() {
        for (Account account : accounts) account.stop();
        this.stop();
    }

    private void transfer(String from, String to, int count) {
        Account acc1 = accounts.stream().filter(a -> a.name.equals(from)).findAny().orElse(null);
        Account acc2 = accounts.stream().filter(a -> a.name.equals(to)).findAny().orElse(null);

        if (acc1 != null && acc2 != null) {
            if (acc1.moneyCount < count) {
                System.out.println("Ошибка: у отправителя недостаточно средств");
            }
            else {
                acc1.decrease(count);
                acc2.increase(count);

                System.out.println("Транзакция прошла успешно");
            }
        }
        else {
            System.out.println("Ошибка: один или более из введенных аккаунтов не существуют");
        }
    }

    public void getAccounts() {
        accounts.forEach(a -> System.out.println(a.toString() + ";"));
    }

    public void makeTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);

                if (transactions.size() != 0) {
                    for (int i = 0; i < transactions.size(); i++) {
                        Transaction tr = transactions.poll();
                        transfer(tr.from, tr.to, tr.count);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}