public class ExceptionPlanning extends Exception{
    private int codeErreur;
    public ExceptionPlanning(int parCodeErreur){
        super(); //Appel au constructeur de la classe mère
        this.codeErreur = parCodeErreur;
    }
    public int getCodeErreur(){
        return codeErreur;
    }
}
