package minesweeper;

import java.awt.*;
import javax.swing.*;

public class NewProfButton extends MineSweeper{
    NewProfButton(JFrame frame){

        frame.getContentPane().removeAll();
        //frame.getContentPane().add(panel);
        frame.repaint();
        ImageIcon bg=new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\bg.png");
        
        ImageIcon ex= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\e.png"); 
        
        
        JTextField name= new JTextField(30);
        name.setBounds(450, 210, 200, 40);
        JLabel namelabel= new JLabel("Name:");
        namelabel.setBounds(360, 210, 200, 40);

        JTextField password= new JTextField(30);
        password.setBounds(450, 270, 200, 40);
        JLabel passwordlabel= new JLabel("Password:");
        passwordlabel.setBounds(360, 270, 200, 40);
        
        
        ImageIcon pb= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\222.png");       //login button                                                                                 //guestbutton                                                                                //new profile button
        JButton login= new JButton(pb);
        login.setBounds(520,340 , 160, 46);
        login.addActionListener(e-> {
            
            PlayAudioBC();
            PlayAudioTheme(false);                                                       //stop theme...
            new GuestButton(frame,bombnum,gridx,gridy,gridh);
                });
        
        
        
        passwordlabel.setFont(new Font("Courier New",Font.BOLD,15)); 
        namelabel.setFont(new Font("Courier New",Font.BOLD,15)); 
        
        frame.add(name);
        frame.add(namelabel);
        frame.add(password);
        frame.add(passwordlabel);
        frame.add(login);
        
        
        JButton tbutton = new JButton(ex);                                       //home button
        tbutton.setBounds(340 ,340 , 160, 46);
        tbutton.addActionListener(e-> {
             PlayAudioBC();
             frame.getContentPane().removeAll();
             frame.repaint();
             PlayAudioTheme(true);
             home(frame);
                });
        frame.add(tbutton);
        
        
        
        JLabel lll=new JLabel(bg);
        lll.setBounds(-4, -5, 1010, 598);
        frame.add(lll);
        System.out.println("newprofbutton clicked");
    }
}
