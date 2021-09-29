import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void pembuka() {
        System.out.println("------------------------------------------------------");
        System.out.println("Selamat datang di program matriks kelompok 21 BONEK");
        System.out.println("------------------------------------------------------");
    }

    public static void menuUtama() {
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan Matriks");
        System.out.println("3. Matrix Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi Linear Berganda");
        System.out.println("6. CLOSE PROGRAM");
    }

    public static void penutup() {
        System.out.println("-------------------------------------------");
        System.out.println("Terimakasih sudah menggunakan program kami");
        System.out.println("-------------------------------------------");
    }

    public static void subMenuSPL() {
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
    }

    public static Matrix inputMatrix(boolean persegi) {
        Scanner sc = new Scanner(System.in);
        Matrix hasil = new Matrix(20, 20);
        int subPilihan, baris, kolom, size;
        System.out.println("Ketik 1 untuk menambah matriks by input user");
        System.out.println("Ketik 2 untuk input matriks dari file txt");
        System.out.print("Masukkan sub-pilihan anda: ");
        subPilihan = sc.nextInt();
        while (subPilihan <1 || subPilihan > 2) {
            System.out.println("Pilihan salah, ulangi");
            System.out.print("Masukkan sub-pilihan anda: ");
            subPilihan = sc.nextInt();
        }
        if (subPilihan == 1) {
            if (persegi) {
                System.out.print("Masukkan ukuran matriks persegi: ");
                size = sc.nextInt();
                baris = size;
                kolom = size;
            } else {
                System.out.print("Masukkan baris matriksnya: ");
                baris = sc.nextInt();
                System.out.print("Masukkan kolom matriksnya: ");
                kolom = sc.nextInt();
            }
            Matrix mTerminal = new Matrix(baris, kolom);
            mTerminal.readMatrix(baris, kolom);
            hasil = mTerminal.copyMatrix();
        }
        /* else {

        }*/
        return hasil;
    }

    public static void pilihmenu() {
        Matrix mUtama = new Matrix(20, 20); // BIAR MAX SIZE NYA 20 DULU
        mUtama.rows = 0; // awowakoka biar input awalnya kosong dulu
        mUtama.cols = 0;
        Matrix B = new Matrix(20, 20); //KHUSUS SPL METODE 3 DAN 4 YO
        Matrix temp = new Matrix(20, 20); //INI BUAT REGRESI LINEAR GAIS 
        B.cols = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ketik menu yang ingin dipilih: ");
        int pilihan = sc.nextInt();
        int subPilihan, i,saul,k;
        double elemen;
        System.out.println("-------------------------------------------------------");
        if (pilihan==1){
            subMenuSPL();
            System.out.print("Masukkan pilihan anda: ");
            Scanner sc1 = new Scanner(System.in);
            int metode = sc1.nextInt();
            //UNTUK METODE 1 DAN 2, jumlah baris harus sama dengan jumlah variabel, jumlah kolom harus sama dengan jumlah variabel ditambah 1 
            //UNTUK METODE 3 dan 4, INPUT MATRIKS A HARUS PERSEGI
            if(metode==1){
                Matrix mAwal = inputMatrix(false);
                Matrix mProses = mAwal.extendMatrix(mAwal.cols-1>mAwal.rows ? mAwal.cols-1-mAwal.rows : 0,0);
                Matrix eselon = mProses.convertToEselon(false);
                double solusi[] = eselon.substitusiBalik();
                if(!eselon.isUndef()){
                    System.out.println("Penyelesaian persamaan tersebut adalah"); //asumsi solusi tunggal
                    System.out.println(Arrays.toString(solusi));
                }
            } else if(metode==2){
                Matrix mAwal = inputMatrix(false);
                Matrix mProses = mAwal.extendMatrix(mAwal.cols-1>mAwal.rows ? mAwal.cols-1-mAwal.rows : 0,0);
                Matrix eselon = mProses.convertToEselon(true);
                double solusi[] = eselon.substitusiBalik();
                if(!eselon.isUndef()){
                    System.out.println("Penyelesaian persamaan tersebut adalah"); //asumsi solusi tunggal
                    System.out.println(Arrays.toString(solusi));
                }
            } else if(metode==3){
                System.out.println("Menggunakan metode matriks balikan, bentuk matriks Ax = B");
                System.out.println("Silahkan menginput matriks A: ");
                Matrix mAwal = new Matrix(20,20);
                mAwal = inputMatrix(false);
                Double detAwal = mAwal.determinanKofaktor();
                if (mAwal.rows != mAwal.cols) {
                    System.out.println("Matriks A tidak persegi, tidak bisa menggunakan metode ini.");
                    System.out.println("Akan dikembalikan ke menu utama");
                }
                else if (detAwal == 0) {
                    System.out.println("Determinan matriks A adalah 0 sehingga tidak bisa menggunakan metode ini karena tidak ada inversnya.");
                    System.out.println("Akan dikembalikan ke menu utama");
                }
                else {
                    System.out.println("Matrix A awal adalah");
                    mAwal.displayMatrix();
                    System.out.println("Silahkan menginput matriks B: ");
                    B.rows = mAwal.rows;
                    for (saul=0;saul<B.rows;saul++) {
                        System.out.print("Masukkan matriks B baris ke-");
                        System.out.print(saul+1);
                        System.out.print(": ");
                        elemen = sc1.nextDouble();
                        B.matrix[saul][0] = elemen;
                    }
                    Matrix invers = mAwal.InverseKofaktor();
                    System.out.println("Invers matrix A adalah");
                    invers.displayMatrix();
                    System.out.println("Matrix B adalah");
                    B.displayMatrix();
                    System.out.println("Hasil kali invers matrix A dengan matrix B adalah");
                    Matrix kali = invers.kaliMatrix(B);
                    kali.displayMatrix();
                    System.out.println("Sehingga solusi dari paling atas adalah");
                    for (i=0; i < kali.rows; i++){
                        System.out.printf("X%d adalah %f", (i+1), kali.matrix[i][0]);
                        System.out.println();
                    }
                }
            } else if(metode==4){
                System.out.println("Menggunakan metode Cramer, bentuk matriks Ax = B");
                System.out.println("Silahkan menginput matriks A: ");
                Matrix mAwal = new Matrix(20,20);
                mAwal = inputMatrix(false);
                Double detAwal = mAwal.determinanKofaktor();
                if (mAwal.rows != mAwal.cols) {
                    System.out.println("Matriks A tidak persegi, tidak bisa menggunakan metode ini.");
                    System.out.println("Akan dikembalikan ke menu utama");
                }
                else if (detAwal == 0) {
                    System.out.println("Determinan matriks A adalah 0 sehingga tidak bisa menggunakan metode ini karena solusinya banyak / tidak ada solusi.");
                    System.out.println("Akan dikembalikan ke menu utama");
                }
                else {
                    System.out.println("Matrix A awal adalah");
                    mAwal.displayMatrix();
                    System.out.print("Determinannya adalah: ");
                    System.out.println(detAwal);
                    System.out.println("Silahkan menginput matriks B: ");
                    B.rows = mAwal.rows;
                    for (saul=0;saul<B.rows;saul++) {
                        System.out.print("Masukkan matriks B baris ke-");
                        System.out.print(saul+1);
                        System.out.print(": ");
                        elemen = sc1.nextDouble();
                        B.matrix[saul][0] = elemen;
                    }
                    for (saul=0;saul<mAwal.cols;saul++) {
                        for (k=0;k<B.rows;k++){// UNTUK NGESWITCHNYA
                           elemen = mAwal.matrix[k][saul] ;
                           mAwal.matrix[k][saul] = B.matrix[k][0];
                           B.matrix[k][0] = elemen;
                        }
                        Double detAkhir = mAwal.determinanKofaktor();
                        System.out.print("Mencari nilai dari X");
                        System.out.print(saul+1);
                        System.out.println(" Dengan menukar kolomnya dengan matriks B");
                        mAwal.displayMatrix();
                        System.out.print("X");
                        System.out.print(saul+1);
                        System.out.print(" Adalah ");
                        System.out.print(detAkhir);
                        System.out.print("/");
                        System.out.print(detAwal);
                        System.out.print("= ");
                        System.out.print(detAkhir/detAwal);
                        System.out.println();
                        for (k=0;k<B.rows;k++){// UNTUK NGESWITCH KEMBALI BIAR NORMAL
                            elemen = mAwal.matrix[k][saul] ;
                            mAwal.matrix[k][saul] = B.matrix[k][0];
                            B.matrix[k][0] = elemen;
                        }
                    }
                }
            }
            else {
                System.out.println("metode tidak sesuai, dikembalikan ke menu utama");
            }
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihmenu();
        } else if (pilihan == 2) {
            System.out.println("Ketik 1 untuk menggunakan metode OBE");
            System.out.println("Ketik 2 untuk menggunakan metode Kofaktor");
            System.out.print("Masukkan pilihan anda: ");
            subPilihan = sc.nextInt();
            if (subPilihan == 1) {
                mUtama = inputMatrix(true);
                System.out.println("Determinan perkalian diagonal utamanya adalah (plus minus bergantung banyaknya operasi swap): " +mUtama.determinanOBE());
            } 
            else if (subPilihan == 2) {
                mUtama = inputMatrix(true);
                System.out.println("Mencari determinan dengan menggunakan kofaktor pada baris pertama.");
                System.out.print("Determinannya adalah: ");
                for (i = 0; i < mUtama.rows; i++) {
                    System.out.print(mUtama.matrix[0][i]);
                    System.out.print("*");
                    System.out.print(mUtama.getKofaktor(0, i));
                    if (i != mUtama.rows - 1) {
                        System.out.print(" + ");
                    }
                }
                System.out.print(": ");
                System.out.println(mUtama.determinanKofaktor());
            }
            else {
                System.out.println("Subpilihan tidak sesuai, dikembalikan ke menu utama");
            }
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihmenu();
        } else if (pilihan == 3) {      // Balikan matriks
            System.out.println("Ketik 1 untuk menggunakan metode OBE");
            System.out.println("Ketik 2 untuk menggunakan metode adjoint");
            System.out.print("Masukkan pilihan anda = ");
            subPilihan = sc.nextInt();
            if (subPilihan == 1) {
                mUtama = inputMatrix(true);
                if (mUtama.determinanKofaktor() == 0) {
                    System.out.println("Matriks mempunyai determinan 0, tidak bisa dicari balikannya");
                } else {
                    mUtama = mUtama.InverseOBE();

                    Matrix kiri = mUtama.copyMatrix();
                    kiri.cols /= 2;
                    if (kiri.isIdentity()) {
                        int j;
                        for (i = 0; i<kiri.rows; i++) {
                            for (j= 0; j<kiri.cols; j++) {
                                kiri.matrix[i][j] = kiri.matrix[i][j+kiri.cols];
                            }
                        }    
                    System.out.println("Matriks invers adalah: ");        
                    kiri.displayMatrix();
                    }
                    else {
                        System.out.println("Matriks sebelah kiri gagal dijadikan matriks identitas. ");
                        System.out.println("Tidak bisa mendapatkan inversnya. ");
                    }
                }
            } else if (subPilihan == 2) {
                mUtama = inputMatrix(true);
                if (mUtama.determinanKofaktor() == 0) {
                    System.out.println("Matriks mempunyai determinan 0, tidak bisa dicari balikannya");
                } else {
                    mUtama = mUtama.InverseKofaktor();  // MEMANGGIL FUNGSI Inverse metode kofaktor
                    System.out.println("Matriks inverse adalah:");
                    mUtama.displayMatrix();
                }
            } else {
                System.out.println("Subpilihan tidak sesuai, dikembalikan ke menu utama");
            }
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihmenu();
        }
        else if (pilihan == 4){
            int j;
            Matrix eselon;
            double solusi[];
            double y_interpolasi;
            System.out.println("Ketik 1 untuk memasukkan titik melalui CLI atau 0 untuk memasukkan titik melalui file txt");
            Scanner sc5 = new Scanner(System.in);
            int subpilihan = sc5.nextInt();
            if(subpilihan==1){
                System.out.println("Jumlah titik yang ingin dimasukkan :"); //prekondisi n>1
                Scanner sc6 = new Scanner(System.in);
                int n = sc6.nextInt();
                Matrix matrix = new Matrix(n,n+1);
                for(k=0;k<n;k++){
                    System.out.printf("Masukkan absis titik ke-%d\n", (k+1));
                    Scanner sc4 = new Scanner(System.in);
                    double x = sc4.nextDouble();
                    for(j=0;j<n;j++){
                        matrix.matrix[k][j] = Math.pow(x,j);
                    }
                    System.out.printf("Masukkan ordinat titik ke-%d\n", (k+1));
                    Scanner sc2 = new Scanner(System.in);
                    double y = sc2.nextDouble();
                    matrix.matrix[k][n] = y;
                }
                eselon = matrix.convertToEselon(false);
                solusi = eselon.substitusiBalik();
                System.out.println("Koefisien-koefisien dari polinomial yang bersesuaian, dimulai dari derajat 0 di paling kiri");
                System.out.println(Arrays.toString(solusi));
                System.out.println("Masukkan nilai ordinat yang ingin diinterpolasi");
                Scanner sc3 = new Scanner(System.in);
                double x_interpolasi = sc3.nextDouble();
                y_interpolasi = 0;
                for(i=0;i<n;i++){
                    y_interpolasi+=solusi[i]*Math.pow(x_interpolasi,i);
                }
                System.out.printf("Hasil interpolasi adalah : %f", y_interpolasi);
                System.out.println();
            }
            /*else if (subpilihan==2) { BAGIAN AFAN 

            }*/
            menuUtama();
            pilihmenu();
        }
        else if (pilihan == 5) { //sumpah iki utekku kobong banget tapi yaudah lah ya demi kalian para cintaku 
            int a,b,c;
            double solusi[];
            Matrix eselon;
            System.out.println("Ketik 1 untuk memasukkan titik melalui CLI atau 0 untuk memasukkan titik melalui file txt");
            Scanner sc5 = new Scanner(System.in);
            int subpilihan = sc5.nextInt();
            if(subpilihan==1){
                System.out.println("Jumlah variabel peubah yang ingin dimasukkan :"); //prekondisi n>1
                Scanner sc6 = new Scanner(System.in);
                int n = sc6.nextInt();
                System.out.println("Jumlah titik yang ingin dimasukkan :");
                int titik = sc6.nextInt();
                mUtama.rows = titik;
                mUtama.cols = n+2;
                for (a=0;a<mUtama.rows;a++) {
                    mUtama.matrix[a][0] = 1;
                }
                for (a=0;a<mUtama.rows;a++) {
                    for (b=1;b<mUtama.cols-1;b++){
                        System.out.printf("Masukkan nilai dari X%d%d: ", b, (a+1));
                        elemen = sc.nextDouble();
                        mUtama.matrix[a][b] = elemen;
                    }
                    System.out.printf("Masukkan nilai dari Y%d: ", (a+1));
                    elemen = sc.nextDouble();
                    mUtama.matrix[a][b] = elemen;
                }// DENGAN INI MATRIKS UTAMANYA UDAH KEISI 
                temp.rows = n+1;
                temp.cols = n+2;
                for (a=0;a<temp.rows;a++) {
                    for (b=0;b<temp.cols;b++){
                        temp.matrix[a][b] = mUtama.getRegresiElement(a,b);
                    }
                }
                eselon = temp.convertToEselon(false);
                solusi = eselon.substitusiBalik();
                System.out.println("nilai dari B yang bersesuaian, dimulai dari derajat 0 di paling kiri");
                System.out.println(Arrays.toString(solusi));  
                System.out.println("Masukkan nilai nilai Xk yang ingin ditaksir fungsinya");
                double total= solusi[0];
                for (b=1;b<=n;b++){
                    System.out.printf("Masukkan nilai dari X%d: ", b);
                    elemen = sc.nextDouble();
                    total += elemen*solusi[b];
                }
                System.out.printf("Hasil taksiran adalah : %f \n", total);
                System.out.println("-------------------------------------------------------");
            } 
            /*else if (subpilihan==2) { BAGIAN AFAN 

            }*/
            menuUtama();
            pilihmenu();     
        }
            else if (pilihan == 6){
        penutup();
        }
    }

    public static void main(String[] args) {
        pembuka();
        menuUtama();
        pilihmenu();
    }
}