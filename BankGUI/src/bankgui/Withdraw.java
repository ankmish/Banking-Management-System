package bankgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Withdraw implements ActionListener{
    JFrame j;
    JPanel p;
    JLabel l,l1,l2,l3;
    JPasswordField p1;
    JTextField t1,t2;
    JButton b,b1;
    
    String uname,pass;
    int bal,am;
    
    Withdraw()
    {
        j=new JFrame("Welcome to Our Banking Page ");
        l=new JLabel("Don't share your credential with anyone...");
        l1=new JLabel("User Name :");
        l2=new JLabel("Password :");
        t1=new JTextField(20);
        p1=new JPasswordField(20);


        b=new JButton("Submit");
        
        
        p=new JPanel();
        p.setBackground(Color.lightGray);
        
        j.setSize(700,550);
        j.setVisible(true);
        j.setResizable(false);
        p.setLayout(null);
        p.setVisible(true);
        j.show();       //to bring the window in front to make the Components visible 
        
        l.setFont(new Font("Bernard MT", Font.BOLD, 20));
        l.setBounds(200,20,400,40);
        l.setForeground(Color.BLUE);
        
        l1.setFont(new Font("Dialog", Font.BOLD, 20));
        l1.setBounds(100,80,150,40);
        
        
        l2.setFont(new Font("Dialog", Font.BOLD, 20));
        l2.setBounds(100,140,150,40);
        
        
        l3=new JLabel("WithDrawing Amount :");
        l3.setFont(new Font("Dialog", Font.BOLD, 16));
        l3.setBounds(80,200,180,40);
        
        l3.setVisible(false);
        
        
        t1.setFont(new Font("Dialog", Font.BOLD, 17));
        t1.setBounds(350,80,180,30);
        
        p1.setFont(new Font("Dialog", Font.BOLD, 17));
        p1.setBounds(350,140,180,30);
        
        
        t2=new JTextField(20);            
        t2.setFont(new Font("Dialog", Font.BOLD, 17));
        t2.setBounds(350,200,180,30);
        t2.setVisible(false);
        
        
        b1=new JButton("Proceed");
        b1.setVisible(false);
        
        b.setBounds(200,350,100,30);
        b1.setBounds(350,350,100,30);
        b1.setVisible(false);
        
        p.add(l);
        p.add(t1);
        p.add(p1);
        p.add(l1);
        p.add(l2);
        p.add(b);
        
        p.add(l3);
        p.add(t2);
        p.add(b1);
        
        j.add(p);
        
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
        PreparedStatement pst,pst1;
        pst=cn.prepareStatement("select balance from customer1 where username='"+uname+"' and password='"+pass+"'");
        ResultSet rs;
        rs=pst.executeQuery();
        if(rs.next())
        {
      //       JOptionPane.showMessageDialog(null,"Correct Credential!!!");
            
            l3.setVisible(true);
            t2.setVisible(true);
            b1.setVisible(true);
            
            l1.setVisible(false);
            l2.setVisible(false);
            t1.setVisible(false);
            p1.setVisible(false);
            b.setVisible(false);
                               
            bal=rs.getInt("balance");
            
        }
         else
        {
            JOptionPane.showMessageDialog(null,"Wrong Credential,Try Again !!!");
            t1.setText("");
            p1.setText("");
        }
       
        rs.close();
        cn.close();      
        
        }
             
            if(ae.getSource()==b1)
            {
                            
                 am=Integer.parseInt(t2.getText()); 
                 if(bal>am)
                 {
                 
                     bal-=am;
                 
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       Connection cn;
       String str="jdbc:derby://localhost:1527/BankGUI;user=ankit;password=0312";
       cn=DriverManager.getConnection(str);
       PreparedStatement pst1;
                 
                 pst1=cn.prepareStatement("update customer1 set balance="+bal+" where username='"+uname+"' and password='"+pass+"'");
                  int x=pst1.executeUpdate();
                    if(x==1)
                    {
                        JOptionPane.showMessageDialog(p,"Cash WithDrawn !!");
                        j.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(p,"Kuch to gadbad haii ");
                    }
             }
                 else
                 {
                     JOptionPane.showMessageDialog(p,"Insufficient Balance !!!!");
                     t2.setText("");
                 }
                 
            }
         }            
          catch(Exception ex)
          {
              System.out.println(ex);
          }  
      }
  
    public static void main(String args[])
    {
 //       Withdraw d=new Withdraw();
    }
    
}
