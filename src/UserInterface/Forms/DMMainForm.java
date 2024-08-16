package UserInterface.Forms;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class DMMainForm extends JFrame {
    
    DMPanelMenu dmPanelMenu;

    public DMMainForm(String title) {
        dmPanelMenu = new DMPanelMenu (); 
            customizeComponent(title);
        
    }

    private void customizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(720, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(dmPanelMenu, BorderLayout.CENTER);

        setVisible(true);
    }
}
