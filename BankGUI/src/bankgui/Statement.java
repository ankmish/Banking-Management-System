package bankgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Statement implements ActionListener {
         JFrame j;
         JPanel p;
         JLabel l,l1,l2,l3;
         JPasswordField p1;
         JTextField t1,t2;
         JButton b,b1;
         String uname,pass;
         int bal;
    
    Statement()
    {
         
         j=new JFrame("Know Your Mini Statement");
         p=new JPanel();
         
        l1=new JLabel("User Name :");
        l2=new JLabel("Password :");
        t1=new JTextField(20);
        p1=new JPasswordField(20);

         j.setVisible(true);
         j.show();
         j.setSize(700,550);

         j.add(p);
         p.setLayout(null);
         p.setBackground(Color.magenta);
         
         l=new JLabel("Welcome to Mini Account");
         l.setForeground(Color.blue);
         l.setFont(new Font("Bernard MT", Font.BOLD, 20));
         l.setBounds(220,20,400,40);
         
         
         l1.setFont(new Font("Dialog", Font.BOLD, 20));
         l1.setBounds(100,80,150,40);
         
        
         l2.setFont(new Font("Dialog", Font.BOLD, 20));
         l2.setBounds(100,140,150,40);
         
         t1.setFont(new Font("Dialog", Font.BOLD, 17));
         t1.setBounds(320,80,180,30);
        
         p1.setFont(new Font("Dialog", Font.BOLD, 17));
         p1.setBounds(320,140,180,30);
         
         b=new JButton("Submit");
         
         b.setBounds(380,200,80,40);
         
            l3=new JLabel("Your Available Balance is :");
            l3.setForeground(Color.black);
            l3.setFont(new Font("Dialog", Font.ITALIC, 18));
            l3.setBounds(200,150,300,30);

         
            
            t2=new JTextField(20);
            t2.setBounds(450,150,100,30);
            t2.setFont(new Font("Dialog", Font.BOLD, 17));
            
            l3.setVisible(false);
            t2.setVisible(false);
 
          j.setResizable(false);
          
          b1=new JButton("OK");
          b1.setBounds(400,250,80,30);
          b1.setVisible(false);
            
         p.add(l);
         p.add(l1);
         p.add(l2);
         p.add(p1);
         p.add(t1);
         p.add(b);
         p.add(l3);
         p.add(t2);
         p.add(b1);
         
        
         
         b.addActionListener(this);
         b1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
  
        if(ae.getSource()==b)
        {
             uname=t1.getText();
             pass=p1.getText();
             
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection cn;
        String str="jdbc:derby://localhost:1527/BankGUI;user=ankit;password=0312";
        cn=DriverManager.getConnection(str);
        PreparedStatement pst;
        pst=cn.prepareStatement("select balance from customer1 where username='"+uname+"' and password='"+pass+"'");
        ResultSet rs;
        rs=pst.executeQuery();
        if(rs.next())
        {
            l1.setVisible(false);
            t1.setVisible(false);
            l2.setVisible(false);
            p1.setVisible(false);
            b.setVisible(false);
           
            bal=rs.getInt("balance");
            
            t2.setText(Integer.toString(bal));
            
            l3.setVisible(true);
            t2.setVisible(true);
            b1.setVisible(true);                 
        }
        else
        {
            JOptionPane.showMessageDialog(p,"Wrong Credential,Try Again !!!"); 
            t1.setText("");
            p1.setText("");
        }
        }
        if(ae.getSource()==b1)
        {
            j.dispose();
        }
     }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public static void main(String args[])
    {
      //  Statement t=new Statement ();
    }
    
}
