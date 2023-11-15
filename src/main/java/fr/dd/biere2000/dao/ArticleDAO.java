package fr.dd.biere2000.dao;

import fr.dd.biere2000.entity.*;
import fr.dd.biere2000.utils.Utils;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO extends DAO<Article> {
    @Override
    public boolean create(Article object) {
        return false;
    }

    @Override
    public Article read(Long id) {
        Article article = null;
        CouleurDAO couleurDAO = new CouleurDAO();
        TypeBiereDAO typeBiereDAO = new TypeBiereDAO();
        MarqueDAO marqueDAO = new MarqueDAO();
        String sqlString = "SELECT A.ID_ARTICLE,A.NOM_ARTICLE, A.ID_TYPE, T.NOM_TYPE, A.ID_COULEUR,C.NOM_COULEUR, A.TITRAGE, A.ID_MARQUE, M.NOM_MARQUE, F.ID_FABRICANT, F.NOM_FABRICANT  FROM ARTICLE AS A " +
                "LEFT JOIN TYPEBIERE AS T ON T.ID_TYPE=A.ID_TYPE " +
                "LEFT JOIN COULEUR AS C ON C.ID_COULEUR=A.ID_COULEUR " +
                "LEFT JOIN MARQUE AS M ON A.ID_MARQUE=M.ID_MARQUE " +
                "LEFT JOIN FABRICANT AS F ON F.ID_FABRICANT=M.ID_FABRICANT " +
                "WHERE A.ID_ARTICLE = ?";
        try (PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlString);){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                article = new Article(
                        resultSet.getInt("ID_ARTICLE"),
                        resultSet.getString("NOM_ARTICLE"),
                        new Couleur(resultSet.getInt("ID_COULEUR"),resultSet.getString("NOM_COULEUR")),
                        new TypeBiere(resultSet.getInt("ID_TYPE"),resultSet.getString("NOM_TYPE")),
                        resultSet.getFloat("TITRAGE"),
                        new Marque(resultSet.getInt("ID_MARQUE"), resultSet.getString("NOM_MARQUE"),
                                new Fabricant(resultSet.getInt("ID_FABRICANT"), resultSet.getString("NOM_FABRICANT")))

                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public ArrayList<Article> readAll() {
        ResultSet resultSet;
        ArrayList<Article> liste = new ArrayList<>();
        CouleurDAO couleurDAO = new CouleurDAO();
        TypeBiereDAO typeBiereDAO = new TypeBiereDAO();
        MarqueDAO marqueDAO = new MarqueDAO();
        try{
            String sqlString = "SELECT A.ID_ARTICLE,A.NOM_ARTICLE, A.ID_TYPE, T.NOM_TYPE, A.ID_COULEUR,C.NOM_COULEUR, A.TITRAGE, A.ID_MARQUE, M.NOM_MARQUE, F.ID_FABRICANT, F.NOM_FABRICANT  FROM ARTICLE AS A " +
                    "LEFT JOIN TYPEBIERE AS T ON T.ID_TYPE=A.ID_TYPE " +
                    "LEFT JOIN COULEUR AS C ON C.ID_COULEUR=A.ID_COULEUR " +
                    "LEFT JOIN MARQUE AS M ON A.ID_MARQUE=M.ID_MARQUE " +
                    "LEFT JOIN FABRICANT AS F ON F.ID_FABRICANT=M.ID_FABRICANT " +
                    "ORDER BY A.NOM_ARTICLE";
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                liste.add(new Article(
                        resultSet.getInt("ID_ARTICLE"),
                        resultSet.getString("NOM_ARTICLE"),
                        new Couleur(resultSet.getInt("ID_COULEUR"),resultSet.getString("NOM_COULEUR")),
                        new TypeBiere(resultSet.getInt("ID_TYPE"),resultSet.getString("NOM_TYPE")),
                        resultSet.getFloat("TITRAGE"),
                        new Marque(resultSet.getInt("ID_MARQUE"), resultSet.getString("NOM_MARQUE"),
                                new Fabricant(resultSet.getInt("ID_FABRICANT"), resultSet.getString("NOM_FABRICANT")))

                ));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Article> findArticle(String couleur, String pays, String type, String marque) {
        ArrayList<Article> results = new ArrayList<>();
        String sqlRequest = "EXECUTE ps_recherche_article @couleur = ?,@pays = ?, @type=?, @marque=?";
        try{
        PreparedStatement preparedStatement = getConnexion().prepareStatement(sqlRequest);
        preparedStatement.setString(1, couleur);
        preparedStatement.setString(2, pays);
        preparedStatement.setString(3, type);
        preparedStatement.setString(4, marque);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            results.add(new Article(
                    resultSet.getInt("ID_ARTICLE"),
                    resultSet.getString("NOM_ARTICLE"),
                    new Couleur(resultSet.getInt("ID_COULEUR"),resultSet.getString("NOM_COULEUR")),
                    new TypeBiere(resultSet.getInt("ID_TYPE"),resultSet.getString("NOM_TYPE")),
                    resultSet.getFloat("TITRAGE"),
                    new Marque(resultSet.getInt("ID_MARQUE"), resultSet.getString("NOM_MARQUE"),
                            new Fabricant(resultSet.getInt("ID_FABRICANT"), resultSet.getString("NOM_FABRICANT")))

            ));
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

    public ArrayList<Article> readRandom(){
        ArrayList<Article> results = new ArrayList<>();
        int PoolSize = getArticlePoolSize();
        ArrayList<Long> randomId = Utils.giveMeFifteenIdArticle(PoolSize);
        ArticleDAO articleDAO = new ArticleDAO();
        for(int i=0; i<15; i++){
            results.add(articleDAO.read(randomId.get(i)));
        }
        return results;
    }

    private int getArticlePoolSize(){
        ResultSet resultSet;
        String sqlRequest = "SELECT COUNT(ID_ARTICLE) FROM ARTICLE";
        try {
            Statement statement = getConnexion().createStatement();
            resultSet = statement.executeQuery(sqlRequest);
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
