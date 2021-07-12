package minesweeper;

import java.awt.*;
import javax.swing.*;

public class SelectButton {
    SelectButton(){
        JFrame tframe= new JFrame("Select Profile");
        tframe.setBounds(550, 330, 290, 100);
        tframe.getContentPane().setBackground(Color.yellow);
        
        JPanel pane= new JPanel();
        pane.setSize(400,100);
        pane.setBackground(Color.orange);
        
        String country[]={"Ashik","Shihab","xxx","yyyy","zzzz"};        
        JComboBox cb=new JComboBox(country);    
        cb.setBounds(5, 25,90,20);    
        tframe.add(cb);
        
        JButton tbutton =new JButton("CHOOSE");
        //tbutton.addActionListener(e-> System.exit(0));
        tbutton.setBounds(100, 50, 90, 20);
        pane.add(tbutton);
        pane.setLayout(new GridBagLayout());
        tframe.add(pane);
        
        tframe.setResizable(false);
        tframe.setVisible(true);
        tframe.setLayout(null);
        
        System.out.println("selectbutton clicked");
    }
}
