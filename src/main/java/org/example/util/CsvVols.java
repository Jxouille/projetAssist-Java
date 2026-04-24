package org.example.util;

import org.example.model.Aeroport;
import org.example.model.Vol;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvVols {
    private static final String FILE_PATH = "vols.csv";

    public static void sauvegarderVols(List<Vol> vols) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            writer.write("numeroVol|origine|destination|dateHeureDepart|dateHeureArrivee|etat");
            writer.newLine();
            for (Vol v : vols) {
                writer.write(v.getNumeroVol() + "|" +
                        v.getOrigine() + "|" +
                        v.getDestination() + "|" +
                        v.getDateHeureDepart() + "|" +
                        v.getDateHeureArrivee() + "|" +
                        v.getEtat());
                writer.newLine();
            }
            System.out.println("Vols sauvegardés dans " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des vols : " + e.getMessage());
        }
    }

    public static List<Vol> chargerVols() {
        List<Vol> vols = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    Aeroport dep = new Aeroport(parts[1],parts[1], "" );
                    Aeroport arr = new Aeroport(parts[2], parts[2], "" );
                    Vol vol = new Vol(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], dep, arr );
                    vols.add(vol);
                }
            }
            System.out.println(vols.size() + " vol(s) chargé(s) depuis " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des vols : " + e.getMessage());
        }
        return vols;
    }
}
