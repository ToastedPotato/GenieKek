package ui;

import java.util.Scanner;

public class ControlAdmin extends Control {

    private Scanner scanner = new Scanner(System.in);

    //String contenant les options de recherche de vol/croisière/trajet de train
    private String findTripMenu = "";

    private String selectTripMenu = "";

    //String contenant les options de gestion de réservation: annuler, payer, etc.
    //private String reservationMenu;

    public ControlAdmin(){
        this.view = new View();
        this.mainMenu = "Bienvenue au système Voyages Kek. Veuillez choisir parmis les options suivantes:\n" +
                "    [1] - Aéroport\n" +
                "    [2] - Compagnie\n" +
                "    [3] - Quitter\n";
        return;
    }

    public void listen(){
        //La boucle d'exécution primaire du contrôleur

        boolean run = true;
        String choice = scanner.next();

        while(run){
            this.view.update(mainMenu);
            this.view.display();

            switch (choice) {
                case "1" : this.findTrip();
                    break;
                case "2" : this.reservationManagement();
                    break;
                case "3" :
                    run = false;
                    System.out.println("Merci d'avoir utilisé notre service.");
                    break;
                default: System.out.println("Choix invalide, veuillez entrer un chiffre de 1 à 3.");
                    break;
            }
        }
        return;
    }

    public void findTrip(){
        //offre les options de recherche de voyage disponibles

        this.view.update(this.findTripMenu);
        this.view.display();
        String searchParams = scanner.next();

        //TODO: traitement des paramètres; splice puis un switch, etc.

        //TODO: appel du visiteur approprié pour lire les voyages disponibles
        String searchResults = "";


        //Options disponibles après recherche: selectionner un voyage, presser "Enter"-> Retour au menu principal
        this.view.update(this.selectTripMenu);
        this.view.display();
        String choice = scanner.next();

        if(!choice.equals("\n") && !choice.equals("\r\n")){
            //TODO: réservation d'un siège selon préférences client
        }

        return;
    }

    public void reservationManagement(){
        //gestion de la réservation du client

        this.view.update("Veuillez entrer votre numéro de réservation.");
        this.view.display();
        String resNumber = scanner.next();

        //TODO: appel du visiteur/itérateur approprié pour lire la liste de réservations

        /*TODO: affichage des infos de la réservation et des options de
            réservation (si disponibles): [1] Annuller [2] Réserver une autre
            place [3] Payer la réservation [4] Retour au menu principal*/

        return;
    }

}

