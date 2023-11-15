package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Fabricant;
import fr.dd.biere2000.entity.TypeBiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeBiereDAO extends DAO<TypeBiere>{
    @Override
    public boolean create(TypeBiere object) {
        return false;
    }

    @Override
    public boolean update(TypeBiere object) {
        return false;
    }

    @Override
    public boolean delete(TypeBiere object) {
        return false;
    }

    @Override
    public TypeBiere read(Long id) {
        TypeBiere typeBiere = null;
        String sqlRequest = "SELECT ID_TYPE,NOM_TYPE FROM TYPEBIERE WHERE ID_TYPE = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                typeBiere = new TypeBiere(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return typeBiere;
    }

    @Override
    public ArrayList<TypeBiere> readAll() {
        ResultSet resultSet;
        ArrayList<TypeBiere> liste = new ArrayList<>();
        try {
        String sqlRequest = "SELECT ID_TYPE, NOM_TYPE FROM TYPEBIERE ORDER BY NOM_TYPE";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()){
                liste.add(new TypeBiere(resultSet.getInt(1),resultSet.getString(2)));
            }
            resultSet.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return liste;
    }
}
