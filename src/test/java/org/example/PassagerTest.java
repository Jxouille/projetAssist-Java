package org.example;

import org.example.model.Aeroport;
import org.example.model.Passager;
import org.example.model.Reservation;
import org.example.model.Vol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassagerTest {

    private Passager passager;
    private Reservation reservation;

    @BeforeEach
    void setUp() {
        passager = new Passager("PA001", "Durand Pierre", "Marseille", "0600000001", "AB123456");
        Aeroport dep = new Aeroport("CDG", "Paris", "");
        Aeroport arr = new Aeroport("JFK", "New York", "");
        Vol vol = new Vol("AF001", "Paris", "New York", "2025-04-20 10:00", "2025-04-20 13:00", "Planifié", dep, arr);
        reservation = new Reservation("RES001", "2025-04-01", passager);
        reservation.ajouterVol(vol);
    }

    @Test
    void testNomPassager() {
        assertEquals("Durand Pierre", passager.getNom());
    }

    @Test
    void testPasseport() {
        assertEquals("AB123456", passager.getPasseport());
    }

    @Test
    void testReserverVol() {
        passager.reserverVol(reservation);
        assertEquals(1, passager.getReservations().size());
    }

    @Test
    void testAnnulerReservation() {
        passager.reserverVol(reservation);
        passager.annulerReservation("RES001");
        assertEquals(0, passager.getReservations().size());
    }

    @Test
    void testIdentifiant() {
        assertEquals("PA001", passager.getIdentifiant());
    }
}