package fr.paul.game;

import java.util.concurrent.TimeUnit;

public class AnimationWait {

    public void start(String message) {

        System.out.print(message);

        Thread animationThread = new Thread(() -> {
            try {
                // Affiche les points pendant 5 secondes
                for (int i = 0; i < 5; i++) {
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println("");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Rétablit l'état d'interruption
                e.printStackTrace();
            }
        });

        animationThread.start();

        // Attend que le thread d'animation se termine
        try {
            animationThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
