package fr.paul.game;

public class RouletteGame extends Game {

    private int droppedNumber;
    private int numberOfPlayer;
    private int winnings;
    private int winningsOfPlayer;
    private boolean win;
    private int maxNumberOfWheel = 37;

    public RouletteGame(String name) {
        super(name);
        this.winnings = 2;
        this.win = false;
    }

    @Override
    public void start(Player player) {
        this.menu.player = player; // Set the player for the menu

        while(true) {
            givenABet();
            givenNumber();

            AnimationWait animWait = new AnimationWait();
            animWait.start("Patience, the wheel is turning");

            droppedNumber = (int) (Math.random() * maxNumberOfWheel); // random number 0 to 37

            // Display result for the dropped number
            System.out.println("The dropped number is : " + droppedNumber);

            if(numberOfPlayer <= maxNumberOfWheel) {
                if(numberOfPlayer != droppedNumber) {
                    calculLose();
                    break;
                } else {
                    calculWinnings();
                    break;
                }
            } else {
                System.out.println("Choose a number between 0 and " + maxNumberOfWheel);
                continue;
            }
        }
    }


    @Override
    protected void calculWinnings() {
        win = true;

        if(numberOfPlayer != 0) {
            winningsOfPlayer = getBet() * winnings;
        } else {
            winnings = 4;
            winningsOfPlayer = getBet() * winnings;
        }

        menu.player.setWallet(winningsOfPlayer, win);

        System.out.println("");
        System.out.println("Congratulation !");
        System.out.println("You win " + winningsOfPlayer + "€");
    }

    @Override
    protected void calculLose() {
        if (numberOfPlayer != droppedNumber) {
            winningsOfPlayer = getBet();
            // Effectuer la déduction du portefeuille du joueur
            menu.player.setWallet(winningsOfPlayer, win);
        } else {
            // Réinitialiser winningsOfPlayer à 0 en cas de victoire
            winningsOfPlayer = 0;
        }

        System.out.println("");
        System.out.println("Sorry, you have lost!");
        System.out.println("Your lose " + "-" + getBet() + "€");
        System.out.println("But the next part will be the good part!");
    }

    private void givenNumber() {
        while(true) {
            System.out.println("Choose a number between 0 and 37");
            System.out.print("==> ");
            numberOfPlayer = sc.nextInt();

            if(numberOfPlayer > 37) {
                continue;
            }
            break;
        }
    }
}
