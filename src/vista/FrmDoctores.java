package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FrmDoctores extends JInternalFrame {

    public FrmDoctores() {
        setTitle("Gestión de Doctores");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setSize(650, 500);
        setLocation(60, 60);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cabecera
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(new Color(0, 128, 96));
        JLabel lblTitulo = new JLabel("   MÓDULO DE CITAS - DIRECTORIO DE MÉDICOS", JLabel.LEFT);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        panelHeader.setPreferredSize(new Dimension(0, 40));
        mainPanel.add(panelHeader);
        mainPanel.add(Box.createVerticalStrut(10));

        // Formulario de Doctores
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "DATOS DEL PROFESIONAL", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelDatos.add(new JLabel("Nombres y Apellidos:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        panelDatos.add(new JTextField(25), gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        panelDatos.add(new JLabel("Especialidad:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JComboBox<>(new String[]{"Cardiología", "Pediatría", "Traumatología", "Medicina General"}), gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        panelDatos.add(new JLabel("N° Colegiatura:"), gbc);
        gbc.gridx = 3; 
        panelDatos.add(new JTextField(10), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelDatos.add(new JLabel("Teléfono Contacto:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JTextField(12), gbc);

        mainPanel.add(panelDatos);
        mainPanel.add(Box.createVerticalStrut(10));

        // Perfil o Biografía
        JPanel panelNotas = new JPanel(new BorderLayout());
        panelNotas.setBorder(BorderFactory.createTitledBorder(null, "PERFIL Y EXPERIENCIA", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        panelNotas.add(new JScrollPane(new JTextArea(4, 20)), BorderLayout.CENTER);
        mainPanel.add(panelNotas);

        add(new JScrollPane(mainPanel));
    }
}