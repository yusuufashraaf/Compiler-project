/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;


/**
 *
 * @author joe
 */

public class ignoringComments extends commenting {
        public  String code;
// here we make the function take the code as paramater of the function
            public  void removeComments() {
// here we initialize the codeAfterRemovingComments
            String codeAfterRemovingComments = "";
        
// here we loop on the length of the code 
              for (int i = 0; i < (int) code.length() ; i++) {           
// here if we found /# we skip 2 characters by adding 2 to i
                if (this.code.charAt(i) == '/' && this.code.charAt(i + 1) == '#') {
                codeAfterRemovingComments += this.code.charAt(i);
                codeAfterRemovingComments += this.code.charAt(i+1);
                i += 2;                          
/* here we make loop from the i to the other lines of the code until we found #/ to ignore the multiple line and
                 if we found the #/ we break and add 2 character to i to skip #/ and if we found #/ we increase the i by 
                one until reaching the comment part to remove it
*/
               while (i < (int) this.code.length() - 1  ) {
                    if(this.code.charAt(i) == '\n'){
                    codeAfterRemovingComments += this.code.charAt(i);
                } 
                    if(this.code.charAt(i)=='#'&&this.code.charAt(i+1)=='/')
                            {
                          codeAfterRemovingComments += this.code.charAt(i);
                          codeAfterRemovingComments += this.code.charAt(i+1);
                    break;
                    }
                    i++;
                }
                i += 2;
            }        
            // here we found /- we loop on the code until we reach the new line to remove the rest of the line            
             if (i < (int) this.code.length() - 1 && this.code.charAt(i) == '/' && this.code.charAt(i + 1) == '-' ) {
                codeAfterRemovingComments += this.code.charAt(i);
                codeAfterRemovingComments += this.code.charAt(i+1);
                while (i < (int) this.code.length() - 1  ) {
                    i++;
                    if(this.code.charAt(i) == '\n'){
                    codeAfterRemovingComments += this.code.charAt(i);
                    break;
                    }
                    
                }
                
            } else {
                if(i < (int) this.code.length() ){
                codeAfterRemovingComments += this.code.charAt(i);
                }
            }
        }
// here we make the code take the code after removing comments
        code = codeAfterRemovingComments;
            }
    
// this function to remove the unwanted space like if ("hello     world")  it will make it ("hello world")
    public  void remove_spaces() {
// here to be able to remove from strings
        StringBuilder sb = new StringBuilder(String.valueOf(code));
// here to make the new string have only the new code after removing un wanted spaces
        StringBuilder sb1 = new StringBuilder();
/* here we loop on the code length until we find the space and not the end line space and check if the next char has 
        space we continue to ignore it and then we go out putting the important char on sb1      
        */
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' && i != sb.length() - 1) {
                if (sb.charAt(i + 1) == ' ') {
                    continue;
                }
            }
            sb1.append(sb.charAt(i));
        }
// here we check if the last char has space we delete it 
        if (sb1.charAt(sb1.length() - 1) == ' ') {
            sb1.deleteCharAt(sb1.length()-1);
        }
// here we make code = new code after removing comment and spaces to remove new line also
        code = String.valueOf(sb1);}


// this function to remove the more unwanted new lines
    public void remove_newLines( ){
// here we initialize the string to empty
        String afterRemovingNewLine = "";
        int i = 0;
// hew we check if the first cahr is new line we initialize i to 1
        if(code.charAt(0)=='\n')
            i=1;
/* here we move on the code line until we find the new line and check if the next char is new line we continue
        and if the next char is not new line we then we add the char in the line to the string afterRemovingNewLine
        */
        for ( ; i < code.length()-1; i++) {
          if((this.code.charAt(i) == '\n' && this.code.charAt(i+1) == '\n')||(this.code.charAt(i) == '\r')){
             continue;
            }
            afterRemovingNewLine+= code.charAt(i);
        }
// here we add the last char to the string
        afterRemovingNewLine+=code.charAt(code.length()-1);
// we make code have the string afterRemovingNewLine to return it to use it in another funtions
        code = afterRemovingNewLine;
    }
     
// here the function that return the clean code after we invoke the all previous functions        
           public String  cleancode(String Code){
               code = Code;
              remove_newLines();
              removeComments ();
               remove_spaces();
               return code;
           }}
           
           
