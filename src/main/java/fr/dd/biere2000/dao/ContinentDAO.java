package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Continent;
import fr.dd.biere2000.entity.Couleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContinentDAO extends DAO<Continent> {
    @Override
    public boolean create(Continent object) {
        return false;
    }

    @Override
    public Continent read(Long id) {
        Continent continent = null;
        String sqlString = "SELECT ID_CONTINENT,NOM_CONTINENT FROM CONTINENT WHERE ID_CONTINENT = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                continent = new Continent(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return continent;
    }

    @Override
    public ArrayList<Continent> readAll() {
        return null;
    }

    @Override
    public boolean update(Continent object) {
        return false;
    }

    @Override
    public boolean delete(Continent object) {
        return false;
    }

}
