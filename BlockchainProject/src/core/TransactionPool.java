package core;

import java.util.ArrayList;
import actors.Sender;
import actors.Receiver;
import crypto.BTCCoin;
import crypto.ETHCoin;

public class TransactionPool {
    private BTCCoin BTC = new BTCCoin(1000000);
    private ETHCoin ETH = new ETHCoin(2000000);

    public Sender alice = new Sender(1000, 1000);
    public Receiver bob = new Receiver(500, 3000);

    private ArrayList<Transaction> T = new ArrayList<Transaction>();
    private int maxPoolSize = 2;

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
        String receiver = t.getReceiver();
        String assetName = t.getAssetSymbol();
        boolean isBTC = assetName.equals("BTC");
        boolean success;


        success = isBTC ? alice.sendBTC(amount, receiver) : alice.sendETH(amount, receiver);
        if (!success) return;

        success = isBTC ? bob.receiveBTC(amount) : bob.receiveETH(amount);
        if (!success) return;

        t.setChecked();
        if (isPoolFull()) T.clear();
        T.add(t);
    }

    public boolean isPoolFull() {
        return T.size() >= maxPoolSize;
    }

    public boolean checkTotalBTC() {
        return alice.getBalanceBTC() + bob.getBalanceBTC() <= BTC.getTotalSupply();
    }

    public boolean checkTotalETH() {
        return alice.getBalanceETH() + bob.getBalanceETH() <= ETH.getTotalSupply();
    }

    public ArrayList<Transaction> getPool() {
        return T;
    }
}