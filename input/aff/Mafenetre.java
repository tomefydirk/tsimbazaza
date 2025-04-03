package aff;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.*;

import zoo.*;
public class Mafenetre extends JFrame{
    Zoo zoo;
    Dessin d;
    boolean en_mouvement;
    public void init_bouton_panel(Vector<JButton> j1){
        JPanel bouton_panel = new JPanel();
        for(int i=0;i<j1.size();i++){
            bouton_panel.add(j1.elementAt(i));
        }
          add(d,BorderLayout.CENTER);
          add(bouton_panel,BorderLayout.SOUTH);
      
    }
    public Mafenetre(Zoo zoo,int marg_x,int marg_y,int echelle) {
        this.zoo=zoo;
        this.en_mouvement=false;
        setTitle("Zoo simulation");
		setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        d=new Dessin(zoo,marg_x,marg_y,echelle);
        add(d);
        setVisible(true);
        BoutonBoucle deplacerButton_boucle = new BoutonBoucle(this);
        BoutonDep deplButton = new BoutonDep(this);
        Vector<JButton>  LB = new Vector<JButton>(); 
        LB.add(deplacerButton_boucle);
        LB.add(deplButton);
        init_bouton_panel(LB);
    }
    public void dessiner_boucle(){
        if(en_mouvement){
            this.en_mouvement=false;
            return;
        }else{
            en_mouvement=true;
            new Thread(()->{
                while(this.en_mouvement){
                dessiner_1();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
        
                } 
            }}).start();
        }
     
      
    }
    public void dessiner_1(){
            if(en_mouvement){
                zoo.deplacer_tous();
            }
            
            d.repaint();
            zoo.afficher_la();
           
    }
    public void dessiner_2(){
        zoo.deplacer_tous();
        d.repaint();
    } 
}
