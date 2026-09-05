package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FrmHorarios extends JInternalFrame {

    public FrmHorarios() {
        setTitle("Gestión de Horarios de Atención");
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setSize(650, 500);
        setLocation(40, 40);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cabecera
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(new Color(0, 128, 96));
        JLabel lblTitulo = new JLabel("   MÓDULO DE CITAS - CONTROL DE HORARIOS", JLabel.LEFT);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        panelHeader.setPreferredSize(new Dimension(0, 40));
        mainPanel.add(panelHeader);
        mainPanel.add(Box.createVerticalStrut(10));

        // Formulario de Horarios
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "CONFIGURACIÓN DE HORARIO", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelDatos.add(new JLabel("ID Horario:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JTextField(10), gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        panelDatos.add(new JLabel("Días de Atención:"), gbc);
        gbc.gridx = 3; 
        panelDatos.add(new JComboBox<>(new String[]{"Lunes a Viernes", "Lunes a Sábado", "Fines de Semana", "Turno Rotativo"}), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelDatos.add(new JLabel("Hora Inicio:"), gbc);
        gbc.gridx = 1; 
        panelDatos.add(new JTextField(10), gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        panelDatos.add(new JLabel("Hora Fin:"), gbc);
        gbc.gridx = 3; 
        panelDatos.add(new JTextField(10), gbc);

        mainPanel.add(panelDatos);
        mainPanel.add(Box.createVerticalStrut(10));

        // Observaciones / Notas
        JPanel panelNotas = new JPanel(new BorderLayout());
        panelNotas.setBorder(BorderFactory.createTitledBorder(null, "RESTRICCIONES O OBSERVACIONES", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        panelNotas.add(new JScrollPane(new JTextArea(4, 20)), BorderLayout.CENTER);
        mainPanel.add(panelNotas);

        add(new JScrollPane(mainPanel));
    }
}