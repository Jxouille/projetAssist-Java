package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
    private String passeport;
    private List<Reservation> reservations;

    public Passager (String identifiant, String nom, String adresse, String contact, String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
        this.reservations = new ArrayList<>();
    }

    public String getPasseport () {
        return passeport;
    }

    public  List<Reservation> getReservations () {
        return reservations;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }

    public void reserverVol(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Vol réservé avec succès pour " + getNom());
    }

    public void annulerReservation(String numeroReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            if (r.getNumeroReservations().equals(numeroReservation)) {
                reservations.remove(i);
                System.out.println("Réservation " + numeroReservation + " annulée.");
                return;
            }
        }
    }

    public void obtenirReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation");
        } else {
            for (Reservation r : reservations) {
                r.obtenirInfos();
            }
        }
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Passeport: " + passeport);
    }
}
