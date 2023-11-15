package fr.dd.biere2000.entity;

public class Pays {
    private int id;
    private String nom;
    private Continent continent;

    public Pays(int id, String nom,Continent continent) {
        this.id = id;
        this.nom = nom;
        this.continent = continent;
    }
    public Pays(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public Pays() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return nom + " (" + continent.getLibelle() + ")";
    }
}
