package aff;

import javax.swing.JButton;

public class BoutonBoucle extends JButton{
    Mafenetre f;
    BoutonBoucle(Mafenetre f){
        super("Déplacer en boucle");
        this.f=f;
       this.addActionListener( _-> {
            if(f.en_mouvement){
               this.setText("Deplacer en boucle");
            }else{
               this.setText("Arreter la boucle");
            }
            f.dessiner_boucle();
    });
    }    
}
