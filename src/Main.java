import java.util.Scanner;

public class Main {
    public static void pembuka() {
        System.out.println("------------------------------------------------------");
        System.out.println("Selamat datang di program matriks kelompok 21 BONEK");
        System.out.println("------------------------------------------------------\n");
    }

    public static void menuUtama(){
        System.out.println("1. Input/Ubah Matriks");
        System.out.println("2. Tampilkan Matriks");
        System.out.println("3. Sistem Persamaan Linear");
        System.out.println("4. Determinan Matriks");
        System.out.println("5. Interpolasi Polinom");
        System.out.println("6. Regresi Linear berganda");
        System.out.println("7. Inverse Matrix");
        System.out.println("8. Export Matriks");
        System.out.println("9. CLOSE PROGRAM");
    }

    public static void penutup() {
        System.out.println("-------------------------------------------");
        System.out.println("Terimakasih sudah menggunakan program kami");
        System.out.println("-------------------------------------------");
    }

    public static void subMenuSPL(Matrix mDummy){
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
    }

    public static void pilihMenu(Matrix mUtama){
        Matrix mDummy = new Matrix(20,20);//ini yang dummy, silahkan pakai sesuka hati buat diganti anjay
        Scanner sc = new Scanner(System.in);
        System.out.print("Ketik menu yang ingin dipilih: ");
        int pilihan = sc.nextInt();
        int subPilihan,baris,kolom,i;
        System.out.println("-------------------------------------------------------");
        if(pilihan==1){
            System.out.println("Ketik 1 untuk menambah matriks by input user");
            System.out.println("Ketik 2 untuk input matriks dari file txt");
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Masukkan sub-pilihan anda: ");
            subPilihan = sc.nextInt();
            if(subPilihan==1){
                System.out.print("Masukkan baris matriksnya: ");
                baris = sc.nextInt();
                System.out.print("Masukkan kolom matriksnya: ");
                kolom = sc.nextInt();
                mUtama.readMatrix(baris, kolom);
            }
            System.out.println("Matriks sudah tersimpan. Silahkan pilih operasi lain.");
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihMenu(mUtama);
        }
        else if(pilihan==2){
            System.out.println("Matriks yang tersimpan adalah: ");
            mUtama.displayMatrix();
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihMenu(mUtama);
        }
        else if(pilihan==4 && ( mUtama.rows == 0 || mUtama.cols ==0 || mUtama.rows != mUtama.cols)){
            System.out.println("Matrix kosong atau Matrix tidak persegi.");
            System.out.println("Silahkan menginput kembali matriks jika mau dicari determinannya.");
            menuUtama();
            pilihMenu(mUtama);
        }
        else if(pilihan==4 && mUtama.rows >0 && mUtama.cols >0 && mUtama.rows == mUtama.cols){
            mDummy = mUtama.copyMatrix();
            System.out.println("Ketik 1 untuk menggunakan metode OBE");
            System.out.println("Ketik 2 untuk menggunakan metode Kofaktor");
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Masukkan pilihan anda = ");
            subPilihan = sc.nextInt();
            if(subPilihan==0){
                menuUtama();
                pilihMenu(mUtama);
            }
            else if (subPilihan==1){
                System.out.println("Determinan perkalian diagonal utamanya adalah (plus minus bergantung banyaknya operasi swap): " + mDummy.determinanOBE());
            }
            else if (subPilihan==2){
                System.out.println("Mencari determinan dengan menggunakan kofaktor pada baris pertama.");
                System.out.print("Determinannya adalah: ");
                for(i = 0; i < mDummy.rows; i++){
                    System.out.print(mDummy.matrix[0][i]);
                    System.out.print("*");
                    System.out.print(mDummy.getKofaktor(0,i));
                    if (i!= mDummy.rows -1) {
                        System.out.print(" + ");
                    }
                }
                System.out.print(": ");
                System.out.println(mDummy.determinanKofaktor());
            }
            System.out.println("-------------------------------------------------------");
            menuUtama();
            pilihMenu(mUtama);
        }
    }

    public static void main(String[] args) {
        Matrix mUtama = new Matrix(20,20); //BIAR MAX SIZE NYA 20 DULU
        mUtama.rows = 0; //awowakoka biar input awalnya kosong dulu
        mUtama.cols = 0;
        pembuka();
        menuUtama();
        pilihMenu(mUtama);
    }
}
            