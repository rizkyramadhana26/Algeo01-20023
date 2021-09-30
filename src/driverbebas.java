import java.util.Arrays;

class driverbebas {
  public static void main(String[] args) {
    // Matrix m2 = new Matrix(3,3);
    // Matrix m3 = new Matrix(3,3);
    //m.createMatrix(3, 3);
    //m.displayMatrix();
    // m1.readMatrix(3,3);
    // m2.readMatrix(3,3);
    //m1.displayMatrix();
    //m2 = m1.copyMatrix();
    //m2.displayMatrix();
    //System.out.println(m1.isRowsZero());
    //System.out.println(m1.isColsZero());
    //System.out.println(m1.determinanOBE());
    // m3 = m3.kaliMatrix(m1,m2);
    // m3.displayMatrix();
    //System.out.println(m1.determinanOBE());
    //System.out.println("Yang asli: ");
    //m1.displayMatrix();
    Matrix m1 = new Matrix(3,7);
    m1.readMatrix(3,7);
    System.out.println(m1.cekReadyEselon());
    Matrix mProses = m1.extendMatrix(m1.cols-1>m1.rows ? m1.cols-1-m1.rows : 0,0);
    Matrix eselon = mProses.convertToEselon(false);
    if(!eselon.isUndef()){
      double solusi[] = eselon.substitusiBalik();
      System.out.println("Penyelesaian persamaan tersebut adalah"); //asumsi solusi tunggal
      System.out.println(Arrays.toString(solusi));
    }
  }
}