package actors;

import java.util.ArrayList;
import core.Block;

public class Miner {
    private int rewardsBTC;
    private ArrayList<Block> blocksMined = new ArrayList<Block>();

    public Miner() {
        this.rewardsBTC = 0;
    }

    public int getMinerRewards() {
        return rewardsBTC;
    }

    public void mineBlock(Block b, int rewards) {
        if (rewards <= 0) return;
        blocksMined.add(b);
        gatherRewards(rewards);
    }

    public void gatherRewards(int newRewards) {
        rewardsBTC += newRewards;
    }
}
