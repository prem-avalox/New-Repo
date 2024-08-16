package UserInterface.Forms;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.DMAnimalBL;
import DataAcessComponent.DTO.DMAnimalDTO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import UserInterface.DMStyles;
import UserInterface.CustomizeControl.DMButton;
import UserInterface.CustomizeControl.DMLabel;
import UserInterface.CustomizeControl.DMTextField;

public class DMPanelMenu extends JPanel {
    private String[] mdAlimentos = { "AX", "AXX", "AXY" };
    private DMAnimalBL dmAnimalBL = new DMAnimalBL();
    private DMTextField idField = new DMTextField();
    private DMTextField nameField = new DMTextField();
    private DMButton dmDeleteButton = new DMButton("Eliminar");
    private DMButton dmSaveButton = new DMButton("Guardar");
    private DMButton dmAddAnimal = new DMButton("Crear Animal", DMStyles.COLOR_FONT);
    private DMButton dmFeedAnimal = new DMButton("Alimentar", DMStyles.COLOR_FONT);
    private DMLabel loginDmLabel1 = new DMLabel("Cedula del alumno:");
    private DMLabel loginDmLabel2 = new DMLabel("Nombres del alumno:");
    private DMLabel dmLabelTitle = new DMLabel("Laboratorio de mutacion");
    private JTable dmAnimalTable;
    private DefaultTableModel tableModel;

    public DMPanelMenu() {

        customizeComponent();

        // dmDeleteButton.addActionListener();
        // dmSaveButton.addActionListener();

        // dmAddAnimal.addActionListener();
        // dmFeedAnimal.addActionListener();
    }

    private void customizeComponent() {

        JPanel dmLeftPanel = new JPanel();
        dmLeftPanel.setPreferredSize(new Dimension(20, 480));

        JPanel dmRightPanel = new JPanel();
        dmRightPanel.setPreferredSize(new Dimension(20, 480));

        JPanel dmNorthPanel = new JPanel();
        dmNorthPanel.setLayout(null);
        loginDmLabel1.setBounds(140, 20, 200, 20);
        loginDmLabel1.setHorizontalAlignment(DMStyles.ALIGNMENT_CENTER);
        idField.setBounds(380, 20, 200, 20);
        loginDmLabel2.setBounds(140, 60, 200, 20);
        loginDmLabel2.setHorizontalAlignment(DMStyles.ALIGNMENT_CENTER);
        nameField.setBounds(380, 60, 200, 20);
        dmNorthPanel.add(loginDmLabel1);
        dmNorthPanel.add(idField);
        dmNorthPanel.add(loginDmLabel2);
        dmNorthPanel.add(nameField);
        dmNorthPanel.setPreferredSize(new Dimension(680, 100));
        dmNorthPanel.setBackground(DMStyles.COLOR_FONT_BG);
        dmNorthPanel.setBorder(new LineBorder(DMStyles.COLOR_FONT, 1, true));

        JPanel auxButtonNorthPanel = new JPanel();
        auxButtonNorthPanel.setLayout(null);
        dmLabelTitle.setBounds(80, 10, 200, 50);
        dmAddAnimal.setBounds(480, 20, 140, 30);
        auxButtonNorthPanel.add(dmLabelTitle);
        auxButtonNorthPanel.add(dmAddAnimal);
        auxButtonNorthPanel.setPreferredSize(new Dimension(680, 60));

        JPanel auxButtonSouthPanel = new JPanel();
        auxButtonSouthPanel.setLayout(null);
        auxButtonSouthPanel.setPreferredSize(new Dimension(680, 100));
        JComboBox dmGenoAlimento = new JComboBox(mdAlimentos);
        dmGenoAlimento.setBounds(80, 10, 200, 50);
        dmFeedAnimal.setBounds(480, 20, 140, 30);
        auxButtonSouthPanel.add(dmFeedAnimal);
        auxButtonSouthPanel.add(dmGenoAlimento);

        JPanel dmCenterPanel = new JPanel();
        dmCenterPanel.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // La celda no es editable
            }
        };
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Nombre Cientifico");
        tableModel.addColumn("Sexo");
        tableModel.addColumn("Clasificacion");
        tableModel.addColumn("GenoAlimento");
        dmAnimalTable = new JTable(tableModel);
        dmAnimalTable.setPreferredScrollableViewportSize(new Dimension(480, 200));
        dmAnimalTable.setBackground(DMStyles.COLOR_FONT_BG);
        dmAnimalTable.setSelectionForeground(DMStyles.COLOR_FOREGROUND);

        JScrollPane tableScrollPane = new JScrollPane(dmAnimalTable);
        tableScrollPane.setPreferredSize(new Dimension(480, 200)); // Establecer un tamaño para el JScrollPane

        dmCenterPanel.add(auxButtonNorthPanel, BorderLayout.NORTH);// Agregar titulo y nuevo al panel
        dmCenterPanel.add(auxButtonSouthPanel, BorderLayout.SOUTH);// Agregar comboBox y alimentar al panel
        dmCenterPanel.add(tableScrollPane, BorderLayout.CENTER); // Agregar el JScrollPane al panel

        loadAnimalsFromDatabase();

        JPanel dmSouthPanel = new JPanel();
        dmSouthPanel.setLayout(new GridLayout(1, 2, 60, 0));
        dmSouthPanel.setBorder(new LineBorder(DMStyles.COLOR_FONT, 1, true));
        dmSouthPanel.add(dmSaveButton);
        dmSouthPanel.add(dmDeleteButton);

        setLayout(new BorderLayout());
        add(dmLeftPanel, BorderLayout.WEST);
        add(dmRightPanel, BorderLayout.EAST);
        add(dmNorthPanel, BorderLayout.NORTH);
        add(dmCenterPanel, BorderLayout.CENTER);
        add(dmSouthPanel, BorderLayout.SOUTH);

    }

    private void loadAnimalsFromDatabase() {
        try {
            // Obtener los productos de la base de datos
            List<DMAnimalDTO> dmAnimales = dmAnimalBL.getAll();

            // Agregar los productos a la tabla
            for (DMAnimalDTO animal : dmAnimales) {
                tableModel.addRow(new Object[] {

                        animal.getNombre(),
                        animal.getNombreCientifico(),
                        animal.getIdCatalogoSexo(),
                        animal.getIdCatalogoClasificacion(),
                        animal.getIdCatalogoGenoAlimento(),

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
