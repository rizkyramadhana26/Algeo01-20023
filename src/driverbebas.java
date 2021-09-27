class driverbebas {
  public static void main(String[] args) {
    Matrix m1 = new Matrix(3,3);
    Matrix m2 = new Matrix(3,3);
    Matrix m3 = new Matrix(3,3);
    //m.createMatrix(3, 3);
    //m.displayMatrix();
    m1.readMatrix(3,3);
    m2.readMatrix(3,3);
    //m1.displayMatrix();
    //m2 = m1.copyMatrix();
    //m2.displayMatrix();
    //System.out.println(m1.isRowsZero());
    //System.out.println(m1.isColsZero());
    //System.out.println(m1.determinanOBE());
    m3 = m3.kaliMatrix(m1,m2);
    m3.displayMatrix();
    //System.out.println(m1.determinanOBE());
    //System.out.println("Yang asli: ");
    //m1.displayMatrix();
  }
}