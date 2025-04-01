package data;
import vivant.*;
import zoo.*;

import java.util.Vector;
import geo.*;
public class Data {
      public  static Zoo get_zoo(){
        // Création des secteurs
        Secteur[] ls = new Secteur[6];
        ls[3] =new SecteurPark("moyene",11);
        ls[3].setRect(50,50,10,10);
        
        ls[0]= new SecteurPark("Savane",100);
        ls[0].setRect(0,0,10,10);

        ls[1]= new SecteurPark("Jungle",2);
        ls[1].setRect(10,10,20,20);

        ls[2]= new SecteurPark("Zone morte",0);
        ls[2].setRect(30,20,30,30);

        ls[4] = new SecteurPark("talatamaty",44);
        ls[4].setRect(70,20,20,20);
        // Création des animaux
        Vector<Anim> la = new Vector<>();
        Herbi h1 = new Herbi("h1", 30, 50, new Point(10, 10), 2);
        h1.set_dp(new Point(1,0));
        Carni c1 = new Carni("c1", 80, 120, new Point(20, 20), 5);
        c1.set_dp(new Point(0,1));
        
        Carni c2=new Carni("c2",100,343,new Point(23,26),2);
        c2.set_dp(new Point(1,1));
        la.add(h1);
        la.add(c1);
        la.add(c2);
        
        // Création du zoo
        Zoo zoo = new Zoo(ls, la, 0, 0, 100,50);

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
