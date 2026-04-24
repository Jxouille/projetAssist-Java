package org.example;

import org.example.model.Aeroport;
import org.example.model.Vol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VolTest {

    private Vol vol;

    @BeforeEach
    void setUp() {
        Aeroport dep = new Aeroport("CDG", "Paris", "Aéroport Charles de Gaulle");
        Aeroport arr = new Aeroport("JFK", "New York", "Aéroport JFK");
        vol = new Vol("AF001", "Paris", "New York", "2025-04-20 10:00", "2025-04-20 13:00", "Planifié", dep, arr);
    }

    @Test
    void testNumeroVol() {
        assertEquals("AF001", vol.getNumeroVol());
    }

    @Test
    void testOrigine() {
        assertEquals("Paris", vol.getOrigine());
    }

    @Test
    void testDestination() {
        assertEquals("New York", vol.getDestination());
    }

    @Test
    void testEtatInitial() {
        assertEquals("Planifié", vol.getEtat());
    }

    @Test
    void testAnnulerVol() {
        vol.annulerVol();
        assertEquals("Annulé", vol.getEtat());
    }

    @Test
    void testModifierVol() {
        vol.modifierVol("2025-04-21 10:00", "2025-04-21 13:00");
        assertEquals("2025-04-21 10:00", vol.getDateHeureDepart());
        assertEquals("2025-04-21 13:00", vol.getDateHeureArrivee());
    }
}