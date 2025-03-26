package main;

import vivant.*;
import my_math.*;
public class Main {
    public static void main(String[] args) {
        Anim a=new Anim();
        Anim b=a;
        System.out.println(b.equals(a)); 
        double p=Calcul.my_sqrt(121);
        System.out.println(p);
    }    
}