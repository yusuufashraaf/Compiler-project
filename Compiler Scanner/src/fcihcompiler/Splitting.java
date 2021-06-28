/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fcihcompiler;



import java.util.ArrayList;



/**
*
* @author joe
*/
public class Splitting {

        String file_content;
        private ArrayList<Integer> NewLines;
        public void Splitting(String file_content){
        this.NewLines = new ArrayList<>();
        this.file_content=file_content;
        }
                public ArrayList <String> Split(){
//start of function
                NewLines.add(0);
                ArrayList<String> All_tokens = new ArrayList<>();
                String lexem ="";
                for(int i=0; i<file_content.length()-1;i++){
//to check is it letter or digit

                if((file_content.charAt(i) >= 'a' && file_content.charAt(i) <= 'z') || (file_content.charAt(i) >= 'A' && file_content.charAt(i) <= 'Z') || (file_content.charAt(i)>='0' && file_content.charAt(i)<='9')){
                lexem+=file_content.charAt(i);
                }

                else {
//to add string that has lexem if it not empty
                if(lexem!=""){
                All_tokens.add(lexem);
                lexem="";
                }

//to add special char in array list
                if(file_content.charAt(i)!='\n'){
                if(file_content.charAt(i)!=' '){
                lexem+=file_content.charAt(i);

//to check if it == or <= or >= or && or ||
                if(file_content.charAt(i+1)=='=' || file_content.charAt(i+1)=='|' || file_content.charAt(i+1)=='&' || file_content.charAt(i+1)=='-' || file_content.charAt(i+1)=='#' || file_content.charAt(i+1)=='/'){
                if(file_content.charAt(i)=='<'||file_content.charAt(i)=='>'||file_content.charAt(i)=='&'||file_content.charAt(i)=='|'||file_content.charAt(i)=='=' || file_content.charAt(i)=='/' || file_content.charAt(i)=='#'){
                lexem+=file_content.charAt(i+1);//to add = with the first = in one string
                i++;}
                }
//to add special chars
                All_tokens.add(lexem);
                lexem="";
                }
                }else{
//to add in array the index of last element of each line
                NewLines.add(All_tokens.size());
                }
                }
//to add final char in string to array list
                if(i==file_content.length()-2){
                if((file_content.charAt(i+1) >= 'a' && file_content.charAt(i+1) <= 'z') || (file_content.charAt(i+1) >= 'A' && file_content.charAt(i+1) <= 'Z') || (file_content.charAt(i+1)>='0' && file_content.charAt(i+1)<='9')){
                lexem+=file_content.charAt((file_content.length())-1);
                All_tokens.add(lexem);
                }
                else{
                if(lexem!=""){
                All_tokens.add(lexem);
                lexem="";
                }
                lexem+=file_content.charAt((file_content.length())-1);
                All_tokens.add(lexem);
                }
                NewLines.add(All_tokens.size());
                }
                }
                return All_tokens;}
                
//function to return array that content where
        public ArrayList<Integer> num_of_lines(){

        return NewLines;
        }

        }