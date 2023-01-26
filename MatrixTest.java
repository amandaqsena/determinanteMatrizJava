package matrixDeterminant;

public class MatrixTest {
    public static void main(String[] args) {
        double[][] valores0 = {
				{1,2},
				{3,4},
		};
		
        Matrix m0 = new Matrix();
        m0.setValues(valores0);
		System.out.println(m0.getDeterminant());
        
        double[][] valores1 = {
				{1}
		};
		
        Matrix m1 = new Matrix();
        m1.setValues(valores1);
		System.out.println(m1.getDeterminant());

        double[][] valores2 = {
				{1,0},
				{0,1},
		};
		
        Matrix m2 = new Matrix();
        m2.setValues(valores2);
		System.out.println(m2.getDeterminant());
        
        double[][] valores3 = {
            {3,0},
            {0,3},
        };

        Matrix m3 = new Matrix();
        m3.setValues(valores3);
		System.out.println(m3.getDeterminant());

        Matrix m4 = m3.times(m2);
        System.out.println(m4.getDeterminant());

        double[][] valores5 = {
            {2,0},
            {0,3},
        };

        Matrix m5 = new Matrix();
        m5.setValues(valores5);
		System.out.println(m5.getDeterminant());

        Matrix m6 = m4.times(m5);
        System.out.println(m6.getDeterminant());

    }
}

