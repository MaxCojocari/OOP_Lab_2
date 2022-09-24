import java.security.*;

public class Block {
    public int index;
    public long timestamp;
    public String currHash;
    public String prevHash;
    public int nonce = 0;


    public Block(int index, String prevHash) {
        this.index = index;
        this.timestamp = System.currentTimeMillis();
        this.prevHash = prevHash;
        currHash = computeHash();
    }

    public String computeHash() {
        try {
            String input = index + timestamp + prevHash + nonce;
            MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = SHA256.digest(input.getBytes("UTF-8"));
            
            StringBuffer hexString = new StringBuffer();
            for (byte b: hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!currHash.substring(0, difficulty).equals(target)) {
            nonce++;
            currHash = computeHash();
        }
    }

    public String toString() {
        String s = "Block # " + index + "\n";
        s = s + "PreviousHash:\t" + prevHash + "\n";
        s = s + "Timestamp:\t" + timestamp + "\n";
        s = s + "Nonce:\t\t" + nonce + "\n";
        s = s + "CurrentHash:\t" + currHash + "\n";
        return s;
    }
}