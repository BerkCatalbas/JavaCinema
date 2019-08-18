/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;



/**
 *
 * @author Berk
 */

public class MyListener implements ActionListener {
  
   private String[][] k=new String[44][2];
    Component[] component;
    int count;
    JLabel label;
    double price,pricef;    
    public MyListener(JPanel j,JLabel t)
            
     {
         label=t;
      int count=0;   
      price=0;
      
     component = j.getComponents();

   int b=0;
    for(int i=0; i<component.length; i++)
    {
        
        if (component[i] instanceof JToggleButton)
        {
            
            JToggleButton button = (JToggleButton)component[i];
         k[b][0]=button.getToolTipText();
         
         b++;
         
        }
        
    }       
    
         }
        protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL, description);
    } else {
        System.out.println("Couldn't find file: " + path);
        return null;
    }
}
        
    public void actionPerformed(ActionEvent e) {
        
        int g=0;
       
       Object source = e.getSource();
if (source instanceof JToggleButton) {
    JToggleButton button = (JToggleButton) source;
    
    
    for(int i=0;i<44;i++)
    {
    
    if(k[i][0].equals(((JToggleButton) source).getToolTipText()))   
        break;
    g++;
    }
    
    if(k[g][1]=="0"||k[g][1]==null)
    {
        ImageIcon icon = createImageIcon("Images/Seatr.png","a");
    button.setIcon(icon);
    k[g][1]="1";
    count++;
    price=count*22.5;
    label.setText(Double.toString(price));
    }
    else
    {
        ImageIcon icon = createImageIcon("Images/Seat.png","a");
    button.setIcon(icon);
     
    k[g][1]="0";
    count--;
    price=count*22.5;
    label.setText(Double.toString(price));
    }
}

    }
    
   public String[][] GetList()
   {
   return k;
   }
   
   public void SetList(String[][] u)
   {
   k=u;
   }
   
   public void SetCount(int a)
   {
   count=a;
   }
   public void fopen()
   {
       
     
       int b=0;
  for(int i=0; i<component.length; i++)
    {
        
        if (component[i] instanceof JToggleButton)
        {
                       
            JToggleButton button = (JToggleButton)component[i];
         
     if(k[b][1]==null || k[b][1]=="0")
             {
                 ImageIcon icon = createImageIcon("Images/Seat.png","a");
            
             button.setIcon(icon);
              
             }
     else
     {
      ImageIcon icon = createImageIcon("Images/Seatr.png","a");
     
   button.setEnabled(false);
   button.setDisabledIcon(icon);
     
     }                   
         
     
b++; 
    }

   
   }
   }
    
}
