package ui;

import trip.Trip;
import ui.Control;
import ui.ControlAdmin;
import ui.ControlClient;
import ui.DataBase;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SystemMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataBase.getInstance().init();
        choice();
    }

    public static void choice() {
        String choice;
        do {
            System.out.println(Console.menu("Système de réservation de voyages"));
            System.out.println("Bienvenue, quel type d'utilisateur êtes-vous ?");
            System.out.println("[1] " + Console.colorize(Console.BLUE, "Client"));
            System.out.println("[2] " + Console.colorize(Console.BLUE, "Administrateur"));
            System.out.print("\n> ");
            choice = scanner.next();
            if (choice.equals("2")) new ControlAdmin();
            else new ControlClient();
        } while (!choice.equals("quit"));
    }
}
