public class BTCCoin {
    private String name;
    private String symbol;
    private int totalSupply;

    public BTCCoin(int totalSupply) {
        this.name = "Bitcoin";
        this.symbol = "BTC";
        this.totalSupply = totalSupply;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getTotalSupply() {
        return totalSupply;
    }
}
