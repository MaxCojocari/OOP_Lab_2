package core;

public class Transaction {
    private String sender;
    private String receiver;
    private String assetSymbol;
    private int amount;
    private boolean checked;

    public Transaction(String sender, String receiver, String assetName, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.assetSymbol = assetName;
        this.amount = amount;
        this.checked = false;
    }

    public String getTransactionInfo() {
        String s = "Sender:\t\t" + sender + "\n";
        s += "Receiver:\t" + receiver + "\n";
        s += "Amount:\t\t" + amount + " " + assetSymbol;
        return s;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getAssetSymbol() {
        return assetSymbol;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked() {
        this.checked = true;
    }
}