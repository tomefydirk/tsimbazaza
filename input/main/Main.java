package main;

import vivant.*;
import zoo.*;

import java.awt.geom.Rectangle2D;
import java.util.Vector;

import geo.*;
public class Main {
    public static void main(String[] args) {
     Carni c1=new Carni("Balou", 1, 1000, new Point(0, 1), 20);
       c1.set_dp(new Point(0, 0)); 
       Carni c2=new Carni("Hasman", 8.0, 1000, new Point(10, 1), 40);
       c2.set_dp(new Point(0, 1));
       Carni c3=new Carni("bogosy", 10.0, 1000, new Point(99, 1), 1000);
       c3.set_dp(new Point(0, 4));
       Herbi h1=new Herbi("Hermino", 100, 1000, new Point(0, 0), 10);
       h1.set_dp(new Point(1, 3));
       Herbi h2=new Herbi("Jasara", 2, 1000, new Point(11, 1), 10);
       h2.set_dp(new Point(0, 0));

       SecteurPark s1=new SecteurPark("S1",100);
       s1.init_form(new Point(-100, -100), new Point(100, 100), new Point(100, -100), new Point(-100,100));
     /*  Anim[] la=new Anim[100];
       c1.insert_into(la);
       c2.insert_into(la);
       c3.insert_into(la);
      h1.insert_into(la);
      h2.insert_into(la); */

      Vector<Anim> la=new Vector<Anim>();
      la.add(c1);
      la.add(c2);
      la.add(c3);
      la.add(h1);
      la.add(h2);
       Secteur[] ls=new Secteur[3];
       s1.insert_into(ls);
       Zoo tsimbina=new Zoo(ls,la);
       System.out.println(Point.distance(c2.get_position(), c2.get_position()));
       tsimbina.deplacer_tous();
   //    System.out.println(c2.get_est_mort());
      // Zoo.delete_animal(c1, la);
    //   c2.premier_mangeable(la).afficher();

        // Zoo.delete_animal(c1, la);
        // Zoo.delete_animal(c2, la);
      // tsimbina.afficher_la();
       // c2.afficher_debug();
     //   double c=10 +(8.0/10);
     // System.out.println(c);
       // h1.afficher_debug();;
        // Zoo.delete_animal(c2, la);
      
        /* 
          for(int i=0;la[i]!=null;i++){
        la[i].afficher_debug();
        }
        */
       
       // c2.afficher_debug();

      //  c1.plus_mangeable(la).afficher_debug();
      /*---------------------------------------------------------- */
      Rectangle2D.Double r=new Rectangle2D.Double(1, 1, 1, 1);
      boolean isInside =r.contains(0.5, 0.5);
      if(isInside){
        System.out.println("oui!!");
      } 
    }    
}