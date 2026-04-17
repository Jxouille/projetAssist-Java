package org.example.model;

public abstract class Employe extends Personne{
    private String numeroEmploye;
    private String dateEmbauche;

    public Employe(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public String getNumeroEmploye () {
        return numeroEmploye;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setNumeroEmploye(String numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public abstract String obtenirRole();

    @Override
    public void obtenirInfos() {
        super.obtenirInfos();
        System.out.println("Numéro employé: " + numeroEmploye);
        System.out.println("Date embauche: " + dateEmbauche);
        System.out.println("Role: " + obtenirRole());
    }
}
