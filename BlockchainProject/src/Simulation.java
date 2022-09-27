import core.Block;
import core.Blockchain;
import core.Transaction;
import core.TransactionPool;

public class Simulation {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        int i = 0;
        int k = 0;
        TransactionPool TxPool = new TransactionPool();
        
        Transaction tx = new Transaction("Alice", "Bob", "BTC", 10);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (k++) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceBTC() + " BTC");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceBTC() + " BTC" + "\n");
        
        tx = new Transaction("Alice", "Bob", "ETH", 3);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (k++) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceETH() + " ETH");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceETH() + " ETH" + "\n");
        
        Block block = new Block(i, null, TxPool.getPool());
        block.mineBlock(2);
        blockchain.addBlock(block);
        
        
        tx = new Transaction("Alice", "Bob", "ETH", 30);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (k++) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceETH() + " ETH");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceETH() + " ETH" + "\n");
        
        tx = new Transaction("Alice", "Bob", "ETH", 130);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (k++) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceETH() + " ETH");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceETH() + " ETH" + "\n");

        block = new Block(++i, block.currHash, TxPool.getPool());
        block.mineBlock(1);
        blockchain.addBlock(block);

        blockchain.getBlocks();
    }
}