package bankgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class check implements ActionListener {
    JFrame j;
    JPanel p;
    JRadioButton b1,b2;
    ButtonGroup g;
    JButton t1,t2;
    check()
    {
        j=new JFrame("check");
        b1=new JRadioButton("Male");
        b2=new JRadioButton("Female");
        g=new ButtonGroup();
        g.add(b1);
        g.add(b2);
        
        p=new JPanel();
        
        t1=new JButton("Submit");
        t2=new JButton("Clear");
        
        b1.setBounds(100,100,100,60);
        b2.setBounds(100,250,100,60);
         
        t1.setBounds(200,400,100,60);
        t2.setBounds(500,400,100,60);
        
       p.add(b1);
       p.add(b2);
       p.add(t1);
       p.add(t2);
       
       j.setSize(1900,1000);
       j.setVisible(true); 
       p.setLayout(null);
       
       j.add(p);
       
       t1.addActionListener(this);
       t2.addActionListener(this);
       
       
       t1.setEnabled(false);
       t2.setEnabled(false);
       
       
           
    b1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
        t1.setEnabled(true);
}
});
    
    
        b2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
        t1.setEnabled(true);
}
});   
    
              
    }  
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getActionCommand().equals("Submit"))
        {
           Start s=new Start();
        }
        if(ae.getSource()==b2)
        {  
            g.clearSelection();        // to clear the selection 
        }
    }
    public static void main(String args[]) {
        check c=new check();
    }
    
}
