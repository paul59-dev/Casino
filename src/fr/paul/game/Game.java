package fr.paul.game;

import java.util.Scanner;

public abstract class Game {

    private String name;
    private int bet;
    protected final Scanner sc = new Scanner(System.in);
    protected Menu menu;

    public Game() { }

    public Game(String name) {
        this.name = name;
        this.menu = new Menu();
    }

    public String getName() {
        return name;
    }

    public int getBet() {
        return bet;
    }

    public abstract void start(Player player);
    protected abstract void calculWinnings();
    protected abstract void calculLose();

    protected void givenABet() {
        while(true) {
            System.out.print("Place your bet: ");

            if(sc.hasNextInt()) {
                bet = sc.nextInt();

                if(bet > menu.player.getWallet()) {
                    System.out.println("You can't bet above your wallet !");
                    continue;
                }
            }
            break;
        }
    }
}
