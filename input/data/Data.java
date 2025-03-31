package data;
import vivant.*;
import zoo.*;

import java.awt.geom.Rectangle2D;
import java.util.Vector;
import aff.MaFenetre;
import geo.*;
public class Data {
      Zoo mon_zoo;
      public   Data(){
            Carni c1=new Carni("Balou", 1000, 1000, new Point(1, 1), 0);
            c1.set_dp(new Point(10, 0)); 
            Carni c2=new Carni("Hasman", 8.0, 1, new Point(10, 1), 40);
            c2.set_dp(new Point(0, 1));
            Carni c3=new Carni("bogosy", 222, 1000, new Point(99, 1), 10);
            c3.set_dp(new Point(0, 4));
            Herbi h1=new Herbi("Hermino", 222, 1000, new Point(120, 122), 10);
            h1.set_dp(new Point(1, 0));
            Herbi h2=new Herbi("Jasara", 200, 1000, new Point(110, 1), 10);
            h2.set_dp(new Point(0, 0));
            Herbi h3=new Herbi("Gaëlle", 200, 1000, new Point(501, 100), 10);
            h3.set_dp(new Point(0, 0));
            SecteurPark s1=new SecteurPark("S1",100);
            s1.init_form(new Point(-100, -100), new Point(100, 100), new Point(100, -100), new Point(-100,100));
            SecteurPark s2=new SecteurPark("S2",100);
            s2.setRect(500, -500, 2, 2);
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
           la.add(h3);
            Secteur[] ls=new Secteur[3];
            s1.insert_into(ls);
            s2.insert_into(ls);
            Zoo tsimbina=new Zoo(ls,la);
         //  // System.out.println(Point.distance(c2.get_position(), c2.get_position()));
           // tsimbina.deplacer_tous();
           // tsimbina.deplacer_tous();
        //    System.out.println(c2.get_est_mort());
       //   tsimbina.get_la().remove(c1);
           // c2.plus_mangeable(la).afficher();
           tsimbina.afficher_la();
          
             // Zoo.delete_animal(c1, la);
             // Zoo.delete_animal(c2, la);
           // tsimbina.afficher_la();
          //   c3.afficher_debug();
          //   double c=10 +(8.0/10);
          // System.out.println(c);
            // h1.afficher_debug();;
             // Zoo.delete_animal(c2, la);
          // Anim a=c2.premier_mangeable(la);
         //  a.afficher();
           
             /* 
               for(int i=0;la[i]!=null;i++){
             la[i].afficher_debug();
             }
             */
            
            // c2.afficher_debug();
            this.mon_zoo=tsimbina;
           if(c1.get_position().appartient_sec(s1)){
               System.out.println("vrai");
           }
           System.out.println(s1.getWidth());
           //  c1.plus_mangeable(la).afficher_debug();
           /*---------------------------------------------------------- */
           Rectangle2D.Double r=new Rectangle2D.Double(0, 0, 1, 1);
           boolean isInside =r.contains(0.5, 0.5);
           if(isInside){
             System.out.println("oui!!");
           } 
      
        }   
        //impl --->#[get_field]{
        public Zoo get_zoo(){
          return this.mon_zoo;
        }
        //}

        //impl --->#[mut_field]{
        public void set_zoo(Zoo a){
          this.mon_zoo=a;
        }
        //}
}
