package fr.paul.game;

import java.io.IOException;

public class ClearTerminal {

    public static void clear() {

        System.out.println("Coucou");
        try {
            String os = System.getProperty("os.name").toLowerCase();

            Process process;
            if (os.contains("win")) {
                // Pour Windows
                process = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
            } else {
                // Pour MacOS et Linux
                process = new ProcessBuilder("clear").inheritIO().start();
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.out.println("Clearing the terminal failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
