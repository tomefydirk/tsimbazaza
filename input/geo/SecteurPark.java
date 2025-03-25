package geo;
public class SecteurPark extends Secteur{   
    int vertete;
    //impl --->#[constructor] { 

    SecteurPark(String nom){
        this.set_nom(nom);
        this.set_form(new Point[4]);
    }
    // }
}