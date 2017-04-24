package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import estructuras.GeneradorDeDatos;
import ordenamiento.MetodosDirectos;

public class MetodosDeOrdenamiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int[] arreglo;
	static int[] copiaArreglo;

	public static JCheckBox chckbxCasoAleatorio;
	public static JCheckBox chckbxMejorCaso;
	public static JCheckBox chckbxPeorCaso;
	public static JCheckBox chckbxCasoMixto;

	public static JCheckBox chckbxBubble;
	public static JCheckBox chckbxBubbleSignal;
	public static JCheckBox chckbxShakerSort;
	public static JCheckBox chckbxSelection;
	public static JCheckBox chckbxShellSort;
	public static JCheckBox chckbxQuickSort;

	private JPanel contentPane;
	private static JTextField txtAleatorioBubble;
	private static JTextField txtMejorBubble;
	private static JTextField txtPeorBubble;
	private static JTextField txtMixtoBubble;
	private static JTextField txtAleatorioBubbleSignal;
	private static JTextField txtMejorBubbleSignal;
	private static JTextField txtPeorBubbleSignal;
	private static JTextField txtMixtoBubbleSignal;
	private static JTextField txtAleatorioShaker;
	private static JTextField txtMejorShaker;
	private static JTextField txtPeorShaker;
	private static JTextField txtMixtoShaker;
	private static JTextField txtAleatorioSelection;
	private static JTextField txtMejorSelection;
	private static JTextField txtPeorSelection;
	private static JTextField txtMixtoSelection;
	private static JTextField txtAleatorioShell;
	private static JTextField txtMejorShell;
	private static JTextField txtPeorShell;
	private static JTextField txtMixtoShell;
	private static JTextField txtAleatorioQuick;
	private static JTextField txtMejorQuick;
	private static JTextField txtPeorQuick;
	private static JTextField txtMixtoQuick;
	private JLabel lblElementosPorArreglo;
	private static JComboBox<String> comboBoxElementos;
	private JLabel lblParaElCaso;
	private JLabel lblOrdenado;
	private static JSpinner spinnerPorciento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodosDeOrdenamiento frame = new MetodosDeOrdenamiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MetodosDeOrdenamiento() {
		setTitle("M\u00E9todos de ordenamiento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEjecutar.setBounds(6, 5, 100, 46);
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llamado();
			}
		});

		contentPane.setLayout(null);
		contentPane.add(btnEjecutar);

		chckbxCasoAleatorio = new JCheckBox("Caso aleatorio");
		chckbxCasoAleatorio.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCasoAleatorio.setBounds(112, 5, 150, 46);
		contentPane.add(chckbxCasoAleatorio);

		chckbxMejorCaso = new JCheckBox("Mejor caso");
		chckbxMejorCaso.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMejorCaso.setBounds(264, 5, 150, 46);
		contentPane.add(chckbxMejorCaso);

		chckbxPeorCaso = new JCheckBox("Peor caso");
		chckbxPeorCaso.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPeorCaso.setBounds(421, 5, 150, 46);
		contentPane.add(chckbxPeorCaso);

		chckbxCasoMixto = new JCheckBox("Caso mixto");
		chckbxCasoMixto.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCasoMixto.setBounds(573, 5, 150, 46);
		contentPane.add(chckbxCasoMixto);

		chckbxBubble = new JCheckBox("Bubble");
		chckbxBubble.setBounds(6, 58, 100, 23);
		contentPane.add(chckbxBubble);

		chckbxBubbleSignal = new JCheckBox("Bubble (signal)");
		chckbxBubbleSignal.setBounds(6, 84, 110, 23);
		contentPane.add(chckbxBubbleSignal);

		chckbxShakerSort = new JCheckBox("Shaker sort");
		chckbxShakerSort.setBounds(6, 110, 100, 23);
		contentPane.add(chckbxShakerSort);

		chckbxSelection = new JCheckBox("Selection");
		chckbxSelection.setBounds(6, 136, 100, 23);
		contentPane.add(chckbxSelection);

		chckbxShellSort = new JCheckBox("Shell sort");
		chckbxShellSort.setBounds(6, 162, 100, 23);
		contentPane.add(chckbxShellSort);

		chckbxQuickSort = new JCheckBox("Quick sort");
		chckbxQuickSort.setBounds(6, 188, 100, 23);
		contentPane.add(chckbxQuickSort);

		txtAleatorioBubble = new JTextField();
		txtAleatorioBubble.setBackground(Color.WHITE);
		txtAleatorioBubble.setEditable(false);
		txtAleatorioBubble.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioBubble.setText("segundos");
		txtAleatorioBubble.setBounds(122, 59, 140, 20);
		contentPane.add(txtAleatorioBubble);
		txtAleatorioBubble.setColumns(10);

		txtMejorBubble = new JTextField();
		txtMejorBubble.setBackground(Color.WHITE);
		txtMejorBubble.setEditable(false);
		txtMejorBubble.setText("segundos");
		txtMejorBubble.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorBubble.setColumns(10);
		txtMejorBubble.setBounds(274, 58, 140, 20);
		contentPane.add(txtMejorBubble);

		txtPeorBubble = new JTextField();
		txtPeorBubble.setBackground(Color.WHITE);
		txtPeorBubble.setEditable(false);
		txtPeorBubble.setText("segundos");
		txtPeorBubble.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorBubble.setColumns(10);
		txtPeorBubble.setBounds(431, 58, 140, 20);
		contentPane.add(txtPeorBubble);

		txtMixtoBubble = new JTextField();
		txtMixtoBubble.setBackground(Color.WHITE);
		txtMixtoBubble.setEditable(false);
		txtMixtoBubble.setText("segundos");
		txtMixtoBubble.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoBubble.setColumns(10);
		txtMixtoBubble.setBounds(583, 58, 140, 20);
		contentPane.add(txtMixtoBubble);

		txtAleatorioBubbleSignal = new JTextField();
		txtAleatorioBubbleSignal.setBackground(Color.WHITE);
		txtAleatorioBubbleSignal.setEditable(false);
		txtAleatorioBubbleSignal.setText("segundos");
		txtAleatorioBubbleSignal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioBubbleSignal.setColumns(10);
		txtAleatorioBubbleSignal.setBounds(122, 85, 140, 20);
		contentPane.add(txtAleatorioBubbleSignal);

		txtMejorBubbleSignal = new JTextField();
		txtMejorBubbleSignal.setBackground(Color.WHITE);
		txtMejorBubbleSignal.setEditable(false);
		txtMejorBubbleSignal.setText("segundos");
		txtMejorBubbleSignal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorBubbleSignal.setColumns(10);
		txtMejorBubbleSignal.setBounds(274, 85, 140, 20);
		contentPane.add(txtMejorBubbleSignal);

		txtPeorBubbleSignal = new JTextField();
		txtPeorBubbleSignal.setBackground(Color.WHITE);
		txtPeorBubbleSignal.setEditable(false);
		txtPeorBubbleSignal.setText("segundos");
		txtPeorBubbleSignal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorBubbleSignal.setColumns(10);
		txtPeorBubbleSignal.setBounds(431, 85, 140, 20);
		contentPane.add(txtPeorBubbleSignal);

		txtMixtoBubbleSignal = new JTextField();
		txtMixtoBubbleSignal.setBackground(Color.WHITE);
		txtMixtoBubbleSignal.setEditable(false);
		txtMixtoBubbleSignal.setText("segundos");
		txtMixtoBubbleSignal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoBubbleSignal.setColumns(10);
		txtMixtoBubbleSignal.setBounds(583, 85, 140, 20);
		contentPane.add(txtMixtoBubbleSignal);

		txtAleatorioShaker = new JTextField();
		txtAleatorioShaker.setBackground(Color.WHITE);
		txtAleatorioShaker.setEditable(false);
		txtAleatorioShaker.setText("segundos");
		txtAleatorioShaker.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioShaker.setColumns(10);
		txtAleatorioShaker.setBounds(122, 111, 140, 20);
		contentPane.add(txtAleatorioShaker);

		txtMejorShaker = new JTextField();
		txtMejorShaker.setBackground(Color.WHITE);
		txtMejorShaker.setEditable(false);
		txtMejorShaker.setText("segundos");
		txtMejorShaker.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorShaker.setColumns(10);
		txtMejorShaker.setBounds(274, 111, 140, 20);
		contentPane.add(txtMejorShaker);

		txtPeorShaker = new JTextField();
		txtPeorShaker.setBackground(Color.WHITE);
		txtPeorShaker.setEditable(false);
		txtPeorShaker.setText("segundos");
		txtPeorShaker.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorShaker.setColumns(10);
		txtPeorShaker.setBounds(431, 111, 140, 20);
		contentPane.add(txtPeorShaker);

		txtMixtoShaker = new JTextField();
		txtMixtoShaker.setBackground(Color.WHITE);
		txtMixtoShaker.setEditable(false);
		txtMixtoShaker.setText("segundos");
		txtMixtoShaker.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoShaker.setColumns(10);
		txtMixtoShaker.setBounds(583, 111, 140, 20);
		contentPane.add(txtMixtoShaker);

		txtAleatorioSelection = new JTextField();
		txtAleatorioSelection.setBackground(Color.WHITE);
		txtAleatorioSelection.setEditable(false);
		txtAleatorioSelection.setText("segundos");
		txtAleatorioSelection.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioSelection.setColumns(10);
		txtAleatorioSelection.setBounds(122, 137, 140, 20);
		contentPane.add(txtAleatorioSelection);

		txtMejorSelection = new JTextField();
		txtMejorSelection.setBackground(Color.WHITE);
		txtMejorSelection.setEditable(false);
		txtMejorSelection.setText("segundos");
		txtMejorSelection.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorSelection.setColumns(10);
		txtMejorSelection.setBounds(274, 137, 140, 20);
		contentPane.add(txtMejorSelection);

		txtPeorSelection = new JTextField();
		txtPeorSelection.setBackground(Color.WHITE);
		txtPeorSelection.setEditable(false);
		txtPeorSelection.setText("segundos");
		txtPeorSelection.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorSelection.setColumns(10);
		txtPeorSelection.setBounds(431, 137, 140, 20);
		contentPane.add(txtPeorSelection);

		txtMixtoSelection = new JTextField();
		txtMixtoSelection.setBackground(Color.WHITE);
		txtMixtoSelection.setEditable(false);
		txtMixtoSelection.setText("segundos");
		txtMixtoSelection.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoSelection.setColumns(10);
		txtMixtoSelection.setBounds(583, 137, 140, 20);
		contentPane.add(txtMixtoSelection);

		txtAleatorioShell = new JTextField();
		txtAleatorioShell.setBackground(Color.WHITE);
		txtAleatorioShell.setEditable(false);
		txtAleatorioShell.setText("segundos");
		txtAleatorioShell.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioShell.setColumns(10);
		txtAleatorioShell.setBounds(122, 163, 140, 20);
		contentPane.add(txtAleatorioShell);

		txtMejorShell = new JTextField();
		txtMejorShell.setBackground(Color.WHITE);
		txtMejorShell.setEditable(false);
		txtMejorShell.setText("segundos");
		txtMejorShell.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorShell.setColumns(10);
		txtMejorShell.setBounds(274, 163, 140, 20);
		contentPane.add(txtMejorShell);

		txtPeorShell = new JTextField();
		txtPeorShell.setBackground(Color.WHITE);
		txtPeorShell.setEditable(false);
		txtPeorShell.setText("segundos");
		txtPeorShell.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorShell.setColumns(10);
		txtPeorShell.setBounds(431, 163, 140, 20);
		contentPane.add(txtPeorShell);

		txtMixtoShell = new JTextField();
		txtMixtoShell.setBackground(Color.WHITE);
		txtMixtoShell.setEditable(false);
		txtMixtoShell.setText("segundos");
		txtMixtoShell.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoShell.setColumns(10);
		txtMixtoShell.setBounds(583, 163, 140, 20);
		contentPane.add(txtMixtoShell);

		txtAleatorioQuick = new JTextField();
		txtAleatorioQuick.setBackground(Color.WHITE);
		txtAleatorioQuick.setEditable(false);
		txtAleatorioQuick.setText("segundos");
		txtAleatorioQuick.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAleatorioQuick.setColumns(10);
		txtAleatorioQuick.setBounds(122, 189, 140, 20);
		contentPane.add(txtAleatorioQuick);

		txtMejorQuick = new JTextField();
		txtMejorQuick.setBackground(Color.WHITE);
		txtMejorQuick.setEditable(false);
		txtMejorQuick.setText("segundos");
		txtMejorQuick.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMejorQuick.setColumns(10);
		txtMejorQuick.setBounds(274, 189, 140, 20);
		contentPane.add(txtMejorQuick);

		txtPeorQuick = new JTextField();
		txtPeorQuick.setBackground(Color.WHITE);
		txtPeorQuick.setEditable(false);
		txtPeorQuick.setText("segundos");
		txtPeorQuick.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeorQuick.setColumns(10);
		txtPeorQuick.setBounds(431, 189, 140, 20);
		contentPane.add(txtPeorQuick);

		txtMixtoQuick = new JTextField();
		txtMixtoQuick.setBackground(Color.WHITE);
		txtMixtoQuick.setEditable(false);
		txtMixtoQuick.setText("segundos");
		txtMixtoQuick.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMixtoQuick.setColumns(10);
		txtMixtoQuick.setBounds(583, 189, 140, 20);
		contentPane.add(txtMixtoQuick);

		lblElementosPorArreglo = new JLabel("N\u00B0 de elementos por arreglo:");
		lblElementosPorArreglo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblElementosPorArreglo.setBounds(144, 227, 171, 23);
		contentPane.add(lblElementosPorArreglo);

		comboBoxElementos = new JComboBox<String>();
		comboBoxElementos.setModel(
				new DefaultComboBoxModel<String>(new String[] { "10000", "20000", "40000", "80000", "100000" }));
		comboBoxElementos.setBounds(314, 229, 64, 20);
		contentPane.add(comboBoxElementos);

		lblParaElCaso = new JLabel("*Para el caso mixto: ");
		lblParaElCaso.setFont(new Font("Arial", Font.PLAIN, 13));
		lblParaElCaso.setBounds(455, 227, 122, 23);
		contentPane.add(lblParaElCaso);

		lblOrdenado = new JLabel("% ordenado.");
		lblOrdenado.setFont(new Font("Arial", Font.PLAIN, 13));
		lblOrdenado.setBounds(609, 227, 85, 23);
		contentPane.add(lblOrdenado);

		spinnerPorciento = new JSpinner();
		spinnerPorciento.setModel(new SpinnerNumberModel(50, 1, 99, 1));
		spinnerPorciento.setBounds(573, 227, 35, 20);
		contentPane.add(spinnerPorciento);
	}// MetodosDeOrdenamiento

	/**
	 * Método que contiene todo el código necesario para la ejecución de cada
	 * método de ordenamiento.
	 */
	public static void llamado() {

		int numeroDeDatos = (Integer.parseInt((String) comboBoxElementos.getSelectedItem()));
		int porcentajeOrdenado = (int) spinnerPorciento.getValue();

		// Guarda la hora del sistema al inicio y final de la ejecución de un
		// método de ordenamiento.
		long inicio = 0;
		long fin = 0;

		if (chckbxCasoAleatorio.isSelected()) {
			arreglo = GeneradorDeDatos.casoAleatorio(numeroDeDatos);

			if (chckbxBubble.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.bubbleSort(copiaArreglo);
				fin = System.nanoTime();
				txtAleatorioBubble.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
			if (chckbxBubbleSignal.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.bubbleSortConSeñal(copiaArreglo);
				fin = System.nanoTime();
				txtAleatorioBubbleSignal.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
			if (chckbxShakerSort.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.shakerSort(copiaArreglo);
				fin = System.nanoTime();
				txtAleatorioShaker.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
			if (chckbxSelection.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.seleccionDirecta(copiaArreglo);
				fin = System.nanoTime();
				txtAleatorioSelection.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
			if (chckbxShellSort.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.shellSort(copiaArreglo);
				fin = System.nanoTime();
				txtAleatorioShell.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
			if (chckbxQuickSort.isSelected()) {
				copiarArreglo();
				inicio = System.nanoTime();
				MetodosDirectos.quicksort(copiaArreglo, 0, copiaArreglo.length - 1);
				fin = System.nanoTime();
				txtAleatorioQuick.setText((double) (fin - inicio) * 1.0e-9 + "");
			}
		}

		if (chckbxMejorCaso.isSelected()) {
			arreglo = GeneradorDeDatos.mejorCasoAscendente(numeroDeDatos);

		}

		if (chckbxPeorCaso.isSelected()) {
			arreglo = GeneradorDeDatos.peorCasoAscendente(numeroDeDatos);

		}

		if (chckbxCasoMixto.isSelected()) {
			arreglo = GeneradorDeDatos.casoMixto(numeroDeDatos, porcentajeOrdenado);
		}
	}// llamado

	public static void copiarArreglo() {
		copiaArreglo = new int[arreglo.length];
		System.arraycopy(arreglo, 0, copiaArreglo, 0, arreglo.length);
	}
}// class