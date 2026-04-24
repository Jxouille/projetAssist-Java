package org.example.service;

import org.example.model.Vol;
import java.util.ArrayList;
import java.util.List;

public class GestionVols {
    private List<Vol> vols;

    public List<Vol> getVols() { return vols; }
    public void setVols(List<Vol> vols) { this.vols = vols; }

    public GestionVols() {
        this.vols = new ArrayList<>();
    }

    public void ajouterVol(Vol vol) {
        vols.add(vol);
        System.out.println("Vol " + vol.getNumeroVol() + " ajouté.");
    }

    public void modifierVol(String numeroVol, String dateHeureDepart, String dateHeureArrivee) {
        Vol vol = chercherVol(numeroVol);
        if (vol != null) {
            vol.modifierVol(dateHeureDepart, dateHeureArrivee);
        } else {
            System.out.println("Vol " + numeroVol + " introuvable.");
        }
    }

    public Vol chercherVol(String numeroVol) {
        for (Vol v : vols) {
            if (v.getNumeroVol().equals(numeroVol)) {
                return v;
            }
        }
        System.out.println("Vol " + numeroVol + " introuvable.");
        return null;
    }

    public void supprimerVol(String numeroVol) {
        for (int i = 0; i < vols.size(); i++ ) {
            if (vols.get(i).getNumeroVol().equals(numeroVol)) {
                vols.remove(i);
                System.out.println("Vol " + numeroVol + " supprimé.");
                return;
            }
        }
        System.out.println("Vol " + numeroVol + " introuvable.");
    }

    public void annulerVol(String numeroVol) {
        Vol vol = chercherVol(numeroVol);
        if (vol != null) {
            vol.annulerVol();
        }
    }

    public void planifierVols(List<Vol> volsAplanifier) {
        for (Vol v : volsAplanifier) {
            ajouterVol(v);
            v.planifierVol();
        }
        System.out.println(volsAplanifier.size() + " vol(s) planifié(s).");
    }

    public void listerVols() {
        if (vols.isEmpty()) {
            System.out.println("Aucun vol enregistré.");
        } else {
            System.out.println("--- Liste des vols ---");
            for (Vol v : vols) {
                v.obtenirInfos();
                System.out.println("---");
            }
        }
    }
}

