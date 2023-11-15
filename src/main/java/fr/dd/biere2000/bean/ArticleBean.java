package fr.dd.biere2000.bean;

import fr.dd.biere2000.dao.ArticleDAO;
import fr.dd.biere2000.dao.DAOFactory;
import fr.dd.biere2000.entity.Article;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;
@Named("articleBean")
@ApplicationScoped
public class ArticleBean {

    private static List<Article> articles;
    private Article articleSelected;
    private ArticleDAO articleDAO = new ArticleDAO();
    private String colorSelector;
    private String countrySelector;
    private String styleSelector;
    private String brandSelector;

    @PostConstruct
    private void init(){
        articles = null;
    }

    public void selectRandomArticle(){
        setArticles(articleDAO.readRandom());
    }
    public void selectAllArticle(){
        setArticles(DAOFactory.articleDAO().readAll());
    }
    public void findArticle(){
        setArticles(articleDAO.findArticle(
                getColorSelector(),
                getCountrySelector(),
                getStyleSelector(),
                getBrandSelector()
        ));
    }
    public List<Article> getArticles() {
        return articles;
    }

    public static void setArticles(List<Article> articles) {
        ArticleBean.articles = articles;
    }

    public String getColorSelector() {
        return colorSelector;
    }

    public void setColorSelector(String colorSelector) {
        this.colorSelector = colorSelector.toLowerCase();
    }

    public String getCountrySelector() {
        return countrySelector;
    }

    public void setCountrySelector(String countrySelector) {
        String[] splitCountrySelector = countrySelector.split(" ");
        this.countrySelector = splitCountrySelector[0].toLowerCase();
    }

    public String getStyleSelector() {
        return styleSelector;
    }

    public void setStyleSelector(String styleSelector) {
        this.styleSelector = styleSelector;
    }

    public String getBrandSelector() {
        return brandSelector;
    }

    public void setBrandSelector(String brandSelector) {
        String[] splitBrandeSelector = brandSelector.split(" ");
        this.brandSelector = splitBrandeSelector[0].toLowerCase();
    }

    public Article getArticleSelected() {
        return articleSelected;
    }

    public void setArticleSelected(Article articleSelected) {
        this.articleSelected = articleSelected;
    }
}
