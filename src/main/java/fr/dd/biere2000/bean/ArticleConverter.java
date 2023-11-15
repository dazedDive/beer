package fr.dd.biere2000.bean;

import fr.dd.biere2000.entity.Article;
import fr.dd.biere2000.entity.Couleur;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="articleConverter",managed = true)
public class ArticleConverter implements Converter<Article> {
    @Inject
    private ArticleBean articleBean;
    @Override
    public Article getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length() > 0){
            for (Article article : articleBean.getArticles()){
                if (article.getId() == Integer.parseInt(value)){
                    return article;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Article article) {
        return String.valueOf(article.getId());
    }
}
