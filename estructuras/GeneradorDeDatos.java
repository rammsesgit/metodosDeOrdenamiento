package estructuras;

import java.util.Random;

public class GeneradorDeDatos {

	/**
	 * Genera valores aleatorios.
	 * 
	 * @param tama�o
	 *            del arreglo
	 * @return arreglo lleno de valores aleatorios
	 */
	public static int[] casoAleatorio(int tama�o) {
		Random numeroAleatorio = new Random();

		// Arreglo del tama�o indicado, que contendr� los valores. Con valor
		// absoluto para evitar excepci�n por tama�o negativo en el arreglo.
		int[] datos = new int[Math.abs(tama�o)];

		for (int i = 0; i < tama�o; i++) {
			datos[i] = numeroAleatorio.nextInt(10);
		}

		return datos;
	}

	/**
	 * Genera valores en el mejor caso para un orden ascendente, peor si es
	 * descendente. Si el tama�o recibido es negativo, se toma su valor
	 * absoluto.
	 * 
	 * @param tama�o
	 *            (tama�o del arreglo a generar)
	 * @return arreglo que contendr� los valores generados
	 */
	public static int[] mejorCasoAscendente(int tama�o) {
		// Arreglo del tama�o indicado, que contendr� los valores. Con valor
		// absoluto para evitar excepci�n por tama�o en el arreglo.
		int[] datos = new int[Math.abs(tama�o)];

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
	 * M�todo que crea un arreglo del tama�o recibido y lo llena de valores en
	 * orden descendente, dando as� el peor caso.
	 * 
	 * @param tama�o
	 *            (tama�o del arreglo)
	 * @return arreglo con los valores en el peor caso
	 */
	public static int[] peorCasoAscendente(int tama�o) {
		// Arreglo del tama�o indicado, que contendr� los valores. Con valor
		// absoluto para evitar excepci�n por tama�o negativo en el arreglo.
		int[] datos = new int[Math.abs(tama�o)];

		for (int i = 0; i < datos.length; i++) {
			// Llena los elementos del arreglo con valor descendente.
			datos[i] = datos.length - i;
		}
		return datos;
	}

	/**
	 * M�todo que crea un arreglo con valores mixtos haciendo uso de los m�todos
	 * mejorCasoAscendente y casoAleatorio para llenarlo.
	 * 
	 * @param tama�o,porcentajeOrdenado
	 *            (el tama�o del arreglo y el porcentaje del arreglo que debe
	 *            estar ordenado)
	 * @return arreglo con valores mixtos
	 */
	public static int[] casoMixto(int tama�o, int porcentajeOrdenado) {
		// Arreglo del tama�o recibido.
		int[] datosMixto = new int[tama�o];
		// Arreglo con datos ordenados de un tama�o seg�n el porcentaje
		// recibido.
		int[] datosOrdenados = mejorCasoAscendente((int) ((porcentajeOrdenado / 100.0) * tama�o));
		// Arreglo con datos aleatorios, su tama�o equivale a la diferencia
		// entre el tama�o del arreglo ordenado ascendente y el tama�o del
		// arreglo mixto.
		int[] datosAleatorios = casoAleatorio(Math.abs(tama�o - datosOrdenados.length));

		// Se copia el arreglo ordenado en el arreglo mixto.
		System.arraycopy(datosOrdenados, 0, datosMixto, 0, datosOrdenados.length);
		// Se copia el arreglo con datos aleatorios en el arreglo mixto.
		System.arraycopy(datosAleatorios, 0, datosMixto, datosOrdenados.length, datosAleatorios.length);

		return datosMixto;
	}
}