package geo;

public class SecteurPark extends Secteur{   
    int vertete;
    //impl --->#[constructor] { 
   public  SecteurPark(String nom,int vertete){
        super(nom);
        this.vertete=vertete;
    }
    public SecteurPark(String nom,int vertete,int x,int y,int width,int height){
        super(nom, x, y, width, height);
        this.vertete=vertete;
    }
    // }

    //impl --->#[get_field]{
    public int get_vertete(){
        return this.vertete;
    }
    // }

    //impl --->#[mut_field]{
    public void set_vertete(int vertete){
        this.vertete=vertete;
    }
    public void iter_vertete(int interator){
        this.vertete=this.vertete+interator;
    }
    // }

    //impl --->#[inserable]{
      public void insert_into(SecteurPark[] lsp){
        int i=0;
        while (true) {
                if(lsp[i]==null){
                    break;
                }
                i+=1;
        }
        lsp[i]=this;
    }
    
    // }

    //impl --->#[debug]{
        public void afficher_debug(){
            System.out.println("Nom : "+this.get_nom());
            System.out.println("Vertete : "+this.vertete);
        }

    //}
    
}