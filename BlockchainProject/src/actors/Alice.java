package actors;

public class Alice {
    public String nickname;
    public String favouriteFAFTeacher;
    private int balanceBTC;
    private int balanceETH;

    public Alice(int balanceBTC, int balanceETH) {
        this.nickname = "JuicyCat";
        this.favouriteFAFTeacher = "A.Vdovicenco";
        this.balanceBTC = balanceBTC;
        this.balanceETH = balanceETH;
    }

    public boolean sendBTC(int amount, String to) {
        if (balanceBTC <= amount || amount <= 0) return false;
        balanceBTC -= amount;
        return true;
    }

    public boolean sendETH(int amount, String to) {
        if (balanceETH <= amount || amount <= 0) return false;
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

    public int getBalanceBTC() {
        return balanceBTC;
    }

    public int getBalanceETH() {
        return balanceETH;
    }

}