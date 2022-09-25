package actors;

public class John {
    private String favouriteFood;
    private String email;
    private int balanceBTC;
    private int balanceETH;

    public John(int balanceBTC, int balanceETH) {
        this.favouriteFood = "Pizza";
        this.email = "john@gmail.com";
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

    public int getBalanceBTC() {
        return balanceBTC;
    }

    public int getBalanceETH() {
        return balanceETH;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getEmail() {
        return email;
    }
}
