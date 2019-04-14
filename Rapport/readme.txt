Section 0: Démarrage de l'application

Section 1: Commandes générales naviguation de menus

    Après l'authentification de l'usager, les commandes suivantes peuvent être 
    utilisées n'importe quand durant l'exécution du programme:
    > quit : termine l'exécution du programme et quitte
    > undo : (ADMIN SEULEMENT) annule l'action la plus récente
    > redo : (ADMIN SEULEMENT) réexécute la dernière action annulée

    Les autres commandes sont contextuelles: il suffit d'entrer dans la console 
    le numéro ou la lettre leur correspondant dans le menu.
    
Section 2: Authentification de l'usager
    
    Avant d'utiliser le système, l'usager doit spécifier s'il est un client 
    régulier ou un administrateur système pour obtenir les options spécifiques 
    à chaque usager.
    
Section 3: Menu principal du client

    Le client a 2 actions principales (précédées d'un chiffre) dans son menu:
    > consulter les voyages disponibles
    > Gérer sa réservation
    
    Sous-section 3.A: Consultation des voyages
        
        Après avoir choisi son mode de transport (Avion, Paquebot, Train), le 
        client devra entrer la ville de départ de son voyage, sa ville de 
        destination, la date de départ désirée et le type de section voulue 
        (F, A, P ou E pour les avions et trains, D, F, S, O ou I pour les 
        paquebots), le système imprime tous les voyages correspondant aux 
        critères spécifiés et renvoit les informations selon le format suivant:
        
        DÉPART-ARRIVÉE:[COMPAGNIE]IdVoyage(DateHeureDépart->DateHeureArrivée)|PRIX|TypeSECTIONNombrePlaceLibres
        
        Le système offrira ensuite à l'usager l'option de réserver une place 
        dans un des voyages retournés ou de faire une nouvelle recherche. Pour 
        réserver, l'usager n'a qu'à entrer dans la console la donnée "IdVoyage" 
        du voyage désiré. Par exemple, pour réserver une place dans le voyage 
        suivant:
        
        CDG-YUL:[AIRCAN]PT1(2019.04.23 09:10->2019.04.23 04:50)|400.0|E100
        
        Le client, après avoir choisi l'option "Réserver une place dans un 
        voyage", n'aura qu'à entrer le code "PT1" dans la console. Après la 
        création de la réservation, le système affichera à l'écran un numéro de 
        réservation que le client devra conserver.
        
    Sous-section 3.B: Gestion de la réservation
        
        Après avoir entré son numéro de réservation (voir sous-section 3.B), le 
        système offrira au client les options suivantes, selon l'état de sa 
        place:
        > Payer la place (PLACE RÉSERVÉE SEULEMENT)
        > Annuler la réservation (PLACE RÉSERVÉE ou CONFIRMÉE)
        > Changer pour une place dans la même section dans un autre voyage 
            effectuant le même trajet à une date différente (PLACE CONFIRMÉE)
        > Changer la classe de la place réservée (PLACE CONFIRMÉE SEULEMENT)
        
        Lors du paiement, le système demandera au client d'entrer les 
        informations requises afin de exécuter le paiement et générer une 
        confirmation de paiement. Le statut de la place deviendra ainsi 
        "CONFIRMÉ". 
        
        Pour modifier la réservation pour une place RÉSERVÉE mais non CONFIRMÉE, 
        le client devra, par raison de sécurité, annuler sa réservation puis 
        effectuer une nouvelle recherche de voyage disponible et réserver la 
        nouvelle place désirée.
        
Section 4 : Menu principal de l'administrateur système

    L'administrateur système peut créer, modifier et supprimer des Stations (
    Aéroports, Gares, Ports), Compagnies, Voyages et Transports (Avions, 
    Paquebots et Trains) et afficher le contenu de la base de données du 
    système.
    
    Pour accéder aux options de gestion des Stations, l'administrateur devra 
    choisir l'option "Station" du menu principal.
