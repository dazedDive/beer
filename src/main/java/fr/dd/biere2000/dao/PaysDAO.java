package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Pays;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PaysDAO extends DAO<Pays> {
    @Override
    public boolean create(Pays object) {
        return false;
    }

    @Override
    public Pays read(Long id) {
        return null;
    }

    @Override
    public boolean update(Pays object) {
        return false;
    }

    @Override
    public boolean delete(Pays object) {
        return false;
    }

    @Override
    public ArrayList<Pays> readAll(){
        ResultSet resultSet;
        ArrayList<Pays> liste = new ArrayList<>();
        ContinentDAO continentDAO = new ContinentDAO();
        try{
            String sqlRequest = "SELECT ID_PAYS,NOM_PAYS,ID_CONTINENT FROM PAYS ORDER BY NOM_PAYS";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()){
                liste.add(new Pays(resultSet.getInt(1),resultSet.getString(2),continentDAO.read(resultSet.getLong(1))));
            }
            resultSet.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
}
