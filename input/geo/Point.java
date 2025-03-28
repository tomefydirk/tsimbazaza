package geo;
import my_math.*;
import java.awt.geom.Point2D;
public class Point extends Point2D.Double{
    double  x;
    private double y;

    //impl ---> #[constructor] {
    public Point(double x,double y){
        this.x=x;
        this.y=y;
        
      }
    // }

    //impl -->[operation]{
    public static Point add(Point p1,Point p2){
        return new Point(p1.x+p2.x, p1.y+p2.y);
    }
    public static Point substract(Point p1,Point p2){
        return new Point(p1.x-p2.x, p1.y-p2.y);
    }
    public static double distance(Point p1,Point p2){
        return Calcul.my_sqrt(Calcul.carree(p1.x-p2.x)+Calcul.carree(p1.y-p2.y));
    }
    //}
    public boolean appartient_sec_part(Point born_inf,Point born_sup){
        return this.x>=born_inf.x && this.x<=born_sup.x && this.y>=born_inf.y && this.y<=born_sup.y;
        
    }
    public boolean appartient_sec(Secteur s){
        return s.contains(x, y);
    }
    //impl --->#[PartialEq] {
    public boolean equal(Point autre){
       return Calcul.my_fabs(autre.x-this.x)<0.00001 && Calcul.my_fabs(autre.y-this.y)<0.00001;
        
    }
    // }

    // impl --->#[Debug] {
    public String into_string(){
        return "{ x: "+this.x+" ; y: "+this.y+" }";
    }
    public void afficher(){
        System.out.println(this.into_string());
    }
    // }

    //impl -->#[get_field] {
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    // }

    //impl -->#[mut_field] {
    public void set_x(double x){
        this.x=x;
    }
    public void set_y(double y){
        this.y=y;
    }
    // }

    //impl --> #[inserable] {
        public void insert_into(Point[] ld){
            int i=0;
            while (true) {
                if(ld[i]==null){
                    break;
                }
                i++;
            }
            ld[i]=this;
        }
    
        public void replace_into(Point[] ld,int index){
            ld[index]=this;
        }
    // }  

    public static Point min_p(Point[] form){
        Point minimum=new Point(0,0);
        minimum=form[0];
        for(int i=0;i<4;i++){
            if(minimum.getX()>=form[i].getX() && minimum.getY()>=form[i].getY()){
                minimum=form[i];
            }
        }
        return minimum;
    }
    public static Point max_p(Point[] form){
        Point maximum=new Point(0,0);
        maximum=form[0];
        for(int i=0;i<4;i++){
            if(maximum.getX()<=form[i].getX() && maximum.getY()<=form[i].getY()){
                maximum=form[i];
            }
        }
        return maximum;
    }
} 