/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Vide extends Case {
    
    private int somme;  // Le nombre des mines dans les cases adjacentes

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }
    
    public Vide(Plateau p,int i, int j){
        super(p,i,j);
        setNom("Vide");
        this.somme=0;
    }
    public void sommeMines(){
        int k=1;
        do{
            if((this.getV().getT(k)!=null) && this.getV().getT(k).getNom().equals("Mine")){
                    this.somme=this.somme+1;
            }                          
            k++;
           }while(k<9);
    }
        
     // Remplissage du tableau de voisinnage en se basant sur les cordonnées de la case
     public  void initVoisinage(){
        int i=this.getL(); 
        int j=this.getC();
        if(i==0 && j==0){
            this.getV().setT(this.getP().getT(i, j+1), 5);
               this.getV().setT(this.getP().getT(i+1, j), 7);
                  this.getV().setT(this.getP().getT(i+1, j+1), 8);
        }
        else if(i==this.getP().getNl()-1 && j==this.getP().getNc()-1){
              this.getV().setT(this.getP().getT(i-1, j-1), 1);
                this.getV().setT(this.getP().getT(i-1, j), 2);
                  this.getV().setT(this.getP().getT(i, j-1), 4);
        }
        else if(i==this.getP().getNl()-1 && j==0){
               this.getV().setT(this.getP().getT(i-1, j), 2);
                 this.getV().setT(this.getP().getT(i-1, j+1), 3);
                   this.getV().setT(this.getP().getT(i, j+1), 5);
              
        }
        else if(i==0 && j==this.getP().getNc()-1){
                this.getV().setT(this.getP().getT(i, j-1), 4);
                  this.getV().setT(this.getP().getT(i+1, j-1), 6);
                    this.getV().setT(this.getP().getT(i+1, j), 7);
           
        }
        else if(i==0){
               this.getV().setT(this.getP().getT(i, j-1), 4);
                  this.getV().setT(this.getP().getT(i, j+1), 5);
                     this.getV().setT(this.getP().getT(i+1, j-1), 6);
                        this.getV().setT(this.getP().getT(i+1, j), 7);
                           this.getV().setT(this.getP().getT(i+1, j+1), 8);
        }
        else if(j==0){
            this.getV().setT(this.getP().getT(i-1, j), 2);
               this.getV().setT(this.getP().getT(i-1, j+1), 3);
                  this.getV().setT(this.getP().getT(i, j+1), 5);
                     this.getV().setT(this.getP().getT(i+1, j), 7);
                        this.getV().setT(this.getP().getT(i+1, j+1), 8);
           
        }
        else if(j==this.getP().getNc()-1){
               this.getV().setT(this.getP().getT(i-1, j-1), 1);
                  this.getV().setT(this.getP().getT(i-1, j), 2);
                     this.getV().setT(this.getP().getT(i, j-1), 4);
                        this.getV().setT(this.getP().getT(i+1, j-1), 6);
                           this.getV().setT(this.getP().getT(i+1, j), 7);
        }
        else if(i==this.getP().getNl()-1){
               this.getV().setT(this.getP().getT(i-1, j-1), 1);
                  this.getV().setT(this.getP().getT(i-1, j), 2);
                     this.getV().setT(this.getP().getT(i-1, j+1), 3);
                        this.getV().setT(this.getP().getT(i, j-1), 4);
                            this.getV().setT(this.getP().getT(i, j+1), 5);                     
        }
        else {
               this.getV().setT(this.getP().getT(i-1, j-1), 1);
                  this.getV().setT(this.getP().getT(i-1, j), 2);
                     this.getV().setT(this.getP().getT(i-1, j+1), 3);
                        this.getV().setT(this.getP().getT(i, j-1), 4);
                           this.getV().setT(this.getP().getT(i, j+1), 5);
                              this.getV().setT(this.getP().getT(i+1, j-1), 6);
                                 this.getV().setT(this.getP().getT(i+1, j), 7);
                                    this.getV().setT(this.getP().getT(i+1, j+1), 8);
        }
            
    }
    
    public String toString(){
       if(this.somme!=0){
            return "[  "+this.getSomme()+"  ]";
       }
       else return "[     ]"; 
    }
    
    
    public void active(){
         if(this.getP().getTab(this.getL(), this.getC())==false ){ // Si cette case n'est pas encore activée (affichée)
            this.getP().setTab(this.getL(), this.getC(),true);  // Affichage de cette case 
            if(this.getSomme()==0 ){ // Verifier la somme de cette case
                // Appel recursive de la methode active par les cases adjacentes
                for(int i=1;i<9;i++){ 
                    if(this.getV().getT(i)!=null){ // Verifier si la case existe 
                        this.getV().getT(i).active(); // Appel a la mthode active
                    }
                }
            }
        }
    }   
}
