package UserInterface.CustomizeControl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import UserInterface.DMStyles;

public class DMButton extends JButton {

    public DMButton(String text) {
        super(text);
        setFont(DMStyles.FONT);
        setPreferredSize(new Dimension(50,30));
    }

    public DMButton(String text, Color color){
        super(text);
        setBackground(color);
        setForeground(Color.WHITE);
        setFont(DMStyles.FONT);
        setOpaque(true);
        setBorderPainted(false);
        setPreferredSize(new Dimension(50,30));
    }
    public DMButton(String text, Color color, Font font){
        super(text);
        setBackground(color);
        setForeground(Color.WHITE);
        setFont(font);
        setOpaque(true);
        setBorderPainted(false);
        setPreferredSize(new Dimension(50,30));
    }
}
