    package minesweeper;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static minesweeper.MineSweeper.PlayAudioLose;


public class GuestButton extends MineSweeper{
    
int mx=-100,my=-100,spacing=1;
    JToggleButton[][] button= new JToggleButton[100][200];
    int[][] blox = new int[100][200];
    boolean start = false, gamelost = false,winwin=true;
    int second=0, minute=0;
    
    GuestButton(JFrame frame, int bombnum,int gridx, int gridy, int gridh){
        Date starttime= new Date();
        frame.getContentPane().removeAll();
        //frame.getContentPane().add(panel);
        frame.repaint();
        ActionListener listen= new ActionListener(){
            public void actionPerformed(ActionEvent e){
                timer(starttime,frame);
                    int i = 0,j = 0;
                    boolean found=false;
                    for(i=0;i<gridy;i++){
                        for(j=0;j<gridx;j++){
                            if(button[i][j]==e.getSource()){
                                found=true;
                                break;
                            }
                        }
                        if(found==true) break;
                    }
                    PlayAudioBC();
                    if(gamelost==false){
                        button[i][j].setSelected(true);
                         //if(blox[i][j]==-1) gamelost=true;
                        if(!start) setBomb(i,j);
                        start=true;
                        if(blox[i][j]!=-1){
                            openblocks(i,j);
                            labelblocks(gridh);
                        }else {
                            PlayAudioBomb();
                            PlayAudioLose();
                            lose(gridh);
                        }
                        wincheck();
                    }else labelblocks(gridh);
            }
        };

        for(int i=0;i<gridy;i++)
        {
            for(int j=0;j<gridx;j++)
            {
                button[i][j]= new JToggleButton();
                button[i][j].setBackground(Color.DARK_GRAY);
                button[i][j].setBounds(j*(gridh+1)+15+spacing+10, i*(gridh+1)+spacing+60+7,gridh,gridh);
                button[i][j].addActionListener(listen);
                frame.add(button[i][j]);
            }
        }
        
        ImageIcon ex=new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\e.png");
        JButton tbutton = new JButton(ex);
        tbutton.setBounds(30 , 20 , 160 , 46);
        tbutton.addActionListener(e-> {
             PlayAudioBC();
             frame.getContentPane().removeAll();
             frame.repaint();
             PlayAudioTheme(true);
             home(frame);
                });
        frame.add(tbutton);
        ImageIcon bg=new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\bg.png");
        JLabel lll=new JLabel(bg);
        lll.setBounds(-4, -5, 1010, 600);
        frame.add(lll);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked");
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }
            
        });
        
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mx=e.getX();
                my=e.getY();
                System.out.println("Mouse Moved on X = "+mx+" , Y = "+my);
            }
            /*@Override
            public void mouseDragged(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }*/
        });
        /*ActionListener timer = new ActionListener() {
            int time = 10000;
            int step = 1;

            public void actionPerformed(ActionEvent ae) {
                if (time == 0 && step == 1) {
                    time = 60000;
                    step = 2;
                    for (int i = 0; i < 16; i++) {
                        /// btn[i + 1].setText("");
                       // btn[i + 1].setIcon(common);
                    }
                } else if (time == 0 && step == 2 && result < 😎 {
                    //countdown.setText("game over");
                    ((Timer) ae.getSource()).stop();
                    //nfFrame.setVisible(false);
                }
                time -= 100;
                Time = time;
                if (time > 0 && result < 😎 {
                    countdown.setText( Integer.toString(time / 1000) + "s");
                }
            }
        };
        new javax.swing.Timer(100, timer).start();*/


        System.out.println("guestbutton clicked");
    }
    
    public void timer(Date starttime, JFrame frame){
        JPanel p=new JPanel();
                p.setBounds(870,25,180,46);
                p.setBackground(Color.GRAY);
                second=(int)((new Date().getTime()-starttime.getTime())/1000);
                System.out.println(second);
                JLabel time=new JLabel(""+second);
                //time.setBounds(913,3,150,40);
                time.setForeground(Color.red);
                time.setFont(new Font("Courier New",Font.BOLD,30));
                p.add(time);
                frame.add(p);
    }
    
    public void setBomb(int y, int x){
        int i,j;
            for(int k=1; k<=bombnum; k++){
                do{
                i= (int) (Math.random()*(gridy-.01));
                j= (int) (Math.random()*(gridx-.01));
                }
                while(blox[i][j]==-1 || (i==y && j==x));
                blox[i][j]=-1;
                //button[i][j].setText("b");
            }
    }
    
    public void openblocks(int y, int x){
        if(y<0 || x<0 || y>gridy-1 || x>gridx-1|| blox[y][x]!=0)return;
        int bombs = 0;
        for(int i= y-1; i<=y+1; i++){
            for(int j= x-1; j<= x+1; j++){
                if(!(i<0 || j<0 || i>gridy-1 || j>gridx-1) && blox[i][j]==-1){
                    bombs++;
                }
            }
        }
        if(bombs==0){
            blox[y][x]= -2;
            for(int i= y-1; i<=y+1; i++){
                for(int j= x-1; j<= x+1; j++){
                    if(!(i<0 || j<0 || i>gridy-1 || j>gridx-1))
                        if(i!=y || j!=x) openblocks(i,j);
                }
            }
        }else  blox[y][x]=bombs;
    }
    
    public void labelblocks(int gridh){
        for(int i=0;i<gridy;i++){
            for(int j=0;j<gridx;j++){
                if(blox[i][j]==0){
                    button[i][j].setText("");
                    button[i][j].setSelected(false);
                }
                if(blox[i][j]== -2){
                    button[i][j].setText("");
                    button[i][j].setSelected(true);
                }
                if(blox[i][j]>0){
                    if(gridh!=49)
                    {
                        if(blox[i][j]==1){
                        ImageIcon n1= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n1.png");
                        button[i][j].setIcon(n1);
                        }
                        if(blox[i][j]==2){
                        ImageIcon n2= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n2.png");
                        button[i][j].setIcon(n2);
                        }
                        if(blox[i][j]==3){
                        ImageIcon n3= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n3.png");
                        button[i][j].setIcon(n3);
                        }
                        if(blox[i][j]==4){
                        ImageIcon n4= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n4.png");
                        button[i][j].setIcon(n4);
                        }
                        if(blox[i][j]==5){
                        ImageIcon n5= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n5.png");
                        button[i][j].setIcon(n5);
                        }
                        if(blox[i][j]==6){
                        ImageIcon n6= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n6.png");
                        button[i][j].setIcon(n6);
                        }
                        if(blox[i][j]==7){
                        ImageIcon n7= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n7.png");
                        button[i][j].setIcon(n7);
                        }
                        if(blox[i][j]==8){
                        ImageIcon n8= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\n8.png");
                        button[i][j].setIcon(n8);
                        }
                    }
                    else
                    button[i][j].setText(""+blox[i][j]);
                    button[i][j].setSelected(true);
                }
            }
        }
    }
    public void lose(int gridh){
        gamelost=true;
         for(int i=0;i<gridy;i++){
            for(int j=0;j<gridx;j++){
                if(blox[i][j]==-1){
                    
                    if(gridh==49){
                    ImageIcon img= new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\b4.png");
                    button[i][j].setIcon(img);
                    }
                    

                    if(gridh!=49){
                        ImageIcon img2=new ImageIcon("C:\\Users\\hp\\Documents\\java\\res\\b30px.png");
                        button[i][j].setIcon(img2);
                    }
                    button[i][j].setSelected(true);
                    
                }
                
            }
         }
         javax.swing.JOptionPane.showMessageDialog(null, "You lose in "+second+" seconds!!!");
    }
    public void wincheck(){
        boolean win=true;
        for(int i=0;i<gridy;i++){
            for(int j=0;j<gridx;j++){
                if(blox[i][j]==0){
                    win=false;
                }
             }
            if(win==false) break;
        }
        if(win) {
            gamelost=true;
            PlayAudioWin();
            javax.swing.JOptionPane.showMessageDialog(null, "Congrats You Win in "+second+" seconds!!!!!!");
        }
        
    }
}



