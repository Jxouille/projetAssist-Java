package org.example.util;

import org.example.model.Passager;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvPassagers {
    private static final String FILE_PATH = "passagers.csv";

    public static void sauvegarderPassagers(List<Passager> passagers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            writer.write("identifiant|nom|adresse|contact|passport");
            writer.newLine();
            for (Passager p : passagers) {
                writer.write(p.getIdentifiant() + "|" +
                        p.getNom() + "|" +
                        p.getAdresse() + "|" +
                        p.getContact() + "|" +
                        p.getPasseport());
                writer.newLine();
            }
            System.out.println("Passagers sauvegardés dans " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des passagers : " + e.getMessage());
        }
    }

    public static List<Passager> chargerPassagers() {
        List<Passager> passagers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Passager p = new Passager(parts[0], parts[1], parts[2], parts[3], parts[4] );
                    passagers.add(p);
                }
            }
            System.out.println(passagers.size() + " passager(s) chargé(s) depuis " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des passagers : "+ e.getMessage());
        }
        return passagers;
    }
}
