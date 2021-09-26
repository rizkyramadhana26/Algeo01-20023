import java.util.Arrays;

class driverbebas {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 3);
        double solusi[];
        //m.createMatrix(3, 3);
        //m.displayMatrix();
        m1.readMatrix(3, 3);
        m1.displayMatrix();
        m2 = m1.copyMatrix();
        m2.displayMatrix();
        System.out.println(m1.isRowsZero());
        System.out.println(m1.isColsZero());
        m2 = m1.convertToSegitigaAtas();
        m2.displayMatrix();
        System.out.println("m1 adalah matriks eselon baris : "+m1.cekEselon());
        System.out.println("m2 adalah matriks eselon baris : "+m2.cekEselon());
        Matrix matEselon = new Matrix(3,4);
        Matrix mat = new Matrix(3,4);
        mat.readMatrix(3,4);
        matEselon = mat.convertToEselon();
        solusi=matEselon.substitusiBalik();
        System.out.println(Arrays.toString(solusi));
    }
}