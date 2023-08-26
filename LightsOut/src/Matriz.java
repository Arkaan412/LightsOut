public class Matriz {
	private boolean[][] matriz;

	public Matriz(int tamanioMatriz) {
		matriz = new boolean[tamanioMatriz][tamanioMatriz];

		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = false;
			}
		}
	}
	
	public int tamanio() {
		return matriz.length;
	}

	public boolean obtenerValorCelda(int fila, int columna) {
		return matriz[fila][columna];
	}

	public boolean[] obtenerFila(int fila) {
		return matriz[fila];
	}

	public boolean[] obtenerColumna(int columna) {
		return matriz[columna];
	}

	public boolean[][] obtenerMatriz() {
		return matriz;
	}

	public void cambiarValorCelda(int fila, int columna) {
		boolean valorActualCelda = obtenerValorCelda(fila, columna);
		boolean nuevoValor = !valorActualCelda;

		matriz[fila][columna] = nuevoValor;
	}

	public void cambiarValorFila(int fila) {
		for (int i = 0; i < matriz.length; i++) {
			cambiarValorCelda(fila, i);
		}
	}

	public void cambiarValorColumna(int columna) {
		for (int i = 0; i < matriz.length; i++) {
			cambiarValorCelda(i, columna);
		}
	}

	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				cadena += matriz[i][j];
				cadena += ", ";
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	public static void main(String[] args) {
		Matriz matriz = new Matriz(3);
		
		System.out.println(matriz.toString());
	}
}