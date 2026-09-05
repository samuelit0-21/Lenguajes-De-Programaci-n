package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class FrmHabitacion extends JInternalFrame {

    public FrmHabitacion() {
        setTitle("Gestión de Habitaciones");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setSize(650, 500);
        setLocation(80, 80);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cabecera
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(new Color(0, 128, 96));
        JLabel lblTitulo = new JLabel("   MÓDULO DE CITAS - CONTROL DE HABITACIONES", JLabel.LEFT);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        panelHeader.setPreferredSize(new Dimension(0, 40));
        mainPanel.add(panelHeader);
        mainPanel.add(Box.createVerticalStrut(10));

        // Formulario de Habitación
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "INFORMACIÓN DE HABITACIÓN", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelDatos.add(new JLabel("N° de Habitación:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JTextField(10), gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        panelDatos.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 3; 
        panelDatos.add(new JComboBox<>(new String[]{"Individual", "Doble", "Cuidados Intensivos (UCI)", "Pediatría"}), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelDatos.add(new JLabel("Piso / Ala:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JTextField(10), gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        panelDatos.add(new JLabel("Estado:"), gbc);
        gbc.gridx = 3; 
        panelDatos.add(new JComboBox<>(new String[]{"Disponible", "Ocupada", "En Mantenimiento", "Reservada"}), gbc);

        mainPanel.add(panelDatos);
        mainPanel.add(Box.createVerticalStrut(10));

        // Observaciones / Equipamiento
        JPanel panelNotas = new JPanel(new BorderLayout());
        panelNotas.setBorder(BorderFactory.createTitledBorder(null, "EQUIPAMIENTO Y OBSERVACIONES", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        panelNotas.add(new JScrollPane(new JTextArea(4, 20)), BorderLayout.CENTER);
        mainPanel.add(panelNotas);

        add(new JScrollPane(mainPanel));
    }
}