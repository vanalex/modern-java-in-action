package chapter10.model;

public class Stock {

    private String symbol;
    private String market;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol( String symbol ) {
        this.symbol = symbol;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket( String market ) {
        this.market = market;
    }

    @Override
    public String toString() {
        return String.format("Stock[symbol=%s, market=%s]", symbol, market);
    }
}
