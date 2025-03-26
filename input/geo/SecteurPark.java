package geo;

public class SecteurPark extends Secteur{   
    int vertete;
    //impl --->#[constructor] { 
   public  SecteurPark(String nom,int vertete){
        super(nom);
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