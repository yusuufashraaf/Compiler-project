/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcihcompiler;
 import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MatchedTable {
ArrayList<String>SpilitedCode;
ArrayList<String> Return_Tokens_List;
ArrayList<Integer>Indecies;
MatchedTable(ArrayList<String>Code,ArrayList<Integer>Indecies,String[]markrs,ArrayList<String> Return_Token){
SpilitedCode= new ArrayList <String>();
Return_Tokens_List=new ArrayList<String>();
Return_Tokens_List=Return_Token;
SpilitedCode=Code;
this.Indecies=Indecies;
}
MatchedTable(){
    
}
            public void Table () {
                
            int Row=SpilitedCode.size();
            String [][] marks=new String[Row][5] ;
            int k=0;
            for(int i=1;i<Indecies.size();i++){
            for(int j=Indecies.get(i-1);j<Indecies.get(i);j++){
            
// here making the data fill the table           
            marks[k][0]=i+"";
            marks[k][1]=SpilitedCode.get(j);
            marks[k][3]=((j-Indecies.get(i-1))+1)+"";
            marks[k][2]=Return_Tokens_List.get(j);
            if(marks[k][2]=="INVALID")
            {marks[k][4]="Not Matched";}
            else
            {
            marks[k][4]="Matched";
            }
            k++;
            }
            }
            
// here making table 
            String students[] = { "Line NO", "Lexeme", "Return Token", "Lexeme NO in \nLine", "matchability"};
            JTable table = new JTable(marks, students);
            Font font = new Font("Verdana", Font.PLAIN, 12);
            table.setFont(font);
            table.setRowHeight(30);
            JFrame frame = new JFrame();
            frame.setSize(600, 400);
            frame.add(new JScrollPane(table));
            frame.setVisible(true);
            }


// this function is to return the lexeme token 
            public void ReturnToken (String code){
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
            ArrayList <String> Return_token=new ArrayList<>();
//here we get the arr size in row to make table row            
            int Row=arr.size();
           
            String [] Tokens=new String[Row] ;
// here we make loop on arr to get the token, lexeme and is accepted or not            
            for (int i = 0 ; i < arr.size() ; i++){
            t2.isStartOfKeyWord(arr.get(i));
            Return_token.add(t2.Lexeme_or_Identifier());
            }
// here we pass the data to the table
            new MatchedTable(arr,s1.num_of_lines(),Tokens,Return_token).Table();
            }}


