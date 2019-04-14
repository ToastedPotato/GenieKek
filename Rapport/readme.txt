Section 0: Démarrage de l'application

    Exécution à partir d'un IDE:
        Le point d'entrée (méthode "main") est situé dans la class "SystemMain". 
        Vous pouvez simplement ouvrir cette classe dans votre IDE et cliquer sur 
        le bouton "exécuter" (le chevron vert dans la barre de tâches de l'IDE).
        
    Exécution à partir du terminal:
        Sous Linux (et possiblement MacOS), vous pouvez utiliser l'outil "make" 
        à partir du terminal afin de compiler et exécuter l'application. 
        À partir du répertoire "code" du dossier de remise, exécutez dans votre 
        terminal la commande "make" (un raccourci pour l'appel consécutif des 
        commandes "make build" et "make run") prédéfinie dans le makefile 
        fourni avec le projet.
        
        N.B.: vous pouvez ajouter l'option silencieux "-s" ("make -s" par 
        exemple) aux commandes de make pour alléger le texte généré dans votre 
        terminal
    
    Exécution à partir d'une archive .jar:
        *En construction*     
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

    Sous-section 4.A.: Navigation des menus Administrateur
    
        L'administrateur système peut créer, modifier et supprimer des Stations 
        (Aéroports, Gares, Ports), Compagnies, Voyages et Transports (Avions, 
        Paquebots et Trains) et afficher le contenu de la base de données du 
        système.

        Pour accéder aux options de gestion des Stations, l'administrateur devra 
        choisir l'option "Station" du menu principal.

        Pour accéder aux options de gestion de Compagnies, Voyages et 
        Transports, il faut sélectionner l'option "Compagnie". Le sous-menu 
        offrira ensuite les options de création, modification, suppression, 
        gestion et affichage des compagnies présentes dans la base de données. 

        Les Voyages et Transports étant des composantes d'une compagnie, avant 
        de pouvoir accéder à leurs options administratives, il faudra d'abord 
        choisir l'option "Gestion d'une compagnie" puis entrer l'identifiant de 
        la Compagnie dont vous voulez gérer les Voyages et Transports.

        Pour voir le résultat des actions d'administration du point de vue 
        d'un client régulier, il faut retourner au menu d'authentification du 
        système puis s'authentifier en mode "client" (voir Section 2).
    
    Sous-section 4.B.: Format d'affichage des information en mode Administrateur
        
        Veuillez prendre note du format de l'affichage des différentes entités:
        
        > Affichage des Stations
        
        [IDENTIFIANT] Ville            | Exemple: [YUL] Montréal
        
        > Affichage des Compagnies
        
        [IDENTIFIANT] Nom, Prix        | Exemple:[STMGRP] STM Groupe, prix: $400

        > Affichage des Voyages
        
        DÉPART-ARRIVÉE:[COMPAGNIE]IdVoyage(DateHeureDépart->DateHeureArrivée)|TypeSECTIONConfiguration(PlacesReservées/TotalPlaces)PRIX
        
        Exemple: CDG-YUL:[AIRCAN]PT1(2019.04.23 09:10->2019.04.23 04:50)|EL(0/100)400.0
        
        Exemple: CDG-YUL:[AIRCAN]KO4(2019.04.24 10:50->2019.04.24 06:24)|EL(0/140)400.0|AM(0/60)600.0

        > Affichage des Transports
        
        IDENTIFIANT|TypeSECTIONConfigurationTotalPlaces 
        
        Exemple: A45|EL100
        
        Exemple: A48|EL140|AM60
