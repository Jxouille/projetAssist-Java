package org.example.model;

public abstract class Personne {
    private String identifiant;
    private String nom;
    private String adresse;
    private String contact;

    //constructeur
    public  Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }


    // geter
    public String getIdentifiant () {
        return identifiant;
    }

    public  String getNom () {
        return nom;
    }

    public String getAdresse () {
        return adresse;
    }

    public String getContact () {
        return contact;
    }

    //seter
    public void setIdentifiant (String identifiant) {
        this.identifiant = identifiant;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void obtenirInfos () {
        System.out.println("ID: " + identifiant);
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Contact: " + contact);
    }
}
