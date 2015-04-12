package danielpernia.citologias.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.CardLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.*;

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
	JDatePickerImpl datePicker;
	JComboBox comboBox,comboBox_1,comboBox_2,comboBox_3,comboBox_4,comboBox_5,comboBox_6,comboBox_7, comboBox_13,comboBox_12,comboBox_10,comboBox_11,comboBox_14,comboBox_15,comboBox_16,comboBox_17,comboBox_18,comboBox_8 ;
	JTextArea textArea,textArea_1,textArea_2,textArea_3,textArea_4;
	private JTextField txtContrasea;
	private JTextField textField_21;
	JPanel panel,p_inicio,central;
	private JTextField textField_20;
	private JTable table;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField txtPepeAlcantara;
	private JTextField txtPerezPerez;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_27;
	private JTextField textField_28;
	private JButton btnEditar;

	medico medico_;
	pasiente pasiente_;
	estudio_citologico estudio;
	Vector<estudio_citologico> estudio_v;
	private JTextField textField_29;
	
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
		
		medico_ = new medico();
		pasiente_ = new pasiente();
		estudio = new estudio_citologico();
		estudio_v = new Vector<estudio_citologico>(3, 3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("Nuevo Estudio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_8159828611565");
				panel.setVisible(true);
				ActualizarDatos();
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
			}
		});
		menuBar.add(btnImprimir);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_38544120539856");
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
			}
		});
		menuBar.add(btnUsuarios);
		
		JLabel lblNewLabel = new JLabel("Bienvenido: Pedro Perez (Administrador)");
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
					.addContainerGap(530, Short.MAX_VALUE))
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
		panel.setLayout(gl_panel);
		
		central = new JPanel();
		contentPane.add(central, BorderLayout.CENTER);
		central.setLayout(new CardLayout(0, 0));
		
		p_inicio = new JPanel();
		central.add(p_inicio, "name_30190169966599");
		
		JLabel lblNewLabel_26 = new JLabel("ESTUDIO CITOLOGICO");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_27 = new JLabel("Licd. Lisbeth Jaimes");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_28 = new JLabel("RIF: V-15881409-5");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 153, 255));
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		GroupLayout gl_p_inicio = new GroupLayout(p_inicio);
		gl_p_inicio.setHorizontalGroup(
			gl_p_inicio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_inicio.createSequentialGroup()
					.addGroup(gl_p_inicio.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p_inicio.createSequentialGroup()
							.addGap(254)
							.addGroup(gl_p_inicio.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_26)
								.addComponent(lblNewLabel_28)
								.addComponent(lblNewLabel_27)))
						.addGroup(gl_p_inicio.createSequentialGroup()
							.addGap(321)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(348, Short.MAX_VALUE))
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
					.addGap(66)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_24 = new JLabel("Usuario");
		
		JLabel lblNewLabel_25 = new JLabel("Contrase\u00F1a");
		
		txtContrasea = new JTextField();
		txtContrasea.setToolTipText("Contrase\u00F1a es sensible a mayusculas y minusculas");
		txtContrasea.setColumns(12);
		
		textField_21 = new JTextField();
		textField_21.setColumns(12);
		
		JButton btnNewButton_2 = new JButton("Entrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_8159828611565");
				panel.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_29 = new JLabel("Acceso al sistema por favor ingrese usuario y contrase\u00F1a");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNewLabel_29)
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(136, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_25)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtContrasea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_24)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(121))
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(169))
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
						.addComponent(lblNewLabel_25)
						.addComponent(txtContrasea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addGap(43))
		);
		panel_4.setLayout(gl_panel_4);
		p_inicio.setLayout(gl_p_inicio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		central.add(panel_1, "name_8159828611565");
		
		JPanel tratamiento_previo = new JPanel();
		
		JPanel usuario = new JPanel();
		
		JPanel info_ginecologica = new JPanel();
		
		JPanel panel_3 = new JPanel();
		
		JButton btnNewButton_4 = new JButton("Guardar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pasiente_.cedula = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString()+textField_10.getText();
				
				if(db.buscarPasientePorCedula(pasiente_)==1){
					//textField_11.setText(pasiente_.nombres);
					//textField_12.setText(pasiente_.Apellidos);
					//textField_13.setText(pasiente_.f_nacimiento);
					//textField_14.setText(pasiente_.telefono);
					//textField_15.setText(pasiente_.direccion);
					//textField_19.setText(pasiente_.procedencia);
				}else{
					pasiente_.nombres = textField_11.getText();
					pasiente_.Apellidos = textField_12.getText();
					pasiente_.f_nacimiento = textField_13.getText();
					pasiente_.telefono = textField_14.getText();
					pasiente_.direccion = textField_15.getText();
					pasiente_.procedencia = textField_19.getText();
					db.registrarPasiente(pasiente_);
					//db.buscarPasientePorCedula(pasiente_); // lo busco otra vez para sacar el rowid
				}
				
				//estudio.rowid_pasiente = Integer.parseInt(textField_1.getText());
				estudio.motivo_consulta = textArea_3.getText();
				estudio.diagnostico = textArea_4.getText();
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
				estudio.numero_impresiones = 0;
				estudio.fecha_muestra = textField_1.getText();
				estudio.fecha_resultado = textField_1.getText();
				estudio.estado = "esperando resultado";
				estudio.cedula_pasiente = pasiente_.cedula;
				
				
				if(db.guardarEstudio(estudio) == 1){
					
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
					estudio.id_medico = Integer.parseInt(tmp2[0]);
					
					estudio.irradiacion =comboBox_1.getSelectedIndex();
					textField_2.setText(estudio.f_irradiacion);
					estudio.quimio = comboBox_2.getSelectedIndex();
					textField_4.setText(estudio.f_quimio);
					textField_8.setText(estudio.quirurgico);
					textField_7.setText(estudio.hormonas);
					estudio.diu =comboBox_3.getSelectedIndex();
					estudio.anticonceptivo =comboBox_4.getSelectedIndex();
					textField_9.setText(estudio.d_anticonceptivo);
					
					textArea.setText(estudio.resultado);
					estudio.info_muestra1 = comboBox_11.getSelectedIndex();
					estudio.info_muestra2 = comboBox_12.getSelectedIndex();
					estudio.info_muestra3 = comboBox_13.getSelectedIndex();
					estudio.clasificacion1 =comboBox_14.getSelectedIndex();
					estudio.clasificacion2 =comboBox_15.getSelectedIndex();
					estudio.clasificacion3 =comboBox_16.getSelectedIndex();
					estudio.clasificacion4 =comboBox_17.getSelectedIndex();
					textArea_1.setText(estudio.clasificacion_detalle);
					estudio.numero_impresiones = 0;
					textField_1.setText(estudio.fecha_muestra);
					textField_1.setText(estudio.fecha_resultado);
					estudio.estado = "esperando resultado";
					estudio.cedula_pasiente = pasiente_.cedula;
					
					// igualo
					
					
				}
				
				
				
				
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(usuario, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
								.addComponent(info_ginecologica, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 630, Short.MAX_VALUE)
								.addComponent(tratamiento_previo, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap(1193, Short.MAX_VALUE)
							.addComponent(btnNewButton_4)))
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
					.addComponent(btnNewButton_4)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_22 = new JLabel("Resultado");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textArea = new JTextArea();
		textArea.setColumns(55);
		textArea.setRows(5);
		
		JLabel lblCalidadDeLa = new JLabel("Calidad de la muestra");
		lblCalidadDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_11 = new JComboBox();
		comboBox_11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox_11.getSelectedIndex() == 0){
					comboBox_12.enable(false);
					comboBox_13.enable(false);
					comboBox_14.enable(true);
					comboBox_15.enable(true);
					comboBox_16.enable(true);
					comboBox_17.enable(true);
					update(getGraphics());
					
				}else{
					comboBox_12.enable(true);
					comboBox_13.enable(true);
					comboBox_14.enable(false);
					comboBox_15.enable(false);
					comboBox_16.enable(false);
					comboBox_17.enable(false);
					update(getGraphics());
					
				}
			}
		});
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Satisfactoria para evaluaci\u00F3n", "Insatisfactoria para evaluaci\u00F3n"}));
		comboBox_11.setSelectedIndex(0);
		
		comboBox_12 = new JComboBox();
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
		comboBox_13.addItem("por falta de datos para el procesamiento");
		comboBox_13.addItem("lamina invalidada por defecto fisico");
		comboBox_13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comboBox_12.enable(false);
		comboBox_13.enable(false);
		
		JLabel lblNewLabel_23 = new JLabel("Clasificacion General");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_14 = new JComboBox();
		comboBox_14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_15.removeAllItems();
				if(comboBox_14.getSelectedIndex() == 0){
					comboBox_15.addItem("MICROORGANISMOS");
					comboBox_15.addItem("OTROS HALLAZGOS NO NEOPLÁSICOS");
				}if(comboBox_14.getSelectedIndex() == 1){
					comboBox_15.addItem("CÉLULAS ENDOMETRIALES  (mujer mayor de 40 años) ");
					
				}if(comboBox_14.getSelectedIndex() == 2){
					comboBox_15.addItem("CÉLULAS ESCAMOSAS");
					comboBox_15.addItem("CÉLULAS GLANDULARES");
				}if(comboBox_14.getSelectedIndex() == 3){
					//tex
				}
			}
		});
		comboBox_14.setModel(new DefaultComboBoxModel(new String[] {"NEGATIVO PARA LESI\u00D3N INTRAEPITELIAL O MALIGNIDAD", "OTROS HALLAZGOS", "ANOMAL\u00CDAS DE LAS C\u00C9LULAS EPITELIALES", "OTRAS NEOPLASIAS MALIGNAS"}));
		comboBox_14.setSelectedIndex(0);
		
		comboBox_15 = new JComboBox();
		comboBox_15.setModel(new DefaultComboBoxModel(new String[] {"MICROORGANISMOS", "OTROS HALLAZGOS NO NEOPL\u00C1SICOS"}));
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
		
		comboBox_17 = new JComboBox();
		comboBox_17.addItem("Inflamación");
		comboBox_17.addItem("Radiación");
		comboBox_17.addItem("Dispositivo intrauterino (DIU)");
	
		textArea_1 = new JTextArea();
		textArea_1.setColumns(60);
		textArea_1.setRows(2);
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
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_23)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Informacion Ginecol\u00F3gica");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblFur = new JLabel("F.U.R.");
		lblFur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		
		textField = new JTextField();
		textField.setColumns(6);
		
		JButton btnNewButton_1 = new JButton("calendario");
		
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
		
		JButton btnClaen = new JButton("claen");
		
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
		
		comboBox_10 = new JComboBox();
		comboBox_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		ActualizarDatos();
		
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
								.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_info_ginecologica.createSequentialGroup()
										.addComponent(lblNewLabel_16)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(btnClaen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_info_ginecologica.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblCesreas, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblPartos, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
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
					.addContainerGap(108, Short.MAX_VALUE))
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
						.addComponent(btnClaen)
						.addComponent(lblFur, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
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
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasiente_.cedula = comboBox_5.getItemAt(comboBox_5.getSelectedIndex()).toString()+textField_10.getText();
				
				if(db.buscarPasientePorCedula(pasiente_)==1){
					textField_11.setText(pasiente_.nombres);
					textField_12.setText(pasiente_.Apellidos);
					textField_13.setText(pasiente_.f_nacimiento);
					textField_14.setText(pasiente_.telefono);
					textField_15.setText(pasiente_.direccion);
					textField_19.setText(pasiente_.procedencia);
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
		
		JLabel lblNewLabel_12 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_13 = new JTextField();
		textField_13.setText("2015-03-01");
		textField_13.setToolTipText("YYYY-MM-DD");
		textField_13.setColumns(6);
		
		JButton btnFecha = new JButton("Fecha");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UtilDateModel model = new UtilDateModel();
				model.setSelected(true);
				//model.setDate(20,04,2014);
				// Need this...
				Properties p = new Properties();
				p.put("text.today", "Today_X");
				p.put("text.month", "Month_X");
				p.put("text.year", "Year_X");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				//datePanel.setBounds(0,0,500,100);
				// Don't know about the formatter, but there it is...
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,null);
				datePicker.setBounds(220,350,120,30);
				 panel_1.add(datePicker);
			
				System.out.println("muestro fecha!!");
			}
		});
		
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
		textField_29.setToolTipText("00/00/0000");
		textField_29.setColumns(6);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la Muestra");
		lblFechaDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnFecha)
									.addGap(21)
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
							.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_usuario.createSequentialGroup()
							.addComponent(lblDiagnsticoClnico, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(145, Short.MAX_VALUE))
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
							.addComponent(btnFecha)
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
						.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
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
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(147)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(349, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", ""},
			},
			new String[] {
				"Codigo", "Nombre", "Medico", "Fecha recibido", "Fecha resultado"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(310);
		table.getColumnModel().getColumn(2).setPreferredWidth(229);
		table.getColumnModel().getColumn(3).setPreferredWidth(144);
		table.getColumnModel().getColumn(4).setPreferredWidth(122);
		
		JButton btnNewButton_6 = new JButton("Ver");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)central.getLayout();
				cl.show(central, "name_8159828611565");
				panel.setVisible(true);
				ActualizarDatos();
				
				
				
				estudio = estudio_v.elementAt((table.getSelectedRow()-1));
				
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
				comboBox_10.setSelectedIndex(0);
				
				estudio.irradiacion =comboBox_1.getSelectedIndex();
				textField_2.setText(estudio.f_irradiacion);
				estudio.quimio = comboBox_2.getSelectedIndex();
				textField_4.setText(estudio.f_quimio);
				textField_8.setText(estudio.quirurgico);
				textField_7.setText(estudio.hormonas);
				estudio.diu =comboBox_3.getSelectedIndex();
				estudio.anticonceptivo =comboBox_4.getSelectedIndex();
				textField_9.setText(estudio.d_anticonceptivo);
				
				textArea.setText(estudio.resultado);
				estudio.info_muestra1 = comboBox_11.getSelectedIndex();
				estudio.info_muestra2 = comboBox_12.getSelectedIndex();
				estudio.info_muestra3 = comboBox_13.getSelectedIndex();
				estudio.clasificacion1 =comboBox_14.getSelectedIndex();
				estudio.clasificacion2 =comboBox_15.getSelectedIndex();
				estudio.clasificacion3 =comboBox_16.getSelectedIndex();
				estudio.clasificacion4 =comboBox_17.getSelectedIndex();
				textArea_1.setText(estudio.clasificacion_detalle);
				estudio.numero_impresiones = 0;
				textField_1.setText(estudio.fecha_muestra);
				textField_1.setText(estudio.fecha_resultado);
				estudio.estado = "esperando resultado";
				//estudio.cedula_pasiente = pasiente_.cedula;
				
				// datos pasiente
				textField_10.setText(textField_20.getText().substring(1));
				pasiente_.cedula = textField_20.getText();
				
				if(db.buscarPasientePorCedula(pasiente_)==1){
					textField_11.setText(pasiente_.nombres);
					textField_12.setText(pasiente_.Apellidos);
					textField_13.setText(pasiente_.f_nacimiento);
					textField_14.setText(pasiente_.telefono);
					textField_15.setText(pasiente_.direccion);
					textField_19.setText(pasiente_.procedencia);
				}
			}
		});
		
		JButton btnImprimir_1 = new JButton("Imprimir");
		btnImprimir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton btnImprimirTodo = new JButton("Imprimir Todo");
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(btnNewButton_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimir_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnImprimirTodo))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(156)))
					.addGap(24))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(34)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimirTodo)
						.addComponent(btnImprimir_1)
						.addComponent(btnNewButton_6))
					.addGap(14))
		);
		panel_7.setLayout(gl_panel_7);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_20 = new JTextField();
		textField_20.setToolTipText("V-0000000");
		textField_20.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Buscar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.buscarEstudioCedula(textField_20.getText(), estudio_v);
				int i =0;
				
				Object[][] datos = new Object[100][];
				
				for (estudio_citologico estudio : estudio_v) {
					i++;
					//System.out.println("ssss: "+estudio.estado);
					datos[i] = new String[]{"000"+i,""+estudio.diagnostico,""+estudio.id_medico,""+estudio.fecha_muestra,""+estudio.fecha_resultado};
					
				}
				
				table.clearSelection();
				//table.
				table.setModel(new DefaultTableModel(
						datos,
						new String[] {
							"Codigo", "Nombre", "Medico", "Fecha recibido", "Fecha resultado"
						}
					));
				table.getColumnModel().getColumn(1).setPreferredWidth(310);
				table.getColumnModel().getColumn(2).setPreferredWidth(229);
				table.getColumnModel().getColumn(3).setPreferredWidth(144);
				table.getColumnModel().getColumn(4).setPreferredWidth(122);
			}
		});
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(lblCedula)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_5)
					.addGap(27))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_5)
						.addComponent(lblCedula))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		panel_2.setLayout(gl_panel_2);
		
		JPanel imprimir = new JPanel();
		central.add(imprimir, "name_33870233261272");
		
		JLabel lblImprimir = new JLabel("Imprimir:");
		lblImprimir.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_30 = new JLabel("Total dia: 14");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_31 = new JLabel("Ultima imprecion : 00/00/0000 - Informes pendientes: 18\r\n");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_32 = new JLabel("Ultima semana: 92");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_8 = new JButton("Imprimir Dia");
		
		JButton btnImprimirPendiente = new JButton("Imprimir Pendiente");
		
		JButton btnImprimirSemana = new JButton("Imprimir Semana");
		
		JLabel lblSincornizar = new JLabel("Sincronizar:");
		lblSincornizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblExportarDatosAlmacenados = new JLabel("Exportar datos almacenados: 1541 (Informes).");
		lblExportarDatosAlmacenados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblImportarDatos = new JLabel("Importar datos.");
		lblImportarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAnalizarYEliminar = new JLabel("Analizar y eliminar informes redundantes.");
		lblAnalizarYEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnExportar = new JButton("Exportar");
		
		JButton btnImportar = new JButton("Importar");
		
		JButton btnAnalizar = new JButton("Analizar");
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
										.addComponent(lblExportarDatosAlmacenados, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAnalizarYEliminar, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(gl_imprimir.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAnalizar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_8)
								.addComponent(btnImprimirSemana)
								.addComponent(btnImprimirPendiente))))
					.addContainerGap(774, Short.MAX_VALUE))
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
							.addComponent(lblImportarDatos, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAnalizarYEliminar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_imprimir.createSequentialGroup()
							.addGap(32)
							.addComponent(btnExportar)
							.addGap(11)
							.addComponent(btnImportar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAnalizar)))
					.addContainerGap(367, Short.MAX_VALUE))
		);
		imprimir.setLayout(gl_imprimir);
		
		JPanel Estadisticas = new JPanel();
		central.add(Estadisticas, "name_38544120539856");
		
		JPanel panel_8 = new JPanel();
		GroupLayout gl_Estadisticas = new GroupLayout(Estadisticas);
		gl_Estadisticas.setHorizontalGroup(
			gl_Estadisticas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Estadisticas.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(553, Short.MAX_VALUE))
		);
		gl_Estadisticas.setVerticalGroup(
			gl_Estadisticas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Estadisticas.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(446, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_35 = new JLabel("Estadisticas");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_37 = new JLabel("Doctores");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez", "Pedro Perez"}));
		
		JLabel lblEdadPasiente = new JLabel("Edad Paciente");
		lblEdadPasiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setModel(new DefaultComboBoxModel(new String[] {"Todas", "0-18", "19-35", "35-48", "Mas de 48"}));
		
		JLabel lblLesion = new JLabel("Lesion");
		lblLesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setModel(new DefaultComboBoxModel(new String[] {"Lesion1", "Lesion2", "Lesion3", "Lesion4", "Lesion5", "Lesion6", "Lesion7"}));
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_24 = new JComboBox();
		comboBox_24.setModel(new DefaultComboBoxModel(new String[] {"1 mes", "3 meses", "6 meses", "1 a\u00F1o", "Todo el periodo"}));
		
		JButton btnNewButton_10 = new JButton("New button");
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_8.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_37)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblEdadPasiente, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(comboBox_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblLesion, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_24, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_35)))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(247)
							.addComponent(btnNewButton_10)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_35)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_37)
						.addComponent(comboBox_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdadPasiente, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLesion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(btnNewButton_10)
					.addGap(22))
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
				
				if(db.buscarMedico(medico_)==1){
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
		
		JButton btnGuardar = new JButton("Guardar");
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
					
					if(db.registrarMedico(medico_)==1){
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
		
		btnEditar = new JButton("Editar");
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
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(389, Short.MAX_VALUE))
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
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a");
		lblRepitaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a");
		lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_9 = new JButton("Guardar");
		
		JLabel lblActualizarContrasea = new JLabel("Actualizar Contrase\u00F1a");
		lblActualizarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		passwordField.setColumns(14);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(14);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setColumns(14);
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblRepitaContrasea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblContrasea)
								.addGroup(gl_panel_10.createSequentialGroup()
									.addComponent(lblNuevaContrasea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGap(10)
							.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_9)))
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(192)
							.addComponent(lblActualizarContrasea)))
					.addContainerGap(990, Short.MAX_VALUE))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_10.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblActualizarContrasea)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContrasea)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRepitaContrasea, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevaContrasea, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_9)
					.addContainerGap())
		);
		panel_10.setLayout(gl_panel_10);
		GroupLayout gl_Usuarios = new GroupLayout(Usuarios);
		gl_Usuarios.setHorizontalGroup(
			gl_Usuarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuarios.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Usuarios.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_36)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addComponent(panel_10, 0, 0, Short.MAX_VALUE))
					.addGap(733))
		);
		gl_Usuarios.setVerticalGroup(
			gl_Usuarios.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Usuarios.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_36)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(296, Short.MAX_VALUE))
		);
		
		JLabel lblNombre_1 = new JLabel("Cedula:");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setEnabled(false);
		comboBox_19.setModel(new DefaultComboBoxModel(new String[] {"V", "E", "N"}));
		
		textField_26 = new JTextField();
		textField_26.setText("0000000");
		textField_26.setEnabled(false);
		textField_26.setColumns(10);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblApellidos_2 = new JLabel("Apellidos");
		lblApellidos_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtPepeAlcantara = new JTextField();
		txtPepeAlcantara.setText("Pepe alcantara");
		txtPepeAlcantara.setEnabled(false);
		txtPepeAlcantara.setColumns(10);
		
		txtPerezPerez = new JTextField();
		txtPerezPerez.setEnabled(false);
		txtPerezPerez.setText("Perez Perez");
		txtPerezPerez.setColumns(10);
		
		JLabel lblRol = new JLabel("Acceso");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setEnabled(false);
		comboBox_20.setModel(new DefaultComboBoxModel(new String[] {"Licenciada", "Ayudante", "Administrador"}));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(lblNombre_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNombre_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblApellidos_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPerezPerez, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPepeAlcantara, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_9.createSequentialGroup()
							.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1)
						.addComponent(comboBox_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPepeAlcantara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPerezPerez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRol, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		Usuarios.setLayout(gl_Usuarios);
	}
	
	
	public void ActualizarDatos(){
		
		//medicos
		Vector<medico> medico_v = new Vector<medico>(10, 10) ;
		int totalMedicos;
		
		totalMedicos = db.listarMedicos(medico_v);
		
		Vector<String> listaMedicos = new Vector<>(2, 1);
		
		for (medico medico_ : medico_v) {
			listaMedicos.add(medico_.id_medico+"- "+medico_.rif+" "+medico_.nombres+" "+medico_.Apellidos);
		}
		
		comboBox_10.setModel(new DefaultComboBoxModel<String>(listaMedicos));
		
	}
}
