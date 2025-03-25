package main;

import vivant.Anim;

public class Main {
    public static void main(String[] args) {
        Anim a=new Anim();
        Anim b=a;
        System.out.println(b.equals(a)); 
    }    
}