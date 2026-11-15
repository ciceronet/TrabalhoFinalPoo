package ui;

import java.util.Scanner;

public final class Entrada {
    public static final Scanner SC = new Scanner(System.in);

    private Entrada() {}

    public static String lerLinha() {
        if (!SC.hasNextLine()) {
            System.out.println("\nEntrada encerrada. Saindo do sistema.");
            System.exit(0);
        }
        return SC.nextLine().trim();
    }

    public static int lerInt() {
        try {
            return Integer.parseInt(lerLinha());
        } catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }
}
