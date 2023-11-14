package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.Article;
import fr.dd.biere2000.entity.Couleur;
import fr.dd.biere2000.entity.Pays;
import fr.dd.biere2000.entity.TypeBiere;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDAO extends DAO<Article> {
    @Override
    public boolean create(Article object) {
        return false;
    }

    @Override
    public Article read(Long id) {
        return null;
    }

    @Override
    public ArrayList<Article> readAll() {
        return null;
    }

    public ArrayList<Article> findArticle(Couleur couleur, Pays pays, TypeBiere type) {
        ResultSet resultSet;
        ArrayList<Article> results = new ArrayList<>();
        String sqlRequest = "EXECUTE ps_recherche_article @couleur = ?, @pays = ?, @type=?";
        try(PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest)){
        preparedStatement.setString(1, couleur.getLibelle());
        preparedStatement.setString(1, pays.getNom());
        preparedStatement.setString(1, type.getLibelle());
        Statement statement= getConnexion().createStatement();
        resultSet = statement.executeQuery(preparedStatement.toString());
        while (resultSet.next()){
            results.add(new Article(resultSet.getInt(1),resultSet.getString(2)));
        }
        } catch (Exception e){
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public boolean update(Article object) {
        return false;
    }

    @Override
    public boolean delete(Article object) {
        return false;
    }
}
