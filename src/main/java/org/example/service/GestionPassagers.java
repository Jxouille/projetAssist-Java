package org.example.service;

import org.example.model.Passager;
import java.util.ArrayList;
import java.util.List;

public class GestionPassagers {
    private List<Passager> passagers;

    public GestionPassagers() {
        this.passagers = new ArrayList<>();
    }

    public List<Passager> getPassagers() { return passagers; }
    public void setPassagers(List<Passager> passagers) { this.passagers = passagers; }

    public void ajouterPassager(Passager passager) {
        passagers.add(passager);
        System.out.println("Passager " + passager.getNom() + " ajouté.");
    }

    public Passager chercherPassager(String identifiant) {
        for (Passager p : passagers) {
            if (p.getIdentifiant().equals(identifiant)) {
                return p;
            }
        }
        System.out.println("Passager " + identifiant + " introuvable.");
        return null;
    }

    public void modifierPassager(String identifiant, String nom, String adresse, String contact, String passport) {
        Passager passager = chercherPassager(identifiant);
        if (passager != null) {
            passager.setNom(nom);
            passager.setAdresse(adresse);
            passager.setContact(contact);
            passager.setPasseport(passport);
            System.out.println("Passager " + identifiant + " modifié.");
        }
    }

    public void supprimerPassager(String identifiant) {
        for (int i = 0; i < passagers.size(); i++) {
            if (passagers.get(i).getIdentifiant().equals(identifiant)) {
                passagers.remove(i);
                System.out.println("Passager " + identifiant + " supprimé.");
                return;
            }
        }
        System.out.println("Passager " + identifiant + " introuvable.");
    }

    public void listerPassagers() {
        if (passagers.isEmpty()) {
            System.out.println("Aucun passager enregistré.");
        } else {
            System.out.println("--- Liste des passagers ---");
            for (Passager p : passagers) {
                System.out.println("---");
            }
        }
    }
}
