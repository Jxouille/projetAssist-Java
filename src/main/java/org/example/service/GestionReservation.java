package org.example.service;

import org.example.model.Reservation;
import org.example.model.Passager;
import org.example.model.Vol;
import java.util.ArrayList;
import java.util.List;

public class GestionReservation {
    private List<Reservation> reservations;

    public  GestionReservation() {
        this.reservations = new ArrayList<>();
    }

    public void ajouterReservations( Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Réservation " + reservation.getNumeroReservation() + " ajoutée.");
    }

    public Reservation chercherReservation(String numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) {
                return r;
            }
        }
        System.out.println("Réservation " + numeroReservation + " introuvable.");
        return null;
    }

    public void modifierReservation(String numeroReservation, String nouvelleDateReservation) {
        Reservation reservation = chercherReservation(numeroReservation);
        if (reservation != null) {
            reservation.modifierReservation(nouvelleDateReservation);
        }
    }

    public void supprimerReservation(String numeroReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getNumeroReservation().equals(numeroReservation)){
                reservations.remove(i);
                System.out.println("Réservation " + numeroReservation + " supprimée.");
                return;
            }
        }
        System.out.println("Reservation " + numeroReservation + " introuvable.");
    }

    public void annulerReservation(String numeroReservation) {
        Reservation reservation = chercherReservation(numeroReservation);
        if (reservation != null) {
            reservation.annulerReservation();
        }
    }

    public void confirmerReservation(String numeroReservation) {
        Reservation reservation = chercherReservation(numeroReservation);
        if (reservation != null) {
            reservation.confirmerReservation();
        }
    }

    public void listerReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation enregistrée.");
        } else {
            System.out.println("--- Liste des réservations ---");
            for (Reservation r : reservations) {
                r.obtenirInfos();
                System.out.println("---");
            }
        }
    }



}
