package UserInterface.CustomizeControl;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import UserInterface.DMStyles;

public class DMTextField extends JTextField{
    public DMTextField() {
        super();
        this.setFont(DMStyles.FONT);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(DMStyles.COLOR_FONT, 1, true));
        this.setPreferredSize(new Dimension(100,20));
        
    }
}