package matrixDeterminant;

public class Matrix {
    
    public double[][] values;

    public void setValues(double[][] values){
        this.values = values;
    }

    public double[][] getValues(){
        return this.values;
    }
	
	private Matrix removeLineAndColumn(int line,int column){
		int p = 0;
		
		int dimension = this.values.length;
		Matrix matrix = new Matrix();
		double matrixValues[][] = new double[dimension-1][dimension-1];

		for (int i = 0;i<dimension;i++) {
			if (i == line) {
				continue;
			}
			int q = 0;
			for (int j = 0; j<dimension;j++) {
				if (j == column) {
					continue;
				}
				
				matrixValues[p][q] = this.values[i][j];
				++q;
			}
			++p;
		};

		matrix.setValues(matrixValues);
		return matrix;
		
	}
	
	public double getDeterminant() {
        double[][] squareMatrixValues = this.values;
		double determinant = 0;
		int dimensao = squareMatrixValues.length;
		if (dimensao == 1) {
			determinant = this.values[0][0];
		}
		else {
			for (int i = 0;i<dimensao; i++) {

                Matrix smaler = this.removeLineAndColumn(0,i);

				boolean even = (i%2) == 0;
				if (even) {
					determinant += squareMatrixValues[0][i]*
						smaler.getDeterminant();
				}
				else {
					determinant -= squareMatrixValues[0][i]*
						smaler.getDeterminant();
				}
					
			}	
		}
		
		return determinant;
	};

}
