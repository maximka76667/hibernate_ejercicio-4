package ejercicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ButtonGroup botonescampo;
	private ButtonGroup botonesorden;
	private JComboBox cbpuesto;
	private JRadioButton rbnumero;
	private JRadioButton rbnombre;
	private JComboBox cbnumdeptno;
	private JTable tabla;
	private JButton bmostrar;
	private JRadioButton rbsalario;
	private JRadioButton rbjefe;
	private JRadioButton rbpuesto;
	private JRadioButton rbcomision;
	private JRadioButton rbdeptno;
	private JRadioButton rbascendente;
	private JRadioButton rbdescendente;

	public void rellenarcombos() {
		ArrayList<String> puestos = BBDD.puestos();
		cbpuesto.addItem("");
		for (String puesto : puestos) {
			cbpuesto.addItem(puesto);
		}
		ArrayList<Integer> numdeptnos = BBDD.numdeptnos();
		cbnumdeptno.addItem("");
		for (Integer numdeptno : numdeptnos) {
			cbnumdeptno.addItem(numdeptno.toString());
		}
	}

	public void rellenartabla(String orden, String puesto, String numdepartamento) {

		DefaultTableModel modelotabla = new DefaultTableModel(0, 3);
		String titulos[] = { "NUMERO", "NOMBRE", "PUESTO", "JEFE", "SALARIO", "COMSION", "DEPTNO" };
		modelotabla.setColumnIdentifiers(titulos);
		ArrayList<Empleados> empleados = BBDD.empleados(orden, puesto, numdepartamento);
		for (Empleados empleado : empleados) {
			String emp[] = { String.valueOf(empleado.getNumEmpleado()), empleado.getNombreEmpleado(),
					empleado.getPuesto(), String.valueOf(empleado.getNumJefe()), String.valueOf(empleado.getSalario()),
					String.valueOf(empleado.getComision()),
					String.valueOf(empleado.getDepartamentos().getNumDepartamento()) };
			modelotabla.addRow(emp);
		}
		tabla.setModel(modelotabla);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 629);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/ejercicio/empleados.jpg")));
		lblNewLabel.setBounds(627, 11, 194, 190);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ORDENACION", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(25, 11, 288, 254);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "FILTRO", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(382, 45, 194, 192);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		cbpuesto = new JComboBox();
		cbpuesto.setBounds(21, 52, 163, 20);
		panel_1.add(cbpuesto);

		cbnumdeptno = new JComboBox();
		cbnumdeptno.setBounds(21, 126, 163, 20);
		panel_1.add(cbnumdeptno);

		JLabel lblNewLabel_1 = new JLabel("PUESTO");
		lblNewLabel_1.setBounds(21, 27, 98, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NUM DEPTNO");
		lblNewLabel_2.setBounds(21, 97, 113, 14);
		panel_1.add(lblNewLabel_2);

		bmostrar = new JButton("Mostrar");
		bmostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String orden = "";
				if (rbnombre.isSelected())
					orden = "nombre_empleado";
				else if (rbnumero.isSelected())
					orden = "num_empleado";
				else if (rbpuesto.isSelected())
					orden = "puesto";
				else if (rbjefe.isSelected())
					orden = "numJefe";
				else if (rbsalario.isSelected())
					orden = "salario";
				else if (rbcomision.isSelected())
					orden = "comision";
				else if (rbdeptno.isSelected())
					orden = "num_Departamento";
				if (rbdescendente.isSelected())
					orden = orden + " DESC";
				rellenartabla(orden, cbpuesto.getSelectedItem().toString(), cbnumdeptno.getSelectedItem().toString());
			}
		});
		bmostrar.setBounds(382, 11, 182, 23);
		contentPane.add(bmostrar);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Campo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 24, 109, 219);
		panel.add(panel_2);
		panel_2.setLayout(null);

		rbnumero = new JRadioButton("Numero");
		rbnumero.setBounds(6, 17, 97, 23);
		panel_2.add(rbnumero);

		rbnombre = new JRadioButton("Nombre");
		rbnombre.setBounds(6, 43, 86, 23);
		panel_2.add(rbnombre);

		rbpuesto = new JRadioButton("Puesto");
		rbpuesto.setBounds(6, 69, 86, 23);
		panel_2.add(rbpuesto);

		rbjefe = new JRadioButton("Jefe");
		rbjefe.setBounds(6, 95, 79, 23);
		panel_2.add(rbjefe);

		rbsalario = new JRadioButton("Salario");
		rbsalario.setBounds(6, 121, 79, 23);
		panel_2.add(rbsalario);

		rbcomision = new JRadioButton("Comision");
		rbcomision.setBounds(6, 147, 86, 23);
		panel_2.add(rbcomision);

		rbdeptno = new JRadioButton("Deptno");
		rbdeptno.setBounds(6, 173, 79, 23);
		panel_2.add(rbdeptno);

		botonescampo = new ButtonGroup();
		botonescampo.add(rbnumero);
		botonescampo.add(rbnombre);
		botonescampo.add(rbpuesto);
		botonescampo.add(rbjefe);
		botonescampo.add(rbsalario);
		botonescampo.add(rbcomision);
		botonescampo.add(rbdeptno);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Orden", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(125, 24, 146, 95);
		panel.add(panel_3);
		panel_3.setLayout(null);

		rbascendente = new JRadioButton("Ascendente");
		rbascendente.setBounds(6, 24, 123, 23);
		panel_3.add(rbascendente);

		rbdescendente = new JRadioButton("Descendente");
		rbdescendente.setBounds(6, 53, 123, 23);
		panel_3.add(rbdescendente);

		botonesorden = new ButtonGroup();
		botonesorden.add(rbascendente);
		botonesorden.add(rbdescendente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 276, 781, 303);
		contentPane.add(scrollPane);

		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		rellenarcombos();
		rellenartabla("", "", "");

	}
}
