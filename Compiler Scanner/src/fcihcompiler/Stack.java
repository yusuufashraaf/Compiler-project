/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fcihcompiler;



public class Stack {
int myStackSize = 100; // initialize the size of stack to 100
public String[] myStack = new String[myStackSize]; // It will be stack of strngs
public int top = -1; // The top starts on -1

public void pushInStack(String fileContent) {
top += 1; // Increases the top by 1 everytime we push on it.
myStack[top] = fileContent; // assign the passed striing into the top of stack.

}

public String popFromStack() {
return myStack[top--]; // takes out a string from the top of the stack.
}

public boolean isStackFull() {
return (myStackSize - 1 == top); // Checks if the stack is full by checking if the size-1 equals to top or not.
}

public boolean isStackEmpty() {
return (top == -1); // once top reaches -1, that means that the stack is empty + the create stack implemention above proved that.
}

}