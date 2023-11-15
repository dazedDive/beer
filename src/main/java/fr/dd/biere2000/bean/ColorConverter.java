package fr.dd.biere2000.bean;
import fr.dd.biere2000.entity.Couleur;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value="colorConverter",managed = true)
public class ColorConverter implements Converter<Couleur> {

    @Inject
    private ColorBean colorBean;

    public Couleur getAsObject(FacesContext fc, UIComponent uic, String value){
        if(value != null && value.trim().length() > 0){
            for (Couleur couleur : colorBean.getColors()){
                if (couleur.getId() == Integer.parseInt(value)){
                    return couleur;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Couleur couleur){
        if(couleur != null) {
            return String.valueOf(couleur.getId());
        }
        return "";
    }
}
