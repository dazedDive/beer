package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Fabricant;
import fr.dd.biere2000.entity.Marque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MarqueDAO extends DAO<Marque> {
    @Override
    public boolean create(Marque object) {
        return false;
    }

    @Override
    public Marque read(Long id) {
        Marque marque = null;
        FabricantDAO fabricantDAO = new FabricantDAO();
        String sqlRequest = "SELECT M.ID_MARQUE,M.NOM_MARQUE,M.ID_FABRICANT,F.NOM_FABRICANT FROM MARQUE AS M JOIN FABRICANT AS F ON F.ID_FABRICANT=M.ID_FABRICANT WHERE ID_MARQUE = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                marque = new Marque(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        new Fabricant(resultSet.getInt(3),
                                resultSet.getString(4)));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return marque;
    }

    @Override
    public ArrayList<Marque> readAll() {
        ResultSet resultSet;
        ArrayList<Marque> liste = new ArrayList<>();
        FabricantDAO fabricantDAO= new FabricantDAO();
        try {
            String sqlRequest = "SELECT M.ID_MARQUE, M.NOM_MARQUE, M.ID_FABRICANT, F.NOM_FABRICANT FROM MARQUE AS M JOIN FABRICANT AS F ON F.ID_FABRICANT=M.ID_FABRICANT ORDER BY NOM_MARQUE";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
                liste.add(new Marque(resultSet.getInt(1),
                        resultSet.getString(2),
                        new Fabricant(resultSet.getInt(3),
                                    resultSet.getString(4))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public boolean update(Marque object) {
        return false;
    }

    @Override
    public boolean delete(Marque object) {
        return false;
    }
}
