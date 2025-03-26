package main;

import vivant.*;
import geo.Point;
import my_math.*;
public class Main {
    public static void main(String[] args) {
       Carni c1=new Carni("Balou", 1, 1000, new Point(0, 1), 20);
       c1.set_dp(new Point(0, 0));
       Carni c2=new Carni("Hasman", 1000, 1000, new Point(10, 1), 1000);
       c2.set_dp(new Point(0, 0));

       Anim[] la=new Anim[4];
       c1.insert_into(la);
       c2.insert_into(la);
    }    
}