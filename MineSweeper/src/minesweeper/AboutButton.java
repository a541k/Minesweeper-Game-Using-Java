package minesweeper;

import java.awt.*;
import javax.swing.*;


public class AboutButton extends MineSweeper{
    AboutButton(){
            JFrame temp=new JFrame("About");
            temp.setBounds(620, 290, 150, 200);
            temp.getContentPane().setBackground(Color.orange); 
            
            JLabel label =new JLabel("<html><center><b><u>Created By.......</b></u><br>Ashik Mahmud<br>Shihub kobir<br><t>Contact: 01798652221<br></t><center></html>");
            label.setForeground(Color.red);
            temp.add(label);
            temp.setResizable(false);
            temp.setVisible(true);
    }
    
}
