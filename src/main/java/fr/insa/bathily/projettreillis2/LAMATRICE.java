/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author donia
 */
import java.text.DecimalFormat;
import Jama.*;
import recup.Lire;
public class Matrice {
    //----------------partie1.1
    private int nbrLig;
    
    private int nbrCol;
    
    private double[][] coeffs;
    
    
    //----------------partie 1.2
    
     * @param nbrLig nombre de ligne
     * @param nbrCol nombre de colonnes
     */
    //Constructeur avec arguments
    public Matrice(int nl, int nc)
    {
        this.nbrLig=nl;
        this.nbrCol=nc;
        this.coeffs=new double [nl][nc];
    
    }
     */
    private Matrice(double[][] coeffs) {
        this.nbrLig = coeffs.length;
        this.nbrCol = coeffs[0].length;
        this.coeffs = coeffs;
    }
    
    //-----------partie 1.3
   
   
    
    // affichage d'une matrice

    public String toString() {
        String res = "";
        for (int i = 0; i < nbrLig; i++) {
            res = res + "[";
            for (int j = 0; j < nbrCol; j++) {
                res = res + formatDouble(this.getCoeffs(i, j));
                if (j < nbrCol - 1) {
                    res = res + " ";
                }
            }
            res = res + "]\n";
        }
        return res;
    }
    
    //-----------partie 1.4
   
    //Methode identite
    public static Matrice identite (int taille){
        Matrice id= new Matrice (taille,taille);
        for (int i=0; i<taille; i++){
                    id.coeffs[i][i]=1;
        }
       return id;
    }
    
    public static Matrice matTest1 (int taille){
        Matrice mtest = new Matrice (taille,taille);
        int a=0;
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                mtest.coeffs[i][j]=a;
                a+=1;
            }
        }
        return mtest;
    }
       
    public static Matrice matTest2(int n){
        Matrice mtest2=matTest1(n);
        for(int i=0; i<n; i++){
            mtest2.coeffs[i][i]=-mtest2.coeffs[i][i];
        }
        return mtest2;
    }

        /**
     
     * @return aléatoirement 1 ou 2.
     */
    public static int aleaUnOuDeux(){
        return (int)(Math.random()*10)%2+1;
            }
   
   
    public static Matrice matAleaZeroUnDeux(int nbrLig, int nbrCol, double proportionDeZero) {
        Matrice res = new Matrice(nbrLig, nbrCol);
        for (int i = 0; i < nbrLig; i++) {
            for (int j = 0; j < nbrCol; j++) {
                if (Math.random() >= proportionDeZero) {
                    res.coeffs[i][j] = aleaUnOuDeux();
                }
            }
        }
        return res;
    }

    public static Matrice creeVecteur(double[] composantes){
        Matrice res=new Matrice(composantes.length,1);
        for (int i=0; i<composantes.length; i++){
            res.coeffs[i][1]=composantes[i];
        }
    return res;
    }
   
    //-------------partie 1.5
    
    public int getNbrLig() {
        return this.nbrLig;
    }

    public int getNbrCol() {
        return this.nbrCol;
    }

    public void setNbrLig(int nbrLig) {
        this.nbrLig = nbrLig;
    }

    public void setNbrCol(int nbrCol) {
        this.nbrCol = nbrCol;
    }
             
    public double getCoeffs(int i, int j){
        return this.coeffs[i][j];
    }
    
    public void setCoeffs (int i, int j, double val){
        this.coeffs[i][j]=val;
    }
    
    //------------partie 1.6
    
    public static void test1(int nl, int nc, double pz){
        System.out.println("TST1");
        System.out.println("matrice random  taille " + nl + " x " + nc
                + " (probabilite de zero : " + pz + ") : ");
        Matrice m=matAleaZeroUnDeux(nl, nc, pz);
        System.out.println(m.toString());
    }
    
    
    
    
    
    
//-------------partie 2.1
 public Matrice concatLig (Matrice N){
        if(this.getNbrCol()!=N.getNbrCol()){
            throw new Error("les nbrs de colonnes des deux matrices ne sont pas les mêmes");
        }
        Matrice R= new Matrice(this.getNbrLig()+N.getNbrLig(),N.getNbrCol());
        for(int i=0; i<R.getNbrLig(); i++){
            for (int j=0; j<R.getNbrCol(); j++ ){
                if (i<this.getNbrLig()){
            R.setCoeffs(i,j,this.getCoeffs(i,j));
                }
        else{
            R.setCoeffs(i,j,N.getCoeffs(i-this.getNbrLig(),j));
             }
        }
    }    
    return R;    
}
    
public Matrice concatCol (Matrice N){
   if(this.getNbrLig()!=N.getNbrLig()){
           throw new Error("les nbrs de lignes des deux matrices ne sont pas les mêmes");
        }
        Matrice R= new Matrice(this.getNbrLig(),N.getNbrCol()+this.getNbrCol());
        for(int i=0; i<R.getNbrLig(); i++){
            for (int j=0; j<R.getNbrCol(); j++ ){
                if (j<this.getNbrCol()){
                    R.setCoeffs(i,j,this.getCoeffs(i,j));
                }
                else{
                    R.setCoeffs(i,j,N.getCoeffs(i,j-this.getNbrCol()));
                 }
            }
        }   
    return R;    
}


//----------partie 2.2

public Matrice subLignes(int nMin, int nMax){
    if((0>nMin) || (nMin>nMax) || (nMax>this.getNbrLig())){
        throw new Error("ERREUR ! ");
    }
    Matrice R= new Matrice(nMax-nMin+1,this.getNbrCol());
    for (int lig=0; lig<R.getNbrLig(); lig++){
        for(int col=0; col<R.getNbrCol(); col++){
            R.setCoeffs(lig,col,this.getCoeffs(nMin+lig, col));
        }
    }
    return R;
}

   
public Matrice subCols(int cMin, int cMax){
    if((0>cMin) || (cMin>cMax) || (cMax>this.getNbrCol())){
        throw new Error("ERREUR !");
    }
    Matrice R= new Matrice(this.getNbrLig(),cMax-cMin+1);
    for (int lig=0; lig<R.getNbrLig(); lig++){
        for(int col=0; col<R.getNbrCol(); col++){
            R.setCoeffs(lig,col,this.getCoeffs(lig,cMin+col));
        }
    }
    return R;
}


 public Matrice copie(){ 
    return this.subLignes(0,this.getNbrLig()-1);
}

//------------partie 2.3
public Matrice transposee(){
    Matrice Mt=new Matrice(this.getNbrCol(), this.getNbrLig());
    for(int i=0; i<Mt.getNbrLig(); i++){
        for(int j=0; j<Mt.getNbrCol(); j++){
            Mt.setCoeffs(i,j,this.getCoeffs(j, i));   
        }
    }
   return Mt;
}


//---------partie 2.4
public Matrice metAuCarre(){
    return this.concatCol(Matrice.identite(this.getNbrLig())).concatLig(
                Matrice.identite(this.getNbrCol()).concatCol(this.transposee()));
}

public static int intAlea(int bmin, int bmax){
    return (int)(Math.random() * (bmax-bmin)) + bmin;
}

public static void test2(int nl, int nc, double pz){
    System.out.println("TST2");
    int nl2=intAlea(nl,nc);
    int nc2=intAlea(nl,nc);
    Matrice M = matAleaZeroUnDeux(nl2,nc2,0.33);
    Matrice Mc = M.metAuCarre();
    Matrice Mbis=Mc.subLignes(0,nl2-1).subCols(0,nc2-1);
    System.out.println("M --> matrice de base");
    System.out.println(M.toString());
    System.out.println("Mc ---> mise au carré");
    System.out.println(Mc.toString());
    System.out.println("Mbis --> sub de mc  ");
    System.out.println(Mbis.toString());
}





//-----------partie 3.1
   
public Matrice add(Matrice N){
    if ((this.getNbrLig()!=N.getNbrLig()) || (this.getNbrCol()!=N.getNbrCol())){
        throw new Error("les deux matrices doivent avoir la M taille");
    }
        Matrice R= new Matrice(N.getNbrLig(),N.getNbrCol());
        for (int i=0; i<R.getNbrLig(); i++){
            for(int j=0; j<R.getNbrCol(); j++){
                R.setCoeffs(i, j, this.getCoeffs(i, j)+N.getCoeffs(i, j));
            }
        }
     return R;
}

//--------------- partie 3.2
   
public Matrice opp(){
    Matrice R=new Matrice(this.getNbrLig(),this.getNbrCol());
    for (int i=0; i<R.getNbrLig(); i++){
        for (int j=0; j<R.getNbrCol(); j++){
            R.setCoeffs(i, j, R.getCoeffs(i,j)*(-1));
        }
    }
    return R;
}

//--------------- partie 3.3
  
public Matrice moins(Matrice N){
return this.add(N.opp());
}

//---------------- partie 3.4
public Matrice mult(Matrice N){
    if(this.getNbrCol()!=N.getNbrLig()){
        throw new Error("le nbr de col de 1ere matrice doit être = au nbr de col de la 2eme matrice");
    }
    Matrice R=new Matrice(this.getNbrLig(),N.getNbrCol());
    for (int i=0; i<this.getNbrLig(); i++){
	for (int j=0; j<N.getNbrCol(); j++){
            double cur =0;
            for(int k=0; k<N.getNbrLig(); k++){
                cur = cur +this.getCoeffs(i,k)*N.getCoeffs(k,j);
            }
                R.setCoeffs(i,j,cur);
        }
    }
    return R;
}

//---------------- partie 3.5
public static void test3(int taille){
    System.out.println("TST3");
    Matrice m=matTest1(taille);
    System.out.println("matrice M ");
    System.out.println(m);
    System.out.println("matrice M + M^2");
    System.out.println(m.add(m.mult(m)));
}





//----------------- partie 4.3
/**
    
     */
public int permuteLigne(int i1, int i2){
    double temp;
        int ind=0;
        for(int j=0; j<this.getNbrCol(); j++){
            if(this.getCoeffs(i1,j)== this.getCoeffs(i2,j)){
                ind=ind+1;
            }
        }
    if (ind!=this.nbrCol){
        for(int i=0; i<this.getNbrCol(); i++){
            temp=this.getCoeffs(i1,i);
            this.setCoeffs(i1,i,this.getCoeffs(i2,i));
            this.setCoeffs(i2,i,temp);
        }
        return -1;
    }
    else{
        return 1;
    }  
}

/**
    
*/
public Matrice transvection (int i1, int i2){
    if(this.getCoeffs(i1,i1)==0){
        throw new Error("ERREUR! on ne peut pas diviser par 0");
    }
    double p= this.getCoeffs(i2, i1) / this.getCoeffs(i1,i1);
    for (int j=0;j<this.getNbrCol();j++){
        if (j==i1){
            this.setCoeffs(i2,j,0);
        }
        else{
            this.setCoeffs(i2,j,this.getCoeffs(i2,j)-p*this.getCoeffs(i1,j));
        }
    }
    return this;
}

/**
*che
*/
public int lignePlusGrandPivot(int e){
    int ligMax=e;
    double epsilon_pivot=Math.pow(10, -8);
    for (int i=e+1; i<this.getNbrLig(); i++){
        if(Math.abs(this.getCoeffs(i, e))> Math.abs(this.getCoeffs(ligMax, e) )){
            ligMax=i;
        }
    }
    if(Math.abs(this.getCoeffs(ligMax, e))<=epsilon_pivot) {
        return -1;
    }
    else{
        return ligMax;
    }
}


public ResGauss descenteGauss(){
    int lignepivot;
    ResGauss res= new ResGauss(0,1);
    for(int i=0; i<Math.min(this.getNbrLig(),this.getNbrCol()); i++){
        lignepivot= this.lignePlusGrandPivot(i);
        if(lignepivot!=-1){
            res.sigPerm=res.sigPerm*this.permuteLigne(i, lignepivot);
            res.rang=res.rang+1;
            for (int i2=i+1; i2<this.getNbrLig(); i2++){
                this.transvection(i, i2);
            }
        }
        else{
           System.out.println("la matrice n'est pas inversible");
        }
    }
System.out.println(this.toString());  
System.out.println(res) ; 
System.out.println();
return res;
}

public static void test4(){
    System.out.println("TST4");
    Matrice m1=matTest1(3);
    Matrice m2=matTest2(3);
    Matrice vecteur= new Matrice(3,1);
    vecteur.setCoeffs(0, 0, 1);
    vecteur.setCoeffs(1, 0, 2);
    vecteur.setCoeffs(2, 0, 3);
    m1=m1.concatCol(vecteur);
    m2=m2.concatCol(vecteur);
    m1.descenteGauss();
    m2.descenteGauss();
}



//---------------partie 4.4

public double determinant(){
    if(this.getNbrCol()!=this.getNbrLig()){
        throw new Error("La matrice n'est pas une matrice carrée");
    }
    Matrice m = this.copie();
        ResGauss res = m.descenteGauss();
        if (res.rang != this.getNbrLig()) {
            return 0;
        } else {
            double det = res.sigPerm;
            for (int k = 0; k < this.getNbrLig(); k++) {
                det = det * m.getCoeffs(k, k);
            }
            return det;
        }
}



//---------------partie 4.5.3
public Matrix toMatrix(){
    Matrix m = new Matrix(this.getNbrLig(),this.getNbrCol());
    for(int i=0; i<this.getNbrLig();i++){
        for(int j=0; j<this.getNbrCol(); j++){
            m.set(i,j,this.getCoeffs(i,j));
        }
    }
return m;
}

public static Matrice fromMatrix (Matrix m){
    Matrice res= new Matrice(m.getRowDimension(),m.getRowDimension());
    for (int i=0; i<m.getRowDimension(); i++){
        for (int j=0; j<m.getColumnDimension(); j++){
            res.setCoeffs(i, j, m.get(i, i));
        }
    }
return res;
}

public double testDet (){
    return Math.abs(this.determinant()-this.toMatrix().det());
}

public static void test5(int nbrTest, int n){
    System.out.println("TST5");
    double max=0;
    Matrice matricemax=new Matrice(n,n);
    for(int i=0; i<nbrTest; i++){
        Matrice m=matAleaZeroUnDeux(n,n,0.33);
        double diff=m.testDet();
        if(diff>max){
            max=diff;
            matricemax=m;
        }
    }
    System.out.println("la différence maximale est "+max);
    if(max!=0){
        System.out.println(matricemax);
    }
}


//---------------------partie 5
public Matrice unitaire(){
    for(int i=0;i<this.getNbrLig(); i++){
        if(this.getCoeffs(i,i)!=1){
            for(int j=this.getNbrCol()-1; j>i-1; j--){
                this.setCoeffs(i,j,this.getCoeffs(i, j)/this.getCoeffs(i, i));
            }
        }
    }
return this;
}

public Matrice remontéeGauss(){
    for(int i=this.getNbrLig()-1; i>0; i--){
        for(int j=i-1; j>-1; j--){
            this.transvection(i, j);
        }
    }
return this;
}

public static void resolution(){
    System.out.println("nbr d'iconnues? ");
    int inc=Lire.i();
    Matrice m= new Matrice (inc, inc+1);
    for(int i=0; i<m.getNbrLig(); i++){
        for(int j=0; j<m.getNbrCol(); j++){
            System.out.println("Entrez le coef ("+ (i+1)+","+ (j+1)+")");
            m.setCoeffs(i,j,Lire.d());
        }
    }
    if(m.subCols(0,m.getNbrCol()-2).determinant()==0){
        System.out.println("Le système n'a pas de solution OU le systeme a une infinité de solutions");
    }
    else{
        m.descenteGauss();
        m.remontéeGauss().unitaire();
        System.out.println("Les solutions sont");
        System.out.println(m.subCols(m.getNbrCol()-1,m.getNbrCol()-1).toString());
    }
}

}
