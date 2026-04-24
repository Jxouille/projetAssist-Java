package org.example.util;

import org.example.model.Passager;
import org.example.model.Reservation;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReservations {
    private static final String FILE_PATH = "reservations.csv";

    public static void sauvegarderReservations(List<Reservation> reservations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            writer.write("numeroReservation|dateReservation|statut|idPassager|nomPassager");
            writer.newLine();
            for (Reservation r : reservations) {
                writer.write(r.getNumeroReservation() + "|" +
                        r.getDateReservation() + "|" +
                        r.getStatut() + "|" +
                        r.getPassager().getIdentifiant() + "|" +
                        r.getPassager().getNom());
                writer.newLine();
            }
            System.out.println("Réservations sauvegardées dans " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des réservations : " + e.getMessage());
        }
    }

    public static List<Reservation> chargerReservations(List<Passager> passagers) {
        List<Reservation> reservations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; }
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Passager passager = null;
                    for (Passager p : passagers) {
                        if (p.getIdentifiant().equals(parts[3])) {
                            passager = p;
                            break;
                        }
                    }
                    if (passager != null) {
                        Reservation r = new Reservation(parts[0], parts[1], passager);
                        r.setStatut(parts[2]);
                        reservations.add(r);
                    }
                }
            }
            System.out.println(reservations.size() + " réservation(s) chargée(s) depuis " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des réservations : " + e.getMessage());
        }
        return reservations;
    }
}
