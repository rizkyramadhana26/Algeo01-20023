import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void pembuka() {
        System.out.println("------------------------------------------------------");
        System.out.println("Selamat datang di program matriks kelompok 21 BONEK");
        System.out.println("------------------------------------------------------\n");
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

    public static Matrix inputMatrix() {
        Scanner sc = new Scanner(System.in);
        Matrix hasil = new Matrix(20, 20);
        int subPilihan, baris, kolom;
        System.out.println("Ketik 1 untuk menambah matriks by input user");
        System.out.println("Ketik 2 untuk input matriks dari file txt");
        System.out.print("Masukkan sub-pilihan anda: ");
        subPilihan = sc.nextInt();
        if (subPilihan == 1) {
            System.out.print("Masukkan baris matriksnya: ");
            baris = sc.nextInt();
            System.out.print("Masukkan kolom matriksnya: ");
            kolom = sc.nextInt();
            Matrix mTerminal = new Matrix(baris, kolom);
            mTerminal.readMatrix(baris, kolom);
            hasil = mTerminal.copyMatrix();
        }
        return hasil;
    }

    public static void pilihmenu() {
        Matrix mUtama = new Matrix(20, 20); // BIAR MAX SIZE NYA 20 DULU
        mUtama.rows = 0; // awowakoka biar input awalnya kosong dulu
        mUtama.cols = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ketik menu yang ingin dipilih: ");
        int pilihan = sc.nextInt();
        int subPilihan, i;
        System.out.println("-------------------------------------------------------");
        if (pilihan==1){
            subMenuSPL();
            Scanner sc1 = new Scanner(System.in);
            int metode = sc1.nextInt();
            Matrix mAwal = inputMatrix();
            //jumlah baris harus sama dengan jumlah variabel, jumlah kolom harus sama dengan jumlah variabel ditambah 1
            mAwal.extendMatrix(mAwal.cols-1>mAwal.rows ? mAwal.cols-1-mAwal.rows : 0,0);
            if(metode==1){
                Matrix eselon = mAwal.convertToEselon(false);
                double solusi[] = eselon.substitusiBalik();
                System.out.println("Penyelesaian persamaan tersebut adalah"); //asumsi solusi tunggal
                System.out.println(Arrays.toString(solusi));
            } else if(metode==2){
                Matrix eselon = mAwal.convertToEselon(true);
                double solusi[] = eselon.substitusiBalik();
                System.out.println("Penyelesaian persamaan tersebut adalah"); //asumsi solusi tunggal
                System.out.println(Arrays.toString(solusi));
            } else if(metode==3){

            } else if(metode==4){

            }
        } else if (pilihan == 2) {
            System.out.println("Ketik 1 untuk menggunakan metode OBE");
            System.out.println("Ketik 2 untuk menggunakan metode Kofaktor");
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Masukkan pilihan anda = ");
            subPilihan = sc.nextInt();
            if (subPilihan == 0) {
                menuUtama();
                pilihmenu();
            }   
            else if (subPilihan == 1) {
                mUtama = inputMatrix();
                if (mUtama.cols != mUtama.rows) {
                    System.out.println("Matriks bukan persegi, tidak bisa dicari determinannya");
                }
                else {
                    System.out.println("Determinan perkalian diagonal utamanya adalah (plus minus bergantung banyaknya operasi swap): " +mUtama.determinanOBE());
                }
            } 
            else if (subPilihan == 2) {
                mUtama = inputMatrix();
                if (mUtama.cols != mUtama.rows) {
                    System.out.println("Matriks bukan persegi, tidak bisa dicari determinannya");
                }
                else{
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
            }
        System.out.println("-------------------------------------------------------");
        menuUtama();
        pilihmenu();
        } else if (pilihan == 4){
            int k,j;
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
                System.out.printf("Hasil interpolasi adalah : %.2f", y_interpolasi);
            }
        }
    }

    public static void main(String[] args) {
        pembuka();
        menuUtama();
        pilihmenu();
    }
}
