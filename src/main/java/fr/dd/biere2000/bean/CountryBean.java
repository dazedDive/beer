package fr.dd.biere2000.bean;

import fr.dd.biere2000.dao.DAOFactory;
import fr.dd.biere2000.entity.Pays;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;

@Named("countrieBean")
@ApplicationScoped
public class CountryBean {
    private static List<Pays> Countries;
    private Pays countrySelected;

    @PostConstruct
    private void init(){
        Countries = DAOFactory.paysDAO().readAll();
    }

    public List<Pays> getCountries(){
        return Countries;
    }

    public Pays getCountrySelected() {
        return countrySelected;
    }

    public void setCountrySelected(Pays countrySelected) {
        this.countrySelected = countrySelected;
    }
    public void countryChanged(){

    }

}
