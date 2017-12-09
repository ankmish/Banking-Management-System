package bankgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Start  implements ActionListener {   
    JFrame f;
    JPanel p;
    JLabel l, l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5;
    JTextArea a1;
    JPasswordField p1;
    JRadioButton j1,j2,j3,j4;
    ButtonGroup g,g1;
    JButton b;  
    String name,gen,dob1,dob2,dob,dobb,pass,con,email,area,bal;
    int count,acc;
    
  Start()
  {
     p=new JPanel();
     f=new JFrame("Account Section");
     l=new JLabel("Fill Up The Details For Account Opening ");
     l1=new JLabel("User Name :");
     t1=new JTextField(30);
     l2=new JLabel("Password :");
     p1=new JPasswordField(15);
     l3=new JLabel("D.O.B   :");
     t2=new JTextField(20);
     l4=new JLabel("Email ID :");
     t3=new JTextField(30);
     l5=new JLabel("Residential :");
     a1=new JTextArea(5,5);
     l6=new JLabel("Contact :");
     t4=new JTextField(14);
     l7=new JLabel("Gender :");
     j1= new JRadioButton("Male");
     j2=new JRadioButton("Female");
     g=new ButtonGroup();
     g.add(j1);
     g.add(j2);
     b=new JButton("Submit");
     l8=new JLabel("Want to Deposit Some Amount ?");
     j3=new JRadioButton("Yes");
     j4=new JRadioButton("No");
     g1=new ButtonGroup();
     g1.add(j3);
     g1.add(j4);
     l9=new JLabel("Enter Amount :");
     t5=new JTextField(20);
     
     
     
     p.setLayout(null);
     p.add(l);
     p.add(l1);
     p.add(l2);
     p.add(l3);
     p.add(l4);
     p.add(l5);
     p.add(l6);
     p.add(t1);
     p.add(t2);
     p.add(t3);
     p.add(t4);
     p.add(a1);
     p.add(p1);
     p.add(j1);
     p.add(j2);
     p.add(b);
     p.add(l7);
     p.add(l8);
     p.add(j3);
     p.add(j4);
     p.add(l9);
     p.add(t5);
     
      j1.setActionCommand("M"); 
      j2.setActionCommand("F");
      
      j3.setActionCommand("y"); 
      j4.setActionCommand("N");
     
     
     l.setBounds(600,50,300,100);
     l1.setBounds(400,150,100,60);
     t1.setBounds(650,160,200,40);
     l2.setBounds(400,220,100,60);
     p1.setBounds(650,230,200,40);
     l3.setBounds(400,290,100,60);
     t2.setBounds(650,300,200,40);
     l4.setBounds(400,360,100,60);
     t3.setBounds(650,370,200,40);
     l5.setBounds(400,430,100,60);
     a1.setBounds(650,440,200,60);
     l6.setBounds(400,520,100,60);
     t4.setBounds(650,530,200,40);
     l7.setBounds(400,590,100,60);
     j1.setBounds(600,620,80,50);
     j2.setBounds(700,620,80,50);
     l8.setBounds(400,650,350,60);
     j3.setBounds(600,680,80,50);
     j4.setBounds(700,680,80,50);
     l9.setBounds(400,750,100,60);
     t5.setBounds(650,760,200,40);
     b.setBounds(1000,750,80,50);     
     
     l9.setVisible(false);
     t5.setVisible(false);
                                            
 f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
 f.setSize(1900, 1000);
 f.setVisible(true);
 f.setResizable(false);
 f.add(p);

 b.addActionListener(this);
 j3.addActionListener(this);
 j4.addActionListener(this);
 
 
 b.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent event)
{
getUserInformation();
validation();
registerUserData();

}
});
 
 
j1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
gen=g.getSelection().getActionCommand();
}
});


j2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
gen=g.getSelection().getActionCommand();
}
});


j3.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
j3.setActionCommand("Y"); 
}
});

j4.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
j4.setActionCommand("N"); 
}
});
 
 
 }
  
  
  

  
  

public void validation() {
    count =0;

if(name.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Name");
}
else if(pass.equals(""))
{
JOptionPane.showMessageDialog(null,"Create your Password");
}
else if(dob.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Date");
}
else if(dob1.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Month");
}
else if(dob2.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Year");
}

else if(con.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Mobile Number");
}

else if(email.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter E-Mail address");
}

else if(area.equals(""))
{
JOptionPane.showMessageDialog(null,"Enter Area");
}

else if(gen.equals(""))
{
JOptionPane.showMessageDialog(null,"Select gender");
}
else
{
if((Integer.parseInt(dob2)<=2011) && (Integer.parseInt(dob2)>=1930))
{
if((Integer.parseInt(dob1)<=12) && (Integer.parseInt(dob1)>0))
{
if((Integer.parseInt(dob1)==1) || (Integer.parseInt(dob1)==3) || (Integer.parseInt(dob1)==5) || (Integer.parseInt(dob1)==7) || (Integer.parseInt(dob1)==8) || (Integer.parseInt(dob1)==10) || (Integer.parseInt(dob1)==12))
{
if((Integer.parseInt(dob)<=31) && (Integer.parseInt(dob)>=1))
{
dobb=dob+"/"+dob1+"/"+dob2;

if(email.contains("@") && email.contains(".com")) {
if(con.length()==10) {
count++;
}
else {
JOptionPane.showMessageDialog(null,"Enter 10-digit moblie number");
}
}
else {
JOptionPane.showMessageDialog(null,"Enter valid mail ID");
}

}
else
{
JOptionPane.showMessageDialog(null,"Invalid Date");
}
}
else if((Integer.parseInt(dob1)==4) || (Integer.parseInt(dob1)==6) || (Integer.parseInt(dob1)==9) || (Integer.parseInt(dob1)==11))
{
if((Integer.parseInt(dob)<=30) && (Integer.parseInt(dob)>=1))
{
dobb=dob+"/"+dob1+"/"+dob2;

if(email.contains("@") && email.contains(".com")) {
if(con.length()==10) {
count++;
}
else {
JOptionPane.showMessageDialog(null,"Enter 10-digit moblie number");
}
}
else {
JOptionPane.showMessageDialog(null,"Enter valid mail ID");
}

}
else
{
JOptionPane.showMessageDialog(null,"Invalid Date");
}
}
else
{
if(((Integer.parseInt(dob2)%100)==0) || ((Integer.parseInt(dob2)%4)==0))
{
if((Integer.parseInt(dob)<=29) && (Integer.parseInt(dob)>=1))
{
dobb=dob+"/"+dob1+"/"+dob2;
}
else
{
JOptionPane.showMessageDialog(null,"Invalid Date");
}
}
else
{
if((Integer.parseInt(dob)<=28) && (Integer.parseInt(dob)>=1))
{
dobb=dob+"/"+dob1+"/"+dob2;
}
else
{
JOptionPane.showMessageDialog(null,"Invalid Date");
}
}
}
}
else
{
JOptionPane.showMessageDialog(null,"Enter month between 1 and 12");
}
}
else
{
JOptionPane.showMessageDialog(null,"Enter year between 1930 and 2011");
}
}
}

public void getUserInformation() {
name = t1.getText();
pass= p1.getText();
dob =t2.getText();
dob1 = t2.getText();
dob2 = t2.getText();
dobb = dob + "/" + dob1 + "/" + dob2;
con = t4.getText();
email = t3.getText();
area = a1.getText();


}
  
public void registerUserData() {

 if(count==1)
       {
   //    if(ae.getSource()==b)
    //   {
         //  String name,pass,con,email,add,dob,gen;
         //  int acc;
         //  String bal;
    /*       name=t1.getText();
           pass=p1.getText();
           dob=t2.getText();
           email=t3.getText();
           area=a1.getText();
           con=t4.getText();
           gen=g.getSelection().getActionCommand();
           bal=g1.getSelection().getActionCommand();
           Random r=new Random();
           acc=r.nextInt(1000000000);
           bal=t5.getText();   */
       
           try
           {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection cn;
                String str="jdbc:derby://localhost:1527/BankGUI;user=ankit;password=0312";
                cn=DriverManager.getConnection(str);
                PreparedStatement pst;
                pst=cn.prepareStatement("insert into customer1 values("+acc+",'"+name+"','"+pass+"','"+dob+"','"+email+"','"+area+"','"+con+"','"+gen+"','"+bal+"')");          
                int xx=pst.executeUpdate();
        
        if(xx==1)
        {
            JOptionPane.showMessageDialog(f,"Registration Done !!!");  
            //System.out.println("Registration Done !!! ..yours StudentID is :->"+sid);
        }
        else
        {
            JOptionPane.showMessageDialog(f,"Error on Registration .....Try Again.!!!!!!");  
            //System.out.print("Error on Registration .....Try Again.!!!!!!");
        }         
     }
           catch(Exception ex)
           {
               System.out.println(ex);
           }
    //   }
       }
}



   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==j3)
       {
           l9.setVisible(true);
           t5.setVisible(true);
           
      //    boolean v = !t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty() && !t5.getText().isEmpty() &&!p1.getText().isEmpty() && !a1.getText().isEmpty() && g.getSelection()!=null && g1.getSelection()!=null;          
          
      //    b.setEnabled(v);
       }
       
       if(ae.getSource()==j4)
       {
           l9.setVisible(false);
           t5.setVisible(false);
           
           
      //     boolean v=!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty() && !p1.getText().isEmpty() && !a1.getText().isEmpty() && g.getSelection()!=null && g1.getSelection()!=null;
           
       //    b.setEnabled(v);
       }
       if(ae.getSource()==b)
       {
           
       }
       
      
   }
  
  
  public static void main(String args[])
  {
      Start s=new Start();
  }
}
