package core;
import java.util.ArrayList;
import actors.Alice;
import actors.Bob;
import actors.Steave;
import actors.John;
import crypto.BTCCoin;
import crypto.ETHCoin;

public class TransactionPool {
    public BTCCoin BTC = new BTCCoin(1000000);
    public ETHCoin ETH = new ETHCoin(2000000);

    public Alice alice = new Alice(100, 100);
    public Bob bob = new Bob(50, 300);
    public Steave steave = new Steave(150, 300);
    public John john = new John(270, 400);

    private ArrayList<Transaction> T = new ArrayList<Transaction>();
    private int maxPoolSize = 3;

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
                break;
            }
            case "Bob": {
                success = isBTC ? bob.sendBTC(amount, receiver) : bob.sendETH(amount, receiver);
                if (!success) return;
                break;
            }
            case "Steave": {
                success = isBTC ? steave.sendBTC(amount, receiver) : steave.sendETH(amount, receiver);
                if (!success) return;
                break;
            }
            case "John": {
                success = isBTC ? john.sendBTC(amount, receiver) : john.sendETH(amount, receiver);
                if (!success) return;
                break;
            }
        }

        switch(receiver){
            case "Alice": {
                success = isBTC ? alice.receiveBTC(amount) : alice.receiveETH(amount);
                if (!success) return;
                break;
            }
            case "Bob": {
                success = isBTC ? bob.receiveBTC(amount) : bob.receiveETH(amount);
                if (!success) return;
                break;
            }
            case "Steave": {
                success = isBTC ? steave.receiveBTC(amount) : steave.receiveETH(amount);
                if (!success) return;
                break;
            }
            case "John": {
                success = isBTC ? john.receiveBTC(amount) : john.receiveETH(amount);
                if (!success) return;
                break;
            }
        }
        
        t.setChecked();
        if (isPoolFull()) T.clear();
        T.add(t);
    }

    public boolean isPoolFull() {
        return T.size() >= maxPoolSize;
    }

    public boolean checkTotalBTC() {
        return alice.getBalanceBTC() + bob.getBalanceBTC() + steave.getBalanceBTC() + john.getBalanceBTC() <= BTC.getTotalSupply();
    }

    public boolean checkTotalETH() {
        return alice.getBalanceETH() + bob.getBalanceETH() + steave.getBalanceETH() + john.getBalanceETH() <= ETH.getTotalSupply();
    }

    public ArrayList<Transaction> getPool() {
        return T;
    }
}