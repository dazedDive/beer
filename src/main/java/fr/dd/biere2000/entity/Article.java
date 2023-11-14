package fr.dd.biere2000.entity;

public class Article {
    private int id;
    private String name;
    private Couleur color;
    private TypeBiere type;

    public Article(int id, String name, Couleur color, TypeBiere type) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.type = type;
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

    @Override
    public String toString() {
        return  name ;
    }
}
