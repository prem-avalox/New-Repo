package UserInterface.CustomizeControl;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import UserInterface.DMStyles;

public class DMLabel extends JLabel {
    
    public DMLabel(String text) {

        super(text);
       
        setForeground(DMStyles.COLOR_FONT);
        setFont(DMStyles.FONT);
    }

}
