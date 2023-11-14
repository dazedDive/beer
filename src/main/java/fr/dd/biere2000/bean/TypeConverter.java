package fr.dd.biere2000.bean;

import fr.dd.biere2000.entity.Pays;
import fr.dd.biere2000.entity.TypeBiere;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "typeConverter",managed = true)
public class TypeConverter implements Converter<TypeBiere> {
    @Inject
    private TypeBean typeBean;
    @Override
    public TypeBiere getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if(value != null && value.trim().length()>0){
            for (TypeBiere typeBiere : typeBean.getTypes()){
                if (typeBiere.getId() == Integer.parseInt(value)){
                    return typeBiere;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, TypeBiere typeBiere) {
        return String.valueOf(typeBiere.getId());
    }
}
