package es.rf.tienda.vistas;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTable;

import es.rf.tienda.controllers.CategoriaController;
import es.rf.tienda.dominio.Categoria;

public class LCCategoria extends JFrame implements ActionListener, MouseListener {

	/**
	 * Falta comentario
	 */
	private static final long serialVersionUID = 1L;

	private static LCCategoria instancia;
	private JTable listado;
	private String codigo = "";
	private List<Categoria> listaCategoria;
	private static CategoriaController controller;

	private String[] cabecera = { "id", "Nombre", "Descripcion" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					controller = new CategoriaController();
					List<Categoria> lista = controller.leerTodos();
					LCCategoria frame = LCCategoria.getInstance();
					frame.setController(controller);
					frame.setDatos(lista);
					frame.montarPantalla().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private LCCategoria() {
		montarPantalla();
	}

	public static LCCategoria getInstance() {
		if (instancia == null)
			instancia = new LCCategoria();
		return instancia;
	}

	public void setController(CategoriaController obj) {
		LCCategoria.controller = obj;

	}

	public void setDatos(List<Categoria> lista) {
		listaCategoria = lista;
		// *************montando listado
		getContentPane().add(montaListado(cabecera), BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JFrame montarPantalla() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 660, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));

		// ***** panel de filtro ******
		JPanel opciones = new JPanel();
		opciones.setBackground(Color.WHITE);
		opciones.setForeground(Color.BLACK);
		getContentPane().add(opciones, BorderLayout.WEST);
		JLabel filtros = new JLabel("Filtros");
		opciones.add(filtros);

		// Botonera
		JPanel botonera = new JPanel();
		botonera.setLayout(new BorderLayout(0, 0));
		botonera.setBackground(Color.WHITE);
		getContentPane().add(botonera, BorderLayout.SOUTH);

		botonera.add(montaBoton("Cancelar", "cancela", false), BorderLayout.EAST);

		JPanel botoneraIzquierda = new JPanel();
		botoneraIzquierda.setLayout(new BoxLayout(botoneraIzquierda, BoxLayout.X_AXIS));
		botoneraIzquierda.add(montaBoton("Quitar filtros", "qFiltro", false));
		botoneraIzquierda.add(montaBoton("Nuevo", "nuevo", false));
		botoneraIzquierda.add(montaBoton("Modificar", "modificar", false));
		botoneraIzquierda.add(montaBoton("Ver", "ver", false));

		botonera.add(botoneraIzquierda, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Listado categorias");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		return this;
	}

	public JScrollPane montaListado(String[] cabecera) {

		DefaultTableModel tableModel = new DefaultTableModel(leer(listaCategoria).toArray(new Object[][] {}),
				cabecera) {
			@Override
			public boolean isCellEditable(int row, int column) { // hacerla no editable
				// all cells false
				return false;
			}
		};
		listado = new JTable(tableModel);
		listado.setFocusable(false);
		JScrollPane listTableScroll = new JScrollPane(listado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		listado.addMouseListener(this);
		return listTableScroll;

	}

	/**
	 * Monta un boton con el texto y la orden indicada
	 * 
	 * @param texto
	 * @param orden
	 * @return
	 */
	public JButton montaBoton(String texto, String orden, boolean desactivado) {
		JButton btt = new JButton(texto);
		btt.addActionListener(this);
		btt.setActionCommand(orden);
		btt.setEnabled(!desactivado);
		return btt;
	}

	public List<String[]> leer(List<Categoria> lista) {

		List<String[]> salida = new ArrayList<String[]>();
		for (Categoria cat : lista) {
			salida.add(cat.toArray());
		}
		return salida;
	}

	public void ordCancelar() {
		setVisible(false);
		dispose();
	}

	public void ordNuevo() {
		System.out.println("Añadir");
		controller.setOption(new String[] { CategoriaController.ADD, "0" });
	}

	public void ordQuitaFiltros() {
		System.out.println("Quitar filtrosr");
	}

	public void ordBorrar() {
		if (!codigo.equals("")) {
			System.out.println("Borrar:" + codigo);
			controller.setOption(new String[] { CategoriaController.DELETE, codigo });
		}
	}

	public void ordModificar() {
		if (!codigo.equals("")) {
			System.out.println("Modificar:" + codigo);
			controller.setOption(new String[] { CategoriaController.UPDATE, codigo });
		}
	}

	public void ordVer() {
		if (!codigo.equals("")) {
			System.out.println("Ver:" + codigo);
			controller.setOption(new String[] { CategoriaController.VIEW, codigo });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Entro:" + e.getActionCommand());
		String comando = e.getActionCommand();
		if (comando.equals("cancela"))
			ordCancelar();
		else if (comando.equals("nuevo"))
			ordNuevo();
		else if (comando.equals("qFiltro"))
			ordQuitaFiltros();
		else if (comando.equals("modificar"))
			ordModificar();
		else if (comando.equals("ver"))
			ordVer();

	}

	@Override
	public void mouseClicked(MouseEvent me) {

		JTable table = (JTable) me.getSource();
		int linea = table.getSelectedRow();
		this.codigo = table.getValueAt(linea, 0).toString();
		System.out.println(this.codigo);
		if (me.getClickCount() == 2) {
			ordModificar();

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
