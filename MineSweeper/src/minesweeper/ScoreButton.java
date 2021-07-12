package minesweeper;

import java.awt.*;
import javax.swing.*;

public class ScoreButton {
    ScoreButton(){
        JFrame tframe= new JFrame("Create New Profile");
        tframe.setBounds(500, 250, 400, 200);
        tframe.getContentPane().setBackground(Color.yellow);
        
        JLabel tl= new JLabel("HighScores");
        tl.setForeground(Color.red);
        tl.setBounds(50, 50, 50, 40);
        tframe.add(tl);
        
        tframe.setResizable(false);
        tframe.setVisible(true);
        tframe.setLayout(null);
          System.out.println("scorebutton clicked");
    }
}
