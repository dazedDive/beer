package fr.dd.biere2000.entity;

public class Article {
    private int id;
    private String name;
    private Couleur color;
    private TypeBiere type;
    private float titrage;
    private Marque marque;

    public Article(int id, String name, Couleur color, TypeBiere type, float titrage, Marque marque) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.type = type;
        this.titrage = titrage;
        this.marque = marque;
     }
    public Article(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Couleur getColor() {
        return color;
    }

    public void setColor(Couleur color) {
        this.color = color;
    }

    public TypeBiere getType() {
        return type;
    }

    public void setType(TypeBiere type) {
        this.type = type;
    }

    public float getTitrage() {
        return titrage;
    }

    public void setTitrage(float titrage) {
        this.titrage = titrage;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
