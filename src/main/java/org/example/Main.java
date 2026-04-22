package org.example;

import org.example.model.*;

public class Main {
    static void main() {

        Aeroport cdg = new Aeroport("Charles de Gaulle", "Paris", "Aéroport principal de Paris");
        Aeroport jfk = new Aeroport("JFK", "New York", "Aéroport international de New York");

        Avion avion = new Avion("F-GKXJ", "Airbus A320", 180);

        Vol vol = new Vol("AF001", "Paris", "New York", "2025-04-20 10:00", "2025-04-20 13:00", "Planifié", cdg, jfk);

        Pilote pilote = new Pilote("P007", "Steinhart Axel", "Paris", "0678563574", "EMP007","2005-03-28", "ATPL", 20000);

        PersonnelCabine cabine = new PersonnelCabine("C008", "Lim Jimmy", "Fitness Park", "0789654275", "EMP008", "2020-04-22", "Hôte" );

        Passager passager = new Passager("PA666", "Lopez Romain", "Saulx les chartreux", "0766666799","FR666777");

        Reservation reservation = new Reservation("RES001", "2026-06-20", passager);
        reservation.ajouterVol(vol);
        reservation.confirmerReservation();
        passager.reserverVol(reservation);

        avion.affecterVol(vol);
        pilote.affecterVol(vol);
        cabine.affecterVol(vol);

        System.out.println("\n--- Infos Vol ---");
        vol.obtenirInfos();

        System.out.println("\n--- Infos Passager ---");
        passager.obtenirInfos();

        System.out.println("\n--- Infos Réservation ---");
        reservation.obtenirInfos();

        System.out.println("\n--- Listing Passagers du vol ---");
        vol.listingPassagers();

    }
}
