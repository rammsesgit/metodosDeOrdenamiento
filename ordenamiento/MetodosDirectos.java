package ordenamiento;

/**
 * @author Isar Ramses Cadena Gaona
 * 
 *         Clase instanciable que contiene los m�todos de ordenamiento vistos en
 *         clase.
 */
public class MetodosDirectos {
	/**
	 * M�todo burbuja.
	 * 
	 * @param arreglo
	 *            para ordenar
	 * @return arreglo ordenado
	 */
	public static int[] bubbleSort(int[] arreglo) {
		for (int i = 0; i < arreglo.length - 1; i++) {
			for (int j = 0; j < arreglo.length - i - 1; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					int auxiliar = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = auxiliar;
				}
			}
		}
		return arreglo;
	}

	/**
	 * Burbuja con se�al.
	 * 
	 * @param arreglo
	 *            para ordenar
	 * @return arreglo ordenado
	 */
	public static int[] bubbleSortConSe�al(int[] arreglo) {
		boolean cambios = false;

		for (int i = 0; i < arreglo.length - 1; i++) {
			cambios = false;

			for (int j = 0; j < arreglo.length - 1; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					int auxiliar = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = auxiliar;
					cambios = true;
				}
			}

			// Si a lo largo de la �ltima pasada no se realiz� por lo menos un
			// cambio entonces se entiende que el arreglo ya est� ordenado.
			if (!cambios) {
				return arreglo;
			}
		}
		return arreglo;
	}

	/**
	 * M�todo shakerSort (sacudida) que consiste en ordenar un arreglo
	 * recorriendo �ste de extremo a extremo cambiando de lugar los elementos
	 * adyacentes entre s�, para que cumplan con el orden esperado.
	 * 
	 * @param arreglo
	 *            (recibe un arreglo que contiene elementos con el fin de
	 *            ordenarlos)
	 * @return sin valores de retorno
	 */
	public static void shakerSort(int[] arreglo) {
		// Variables boolean que indican si sucedi� o no un cambio de orden
		// dentro del arreglo.
		boolean cambio1 = false, cambio2 = false;

		// Variable temporal que almacena un dato para poder manipularlo
		// seg�n convenga.
		int temporal = 0;

		// El n�mero m�ximo de ejecuciones es n/2 en �ste tipo de ordenamiento,
		// por lo cual el ciclo se repite mientras i < arreglo.length/2.
		for (int i = 0; i < arreglo.length / 2; i++) {

			// Ciclo que recorre el arreglo de izquierda a derecha.
			for (int j = 0 + i; j < arreglo.length - i - 1; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					temporal = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temporal;

					cambio1 = true;
				} else {
					cambio1 = false;
				}
			}

			// Ciclo que recorre el arreglo de derecha a izquierda.
			for (int k = 0; k < arreglo.length - i - 1; k++) {
				if (arreglo[arreglo.length - k - 1] < arreglo[arreglo.length - k - 2]) {
					temporal = arreglo[arreglo.length - k - 1];
					arreglo[arreglo.length - k - 1] = arreglo[arreglo.length - k - 2];
					arreglo[arreglo.length - k - 2] = temporal;

					cambio2 = true;
				} else {
					cambio2 = false;
				}
			}

			// Si no se realiza ning�n cambio, se da por entendido que el
			// arreglo ya est� ordenado, por lo cual no es necesario continuar
			// ejecutando el ciclo.
			if (!cambio1 && !cambio2) {
				break;
			}
		}
	}// shakerSort

	/**
	 * M�todo que ordena de forma ascendente los valores dentro de un arreglo
	 * recibido mediante selecci�n directa.
	 * 
	 * @param arreglo
	 *            (que contiene los datos a ordenar)
	 * @return sin valores de retorno
	 */
	public static void seleccionDirecta(int[] arreglo) {
		for (int i = 0; i < arreglo.length - 1; i++) {

			int indiceDelMenor = i;
			int menor = arreglo[i];

			// Busca el dato menor y guarda su �ndice.
			for (int j = i; j < arreglo.length; j++) {
				if (menor > arreglo[j]) {
					menor = arreglo[j];
					indiceDelMenor = j;
				}
			}

			// Se intercambian los valores entre el primer dato y el dato menor,
			// ambos del conjunto probablemente no ordenado.
			int temporal = arreglo[i];
			arreglo[i] = arreglo[indiceDelMenor];
			arreglo[indiceDelMenor] = temporal;
		}

	}// seleccionDirecta

	/**
	 * M�todo para inserci�n directa, consiste en recorrer todo el arreglo
	 * comenzando desde el segundo elemento, el elemento seleccionado se compara
	 * con los anteriores pertenecientes al conjunto ya ordenado, cambiando su
	 * posici�n si es necesario para lograr un orden ascendente.
	 * 
	 * @param arreglo
	 * @return sin valores de retorno
	 */
	public static void shellSort(int[] arreglo) {
		// salto es la distancia que hay entre el dato que se toma con el dato
		// que se compara.
		int salto = arreglo.length / 2;

		while (salto / 2 >= 1) {
			for (int i = 1; i < arreglo.length; i++) {
				int temporal = arreglo[i];
				int indiceAnterior = i - salto;

				while ((indiceAnterior >= 0) && (temporal < arreglo[indiceAnterior])) {
					arreglo[indiceAnterior + salto] = arreglo[indiceAnterior];
					indiceAnterior -= salto;
				}

				arreglo[indiceAnterior + salto] = temporal;
			}

			salto /= 2;
		}
	}// shellSort

	/**
	 * 
	 * @param arreglo
	 *            a ordenar.
	 * @param izquierda
	 * @param derecha
	 */
	public static void quicksort(int arreglo[], int izquierda, int derecha) {

		int pivote = arreglo[izquierda];
		int i = izquierda;
		int j = derecha;
		int auxiliar;

		while (i < j) {

			while (arreglo[i] <= pivote && i < j) {
				i++;
			}

			while (arreglo[j] > pivote) {
				j--;
			}

			if (i < j) {
				// si no se han cruzado los indices, los intercambia.
				auxiliar = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = auxiliar;
			}
		}
		// se coloca el pivote en su lugar.
		arreglo[izquierda] = arreglo[j];

		arreglo[j] = pivote;

		if (izquierda < j - 1)
			// Mandamos llamar al metodo recursivo para que ordene la primer
			// mitad del arreglo.
			quicksort(arreglo, izquierda, j - 1);
		if (j + 1 < derecha)
			// Ahora la segunda mitad.
			quicksort(arreglo, j + 1, derecha);
	}// quicksort

}// Class