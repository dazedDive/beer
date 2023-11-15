package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Continent;
import fr.dd.biere2000.entity.Fabricant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FabricantDAO extends DAO<Fabricant> {
    @Override
    public boolean create(Fabricant object) {
        return false;
    }

    @Override
    public Fabricant read(Long id) {
        Fabricant fabricant = null;
        String sqlRequest = "SELECT ID_FABRICANT,NOM_FABRICANT FROM FABRICANT WHERE ID_FABRICANT = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                fabricant = new Fabricant(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return fabricant;
    }

    @Override
    public ArrayList<Fabricant> readAll() {
        return null;
    }

    @Override
    public boolean update(Fabricant object) {
        return false;
    }

    @Override
    public boolean delete(Fabricant object) {
        return false;
    }
}
