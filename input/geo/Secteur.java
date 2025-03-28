package geo;
import java.awt.geom.*;
public class Secteur extends Rectangle2D.Double{
    private String nom;

    //impl ---> #[constructor] {
    public Secteur(String nom) {
        this.nom=nom;
    } 
    public Secteur(String nom,double x,double y,double width,double height){
        this.nom=nom;
        this.setRect(x, y, width, height);
    }
    // }
   
    public void init_form(Point p1,Point p2,Point p3,Point p4){
            Point[] LP=new Point[5];  
            p1.insert_into(LP);
            p2.insert_into(LP);
            p3.insert_into(LP);
            p4.insert_into(LP);

            Point min=Point.min_p(LP);
            Point max=Point.max_p(LP);

            double width=max.getX()-min.getX();
            double height=max.getY()-min.getY();
            this.setRect(min.getX(), min.getY(),width, height);
    }
    //impl -->#[PartialEq] {
    public boolean equal(Secteur autre){
       return this==autre;
        
    }
    // }

    
 
    
    // impl --->#[Debug] {
   
    public void afficher(){
        System.out.println(this.nom);
    }
    // }

    //impl ---> #[get_field] {
    public String get_nom(){
        return this.nom;
    }
    // }

     //impl ---> #[mut_field] {
    public void set_nom(String nom){
        this.nom=nom;
    }
    // }
    //impl --> #[inserable] {
        public void insert_into(Secteur[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Secteur[] ld,int index){
            ld[index]=this;
        }

    
}