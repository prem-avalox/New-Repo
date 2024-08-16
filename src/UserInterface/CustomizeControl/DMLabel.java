package UserInterface.CustomizeControl;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import UserInterface.DMStyles;

public class DMLabel extends JLabel {
    
    public DMLabel(String text) {

        super(text);
        setHorizontalAlignment(DMStyles.ALIGNMENT_LEFT);
        setForeground(DMStyles.COLOR_FONT);
        setFont(DMStyles.FONT);
    }

}
