# Sistem Persamaan Linier, Determinan, dan Aplikasinya
# Algeo01-20023
Kelompok BONEK
* 13520023 - Ahmad Alfani Handoyo
* 13520094 - Saul Sayers
* 13520151 - Rizky Ramadhana P. K.
## Menjalankan Program
Pertama-tama masuk ke folder '/src' lalu compile file .java dengan command
```javac *.java```
Hasil compile program ini ditampung pada folder '/bin'. Untuk menjalankan program, masuk ke folder '/bin' lalu jalankan command
```java Main```
dimana Main adalah nama class utama di mana progam berada.
## Menu Utama
Setelah menjalankan program, akan ditampilkan menu seperti berikut
```
------------------------------------------------------
Selamat datang di program matriks kelompok 21 BONEK 
------------------------------------------------------ 
1. Sistem Persamaan Linear     
2. Determinan Matriks          
3. Matrix Balikan              
4. Interpolasi Polinom       
5. Regresi Linear Berganda  
6. CLOSE PROGRAM            
Ketik menu yang ingin dipilih:
```
Masukkan opsi yang ingin dijalankan berupa sebuah angka di antara 1 sampai 6 (inklusif)
## Sistem Persamaan Linear
Apabila dipilih menu 1, maka akan terdapat beberapa pilihan kembali. Masing-masing pilihan berkaitan dengan metode penyelesaian sistem persamaan linear yang akan digunakan.
```
-------------------------------------------------------
1. Metode eliminasi Gauss
2. Metode eliminasi Gauss-Jordan
3. Metode matriks balikan
4. Kaidah Cramer
Masukkan pilihan anda:
```
### Metode Eliminasi Gauss
Mula-mula akan diminta matriks *augmented* dari sistem persamaan linear yang akan diselesaikan. Misal, sebuah sistem persamaan linear terdiri dari tiga persamaan di bawah ini
> x+y+z=10;
> 2x+y+z=12;
> x+2y+z=13

Maka matriks *augmented* nya adalah <br>
1 1 1 10 <br>
2 1 1 12 <br>
1 2 1 13 <br>

Sehingga, untuk menyelesaikan sistem persamaan linear tersebut pengguna harus berinteraksi dengan program seperti berikut (angka setelah tanda ':' adalah input dari pengguna)

```
Ketik 1 untuk menambah matriks by input user
Ketik 2 untuk input matriks dari file txt
Masukkan sub-pilihan anda: 1
Masukkan baris matriksnya: 3
Masukkan kolom matriksnya: 4
Masukkan nilai untuk baris ke-1 kolom ke-1: 1
Masukkan nilai untuk baris ke-1 kolom ke-2: 1
Masukkan nilai untuk baris ke-1 kolom ke-3: 1
Masukkan nilai untuk baris ke-1 kolom ke-4: 10
Masukkan nilai untuk baris ke-2 kolom ke-1: 2
Masukkan nilai untuk baris ke-2 kolom ke-2: 1
Masukkan nilai untuk baris ke-2 kolom ke-3: 1
Masukkan nilai untuk baris ke-2 kolom ke-4: 12
Masukkan nilai untuk baris ke-3 kolom ke-1: 1 
Masukkan nilai untuk baris ke-3 kolom ke-2: 2
Masukkan nilai untuk baris ke-3 kolom ke-3: 1
Masukkan nilai untuk baris ke-3 kolom ke-4: 13 
```
Program akan menjalankan eliminasi Gauss pada matriks *augmented* tersebut. Proses eliminasi akan berjalan seperti di bawah ini
```
Matrix awal
1.00 1.00 1.00 10.00
2.00 1.00 1.00 12.00
1.00 2.00 1.00 13.00
Tukar baris ke-1 dan baris ke-2
2.00 1.00 1.00 12.00
1.00 1.00 1.00 10.00
1.00 2.00 1.00 13.00
Baris ke-2 dikurangi baris ke-1 dikali 0.50
2.00 1.00 1.00 12.00
0.00 0.50 0.50 4.00
1.00 2.00 1.00 13.00
Baris ke-3 dikurangi baris ke-1 dikali 0.50
2.00 1.00 1.00 12.00
0.00 0.50 0.50 4.00
0.00 1.50 0.50 7.00
Baris ke-3 dikurangi baris ke-2 dikali 3.00
2.00 1.00 1.00 12.00
0.00 0.50 0.50 4.00
0.00 0.00 -1.00 -5.00
Baris ke-1 dibagi dengan 2.00
1.00 0.50 0.50 6.00
0.00 0.50 0.50 4.00
0.00 0.00 -1.00 -5.00
Baris ke-2 dibagi dengan 0.50
1.00 0.50 0.50 6.00
0.00 1.00 1.00 8.00
0.00 0.00 -1.00 -5.00
Baris ke-3 dibagi dengan -1.00
1.00 0.50 0.50 6.00
0.00 1.00 1.00 8.00
-0.00 -0.00 1.00 5.00
```
Lalu program akan melakukan substitusi balik dan menghasilkan solusi seperti berikut
```
Penyelesaian persamaan tersebut adalah
[2.0, 3.0, 5.0] 
```
### Metode Eliminasi Gauss Jordan
### Metode Matriks Balikan
### Metode Crammer
## Determinan Matriks
### Metode OBE
### Metode Kofaktor
## Matrix Balikan
### Metode OBE
### Metode Adjoint
## Interpolasi Polinom
## Regresi Linear Berganda
