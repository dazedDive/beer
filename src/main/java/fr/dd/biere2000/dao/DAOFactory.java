package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.*;

public class DAOFactory {

    public static DAO<Couleur> couleurDAO() {
        return new CouleurDAO();
    }
    public static DAO<Pays> paysDAO() {
        return new PaysDAO();
    }
    public static DAO<TypeBiere> typeDAO() {
        return new TypeBiereDAO();
    }
    public static DAO<Marque> marqueDAOe() { return new MarqueDAO(); }
    public static DAO<Article> articleDAO() { return new ArticleDAO(); }
}
