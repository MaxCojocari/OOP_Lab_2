package actors;

public class Receiver {
    private int balanceBTC;
    private int balanceETH;
    private int age;

    public Receiver(int balanceBTC, int balanceETH) {
        this.balanceBTC = balanceBTC;
        this.balanceETH = balanceETH;
        this.age = 24;
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

    public int getAge() {
        return age;
    }

    public int getBalanceBTC() {
        return balanceBTC;
    }

    public int getBalanceETH() {
        return balanceETH;
    }
}