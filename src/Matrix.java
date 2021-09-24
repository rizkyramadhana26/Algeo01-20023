import java.util.Scanner;
import java.lang.Math;

public class Matrix {
    //ATRIBUT
    int rows;
    int cols;
    double[][] matrix; 

    public static void main(String[] args) {
        System.out.print("");
    }

    public Matrix(int rows, int cols) { //KONSTRUKTOR
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols]; 
        //NOTE : INI DI GOOGLE TERNYATA KALAU UDAH DI CONSTRUCT ROW SAMA BARISNYA, UDAH GABISA DIUBAH LAGI SIZE MATRIXNYA
        //KALAU MAU GANTI SIZE KARENA GACUKUP BIKIN VARIABEL BARU AJA PAKAI EXTENDMATRIX()
        }

    //METHOD PRIMITIF MATRIKS
    public void readMatrix(int rows, int cols) { //MEMBACA ELEMEN DARI USER
        int i, j,elemen;
        Scanner sc = new Scanner(System.in);
        this.rows = rows;
        this.cols = cols;
        for (i=1;i<=rows;i++) {
            for (j=1; j<=cols; j++) {
                System.out.print("Masukkan nilai untuk baris ke-" +i+" kolom ke-" +j+": ");
                elemen = sc.nextInt();
                this.matrix[i-1][j-1] = elemen;
            }
        }
    }

    public void displayMatrix() { // UNTUK MENCETAK MATRIKSNYA
        int i,j ;
        for (i=0;i<this.rows;i++) {
            for (j=0; j<this.cols; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void createMatrix(int rows, int cols){ //MENGISI SEMUA ELEMEN JADI 0
        int i, j;
        Scanner sc = new Scanner(System.in);
        for (i=0;i<this.rows;i++) {
            for (j=0; j<this.cols; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix copyMatrix() { //NYUALIN PERSIS MATRIXNYA TRUS DIRETURN
        Matrix mOutput = new Matrix(this.rows,this.cols);
        int i,j ;
        mOutput.rows = this.rows;
        mOutput.cols = this.cols;
        for (i=0;i<this.rows;i++) {
            for (j=0; j<this.cols; j++) {
               mOutput.matrix[i][j] = this.matrix[i][j] ;
            }
        }
        return mOutput ;
    }

    public Matrix extendMatrix(int row, int col) { //SAMA SEPERTI COPY MATRIX, TAPI UKURANNYA DITAMBAH AJA TRUS BIARIN KOSONG
        Matrix mOutput = new Matrix(this.rows,this.cols);
        int i,j ;
        mOutput.rows = this.rows + row;
        mOutput.cols = this.cols + col;
        for (i=0;i<this.rows;i++) {
            for (j=0; j<this.cols; j++) {
               mOutput.matrix[i][j] = this.matrix[i][j] ;
            }
        }
        return mOutput ;
    }

    public boolean isRowsZero() { //MENGECEK APAKAH ADA ROWS YANG MURNI 0
        boolean ada = false;
        boolean sebaris0 = true;
        int i,j ;
        for (i=0;i<this.rows; i++) {
            for (j=0;j<this.cols; j++) {
                if (this.matrix[i][j] != 0) {
                    sebaris0 = false;
                }
            }
            if (sebaris0 == true) {
                ada = true;
            }
            sebaris0 = true;
        }
    return ada;
    }

    public boolean isColsZero() { //MENGECEK APAKAH ADA ROWS YANG MURNI 0
        boolean ada = false;
        boolean sekolom0 = true;
        int i,j ;
        for (j=0;j<this.cols; j++) {
            for (i=0;i<this.rows; i++) {
                if (this.matrix[i][j] != 0) {
                    sekolom0 = false;
                }
            }
            if (sekolom0 == true) {
                ada = true;
            }
            sekolom0 = true;
        }
    return ada;
    }

    public boolean isSegitigaAtas() { // Matriks bagian atas berisi elemen, bagian bawah diagonal 0 semua
        boolean bener = true;
        int i,j;
        if (this.rows <2 || this.cols <2) {
            return false;
        }
        else {
            for (i=1;i<this.rows; i++) {
                for (j=0;j<i; j++) {
                    if (this.matrix[i][j] != 0) {
                        bener = false;
                    }
                }
            }
        }
        return bener;
    }

    //METHOD GAUSS DAN KAWAN KAWANA
    void swap_row(int row1, int row2){ //ROW1 DAN ROW2 MENGGANTI BERDASARKAN INDEKS BUKAN BARIS
        int k;
        double temp;
        for (k=0; k<this.cols; k++){
            temp = this.matrix[row1][k];
            this.matrix[row1][k] = this.matrix[row2][k];
            this.matrix[row2][k] = temp;
        }
    }

    public void OBEsegitigaAtas(){ //INI SEGITIGA ATASNYA ADA KESALAHAN PRESISI DIKIT e^-16 an mungkin
        int k,i,j;
        for (k = 0; k < this.cols; k++){
            int imaks = k;
            int value = (int)this.matrix[imaks][k];
            for (i = k + 1; i < this.rows; i++){
                if (Math.abs(this.matrix[i][k]) > value){
                    value = (int)this.matrix[i][k];
                    imaks = i;
                }
            }
            if (this.matrix[k][imaks] == 0){ //matriksnya singular bos
                System.out.println("Matriksnya singuar");
            }
            if (imaks != k){
                swap_row(k, imaks);
            }
            for (i = k + 1; i < this.rows; i++){
                double faktor = this.matrix[i][k] / this.matrix[k][k];
                for (j = k + 1; j < this.cols; j++){
                this.matrix[i][j] -= this.matrix[k][j] * faktor;
                }
                this.matrix[i][k] = 0;
            } 
        }
    }

    public Matrix convertToSegitigaAtas() { //convert matrixnya pake OBE nya ke segitiga bawah, prekondisi : matriks persegi
        Matrix mOutput = new Matrix(this.rows,this.cols);
        mOutput = this.copyMatrix();
        int i,j,k;
        if (this.rows != this.cols) {
            System.out.println("Tidak bisa dikonversi ke matriks segitiga.");
        }
        else if (isRowsZero() || isColsZero()) {
            System.out.println("Terdapat baris atau kolom yang elemennya 0 semua");
        }
        else if (isSegitigaAtas()) {
            System.out.println("Sudah merupakan segitiga atas");
        }
        else {
            mOutput.OBEsegitigaAtas();
        }
        return mOutput;
    }
}