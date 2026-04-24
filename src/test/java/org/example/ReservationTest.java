package org.example;

import org.example.model.Aeroport;
import org.example.model.Passager;
import org.example.model.Reservation;
import org.example.model.Vol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation reservation;
    private Passager passager;
    private Vol vol;

    @BeforeEach
    void setUp() {
        passager = new Passager("PA001", "Durand Pierre", "Marseille", "0600000001", "AB123456");
        Aeroport dep = new Aeroport("CDG", "Paris", "");
        Aeroport arr = new Aeroport("JFK", "New York", "");
        vol = new Vol("AF001", "Paris", "New York", "2025-04-20 10:00", "2025-04-20 13:00", "Planifié", dep, arr);
        reservation = new Reservation("RES001", "2025-04-01", passager);
    }

    @Test
    void testNumeroReservation() {
        assertEquals("RES001", reservation.getNumeroReservation());
    }

    @Test
    void testStatutInitial() {
        assertEquals("En attente", reservation.getStatut());
    }

    @Test
    void testConfirmerReservation() {
        reservation.confirmerReservation();
        assertEquals("Confirmée", reservation.getStatut());
    }

    @Test
    void testAnnulerReservation() {
        reservation.annulerReservation();
        assertEquals("Annulée", reservation.getStatut());
    }

    @Test
    void testModifierReservation() {
        reservation.modifierReservation("2025-05-01");
        assertEquals("2025-05-01", reservation.getDateReservation());
    }

    @Test
    void testAjouterVol() {
        reservation.ajouterVol(vol);
        assertEquals(1, reservation.getVols().size());
    }

    @Test
    void testPassager() {
        assertEquals("Durand Pierre", reservation.getPassager().getNom());
    }
}