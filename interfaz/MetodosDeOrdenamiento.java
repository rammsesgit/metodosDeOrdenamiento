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
import javax.swing.JOptionPane;
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
	// Guarda la hora del sistema al inicio y final de la ejecución de un método
	// de ordenamiento.
	static long inicio = 0;
	static long fin = 0;
	static String tiempo = "";

	static int minutos = 0;
	static int segundos = 0;
	static int decisegundos = 0;
	static int centisegundo = 0;
	static int milisegundo = 0;
	static int microsegundo = 0;
	static long nanosegundo = 0;

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
	private JButton button;

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
		txtAleatorioBubble.setForeground(Color.RED);
		txtAleatorioBubble.setBackground(Color.WHITE);
		txtAleatorioBubble.setEditable(false);
		txtAleatorioBubble.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioBubble.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioBubble.setBounds(122, 59, 145, 20);
		contentPane.add(txtAleatorioBubble);
		txtAleatorioBubble.setColumns(10);

		txtMejorBubble = new JTextField();
		txtMejorBubble.setForeground(Color.RED);
		txtMejorBubble.setBackground(Color.WHITE);
		txtMejorBubble.setEditable(false);
		txtMejorBubble.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorBubble.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorBubble.setColumns(10);
		txtMejorBubble.setBounds(277, 58, 145, 20);
		contentPane.add(txtMejorBubble);

		txtPeorBubble = new JTextField();
		txtPeorBubble.setForeground(Color.RED);
		txtPeorBubble.setBackground(Color.WHITE);
		txtPeorBubble.setEditable(false);
		txtPeorBubble.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorBubble.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorBubble.setColumns(10);
		txtPeorBubble.setBounds(431, 58, 145, 20);
		contentPane.add(txtPeorBubble);

		txtMixtoBubble = new JTextField();
		txtMixtoBubble.setForeground(Color.RED);
		txtMixtoBubble.setBackground(Color.WHITE);
		txtMixtoBubble.setEditable(false);
		txtMixtoBubble.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoBubble.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoBubble.setColumns(10);
		txtMixtoBubble.setBounds(583, 58, 145, 20);
		contentPane.add(txtMixtoBubble);

		txtAleatorioBubbleSignal = new JTextField();
		txtAleatorioBubbleSignal.setForeground(Color.RED);
		txtAleatorioBubbleSignal.setBackground(Color.WHITE);
		txtAleatorioBubbleSignal.setEditable(false);
		txtAleatorioBubbleSignal.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioBubbleSignal.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioBubbleSignal.setColumns(10);
		txtAleatorioBubbleSignal.setBounds(122, 85, 145, 20);
		contentPane.add(txtAleatorioBubbleSignal);

		txtMejorBubbleSignal = new JTextField();
		txtMejorBubbleSignal.setForeground(Color.RED);
		txtMejorBubbleSignal.setBackground(Color.WHITE);
		txtMejorBubbleSignal.setEditable(false);
		txtMejorBubbleSignal.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorBubbleSignal.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorBubbleSignal.setColumns(10);
		txtMejorBubbleSignal.setBounds(277, 85, 145, 20);
		contentPane.add(txtMejorBubbleSignal);

		txtPeorBubbleSignal = new JTextField();
		txtPeorBubbleSignal.setForeground(Color.RED);
		txtPeorBubbleSignal.setBackground(Color.WHITE);
		txtPeorBubbleSignal.setEditable(false);
		txtPeorBubbleSignal.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorBubbleSignal.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorBubbleSignal.setColumns(10);
		txtPeorBubbleSignal.setBounds(431, 85, 145, 20);
		contentPane.add(txtPeorBubbleSignal);

		txtMixtoBubbleSignal = new JTextField();
		txtMixtoBubbleSignal.setForeground(Color.RED);
		txtMixtoBubbleSignal.setBackground(Color.WHITE);
		txtMixtoBubbleSignal.setEditable(false);
		txtMixtoBubbleSignal.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoBubbleSignal.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoBubbleSignal.setColumns(10);
		txtMixtoBubbleSignal.setBounds(583, 85, 145, 20);
		contentPane.add(txtMixtoBubbleSignal);

		txtAleatorioShaker = new JTextField();
		txtAleatorioShaker.setForeground(Color.RED);
		txtAleatorioShaker.setBackground(Color.WHITE);
		txtAleatorioShaker.setEditable(false);
		txtAleatorioShaker.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioShaker.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioShaker.setColumns(10);
		txtAleatorioShaker.setBounds(122, 111, 145, 20);
		contentPane.add(txtAleatorioShaker);

		txtMejorShaker = new JTextField();
		txtMejorShaker.setForeground(Color.RED);
		txtMejorShaker.setBackground(Color.WHITE);
		txtMejorShaker.setEditable(false);
		txtMejorShaker.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorShaker.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorShaker.setColumns(10);
		txtMejorShaker.setBounds(277, 111, 145, 20);
		contentPane.add(txtMejorShaker);

		txtPeorShaker = new JTextField();
		txtPeorShaker.setForeground(Color.RED);
		txtPeorShaker.setBackground(Color.WHITE);
		txtPeorShaker.setEditable(false);
		txtPeorShaker.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorShaker.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorShaker.setColumns(10);
		txtPeorShaker.setBounds(431, 111, 145, 20);
		contentPane.add(txtPeorShaker);

		txtMixtoShaker = new JTextField();
		txtMixtoShaker.setForeground(Color.RED);
		txtMixtoShaker.setBackground(Color.WHITE);
		txtMixtoShaker.setEditable(false);
		txtMixtoShaker.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoShaker.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoShaker.setColumns(10);
		txtMixtoShaker.setBounds(583, 111, 145, 20);
		contentPane.add(txtMixtoShaker);

		txtAleatorioSelection = new JTextField();
		txtAleatorioSelection.setForeground(Color.RED);
		txtAleatorioSelection.setBackground(Color.WHITE);
		txtAleatorioSelection.setEditable(false);
		txtAleatorioSelection.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioSelection.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioSelection.setColumns(10);
		txtAleatorioSelection.setBounds(122, 137, 145, 20);
		contentPane.add(txtAleatorioSelection);

		txtMejorSelection = new JTextField();
		txtMejorSelection.setForeground(Color.RED);
		txtMejorSelection.setBackground(Color.WHITE);
		txtMejorSelection.setEditable(false);
		txtMejorSelection.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorSelection.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorSelection.setColumns(10);
		txtMejorSelection.setBounds(277, 137, 145, 20);
		contentPane.add(txtMejorSelection);

		txtPeorSelection = new JTextField();
		txtPeorSelection.setForeground(Color.RED);
		txtPeorSelection.setBackground(Color.WHITE);
		txtPeorSelection.setEditable(false);
		txtPeorSelection.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorSelection.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorSelection.setColumns(10);
		txtPeorSelection.setBounds(431, 137, 145, 20);
		contentPane.add(txtPeorSelection);

		txtMixtoSelection = new JTextField();
		txtMixtoSelection.setForeground(Color.RED);
		txtMixtoSelection.setBackground(Color.WHITE);
		txtMixtoSelection.setEditable(false);
		txtMixtoSelection.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoSelection.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoSelection.setColumns(10);
		txtMixtoSelection.setBounds(583, 137, 145, 20);
		contentPane.add(txtMixtoSelection);

		txtAleatorioShell = new JTextField();
		txtAleatorioShell.setForeground(Color.RED);
		txtAleatorioShell.setBackground(Color.WHITE);
		txtAleatorioShell.setEditable(false);
		txtAleatorioShell.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioShell.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioShell.setColumns(10);
		txtAleatorioShell.setBounds(122, 163, 145, 20);
		contentPane.add(txtAleatorioShell);

		txtMejorShell = new JTextField();
		txtMejorShell.setForeground(Color.RED);
		txtMejorShell.setBackground(Color.WHITE);
		txtMejorShell.setEditable(false);
		txtMejorShell.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorShell.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorShell.setColumns(10);
		txtMejorShell.setBounds(277, 163, 145, 20);
		contentPane.add(txtMejorShell);

		txtPeorShell = new JTextField();
		txtPeorShell.setForeground(Color.RED);
		txtPeorShell.setBackground(Color.WHITE);
		txtPeorShell.setEditable(false);
		txtPeorShell.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorShell.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorShell.setColumns(10);
		txtPeorShell.setBounds(431, 163, 145, 20);
		contentPane.add(txtPeorShell);

		txtMixtoShell = new JTextField();
		txtMixtoShell.setForeground(Color.RED);
		txtMixtoShell.setBackground(Color.WHITE);
		txtMixtoShell.setEditable(false);
		txtMixtoShell.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoShell.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoShell.setColumns(10);
		txtMixtoShell.setBounds(583, 163, 145, 20);
		contentPane.add(txtMixtoShell);

		txtAleatorioQuick = new JTextField();
		txtAleatorioQuick.setForeground(Color.RED);
		txtAleatorioQuick.setBackground(Color.WHITE);
		txtAleatorioQuick.setEditable(false);
		txtAleatorioQuick.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtAleatorioQuick.setHorizontalAlignment(SwingConstants.CENTER);
		txtAleatorioQuick.setColumns(10);
		txtAleatorioQuick.setBounds(122, 189, 145, 20);
		contentPane.add(txtAleatorioQuick);

		txtMejorQuick = new JTextField();
		txtMejorQuick.setForeground(Color.RED);
		txtMejorQuick.setBackground(Color.WHITE);
		txtMejorQuick.setEditable(false);
		txtMejorQuick.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMejorQuick.setHorizontalAlignment(SwingConstants.CENTER);
		txtMejorQuick.setColumns(10);
		txtMejorQuick.setBounds(277, 189, 145, 20);
		contentPane.add(txtMejorQuick);

		txtPeorQuick = new JTextField();
		txtPeorQuick.setForeground(Color.RED);
		txtPeorQuick.setBackground(Color.WHITE);
		txtPeorQuick.setEditable(false);
		txtPeorQuick.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtPeorQuick.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeorQuick.setColumns(10);
		txtPeorQuick.setBounds(431, 189, 145, 20);
		contentPane.add(txtPeorQuick);

		txtMixtoQuick = new JTextField();
		txtMixtoQuick.setForeground(Color.RED);
		txtMixtoQuick.setBackground(Color.WHITE);
		txtMixtoQuick.setEditable(false);
		txtMixtoQuick.setText("ss;ds;cs;ms;\u00B5s;ns");
		txtMixtoQuick.setHorizontalAlignment(SwingConstants.CENTER);
		txtMixtoQuick.setColumns(10);
		txtMixtoQuick.setBounds(583, 189, 145, 20);
		contentPane.add(txtMixtoQuick);

		lblElementosPorArreglo = new JLabel("N\u00B0 de elementos por arreglo:");
		lblElementosPorArreglo.setFont(new Font("Arial", Font.PLAIN, 13));
		lblElementosPorArreglo.setBounds(144, 227, 171, 23);
		contentPane.add(lblElementosPorArreglo);

		comboBoxElementos = new JComboBox<String>();
		comboBoxElementos.setModel(new DefaultComboBoxModel<String>(new String[] { "500", "1500", "4500", "13500",
				"40500", "121500", "364500", "1093500", "3280500", "9841500" }));
		comboBoxElementos.setBounds(314, 229, 79, 20);
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

		button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				informacion();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		button.setBounds(29, 228, 46, 23);
		contentPane.add(button);

		informacion();

	}// MetodosDeOrdenamiento

	/**
	 * Método que contiene todo el código necesario para la ejecución de cada
	 * método de ordenamiento.
	 */
	public static void llamado() {

		int numeroDeDatos = (Integer.parseInt((String) comboBoxElementos.getSelectedItem()));
		int porcentajeOrdenado = (int) spinnerPorciento.getValue();

		if (chckbxCasoAleatorio.isSelected()) {
			arreglo = GeneradorDeDatos.casoAleatorio(numeroDeDatos);

			if (chckbxBubble.isSelected()) {
				capturaDeTiempoParaBubble();
				txtAleatorioBubble.setText(tiempo);
			}
			if (chckbxBubbleSignal.isSelected()) {
				capturaDeTiempoParaBubbleSignal();
				txtAleatorioBubbleSignal.setText(tiempo);
			}
			if (chckbxShakerSort.isSelected()) {
				capturaDeTiempoParaShakerSort();
				txtAleatorioShaker.setText(tiempo);
			}
			if (chckbxSelection.isSelected()) {
				capturaDeTiempoParaSeleccionDirecta();
				txtAleatorioSelection.setText(tiempo);
			}
			if (chckbxShellSort.isSelected()) {
				capturaDeTiempoParaShellSort();
				txtAleatorioShell.setText(tiempo);
			}
			if (chckbxQuickSort.isSelected()) {
				capturaDeTiempoParaQuickSort();
				txtAleatorioQuick.setText(tiempo);
			}
		}

		if (chckbxMejorCaso.isSelected()) {
			arreglo = GeneradorDeDatos.mejorCasoAscendente(numeroDeDatos);

			if (chckbxBubble.isSelected()) {
				capturaDeTiempoParaBubble();
				txtMejorBubble.setText(tiempo);
			}
			if (chckbxBubbleSignal.isSelected()) {
				capturaDeTiempoParaBubbleSignal();
				txtMejorBubbleSignal.setText(tiempo);
			}
			if (chckbxShakerSort.isSelected()) {
				capturaDeTiempoParaShakerSort();
				txtMejorShaker.setText(tiempo);
			}
			if (chckbxSelection.isSelected()) {
				capturaDeTiempoParaSeleccionDirecta();
				txtMejorSelection.setText(tiempo);
			}
			if (chckbxShellSort.isSelected()) {
				capturaDeTiempoParaShellSort();
				txtMejorShell.setText(tiempo);
			}
			if (chckbxQuickSort.isSelected()) {
				capturaDeTiempoParaQuickSort();
				txtMejorQuick.setText(tiempo);
			}

		}

		if (chckbxPeorCaso.isSelected()) {
			arreglo = GeneradorDeDatos.peorCasoAscendente(numeroDeDatos);

			if (chckbxBubble.isSelected()) {
				capturaDeTiempoParaBubble();
				txtPeorBubble.setText(tiempo);
			}
			if (chckbxBubbleSignal.isSelected()) {
				capturaDeTiempoParaBubbleSignal();
				txtPeorBubbleSignal.setText(tiempo);
			}
			if (chckbxShakerSort.isSelected()) {
				capturaDeTiempoParaShakerSort();
				txtPeorShaker.setText(tiempo);
			}
			if (chckbxSelection.isSelected()) {
				capturaDeTiempoParaSeleccionDirecta();
				txtPeorSelection.setText(tiempo);
			}
			if (chckbxShellSort.isSelected()) {
				capturaDeTiempoParaShellSort();
				txtPeorShell.setText(tiempo);
			}
			if (chckbxQuickSort.isSelected()) {
				capturaDeTiempoParaQuickSort();
				txtPeorQuick.setText(tiempo);
			}
		}

		if (chckbxCasoMixto.isSelected()) {
			arreglo = GeneradorDeDatos.casoMixto(numeroDeDatos, porcentajeOrdenado);

			if (chckbxBubble.isSelected()) {
				capturaDeTiempoParaBubble();
				txtMixtoBubble.setText(tiempo);
			}
			if (chckbxBubbleSignal.isSelected()) {
				capturaDeTiempoParaBubbleSignal();
				txtMixtoBubbleSignal.setText(tiempo);
			}
			if (chckbxShakerSort.isSelected()) {
				capturaDeTiempoParaShakerSort();
				txtMixtoShaker.setText(tiempo);
			}
			if (chckbxSelection.isSelected()) {
				capturaDeTiempoParaSeleccionDirecta();
				txtMixtoSelection.setText(tiempo);
			}
			if (chckbxShellSort.isSelected()) {
				capturaDeTiempoParaShellSort();
				txtMixtoShell.setText(tiempo);
			}
			if (chckbxQuickSort.isSelected()) {
				capturaDeTiempoParaQuickSort();
				txtMixtoQuick.setText(tiempo);
			}
		}
	}// llamado

	/**
	 * Método que hace una copia del arreglo original.
	 */
	public static void copiarArreglo() {
		copiaArreglo = new int[arreglo.length];
		System.arraycopy(arreglo, 0, copiaArreglo, 0, arreglo.length);
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método BubbleSort.
	 */
	public static void capturaDeTiempoParaBubble() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.bubbleSort(copiaArreglo);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método BubbleSort con señal.
	 */
	public static void capturaDeTiempoParaBubbleSignal() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.bubbleSortConSeñal(copiaArreglo);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método Shaker sort.
	 */
	public static void capturaDeTiempoParaShakerSort() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.shakerSort(copiaArreglo);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método seleccionDirecta.
	 */
	public static void capturaDeTiempoParaSeleccionDirecta() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.seleccionDirecta(copiaArreglo);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método Shell Sort.
	 */
	public static void capturaDeTiempoParaShellSort() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.shellSort(copiaArreglo);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que contiene el código necesario para copiar el arreglo original,
	 * ordenar la copia del arreglo y calcular el tiempo de ejecución para el
	 * método Quick Sort.
	 */
	public static void capturaDeTiempoParaQuickSort() {
		copiarArreglo();
		inicio = System.nanoTime();
		MetodosDirectos.quicksort(copiaArreglo, 0, copiaArreglo.length - 1);
		fin = System.nanoTime();
		segundos = 0;
		decisegundos = 0;
		centisegundo = 0;
		milisegundo = 0;
		microsegundo = 0;
		nanosegundo = fin - inicio;
		formatoDeTiempo();
	}

	/**
	 * Método que da un formato en mm;ss;ds;cs;ms;µs;ns a partir de los
	 * nanosegundos que dure la ejecución de un método de ordenamiento.
	 */
	public static void formatoDeTiempo() {
		while (nanosegundo > 999) {
			microsegundo++;
			nanosegundo -= 1000;
			if (microsegundo > 999) {
				milisegundo++;
				microsegundo -= 1000;
				if (milisegundo > 9) {
					centisegundo++;
					milisegundo -= 10;
					if (centisegundo > 9) {
						decisegundos++;
						centisegundo -= 10;
						if (decisegundos > 9) {
							segundos++;
							decisegundos -= 10;
							if (segundos > 59) {
								minutos++;
							}
						}
					}
				}
			}
		} // while

		tiempo = segundos + ";" + decisegundos + ";" + centisegundo + ";" + milisegundo + ";" + microsegundo + ";"
				+ nanosegundo;
	}// formatoDeTiempo

	/**
	 * Método que muestra una ventana con información sobre la medida del tiempo
	 * de ejecución.
	 */
	public static void informacion() {
		JOptionPane.showMessageDialog(null,
				"La medición del tiempo de ejecución está dada en:" + "\n                      mm;ss;ds;cs;ms;µs;ns"
						+ "\n\nmm = minutos \nss = segundos \nds = décimas de segundo (decisegundos)"
						+ "\ncs = centésimas de segundo (centisegundo) \nms = milésimas de segundo (milisegundo)"
						+ "\nµs = millonésimas de segundo (microsegundo)"
						+ "\nns = milmillonésimas de segundo (nanosegundo)");
	}
}// class
