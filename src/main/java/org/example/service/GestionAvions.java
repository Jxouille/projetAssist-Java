package org.example.service;

import org.example.model.Avion;
import java.util.ArrayList;
import java.util.List;

public class GestionAvions {
    private List<Avion> avions;

    public GestionAvions() {
        this.avions = new ArrayList<>();
    }

    public void ajouterAvion(Avion avion) {
        avions.add(avion);
        System.out.println("Avion " + avion.getImmatriculation() + " ajouté");
    }

    public Avion ChercherAvion(String immatriculation) {
        for (Avion a : avions) {
            if (a.getImmatriculation().equals(immatriculation)) {
                return a;
            }
        }
        System.out.println("Avion " + immatriculation + " intouvable.");
        return null;
    }

    public void modifierAvion(String immatriculation, String modele, int capacite) {
        Avion avion = ChercherAvion(immatriculation);
        if (avion != null) {
            avion.setModele(modele);
            avion.setCapacite(capacite);
            System.out.println("Avion " + immatriculation + " modifié.");
        }
    }

    public void supprimerAvion(String immatriculation) {
        for (int i = 0; i < avions.size(); i++) {
            if (avions.get(i).getImmatriculation().equals(immatriculation)) {
                avions.remove(i);
                System.out.println("Avion " + immatriculation + " supprimé.");
                return;
            }
        }
        System.out.println("Avion " + immatriculation + " introuvable");
    }

    public void listerAvionsDisponibles() {
        boolean found = false;
        System.out.println("--- Avions disponibles ---");
        for (Avion a : avions) {
            if (a.isDisponible()) {
                a.obtenirInfos();
                System.out.println("---");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun avion disponible.");
        }
    }

    public void listerAvions() {
        if (avions.isEmpty()) {
            System.out.println("Aucun avion enregistré.");
        } else {
            System.out.println("--- Liste des avions ---");
            for (Avion a : avions) {
                a.obtenirInfos();
                System.out.println("---");
            }
        }
    }
}
