/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Mine extends Case {
    
    
    
    public Mine(Plateau p,int i, int j){
        super(p,i,j);
        setNom("Mine");
    }
    @Override
    public void active(){
        // La récuperation des cordonnées de la case
        int i=this.getL(); 
        int j=this.getC();
        // Affecter true a la case du tableau boolean (c-a-d affichée la case)
        this.getP().setTab(i,j,true);
       
        // Affichage de tous les mines du tableau 
        for(int k=0;k<this.getP().getNl();k++){
            for(int m=0;m<this.getP().getNc();m++){
                if(this.getP().getT(k, m).getNom().equals("Mine")){
                
                    this.getP().setTab(k, m, true);
                }
            }
        }
    }
    public void sommeMines(){}
      public  void initVoisinage(){}
    
    @Override
    public String toString(){
        
            return "[  m  ]";
            
    }
}
