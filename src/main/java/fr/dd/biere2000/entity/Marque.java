package fr.dd.biere2000.entity;

public class Marque {
    private int id;
    private String nom;
    private Fabricant fabricant;

    public Marque(int id, String nom, Fabricant fabricant) {
        this.id = id;
        this.nom = nom;
        this.fabricant = fabricant;
    }

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return  nom + " (" + fabricant.getNom() + ")";
    }
 }
