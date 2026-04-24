package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static GestionVols gestionVols = new GestionVols();
    static GestionReservation gestionReservations = new GestionReservation();
    static GestionPassagers gestionPassagers = new GestionPassagers();
    static GestionAvions gestionAvions = new GestionAvions();
    static GestionEmployes gestionEmployes = new GestionEmployes();

    public static void main(String[] args) {
        int choix = -1;
        while (choix != 0) {
            System.out.println("\n=== Système de réservation aérienne ===");
            System.out.println("1. Gestion des vols");
            System.out.println("2. Gestion des réservations");
            System.out.println("3. Gestion des passagers");
            System.out.println("4. Gestion des avions");
            System.out.println("5. Gestion des employés");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: menuVols(); break;
                case 2: menuReservations(); break;
                case 3: menuPassagers(); break;
                case 4: menuAvions(); break;
                case 5: menuEmployes(); break;
                case 0: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide.");
            }
        }
    }

    // Menu Vols
    static void menuVols() {
        System.out.println("\n--- Gestion des vols ---");
        System.out.println("1. Ajouter un vol");
        System.out.println("2. Chercher un vol");
        System.out.println("3. Modifier un vol");
        System.out.println("4. Supprimer un vol");
        System.out.println("5. Annuler un vol");
        System.out.println("6. Lister tous les vols");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Numéro de vol : ");
                String numeroVol = scanner.nextLine();
                System.out.print("Origine : ");
                String origine = scanner.nextLine();
                System.out.print("Destination : ");
                String destination = scanner.nextLine();
                System.out.print("Date/heure départ : ");
                String depart = scanner.nextLine();
                System.out.print("Date/heure arrivée : ");
                String arrivee = scanner.nextLine();
                System.out.print("Nom aéroport départ : ");
                String nomAeroportDepart = scanner.nextLine();
                System.out.print("Nom aéroport arrivée : ");
                String nomAeroportArrivee = scanner.nextLine();
                Aeroport aeroportDepart = new Aeroport(nomAeroportDepart, origine, "");
                Aeroport aeroportArrivee = new Aeroport(nomAeroportArrivee, destination, "");
                Vol vol = new Vol(numeroVol, origine, destination, depart, arrivee, "Planifié", aeroportDepart, aeroportArrivee);
                gestionVols.ajouterVol(vol);
                break;
            case 2:
                System.out.print("Numéro de vol : ");
                String numVol = scanner.nextLine();
                Vol v = gestionVols.chercherVol(numVol);
                if (v != null) v.obtenirInfos();
                break;
            case 3:
                System.out.print("Numéro de vol : ");
                String numVolModif = scanner.nextLine();
                System.out.print("Nouvelle date/heure départ : ");
                String newDepart = scanner.nextLine();
                System.out.print("Nouvelle date/heure arrivée : ");
                String newArrivee = scanner.nextLine();
                gestionVols.modifierVol(numVolModif, newDepart, newArrivee);
                break;
            case 4:
                System.out.print("Numéro de vol : ");
                String numVolSupp = scanner.nextLine();
                gestionVols.supprimerVol(numVolSupp);
                break;
            case 5:
                System.out.print("Numéro de vol : ");
                String numVolAnnul = scanner.nextLine();
                gestionVols.annulerVol(numVolAnnul);
                break;
            case 6:
                gestionVols.listerVols();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    // Menu Réservations
    static void menuReservations() {
        System.out.println("\n--- Gestion des réservations ---");
        System.out.println("1. Ajouter une réservation");
        System.out.println("2. Chercher une réservation");
        System.out.println("3. Modifier une réservation");
        System.out.println("4. Supprimer une réservation");
        System.out.println("5. Confirmer une réservation");
        System.out.println("6. Annuler une réservation");
        System.out.println("7. Lister toutes les réservations");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Numéro de réservation : ");
                String numRes = scanner.nextLine();
                System.out.print("Date de réservation : ");
                String dateRes = scanner.nextLine();
                System.out.print("Identifiant passager : ");
                String idPassager = scanner.nextLine();
                Passager passager = gestionPassagers.chercherPassager(idPassager);
                if (passager != null) {
                    System.out.print("Numéro de vol : ");
                    String numVol = scanner.nextLine();
                    Vol vol = gestionVols.chercherVol(numVol);
                    if (vol != null) {
                        Reservation reservation = new Reservation(numRes, dateRes, passager);
                        reservation.ajouterVol(vol);
                        gestionReservations.ajouterReservations(reservation);
                        passager.reserverVol(reservation);
                    }
                }
                break;
            case 2:
                System.out.print("Numéro de réservation : ");
                String numResSearch = scanner.nextLine();
                Reservation r = gestionReservations.chercherReservation(numResSearch);
                if (r != null) r.obtenirInfos();
                break;
            case 3:
                System.out.print("Numéro de réservation : ");
                String numResModif = scanner.nextLine();
                System.out.print("Nouvelle date : ");
                String newDate = scanner.nextLine();
                gestionReservations.modifierReservation(numResModif, newDate);
                break;
            case 4:
                System.out.print("Numéro de réservation : ");
                String numResSupp = scanner.nextLine();
                gestionReservations.supprimerReservation(numResSupp);
                break;
            case 5:
                System.out.print("Numéro de réservation : ");
                String numResConf = scanner.nextLine();
                gestionReservations.confirmerReservation(numResConf);
                break;
            case 6:
                System.out.print("Numéro de réservation : ");
                String numResAnnul = scanner.nextLine();
                gestionReservations.annulerReservation(numResAnnul);
                break;
            case 7:
                gestionReservations.listerReservations();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    // Menu Passagers
    static void menuPassagers() {
        System.out.println("\n--- Gestion des passagers ---");
        System.out.println("1. Ajouter un passager");
        System.out.println("2. Chercher un passager");
        System.out.println("3. Modifier un passager");
        System.out.println("4. Supprimer un passager");
        System.out.println("5. Lister tous les passagers");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Identifiant : ");
                String id = scanner.nextLine();
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Adresse : ");
                String adresse = scanner.nextLine();
                System.out.print("Contact : ");
                String contact = scanner.nextLine();
                System.out.print("Passeport : ");
                String passeport = scanner.nextLine();
                gestionPassagers.ajouterPassager(new Passager(id, nom, adresse, contact, passeport));
                break;
            case 2:
                System.out.print("Identifiant : ");
                String idSearch = scanner.nextLine();
                Passager p = gestionPassagers.chercherPassager(idSearch);
                if (p != null) p.obtenirInfos();
                break;
            case 3:
                System.out.print("Identifiant : ");
                String idModif = scanner.nextLine();
                System.out.print("Nouveau nom : ");
                String newNom = scanner.nextLine();
                System.out.print("Nouvelle adresse : ");
                String newAdresse = scanner.nextLine();
                System.out.print("Nouveau contact : ");
                String newContact = scanner.nextLine();
                System.out.print("Nouveau passeport : ");
                String newPasseport = scanner.nextLine();
                gestionPassagers.modifierPassager(idModif, newNom, newAdresse, newContact, newPasseport);
                break;
            case 4:
                System.out.print("Identifiant : ");
                String idSupp = scanner.nextLine();
                gestionPassagers.supprimerPassager(idSupp);
                break;
            case 5:
                gestionPassagers.listerPassagers();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    // Menu Avions
    static void menuAvions() {
        System.out.println("\n--- Gestion des avions ---");
        System.out.println("1. Ajouter un avion");
        System.out.println("2. Chercher un avion");
        System.out.println("3. Modifier un avion");
        System.out.println("4. Supprimer un avion");
        System.out.println("5. Lister tous les avions");
        System.out.println("6. Lister les avions disponibles");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Immatriculation : ");
                String immat = scanner.nextLine();
                System.out.print("Modèle : ");
                String modele = scanner.nextLine();
                System.out.print("Capacité : ");
                int capacite = scanner.nextInt();
                scanner.nextLine();
                gestionAvions.ajouterAvion(new Avion(immat, modele, capacite));
                break;
            case 2:
                System.out.print("Immatriculation : ");
                String immatSearch = scanner.nextLine();
                Avion a = gestionAvions.ChercherAvion(immatSearch);
                if (a != null) a.obtenirInfos();
                break;
            case 3:
                System.out.print("Immatriculation : ");
                String immatModif = scanner.nextLine();
                System.out.print("Nouveau modèle : ");
                String newModele = scanner.nextLine();
                System.out.print("Nouvelle capacité : ");
                int newCapacite = scanner.nextInt();
                scanner.nextLine();
                gestionAvions.modifierAvion(immatModif, newModele, newCapacite);
                break;
            case 4:
                System.out.print("Immatriculation : ");
                String immatSupp = scanner.nextLine();
                gestionAvions.supprimerAvion(immatSupp);
                break;
            case 5:
                gestionAvions.listerAvions();
                break;
            case 6:
                gestionAvions.listerAvionsDisponibles();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    static void menuEmployes() {
        System.out.println("\n--- Gestion des employés ---");
        System.out.println("1. Ajouter un pilote");
        System.out.println("2. Ajouter un personnel cabine");
        System.out.println("3. Chercher un employé (obtenir rôle)");
        System.out.println("4. Supprimer un pilote");
        System.out.println("5. Supprimer un personnel cabine");
        System.out.println("6. Affecter un équipage à un vol");
        System.out.println("7. Lister tous les employés");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Identifiant : ");
                String id = scanner.nextLine();
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Adresse : ");
                String adresse = scanner.nextLine();
                System.out.print("Contact : ");
                String contact = scanner.nextLine();
                System.out.print("Numéro employé : ");
                String numEmp = scanner.nextLine();
                System.out.print("Date embauche : ");
                String dateEmb = scanner.nextLine();
                System.out.print("Licence : ");
                String licence = scanner.nextLine();
                System.out.print("Heures de vol : ");
                int heures = scanner.nextInt();
                scanner.nextLine();
                gestionEmployes.ajouterPilote(new Pilote(id, nom, adresse, contact, numEmp, dateEmb, licence, heures));
                break;
            case 2:
                System.out.print("Identifiant : ");
                String id2 = scanner.nextLine();
                System.out.print("Nom : ");
                String nom2 = scanner.nextLine();
                System.out.print("Adresse : ");
                String adresse2 = scanner.nextLine();
                System.out.print("Contact : ");
                String contact2 = scanner.nextLine();
                System.out.print("Numéro employé : ");
                String numEmp2 = scanner.nextLine();
                System.out.print("Date embauche : ");
                String dateEmb2 = scanner.nextLine();
                System.out.print("Qualification : ");
                String qualif = scanner.nextLine();
                gestionEmployes.ajouterPersonnelCabine(new PersonnelCabine(id2, nom2, adresse2, contact2, numEmp2, dateEmb2, qualif));
                break;
            case 3:
                System.out.print("Identifiant : ");
                String idRole = scanner.nextLine();
                System.out.println("Rôle : " + gestionEmployes.obtenirRole(idRole));
                break;
            case 4:
                System.out.print("Identifiant : ");
                String idSupp = scanner.nextLine();
                gestionEmployes.supprimerPilote(idSupp);
                break;
            case 5:
                System.out.print("Identifiant : ");
                String idSupp2 = scanner.nextLine();
                gestionEmployes.supprimerPersonnelCabine(idSupp2);
                break;
            case 6:
                System.out.print("Identifiant pilote : ");
                String idPilote = scanner.nextLine();
                System.out.print("Identifiant personnel cabine : ");
                String idPersonnel = scanner.nextLine();
                System.out.print("Numéro de vol : ");
                String numVol = scanner.nextLine();
                Vol vol = gestionVols.chercherVol(numVol);
                if (vol != null) {
                    gestionEmployes.affecterEquipage(idPilote, idPersonnel, vol);
                }
                break;
            case 7:
                gestionEmployes.listerEmployes();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }
}