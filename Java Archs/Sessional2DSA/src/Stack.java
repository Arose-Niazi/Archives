import java.util.EmptyStackException;

public class Stack
{
    private int[] stack = new int[100];
    private int top = -1;

    public void push(int i)
    {

        if(top == 100) throw new StackOverflowError();
        stack[++top]=i;
    }

    public int pop()
    {
        if(!isEmpty())
        {
            return stack[top--];
        }
        else throw new EmptyStackException();
    }

    public int peek()
    {
        return stack[top];
    }

    public boolean isEmpty()
    {
        if(top == -1) return true;
        return false;
    }

    public String toString()
    {
        return stack.toString();
    }
}