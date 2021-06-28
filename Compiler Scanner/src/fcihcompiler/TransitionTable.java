/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fcihcompiler;

/**
*
* @author joe
*/
        public class TransitionTable {
        public char LanguageAlphabet[] = new char [91] ;
        public int rowSize = 143, columnSize = 143, accSize = 20;
        public int[][] states = new int [999][999];
        public int acceptableState[] =new int [99999] ;
        public char [] token = new char[9999];
        public int currentState;
        public int lastState;
        public int spareState=0;
// here we fill the transition table with states
        public void fillTransitionTable() {
// Divisio Final = 37
        makeState(1, 'D', 31);
        makeState(31, 'i', 32);
        makeState(32, 'v', 33);
        makeState(33, 'i', 34);
        makeState(34, 's', 35);
        makeState(35, 'i', 36);
        makeState(36, 'o', 37);
// InferedFrom Final = 19
        makeState(1, 'I', 7);
        makeState(7, 'n', 10);
        makeState(10,'f', 11);
        makeState(11,'e', 12);
        makeState(12,'r', 13);
        makeState(13,'e', 14);
        makeState(14,'d', 15);
        makeState(15,'F', 16);
        makeState(16,'r', 17);
        makeState(17,'o', 18);
        makeState(18,'m', 19);

// WhetherDo final = 28
        makeState(1, 'W',20);
        makeState(20,'h',21);
        makeState(21,'e',22);
        makeState(22,'t',23);
        makeState(23,'h',24);
        makeState(24,'e',25);
        makeState(25,'r',26);
        makeState(26,'D',27);
        makeState(27,'o',28);
// Else Final = 85
        makeState(1, 'E',82);
        makeState(82,'l',83);
        makeState(83,'s',84);
        makeState(84,'e',85);
// Ire Final = 9
        makeState(1, 'I',7);
        makeState(7, 'r',8);
        makeState(8, 'e',9);
// Sire Final = 71
        makeState(1, 'S',61);
        makeState(61, 'i',69);
        makeState(69, 'r',70);
        makeState(70, 'e',71);
// Clo Final = 44
        makeState(1, 'C',38);
        makeState(38, 'l',43);
        makeState(43, 'o',44);
// SetOfClo final 68
        makeState(1, 'S',61);
        makeState(61, 'e',62);
        makeState(62, 't',63);
        makeState(63, 'O',64);
        makeState(64, 'f',65);
        makeState(65, 'C',66);
        makeState(66, 'l',67);
        makeState(67, 'o',68);
// FBU final = 60
        makeState(1, 'F',58);
        makeState(58, 'B',59);
        makeState(59, 'U',60);

// SFBU final = 74
        makeState(1, 'S',61);
        makeState(61, 'F',72);
        makeState(72, 'B',73);
        makeState(73, 'U',74);
// NoneValue final 101
        makeState(1, 'N',93);
        makeState(93,'o',94);
        makeState(94,'n',95);
        makeState(95,'e',96);
        makeState(96,'V',97);
        makeState(97,'a',98);
        makeState(98,'l',99);
        makeState(99,'u',100);
        makeState(100,'e',101);
// TerminateThisNow final 117
        makeState(1, 'T',102);
        makeState(102, 'e',103);
        makeState(103, 'r',104);
        makeState(104, 'm',105);
        makeState(105, 'i',106);
        makeState(106, 'n',107);
        makeState(107, 'a',108);
        makeState(108, 't',109);
        makeState(109, 'e',110);
        makeState(110, 'T',111);
        makeState(111, 'h',112);
        makeState(112, 'i',113);
        makeState(113, 's',114);
        makeState(114, 'N',115);
        makeState(115, 'o',116);
        makeState(116, 'w',117);
// RingWhen final 57
        makeState(1, 'R',50);
        makeState(50, 'i',51);
        makeState(51, 'n',52);
        makeState(52, 'g',53);
        makeState(53, 'W',54);
        makeState(54, 'h',55);
        makeState(55, 'e',56);
        makeState(56, 'n',57);
// BackedValue final 136
        makeState(1, 'B',126);
        makeState(126, 'a',127);
        makeState(127, 'c',128);
        makeState(128, 'k',129);
        makeState(129, 'e',130);
        makeState(130, 'd',131);
        makeState(131, 'V',132);
        makeState(132, 'a',133);
        makeState(133, 'l',134);
        makeState(134, 'u',135);
        makeState(135, 'e',136);
// STT final 76
        makeState(1, 'S',61);
        makeState(61, 'T',75);
        makeState(75, 'T',76);

// Check final 42
        makeState(1, 'C',38);
        makeState(38, 'h',39);
        makeState(39, 'e',40);
        makeState(40, 'c',41);
        makeState(41, 'k',42);

// CaseOf final 49
        makeState(1, 'C',38);
        makeState(38, 'a',45);
        makeState(45, 's',46);
        makeState(46, 'e',47);
        makeState(47, 'O',48);
        makeState(48, 'f',49);
        
// Beginning final 144
        makeState(1, 'B',126);
        makeState(126, 'e',137);
        makeState(137, 'g',138);
        makeState(138, 'i',139);
        makeState(139, 'n',140);
        makeState(140, 'n',141);
        makeState(141, 'i',142);
        makeState(142, 'n',143);
        makeState(143, 'g',144);
// End final 87
        makeState(1, 'E',82);
        makeState(82, 'n',86);
        makeState(86, 'd',87);

// + - * / final 118
        makeState(1, '+',118);
        makeState(1, '*',118);
        makeState(1, '/',118);
        makeState(1, '-',118);

// (&&,||,~) final 120
        makeState(1, '&',119);
        makeState(119,'&',120);
        makeState(1, '~',120);
        makeState(1, '|',119);
        makeState(119,'|',120);
// (= = , < , > ,!= ,>= , <= ) finals 77,80,78,79
        makeState(1, '=',77);
        makeState(77,'=',80);
        makeState(1, '<',78);
        makeState(78,'=',80);
        makeState(1, '>',79);
        makeState(79, '=',80);
        makeState(1, '!',81);
        makeState(81, '=',80);
// . final 121
        makeState(1, '.',121);
// {} [] final 122
        makeState(1, '{',122);
        makeState(1, '}',122);
        makeState(1, ']',122);
        makeState(1, '[',122);
// digits final 3
        makeState(1, '1',3);
        makeState(1, '2',3);
        makeState(1, '3',3);
        makeState(1, '4',3);
        makeState(1, '5',3);
        makeState(1, '6',3);
        makeState(1, '7',3);
        makeState(1, '8',3);
        makeState(1, '9',3);
        makeState(1, '0',3);
        makeState(3, '1',3);
        makeState(3, '2',3);
        makeState(3, '3',3);
        makeState(3, '4',3);
        makeState(3, '5',3);
        makeState(3, '6',3);
        makeState(3, '7',3);
        makeState(3, '8',3);
        makeState(3, '9',3);
        makeState(3, '0',3);

// " '
        makeState(1, '"',123);
        makeState(1, '\'',123);

//USING final 92
        makeState(1,'U',88);
        makeState(88,'s',89);
        makeState(89,'i',90);
        makeState(90,'n',91);
        makeState(91,'g',92);

// /# final 5
        makeState(1,'/',4);
        makeState(4,'#',5);

// /- final 6
        makeState(1,'/',4);
        makeState(4,'-',6);

//#/ final 30
        makeState(1,'#',29);
        makeState(29,'/',30);

//@ final 125
        makeState(1,'@',125);

//; final 124
        makeState(1,';',124);
        }
        
// here we fill the acceptable state to make switch on it to recognize the acceptable lexemes and recgonize the return token
        public void acceptableState() {
        acceptableState[0] = 37;
        acceptableState[1] = 19;
        acceptableState[2] = 28;
        acceptableState[3] = 85;
        acceptableState[4] = 9;
        acceptableState[5] = 71;
        acceptableState[6] = 44;
        acceptableState[7] = 68;
        acceptableState[9] = 60;
        acceptableState[10] = 74;
        acceptableState[11] = 101;
        acceptableState[12] = 117;
        acceptableState[13] = 57;
        acceptableState[14] = 136;
        acceptableState[15] = 76;
        acceptableState[16] = 42;
        acceptableState[17] = 49;
        acceptableState[18] = 144;
        acceptableState[19] = 87;
        acceptableState[20] = 118;
        acceptableState[21] = 120;
        acceptableState[22] = 77;
        acceptableState[23] = 80;
        acceptableState[24] = 78;
        acceptableState[25] = 79;
        acceptableState[26] = 121;
        acceptableState[27] = 122;
        acceptableState[28] = 3;
        acceptableState[29] = 123;
        acceptableState[30] = 5;
        acceptableState[31] = 6;
        acceptableState[32] = 30;
        acceptableState[33] = 125;
        acceptableState[34] = 124;
        acceptableState[35] = 4;
        acceptableState[36] = 92;}


         
        
// here we make switch case on the final states to recognize if it was lexeme, identifier or invalid and then return token
        public String returnTkoen(){
        String Return_token = "";
        switch (spareState)
        {
        case 37:
        Return_token="Class";
        break;

         case 19:
        Return_token="Inheritance";
        break;

         case 28:
        Return_token="Condition";
        break;

         case 85:
        Return_token="Condition";
        break;

         case 9:
        Return_token="Integer";
        break;

         case 71:
        Return_token="SInteger";
        break;

         case 44:
        Return_token="Character";
        break;

         case 68:
        Return_token="String";
        break;

         case 60:
        Return_token="Float";
        break;

         case 74:
        Return_token="SFloat";
        break;

         case 101:
        Return_token="Void";
        break;

         case 117:
        Return_token="Break";
        break;

         case 57:
        Return_token="Loop";
        break;

         case 136:
        Return_token="Return";
        break;

         case 76:
        Return_token="Struct";
        break;

         case 42:
        Return_token="Switch";
        break;

         case 49:
        Return_token="Switch";
        break;

         case 144:
        Return_token="Start Statement";
        break;

         case 87:
        Return_token="End Statement";
        break;

         case 118 :
        Return_token="Arithmetic Operation";
        break;

         case 120:
        Return_token="Logic operators";
        break;

         case 77:
        Return_token="Assignment operator";
        break;

         case 80:
        Return_token="relational operators";
        break;

         case 78:
        Return_token="relational operators";
        break;

         case 79:
        Return_token="relational operators";
        break;

         case 121:
        Return_token="Access Operator";
        break;

         case 122:
        Return_token="Braces";
        break;

         case 3:
        Return_token="Constant";
        break;

         case 123:
        Return_token="Quotation Mark";
        break;

         case 92:
        Return_token="Inclusion";
        break;

         case 5:
        Return_token="Comment";
        break;

         case 6:
        Return_token="Comment";
        break;

         case 30:
        Return_token="Comment";
        break;

         case 125:
        Return_token="Delimiter";
        break;

         case 124:
        Return_token="Delimiter";
        break;
        default:
        Return_token="INVALID";
        }
        return Return_token;
        }
        public boolean isStartOfKeyWord(String str) {
        // here we take the string and convert it to char to check each letter state
        token = str.toCharArray();
        currentState = 1;
        // we then loop on each letter and get its position in alphabet
        for (char letter : this.token) {
        int currentLetter = getI(letter);
        // here we make prevstate to check on the last state we make it equal to current state
        this.lastState = this.currentState;
        // we search on transition table by state and letter to get the current state
        this.currentState = this.states[currentState][currentLetter];
        // here we make the spareState to avoid any change on currentState to put it on switch case to get the return token
        spareState = currentState;}
        // here we invoke this function to check is it identifier, lexeme or invalid
        return true;
        }
// here we make function isAcc -> is Acceptable to check if it is acceptable or not
        public boolean isAcc() {
        for (int index = 0 ; index < 37; index++) {
        if (currentState == acceptableState[index] && currentState != 0) {
        return true;
        }}
        return false;}
 /* here we make the concept of filling transition table using (2d array (matrix)) we get the row and the column and put
        on it the state that it will go to it
*/
        public void makeState(int row, char col, int val) {
        int intCol = this.getI(col);
        if (row <= rowSize && intCol <= columnSize) {
        states[row][intCol] = val;
        }
        }
// here we take the char and return the position of it in the alphabet if found
        public int getI(char ch) {
        for (int i = 0; i < columnSize; i++) {
        if (ch == LanguageAlphabet[i]) {
        return i;
        }
        }
        return 0;
        }
// here we put our alphabet
        public void Alphabet(){
        LanguageAlphabet[1] = 'a';
        LanguageAlphabet[2] = 'B';
        LanguageAlphabet[3] = 'C';
        LanguageAlphabet[4] = 'c';
        LanguageAlphabet[5] = 'D';
        LanguageAlphabet[6] = 'd';
        LanguageAlphabet[7] = 'E';
        LanguageAlphabet[8] = 'e';
        LanguageAlphabet[9] = 'F';
        LanguageAlphabet[10] = 'f';
        LanguageAlphabet[11] = 'g';
        LanguageAlphabet[12] = 'h';
        LanguageAlphabet[13] = 'I';
        LanguageAlphabet[14] = 'i';
        LanguageAlphabet[15] = 'k';
        LanguageAlphabet[16] = 'l';
        LanguageAlphabet[17] = 'm';
        LanguageAlphabet[18] = 'N';
        LanguageAlphabet[19] = 'n';
        LanguageAlphabet[20] = 'O';
        LanguageAlphabet[21] = 'o';
        LanguageAlphabet[22] = 'R';
        LanguageAlphabet[23] = 'r';
        LanguageAlphabet[24] = 'S';
        LanguageAlphabet[25] = 's';
        LanguageAlphabet[26] = 'T';
        LanguageAlphabet[27] = 't';
        LanguageAlphabet[28] = 'U';
        LanguageAlphabet[29] = 'u';
        LanguageAlphabet[30] = 'V';
        LanguageAlphabet[31] = 'v';
        LanguageAlphabet[32] = 'W';
        LanguageAlphabet[33] = 'w';
        LanguageAlphabet[34] = '+';
        LanguageAlphabet[35] = '-';
        LanguageAlphabet[36] = '*';
        LanguageAlphabet[37] = '/';
        LanguageAlphabet[38] = '&';
        LanguageAlphabet[39] = '|';
        LanguageAlphabet[40] = '~';
        LanguageAlphabet[41] = '=';
        LanguageAlphabet[42] = '>';
        LanguageAlphabet[43] = '<';
        LanguageAlphabet[44] = '!';
        LanguageAlphabet[45] = '.';
        LanguageAlphabet[46] = '{';
        LanguageAlphabet[47] = '}';
        LanguageAlphabet[48] = ',';
        LanguageAlphabet[49] = '[';
        LanguageAlphabet[50] = ']';
        LanguageAlphabet[51] = '0';
        LanguageAlphabet[52] = '1';
        LanguageAlphabet[53] = '2';
        LanguageAlphabet[54] = '3';
        LanguageAlphabet[55] = '4';
        LanguageAlphabet[56] = '5';
        LanguageAlphabet[57] = '6';
        LanguageAlphabet[58] = '7';
        LanguageAlphabet[59] = '8';
        LanguageAlphabet[60] = '9';
        LanguageAlphabet[61] = '"';
        LanguageAlphabet[62] = '\'';
        LanguageAlphabet[63] = '#';
        LanguageAlphabet[64] = '-';
        LanguageAlphabet[65] = '@';
        LanguageAlphabet[66] = ';';
        LanguageAlphabet[67] = '_';
        LanguageAlphabet[68] = '\n';
        LanguageAlphabet[69] = ' ';
        LanguageAlphabet[70] = 'A';
        LanguageAlphabet[71] = 'b';
        LanguageAlphabet[72] = 'G';
        LanguageAlphabet[73] = 'H';
        LanguageAlphabet[74] = 'j';
        LanguageAlphabet[75] = 'J';
        LanguageAlphabet[76] = 'K';
        LanguageAlphabet[77] = 'L';
        LanguageAlphabet[78] = 'M';
        LanguageAlphabet[79] = 'p';
        LanguageAlphabet[80] = 'P';
        LanguageAlphabet[81] = 'Q';
        LanguageAlphabet[82] = 'q';
        LanguageAlphabet[83] = 'x';
        LanguageAlphabet[84] = 'X';
        LanguageAlphabet[85] = 'Y';
        LanguageAlphabet[86] = 'y';
        LanguageAlphabet[87] = 'z';
        LanguageAlphabet[88] = 'Z';
        LanguageAlphabet[89] = '(';
        LanguageAlphabet[90] = ')';
        }

        public String Lexeme_or_Identifier()
        {
        String token1="";
        int flag=0;
        if(isAcc()==true )
        {
        token1=returnTkoen();
        return token1;
        }
        else
        {
        if(token[0]>='a' && token[0]<='z' || token[0]>='A' && token[0]<='Z' || token[0]=='_')
        {
        for(int itterator=1;itterator<token.length;itterator++)
        {
        if(token[itterator]>='a' && token[itterator]<='z' || token[itterator]>='A' && token[itterator]<='Z' || token[itterator]=='_' || token[itterator]>='0' && token[itterator]<='9' )
        continue;
        else
        {flag=1;
        break;
        }

        }
        if(flag==0)
        {
        token1 = "Identifier";
        return token1; // DONEEEE
        }
        }

        else {
        token1 = returnTkoen(); // Invalid WORD
        }

        }

        return token1;

        }

        }