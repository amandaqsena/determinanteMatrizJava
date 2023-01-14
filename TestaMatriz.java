package determinanteMatriz;

public class TestaMatriz {
    public static void main(String[] args) {
        double[][] valores0 = {
				{1,2},
				{3,4},
		};
		
        Matriz m0 = new Matriz();
        m0.setValores(valores0);
		System.out.println(m0.getDeterminante());
        
        double[][] valores1 = {
				{1}
		};
		
        Matriz m1 = new Matriz();
        m1.setValores(valores1);
		System.out.println(m1.getDeterminante());

        double[][] valores2 = {
				{1,0},
				{0,1},
		};
		
        Matriz m2 = new Matriz();
        m2.setValores(valores2);
		System.out.println(m2.getDeterminante());
        

    }
}

