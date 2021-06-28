/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;

import java.awt.Color;
import java.awt.TextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class AutoComplete  {
    char [] code;
    // here we initialize the array of lexemes to add them in the combo box
    private  String[] LexemesArray = {"Sire","Ire", "Divisio","InferedFrom","WhetherDo","Else","Clo","SetOfClo","FBU","SFBU","NoneValue","TerminateThisNow","RingWhen","BackedValue","STT","Check","CaseOf"
    ,"Beginning","END","Using","+","-","*","/","&","|","~","=","<",">","!",".","{","}","[","]","","'","#","-","@",";"};
    
// this function is used to put the lexemes in the the combo box
    public void autoComplete(JComboBox combobox , JTextArea jTextArea ){
        for(int i =0 ; i<LexemesArray.length ; i++){
          combobox.addItem(LexemesArray[i]);}}
// this function to put the selected lexeme in text area
    public void AutoComplete(JComboBox jComboBox1 , JTextArea jTextArea1){
        
// here we take the lexeme in string 
                String lexeme = String.valueOf(jComboBox1.getSelectedItem());
// here we make array of char to take the all lexemes with different length and to ignore the un important chars               
                char []neededLexeme = new char[30] ;
// here we loop on lexemes length until we find the BACKSPACE and then add the char of the lexeme in neededLexeme               
                for(int i = 0 ; i< lexeme.length() ; i++){
                    if(lexeme.charAt(i) == ' '){
// here we loop on lexeme length to convert it to string                        
                for(int o = 0 ; o < lexeme.length()-1; o++){
                     neededLexeme[o]+=lexeme.charAt(o);
                    }
                for (int z=0 ; z< lexeme.length()-1 ; z++)
// here to add the needed lexeme only with no more spaces                   
                    jTextArea1.append(String.valueOf(neededLexeme[z]));
// here to initialize the lexeme string again              
               lexeme = "";}}}}
                    
                
    
   
    
    

