package vivant;
import time.*;
import zoo.Zoo;
import geo.*;
public class Anim{
    String nom;
    Date  dns;
    char sex;
    Point position;
    Point dp;
    double poid;
    double poid_max;
    public void deplacer(){
        this.position=Point.add(this.position,this.dp);
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
                h.manger(); 
            }else{
                return;
            }
        }else{
            return;
        }
    }
    public void faire_manger_carni(Anim[] la){
        Carni c=(Carni) this;
        Anim proix=c.plus_mangeable(la);
        if(proix!=null){
            c.manger(proix);
            Zoo.delete_animal(proix, la);
        }
    }
    public void mangability(Secteur[] ls,Anim[] la){
        for(int i=0;ls[i]!=null;i++){
            if(this.est_dans(ls[i])){
                if(this instanceof Herbi){
                   faire_manger_herbi(ls[i]);
                }else if(this instanceof Carni){
                    faire_manger_carni(la);
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
    public Anim plus_proche(Anim[] la){
        if(la==null){
            System.out.println("vous manipulez un tableau de liste d'animal vide !!!");
            return null;
        }
        Anim min_dis=la[0];
        for(int i=0;la[i]!=null;i++){
                if(distance(this, la[i])<distance(this, min_dis)){
                    min_dis=la[i];
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
        public Double get_poid(){
            return this.poid;
        }
        public Double get_poid_max(){
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
}