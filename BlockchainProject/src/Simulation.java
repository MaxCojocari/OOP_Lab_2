public class Simulation {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        int i = 0;
        Block block = new Block(i, null);
        block.mineBlock(1);
        blockchain.addBlock(block);
        
        block = new Block(++i, block.currHash);
        block.mineBlock(1);
        blockchain.addBlock(block);
        
        block = new Block(++i, block.currHash);
        block.mineBlock(1);
        blockchain.addBlock(block);
        
        blockchain.getBlocks();



        //String hex = Integer.toBinaryString(0xff);
        //System.out.println(hex);
        //Scanner input = new Scanner(System.in);
        // String s = block.toString();
        // System.out.println(block.toString());
    }
}