package com.matiaspellarolo.interfazgrafica;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;


public class InicioSesion extends JPanel
{
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	
	public InicioSesion()
	{
		setLayout(null);
		
		JLabel labelInicioSesion = new JLabel("Inicio de Sesión:");
		labelInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelInicioSesion.setBounds(0, 250, 785, 30);
		labelInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelInicioSesion);
		
		textFieldUsuario = new JTextField("Usuario");
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUsuario.setBounds(267, 300, 250, 30);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField("Contraseña");
		textFieldContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldContraseña.setBounds(267, 350, 250, 30);
		add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Programa.mostrarPanel(Paneles.PRINCIPAL);
			}
		});
		buttonIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonIngresar.setBounds(292, 410, 200, 40);
		add(buttonIngresar);
		
		JButton buttonSalir = new JButton("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonSalir.setBounds(675, 517, 100, 35);
		add(buttonSalir);
		
		
	}
	public void paint (Graphics g)
    {
		super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
        Image imagen = t.getImage ("logo.png");
        int x = (this.getWidth() - imagen.getWidth(null)) / 2;
        g.drawImage (imagen, x, 50, this);
    }
}
