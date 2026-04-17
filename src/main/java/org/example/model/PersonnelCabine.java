package org.example.model;

public class PersonnelCabine extends Employe {
    private String qualifications;


    public PersonnelCabine(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche, String qualifications) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualifications = qualifications;
    }

    public String getQualification() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String obtenirRole() {
        return "Personnel de Cabine";
    }

    public void affecterVol(Vol vol) {
        System.out.println("Personnel cabine " + getNom() + " affecté au vol " + vol.getNumeroVol());
    }

    public void obtenirVol(Vol vol) {
        System.out.println("Informations du vol pour " + getNom() + ":");
        vol.obtenirInfos();
    }

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Qualification: " + qualifications);
    }
}

