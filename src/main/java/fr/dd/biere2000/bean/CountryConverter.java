package fr.dd.biere2000.bean;

import fr.dd.biere2000.entity.Couleur;
import fr.dd.biere2000.entity.Pays;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "countryConverter",managed = true)
public class CountryConverter implements Converter<Pays> {
    @Inject
    private CountryBean countryBean;
    @Override
    public Pays getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
       if (value != null && value.trim().length() > 0) {
           for (Pays pays : countryBean.getCountries()){
               if (pays.getId() == Integer.parseInt(value)){
                   return pays;
               }
           }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Pays pays) {
        if(pays != null) {
            return String.valueOf(pays.getId());
        }
        return "";
    }
}
