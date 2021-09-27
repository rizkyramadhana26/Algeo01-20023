import java.util.Scanner;
import java.lang.Math;

public class Matrix {
    //ATRIBUT
    int rows;
    int cols;
    double[][] matrix;

    public static void main(String[] args) { //gatau dah tadi aku gapake main error soalnya waktu compile aowkwokao
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
    public void readMatrix(int rows, int cols) { //MEMBACA ELEMEN DARI USER, prekondisi rows dan cols lebih kecil dari size yang udah dideclare
        int i, j,elemen;
        Scanner sc = new Scanner(System.in);
        this.rows = rows;
        this.cols = cols;
        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= cols; j++) {
                System.out.print("Masukkan nilai untuk baris ke-" + i + " kolom ke-" + j + ": ");
                elemen = sc.nextInt();
                this.matrix[i - 1][j - 1] = elemen;
            }
        }
    }

    public void displayMatrix() { // UNTUK MENCETAK MATRIKSNYA
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                System.out.printf("%.2f ", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void createMatrix(int rows, int cols) { //MENGISI SEMUA ELEMEN JADI 0
        int i, j;
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                this.matrix[i][j] = 0;
            }
        }
    }

    public Matrix copyMatrix() { //NYUALIN PERSIS MATRIXNYA TRUS DIRETURN
        Matrix mOutput = new Matrix(this.rows, this.cols);
        int i, j;
        mOutput.rows = this.rows;
        mOutput.cols = this.cols;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                mOutput.matrix[i][j] = this.matrix[i][j];
            }
        }
        return mOutput;
    }

    public Matrix extendMatrix(int row, int col) { //SAMA SEPERTI COPY MATRIX, TAPI UKURANNYA DITAMBAH AJA TRUS BIARIN KOSONG
        Matrix mOutput = new Matrix(this.rows, this.cols);
        int i, j;
        mOutput.rows = this.rows + row;
        mOutput.cols = this.cols + col;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
                mOutput.matrix[i][j] = this.matrix[i][j];
            }
        }
        //inisialisasi elemen baru dengan 0
        for (i = this.rows; i < mOutput.rows; i++) {
            for (j = this.cols; j < mOutput.cols; j++) {
                mOutput.matrix[i][j] = 0;
            }
        }
        return mOutput;
    }

    public boolean isRowsZero() { //MENGECEK APAKAH ADA ROWS YANG MURNI 0
        boolean ada = false;
        boolean sebaris0 = true;
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.cols; j++) {
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
        int i, j;
        for (j = 0; j < this.cols; j++) {
            for (i = 0; i < this.rows; i++) {
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
        int i, j;
        if (this.rows < 2 || this.cols < 2) {
            return false;
        } else {
            for (i = 1; i < this.rows; i++) {
                for (j = 0; j < i; j++) {
                    if (this.matrix[i][j] != 0) {
                        bener = false;
                    }
                }
            }
        }
        return bener;
    }

    //METHOD GAUSS DAN KAWAN KAWANA
    void swap_row(int row1, int row2) { //ROW1 DAN ROW2 MENGGANTI BERDASARKAN INDEKS BUKAN BARIS
        int k;
        double temp;
        for (k = 0; k < this.cols; k++) {
            temp = this.matrix[row1][k];
            this.matrix[row1][k] = this.matrix[row2][k];
            this.matrix[row2][k] = temp;
        }
    }

    public int OBEsegitigaAtas(){ //ngereturn swapnya ganjil atau genap sama prosedur buat ngubah ke segitiga
        int k,i,j;
        int tukar = 0;
        System.out.println("Matrix awal");
        displayMatrix();
        for (k = 0; k < this.cols; k++){
            int imaks = k;
            int value = (int) this.matrix[imaks][k];
            for (i = k + 1; i < this.rows; i++) {
                if (Math.abs(this.matrix[i][k]) > value) {
                    value = (int) this.matrix[i][k];
                    imaks = i;
                }
            }
            if (this.matrix[k][imaks] == 0){ 
                System.out.println("Matriksnya singular");
            }
            if (imaks != k) {
                swap_row(k, imaks);
                tukar += 1;
                System.out.printf("Tukar baris ke-%d dan baris ke-%d\n", (k+1), (imaks+1));
                displayMatrix();
            }
            for (i = k + 1; i < this.rows; i++) {
                double faktor = this.matrix[i][k] / this.matrix[k][k];
                for (j = k + 1; j < this.cols; j++) {
                    this.matrix[i][j] -= this.matrix[k][j] * faktor;
                }
                this.matrix[i][k] = 0;
                System.out.printf("Baris ke-%d dikurangi baris ke-%d dikali %.2f\n", (i+1), (k+1), faktor);
                displayMatrix();
            }
        }
        return tukar;
    }

    public Matrix convertToSegitigaAtas() { //convert matrixnya pake OBE nya ke segitiga bawah, prekondisi : matriks persegi
        Matrix mOutput = new Matrix(this.rows, this.cols);
        mOutput = this.copyMatrix();
        int i, j, k;
        if (this.rows != this.cols) {
            System.out.println("Tidak bisa dikonversi ke matriks segitiga.");
        } else if (isRowsZero() || isColsZero()) {
            System.out.println("Terdapat baris atau kolom yang elemennya 0 semua");
        } else if (isSegitigaAtas()) {
            System.out.println("Sudah merupakan segitiga atas");
        } else {
            mOutput.OBEsegitigaAtas();
        }
        return mOutput;
    }
    public double determinanOBE() { //PREKONDISI : MATRIKSNYA SUDAH PASTI PERSEGI. PROSES PENANGANAN DI MAIN.JAVA
        Matrix mOutput = new Matrix(this.rows,this.cols);
        double determinan = 1 ;
        mOutput = this.copyMatrix();
        int i,j,k,tukar;
        if (this.rows != this.cols) {
            System.out.println("Tidak bisa dikonversi ke matriks segitiga karena bukan matriks persegi.");
            return 0;
        }
        else if (this.isColsZero() || this.isRowsZero()) {
            System.out.println("Terdapat baris atau kolom yang elemennya 0 semua, determinannya 0.");
            if (!this.isSegitigaAtas()) {
                System.out.println("Maka tidak perlu diubah ke bentuk segitiga.");
            }
            return 0;
        }
        else {
            tukar = mOutput.OBEsegitigaAtas();
            for (i = 0; i < this.rows; i++) {
                determinan *= mOutput.matrix[i][i] ;
            }
            System.out.println("Bentuk matriksnya setelah operasi segitiga adalah:");
            mOutput.displayMatrix();
            if (tukar %2 ==0){
                return determinan;
            }
            else {
                return determinan*-1;
            }
        }
    }

    public Matrix getMinor(int i, int j) { //ngembaliin minornya
        Matrix mOutput = new Matrix(this.rows-1,this.cols-1);
        int k,l ;
        mOutput.rows = this.rows -1;
        mOutput.cols = this.cols -1;
        for (k=0;k<this.rows;k++) {
            for (l=0; l<this.cols; l++) {
               if (k<i) {
                   if (l<j) {
                        mOutput.matrix[k][l] = this.matrix[k][l];
                   }
                   else if (l>j) {
                        mOutput.matrix[k][l-1] = this.matrix[k][l];
                   }
               }
               if (k>i) {
                   if (l<j) {
                        mOutput.matrix[k-1][l] = this.matrix[k][l];
                   }
                   else if (l>j) {
                        mOutput.matrix[k-1][l-1] = this.matrix[k][l];
                    }
                }
            }
        }
        return mOutput ;
    }

    public double getKofaktor(int i, int j) {//ngembaliin kofaktornya, udah sesuai tanda
        Matrix mOutput = new Matrix(this.rows-1,this.cols-1);
        mOutput = this.getMinor(i,j);
        if (i + j % 2 ==0) {
            return mOutput.determinanKofaktor();
        }
        else {
            return mOutput.determinanKofaktor()*-1;
        }
    }

    public double determinanKofaktor() { //nyari determinan pakai metode kofaktor
        int k,tanda = 1;
        double determinan = 0;
        Matrix sementara = new Matrix(this.rows-1,this.cols-1);
        if (this.rows ==1 ) {
            determinan = this.matrix[0][0] ;
        }
        else {
            for (k=0;k<this.rows;k++) {
                sementara = this.getMinor(0,k);
                determinan += tanda*sementara.determinanKofaktor()*this.matrix[0][k];
                tanda *= -1;
            }
        } 
        return determinan;
    }

    public Matrix kaliMatrix(Matrix m1, Matrix m2) { //PREKONDISI : kolom m1 = baris m2, kalau engga nanti diatasi di main.java aja
        Matrix hasil = new Matrix(m1.rows,m2.cols);
        int i,j,k ;
        double total ;
        for (i=0;i<hasil.rows;i++) {
            for (j=0;j<hasil.cols; j++){
                total = 0;
                for (k=0; k < m2.cols; k++) {
                    total += m1.matrix[i][k]*m2.matrix[k][j];
                }
                hasil.matrix[i][j] = total;
            }
        }
        return hasil;
    }
    public boolean cekEselon() {
        //Mengecek apakah matrix merupakan matriks eselon baris
        int i = 0, j = 0, bukan0, bukan0sebelumnya;
        boolean found, eselon;
        bukan0 = 0; //menyimpan indeks dari elemen pertama yang bukan 0 dari tiap baris
        bukan0sebelumnya = -1;
        eselon = true;
        while (i < this.rows && eselon) {
            found = false; //apakah elemen pertama yang bukan 0 telah ditemukan
            while (j < this.cols && eselon && !found) { //mencari elemen pertama bukan 0 di tiap baris
                if (this.matrix[i][j] != 0) {
                    bukan0 = j;
                    found = true;
                } else {
                    j++;
                }
            }
            if (found) { //mengecek kriteria eselon baris
                if (bukan0sebelumnya >= bukan0 | this.matrix[i][bukan0] != 1) {
                    eselon = false;
                }
            } else {
                bukan0sebelumnya = bukan0;
            }
            i++;
        }
        return eselon;
    }
    public Matrix convertToEselon(boolean tereduksi) {
        //kamus
        Matrix mOutput = new Matrix(this.rows, this.cols);
        int singular_flag;
        //algoritma
        mOutput = this.copyMatrix();
        singular_flag = mOutput.forwardElim(tereduksi);
        if (singular_flag != -1){
            System.out.println("Matrix singular");
            if (mOutput.matrix[singular_flag][this.cols-1] != 0){
                System.out.print("Tidak memiliki solusi");
            } else {
                System.out.print("Memiliki tak hingga solusi");
            }
            return mOutput ;
        }
        return mOutput;
    }

    public int forwardElim(boolean tereduksi){
        //menerima sebuah matrix augmented lalu mengonversinya menjadi matriks eselon baris, mengembalikan sebuah nilai integer untuk menandai hasil operasi tersebut untuk menandai
        //matrix tersebut singular atau tidak
        //prekondisi : matrix memiliki solusi tunggal
        //kamus
        int k, i_max, v_max, i, j,bukan0;
        double f,p;
        boolean found;
        //algoritma
        System.out.println("Matrix awal");
        displayMatrix();
        for (k = 0; k < this.cols-1; k++){
            i_max = k;
            v_max = (int)this.matrix[i_max][k];
            for (i = k + 1; i < this.cols-1; i++)
                if (Math.abs(this.matrix[i][k]) > v_max){
                    v_max = (int)this.matrix[i][k];
                    i_max = i;
                }
            if (this.matrix[k][i_max] == 0){
                return k; // Matrix singular
            }
            if (i_max != k){
                swap_row(k, i_max);
                System.out.printf("Tukar baris ke-%d dan baris ke-%d\n", (k+1), (i_max+1));
                displayMatrix();
            }
            for (i = k + 1; i < this.cols-1; i++){
                f = this.matrix[i][k] / this.matrix[k][k];
                for (j = k + 1; j <= this.cols-1; j++){
                    this.matrix[i][j] -= this.matrix[k][j] * f;
                }
                this.matrix[i][k] = 0;
                System.out.printf("Baris ke-%d dikurangi baris ke-%d dikali %.2f\n", (i+1), (k+1), f);
                displayMatrix();
            }
        }
        if(tereduksi){
            for (i = 0; i < this.cols-1; i++){
                for (j = 0; j < this.cols-1; j++){
                    if (i != j){
                        p = this.matrix[j][i] / this.matrix[i][i];
                        for (k = 0; k <= this.cols-1; k++)                
                            this.matrix[j][k] = this.matrix[j][k] - (this.matrix[i][k]) * p;
                            System.out.printf("Baris ke-%d dikurangi baris ke-%d dikali %.2f\n", (j+1), (i+1), p);
                            displayMatrix();            
                    }
                }
            }
        }
        //sampai sini matrix merupakan matrix segitiga
        for(i=0;i<this.cols-1;i++){
            //mencari elemen bukan nol pertama di tiap baris
            bukan0=0;
            found=false;
            j=0;
            while(j<this.cols-1 && !found){
                if(this.matrix[i][j]==0){
                    j++;
                } else {
                    bukan0=j;
                    found=true;
                }
            }
            //mengubah elemen bukan nol pertama di tiap baris menjadi leading one
            if(found){
                p=this.matrix[i][bukan0];
                for(k=0;k<this.cols;k++){
                    this.matrix[i][k]/=p;
                }
                System.out.printf("Baris ke-%d dibagi dengan %.2f\n", (i+1), (p));
                displayMatrix();
            }
        }
        return -1;
    }

    // Untuk substitusi balik ketika sudah didapat matrix eselon baris
    public double[] substitusiBalik(){
        //Menerima sebuah matriks eselon baris dan mengembalikan solusi-solusi dalam bentuk array
        //kamus
        int i,j;
        double solusi[] = new double[this.cols-1]; // Array untuk menyimpan solusi
        //algoritma
        for (i = this.cols - 2; i >= 0; i--){
            solusi[i] = this.matrix[i][this.cols-1];
            for (j = i + 1; j < this.cols-1; j++){
                solusi[i] -= this.matrix[i][j] * solusi[j];
            }
            solusi[i] = solusi[i] / this.matrix[i][i];
        }

    return solusi;
    }

    public double getRegresiElement(int i, int j){
        int k ;
        double total=0;
        if (i==0) {
            for (k = 0; k < this.rows; k++) {
                total += this.matrix[k][j];
            }
        }
        else {// i > 1
            for (k = 0; k < this.rows; k++) {
                total += this.matrix[k][i]*this.matrix[k][j];
            }
        }
        return total;
    }
}