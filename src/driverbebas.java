class driverbebas {
  public static void main(String[] args) {
    Matrix m1 = new Matrix(3,3);
    Matrix m2 = new Matrix(3,3);
    //m.createMatrix(3, 3);
    //m.displayMatrix();
    m1.readMatrix(3,3);
    m1.displayMatrix();
    //m2 = m1.copyMatrix();
    //m2.displayMatrix();
    //System.out.println(m1.isRowsZero());
    //System.out.println(m1.isColsZero());
    m2 = m1.convertToSegitigaAtas();
    m2.displayMatrix();
  }
}