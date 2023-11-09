package fr.dd.biere2000;

import fr.dd.biere2000.entity.Couleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CouleurDAO extends DAO<Couleur>{
    @Override
    public boolean create(Couleur couleur){
        String sqlString = "INSERT INTO COULEUR VALUES ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);) {
            preparedStatement.setString(1,couleur.getLibelle());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e){
            return false;
        }
    }
    @Override
    public Couleur read(Long id){
        Couleur couleur = null;
        String sqlString = "SELECT ID_COULEUR,NOM_COULEUR FROM COULEUR WHERE ID_COULEUR = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                couleur = new Couleur(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return couleur;
    }
    @Override
    public ArrayList<Couleur> readAll() {
        ResultSet resultSet;
        ArrayList<Couleur> liste = new ArrayList<>();
        try{
            String sqlString = "SELECT ID_COULEUR, NOM_COULEUR FROM COULEUR ORDER BY NOM_COULEUR";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                liste.add(new Couleur(resultSet.getInt(1),resultSet.getString(2)));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
    @Override
    public boolean update(Couleur couleur){
        try{
            String sqlString = "UPDATE COULEUR SET NOM_COULEUR=? WHERE ID_COULEUR=?";
            PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);
            preparedStatement.setString(1,couleur.getLibelle());
            preparedStatement.setInt(1,couleur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean delete(Couleur couleur){
        try{
            String sqlString = "DELETE FROM COULEUR WHERE ID_COULEUR = ?";
            PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);
            preparedStatement.setInt(1,couleur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
