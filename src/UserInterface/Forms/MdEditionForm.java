package UserInterface.Forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import UserInterface.DMStyles;
import UserInterface.CustomizeControl.DMButton;
import UserInterface.CustomizeControl.DMLabel;
import UserInterface.CustomizeControl.DMTextField;

public class MdEditionForm extends JPanel {

    private DMLabel dmNombreLabel = new DMLabel("Nombre:");
    private DMLabel dmNombreCientificoLabel = new DMLabel("Nombre Cientifico:");
    private DMLabel dmSexoLabel = new DMLabel("Sexo:");
    private DMLabel dmClasificacionLabel = new DMLabel("Clasificacion");
    private DMLabel dmGenoAlimentoLabel = new DMLabel("Geno Alimento:");
    private DMButton dmRegresarButton = new DMButton("<");
    private DMTextField dmNombreField = new DMTextField();
    private DMTextField dmNombreCientificoField = new DMTextField();
    private DMTextField dmSexoField = new DMTextField();
    private DMTextField dmClasificacionField = new DMTextField();
    private DMTextField dmAlimentoField = new DMTextField();

    public MdEditionForm(DMPanelMenu dmPanelMenu){

        JPanel mdNorthPanel = new JPanel();
        mdNorthPanel.setLayout(new BorderLayout());
        mdNorthPanel.setPreferredSize(new Dimension(680,100));
        mdNorthPanel.setBackground(DMStyles.COLOR_FONT_BG);
        mdNorthPanel.add(dmRegresarButton, BorderLayout.LINE_START);

        JPanel mdCentralPanel = new JPanel();
        mdCentralPanel.setLayout(new GridLayout(5,2,50,50));
        mdCentralPanel.setPreferredSize(new Dimension(680,300));
        mdCentralPanel.setBackground(DMStyles.COLOR_FONT_BG);
        mdCentralPanel.add(dmNombreLabel);
        mdCentralPanel.add(dmNombreField);
        mdCentralPanel.add(dmNombreCientificoLabel);
        //mdCentral



      




        
    }   


}
