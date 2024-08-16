package UserInterface.CustomizeControl;

import java.awt.Color;

import javax.swing.JButton;

import UserInterface.DMStyles;

public class DMButton extends JButton {

    public DMButton(String text) {
        super(text);
        setFont(DMStyles.FONT);
    }

    public DMButton(String text, Color color){
        super(text);
        setBackground(color);
        setForeground(Color.WHITE);
        setFont(DMStyles.FONT);
        setOpaque(true);
        setBorderPainted(false);
    }

}
