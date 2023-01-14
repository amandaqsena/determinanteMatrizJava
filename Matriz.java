package determinanteMatriz;

public class Matriz {
    
    public double[][] valores;

    public void setValores(double[][] valores){
        this.valores = valores;
    }

    public double[][] getValores(){
        return this.valores;
    }

	private boolean ehPar(int numero) {
		return ((numero%2) == 0);
	};
	
	private double[][] removeLinhaEColuna(int linha,int coluna,double[][] matriz){
		int p = 0;
		
		int dimensao = matriz.length;
		double matrizResultado[][] = new double[dimensao-1][dimensao-1];

		for (int i = 0;i<dimensao;i++) {
			if (i == linha) {
				continue;
			}
			int q = 0;
			for (int j = 0; j<dimensao;j++) {
				if (j == coluna) {
					continue;
				}
				
				matrizResultado[p][q] = matriz[i][j];
				++q;
			}
			++p;
		};
		return matrizResultado;
		
	}
	
	public double getDeterminante() {
        double[][] matrizQuadrada = this.valores;
		double determinante = 0;
		int dimensao = matrizQuadrada.length;
		if (dimensao == 1) {
			determinante = matrizQuadrada[0][0];
		}
		else {
			for (int i = 0;i<dimensao; i++) {
                Matriz MatrizMenor = new Matriz();
                double[][] valoresMatrizMenor = removeLinhaEColuna(0,i,matrizQuadrada);
                MatrizMenor.setValores(valoresMatrizMenor);
				if (ehPar(i)) {
					determinante += matrizQuadrada[0][i]*
							MatrizMenor.getDeterminante();
				}
				else {
					determinante -= matrizQuadrada[0][i]*
							MatrizMenor.getDeterminante();
				}
					
			}	
		}
		
		return determinante;
	};

}
