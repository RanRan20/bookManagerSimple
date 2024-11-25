/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package library;

import UI.UI;
import UI.login;
import book.bookController;
import com.sun.tools.javac.Main;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author DELL
 */
public class Library{
    public static void main(String[] args) {
        
         login loginUI = new login();
         loginUI.setSize(400, 370); 
         loginUI.setLocationRelativeTo(null); 
         loginUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         loginUI.setVisible(true);
        
    
    }
  
}
    


