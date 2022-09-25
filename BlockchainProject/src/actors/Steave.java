package actors;

public class Steave {
    public boolean doesSteaveLoveOOP;
    private int balanceBTC;
    private int balanceETH;

    public Steave(int balanceBTC, int balanceETH) {
        this.doesSteaveLoveOOP = true;
        this.balanceBTC = balanceBTC;
        this.balanceETH = balanceETH;
    }

    public boolean sendBTC(int amount, String to) {
        if (balanceBTC <= amount) return false;
        balanceBTC -= amount;
        return true;
    }
    
    public boolean sendETH(int amount, String to) {
        if (balanceETH <= amount) return false;
        balanceETH -= amount;
        return true;
    }

    public boolean receiveBTC(int amount) {
        if (amount <= 0) return false;
        balanceBTC += amount;
        return true;
    }
    
    public boolean receiveETH(int amount) {
        if (amount <= 0) return false;
        balanceETH += amount;
        return true;
    }

    public boolean getDoesSteaveLoveOOP() {
        return doesSteaveLoveOOP;
    }

    public int getBalanceBTC() {
        return balanceBTC;
    }

    public int getBalanceETH() {
        return balanceETH;
    }
}
