package danielpernia.citologias.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Color;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class i_principal extends JFrame {

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
	JComboBox comboBox_13,comboBox_12,comboBox_11,comboBox_14,comboBox_15,comboBox_16,comboBox_17;

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
		setBounds(100, 100, 1100,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(5, 5, 5, 5));
		menuBar.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("Nuevo Estudio");
		menuBar.add(btnNewButton);
		
		JButton btnBuscarEstudio = new JButton("Consultar Estudio");
		menuBar.add(btnBuscarEstudio);
		
		JButton btnImprimir = new JButton("Imprimir");
		menuBar.add(btnImprimir);
		
		JButton btnEstadisticas = new JButton("Estadisticas");
		menuBar.add(btnEstadisticas);
		
		JButton btnUsuarios = new JButton("Usuarios");
		menuBar.add(btnUsuarios);
		
		JLabel lblNewLabel = new JLabel("Bienvenido: Usuario");
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
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel central = new JPanel();
		contentPane.add(central, BorderLayout.CENTER);
		central.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		central.add(panel_1, "name_8159828611565");
		
		JPanel tratamiento_previo = new JPanel();
		
		JPanel usuario = new JPanel();
		
		JPanel info_ginecologica = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(usuario, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
						.addComponent(info_ginecologica, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
						.addComponent(tratamiento_previo, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(info_ginecologica, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(tratamiento_previo, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 367, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_22 = new JLabel("Resultado");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(55);
		textArea.setRows(5);
		
		JLabel lblCalidadDeLa = new JLabel("Calidad de la muestra");
		lblCalidadDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox_11 = new JComboBox();
		comboBox_11.setModel(new DefaultComboBoxModel(new String[] {"Satisfactoria para evaluaci\u00F3n", "Insatisfactoria para evaluaci\u00F3n"}));
		
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
		
		comboBox_15 = new JComboBox();
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
		
		comboBox_17 = new JComboBox();
		
		JTextArea textArea_1 = new JTextArea();
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
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
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Biopsia Anterior");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Muestra de");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"Falta descripccion", "Falta descripccion", "Falta descripccion", "Falta descripccion", "Falta descripccion"}));
		
		JLabel lblNewLabel_20 = new JLabel("Sitio de lesi\u00F3n");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"Falta descripcion", "Falta descripcion", "Falta descripcion", "Falta descripcion", "Falta descripcion", ""}));
		
		JLabel lblNewLabel_21 = new JLabel("Medico solicitante");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"Pedro peres alcantara V-0000000-0", "Pedro peres alcantara V-0000000-0", "Pedro peres alcantara V-0000000-0", "Pedro peres alcantara V-0000000-0", "Pedro peres alcantara V-0000000-0", "nuevo"}));
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBox_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
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
									.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_17))))
						.addGroup(gl_info_ginecologica.createSequentialGroup()
							.addComponent(lblNewLabel_19)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_20)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_info_ginecologica.createSequentialGroup()
							.addComponent(lblNewLabel_21)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
						.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_20)
						.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_info_ginecologica.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_21)
						.addComponent(comboBox_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		info_ginecologica.setLayout(gl_info_ginecologica);
		
		JLabel lblPa = new JLabel("Paciente");
		lblPa.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_10 = new JLabel("Cedula");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("V-0000000");
		textField_10.setColumns(10);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_5.setToolTipText("Nacionalidad\r\nV: Venezolano\r\nE:Extranjero\r\nN:Nacionalizado\r\nM:Menor");
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"V", "E", "N", "M"}));
		
		JButton btnNewButton_3 = new JButton("Buscar");
		
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
		textField_13.setColumns(6);
		
		JButton btnFecha = new JButton("Fecha");
		
		JLabel lblNewLabel_13 = new JLabel("Telefono");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Direccion");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Motivo de consulta");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDiagnsticoClnico = new JLabel("Diagn\u00F3stico cl\u00EDnico");
		lblDiagnsticoClnico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setColumns(40);
		textArea_3.setRows(2);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setColumns(40);
		textArea_4.setRows(2);
		
		JLabel lblClinica = new JLabel("Clinica");
		lblClinica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
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
							.addComponent(lblDiagnsticoClnico, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_usuario.createSequentialGroup()
							.addGroup(gl_usuario.createParallelGroup(Alignment.TRAILING, false)
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
								.addGroup(Alignment.LEADING, gl_usuario.createSequentialGroup()
									.addComponent(lblNewLabel_12)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnFecha)
									.addGap(21)
									.addComponent(lblNewLabel_13)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_14))
								.addGroup(Alignment.LEADING, gl_usuario.createSequentialGroup()
									.addComponent(lblNewLabel_11)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblApellidos)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(60, Short.MAX_VALUE))
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
					.addContainerGap(14, Short.MAX_VALUE))
		);
		usuario.setLayout(gl_usuario);
		
		JLabel lblNewLabel_3 = new JLabel("Tratamiento Previo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Irradiacion");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		JLabel lblNewLabel_5 = new JLabel("Quimioterapia");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		textField_4 = new JTextField();
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
		textField_2.setColumns(14);
		
		JLabel lblNewLabel_8 = new JLabel("Hormonas");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_9 = new JTextField();
		textField_9.setColumns(14);
		
		JLabel lblNewLabel_9 = new JLabel("D.I.U");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
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
		panel_2.setBackground(new Color(192, 192, 192));
		central.add(panel_2, "name_8159840041347");
	}
}
