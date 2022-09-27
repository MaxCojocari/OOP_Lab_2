package merkletree;

import java.security.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import core.Transaction;

public class MerkleTree {	
    private ArrayList<Transaction> leaves;
    private ArrayList<Leaf> leavesObjects = new ArrayList<Leaf>();

    public MerkleTree(ArrayList<Transaction> leaves) {
        this.leaves = leaves;
    }

    public String getMerkleRoot() {
        Queue<Leaf> queue = new LinkedList<Leaf>();

        for (Transaction t: leaves) {
            queue.add(
                new Leaf(computeHash(t.getTransactionInfo()), null, null)
            );
        }

        while (queue.size() != 1) {
            Leaf leftLeaf = queue.remove();
            Leaf rightLeaf = queue.remove();

            Leaf newLeaf = new Leaf(
                computeHash(leftLeaf.getHash() + rightLeaf.getHash()), 
                leftLeaf, 
                rightLeaf
            );
            queue.add(newLeaf);
        }

        return queue.remove().getHash();
    }

    public void getLeaves() {
        for (Transaction t: leaves) {
            String l = t.getTransactionInfo(); 
            leavesObjects.add(new Leaf(computeHash(l), null, null));
        }

        if (leavesObjects.size() % 2 != 0) {
            leavesObjects.add(new Leaf(computeHash(""), null, null));
        }
    }

    public String computeHash(String input) {
        try {
            MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = SHA256.digest(input.getBytes("UTF-8"));
            
            StringBuffer hexString = new StringBuffer();
            for (byte b: hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}