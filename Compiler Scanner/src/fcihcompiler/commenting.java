/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import javax.swing.JTextArea;

/**
 *
 * @author joe
 */
public class commenting {
        static int []cursorPosition = new int [9999];
        static int cursorArrayIterator = 1;
        static int currentCaretPosition;
      static String getTextFromTextAreaForComment;
      /* in this function i take the textarea text in string and if there is new line so it is (the beginning of the line) and i put its index in array to know all 
      the beginning of all lines ( currentPoisition [] array ). i started cursorArrayIterator from 1 because 0 index has new line so i put it manually then it adds
        from the index 1. then i get the caret position and compare along the cursorPosition array if its position bigger than cursorPosition array and less than its next
        so we put the (/-) in the position of its less position.
      */
       public static void comment ( JTextArea jTextArea1){
            fillCursorPositionArray(jTextArea1);
// comparing its position in the cursor array
             for(int x= 0 ; x < getTextFromTextAreaForComment.length()  ; x++ ){
// if the current cursor position > position in array and less than the next position in the array put /- in the first position 
                 if(currentCaretPosition >= cursorPosition[x] && currentCaretPosition < cursorPosition[x+1] ){
                      jTextArea1.insert("/-",cursorPosition[x]); 
                      currentCaretPosition=0;
                      cursorArrayIterator=1;
                      break;}           
// here to make comment in the last line because its next will be 0 so if the next is 0 so it makes comment as 0 is in the first line only
                 if(currentCaretPosition >= cursorPosition[x] && cursorPosition[x+1] == 0 ){
                      jTextArea1.insert("/-",cursorPosition[x]);
                      currentCaretPosition=0;
                      cursorArrayIterator=1;
                       break;
                        }}currentCaretPosition=0;}
 //-------------------------------------------------------------------------------------------------------------------------------------------------
                
public static void unComment( JTextArea jTextArea1)
               {
            fillCursorPositionArray(jTextArea1);
                 
            for(int i=0;i<getTextFromTextAreaForComment.length()  ;i++)
               {
                  if(currentCaretPosition >= cursorPosition[i] && currentCaretPosition < cursorPosition[i+1] )
               {
                     if(getTextFromTextAreaForComment.charAt(cursorPosition[i]) == '/' && getTextFromTextAreaForComment.charAt(cursorPosition[i]+1)=='-')
                        {jTextArea1.replaceRange("",cursorPosition[i] ,cursorPosition[i]+2);
                        currentCaretPosition=0;
                        cursorArrayIterator=1;
                        break;}}
                        
                  if(currentCaretPosition >= cursorPosition[i] && cursorPosition[i+1] == 0 ){
                     if(getTextFromTextAreaForComment.charAt(cursorPosition[i]) == '/' && getTextFromTextAreaForComment.charAt(cursorPosition[i]+1)=='-')
                            {jTextArea1.replaceRange("",cursorPosition[i] ,cursorPosition[i]+2);
                            currentCaretPosition=0;
                            cursorArrayIterator=1;
                            break;}}}}   

       
public static void  fillCursorPositionArray (JTextArea jTextArea1 ){
  //initialize the cursorPosition to 0 because its static above 
            cursorPosition[0]=0;
            cursorArrayIterator=1;               
// getting textarea text in string
                        getTextFromTextArea(jTextArea1);
        for(int i = 1 ; i < getTextFromTextAreaForComment.length() ; i++){
                 if(getTextFromTextAreaForComment.charAt(i) == '\n'){
                         cursorPosition[cursorArrayIterator] = (i+1);
                         cursorArrayIterator++;}}               
//get the caret position
                  currentCaretPosition = jTextArea1.getCaretPosition();
}
public static String getTextFromTextArea(JTextArea jTextArea1){
               return  getTextFromTextAreaForComment = jTextArea1.getText();
}}

