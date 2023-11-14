package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Couleur;
import fr.dd.biere2000.entity.Pays;
import fr.dd.biere2000.entity.TypeBiere;

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
}
