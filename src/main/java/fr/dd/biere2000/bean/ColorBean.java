package fr.dd.biere2000.bean;
import fr.dd.biere2000.DAOFactory;
import fr.dd.biere2000.entity.Couleur;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("colorBean")
@ApplicationScoped
public class ColorBean implements Serializable {
    private static List<Couleur> Colors;

    private Couleur colorSelected;

    @PostConstruct
    private void init(){
        Colors = DAOFactory.couleurDAO().readAll();
    }

    public List<Couleur> getColors(){
        return Colors;
    }

    public Couleur getColorSelected(){
        return colorSelected;
    }
    public void setColorSelected(Couleur colorSelected){
        this.colorSelected = colorSelected;
    }
    public void colorChanged(ValueChangeEvent e){
        Couleur newColor = (Couleur) e.getNewValue();
        setColorSelected(newColor);
    }
}
