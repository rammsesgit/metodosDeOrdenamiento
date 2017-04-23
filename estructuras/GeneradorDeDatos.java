package estructuras;

import java.util.Random;

public class GeneradorDeDatos {

	/**
	 * Genera valores aleatorios.
	 * 
	 * @param tamaño
	 *            del arreglo
	 * @return arreglo lleno de valores aleatorios
	 */
	public static int[] casoAleatorio(int tamaño) {
		Random numeroAleatorio = new Random();

		// Arreglo del tamaño indicado, que contendrá los valores. Con valor
		// absoluto para evitar excepción por tamaño negativo en el arreglo.
		int[] datos = new int[Math.abs(tamaño)];

		for (int i = 0; i < tamaño; i++) {
			datos[i] = numeroAleatorio.nextInt(10);
		}

		return datos;
	}

	/**
	 * Genera valores en el mejor caso para un orden ascendente, peor si es
	 * descendente. Si el tamaño recibido es negativo, se toma su valor
	 * absoluto.
	 * 
	 * @param tamaño
	 *            (tamaño del arreglo a generar)
	 * @return arreglo que contendrá los valores generados
	 */
	public static int[] mejorCasoAscendente(int tamaño) {
		// Arreglo del tamaño indicado, que contendrá los valores. Con valor
		// absoluto para evitar excepción por tamaño en el arreglo.
		int[] datos = new int[Math.abs(tamaño)];

		for (int i = 0; i < datos.length; i++) {
			// Llena los elementos del arreglo con valor ascendente.
			datos[i] = i + 1;
		}

		// Regreso el arreglo creado.
		return datos;
	}

	/**
	 * Genera valores en el mejor caso para un orden ascendente, peor si es
	 * descendente.
	 * 
	 * @param datos
	 *            (arreglo a llenar)
	 * @return sin valores de retorno.
	 */
	public void mejorCasoAscendente(int[] datos) {
		for (int i = 0; i < datos.length; i++) {
			// Llena los elementos del arreglo con valor ascendente.
			datos[i] = i + 1;
		}
	}

	/**
	 * Método que crea un arreglo del tamaño recibido y lo llena de valores en
	 * orden descendente, dando así el peor caso.
	 * 
	 * @param tamaño
	 *            (tamaño del arreglo)
	 * @return arreglo con los valores en el peor caso
	 */
	public static int[] peorCasoAscendente(int tamaño) {
		// Arreglo del tamaño indicado, que contendrá los valores. Con valor
		// absoluto para evitar excepción por tamaño negativo en el arreglo.
		int[] datos = new int[Math.abs(tamaño)];

		for (int i = 0; i < datos.length; i++) {
			// Llena los elementos del arreglo con valor descendente.
			datos[i] = datos.length - i;
		}
		return datos;
	}

	/**
	 * Método que crea un arreglo con valores mixtos haciendo uso de los métodos
	 * mejorCasoAscendente y casoAleatorio para llenarlo.
	 * 
	 * @param tamaño,porcentajeOrdenado
	 *            (el tamaño del arreglo y el porcentaje del arreglo que debe
	 *            estar ordenado)
	 * @return arreglo con valores mixtos
	 */
	public static int[] casoMixto(int tamaño, int porcentajeOrdenado) {
		// Arreglo del tamaño recibido.
		int[] datosMixto = new int[tamaño];
		// Arreglo con datos ordenados de un tamaño según el porcentaje
		// recibido.
		int[] datosOrdenados = mejorCasoAscendente((int) ((porcentajeOrdenado / 100.0) * tamaño));
		// Arreglo con datos aleatorios, su tamaño equivale a la diferencia
		// entre el tamaño del arreglo ordenado ascendente y el tamaño del
		// arreglo mixto.
		int[] datosAleatorios = casoAleatorio(Math.abs(tamaño - datosOrdenados.length));

		// Se copia el arreglo ordenado en el arreglo mixto.
		System.arraycopy(datosOrdenados, 0, datosMixto, 0, datosOrdenados.length);
		// Se copia el arreglo con datos aleatorios en el arreglo mixto.
		System.arraycopy(datosAleatorios, 0, datosMixto, datosOrdenados.length, datosAleatorios.length);

		return datosMixto;
	}
}