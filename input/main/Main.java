package main;

import vivant.*;
import zoo.*;
import geo.*;
public class Main {
    public static void main(String[] args) {
       Carni c1=new Carni("Balou", 1, 1000, new Point(0, 1), 20);
       c1.set_dp(new Point(0, 0));
       Carni c2=new Carni("Hasman", 1000, 1000, new Point(10, 1), 1000);
       c2.set_dp(new Point(0, 1));


       SecteurPark s1=new SecteurPark("S1",100);
       s1.init_form(new Point(-100, -100), new Point(100, 100), new Point(100, -100), new Point(-100,100));
       Anim[] la=new Anim[4];
       c1.insert_into(la);
       c2.insert_into(la);


       Secteur[] ls=new Secteur[3];
       s1.insert_into(ls);
       Zoo tsimbina=new Zoo(ls,la);
       System.out.println(Point.distance(c2.get_position(), c2.get_position()));
       tsimbina.deplacer_tous();

      Zoo.delete_animal(c1, la);
       for(int i=0;la[i]!=null;i++){
        la[i].afficher_debug();
        }
       // c2.afficher_debug();

      //  c1.plus_mangeable(la).afficher_debug();
    }    
}