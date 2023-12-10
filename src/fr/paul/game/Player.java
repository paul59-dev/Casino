package fr.paul.game;

public class Player {

    private String name;
    private int wallet;

    public Player() {
        this.wallet = 2000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int winnings, boolean isWin) {
        if(isWin) {
            wallet += winnings;
        } else {
            wallet -= winnings;
        }
    }
}
