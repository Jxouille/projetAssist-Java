package org.example.service;

import org.example.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestionEmployes {
    private List<Pilote> pilotes;
    private List<PersonnelCabine> personnelCabines;

    public GestionEmployes() {
        this.pilotes = new ArrayList<>();
        this.personnelCabines = new ArrayList<>();
    }

    public void ajouterPilote(Pilote pilote) {
        pilotes.add(pilote);
        System.out.println("Pilote " + pilote.getNom() + " ajouté.");
    }

    public void ajouterPersonnelCabine(PersonnelCabine personnel) {
        personnelCabines.add(personnel);
        System.out.println("Personnel cabine " + personnel.getNom() + " ajouté.");
    }

    public Pilote chercherPilote(String identifiant) {
        for (Pilote p : pilotes) {
            if (p.getIdentifiant().equals(identifiant)) {
                return p;
            }
        }
        System.out.println("Pilote " + identifiant + " introuvable.");
        return null;
    }

    public PersonnelCabine chercherPersonnelCabine(String identifiant) {
        for (PersonnelCabine p : personnelCabines) {
            if (p.getIdentifiant().equals(identifiant)) {
                return p;
            }
        }
        System.out.println("Personnel cabine " + identifiant + " introuvable.");
        return null;
    }

    public String obtenirRole(String identifiant) {
        Pilote pilote = chercherPilote(identifiant);
        if (pilote != null) return pilote.obtenirRole();

        return "Employé introuvable.";
    }

    public void supprimerPilote(String identifiant) {
        for (int i = 0; i < pilotes.size(); i++ ) {
            if (pilotes.get(i).getIdentifiant().equals(identifiant)) {
                pilotes.remove(i);
                System.out.println("Pilote " + identifiant + " supprimé.");
                return;
            }
        }
        System.out.println("Pilote " + identifiant + " introuvable.");
    }

    public void supprimerPersonnelCabine(String identifiant) {
        for (int i = 0; i < personnelCabines.size(); i++) {
            if (personnelCabines.get(i).getIdentifiant().equals(identifiant)) {
                personnelCabines.remove(i);
                System.out.println("Personnel cabine " + identifiant + " supprimé.");
                return;
            }
        }
        System.out.println("Personnel cabine " + identifiant + " introuvable.");
    }

    public void listerEmployes() {
        System.out.println("--- Pilotes ---");
        if (pilotes.isEmpty()) {
            System.out.println("Aucun pilote enregistré.");
        } else {
            for (Pilote p : pilotes) {
                p.obtenirInfos();
                System.out.println("---");
            }
        }
        System.out.println("--- Personnel de Cabine ---");
        if (personnelCabines.isEmpty()) {
            System.out.println("Aucun personnel cabine enregistré.");
        } else {
            for (PersonnelCabine p : personnelCabines) {
                p.obtenirInfos();
                System.out.println("---");
            }
        }
    }

    public void affecterEquipage(String idPilote, String idPersonnel, Vol vol) {
        Pilote pilote = chercherPilote(idPilote);
        PersonnelCabine personnel = chercherPersonnelCabine(idPersonnel);
        if (pilote != null && personnel != null) {
            pilote.affecterVol(vol);
            System.out.println("Equipage affecté au vol " + vol.getNumeroVol());
        } else {
            System.out.println("Impossible d'affecter l'équipage, vérifiez les identifiants.");
        }
    }
}
