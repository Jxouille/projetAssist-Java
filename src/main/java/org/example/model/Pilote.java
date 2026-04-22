package org.example.model;

public class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;

    public Pilote ( String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    public String getLicence () {
        return licence;
    }

    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    public void affecterVol(Vol vol) {
        System.out.println("Pilote " + getNom() + " affecté au vol " + vol.getNumeroVol());
    }

    public void obtenirVol(Vol vol){
        System.out.println("Informations du vol pour le pilote " + getNom() + ":");
        vol.obtenirInfos();
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Licence: " +  licence);
        System.out.println("Heures de vol: " + heuresDeVol);
    }
}
