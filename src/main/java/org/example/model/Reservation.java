package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String numeroReservation;
    private String dateReservation;
    private String statut;
    private Passager passager;
    private List<Vol> vols;

    public Reservation(String numeroReservation, String dateReservation, Passager passager) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = "En attente";
        this.passager= passager;
        this.vols = new ArrayList<>();
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public Passager getPassager() {
        return passager;
    }

    public List<Vol> getVols() {
        return vols;
    }

    public void setNumeroReservation(String numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void ajouterVol(Vol vol) {
        vols.add(vol);
        vol.ajouterPassager(passager);
    }

    public void confirmerReservation() {
        this.statut = "Confirmée";
        System.out.println("Réservation " + numeroReservation + " confirmée.");
    }

    public void annulerReservation() {
        this.statut = "Annulée";
        System.out.println("Réservation " + numeroReservation + " annulée.");
    }

    public void modifierReservation(String nouvelleDateReservation) {
        this.dateReservation = nouvelleDateReservation;
        System.out.println("Réservation " + numeroReservation + " modifée.");
    }

    public void obtenirInfos() {
        System.out.println("Numéro réservation: " + numeroReservation);
        System.out.println("Date: " + dateReservation);
        System.out.println("Statut: " + statut);
        System.out.println("Passager: " + passager.getNom());
        System.out.println("Vols réservés:");
        for (Vol v : vols) {
            v.obtenirInfos();
        }
    }
}
