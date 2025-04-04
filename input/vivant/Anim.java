package vivant;
import time.*;
import zoo.Zoo;

import java.util.Vector;

import aff.Dessin;

import java.awt.Graphics2D;
import geo.*;
public class Anim{
    String nom;
    Date  dns;
    char sex;
    Point position;
    Point dp;
    double poid;
    int intensite_ecran;
    double poid_max;
    boolean est_mort;

    //impl --->#[constructor]{
    public Anim(String nom,double poid,double poid_max,Point position){
            this.nom=nom;
            this.poid=poid;
            this.poid_max=poid_max;
            this.position=position;
            this.est_mort=false;
    }
    //}

    public void deplacer(){
            this.position=Point.add(this.position, this.dp);
        
      
        
    
    }
    public boolean est_dans(Secteur a){
        if(this.position.appartient_sec(a)){
            return true;
        }else{
            return false;
        }
    }
    public void faire_manger_herbi(Secteur s){
        Herbi h=(Herbi) this;
        if(s instanceof SecteurPark){
            SecteurPark sp=(SecteurPark) s;
            if(sp.get_vertete()>0){
                sp.iter_vertete(-1);
                h.manger(); 
            }else{
                return;
            }
        }else{
            return;
        }
    }
    public void faire_manger_carni(Vector<Anim> la,Isolement SI){
        Carni c=(Carni) this;
        Anim proix=c.plus_mangeable(la);
        if(proix!=null){
            c.manger(proix);
            if(proix.get_nom().equalsIgnoreCase(c.get_nom())){
                Zoo.envoyer_isolement(c, SI);
                c.set_dist_fatal(-1);
            }
            proix.est_mort=true;
        }else{
            return;
        }
    }
    public void mangability(Secteur[] ls,Vector<Anim> la,Isolement SI){
        for(int i=0;ls[i]!=null;i++){
            if(this.est_dans(ls[i]) && !this.est_mort){
                if(this instanceof Herbi){
                   faire_manger_herbi(ls[i]);
                }else if(this instanceof Carni){
                    faire_manger_carni(la,SI);
                }else{
                    continue;
                }          
            }
        }
    }
    public boolean equals_to(Anim autre){
        if(autre==this){
            return true;
        }else{
            return false;
        }
    }
    public static double distance(Anim a1,Anim a2){
        return Point.distance(a1.position, a2.position);
    }
    public Anim plus_proche(Vector<Anim> la){
        if(la==null){
            System.out.println("vous manipulez un tableau de liste d'animal vide !!!");
            return null;
        }
        Anim min_dis=(Anim)la.elementAt(0);
        for(int i=0;(Anim)la.elementAt(i)!=null;i++){
                if(distance(this, (Anim)la.elementAt(i))<distance(this, min_dis)){
                    min_dis=(Anim)la.elementAt(i);
                }
        }
        return min_dis;
    }
    
    //impl ---> #[get_field]{
        public String get_nom(){
            return this.nom;
        }
        public Date get_dns(){
           return this.dns;
        }
        public double get_poid(){
            return this.poid;
        }
        public double get_poid_max(){
            return this.poid_max;
        }
        public Point get_position(){
            return this.position;
        }
        public char get_sex(){
            return this.sex;
        }
        public Point get_dp(){
            return this.dp;
        }
        public boolean get_est_mort(){
            return this.est_mort;
        }
        public int get_intensite(){
            return this.intensite_ecran;
        }
    //}

    //impl --->#[mut_field]{
        public void  set_nom(String nom){
                this.nom=nom;
        }
        public void  set_dns(Date dns){
                this.dns= dns;
        }
        public void  set_poid(double poid){
                this.poid=poid;
        }
        public void  set_poid_max(double poid_max){
                this.poid_max=poid_max;
        }
        public void  set_position(Point position){
                this.position=position;
        }
        public void  set_sex(char sex){
                this.sex=sex;
        }
        public void  set_dp(Point dp){
                this.dp=dp;
        }
        public void set_dpX(int x){
            this.dp.set_x(x);
        }
        public void set_dpY(int y){
            this.dp.set_x(y);
        }
        public void oppose_dpX(){
            this.dp.set_x(-this.dp.getX());
        }
        public void oppose_dpY(){
            this.dp.set_y(-this.dp.getY());
        }
        public void set_est_mort(boolean est_mort){
                this.est_mort=est_mort;
        }
        public void set_intensite(int intensite_ecran){
            this.intensite_ecran=intensite_ecran;
        }

    //}
    //impl --->#[inserable]
        public void insert_into(Anim[] la){
            int i=0;
            while (true) {
                    if(la[i]==null){
                        break;
                    }
                    i+=1;
            }
            la[i]=this;
        }

    //}

    //impl --->#[debug]{
        public void afficher(){
            System.out.println("Nom :"+this.nom);
        }
        public void afficher_debug(){
            System.out.println("[ Nom :"+this.nom);
            System.out.print("   ");
            this.position.afficher();
            System.out.println("   Poid:"+this.poid);
            System.out.println("]");
        }
    //}
}