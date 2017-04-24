package aplicacion;

import javax.swing.JOptionPane;

import estructuras.GeneradorDeDatos;
import ordenamiento.MetodosDirectos;

public class AplicacionOrdenamiento {
	static int[] arreglo;

	static int[] copiaArreglo;

	static String arregloAMostrar = "";

	/**
	 * Aplicación que le permite al usuario llenar arreglos con datos en
	 * diferentes tipos de orden, además, ordenarlos posteriormente.
	 * 
	 * @param args
	 * @return sin valores de retorno
	 */
	public static void main(String[] args) {

		String[] menuPrincipal = { "Generar datos", "Ordenamiento", "Salir" };

		// Contiene las opciones que se muestran tras elegir "Generar datos" en
		// el meú principal.
		String[] menuParaGenerarDatos = { "Datos aleatorios", "Mejor caso ascendente", "Peor caso ascendente",
				"Caso mixto" };

		// Contiene las opciones que se muestran tras elegir "Ordenamiento" en
		// el menú principal.
		String[] menuParaOrdenamiento = { "Burbuja", "Burbuja con señal", "Shaker sort", "Selección directa",
				"Shell sort", "Quick sort" };

		// Variables String que almacenan la opción que haya elegido el usuario
		// en los distintos menús.
		String eleccionDelMenuPrincipal = "";
		String eleccionGenerarDatos = "";
		String eleccionOrdenamiento = "";

		boolean arregloCreado = false;

		// Guarda la hora del sistema al inicio y final de la ejecución de un
		// método de ordenamiento.
		long inicio = 0;
		long fin = 0;

		try {
			do {
				// Menú para el usuario.
				eleccionDelMenuPrincipal = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
						"Menú principal", JOptionPane.DEFAULT_OPTION, null, menuPrincipal, menuPrincipal[0]);

				switch (eleccionDelMenuPrincipal) {
				case "Generar datos":
					// Menú para el usuario.
					eleccionGenerarDatos = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
							"Menú Generar Datos", JOptionPane.DEFAULT_OPTION, null, menuParaGenerarDatos,
							menuParaGenerarDatos[0]);

					// Dependiendo de la opción elegida por el usuario se
					// realizan diferentes pasos.
					switch (eleccionGenerarDatos) {
					case "Datos aleatorios":
						arreglo = GeneradorDeDatos.casoAleatorio(
								Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño será el arreglo?", "10")));
						break;

					case "Mejor caso ascendente":
						arreglo = GeneradorDeDatos.mejorCasoAscendente(
								Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño será el arreglo?", "10")));
						break;

					case "Peor caso ascendente":
						arreglo = GeneradorDeDatos.peorCasoAscendente(
								Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño será el arreglo?", "10")));
						break;

					case "Caso mixto":
						arreglo = GeneradorDeDatos.casoMixto(
								Integer.parseInt(JOptionPane.showInputDialog("¿De que tamaño será el arreglo?", "10")),
								Integer.parseInt(JOptionPane
										.showInputDialog("¿Que porcentaje del arreglo estará ordenado?", "70")));
						break;

					}

					// Se copia un areglo para trabajar sobre la copia sin
					// alterar el original.
					copiaArreglo = new int[arreglo.length];
					System.arraycopy(arreglo, 0, copiaArreglo, 0, arreglo.length);

					if (arreglo.length < 20) {
						JOptionPane.showMessageDialog(null, "Arreglo generado: " + mostrarArreglos(arreglo));
					}
					arregloCreado = true;
					break;

				case "Ordenamiento":
					if (!arregloCreado) {
						JOptionPane.showMessageDialog(null, "Antes se tiene que crear un arreglo.");
						break;
					} else {
						System.arraycopy(arreglo, 0, copiaArreglo, 0, arreglo.length);
					}

					if (arreglo.length < 20) {
						eleccionOrdenamiento = (String) JOptionPane.showInputDialog(null,
								"Arreglo a ordenar: " + mostrarArreglos(arreglo) + "\nSeleccione una opción",
								"Menú de ordenamiento", JOptionPane.DEFAULT_OPTION, null, menuParaOrdenamiento,
								menuParaOrdenamiento[0]);
					} else {
						eleccionOrdenamiento = (String) JOptionPane.showInputDialog(null, "\nSeleccione una opción",
								"Menú de ordenamiento", JOptionPane.DEFAULT_OPTION, null, menuParaOrdenamiento,
								menuParaOrdenamiento[0]);
					}

					switch (eleccionOrdenamiento) {
					case "Burbuja":

						inicio = System.nanoTime();
						MetodosDirectos.bubbleSort(copiaArreglo);
						break;

					case "Burbuja con señal":
						inicio = System.nanoTime();
						MetodosDirectos.bubbleSortConSeñal(copiaArreglo);
						break;

					case "Shaker sort":
						inicio = System.nanoTime();
						MetodosDirectos.shakerSort(copiaArreglo);
						break;

					case "Selección directa":
						inicio = System.nanoTime();
						MetodosDirectos.seleccionDirecta(copiaArreglo);
						break;

					case "Shell sort":
						inicio = System.nanoTime();
						MetodosDirectos.shellSort(copiaArreglo);
						break;

					case "Quick sort":
						inicio = System.nanoTime();
						MetodosDirectos.quicksort(copiaArreglo, 0, copiaArreglo.length - 1);
						break;
					}

					fin = System.nanoTime();
					if (arreglo.length < 20) {
						JOptionPane.showMessageDialog(null,
								"Arreglo original: " + mostrarArreglos(arreglo) + "\nArreglo ordenado: "
										+ mostrarArreglos(copiaArreglo) + "\nLa ejecución tomó "
										+ ((double) (fin - inicio) * 1.0e-9) + " segundos.");
					} else {
						JOptionPane.showMessageDialog(null,
								"La ejecución tomó " + ((double) (fin - inicio) * 1.0e-9) + " segundos.");

					}

					break;
				}// switch principal

				// El ciclo contiua mientras la opcion elegida NO sea "Salir".
			} while (!eleccionDelMenuPrincipal.equals("Salir"));
		} catch (NullPointerException nPE) {
			// Si el usuario no elige una opción para el menú, se termina la
			// ejecución.
		} catch (NumberFormatException nFE) {
			// Si el usuario deja la aplicación antes de ingresar el tamaño de
			// un arreglo, ésta se detiene.
		}
	}// main

	/**
	 * Método que recibe un arreglo y regresa todos sus valores en un String,
	 * además guarda una copia del arreglo con la que trabajan los métodos de
	 * ordenamiento y así no alterar el arreglo original.
	 * 
	 * @param arreglo
	 * @return arreglo a mostar (un String que contiene cada valor del arreglo)
	 */
	public static String mostrarArreglos(int[] array) {
		// Aquí se guardan los valores del arreglo para después ser
		// mostrados.
		arregloAMostrar = "| ";

		for (int i = 0; i < array.length; i++) {
			arregloAMostrar += array[i] + " | ";
		}

		return arregloAMostrar;
	}

}// Class
