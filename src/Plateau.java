/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Plateau {
    
    private int nl,nc;  // Nombre de lignes et le nombre de colonnes
    private int niveau;  // Le niveau du jeu
    private Case[][] T;  // Tableau bidimentionnel de type Case
    private boolean tab[][]; // Tableau bidimentionnel de type boolean qui aide a savoir les cases affichées et les non affichées
    private boolean terminer; // Savoir l'état de jeu (Terminer ou non)
    private int coup;  // Stocker le coup
    

    public boolean getTab(int i,int j) {
        return tab[i][j];
    }

    public void setTab(int i,int j,boolean b) {
        this.tab[i][j] = b;
    }

    public int getCoup() {
        return coup;
    }

    public void setCoup(int coup) {
        this.coup = coup;
    }

   

    public int getNl() {
        return nl;
    }

    public void setNl(int nl) {
        this.nl = nl;
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Case getT(int i,int j) {
        return this.T[i][j];
    }

    public boolean getTerminer() {
        return terminer;
    }

    public void setTerminer(boolean k) {
        this.terminer = k;
    }
    

  
    

    public Plateau(int nl, int nc, int niveau) {
        this.nl = nl;
        this.nc = nc;
        this.niveau = niveau;
        this.terminer=false;
        this.coup=1;
        T=new Case[this.getNl()][this.getNc()];
        tab =new boolean [this.getNl()][this.getNc()];
        initPlateau();
  
        
    }
    public void initPlateau(){
        for(int i=0;i<this.nl;i++){
            for(int j=0;j<this.nc;j++){
                   // T[i][j]=new Case(this,i,j);
                    T[i][j]=new Vide(this,i,j);
                    tab[i][j]=false;
                    
                     
           
        }
       
        }
        
        
    }
    public void placerLesmines(){
         int m=getNbMine()-1;
         int x=0;
        do{
            int i = (int)(Math.random()*getNl()-1);
            int j = (int)(Math.random()*getNc()-1);
            
            if(!T[i][j].getNom().equals("Mine"))  
            {  T[i][j]=new Mine(this, i, j);
               System.out.println(m);
               m--;}
        }while(m>=0);
    }
    
    public int getNbMine(){
        int k=(getNc()*getNl()*getNiveau())/10;
        return k;
    }
    
    public String toString(int k,int l){
          
        String res=""; // Déclaration d'une chaine de charactère vide
        this.coup++;  // Incrémentation de la valeur du coup
        int t=this.getNc()*this.getNl() ; // Calcul du nombre de case
        
        // Boucle qui sert a calculer le nombre de case vide affichées
         for(int i=0; i<this.getNl();i++){
            for(int j=0; j<this.getNc();j++){
                if(T[i][j].getNom().equals("Vide") && this.getTab(i,j)==true){
                    t--;
                }
            }
            }      
        if(this.getNbMine()==t){ // Tester si toutes lesb cases non affichées sont des mines
            this.terminer=true;  // Affecter true a l'attribut terminer
            res+="Vous avez gagner en "+this.coup+" coups \n" ; 
            // Affichage du tableau
            for(int i=0; i<this.getNl();i++){
                for(int j=0; j<this.getNc();j++){
                    res+=T[i][j].toString();
                }
                res+="\n";
            }
        }
        // Tester si le joueur a perdu
        else if(T[k][l].getNom().equals("Mine")){
            res+="Vous avez perdu ! \n";
            this.terminer=true; 
            // Affichage du tableau
             for(int i=0; i<this.getNl();i++){
                    for(int j=0; j<this.getNc();j++){
                         if(tab[i][j]==false)
                               res+="[ "+i+":"+j+" ]";
                         else if(i!=k || j!=l)               
                               res+=T[i][j].toString()+"";
                         else if(i==k && j==l)
                                res+="[  *  ]";   
            }
            res+="\n";
        } 
        }
         else {

        // Affichage du tableau (Jeu n'est pas terminer)        
        for(int i=0; i<this.getNl();i++){
            for(int j=0; j<this.getNc();j++){
                if(tab[i][j]==false){
                    res+="[ "+i+":"+j+" ]";
                }
                else
                           res+=T[i][j].toString()+"";    
            }
            res+="\n";
        }  
      }  return res;}
}
    
    
 
    
    
    
    

