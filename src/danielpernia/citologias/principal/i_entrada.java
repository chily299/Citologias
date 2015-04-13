package danielpernia.citologias.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class i_entrada {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private manejador_PDF pdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i_entrada window = new i_entrada();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public i_entrada() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Top = new JPanel();
		Top.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(Top, BorderLayout.NORTH);
		
		JLabel lblGestionDeCitologias = new JLabel("CITOLOG\u00CDAS GINECOL\u00D3GICAS");
		lblGestionDeCitologias.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		JLabel lblNewLabel_1 = new JLabel("Lcda. Lisbeth Jaimes\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("RIF: V-15881409-5");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_Top = new GroupLayout(Top);
		gl_Top.setHorizontalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addGroup(gl_Top.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_Top.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(193))
						.addGroup(Alignment.TRAILING, gl_Top.createSequentialGroup()
							.addComponent(lblGestionDeCitologias, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
							.addGap(149))))
		);
		gl_Top.setVerticalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addGap(21)
					.addComponent(lblGestionDeCitologias)
					.addGap(18)
					.addGroup(gl_Top.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		Top.setLayout(gl_Top);
		
		JPanel Login = new JPanel();
		frame.getContentPane().add(Login, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Login.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		Login.add(lblNewLabel);
		Login.add(textField);
		Login.add(lblContrasea);
		Login.add(textField_1);
		Login.add(btnEntrar);
		
		JPanel Botton = new JPanel();
		frame.getContentPane().add(Botton, BorderLayout.SOUTH);
		
		JLabel lblDanielpgmailcom = new JLabel("danielp299@gmail.com");
		Botton.add(lblDanielpgmailcom);
	}
}
