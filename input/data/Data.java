package data;
import vivant.*;
import zoo.*;

import java.util.Vector;
import geo.*;
public class Data {
      public  static Zoo get_zoo(){
      
    
        Secteur[] ls = new Secteur[6];
    
        
        new SecteurPark("Savane",100,1,1,10,10).insert_into(ls);
       
        new SecteurPark("Jungle",99,10,10,20,20).insert_into(ls);
     
      
        
        new SecteurPark("talatamaty",64,70,20,20,20).insert_into(ls);;
       
        
        Vector<Anim> la = new Vector<>();
        Herbi h1 = new Herbi("h1", 90, 150, new Point(10, 10), 20);
        h1.set_dp(new Point(1,0));

        Herbi h2 = new Herbi("h2",9,9,new Point(9,9),9);
        h2.set_dp(new Point(-1,-1));

      

        Herbi h4 = new Herbi("h4",14,21,new Point(19,9),9);
        h4.set_dp(new Point(1,0));

        Herbi h5 = new Herbi("h5",14,12,new Point(39,9),90);
        h5.set_dp(new Point(-1,1));


        Carni c1 = new Carni("alika", 80, 120, new Point(20, 20), 5);
        c1.set_dp(new Point(0,1));
        
        Carni c2=new Carni("alika",10,33,new Point(23,26),10);
        c2.set_dp(new Point(-1,1));

        Carni c3=new Carni("alika",10,43,new Point(12,24),10);
        c3.set_dp(new Point(1,-1));

        Carni c4=new Carni("alika",9,43,new Point(12,24),10);
        c4.set_dp(new Point(1,-1));

        Carni c5=new Carni("Lion",10,43,new Point(89,26),10);
        c5.set_dp(new Point(-1,-1));
        
        la.add(h1);
        la.add(c1);
        la.add(c2);
        la.add(h2);
        la.add(c5);
        la.add(c3);
        la.add(c4);
        Zoo zoo = new Zoo(ls, la, 1, 1, 100,50);
        zoo.init_isolement(new Isolement(30,20,30,30,10));
      
        System.out.println("État initial du zoo :");
        zoo.afficher_la();
        
      
       
        
        
        return zoo;
      }
       
}
