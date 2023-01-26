package matrixDeterminant;

/**
 * @author amandasena97@gmail.com
 */

public class Matrix {
    
    public double[][] values;

    public void setValues(double[][] values){
        this.values = values;
    }

    public double[][] getValues(){
        return this.values;
    }

	/**
	 * @author amandasena97@gmail.com
	 * @param line line to be removed
	 * @param column column to be removed
	 * @return a smaller matrix without specified line and column
	 */
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
	

	/**
	 * @author amandasena97@gmail.com
	 * @return the matrix determinant
	 */
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
	}

	public Matrix times(Matrix otherMatrix){
		Matrix result = new Matrix();
		int imax = this.getValues().length - 1;
		int jmax = otherMatrix.getValues()[0].length -1;
		int kmax = otherMatrix.getValues().length - 1;
		double[][] resultValues = new double[imax+1][jmax+1];
		for(int i=0;i<=imax;i++){
			for(int j = 0;j<=jmax;j++){
				resultValues[i][j] = 0;
				for(int k=0;k<=kmax;k++){
					resultValues[i][j] += this.getValues()[i][k]*otherMatrix.getValues()[k][j]; 
				}
			}
		}
		result.setValues(resultValues);
		return result;

	}

}
