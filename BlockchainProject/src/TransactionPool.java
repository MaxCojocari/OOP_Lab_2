import java.util.*;

public class TransactionPool {
    public BTCCoin BTC = new BTCCoin(1000000);
    public ETHCoin ETH = new ETHCoin(2000000);
    public Alice alice = new Alice(100, 100);
    public Bob bob = new Bob(50, 300);
    public Steave steave = new Steave(150, 300);

    private ArrayList<Transaction> T = new ArrayList<Transaction>();
    private int maxPoolSize = 5;

    public Transaction getTransaction(int i) {
        return T.get(i);
    }

    public int getNrTransactions() {
        return T.size();
    }

    public void getTransactionInfo() {
        for (Transaction t: T) {
            System.out.println(t.getTransactionInfo());
        }
    }

    public void addTransaction(Transaction t) {
        int amount = t.getAmount();
        String sender = t.getSender();
        String receiver = t.getReceiver();
        String assetName = t.getAssetSymbol();
        boolean isBTC = assetName.equals("BTC");
        boolean success;

        switch(sender) {
            case "Alice": {
                success = isBTC ? alice.sendBTC(amount, receiver) : alice.sendETH(amount, receiver);
                if (!success) return;
            }
            case "Bob": {
                success = isBTC ? bob.sendBTC(amount, receiver) : bob.sendETH(amount, receiver);
                if (!success) return;
            }
            case "Steave": {
                success = isBTC ? steave.sendBTC(amount, receiver) : steave.sendETH(amount, receiver);
                if (!success) return;
            }
        }

        switch(receiver){
            case "Alice":
                if (isBTC) alice.receiveBTC(amount);
                else alice.receiveETH(amount);
            case "Bob":
                if (isBTC) bob.receiveBTC(amount);
                else bob.receiveETH(amount);
            case "Steave":
                if (isBTC) steave.receiveBTC(amount);
                else steave.receiveETH(amount);
        }
        
        t.setChecked();
        if (isPoolFull()) T.clear();
        T.add(t);
    }

    public boolean isPoolFull() {
        return T.size() >= maxPoolSize;
    }
}