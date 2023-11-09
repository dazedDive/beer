package fr.dd.biere2000;

import fr.dd.biere2000.entity.Couleur;

public class DAOFactory {

    public static DAO<Couleur> couleurDAO() {
        return new CouleurDAO();
    }
}
