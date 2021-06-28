/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import java.awt.event.KeyEvent;
import javax.swing.JTextArea;

/**
 *
 * @author joe
 */
public class lineNumbering {
    public static int lineNumber = 2;
    // here display text is a function that take the key release event and text area1 that we will type on it and text area2 which we will append the line number on it if 
     public static void displayLineNumbering(KeyEvent e , JTextArea jTextArea1 , JTextArea jTextArea2  ){
      String   txt = jTextArea1.getText();
        if( e.getKeyCode() == KeyEvent.VK_ENTER){
        jTextArea2.append("\n" + lineNumber + "- ");
        lineNumber++;
        }
     }
          public int lineNumbering(JTextArea jTextArea1 ){
              int line = 1 ;
              String code = jTextArea1.getText();
              for(int i = 0 ; i< code.length() ;i++){
                  if(code.charAt(i)=='\n'){
                      line++;
                  }
              }
              return line;
          }
//here to set line again to 2 when clear button is pressed          
public void setLineNumber(){
    lineNumber=2;
}
}
