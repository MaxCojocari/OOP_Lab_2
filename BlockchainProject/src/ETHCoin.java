public class ETHCoin {
    private String name;
    private String symbol;
    private int totalSupply;

    public ETHCoin(int totalSupply) {
        this.name = "Ethereum";
        this.symbol = "ETH";
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
