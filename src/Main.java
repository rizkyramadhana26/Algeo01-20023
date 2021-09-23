import java.util.Scanner;

public class Main {
    public static  void pembuka(){
        System.out.println("------------------------------------------------------");
        System.out.println("Selamat datang di program matriks kelompok 21 BONEK");
        System.out.println("------------------------------------------------------\n");
    }

    public static void menuUtama(){
        System.out.println("1. Baca Matriks");
        System.out.println("2. Tampilkan Matriks");
        System.out.println("3. Sistem Persamaan Linear");
        System.out.println("4. Determinan Matriks");
        System.out.println("5. Interpolasi Polinom");
        System.out.println("6. Regresi Linear berganda");
        System.out.println("7. Inverse Matrix");
        System.out.println("8. Export Matriks");
        System.out.println("9. CLOSE PROGRAM");
    }

    public static void penutup(){
        System.out.println("-------------------------------------------");
        System.out.println("Terimakasih sudah menggunakan program kami");
        System.out.println("-------------------------------------------");
    }

    public static void subMenuSPL(){
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
    }

    public static void pilihMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ketik menu yang ingin dipilih: ");
        int pilihan = sc.nextInt();
        if(pilihan==1){
            System.out.println("Ketik 1 untuk menambah matriks by input user");
            System.out.println("Ketik 2 untuk input matriks dari file txt");
            System.out.println("Ketik 0 untuk batal");
            System.out.print("Masukkan pilihan anda = ");
        }
    }

    public static void main(String[] args) {
        pembuka() ;
        menuUtama() ;
        pilihMenu();
    }
}
            