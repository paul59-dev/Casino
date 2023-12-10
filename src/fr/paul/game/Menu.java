package fr.paul.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public Player player;
    private final Scanner sc;
    private final List<Game> games;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.games = new ArrayList<>();
        this.player = new Player();
    }

    public void showMenu() {

        boolean play = true;

        System.out.println("What your name ?");
        System.out.print("==> ");
        String name = sc.nextLine();

        player.setName(name);

        RouletteGame rouletteGame = new RouletteGame("The roulette");
        games.add(rouletteGame);

        while(play) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("========== Welcome to the KaZiNo ==========");
            System.out.println(player.getName() + ", what do you want to play today ?");

            System.out.println("0. Show your wallet.");
            for(int i=0; i<games.size(); i++) {
                System.out.println((i+1) + ". " + games.get(i).getName());
            }

            System.out.print("Your choise: ");
            int choise = sc.nextInt();

            switch(choise) {
                case 0:
                    showInfoPlayer();
                    break;
                case 1:
                    rouletteGame.start(player);
                    AnimationWait animWait = new AnimationWait();
                    animWait.start("");
                    break;
                default:
                    System.out.println("Please, choose the number between 0 and " + games.size());
            }

            if(player.getWallet() == 0) {
                System.out.println("You're out of money !");
                break;
            }
        }
    }

    private void showInfoPlayer() {
        System.out.println("Name: " + player.getName());
        System.out.println("Wallet: " + player.getWallet() + "€");
    }
}
