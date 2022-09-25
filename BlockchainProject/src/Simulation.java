import core.Block;
import core.Blockchain;
import core.Transaction;
import core.TransactionPool;

public class Simulation {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        int i = 0;
        int k = -1;
        TransactionPool TxPool = new TransactionPool();
        
        Transaction tx = new Transaction("Alice", "Bob", "BTC", 10);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceBTC() + " BTC");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceBTC() + " BTC" + "\n");
        
        tx = new Transaction("Alice", "Steave", "ETH", 3);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceETH() + " ETH");
        System.out.println("Steave's balance: " + TxPool.steave.getBalanceETH() + " ETH" + "\n");
        
        tx = new Transaction("Steave", "Bob", "ETH", 23);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Steave's balance: " + TxPool.steave.getBalanceETH() + " ETH");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceETH() + " ETH" + "\n");
        
        Block block = new Block(i, null, TxPool.getPool());
        block.mineBlock(2);
        blockchain.addBlock(block);
        
        
        
        tx = new Transaction("Alice", "Bob", "BTC", 22);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceBTC() + " BTC");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceBTC() + " BTC" + "\n");
        
        tx = new Transaction("Steave", "Alice", "ETH", 30);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Steave's balance: " + TxPool.steave.getBalanceETH() + " ETH");
        System.out.println("Alice's balance: " + TxPool.alice.getBalanceETH() + " ETH" + "\n");
        
        tx = new Transaction("Steave", "Bob", "BTC", 6);
        TxPool.addTransaction(tx);
        System.out.println("Transaction # " + (++k) + "\n" + tx.getTransactionInfo());
        System.out.println("Steave's balance: " + TxPool.steave.getBalanceBTC() + " BTC");
        System.out.println("Bob's balance: " + TxPool.bob.getBalanceBTC() + " BTC\n");

        block = new Block(++i, block.currHash, TxPool.getPool());
        block.mineBlock(1);
        blockchain.addBlock(block);

        blockchain.getBlocks();
    }
}