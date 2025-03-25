package zoo;

import geo.*;
import vivant.*;
public class Zoo {
    Secteur[] ls;
    Anim[] la;
    public void deplacer_tous(){
      for(int i=0;la[i]!=null;i++){
            la[i].deplacer();
            la[i].mangability(this.ls);
      }
    }
    public int find_indice_animal(Animal a){
      for(int i=)
    }
    public void delete_animal_indice(int indice){
            if(indice==-1){
              System.out.println("L'anima l'existe pas dans la liste");
              return;
            }else if(indice>=this.la.length){
               System.out.println("Erreur l'indice i dans delete animal dépasse la taille de la");
                return;
            }else if(this.la[indice]==null){
              System.out.println("Erreur l'indice i dans delete animal est null");
              return;
            }else if(this.la[indice+1]==null){
              this.la[indice]=null;
              return;
            }else{
              for(int i=indice+1;la[i]!=null;i++){
                    la[i-1]=la[i];  
              }
               return;
            }   
    
    }
    public void 

  
  }