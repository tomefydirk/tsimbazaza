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
        ls[0].setRect(1,1,10,10);

        ls[1]= new SecteurPark("Jungle",99);
        ls[1].setRect(10,10,20,20);

        ls[2]= new SecteurPark("Zone morte",0);
        ls[2].setRect(30,20,30,30);

        ls[4] = new SecteurPark("talatamaty",64);
        ls[4].setRect(70,20,20,20);
        // Création des animaux
        Vector<Anim> la = new Vector<>();
        Herbi h1 = new Herbi("h1", 3, 5, new Point(10, 10), 2);
        h1.set_dp(new Point(1,0));

        Herbi h2 = new Herbi("h2",9,9,new Point(9,9),9);
        h2.set_dp(new Point(-1,-1));

        Herbi h3 = new Herbi("h3",29,98,new Point(19,9),9);
        h3.set_dp(new Point(-1,1));

        Herbi h4 = new Herbi("h4",14,21,new Point(19,9),9);
        h4.set_dp(new Point(1,0));

        Herbi h5 = new Herbi("h5",14,12,new Point(39,9),90);
        h5.set_dp(new Point(-1,1));


        Carni c1 = new Carni("c1", 80, 12, new Point(20, 20), 5);
        c1.set_dp(new Point(0,1));
        
        Carni c2=new Carni("c2",10,33,new Point(23,26),10);
        c2.set_dp(new Point(1,1));
        la.add(h1);
        la.add(c1);
        la.add(c2);
        la.add(h2);
        la.add(h3);
        la.add(h4);
        la.add(h5);
        // Création du zoo
     
        Zoo zoo = new Zoo(ls, la, 0, 0, 100,50);
        if(zoo.contains(c2.get_position().getX(),c2.get_position().getY())){
          System.out.println("vrai");
      }
        // Affichage de l'état initial
        System.out.println("État initial du zoo :");
        zoo.afficher_la();
        
        // Déplacement et interactions des animaux
       
        
        
        return zoo;
      }
       
}
