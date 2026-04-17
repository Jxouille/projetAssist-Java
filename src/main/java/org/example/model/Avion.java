package org.example.model;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;
    private boolean disponible;

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        this.disponible = true;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void affecterVol(Vol vol) {
        if (verifierDisponibilite()) {
            this.disponible = false;
            System.out.println("Avion " + immatriculation + " affecté au vol " + vol.getNumeroVol());
        } else {
            System.out.println("Avion " + immatriculation + " non disponible.");
        }
    }

    public boolean verifierDisponibilite() {
        if (disponible) {
            System.out.println("Avion " + immatriculation + " est disponible.");
        } else {
            System.out.println("Avion " + immatriculation + " n'est pas disponible.");
        }
        return disponible;
    }

    public void obtenirInfos() {
        System.out.println("Immatriculation: " + immatriculation);
        System.out.println("Modèle: " + modele);
        System.out.println("Capacité: " + capacite);
        System.out.println("Disponible: " + disponible);
    }
}
