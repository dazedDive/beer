package fr.dd.biere2000.bean;

import fr.dd.biere2000.dao.DAOFactory;
import fr.dd.biere2000.entity.TypeBiere;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;

import java.util.List;
@Named("typeBean")
@ApplicationScoped
public class TypeBean {
    private static List<TypeBiere> Types;
    private TypeBiere TypeSelected;

    @PostConstruct
    private void Init(){
        Types = DAOFactory.typeDAO().readAll();
    }

    public List<TypeBiere> getTypes() {
        return Types;
    }

    public TypeBiere getTypeSelected() {
        return TypeSelected;
    }

    public void setTypeSelected(TypeBiere typeSelected) {
        TypeSelected = typeSelected;
    }

    public void typeChanged(){

    }
}
