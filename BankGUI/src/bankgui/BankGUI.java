package bankgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BankGUI implements ActionListener {
    JFrame f;
    JPanel p;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    ButtonGroup group;
    JLabel l,l1,imagelabel;
    BankGUI()
    {
        f=new JFrame("Banking Project By Mishra");
        l=new JLabel("Here we GO !!-- by AkM ");
        l1=new JLabel("Welcome to PNB");
        r1= new JRadioButton("Open a new Account");
        r2=new JRadioButton("Deposit ");
        r3=new JRadioButton("WithDraw");
        r4=new JRadioButton("Know your Statement");
        group= new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        b1=new JButton("Proceed");
        b2=new JButton ("Clear");
        p=new JPanel();
        
        
        l.setFont(new Font("Bradley Hand ITC", Font.BOLD, 40));
        l.setForeground(Color.gray);
        l.setBounds(1300,80,610,70);
        
        l1.setFont(new Font("Serif", Font.BOLD, 50));
        l1.setForeground(Color.red);
        r1.setFont(new Font("Cambria",Font.BOLD,30));
        r2.setFont(new Font("Cambria",Font.BOLD,30));
        r3.setFont(new Font("Cambria",Font.BOLD,30));
        r4.setFont(new Font("Cambria",Font.BOLD,30));
        r1.setForeground(Color.blue);
        r2.setForeground(Color.blue);
        r3.setForeground(Color.blue);
        r4.setForeground(Color.blue);
                 
        p.setBackground(Color.cyan);
        
        ImageIcon image = new ImageIcon(new ImageIcon("C:\\Users\\AkM\\Desktop\\pnb.jpg").getImage().getScaledInstance(450,200, Image.SCALE_DEFAULT));
        imagelabel=new JLabel(image);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        imagelabel.setBounds(80, 80, 500, 150);
        l1.setBounds(720,100,400,200);
        r1.setBounds(600,300,600,100);
        r2.setBounds(600,400,600,100);
        r3.setBounds(600,500,600,100);
        r4.setBounds(600,600,600,100);
        b1.setBounds(700,750,100,60);
        b2.setBounds(900,750,100,60);
        
        p.add(l);
        p.add(b1);
        p.add(b2);
        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(r4);
        p.add(l1);
        p.add(imagelabel);
        f.add(p);
        
        p.setVisible(true);
        p.setLayout(null);
        f.setSize(1800,1000);  
        f.setVisible(true);
        f.setResizable(false);
        
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        
        b1.addActionListener(this);
        b2.addActionListener(this); 
        
        b1.setEnabled(false);
        b2.setEnabled(false);
        
        
        r1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               b1.setEnabled(true);
               b2.setEnabled(true);
}
});
    
    
            r2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    b1.setEnabled(true);
                    b2.setEnabled(true);
}
});
            
            r3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    b1.setEnabled(true);
                    b2.setEnabled(true);
}
});
            r4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    b1.setEnabled(true);
                    b2.setEnabled(true);
}
});
      
     }   
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==b1)
        {
            if(r1.isSelected())
            {                            // if one radioButton is selected and then we proceed
           RegistrationFormDesign r=new RegistrationFormDesign();
           f.dispose();
            }// to dipose the The frame once the new Frame is opened         
        }
        
        if(ae.getSource()==b1)
        {
            if(r2.isSelected())
            {                           
           Deposit r=new Deposit();
           f.dispose();
            }         
        }
        
           if(ae.getSource()==b1)
        {
            if(r3.isSelected())
            {                           
           Withdraw r=new Withdraw();
           f.dispose();
            }         
        }
        
            if(ae.getSource()==b1)
        {
            if(r4.isSelected())
            {                           
           Statement r=new Statement();
           f.dispose();
            }         
        }
           
           
        if(ae.getSource()==b2)
        {  
            group.clearSelection();        // to clear the selection 
            b1.setEnabled(false);
        }
    }   
    public static void main(String[] args) {
        BankGUI b=new BankGUI();
    }   
}
