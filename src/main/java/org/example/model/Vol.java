package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;
    private Aeroport aeroportDepart;
    private Aeroport aeroportArrivee;
    private List<Passager> passagers;

    public Vol (String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee, String etat, Aeroport aeroportDepart, Aeroport aeroportArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
        this.passagers = new ArrayList<>();
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public String getEtat() {
        return etat;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public Aeroport getAeroportArrivee() {
        return aeroportArrivee;
    }

    public List<Passager> getPassagers() {
        return passagers;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void planifierVol() {
        System.out.println("Vol " + numeroVol + " planifié de " + origine + " vers " + destination);
    }

    public void annulerVol() {
        this.etat = "Annulé";
        System.out.println("Vol " + numeroVol + " annulé.");
    }

    public void modifierVol(String dateHeureDepart, String dateHeureArrivee) {
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        System.out.println("Vol " + numeroVol + " modifié.");
    }

    public void listingPassagers() {
        if (passagers.isEmpty()) {
            System.out.println("Aucun passager sur ce vol.");
        } else {
            System.out.println("Passagers du vol " + numeroVol + " : ");
            for (Passager p : passagers) {
                p.obtenirInfos();
            }
        }
    }

    public void ajouterPassager(Passager passager) {
        passagers.add(passager);
    }

    public void obtenirInfos() {
        System.out.println("Vol: " + numeroVol);
        System.out.println("Origine: " + origine);
        System.out.println("Destination: " + destination);
        System.out.println("Départ: " + dateHeureDepart);
        System.out.println("Arrivée: " + dateHeureArrivee);
        System.out.println("Etat: " + etat);
    }
}
