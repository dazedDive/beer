package fr.dd.biere2000.bean;

import fr.dd.biere2000.dao.DAOFactory;
import fr.dd.biere2000.entity.Marque;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.jboss.logging.annotations.ConstructType;

import java.util.List;

@Named("marqueBean")
@ApplicationScoped
public class MarqueBean {
    private static List<Marque> marques;
    private Marque marqueSelected;

    @PostConstruct
    private void Init(){
        marques = DAOFactory.marqueDAOe().readAll();
    }
    public List<Marque> getMarques() {
        return marques;
    }
    public static void setMarques(List<Marque> marques) {
        MarqueBean.marques = marques;
    }

    public Marque getMarqueSelected() {
        return marqueSelected;
    }

    public void setMarqueSelected(Marque marqueSelected) {
        this.marqueSelected = marqueSelected;
    }

    public void marqueChanged(){

    }
}
