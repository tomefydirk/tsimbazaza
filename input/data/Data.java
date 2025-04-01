package data;
import vivant.*;
import zoo.*;

import java.util.Vector;
import geo.*;
public class Data {
      public  static Zoo get_zoo(){
        // Création des secteurs
        Secteur[] secteurs = new Secteur[4];
        secteurs[0] = new Secteur("Savane", 0, 0, 10, 10);
        secteurs[1] = new Secteur("Jungle", 10, 10, 20, 20);
        secteurs[2] =null;
        
        // Création des animaux
        Vector<Anim> animaux = new Vector<>();
        Herbi gazelle = new Herbi("Gazelle", 30, 50, new Point(10, 10), 2);
        gazelle.set_dp(new Point(1,1));
        Carni lion = new Carni("Lion", 80, 120, new Point(20, 20), 5);
        lion.set_dp(new Point(1,1));
        animaux.add(gazelle);
        animaux.add(lion);
        
        // Création du zoo
        Zoo zoo = new Zoo(secteurs, animaux, 1, 1, 10, 10);

        // Affichage de l'état initial
        System.out.println("État initial du zoo :");
        zoo.afficher_la();
        
        // Déplacement et interactions des animaux
       
        
        // Affichage après mouvement
        System.out.println("\nÉtat du zoo après déplacement et interactions :");
        zoo.afficher_la(); 
        return zoo;
      }
       
}
