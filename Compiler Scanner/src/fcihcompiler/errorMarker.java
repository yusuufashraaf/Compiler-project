/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author joe
 */
        public class errorMarker {
// here we make function that takes the wrong lexemes , its line and the text area to get code 
               public void ErrorMarker(ArrayList Wrong_tokens,int Lines,JTextArea TextArea) throws BadLocationException
        {
// here we took the text from text area            
        String Text=TextArea.getText();
        String token;
        int p0=0,p1=0;
// here we make the painter        
        Highlighter highlighter = TextArea.getHighlighter();
        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
/* here we take the line and search the all wrong lexemes int that line the we took the second line and do what we did first 
        until we get all wrong text highlighted 
        */
        for(int i=0;i<Lines;i++)
        {
        for(int j=0;j<Wrong_tokens.size();j++)
        {
        token=String.valueOf(Wrong_tokens.get(j));
        p0=Text.indexOf(token);
        if(p0!=-1)
        {
// here we invoke the function addHighlight that we send the start index po and the last index of the wrong lexemes and the painter           
        highlighter.addHighlight(p0, p0+token.length(), painter );
        p0=-1;}
        }}}
        
// this function to return the all wrong tokens     
                    public ArrayList ReturnToken (String code){
// here we make object of these classes to be able to access functions in these classes               
         ignoringComments t1 =new ignoringComments();
         TransitionTable t2 = new TransitionTable();
         Splitting s1 =new Splitting();
// here we split the code after cleaning it from comments spaces and new line             
         s1.Splitting(t1.cleancode(code));
// here to begin initialize these arrays in these functions           
         t2.Alphabet();
         t2.fillTransitionTable();
         t2.acceptableState();
 // here we make an array list that will have tokens            
         ArrayList <String> arr = s1.Split();
         ArrayList <String> Wrong_token=new ArrayList<>();
         ArrayList <String> Return_token=new ArrayList<>();
         String Word;
// here we make loop on arr to get the token, lexeme and is accepted or not   and is identifier or not          
         for (int i = 0 ; i < arr.size() ; i++){
         t2.isStartOfKeyWord(arr.get(i));
         Word=(t2.Lexeme_or_Identifier());
         Return_token.add(Word);
         if(Word=="INVALID")
         {Wrong_token.add(arr.get(i));
         }}        
         return Wrong_token;}
        
        public void totalErrors (String Code , JTextField jTextField){
            
                 ArrayList <String> NumberOfErrors = new ArrayList<>();
                errorMarker e = new errorMarker ();
                NumberOfErrors= e.ReturnToken(Code);
                jTextField.setText(String.valueOf(NumberOfErrors.size()));
        }
        }
          
            
            
        

