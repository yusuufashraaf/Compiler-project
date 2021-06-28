/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Browsing {
     public String browsing(JFrame frame){
          String Code="";
// we make an object called fc of the type JFileChooer 
                final JFileChooser fc = new JFileChooser(); 
// It opens the dialog to choose from.                
                int returnValue=fc.showOpenDialog(frame);    
// if the user chooses a file, then there's a return value and the file will be loaded.                
                if(returnValue == JFileChooser.APPROVE_OPTION){
// We hold the selected file so we can start making use of it.                    
                   File file = fc.getSelectedFile();
// We declare the variable "reader" of the FileReader type.                   
                FileReader reader = null;
                    try {
// We start reading the chosen file.                        
                        reader = new FileReader(file);
                    } catch (FileNotFoundException ex) {
                        java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                        int data = 0; 
                    try {
// To read the first data element at the file, the loop will depend on it.                       
                        data = reader.read();
                    } catch (IOException ex) {
                    }
// It will keep iterating till the end of the file.                    
                        while(data!=-1){
                            Code+=(char)data;

                        try { 
// To keep reading a different continous data for each iteration.                            
                            data= reader.read();
                        } catch (IOException ex) {
                        }
                        }
                        } 
                    else{
                            System.out.println("You chose no files");
                        }

                        return Code;}

}
 
