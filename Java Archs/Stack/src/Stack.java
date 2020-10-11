import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stack = new ArrayList<Integer>();

    void push(int x){
        stack.add(x);
    }

    public int pop(){
        if(stack.size()<0)
            throw new ArrayIndexOutOfBoundsException();
        else
        return stack.remove(stack.size()-1);
    }
}
