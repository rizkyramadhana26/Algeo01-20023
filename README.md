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
Dengan metode ini, matriks akan disajikan dalam model *Ax = B* 
Misal, sebuah sistem persamaan linear terdiri dari empat persamaan di bawah ini
> a+b-c-d=1;
> 2a+5b-7c-5d=-2;
> 2a-b+c+3d=4;
> 5a+2b-4c+2d=6

Sehingga, untuk menyelesaikan sistem persamaan linear tersebut pengguna 
harus berinteraksi dengan program. Pengguna akan diminta untuk mengisi matriks A terlebih dahulu, kemudian mengisi matriks B seperti berikut (angka setelah tanda ':' adalah input dari pengguna)

```
Menggunakan metode matriks balikan, bentuk matriks Ax = B
Silahkan menginput matriks A:
Ketik 1 untuk menambah matriks by input user
Ketik 2 untuk input matriks dari file txt
Masukkan sub-pilihan anda: 1
Masukkan baris matriksnya: 4
Masukkan kolom matriksnya: 4
Masukkan nilai untuk baris ke-1 kolom ke-1: 1
Masukkan nilai untuk baris ke-1 kolom ke-2: 1
Masukkan nilai untuk baris ke-1 kolom ke-3: -1
Masukkan nilai untuk baris ke-1 kolom ke-4: -1
Masukkan nilai untuk baris ke-2 kolom ke-1: 2
Masukkan nilai untuk baris ke-2 kolom ke-2: 5
Masukkan nilai untuk baris ke-2 kolom ke-3: -7
Masukkan nilai untuk baris ke-2 kolom ke-4: -5
Masukkan nilai untuk baris ke-3 kolom ke-1: 2
Masukkan nilai untuk baris ke-3 kolom ke-2: -1
Masukkan nilai untuk baris ke-3 kolom ke-3: 1
Masukkan nilai untuk baris ke-3 kolom ke-4: 3
Masukkan nilai untuk baris ke-4 kolom ke-1: 5
Masukkan nilai untuk baris ke-4 kolom ke-2: 2
Masukkan nilai untuk baris ke-4 kolom ke-3: -4
Masukkan nilai untuk baris ke-4 kolom ke-4: 2
Determinan matriks A adalah 0 sehingga tidak bisa menggunakan metode ini karena tidak ada inversnya.
Akan dikembalikan ke menu utama
```

Contoh studi kasus yang dipilih memiliki determinan Matriks A yang bernilai 0.
Dengan demikian, metode balikan matriks tidak dapat digunakan karena Matriks A tidak memiliki invers,<br>
sehingga pengguna tidak diminta untuk mengisi matriks B.

### Metode Crammer
Dengan metode ini, matriks akan disajikan dalam model *Ax = B* 
Misal, sebuah sistem persamaan linear terdiri dari empat persamaan di bawah 
ini
> a+b-c-d=1;
> 2a+5b-7c-5d=-2;
> 2a-b+c+3d=4;
> 5a+2b-4c+2d=6

Sehingga, untuk menyelesaikan sistem persamaan linear tersebut pengguna 
harus berinteraksi dengan program. Pengguna akan diminta untuk mengisi 
matriks A terlebih dahulu, kemudian mengisi matriks B seperti berikut 
(angka setelah tanda ':' adalah input dari pengguna)

```
Menggunakan metode Cramer, bentuk matriks Ax = B
Silahkan menginput matriks A:
Ketik 1 untuk menambah matriks by input user
Ketik 2 untuk input matriks dari file txt
Masukkan sub-pilihan anda: 1
Masukkan baris matriksnya: 4
Masukkan kolom matriksnya: 5
Masukkan nilai untuk baris ke-1 kolom ke-1: 1
Masukkan nilai untuk baris ke-1 kolom ke-2: -1
Masukkan nilai untuk baris ke-1 kolom ke-3: 0
Masukkan nilai untuk baris ke-1 kolom ke-4: 0
Masukkan nilai untuk baris ke-1 kolom ke-5: 1
Masukkan nilai untuk baris ke-2 kolom ke-1: 1
Masukkan nilai untuk baris ke-2 kolom ke-2: 1
Masukkan nilai untuk baris ke-2 kolom ke-3: 0
Masukkan nilai untuk baris ke-2 kolom ke-4: -3
Masukkan nilai untuk baris ke-2 kolom ke-5: 0
Masukkan nilai untuk baris ke-3 kolom ke-1: 2
Masukkan nilai untuk baris ke-3 kolom ke-2: -1
Masukkan nilai untuk baris ke-3 kolom ke-3: 0
Masukkan nilai untuk baris ke-3 kolom ke-4: 1
Masukkan nilai untuk baris ke-3 kolom ke-5: -1
Masukkan nilai untuk baris ke-4 kolom ke-1: -1
Masukkan nilai untuk baris ke-4 kolom ke-2: 2
Masukkan nilai untuk baris ke-4 kolom ke-3: 0
Masukkan nilai untuk baris ke-4 kolom ke-4: -2
Masukkan nilai untuk baris ke-4 kolom ke-5: -1
Matriks A tidak persegi, tidak bisa menggunakan metode ini.
Akan dikembalikan ke menu utama
```

Contoh studi kasus kami menggunakan Matriks A yang tidak berbentuk persegi <br>
Dengan demikian, metode ini tidak dapat digunakan karena membutuhkan determinan matriks A.
## Determinan Matriks
Apabila dipilih menu 2, maka akan terdapat beberapa pilihan kembali. Masing-masing pilihan berkaitan dengan metode perhitungan determinan yang akan digunakan. <br>
Syarat dari perhitungan determinan adalah matriks yang dimasukkan harus berupa matriks persegi.
```
Ketik 1 untuk menggunakan metode OBE
Ketik 2 untuk menggunakan metode Kofaktor
Masukkan pilihan anda: 
```

Apabila syarat tidak persegi tidak terpenuhi, maka akan terjadi contoh luaran seperti berikut:
```
Masukkan baris matriksnya: 1
Masukkan kolom matriksnya: 3
Masukkan nilai untuk baris ke-1 kolom ke-1: 1
Masukkan nilai untuk baris ke-1 kolom ke-2: 2
Masukkan nilai untuk baris ke-1 kolom ke-3: 3
Matriks bukan persegi, tidak bisa dicari determinannya
```
### Metode OBE
Metode perhitungan determinan ini menggunakan operasi baris elementer.
Matriks akan dioperasikan sehingga berbentuk segitiga atas (elemen matriks bagian bawah diagonal utama merupakan 0 semua).
Apabila matriks sudah berupa segitiga atas dari awal, maka tidak perlu dioperasikan.
Setelah menjadi segitiga atas, maka perhitungan determinan cukup dengan mengalikan seluruh elemen pada diagonal utama.

Pengguna akan diminta untuk menginput matriks yang akan dihitung determinannya seperti berikut:
```
Masukkan baris matriksnya: 3
Masukkan kolom matriksnya: 3
Masukkan nilai untuk baris ke-1 kolom ke-1: 4
Masukkan nilai untuk baris ke-1 kolom ke-2: 2
Masukkan nilai untuk baris ke-1 kolom ke-3: 8
Masukkan nilai untuk baris ke-2 kolom ke-1: 2
Masukkan nilai untuk baris ke-2 kolom ke-2: 1
Masukkan nilai untuk baris ke-2 kolom ke-3: 5
Masukkan nilai untuk baris ke-3 kolom ke-1: 3
Masukkan nilai untuk baris ke-3 kolom ke-2: 2
Masukkan nilai untuk baris ke-3 kolom ke-3: 4
Matrix awal
4.00 2.00 8.00
2.00 1.00 5.00
3.00 2.00 4.00
Baris ke-2 dikurangi baris ke-1 dikali 0.50
4.00 2.00 8.00
0.00 0.00 1.00
3.00 2.00 4.00
Baris ke-3 dikurangi baris ke-1 dikali 0.75
4.00 2.00 8.00
0.00 0.00 1.00
0.00 0.50 -2.00
Tukar baris ke-2 dan baris ke-3
4.00 2.00 8.00
0.00 0.50 -2.00
0.00 0.00 1.00
Baris ke-3 dikurangi baris ke-2 dikali 0.00
4.00 2.00 8.00
0.00 0.50 -2.00
0.00 0.00 1.00
Bentuk matriksnya setelah operasi segitiga adalah:
4.00 2.00 8.00
0.00 0.50 -2.00
0.00 0.00 1.00
Determinan perkalian diagonal utamanya adalah (plus minus bergantung banyaknya operasi swap): -2.0
```
### Metode Kofaktor
Metode perhitungan determinan ini menggunakan minor dan kofaktor pada matriks tersebut.
Perhitungan determinan akan menggunakan elemen pada baris pertama yang masing-masing dikalikan dengan kofaktornya.
Masing - masing kofaktor akan dihitung dengan mencari minornya yang kemudian determinannya akan dihitung pula menggunakan fungsi determinan metode kofaktor itu sendiri (rekursi).

Pengguna akan diminta untuk menginput matriks yang akan dihitung determinannya seperti berikut:
```
Masukkan baris matriksnya: 3
Masukkan kolom matriksnya: 3
Masukkan nilai untuk baris ke-1 kolom ke-1: 2
Masukkan nilai untuk baris ke-1 kolom ke-2: 0
Masukkan nilai untuk baris ke-1 kolom ke-3: 1
Masukkan nilai untuk baris ke-2 kolom ke-1: 3
Masukkan nilai untuk baris ke-2 kolom ke-2: 1
Masukkan nilai untuk baris ke-2 kolom ke-3: 2
Masukkan nilai untuk baris ke-3 kolom ke-1: 4
Masukkan nilai untuk baris ke-3 kolom ke-2: 2
Masukkan nilai untuk baris ke-3 kolom ke-3: 3
Mencari determinan dengan menggunakan kofaktor pada baris pertama.
Determinannya adalah: 2.0*-1.0 + 0.0*-1.0 + 1.0*2.0: 0.0
```
## Matrix Balikan
### Metode OBE
### Metode Adjoint
## Interpolasi Polinom
## Regresi Linear Berganda
