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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
 
public class Using {
String CodeToBeReturned;
public Using (){
}
private boolean CheckIfUsing(String code){
    if(code.length() >= 5)
if(code.charAt(0)=='U'&&code.charAt(1)=='s'&&code.charAt(2)=='i'&&code.charAt(3)=='n'&&code.charAt(4)=='g'){
    
return true;
}
return false;
}
 public String ReturnCode(){
    return CodeToBeReturned;
}
 
public String FileNameReturner(String Code){
String fileName="";
StringBuilder sb = new StringBuilder(Code);
if(CheckIfUsing(Code)){
for (int i = 6; i < Code.length(); i++) {
    if(Code.charAt(i)=='\n'){
      sb.delete(6,i);
        break;
    }
fileName += Code.charAt(i);
}
}
Code=sb.toString();
CodeToBeReturned=Code;
return fileName;
}

public void using(JTextArea jTextArea1, String CodeFromJtextArea ){
MatchedTable f =new MatchedTable();
ignoringComments i = new ignoringComments();
 String theCode="";
 int data=0;

 if(CheckIfUsing(CodeFromJtextArea)){
while(CheckIfUsing(CodeFromJtextArea) )
{
String F="";
String File_content="";
String filename=FileNameReturner(CodeFromJtextArea);

FileReader reader =null;
try {
reader = new FileReader(filename);
} catch (FileNotFoundException ex) {
data=-1;
}
 
 
try {
if(reader != null){
while((data=reader.read())!=-1 && reader != null)
{
File_content+=(char) data;
}
}
} catch (IOException ex) {
break;
}
 
CodeFromJtextArea=File_content;
theCode +=CodeToBeReturned;
theCode+="\n";

}
StringBuilder removeTheLast = new StringBuilder(theCode);
removeTheLast.deleteCharAt(theCode.length()-1);
theCode = removeTheLast.toString();
 jTextArea1.setText(ignoreTheFirstLine(theCode));}

}
 public String ignoreTheFirstLine(String Code){
StringBuilder sb = new StringBuilder(Code);
for (int i = 0; i < Code.length(); i++) {
    if(Code.charAt(i)=='\n'){
      sb.delete(0,i+1);
        break;
    }
    Code=sb.toString();

}    return Code;}
 }