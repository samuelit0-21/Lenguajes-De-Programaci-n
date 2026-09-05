package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FrmPlantillaMedica extends JInternalFrame {

    public FrmPlantillaMedica(String tituloVentana) {
        setTitle(tituloVentana);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setSize(700, 550);
        setLocation(60, 40);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cabecera Estilo Médico con tono verde
        JPanel panelHeader = new JPanel(new BorderLayout());
        panelHeader.setBackground(new Color(0, 128, 96));
        JLabel lblTitulo = new JLabel("   ESTABLECIMIENTO MÉDICO - " + tituloVentana.toUpperCase(), JLabel.LEFT);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        panelHeader.add(lblTitulo, BorderLayout.CENTER);
        panelHeader.setPreferredSize(new Dimension(0, 40));
        
        mainPanel.add(panelHeader);
        mainPanel.add(Box.createVerticalStrut(10));

        // Sección de Datos Principales (GridBagLayout para distribución limpia)
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "INFORMACIÓN GENERAL", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelDatos.add(new JLabel("Código / Nombres:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        panelDatos.add(new JTextField(25), gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        panelDatos.add(new JLabel("Detalle 1:"), gbc);
        gbc.gridx = 1;
        panelDatos.add(new JTextField(12), gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        panelDatos.add(new JLabel("Detalle 2:"), gbc);
        gbc.gridx = 3;
        panelDatos.add(new JTextField(12), gbc);

        mainPanel.add(panelDatos);
        mainPanel.add(Box.createVerticalStrut(10));

        // Sección de Observaciones amplias (Similar a las secciones inferiores del formato)
        JPanel panelDetalles = new JPanel(new BorderLayout());
        panelDetalles.setBorder(BorderFactory.createTitledBorder(null, "OBSERVACIONES / DESCRIPCIÓN DETALLADA", 
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, 
                new Font("Arial", Font.BOLD, 12), new Color(0, 128, 96)));
        panelDetalles.add(new JScrollPane(new JTextArea(5, 20)), BorderLayout.CENTER);
        
        mainPanel.add(panelDetalles);

        add(new JScrollPane(mainPanel));
    }
}