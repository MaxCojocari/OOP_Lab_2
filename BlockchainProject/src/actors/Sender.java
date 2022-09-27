package actors;

public class Sender {
    private String nickname;
    private String favouriteFAFTeacher;
    private int balanceBTC;
    private int balanceETH;

    public Sender(int balanceBTC, int balanceETH) {
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

    public int getBalanceBTC() {
        return balanceBTC;
    }

    public int getBalanceETH() {
        return balanceETH;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFavouriteFAFTeacher() {
        return favouriteFAFTeacher;
    }

}