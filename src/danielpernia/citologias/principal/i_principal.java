package danielpernia.citologias.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.*;

import com.itextpdf.text.Image;

import javax.swing.JScrollPane;
import javax.swing.DropMode;

public class i_principal extends JFrame {

	private conexion db;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	JButton btnBuscar_1,btnNewButton_4;
	JButton btnGuardar_1,btnTerminar;
	private JLabel lblNewLabel,lblInformasionConsulta;
	JDatePickerImpl datePicker;
	private JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3,comboBox_4,comboBox_5,comboBox_6,comboBox_7,comboBox_9, comboBox_13,comboBox_12,comboBox_10,comboBox_11,comboBox_14,comboBox_15,comboBox_16,comboBox_17,comboBox_18,comboBox_8,comboBox_20,comboBox_19,comboBox_21 ;
	private JComboBox comboBox_28,comboBox_29,comboBox_30,comboBox_31;
	JTextArea textArea,textArea_1,textArea_2,textArea_3,textArea_4;
	private JTextField textField_21;
	JPanel panel,p_inicio,central;
	private JTextField textField_20;
	private JTable table;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField t_u_cedula;
	private JTextField t_u_nombre;
	private JTextField t_u_apellido;
	private JTextField textField_27;
	private JTextField textField_28;
	private JButton btnEditar;

	usuario usuario_,usu_acceso;
	medico medico_;
	paciente paciente_;
	estudio_citologico estudio;
	Vector<estudio_citologico> estudio_v;
	manejador_PDF pdf;
	private JTextField textField_29;
	private JPasswordField passwordField_4;
	private JPasswordField passwordField_5;
	private JPasswordField passwordField_3;
	String anno,mes,dia;
	private int totalEstudiosEstadistica, totalResultadoEstadistica;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i_principal frame = new i_principal();
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
	public i_principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 0, 1300,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setVisible(false);
		
		db = new conexion();
		db.conectar();
		
		pdf = new manejador_PDF();
		usuario_ = new usuario();
		usu_acceso = new usuario();
		medico_ = new medico();
		paciente_ = new paciente();
		estudio = new estudio_citologico();
		estudio_v = new Vector<estudio_citologico>(3, 3);
		comboBox_10 = new JComboBox();
		comboBox_17 = new JComboBox();
		comboBox_21 = new JComboBox();
		comboBox_21.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_17.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("Nuevo Estudio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)central.getLayout();
				//cl.show(central, "name_8159828611565");
				cl.show(central, "name_722126808976");
				//name_722126808976
				panel.setVisible(true);
				actualizarDatosMedico();
				limpiarNuevoEstudio();
				
				if(usu_acceso.rol == 1){
					textArea.setEnabled(false);
					comboBox_11.setEnabled(false);
					comboBox_12.setEnabled(false);
					comboBox_13.setEnabled(false);
					comboBox_14.setEnabled(false);
					comboBox_15.setEnabled(false);
					comboBox_16.setEnabled(false);
					comboBox_17.setEnabled(false);
					textArea_1.setEnabled(false);
				}else{
					textArea.setEnabled(true);
					comboBox_11.setEnabled(true);
					comboBox_12.setEnabled(true);
					comboBox_13.setEnabled(true);
					comboBox_14.setEnabled(true);
					comboBox_15.setEnabled(true);
					comboBox_16.setEnabled(true);
					comboBox_17.setEnabled(true);
					textArea_1.setEnabled(true);
				}
				
				
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnBuscarEstudio = new JButton("Consultar Estudio");
		btnBuscarEstudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_8159840041347");
				panel.setVisible(true);
			}
		});
		menuBar.add(btnBuscarEstudio);
		
		JButton btnImprimir = new JButton("Imprimir - Sincronizar");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_33870233261272");
				panel.setVisible(true);
				lblNewLabel.setText("");
				db.buscarEstudiosPendientesPorImprimir(estudio_v);
				System.out.println("pendientes !"+estudio_v.size());
			}
		});
		menuBar.add(btnImprimir);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_38544120539856");//medicos
				
				actualizarDatosMedico();
				panel.setVisible(true);
			}
		});
		menuBar.add(btnEstadisticas);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_38616660277399");
				panel.setVisible(true);
				
				if(usu_acceso.rol == 1){
					usuario_.cedula = usu_acceso.cedula;
					db.buscarUsuarioPorCedula(usuario_,true);
					
					t_u_cedula.setText(usu_acceso.cedula);
					t_u_nombre.setText(usuario_.nombres);
					t_u_apellido.setText(usuario_.apellidos);
					comboBox_20.setSelectedItem(usuario_.rol);
					passwordField_4.setText(usuario_.clave);
					passwordField_5.setText(usuario_.clave);
					
					comboBox_19.setEnabled(false);
					comboBox_20.setEnabled(false);
					t_u_cedula.setEnabled(false);
					btnBuscar_1.setEnabled(false);
					btnGuardar_1.setEnabled(false);
					
				}else{
					comboBox_19.setEnabled(true);
					comboBox_20.setEnabled(true);
					t_u_cedula.setEnabled(true);
					btnBuscar_1.setEnabled(true);
					btnGuardar_1.setEnabled(true);
				}
				
			}
		});
		menuBar.add(btnUsuarios);
		
		lblNewLabel = new JLabel("Bienvenido: Pedro Perez (Administrador)");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(63)
							.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(625, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JButton btnNewButton_7 = new JButton("Medicos");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_38579282003671");
				panel.setVisible(true);
			}
		});
		menuBar.add(btnNewButton_7);
		
		JButton btnNewButton_12 = new JButton("Salir");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usu_acceso.cedula = "";
				usu_acceso.clave ="";
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_30190169966599");
				panel.setVisible(false);
				textField_21.setText("");
				passwordField_3.setText("");
			}
		});
		menuBar.add(btnNewButton_12);
		panel.setLayout(gl_panel);
		
		central = new JPanel();
		contentPane.add(central, BorderLayout.CENTER);
		central.setLayout(new CardLayout(0, 0));
		
		p_inicio = new JPanel();
		p_inicio.setBackground(new Color(255, 255, 255));
		central.add(p_inicio, "name_30190169966599");
		
		JLabel lblNewLabel_26 = new JLabel("ESTUDIO CITOLOGICO");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_27 = new JLabel("Lcda. Lisbeth Jaimes");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_28 = new JLabel("RIF: V-15881409-5");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 153, 255));
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_p_inicio = new GroupLayout(p_inicio);
		gl_p_inicio.setHorizontalGroup(
			gl_p_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_inicio.createSequentialGroup()
					.addGap(254)
					.addGroup(gl_p_inicio.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_26)
						.addComponent(lblNewLabel_28)
						.addComponent(lblNewLabel_27))
					.addContainerGap(615, Short.MAX_VALUE))
		);
		gl_p_inicio.setVerticalGroup(
			gl_p_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_inicio.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_26)
					.addGap(18)
					.addComponent(lblNewLabel_27)
					.addGap(11)
					.addComponent(lblNewLabel_28)
					.addGap(57)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(248, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_24 = new JLabel("Usuario");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_25 = new JLabel("Contrase\u00F1a");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_21 = new JTextField();
		textField_21.setColumns(12);
		
		JButton btnNewButton_2 = new JButton("Entrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usu_acceso.cedula = textField_21.getText();
				
				if(db.buscarUsuarioPorCedula(usu_acceso,true)){
					
					if(usu_acceso.clave.equals(passwordField_3.getText())){
						CardLayout cl = (CardLayout)central.getLayout();
						cl.show(central, "name_722126808976");
						panel.setVisible(true);
						
						String rolstr = "";
						
						if(usu_acceso.rol == 0){
							rolstr = "Licenciada";
						}else if(usu_acceso.rol == 1){
							rolstr = "Ayudante";
						}else if(usu_acceso.rol == 2){
							rolstr = "Administrador";
						}
						//System.out.println("Rol!!!: "+usu_acceso.rol);
						lblNewLabel.setText("Bienvenid@: "+usu_acceso.nombres+" "+usu_acceso.apellidos+" ("+ rolstr+")");
						
						if(usu_acceso.rol == 1){
							textArea.setEnabled(false);
							comboBox_11.setEnabled(false);
							comboBox_12.setEnabled(false);
							comboBox_13.setEnabled(false);
							comboBox_14.setEnabled(false);
							comboBox_15.setEnabled(false);
							comboBox_16.setEnabled(false);
							comboBox_17.setEnabled(false);
							textArea_1.setEnabled(false);
							btnTerminar.setEnabled(false);
						}else{
							textArea.setEnabled(true);
							comboBox_11.setEnabled(true);
							//comboBox_12.setEnabled(true);
							//comboBox_13.setEnabled(true);
							//comboBox_14.setEnabled(true);
							//comboBox_15.setEnabled(true);
							//comboBox_16.setEnabled(true);
							//comboBox_17.setEnabled(true);
							textArea_1.setEnabled(true);
							btnTerminar.setEnabled(true);
						}
						
						limpiarFormularioPasiente();
						limpiarNuevoEstudio();
						estudio_v.clear();
						actualizarTabla(estudio_v);
						
					}else{
						JOptionPane.showMessageDialog(null, "Verefique Usuario y Clave");
					}
					
					
				}
				
				
			}
		});
		
		JLabel lblNewLabel_29 = new JLabel("Acceso al sistema por favor ingrese usuario y contrase\u00F1a");
		
		passwordField_3 = new JPasswordField();
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel_29)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_25, Alignment.TRAILING)
						.addComponent(lblNewLabel_24, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(passwordField_3)
							.addComponent(textField_21)))
					.addGap(121))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_29)
					.addGap(35)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_24, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_25))
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addGap(43))
		);
		panel_4.setLayout(gl_panel_4);
		p_inicio.setLayout(gl_p_inicio);
		
		actualizarDatosMedico();
		
		JPanel panel_1 = new JPanel();
		central.add(panel_1, "name_722126808976");
		panel_1.setBackground(new Color(230, 230, 250));
		
		JPanel tratamiento_previo = new JPanel();
		
		JPanel usuario = new JPanel();
		
		JPanel info_ginecologica = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		btnNewButton_4 = new JButton("Guardar Como Nuevo");
		btnNewButton_4.setToolTipText("Crea un nuevo estudio en espera por resultado");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				paciente_.cedula = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString()+textField_10.getText();
				
				if(db.buscarPasientePorCedula(paciente_)==1){
				}else{
					actulizarPasienteConFormulario();
					db.registrarPasiente(paciente_,true);
					//db.buscarPasientePorCedula(paciente_); // lo busco otra vez para sacar el rowid
				}
				
				actualizarEstudioConFormulario();
				
				estudio.estado = "esperando resultado";
				//estudio.numero_impresiones = 0;
				
				if(db.guardarEstudio(estudio,true) == 1){
					
					limpiarNuevoEstudio();

				}
				
				
				
				
				
			}
		});
		
		JButton btnGuardarYActualizar = new JButton("Actualizar");
		btnGuardarYActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actualizarEstudioConFormulario();
				
				if(db.EditarEstudio(estudio)==1){
					JOptionPane.showMessageDialog(null, "Estudio N° "+estudio.rowid+" Actualizado");
				}
				
				
			}
		});
		btnGuardarYActualizar.setToolTipText("Actualiza datos del estudio y paciente");
		
		btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actualizarEstudioConFormulario();
				estudio.estado = "terminado";
				estudio.numero_impresiones = -1;
				
				if(db.EditarEstudio(estudio)==1){
					JOptionPane.showMessageDialog(null, "Estudio N° "+estudio.rowid+" Listo para imprimir");
					db.actualizarImpresionesDeEstudio(estudio);
				}
			}
		});
		btnTerminar.setToolTipText("Estudio y resultado preparado para imprimir");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(usuario, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
								.addComponent(info_ginecologica, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 630, Short.MAX_VALUE)
								.addComponent(tratamiento_previo, 0, 0, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGuardarYActualizar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTerminar, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(info_ginecologica, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(tratamiento_previo, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTerminar)
						.addComponent(btnGuardarYActualizar)
						.addComponent(btnNewButton_4))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_22 = new JLabel("Resultado");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textArea = new JTextArea();
		textArea.setTabSize(0);
		textArea.setLineWrap(true);
		textArea.setColumns(30);
		textArea.setRows(5);
		
		JLabel lblCalidadDeLa = new JLabel("Calidad de la muestra");
		lblCalidadDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		comboBox_11 = new JComboBox();
		comboBox_11.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if( comboBox_11.getSelectedIndex() == 0 ){
					comboBox_12.setEnabled(false);
					comboBox_13.setEnabled(false);
					comboBox_14.setEnabled(true);
					comboBox_15.setEnabled(true);
					comboBox_16.setEnabled(true);
					comboBox_17.setEnabled(true);
					//update(getGraphics());
					
				}else{
					comboBox_12.setEnabled(true);
					comboBox_13.setEnabled(true);
					comboBox_14.setEnabled(false);
					comboBox_15.setEnabled(false);
					comboBox_16.setEnabled(false);
					comboBox_17.setEnabled(false);
					//update(getGraphics());
					
				}
			}
		});
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Satisfactoria para evaluaci\u00F3n", "Insatisfactoria para evaluaci\u00F3n"}));
		comboBox_11.setSelectedIndex(0);
		
		comboBox_12 = new JComboBox();
		comboBox_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_12.setModel(new DefaultComboBoxModel(new String[] {"Muestra rechazada y no procesada", "Muestra procesada y examinada pero insatisfactoria para la evaluaci\u00F3n de anomal\u00EDa epiteliales "}));
		comboBox_12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_13.removeAllItems();
				
				if(comboBox_12.getSelectedIndex() == 0){
					comboBox_13.addItem("por falta de datos para el procesamiento");
					comboBox_13.addItem("lamina invalidada por defecto fisico");
				}else if(comboBox_12.getSelectedIndex() == 1){
					comboBox_13.addItem("muy sanguinolenta");
					comboBox_13.addItem("muy inflamatoria");
					comboBox_13.addItem("escaso material celular");
				}
				//if("")
			}
		});
		
		comboBox_13 = new JComboBox();
		comboBox_13.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_13.addItem("por falta de datos para el procesamiento");
		comboBox_13.addItem("lamina invalidada por defecto fisico");
		comboBox_13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comboBox_12.setEnabled(false);
		comboBox_13.setEnabled(false);
		
		JLabel lblNewLabel_23 = new JLabel("Clasificacion General");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_14 = new JComboBox();
		comboBox_14.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_14.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				comboBox_15.removeAllItems();
				
				if(comboBox_14.getSelectedIndex() == 0){
					comboBox_15.addItem("MICROORGANISMOS");
					comboBox_15.addItem("OTROS HALLAZGOS NO NEOPLÁSICOS");
					comboBox_15.addItem("");
				}if(comboBox_14.getSelectedIndex() == 1){
					comboBox_15.addItem("CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años) ");
					comboBox_15.addItem("");
				}if(comboBox_14.getSelectedIndex() == 2){
					comboBox_15.addItem("CÉLULAS ESCAMOSAS");
					comboBox_15.addItem("CÉLULAS GLANDULARES");
					comboBox_15.addItem("");
				}if(comboBox_14.getSelectedIndex() == 3){
					comboBox_15.addItem("");
				}
			}
		});
		comboBox_14.setModel(new DefaultComboBoxModel(new String[] {"NEGATIVO PARA LESI\u00D3N INTRAEPITELIAL O MALIGNIDAD", "OTROS HALLAZGOS", "ANOMAL\u00CDAS DE LAS C\u00C9LULAS EPITELIALES", "OTRAS NEOPLASIAS MALIGNAS"}));
		comboBox_14.setSelectedIndex(0);
		
		comboBox_15 = new JComboBox();
		comboBox_15.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_15.setModel(new DefaultComboBoxModel(new String[] {"MICROORGANISMOS", "OTROS HALLAZGOS NO NEOPL\u00C1SICOS",""}));
		comboBox_15.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_16.removeAllItems();
				
				if(comboBox_14.getSelectedIndex() == 0 &&comboBox_15.getSelectedIndex() == 0 ){
					comboBox_16.addItem("Trichomonas vaginalis");
					comboBox_16.addItem("Elementos micóticos de características morfológicas compatibles con Candida");
					comboBox_16.addItem("Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA");
					comboBox_16.addItem("Bacterias de características morfológicas compatibles con Actinomyces");
					comboBox_16.addItem("Cambios celulares compatibles con HERPES SIMPLE");
				}if(comboBox_14.getSelectedIndex() == 0 && comboBox_15.getSelectedIndex() == 1){
					comboBox_16.addItem("Cambios celulares reactivos asosiados a:");
					comboBox_16.addItem("Células glandulares poshisterectomía");
					comboBox_16.addItem("Atrofia");
					
				}if(comboBox_14.getSelectedIndex() == 1 && comboBox_15.getSelectedIndex() == 0){
					comboBox_16.addItem("NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL");
				}if(comboBox_14.getSelectedIndex() == 2  && comboBox_15.getSelectedIndex() == 0){
					comboBox_16.addItem("CÉLULAS ESCAMOSAS ATÍPICAS");
					comboBox_16.addItem("LESIÓN ESCAMOSA INTRAEPITELIAL DE BAJO GRADO (LSIL)");
					comboBox_16.addItem("LESIÓN ESCAMOSA INTRAEPITELIAL DE ALTO GRADO (HSIL)");
					comboBox_16.addItem("CARCINOMA ESCAMOSO");
				}if(comboBox_14.getSelectedIndex() == 2  && comboBox_15.getSelectedIndex() == 1){
					comboBox_16.addItem("ATÍPICAS");
					comboBox_16.addItem("ATÍPICAS SUGESTIVAS A NEOPLASIA");
					comboBox_16.addItem("ADENOCARCINOMA ENDOCERVICAL (in situ)");
					comboBox_16.addItem("ADENOCARCINOMA");
				}
			}
		});
		
		comboBox_16 = new JComboBox();
		comboBox_16.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_16.addItem("Trichomonas vaginalis");
		comboBox_16.addItem("Elementos micóticos de características morfológicas compatibles con Candida");
		comboBox_16.addItem("Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA");
		comboBox_16.addItem("Bacterias de características morfológicas compatibles con Actinomyces");
		comboBox_16.addItem("Cambios celulares compatibles con HERPES SIMPLE");
		
			comboBox_16.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					comboBox_17.removeAllItems();
					
					if(comboBox_14.getSelectedIndex() == 0 && comboBox_15.getSelectedIndex() == 1 && comboBox_16.getSelectedIndex() == 0 ){
						comboBox_17.addItem("Inflamación");
						comboBox_17.addItem("Radiación");
						comboBox_17.addItem("Dispositivo intrauterino (DIU)");
					}else if(comboBox_14.getSelectedIndex() == 2 && comboBox_15.getSelectedIndex() == 0 && comboBox_16.getSelectedIndex() == 0 ){
						comboBox_17.addItem("de significado indeterminado (ASC-US)");
						comboBox_17.addItem("no se puede descartar lesion escamosa intraepitelial de alto grado (ASC-H)");
					}else if(comboBox_14.getSelectedIndex() == 2 && comboBox_15.getSelectedIndex() == 0 && comboBox_16.getSelectedIndex() == 2 ){
						comboBox_17.addItem("con hallazgos sospechosos de invación");
					}else if(comboBox_14.getSelectedIndex() == 2 && comboBox_15.getSelectedIndex() == 1 && comboBox_16.getSelectedIndex() == 0 ){
						comboBox_17.addItem("Células endocervicales");
						comboBox_17.addItem("Células endometriales");
						comboBox_17.addItem("Células glandulares");
					}else if(comboBox_14.getSelectedIndex() == 2 && comboBox_15.getSelectedIndex() == 1 && comboBox_16.getSelectedIndex() == 1 ){
						comboBox_17.addItem("Células endocervicales");
						comboBox_17.addItem("Células glandulares");
					}else if(comboBox_14.getSelectedIndex() == 2 && comboBox_15.getSelectedIndex() == 1 && comboBox_16.getSelectedIndex() == 3 ){
						comboBox_17.addItem("Endocervical");
						comboBox_17.addItem("Endometrial");
						comboBox_17.addItem("Extrauterino");
						comboBox_17.addItem("Sin Especificar");
					}
				}
			});
			
			
			comboBox_17.addItem("Inflamación");
			comboBox_17.addItem("Radiación");
			comboBox_17.addItem("Dispositivo intrauterino (DIU)");
			
				textArea_1 = new JTextArea();
				textArea_1.setLineWrap(true);
				textArea_1.setColumns(30);
				textArea_1.setRows(2);
				
				JLabel lblNewLabel_39 = new JLabel("Observaciones");
				lblNewLabel_39.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GroupLayout gl_panel_3 = new GroupLayout(panel_3);
				gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_22)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblCalidadDeLa)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 611, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_39)
										.addComponent(lblNewLabel_23))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
										.addComponent(comboBox_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap())
				);
				gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_22)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCalidadDeLa)
								.addComponent(comboBox_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_23)
								.addComponent(comboBox_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_39)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(25, Short.MAX_VALUE))
				);
				panel_3.setLayout(gl_panel_3);
				
				JLabel lblNewLabel_1 = new JLabel("Informacion Ginecol\u00F3gica");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JLabel lblFur = new JLabel("F.U.R.");
				lblFur.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				comboBox = new JComboBox();
				comboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboBox.getSelectedIndex() == 0){
							textField.setEnabled(false);
						}else {
							textField.setEnabled(true);
						}
					}
				});
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				
				textField = new JTextField();
				textField.setEnabled(false);
				textField.setColumns(6);
				
				JLabel lblNewLabel_2 = new JLabel("Embarazos");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_1 = new JTextField();
				textField_1.setColumns(4);
				
				JLabel lblCesreas = new JLabel("Ces\u00E1reas");
				lblCesreas.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_3 = new JTextField();
				textField_3.setColumns(4);
				
				JLabel lblNewLabel_16 = new JLabel("Fecha ultimo embarazo");
				lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_5 = new JTextField();
				textField_5.setToolTipText("00/00/0000");
				textField_5.setColumns(6);
				
				JLabel lblPartos = new JLabel("Partos");
				lblPartos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblAbortos = new JLabel("Abortos");
				lblAbortos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_6 = new JTextField();
				textField_6.setColumns(4);
				
				textField_16 = new JTextField();
				textField_16.setColumns(4);
				
				JLabel lblNewLabel_17 = new JLabel("Citolog\u00EDa Anterior");
				lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				comboBox_6 = new JComboBox();
				comboBox_6.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboBox_6.getSelectedIndex()==0){
							textField_17.setText("");
							textField_17.setEnabled(false);
						}else{
							textField_17.setEnabled(true);
						}
					}
				});
				comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
				
				textField_17 = new JTextField();
				textField_17.setEnabled(false);
				textField_17.setColumns(10);
				
				JLabel lblNewLabel_18 = new JLabel("Biopsia Anterior");
				lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_18 = new JTextField();
				textField_18.setEnabled(false);
				textField_18.setColumns(10);
				
				JLabel lblNewLabel_19 = new JLabel("Muestra de");
				lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblNewLabel_20 = new JLabel("Sitio de lesi\u00F3n");
				lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblNewLabel_21 = new JLabel("Medico solicitante");
				lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				
				comboBox_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
				
				comboBox_7 = new JComboBox();
				comboBox_7.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboBox_7.getSelectedIndex()==0){
							textField_18.setText("");
							textField_18.setEnabled(false);
						}else{
							textField_18.setEnabled(true);
						}
					}
				});
				comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				comboBox_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
				
				textField_27 = new JTextField();
				textField_27.setColumns(10);
				
				textField_28 = new JTextField();
				textField_28.setColumns(10);
				GroupLayout gl_info_ginecologica = new GroupLayout(info_ginecologica);
				gl_info_ginecologica.setHorizontalGroup(
					gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_info_ginecologica.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_1)
									.addGroup(gl_info_ginecologica.createSequentialGroup()
										.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_info_ginecologica.createSequentialGroup()
												.addComponent(lblNewLabel_16)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_5))
											.addGroup(gl_info_ginecologica.createSequentialGroup()
												.addComponent(lblNewLabel_2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblCesreas, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblPartos, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_info_ginecologica.createSequentialGroup()
												.addComponent(lblAbortos, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_info_ginecologica.createSequentialGroup()
												.addComponent(lblFur, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
										.addGap(46))
									.addGroup(gl_info_ginecologica.createSequentialGroup()
										.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_17)
											.addComponent(lblNewLabel_18))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.TRAILING)
											.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_17, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
											.addComponent(textField_18, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))))
								.addGroup(gl_info_ginecologica.createSequentialGroup()
									.addComponent(lblNewLabel_19)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_20)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_info_ginecologica.createSequentialGroup()
									.addComponent(lblNewLabel_21)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(102, Short.MAX_VALUE))
				);
				gl_info_ginecologica.setVerticalGroup(
					gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_info_ginecologica.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCesreas, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPartos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAbortos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_16)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFur, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_17)
								.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_18)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_19)
								.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_20)
								.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_21)
								.addComponent(comboBox_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				info_ginecologica.setLayout(gl_info_ginecologica);
				
				JLabel lblPa = new JLabel("Paciente");
				lblPa.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JLabel lblNewLabel_10 = new JLabel("Cedula");
				lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_10 = new JTextField();
				textField_10.setToolTipText("V-0000000");
				textField_10.setColumns(10);
				
				comboBox_5 = new JComboBox();
				comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_5.setToolTipText("Nacionalidad\r\nV: Venezolano\r\nE:Extranjero\r\nN:Nacionalizado\r\nM:Menor");
				comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"V", "E", "N", "M"}));
				comboBox_5.setSelectedIndex(0);
				
				JButton btnNewButton_3 = new JButton("Buscar");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						limpiarNuevoEstudio();
						btnNewButton_4.setEnabled(true);
						limpiarFormularioPasiente();
						
						paciente_.cedula = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString()+textField_10.getText();
						
						if(db.buscarPasientePorCedula(paciente_)==1){
							textField_11.setText(paciente_.nombres);
							textField_12.setText(paciente_.Apellidos);
							textField_13.setText(""+paciente_.edad);
							textField_14.setText(paciente_.telefono);
							textField_15.setText(paciente_.direccion);
							textField_19.setText(paciente_.procedencia);
						}
					}
				});
				
				JLabel lblNewLabel_11 = new JLabel("Nombres");
				lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_11 = new JTextField();
				textField_11.setColumns(20);
				
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_12 = new JTextField();
				textField_12.setColumns(20);
				
				JLabel lblNewLabel_12 = new JLabel("Edad");
				lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_13 = new JTextField();
				textField_13.setText("00");
				textField_13.setToolTipText("");
				textField_13.setColumns(2);
				
				JLabel lblNewLabel_13 = new JLabel("Telefono");
				lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_14 = new JTextField();
				textField_14.setToolTipText("0000-0000000");
				textField_14.setColumns(10);
				
				JLabel lblNewLabel_14 = new JLabel("Direccion");
				lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_15 = new JTextField();
				textField_15.setColumns(10);
				
				JLabel lblNewLabel_15 = new JLabel("Motivo de consulta");
				lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JLabel lblDiagnsticoClnico = new JLabel("Diagn\u00F3stico cl\u00EDnico");
				lblDiagnsticoClnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textArea_3 = new JTextArea();
				textArea_3.setColumns(40);
				textArea_3.setRows(2);
				
				textArea_4 = new JTextArea();
				textArea_4.setColumns(40);
				textArea_4.setRows(2);
				
				JLabel lblClinica = new JLabel("Procedencia");
				lblClinica.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_19 = new JTextField();
				textField_19.setColumns(10);
				
				textField_29 = new JTextField();
				textField_29.setText("2015-01-01");
				textField_29.setToolTipText("0000-00-00");
				textField_29.setColumns(6);
				
				JLabel lblFechaDeLa = new JLabel("Fecha de la Muestra");
				lblFechaDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				JComboBox comboBox_25 = new JComboBox();
				comboBox_25.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						String tmp[];
						tmp = textField_29.getText().split("-");
						textField_29.setText(""+comboBox_25.getItemAt(comboBox_25.getSelectedIndex())+"-"+tmp[1]+"-"+tmp[2]);
					}
				});
				comboBox_25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				comboBox_25.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_25.setToolTipText("A\u00F1o");
				comboBox_25.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
				
				JComboBox comboBox_26 = new JComboBox();
				comboBox_26.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						String tmp[];
						tmp = textField_29.getText().split("-");
						textField_29.setText(""+tmp[0]+"-"+comboBox_26.getItemAt(comboBox_26.getSelectedIndex())+"-"+tmp[2]);
					}
				});
				comboBox_26.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_26.setToolTipText("Mes");
				comboBox_26.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
				
				JComboBox comboBox_27 = new JComboBox();
				comboBox_27.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						String tmp[];
						tmp = textField_29.getText().split("-");
						textField_29.setText(""+tmp[0]+"-"+tmp[1]+"-"+comboBox_27.getItemAt(comboBox_27.getSelectedIndex()));
					}
				});
				comboBox_27.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_27.setToolTipText("Dia");
				comboBox_27.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				GroupLayout gl_usuario = new GroupLayout(usuario);
				gl_usuario.setHorizontalGroup(
					gl_usuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_usuario.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_usuario.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPa)
								.addGroup(gl_usuario.createSequentialGroup()
									.addComponent(lblNewLabel_14)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_15))
								.addGroup(gl_usuario.createSequentialGroup()
									.addComponent(lblNewLabel_15)
									.addGap(18)
									.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_usuario.createSequentialGroup()
									.addGroup(gl_usuario.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_usuario.createSequentialGroup()
											.addComponent(lblNewLabel_10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnNewButton_3)
											.addGap(18)
											.addComponent(lblClinica)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_19))
										.addGroup(gl_usuario.createSequentialGroup()
											.addComponent(lblNewLabel_12)
											.addGap(29)
											.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(63)
											.addComponent(lblNewLabel_13)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_14))
										.addGroup(gl_usuario.createSequentialGroup()
											.addComponent(lblNewLabel_11)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblApellidos)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_usuario.createSequentialGroup()
									.addComponent(lblFechaDeLa, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_usuario.createSequentialGroup()
									.addComponent(lblDiagnsticoClnico, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(161, Short.MAX_VALUE))
				);
				gl_usuario.setVerticalGroup(
					gl_usuario.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_usuario.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_10)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3)
								.addComponent(lblClinica)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_11)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellidos)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_12)
								.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_13)
									.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_14)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_15)
								.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDiagnsticoClnico, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_usuario.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaDeLa, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(16, Short.MAX_VALUE))
				);
				usuario.setLayout(gl_usuario);
				
				JLabel lblNewLabel_3 = new JLabel("Tratamiento Previo");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
				
				JLabel lblNewLabel_4 = new JLabel("Irradiacion");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				comboBox_1 = new JComboBox();
				comboBox_1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(comboBox_1.getSelectedIndex()==0){
							textField_2.setText("");
							textField_2.setEnabled(false);
						}else{
							textField_2.setEnabled(true);
						}
					}
				});
				comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				
				JLabel lblNewLabel_5 = new JLabel("Quimioterapia");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				comboBox_2 = new JComboBox();
				comboBox_2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(comboBox_2.getSelectedIndex()==0){
							textField_4.setText("");
							textField_4.setEnabled(false);
						}else{
							textField_4.setEnabled(true);
						}
					}
				});
				comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				
				textField_4 = new JTextField();
				textField_4.setEnabled(false);
				textField_4.setColumns(14);
				
				JLabel lblNewLabel_6 = new JLabel("Anticonceptivos Orales");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				
				JLabel lblNewLabel_7 = new JLabel("Quirurgico");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_8 = new JTextField();
				textField_8.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setEnabled(false);
				textField_2.setColumns(14);
				
				JLabel lblNewLabel_8 = new JLabel("Hormonas");
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				textField_9 = new JTextField();
				textField_9.setEnabled(false);
				textField_9.setColumns(14);
				
				JLabel lblNewLabel_9 = new JLabel("D.I.U");
				lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				comboBox_3 = new JComboBox();
				comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				
				comboBox_4 = new JComboBox();
				comboBox_4.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(comboBox_4.getSelectedIndex()==0){
							textField_9.setText("");
							textField_9.setEnabled(false);
						}else{
							textField_9.setEnabled(true);
						}
					}
				});
				comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
				comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
				GroupLayout gl_tratamiento_previo = new GroupLayout(tratamiento_previo);
				gl_tratamiento_previo.setHorizontalGroup(
					gl_tratamiento_previo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tratamiento_previo.createSequentialGroup()
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_tratamiento_previo.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_3))
								.addGroup(gl_tratamiento_previo.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_tratamiento_previo.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_tratamiento_previo.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_7)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_9)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_tratamiento_previo.createSequentialGroup()
											.addComponent(lblNewLabel_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_8, 432, 432, 432))))
								.addGroup(gl_tratamiento_previo.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_4))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_tratamiento_previo.createSequentialGroup()
											.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
										.addGroup(gl_tratamiento_previo.createSequentialGroup()
											.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)))))
							.addGap(58))
				);
				gl_tratamiento_previo.setVerticalGroup(
					gl_tratamiento_previo.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_tratamiento_previo.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel_3)
							.addGap(13)
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tratamiento_previo.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(65))
				);
				tratamiento_previo.setLayout(gl_tratamiento_previo);
				panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		central.add(panel_2, "name_8159840041347");
		
		JPanel panel_6 = new JPanel();
		
		JPanel panel_7 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 1182, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 965, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JButton btnNewButton_6 = new JButton("Ver");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Debe seleccionar un estudio");
				}else if(table.getSelectedRow()>estudio_v.size()){
						JOptionPane.showMessageDialog(null, "Debe seleccionar un estudio valido");
				}else{
					if(usu_acceso.rol != 2)
						btnNewButton_4.setEnabled(false);
					CardLayout cl = (CardLayout)central.getLayout();
					cl.show(central, "name_722126808976");
					panel.setVisible(true);
					actualizarDatosMedico();
					
					estudio = estudio_v.elementAt((table.getSelectedRow()-1));
					
					textArea_3.setText(estudio.motivo_consulta );
					textArea_4.setText(estudio.diagnostico);
					textField_1.setText(""+estudio.embarazos);
					textField_3.setText(""+estudio.cesareas);
					textField_6.setText(estudio.partos+"");
					textField_16.setText(""+estudio.abortos);
					textField_5.setText(estudio.f_ultimo_embarazo);
					comboBox.setSelectedIndex(estudio.FUR);
					textField.setText(estudio.f_FUR);
					comboBox_6.setSelectedIndex(estudio.citologia );
					textField_17.setText(estudio.f_citologia);
					comboBox_7.setSelectedIndex(estudio.biopsia);
					textField_18.setText(estudio.f_biopsia);
					textField_27.setText(estudio.muestra_de);
					textField_28.setText(estudio.sitio_lesion);
					actualizarDatosMedico();
					comboBox_10.setSelectedIndex((estudio.id_medico-1));
					
					comboBox_1.setSelectedIndex(estudio.irradiacion);
					textField_2.setText(estudio.f_irradiacion);
					comboBox_2.setSelectedIndex(estudio.quimio);
					textField_4.setText(estudio.f_quimio);
					textField_8.setText(estudio.quirurgico);
					textField_7.setText(estudio.hormonas);
					comboBox_3.setSelectedIndex(estudio.diu );
					comboBox_4.setSelectedIndex(estudio.anticonceptivo);
					textField_9.setText(estudio.d_anticonceptivo);
					
					textArea.setText(estudio.resultado);
					comboBox_11.setSelectedIndex(estudio.info_muestra1);
					comboBox_12.setSelectedIndex(estudio.info_muestra2);
					comboBox_13.setSelectedIndex(estudio.info_muestra3);
					comboBox_14.setSelectedIndex(estudio.clasificacion1);
					comboBox_15.setSelectedIndex(estudio.clasificacion2);
					comboBox_16.setSelectedIndex(estudio.clasificacion3);
					if(comboBox_17.getItemCount()>0)
					comboBox_17.setSelectedIndex(estudio.clasificacion4);
					textArea_1.setText(estudio.clasificacion_detalle);
					estudio.numero_impresiones = 0;
					textField_29.setText(estudio.fecha_muestra);
					//textField_1.setText(estudio.fecha_resultado);
					estudio.estado = "esperando resultado";
					//estudio.cedula_paciente = paciente_.cedula;
					
					// datos paciente
					textField_10.setText(estudio.cedula_paciente.substring(1));
					paciente_.cedula = estudio.cedula_paciente;
					
					if(db.buscarPasientePorCedula(paciente_)==1){
						textField_11.setText(paciente_.nombres);
						textField_12.setText(paciente_.Apellidos);
						textField_13.setText(""+paciente_.edad);
						textField_14.setText(paciente_.telefono);
						textField_15.setText(paciente_.direccion);
						textField_19.setText(paciente_.procedencia);
					}
				}
			}
		});
		
		JButton btnImprimir_1 = new JButton("Imprimir");
		btnImprimir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				if(table.getSelectedRow()!=-1){
					
					if(table.getSelectedRow()>estudio_v.size()){
						JOptionPane.showMessageDialog(null, "Debe seleccionar un estudio valido");
						
					}else{
						estudio = estudio_v.elementAt((table.getSelectedRow()-1));
						paciente_.cedula = textField_20.getText();
						db.buscarPasientePorCedula(paciente_);
						medico_.id_medico = estudio.id_medico;
						db.buscarMedicoPorId(medico_);
						pdf.imprimirEstudioSeleccionado(estudio,db);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debe seleccionar un estudio");
					
				}
				
				
			}
		});
		
		JButton btnImprimirTodo = new JButton("Imprimir Todo");
		btnImprimirTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pdf.imprimirListaDeEstudios(estudio_v,db);
				
			}
		});
		
		lblInformasionConsulta = new JLabel("Buscar Estudios");
		lblInformasionConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(470)
					.addComponent(lblInformasionConsulta)
					.addContainerGap(602, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addContainerGap(905, Short.MAX_VALUE)
							.addComponent(btnNewButton_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimir_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimirTodo)))
					.addGap(24))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(8)
					.addComponent(lblInformasionConsulta)
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimirTodo)
						.addComponent(btnImprimir_1)
						.addComponent(btnNewButton_6))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setForeground(new Color(102, 0, 102));
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nombre", "Medico", "Fecha recibido", "Fecha resultado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(310);
		table.getColumnModel().getColumn(2).setPreferredWidth(229);
		table.getColumnModel().getColumn(3).setPreferredWidth(144);
		table.getColumnModel().getColumn(4).setPreferredWidth(122);
		panel_7.setLayout(gl_panel_7);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_20 = new JTextField();
		textField_20.setToolTipText("V-0000000");
		textField_20.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Buscar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudioCedula(comboBox_9.getItemAt(comboBox_9.getSelectedIndex())+ textField_20.getText(), estudio_v);
				
				actualizarTabla(estudio_v);
				
				lblInformasionConsulta.setText("Se encontraron "+estudio_v.size()+" para el paciente : "+comboBox_9.getItemAt(comboBox_9.getSelectedIndex())+ textField_20.getText());
			}
		});
		
		JButton btnBuscarPendiente = new JButton("Esperando resultado");
		btnBuscarPendiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudiosPendientesPorResultado(estudio_v);
				
				actualizarTabla(estudio_v);
				
				lblInformasionConsulta.setText("Se encontraron "+estudio_v.size()+" estudios esperando resultados");
				
			}
		});
		
		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"V", "E", "N", "M"}));
		comboBox_9.setSelectedIndex(0);
		comboBox_9.setToolTipText("Nacionalidad\r\nV: Venezolano\r\nE:Extranjero\r\nN:Nacionalizado\r\nM:Menor");
		comboBox_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton btnNewButton_9 = new JButton("Terminado sin imprimir");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				estudio_v.clear();
				db.buscarEstudiosPendientesPorImprimir(estudio_v);
				
				actualizarTabla(estudio_v);
				

				lblInformasionConsulta.setText("Se encontraron "+estudio_v.size()+" estudios terminados sin imprimir");
			}
			
		});
		
		JButton btnTerminadosPorDia = new JButton("Terminados por Dia");
		btnTerminadosPorDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudiosPorDia(estudio_v);
				
				actualizarTabla(estudio_v);
				
				lblInformasionConsulta.setText("Se encontraron "+estudio_v.size()+" terminados hoy");
	
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(lblCedula)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscarPendiente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTerminadosPorDia)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_5)
						.addComponent(btnBuscarPendiente)
						.addComponent(lblCedula)
						.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_9)
						.addComponent(btnTerminadosPorDia))
					.addContainerGap())
		);
		panel_6.setLayout(gl_panel_6);
		panel_2.setLayout(gl_panel_2);
		
		JPanel imprimir = new JPanel();
		central.add(imprimir, "name_33870233261272");
		
		JLabel lblImprimir = new JLabel("Imprimir:");
		lblImprimir.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_30 = new JLabel("Informes terminados por dia");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_31 = new JLabel("Informes pendientes:");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_32 = new JLabel("Ultima semana:");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_8 = new JButton("Imprimir Dia");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudiosPorDia(estudio_v);
				actualizarTabla(estudio_v);

				pdf.imprimirListaDeEstudios(estudio_v,db);
			}
		});
		
		JButton btnImprimirPendiente = new JButton("Imprimir Pendiente");
		btnImprimirPendiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudiosPendientesPorImprimir(estudio_v);
				actualizarTabla(estudio_v);

				pdf.imprimirListaDeEstudios(estudio_v,db);
			}
		});
		
		JButton btnImprimirSemana = new JButton("Imprimir Semana");
		btnImprimirSemana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estudio_v.clear();
				db.buscarEstudiosPorSemana(estudio_v);
				actualizarTabla(estudio_v);

				pdf.imprimirListaDeEstudios(estudio_v,db);
			}
		});
		
		JLabel lblSincornizar = new JLabel("Sincronizar:");
		lblSincornizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblExportarDatosAlmacenados = new JLabel("Exportar datos almacenados");
		lblExportarDatosAlmacenados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblImportarDatos = new JLabel("Importar datos.");
		lblImportarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(""));
				int result = fileChooser.showSaveDialog(panel_4);
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    
				}*/
				
				sincronizaDatos sd = new sincronizaDatos();
				sd.exportar(db);
				
			}
		});
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(panel_4);
				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    sincronizaDatos sd = new sincronizaDatos();
					sd.importar(db, selectedFile);
				}
			}
		});
		GroupLayout gl_imprimir = new GroupLayout(imprimir);
		gl_imprimir.setHorizontalGroup(
			gl_imprimir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_imprimir.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImprimir)
						.addGroup(gl_imprimir.createSequentialGroup()
							.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_imprimir.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_31)
										.addComponent(lblNewLabel_32)
										.addComponent(lblNewLabel_30)))
								.addComponent(lblSincornizar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_imprimir.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
										.addComponent(lblImportarDatos, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblExportarDatosAlmacenados, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnImprimirPendiente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImprimirSemana, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnExportar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImportar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(786, Short.MAX_VALUE))
		);
		gl_imprimir.setVerticalGroup(
			gl_imprimir.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_imprimir.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImprimir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_imprimir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_30)
						.addComponent(btnNewButton_8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_imprimir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_31)
						.addComponent(btnImprimirPendiente))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_imprimir.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_32)
						.addComponent(btnImprimirSemana))
					.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_imprimir.createSequentialGroup()
							.addGap(18)
							.addComponent(lblSincornizar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblExportarDatosAlmacenados, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblImportarDatos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_imprimir.createSequentialGroup()
							.addGap(39)
							.addComponent(btnExportar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnImportar)))
					.addContainerGap(394, Short.MAX_VALUE))
		);
		imprimir.setLayout(gl_imprimir);
		
		JPanel Estadisticas = new JPanel();
		central.add(Estadisticas, "name_38544120539856");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_Estadisticas = new GroupLayout(Estadisticas);
		gl_Estadisticas.setHorizontalGroup(
			gl_Estadisticas.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Estadisticas.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Estadisticas.setVerticalGroup(
			gl_Estadisticas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Estadisticas.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(363, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_35 = new JLabel("Estadisticas");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_37 = new JLabel("Medico");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//comboBox_21.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez"}));
		
		JLabel lblEdadPasiente = new JLabel("Edad Paciente");
		lblEdadPasiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_22.setModel(new DefaultComboBoxModel(new String[] {"Todas", "0-18", "19-29", "30-39", "35-48", "40-48", "Mas de 48"}));
		
		JLabel lblLesion = new JLabel("Lesion");
		lblLesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPeriodo = new JLabel("Fecha de estudio");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_24 = new JComboBox();
		comboBox_24.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_24.setToolTipText("Busca todos los estudios, con fecha de resultado menor o igual al rango seleccionado.");
		comboBox_24.setModel(new DefaultComboBoxModel(new String[] {"30 dias", "90 dias", "180 dias", "365 dias", "Todos los Datos"}));
		
		JButton btnNewButton_10 = new JButton("Consultar");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//db.consultaEstadistica(id_medico, edad_minima, edad_maxima, rango_fecha_dias, categoria1, categoria2, categoria3, categoria4, estudios_consultados, resultado);
				String rif="Todos";
				int edadMinima, edadMaxima = 100;
				int diasConsulta = -1;
				int categoria1,categoria2,categoria3,categoria4;
				
				if(!comboBox_21.getItemAt(comboBox_21.getSelectedIndex()).equals("Todos")){
					String tmp[] =comboBox_21.getItemAt(comboBox_21.getSelectedIndex()).toString().split(" ");
					rif = tmp[1];
				}
				
				if(comboBox_22.getItemAt(comboBox_22.getSelectedIndex()).equals("Todas") ){
					edadMinima = edadMaxima = -1;
				}else if(comboBox_22.getItemAt(comboBox_22.getSelectedIndex()).equals("Mas de 48")){
					edadMinima = 48;
					edadMaxima = 250;
				}else{
					String tmp[] =comboBox_22.getItemAt(comboBox_22.getSelectedIndex()).toString().split("-");
					edadMinima = Integer.parseInt(tmp[0]);
					edadMaxima = Integer.parseInt(tmp[1]);
				}
				
				if(comboBox_24.getSelectedIndex() == 0){ // 1 mes 
					diasConsulta = 30;
				}else if (comboBox_24.getSelectedIndex() == 1){ // 3 meses
					diasConsulta = 90;
				}else if (comboBox_24.getSelectedIndex() == 2){ // 6 meses
					diasConsulta = 180;
				}else if (comboBox_24.getSelectedIndex() == 3){ // 1 año
					diasConsulta = 365;
				}else if (comboBox_24.getSelectedIndex() == 4){ // todo
					diasConsulta = -1;
				}
				
				if(comboBox_28.getSelectedIndex()!=-1 && !comboBox_28.getSelectedItem().toString().isEmpty()){
					categoria1 =comboBox_28.getSelectedIndex();
				}else{
					categoria1 = -1;
				}
				
				
				if(comboBox_29.getSelectedIndex()!=-1 && !comboBox_29.getSelectedItem().toString().isEmpty()){
					categoria2 =comboBox_29.getSelectedIndex();
				}else{
					categoria2 = -1;
				}
				
				if(comboBox_30.getSelectedIndex()!=-1 && !comboBox_30.getSelectedItem().toString().isEmpty()){
					categoria3 =comboBox_30.getSelectedIndex();
				}else{
					categoria3 = -1;
				}
				
				if(comboBox_31.getSelectedIndex()!=-1 && !comboBox_31.getSelectedItem().toString().isEmpty()){
					categoria4 =comboBox_31.getSelectedIndex();
				}else{
					categoria4 = -1;
				}
				
				//totalEstudiosEstadistica = -1;
				//totalResultadoEstadistica =-1;
				
				db.consultaEstadistica(rif, edadMinima, edadMaxima, diasConsulta, categoria1, categoria2, categoria3, categoria4, totalEstudiosEstadistica, totalResultadoEstadistica);
			
				//lblConsulta.setText(""+totalEstudiosEstadistica);
				//lblNewLabel_38.setText(""+totalResultadoEstadistica);
			}
		});
		
		comboBox_28 = new JComboBox();
		//comboBox_28.setSelectedIndex(0);
		comboBox_28.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_28.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				comboBox_29.removeAllItems();
				
				if(comboBox_28.getSelectedIndex() == 0){
					comboBox_29.addItem("MICROORGANISMOS");
					comboBox_29.addItem("OTROS HALLAZGOS NO NEOPLÁSICOS");
					comboBox_29.addItem("");
				}if(comboBox_28.getSelectedIndex() == 1){
					comboBox_29.addItem("CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años) ");
					comboBox_29.addItem("");
				}if(comboBox_28.getSelectedIndex() == 2){
					comboBox_29.addItem("CÉLULAS ESCAMOSAS");
					comboBox_29.addItem("CÉLULAS GLANDULARES");
					comboBox_29.addItem("");
				}if(comboBox_28.getSelectedIndex() == 3){
					comboBox_29.addItem("");
				}
			}
		});
		comboBox_28.setModel(new DefaultComboBoxModel(new String[] {"NEGATIVO PARA LESI\u00D3N INTRAEPITELIAL O MALIGNIDAD", "OTROS HALLAZGOS", "ANOMAL\u00CDAS DE LAS C\u00C9LULAS EPITELIALES", "OTRAS NEOPLASIAS MALIGNAS"}));
		comboBox_28.setSelectedIndex(0);
		
		comboBox_29 = new JComboBox();
		comboBox_29.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_29.setModel(new DefaultComboBoxModel(new String[] {"MICROORGANISMOS", "OTROS HALLAZGOS NO NEOPL\u00C1SICOS",""}));
		comboBox_29.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_30.removeAllItems();
				
				if(comboBox_28.getSelectedIndex() == 0 &&comboBox_29.getSelectedIndex() == 0 ){
					comboBox_30.addItem("Trichomonas vaginalis");
					comboBox_30.addItem("Elementos micóticos de características morfológicas compatibles con Candida");
					comboBox_30.addItem("Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA");
					comboBox_30.addItem("Bacterias de características morfológicas compatibles con Actinomyces");
					comboBox_30.addItem("Cambios celulares compatibles con HERPES SIMPLE");
				}if(comboBox_28.getSelectedIndex() == 0 && comboBox_29.getSelectedIndex() == 1){
					comboBox_30.addItem("Cambios celulares reactivos asosiados a:");
					comboBox_30.addItem("Células glandulares poshisterectomía");
					comboBox_30.addItem("Atrofia");
					
				}if(comboBox_28.getSelectedIndex() == 1 && comboBox_29.getSelectedIndex() == 0){
					comboBox_30.addItem("NEGATIVO PARA LESIÓN ESCAMOSA INTRAEPITELIAL");
				}if(comboBox_28.getSelectedIndex() == 2  && comboBox_29.getSelectedIndex() == 0){
					comboBox_30.addItem("CÉLULAS ESCAMOSAS ATÍPICAS");
					comboBox_30.addItem("LESIÓN ESCAMOSA INTRAEPITELIAL DE BAJO GRADO (LSIL)");
					comboBox_30.addItem("LESIÓN ESCAMOSA INTRAEPITELIAL DE ALTO GRADO (HSIL)");
					comboBox_30.addItem("CARCINOMA ESCAMOSO");
				}if(comboBox_28.getSelectedIndex() == 2  && comboBox_29.getSelectedIndex() == 1){
					comboBox_30.addItem("ATÍPICAS");
					comboBox_30.addItem("ATÍPICAS SUGESTIVAS A NEOPLASIA");
					comboBox_30.addItem("ADENOCARCINOMA ENDOCERVICAL (in situ)");
					comboBox_30.addItem("ADENOCARCINOMA");
				}
			}
		});
		
		comboBox_30 = new JComboBox();
		comboBox_30.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_30.addItem("Trichomonas vaginalis");
		comboBox_30.addItem("Elementos micóticos de características morfológicas compatibles con Candida");
		comboBox_30.addItem("Cambios de la flora vaginal sugerentes de VAGINOSIS BACTERIANA");
		comboBox_30.addItem("Bacterias de características morfológicas compatibles con Actinomyces");
		
		comboBox_30.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					comboBox_31.removeAllItems();
					
					if(comboBox_28.getSelectedIndex() == 0 && comboBox_29.getSelectedIndex() == 1 && comboBox_30.getSelectedIndex() == 0 ){
						comboBox_31.addItem("Inflamación");
						comboBox_31.addItem("Radiación");
						comboBox_31.addItem("Dispositivo intrauterino (DIU)");
					}else if(comboBox_28.getSelectedIndex() == 2 && comboBox_29.getSelectedIndex() == 0 && comboBox_30.getSelectedIndex() == 0 ){
						comboBox_31.addItem("de significado indeterminado (ASC-US)");
						comboBox_31.addItem("no se puede descartar lesion escamosa intraepitelial de alto grado (ASC-H)");
					}else if(comboBox_28.getSelectedIndex() == 2 && comboBox_29.getSelectedIndex() == 0 && comboBox_30.getSelectedIndex() == 2 ){
						comboBox_31.addItem("con hallazgos sospechosos de invación");
					}else if(comboBox_28.getSelectedIndex() == 2 && comboBox_29.getSelectedIndex() == 1 && comboBox_30.getSelectedIndex() == 0 ){
						comboBox_31.addItem("Células endocervicales");
						comboBox_31.addItem("Células endometriales");
						comboBox_31.addItem("Células glandulares");
					}else if(comboBox_28.getSelectedIndex() == 2 && comboBox_29.getSelectedIndex() == 1 && comboBox_30.getSelectedIndex() == 1 ){
						comboBox_31.addItem("Células endocervicales");
						comboBox_31.addItem("Células glandulares");
					}else if(comboBox_28.getSelectedIndex() == 2 && comboBox_29.getSelectedIndex() == 1 && comboBox_30.getSelectedIndex() == 3 ){
						comboBox_31.addItem("Endocervical");
						comboBox_31.addItem("Endometrial");
						comboBox_31.addItem("Extrauterino");
						comboBox_31.addItem("Sin Especificar");
					}
				}
			});
		
		
		//comboBox_29 = new JComboBox();
		//comboBox_29.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		//comboBox_30 = new JComboBox();
		//comboBox_30.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		comboBox_31 = new JComboBox();
		comboBox_31.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_35)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_10)
								.addGroup(gl_panel_8.createSequentialGroup()
									.addComponent(lblNewLabel_37)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblEdadPasiente, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(comboBox_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPeriodo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_24, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblLesion, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_28, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_29, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_30, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_31, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(385, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_35)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_8.createSequentialGroup()
									.addComponent(comboBox_28, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(comboBox_29, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(comboBox_30, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(comboBox_31, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblLesion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_37)
								.addComponent(comboBox_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdadPasiente, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
							.addComponent(btnNewButton_10)
							.addGap(40))))
		);
		panel_8.setLayout(gl_panel_8);
		Estadisticas.setLayout(gl_Estadisticas);
		
		JPanel Medicos = new JPanel();
		central.add(Medicos, "name_38579282003671");
		
		JLabel lblNewLabel_33 = new JLabel("Registro de medicos");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_34 = new JLabel("Consultar o Editar Medico");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_22 = new JTextField();
		textField_22.setToolTipText("RIF V-00000000-0");
		textField_22.setColumns(12);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				medico_.rif = comboBox_8.getItemAt(comboBox_8.getSelectedIndex()).toString() + textField_22.getText();
				
				if(db.buscarMedico(medico_,true)==1){
					btnEditar.setEnabled(true);
				}
				
				if(medico_.rif.substring(0, 1) == "J"){
					comboBox_18.setSelectedIndex(0);
				}else if(medico_.rif.substring(0, 1) == "E"){
					comboBox_18.setSelectedIndex(1);
				}else if(medico_.rif.substring(0, 1) == "V"){
					comboBox_18.setSelectedIndex(2);
				}
				
				textField_23.setText(medico_.rif.substring(1));
				textField_24.setText(medico_.nombres) ;
				textField_25.setText(medico_.Apellidos);
				
				
				
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"J", "E", "V"}));
		GroupLayout gl_Medicos = new GroupLayout(Medicos);
		gl_Medicos.setHorizontalGroup(
			gl_Medicos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medicos.createSequentialGroup()
					.addGroup(gl_Medicos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Medicos.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_34)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Medicos.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_33)
								.addGroup(Alignment.LEADING, gl_Medicos.createSequentialGroup()
									.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBuscar))))
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(621, Short.MAX_VALUE))
		);
		gl_Medicos.setVerticalGroup(
			gl_Medicos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Medicos.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_33)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Medicos.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_34)
						.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(345, Short.MAX_VALUE))
		);
		
		JLabel lblDatosMedico = new JLabel("Datos Medico");
		lblDatosMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRif = new JLabel("* RIF");
		lblRif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("* Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidos_1 = new JLabel("* Apellidos");
		lblApellidos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setColumns(20);
		
		textField_25 = new JTextField();
		textField_25.setColumns(20);
		
		comboBox_18 = new JComboBox();
		comboBox_18.setModel(new DefaultComboBoxModel(new String[] {"J", "E", "V"}));
		
		JButton btnGuardar = new JButton("Guardar Nuevo");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int validado =2;
				
				if(textField_23.getText().length() > 3 && textField_23.getText().length() > 2 && textField_23.getText().length() > 2 ){
					validado++;
				}else{
					JOptionPane.showMessageDialog(null, "Debe ingresar mas informacion");
				}
				
				if(validado > 2){
					
					medico_.rif = comboBox_18.getItemAt(comboBox_18.getSelectedIndex()).toString() + textField_23.getText();
					medico_.nombres = textField_24.getText();
					medico_.Apellidos = textField_25.getText();
					
					if(db.registrarMedico(medico_,true)==1){
						medico_.rif = "";
						medico_.nombres = "";
						medico_.Apellidos = "";
						textField_23.setText(medico_.rif);
						textField_24.setText(medico_.nombres) ;
						textField_25.setText(medico_.Apellidos);
						btnEditar.setEnabled(false);
					}
				}
				
				
				
			}
		});
		
		btnEditar = new JButton("Actualizar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int validado =2;
				
				if(textField_23.getText().length() > 3 && textField_23.getText().length() > 2 && textField_23.getText().length() > 2 ){
					validado++;
				}else{
					JOptionPane.showMessageDialog(null, "Debe ingresar mas informacion");
				}
				
				if(validado > 2){
					
					medico_.rif = comboBox_18.getItemAt(comboBox_18.getSelectedIndex()).toString() + textField_23.getText();
					medico_.nombres = textField_24.getText();
					medico_.Apellidos = textField_25.getText();
					
					if(db.editarMedico(medico_)==1){
						medico_.rif = "";
						medico_.nombres = "";
						medico_.Apellidos = "";
						textField_23.setText(medico_.rif);
						textField_24.setText(medico_.nombres) ;
						textField_25.setText(medico_.Apellidos);
						btnEditar.setEnabled(false);
					}
				}
				
			}
		});
		btnEditar.setEnabled(false);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(lblRif, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(76)
									.addComponent(lblDatosMedico))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(4)
									.addComponent(comboBox_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(lblApellidos_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(btnGuardar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(340, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatosMedico)
					.addGap(14)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRif, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnEditar))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		Medicos.setLayout(gl_Medicos);
		
		JPanel Usuarios = new JPanel();
		central.add(Usuarios, "name_38616660277399");
		
		JLabel lblNewLabel_36 = new JLabel("Usuarios");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_Usuarios = new GroupLayout(Usuarios);
		gl_Usuarios.setHorizontalGroup(
			gl_Usuarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Usuarios.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Usuarios.createSequentialGroup()
							.addComponent(lblNewLabel_36)
							.addContainerGap(1189, Short.MAX_VALUE))
						.addGroup(gl_Usuarios.createSequentialGroup()
							.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
							.addGap(733))))
		);
		gl_Usuarios.setVerticalGroup(
			gl_Usuarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuarios.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_36)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(370, Short.MAX_VALUE))
		);
		
		JLabel lblNombre_1 = new JLabel("Cedula:");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_19 = new JComboBox();
		comboBox_19.setModel(new DefaultComboBoxModel(new String[] {"V", "E", "N"}));
		
		t_u_cedula = new JTextField();
		t_u_cedula.setColumns(10);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidos_2 = new JLabel("Apellidos");
		lblApellidos_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		t_u_nombre = new JTextField();
		t_u_nombre.setColumns(10);
		
		t_u_apellido = new JTextField();
		t_u_apellido.setColumns(10);
		
		JLabel lblRol = new JLabel("Acceso");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_20 = new JComboBox();
		comboBox_20.setModel(new DefaultComboBoxModel(new String[] {"Licenciada", "Ayudante", "Administrador"}));
		comboBox_20.setSelectedIndex(1);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRepitaContrasea_1 = new JLabel("Repita Contrase\u00F1a");
		lblRepitaContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField_4 = new JPasswordField();
		passwordField_4.setColumns(14);
		
		passwordField_5 = new JPasswordField();
		passwordField_5.setColumns(14);
		
		btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuario_.cedula = comboBox_19.getItemAt(comboBox_19.getSelectedIndex()) + t_u_cedula.getText();
				db.buscarUsuarioPorCedula(usuario_,true);
				
				t_u_nombre.setText(usuario_.nombres);
				t_u_apellido.setText(usuario_.apellidos);
				comboBox_20.setSelectedItem(usuario_.rol);
				passwordField_4.setText(usuario_.clave);
				passwordField_5.setText(usuario_.clave);
				
			}
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//usuario_.cedula = comboBox_19.getItemAt(comboBox_19.getSelectedIndex()) + t_u_cedula.getText();
				
				usuario_.nombres = t_u_nombre.getText();
				usuario_.apellidos = t_u_apellido.getText();
				usuario_.rol = comboBox_20.getSelectedIndex();
				
				if(!passwordField_4.getText().isEmpty()&&passwordField_4.getText().equals(passwordField_5.getText()) && !t_u_nombre.getText().isEmpty() && !t_u_apellido.getText().isEmpty() && !t_u_cedula.getText().isEmpty()){
					System.out.println("son iguales");
					usuario_.clave = passwordField_4.getText();
					if(db.actualizarUsuario(usuario_)==1){
						t_u_cedula.setText("");;	
						t_u_nombre.setText("");
						t_u_apellido.setText("");
						comboBox_20.setSelectedItem(1);
						passwordField_4.setText("");
						passwordField_5.setText("");
					}
				}else{
					passwordField_4.setText("");
					passwordField_5.setText("");
					
					JOptionPane.showMessageDialog(null, "Debe llenar todos los datos");
				}
			}
		});
		
		btnGuardar_1 = new JButton("Guardar Nuevo");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuario_.cedula = comboBox_19.getItemAt(comboBox_19.getSelectedIndex()) + t_u_cedula.getText();
				usuario_.nombres = t_u_nombre.getText();
				usuario_.apellidos = t_u_apellido.getText();
				usuario_.rol = comboBox_20.getSelectedIndex();
				
				if(!passwordField_4.getText().isEmpty()&&passwordField_4.getText().equals(passwordField_5.getText()) && !t_u_nombre.getText().isEmpty() && !t_u_apellido.getText().isEmpty() && !t_u_cedula.getText().isEmpty()){
					System.out.println("son iguales");
					usuario_.clave = passwordField_4.getText();
					if(db.registrarUsuarioNuevo(usuario_,true)==1){
						t_u_cedula.setText("");;	
						t_u_nombre.setText("");
						t_u_apellido.setText("");
						comboBox_20.setSelectedItem(1);
						passwordField_4.setText("");
						passwordField_5.setText("");
					}
				}else{
					passwordField_4.setText("");
					passwordField_5.setText("");
					
					JOptionPane.showMessageDialog(null, "Debe llenar todos los datos");
				}
				
				
				
			}
		});
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre_1)
						.addComponent(lblRepitaContrasea_1)
						.addComponent(lblNombre_2)
						.addComponent(lblApellidos_2, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(t_u_apellido, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(t_u_nombre, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(36)
							.addComponent(comboBox_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGap(36)
							.addComponent(passwordField_4, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_9.createSequentialGroup()
								.addComponent(comboBox_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(t_u_cedula, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBuscar_1))
							.addGroup(gl_panel_9.createSequentialGroup()
								.addGap(36)
								.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_9.createSequentialGroup()
										.addComponent(btnGuardar_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
									.addComponent(passwordField_5, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(lblNombre_1)
							.addGap(8)
							.addComponent(lblNombre_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblApellidos_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblContrasea_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRepitaContrasea_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(t_u_cedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(t_u_nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(t_u_apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar_1)
						.addComponent(btnActualizar))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		Usuarios.setLayout(gl_Usuarios);
	}
	
	
	public void actualizarDatosMedico(){
		
		//medicos
		Vector<medico> medico_v = new Vector<medico>(10, 10) ;
		int totalMedicos;
		
		totalMedicos = db.listarMedicos(medico_v);
		
		Vector<String> listaMedicos = new Vector<>(2, 1);
		
		for (medico medico_ : medico_v) {
			//System.out.println("medicos encontrado !!"+medico_.rif);
			listaMedicos.add(medico_.id_medico+"- "+medico_.rif+" "+medico_.nombres+" "+medico_.Apellidos);
		}
		
		comboBox_10.setModel(new DefaultComboBoxModel<String>(listaMedicos));
		Vector<String> medicosEstadistica = new Vector<String>(1);
		
		medicosEstadistica.add("Todos");
		for (String string : listaMedicos) {
			medicosEstadistica.add(string);
		}
		
		comboBox_21.setModel(new DefaultComboBoxModel<String>(medicosEstadistica));
		
	}
	
	public void actulizarPasienteConFormulario(){
		paciente_.nombres = textField_11.getText();
		paciente_.Apellidos = textField_12.getText();
		paciente_.edad = Integer.parseInt(textField_13.getText());
		paciente_.telefono = textField_14.getText();
		paciente_.direccion = textField_15.getText();
		paciente_.procedencia = textField_19.getText();
		
	}
	
	public void limpiarFormularioPasiente(){
		paciente_ = new paciente();
		textField_11.setText(paciente_.nombres);
		textField_12.setText(paciente_.Apellidos);
		textField_13.setText(""+paciente_.edad);
		textField_14.setText(paciente_.telefono);
		textField_15.setText(paciente_.direccion);
		textField_19.setText(paciente_.procedencia);
	}
	
	public void actualizarEstudioConFormulario(){

		//estudio.rowid_paciente = Integer.parseInt(textField_1.getText());
		estudio.motivo_consulta = textArea_3.getText();
		estudio.diagnostico = textArea_4.getText();
		estudio.fecha_muestra = textField_29.getText();
		estudio.embarazos = Integer.parseInt(textField_1.getText());
		estudio.cesareas = Integer.parseInt(textField_3.getText());
		estudio.partos = Integer.parseInt(textField_6.getText());
		estudio.abortos = Integer.parseInt(textField_16.getText());
		estudio.f_ultimo_embarazo = textField_5.getText();
		estudio.FUR = comboBox.getSelectedIndex();
		estudio.f_FUR = textField.getText();
		estudio.citologia = comboBox_6.getSelectedIndex();
		estudio.f_citologia = textField_17.getText();
		estudio.biopsia =comboBox_7.getSelectedIndex();
		estudio.f_biopsia = textField_18.getText();
		estudio.muestra_de = textField_27.getText();
		estudio.sitio_lesion = textField_28.getText();
		String tmp = new String(comboBox_10.getItemAt(comboBox_10.getSelectedIndex()).toString());
		String tmp2[] = tmp.split("-");
		estudio.id_medico = Integer.parseInt(tmp2[0]);
		
		estudio.irradiacion =comboBox_1.getSelectedIndex();
		estudio.f_irradiacion = textField_2.getText();
		estudio.quimio = comboBox_2.getSelectedIndex();
		estudio.f_quimio = textField_4.getText();
		estudio.quirurgico = textField_8.getText();
		estudio.hormonas = textField_7.getText();
		estudio.diu = comboBox_3.getSelectedIndex();
		estudio.anticonceptivo =comboBox_4.getSelectedIndex();
		estudio.d_anticonceptivo = textField_9.getText();
		
		estudio.resultado = textArea.getText();
		estudio.info_muestra1 = comboBox_11.getSelectedIndex();
		estudio.info_muestra2 = comboBox_12.getSelectedIndex();
		estudio.info_muestra3 = comboBox_13.getSelectedIndex();
		estudio.clasificacion1 =comboBox_14.getSelectedIndex();
		estudio.clasificacion2 =comboBox_15.getSelectedIndex();
		estudio.clasificacion3 =comboBox_16.getSelectedIndex();
		estudio.clasificacion4 =comboBox_17.getSelectedIndex();
		estudio.clasificacion_detalle = textArea_1.getText();
		//estudio.numero_impresiones = 0;
		estudio.fecha_muestra = textField_29.getText();
		//estudio.fecha_resultado = textField_1.getText();
		
		estudio.cedula_paciente = paciente_.cedula;
	}
	
	public void limpiarNuevoEstudio(){
		estudio = new estudio_citologico();
		
		textArea_3.setText(estudio.motivo_consulta );
		textArea_4.setText(estudio.diagnostico);
		textField_1.setText(""+estudio.embarazos);
		textField_3.setText(""+estudio.cesareas);
		textField_6.setText(estudio.partos+"");
		textField_16.setText(""+estudio.abortos);
		textField_5.setText(estudio.f_ultimo_embarazo);
		estudio.FUR = comboBox.getSelectedIndex();
		textField.setText(estudio.f_FUR);
		estudio.citologia = comboBox_6.getSelectedIndex();
		textField_17.setText(estudio.f_citologia);
		estudio.biopsia =comboBox_7.getSelectedIndex();
		textField_18.setText(estudio.f_biopsia);
		textField_27.setText(estudio.muestra_de);
		textField_28.setText(estudio.sitio_lesion);
		if(comboBox_10.getItemCount()>0)
			comboBox_10.setSelectedIndex(0);
		
		comboBox_1.setSelectedIndex(0);
		textField_2.setText(estudio.f_irradiacion);
		estudio.quimio = comboBox_2.getSelectedIndex();
		textField_4.setText(estudio.f_quimio);
		textField_8.setText(estudio.quirurgico);
		textField_7.setText(estudio.hormonas);
		estudio.diu =comboBox_3.getSelectedIndex();
		comboBox_4.setSelectedIndex(0);
		textField_9.setText(estudio.d_anticonceptivo);
		
		textArea.setText(estudio.resultado);
		comboBox_11.setSelectedIndex(0);
		comboBox_12.setSelectedIndex(0);
		comboBox_13.setSelectedIndex(0);
		comboBox_14.setSelectedIndex(0);
		comboBox_15.setSelectedIndex(0);
		comboBox_16.setSelectedIndex(0);
		if(comboBox_17.getItemCount()>0)
			comboBox_17.setSelectedIndex(0);
		textArea_1.setText(estudio.clasificacion_detalle);
		estudio.numero_impresiones = 0;
		textField_29.setText(estudio.fecha_muestra);
		//textField_1.setText(estudio.fecha_resultado);
		estudio.estado = "esperando resultado";
	}
	
	public void actualizarTabla(Vector<estudio_citologico> estudio_v){
		int i =0;
		
		Object[][] datos = new Object[100][];
		
		actualizarDatosMedico();
		
		for (estudio_citologico estudio : estudio_v) {
			i++;
			
			String fecha[] = estudio.fecha_resultado.split(" ");
			paciente  paciente_= new paciente();
			paciente_.cedula = estudio.cedula_paciente;
			db.buscarPasientePorCedula(paciente_);
			
			//System.out.println("ssss: "+estudio.estado);
			datos[i] = new String[]{""+estudio.rowid,""+estudio.cedula_paciente+ " "+paciente_.Apellidos+" "+paciente_.nombres,""+comboBox_10.getItemAt(estudio.id_medico-1),""+estudio.fecha_muestra,""+fecha[0]};
			
		}
		
		table.clearSelection();
		//table.
		table.setModel(new DefaultTableModel(
				datos,
				new String[] {
					"Codigo", "Paciente", "Medico", "Fecha recibido", "Fecha resultado"
				}
			));
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
	}
}
