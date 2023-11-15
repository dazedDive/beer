package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Marque;
import fr.dd.biere2000.entity.Pays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaysDAO extends DAO<Pays> {
    @Override
    public boolean create(Pays object) {
        return false;
    }

    @Override
    public Pays read(Long id) {
        Pays pays = null;
        String sqlRequest = "SELECT ID_PAYS,NOM_PAYS FROM PAYS WHERE ID_PAYS = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                pays = new Pays(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return pays;
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
            String sqlRequest = "SELECT P.ID_PAYS,P.NOM_PAYS,P.ID_CONTINENT FROM PAYS AS P JOIN CONTINENT AS C ON C.ID_CONTINENT = P.ID_CONTINENT ORDER BY P.NOM_PAYS";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()){
                liste.add(new Pays(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        continentDAO.read(resultSet.getLong(3))));
            }
            resultSet.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
}
