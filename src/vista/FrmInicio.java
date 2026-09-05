package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class FrmInicio extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane desktopPane;

    // Declaración de los Submenús
    private JMenuItem mntmHorarios, mntmDoctores, mntmHabitacion;
    private JMenuItem mntmCardiologia, mntmPediatria, mntmTraumatologia;
    private JMenuItem mntmDatosPersonales, mntmAntecedentes, mntmContactoEmergencia;

    // Instancias de los formularios internos (JInternalFrame)
    private FrmPlantillaMedica frmHorarios = new FrmPlantillaMedica("Gestión de Horarios");
    private FrmPlantillaMedica frmDoctores = new FrmPlantillaMedica("Gestión de Doctores");
    private FrmPlantillaMedica frmHabitacion = new FrmPlantillaMedica("Gestión de Habitación");
    
    private FrmPlantillaMedica frmCardiologia = new FrmPlantillaMedica("Especialidad: Cardiología");
    private FrmPlantillaMedica frmPediatria = new FrmPlantillaMedica("Especialidad: Pediatría");
    private FrmPlantillaMedica frmTraumatologia = new FrmPlantillaMedica("Especialidad: Traumatología");
    
    private FrmPlantillaMedica frmDatosPersonales = new FrmPlantillaMedica("Paciente: Datos Personales");
    private FrmPlantillaMedica frmAntecedentes = new FrmPlantillaMedica("Paciente: Antecedentes Médicos");
    private FrmPlantillaMedica frmContacto = new FrmPlantillaMedica("Paciente: Contacto de Emergencia");
    private JTextPane txtpnBienvenidoA;
    private JTextPane txtpnNombre;
    private JTextPane txtpnNombre_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmInicio frame = new FrmInicio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmInicio() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(FrmInicio.class.getResource("/iconos/icono/red-cross-11339_16.png")));
        setTitle("Sistema de gestión de establecimientos médicos");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(SystemColor.textHighlight);
        contentPane.add(desktopPane, BorderLayout.CENTER);

        // Agregar los formularios al DesktopPane de forma oculta inicialmente
        agregarFormulariosAlDesktop();

        // Construcción de Menús
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // --- MENÚ CITA ---
        JMenu mnCita = new JMenu("Cita");
        mnCita.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/booked-calendar-and-black-check-mark-lineal-16259_16.png")));
        menuBar.add(mnCita);
        
        mntmHorarios = new JMenuItem("Horarios");
        mntmHorarios.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/calendar-865_16.png")));
        mntmHorarios.addActionListener(this);
        mnCita.add(mntmHorarios);
        
        mntmDoctores = new JMenuItem("Doctores");
        mntmDoctores.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/doctor-294_16.png")));
        mntmDoctores.addActionListener(this);
        mnCita.add(mntmDoctores);
        
        mntmHabitacion = new JMenuItem("Habitación");
        mntmHabitacion.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/hotel-bed-with-two-pillows-15707_16.png")));
        mntmHabitacion.addActionListener(this);
        mnCita.add(mntmHabitacion);
        
        // --- MENÚ ESPECIALIDAD ---
        JMenu mnEspecialidad = new JMenu("Especialidad");
        mnEspecialidad.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/consultant-man-black-26519_16.png")));
        menuBar.add(mnEspecialidad);
        
        mntmCardiologia = new JMenuItem("Cardiología");
        mntmCardiologia.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/heart-beat-3517_16.png")));
        mntmCardiologia.addActionListener(this);
        mnEspecialidad.add(mntmCardiologia);
        
        mntmPediatria = new JMenuItem("Pediatría");
        mntmPediatria.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/swaddled-baby-boy-black-outline-24981_16.png")));
        mntmPediatria.addActionListener(this);
        mnEspecialidad.add(mntmPediatria);
        
        mntmTraumatologia = new JMenuItem("Traumatología");
        mntmTraumatologia.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/broken-bone-6464_16.png")));
        mntmTraumatologia.addActionListener(this);
        mnEspecialidad.add(mntmTraumatologia);
        
        // --- MENÚ PACIENTE ---
        JMenu mnPaciente = new JMenu("Paciente");
        mnPaciente.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/user-6769_16.png")));
        menuBar.add(mnPaciente);
        
        mntmDatosPersonales = new JMenuItem("Datos Personales");
        mntmDatosPersonales.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/gdpr-personal-security-1737_16.png")));
        mntmDatosPersonales.addActionListener(this);
        mnPaciente.add(mntmDatosPersonales);
        
        mntmAntecedentes = new JMenuItem("Antecedentes Médicos");
        mntmAntecedentes.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/medical-history-healthcare-report-black-outline-26327_16.png")));
        mntmAntecedentes.addActionListener(this);
        mnPaciente.add(mntmAntecedentes);
        
        mntmContactoEmergencia = new JMenuItem("Contacto de Emergencia");
        mntmContactoEmergencia.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/icono/emergency-call-14161_16.png")));
        mntmContactoEmergencia.addActionListener(this);
        mnPaciente.add(mntmContactoEmergencia);
    }

    private void agregarFormulariosAlDesktop() {
        desktopPane.add(frmAntecedentes);
        desktopPane.add(frmContacto);
        desktopPane.add(frmHorarios);
        desktopPane.add(frmDoctores);
        desktopPane.add(frmHabitacion);
        desktopPane.add(frmCardiologia);
        desktopPane.add(frmPediatria);
        desktopPane.add(frmTraumatologia);
        desktopPane.add(frmDatosPersonales);
        
        txtpnBienvenidoA = new JTextPane();
        txtpnBienvenidoA.setFont(new Font("Tahoma", Font.PLAIN, 50));
        txtpnBienvenidoA.setText("Bienvenido al sistema de gestión");
        txtpnBienvenidoA.setForeground(new Color(0, 0, 0));
        txtpnBienvenidoA.setBounds(43, 40, 766, 113);
        desktopPane.add(txtpnBienvenidoA);
        
        txtpnNombre = new JTextPane();
        txtpnNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnNombre.setText("Nombre");
        txtpnNombre.setBounds(27, 205, 100, 20);
        desktopPane.add(txtpnNombre);
        
        txtpnNombre_1 = new JTextPane();
        txtpnNombre_1.setText("Nombre");
        txtpnNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnNombre_1.setBounds(27, 258, 100, 20);
        desktopPane.add(txtpnNombre_1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Control de eventos para mostrar cada formulario interno correspondiente
        if (e.getSource() == mntmHorarios) abrirVentana(frmHorarios);
        else if (e.getSource() == mntmDoctores) abrirVentana(frmDoctores);
        else if (e.getSource() == mntmHabitacion) abrirVentana(frmHabitacion);
        else if (e.getSource() == mntmCardiologia) abrirVentana(frmCardiologia);
        else if (e.getSource() == mntmPediatria) abrirVentana(frmPediatria);
        else if (e.getSource() == mntmTraumatologia) abrirVentana(frmTraumatologia);
        else if (e.getSource() == mntmDatosPersonales) abrirVentana(frmDatosPersonales);
        else if (e.getSource() == mntmAntecedentes) abrirVentana(frmAntecedentes);
        else if (e.getSource() == mntmContactoEmergencia) abrirVentana(frmContacto);
    }

    private void abrirVentana(javax.swing.JInternalFrame ventana) {
        ventana.setVisible(true);
        try {
            ventana.setSelected(true); // Trae la ventana al frente si ya estaba abierta
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
    }


}
