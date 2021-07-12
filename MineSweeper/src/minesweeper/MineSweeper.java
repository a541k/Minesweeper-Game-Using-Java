package minesweeper;

import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class MineSweeper {
    
    //public static Clip clip;
    public static Boolean sounds = true,theme=true, settheme=false;
    public static Clip clip;
    public static int bombnum=15;
    public static int gridx=19, gridy=10,gridh=49,level=1;
    
    public static void home(JFrame frame){
        //PlayAudioTheme(theme);
        frame.setBounds(200,100,1008,644);
        if(!settheme)
        frame.getContentPane().setBackground(Color.yellow);   //In Java Swing, the layer that is used to hold objects is called the content pane. 
        
        
        ImageIcon gb= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\11.png");                   //guest button                                                                              //guestbutton
        JButton guestbutton = new JButton(gb);
        //guestbutton.setBackground(Color.yellow);
        //guestbutton.setBounds(410,310 ,200 ,58 );
        guestbutton.setBounds(430,320 ,160 ,46 );
        guestbutton.addActionListener(e-> {
            
            PlayAudioBC();
            PlayAudioTheme(false);                                                       //stop theme...
            new GuestButton(frame,bombnum,gridx,gridy,gridh);
                });
        frame.add(guestbutton);
        
        
        ImageIcon pb= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\22.png");                                                                                  //guestbutton                                                                                //new profile button
        JButton newprofbutton= new JButton(pb);
        //newprofbutton.setBackground(Color.yellow);
        //newprofbutton.setBounds(410,380 , 200, 58);
        newprofbutton.setBounds(430,380 ,160 ,46 );
        newprofbutton.addActionListener(e-> {
            PlayAudioBC();
            PlayAudioTheme(false); 
                new NewProfButton(frame);
                        });
        frame.add(newprofbutton);
        
       
                                                                                  //background image
        ImageIcon ii= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\l5.png");
        JLabel l2= new JLabel(ii);
        l2.setBounds(280, 30, 440, 500);
        frame.add(l2);
        
        
        ImageIcon bg=new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\bg.png");          //bg
        JLabel lll=new JLabel(bg);
        lll.setBounds(-4, -5, 1010, 598);
        frame.add(lll);
        
   
        
     
                                                                                        //Menu Bar.....
        JMenu i6;
        JMenu menu = new JMenu("Menu");
        JMenu sound = new JMenu("Sound");
        JMenu level = new JMenu("level");
        JMenuBar menubar= new JMenuBar();
        JMenuItem i1,i2,i3,i5,i4,i7,i8,i9;
        i1=new JMenuItem("Start Game");  
        i2=new JMenuItem("Instruction");
        
                                                                                //theme
        i6=new JMenu("Theme");
        i6.add(new JMenuItem("Yellow")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.yellow);
            settheme=true;
                });
        i6.add(new JMenuItem("Red")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.red);
            settheme=true;
                });
        i6.add(new JMenuItem("Orange")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.orange);
            settheme=true;
                });
        i6.add(new JMenuItem("Blue")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.blue);
            settheme=true;
                });
        i6.add(new JMenuItem("Green")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.green);
            settheme=true;
                });
        i6.add(new JMenuItem("Pink")).addActionListener(e->{
            frame.getContentPane().setBackground(Color.pink);
            settheme=true;
                });
        
                                                                                //menu
        i3=new JMenuItem("Exit");
        i4=new JMenuItem("Sounds ON");
        i5=new JMenuItem("Sounds OFF");
        i1.addActionListener(e->new GuestButton(frame,bombnum,gridx,gridy,gridh));
        i3.addActionListener(e-> System.exit(0));
                                                                                //sound
        i4.addActionListener(e->{
            sounds=true;
            //PlayAudioTheme(true);                    
                });
        i5.addActionListener(e-> {
            sounds=true;
            PlayAudioTheme(false);
            sounds=false;
                });
                                                                                //Level
        i7=new JMenuItem("Easy");  
        i8=new JMenuItem("Normal");
        i9=new JMenuItem("Hard");
        i7.addActionListener(e-> {
            bombnum=15;
            gridx=19; gridy=10;gridh=49;
                });
        i8.addActionListener(e-> {
            bombnum=35;
            gridx=23; gridy=12;gridh=40;
                });
        i9.addActionListener(e-> {
            bombnum=68;
            gridx=31; gridy=16;gridh=30;
                });
        level.add(i7);level.add(i8);level.add(i9);
        menu.add(i1); menu.add(i2); menu.add(i3);
        sound.add(i5); sound.add(i4);
        menubar.add(menu);
        //menubar.add(i6);
        menubar.add(sound);
        menubar.add(level);
        frame.setJMenuBar(menubar);
        
        
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
                                                                                            //Audio portion
    public static void PlayAudioBC(){
        if(sounds==true){
        InputStream in;
            try {
                in=new FileInputStream(new File("C:\\Users\\hp\\Documents\\java\\res\\click.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public static void PlayAudioTheme(boolean theme){                              // call with true argument to play 
        if(sounds==true){                                                          // call with false argument to stop 
            
            try {
                if(theme==true){
                File musicpath= new File("C:\\Users\\hp\\Documents\\java\\res\\theme.wav");
                AudioInputStream audioinput=AudioSystem.getAudioInputStream(musicpath);
                clip= AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
                clip.loop(5);
                }
                if(theme==false && clip.isRunning()){
                    //long time= clip.getMicrosecondPosition();
                    System.out.println("false");
                    clip.stop();
                }
                
               }catch(Exception ex){
                   ex.printStackTrace();
               }
        }
    }
    public static void PlayAudioWin(){
        if(sounds==true){
        InputStream in;
            try {
                in=new FileInputStream(new File("C:\\Users\\hp\\Documents\\java\\res\\start.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void PlayAudioLose(){
        if(sounds==true){
        InputStream in;
            try {
                in=new FileInputStream(new File("C:\\Users\\hp\\Documents\\java\\res\\game over.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void PlayAudioBomb(){
        if(sounds==true){
        InputStream in;
            try {
                in=new FileInputStream(new File("C:\\Users\\hp\\Documents\\java\\res\\bomb.wav"));
                AudioStream audio = new AudioStream(in);
                AudioPlayer.player.start(audio);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("MINE SWEEPER");
        PlayAudioTheme(theme);
        home(frame);
    }
    
}
