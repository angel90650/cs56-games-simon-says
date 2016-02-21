package edu.ucsb.cs56.projects.games.simon_says;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SimonMenu extends JFrame
{
    
    private JPanel mp;
    private ActionListener al;
    private final String MENU[] = {"New Game", "Rules", "Exit"};
    
   
    public SimonMenu()
    {
        super("Simon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mp = new JPanel();
        mp.setBackground(Color.BLACK);
        mp.setLayout(null);
//        BufferedImage myPicture;
//        try {
//            myPicture = ImageIO.read(new File("Simon_Says_robredeyes2.jpg"));
//        } catch (IOException ex) {
//        }

//        void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            g.drawImage(myPicture, 10, 10, null);
//        }

             
        getContentPane().add(BorderLayout.CENTER, mp);
        for(int i = 0; i < MENU.length; i++)
	    {
		JButton jb = new JButton(MENU[i]);
		jb.setBackground(new Color(0xCC99FF));


		jb.setBorderPainted(false);
		jb.setOpaque(true);
		jb.addActionListener(new MenuListener());
                jb.setBounds(140, 125 + 100 * i, 300, 60);
		mp.add(jb);
	    }

        setSize(600, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("Simon_Says_robredeyes2.jpg").getImage();
        g.drawImage(image, 10,10,this);
    }

      
    public class MenuListener implements ActionListener{
	public void actionPerformed(ActionEvent ex) {
	    String cmd = ex.getActionCommand();
	    if(cmd.equals("New Game")){
		dispose();
                new SimonLevel();
	    }

	    else if(cmd.equals("Rules")){
		dispose();
		new SimonRules().setVisible(true);
	    }
	    else if(cmd.equals("Exit"))
		dispose();
	        
	}
    }
    
    public static void main(String[] args) {
	
	new SimonMenu().setVisible(true);
	       
    }    
}
