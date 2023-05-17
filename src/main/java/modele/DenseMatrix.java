package modele;
public class DenseMatrix {
    private double[][] vals;
    private int nRow;
    private int nCol;

    public DenseMatrix(){
        nRow = 0;
        nCol = 0;
        vals = new double[nRow][nCol];
    }

    public DenseMatrix(double[][] parMat){
        nRow = parMat.length;
        nCol = parMat[0].length;
        vals = parMat;
    }
    public DenseMatrix(int parM, int parN){
        nRow = parM;
        nCol = parN;
        vals = new double[nRow][nCol];
    }

    public int getRowDimension(){
        return nRow;
    }

    public int getColDimension(){
        return nCol;
    }

    public double get(int i, int j){
        return vals[i][j];
    }

    public void set(int i, int j, double aij){
        vals[i][j] = aij;
    }

    public void write(){
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++){
                System.out.print(vals[i][j] + " ");
            }
            System.out.println();
        }
    }

    public DenseMatrix sum(DenseMatrix parMatriceB){
        if (parMatriceB.nCol != nCol || parMatriceB.nRow != nRow){
            return new DenseMatrix();
        }
        DenseMatrix newMatice = new DenseMatrix(nRow,nCol);
        for (int i = 0;i < nRow; i++){
            for (int j = 0;i < nCol; j++){
                newMatice.set(i,j,(vals[i][j] + parMatriceB.get(i,j)));
            }
        }
        return newMatice;
    }

    public DenseMatrix minus(DenseMatrix parMatriceB){
        if (parMatriceB.nCol != nCol || parMatriceB.nRow != nRow){
            return new DenseMatrix();
        }
        DenseMatrix newMatice = new DenseMatrix(nRow,nCol);
        for (int i = 0;i < nRow; i++){
            for (int j = 0;i < nCol; j++){
                newMatice.set(i,j,(vals[i][j] - parMatriceB.get(i,j)));
            }
        }
        return newMatice;
    }

    public DenseMatrix mult(double s){
        DenseMatrix newMatice = new DenseMatrix(nRow,nCol);
        for (int i = 0;i < nRow; i++){
            for (int j = 0;i < nCol; j++){
                newMatice.set(i,j,(vals[i][j] * s));
            }
        }
        return newMatice;
    }

    public DenseMatrix mult(DenseMatrix parMatriceB){
        if (parMatriceB.nCol != nRow){
            return new DenseMatrix();
        }
        DenseMatrix newMatice = new DenseMatrix(nRow,nCol);
        for (int i = 0;i < nRow; i++){
            for (int j = 0;i < nCol; j++){
                double sum = 0;
                for (int k = 0; k < nRow; k++){
                    sum += vals[i][k] * parMatriceB.get(k,j);
                }
                newMatice.set(i,j,sum);
            }
        }
        return newMatice;
    }
    public static void main(String [] args){
        DenseMatrix matrice = new DenseMatrix();
        matrice.write();
    }



}
