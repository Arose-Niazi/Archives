import java.util.Stack;

public class InfixToPrefix {

    private Stack<Character> s;
    private String postfix;
    public InfixToPrefix(String infix)
    {
        infix = new StringBuilder(infix).reverse().toString();
        s = new Stack<>();
        postfix = new String();
        infix = "(".concat(infix);
        infix = infix.concat(")");
        //System.out.println("DEBUG: " + infix);

        for(char currentChar : infix.toCharArray())
        {
            if(isOperator(currentChar))
            {
                while(true)
                {
                    if(getPrecedence(s.peek()) >= getPrecedence(currentChar))
                    {
                        postfix+=s.pop();
                    }
                    else break;
                }

                s.push(currentChar);
                //System.out.print("\t Was Operator");
            }
            if(isBracket(currentChar))
            {
                s.push(currentChar);
                if(currentChar == ')') popTillBrace();
                //System.out.print("\t Was Bracket");
            }
            if(isOperand(currentChar))
            {
                postfix +=currentChar;
                //System.out.print("\t Was Operand");
            }
        }
        postfix = new StringBuilder(postfix).reverse().toString();
    }

    private void popTillBrace()
    {
        char x = ')';
        s.pop();
        do
        {
            x = s.pop();
            if(x != '(') postfix+=x;
        }
        while (x != '(');
    }
    private static boolean isOperator(char symbol)
    {
        if(symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*' || symbol == '^' || symbol == '%') return true;
        return false;
    }

    private static boolean isBracket(char symbol)
    {
        if(symbol == '('  || symbol == ')') return true;
        return false;
    }

    private static boolean isOperand(char symbol)
    {
        if(((int) symbol >= 65 && (int) symbol <= 90)  || ((int) symbol >= 97  && (int) symbol <= 122)) return true;
        return false;
    }

    private static int getPrecedence(char symbol)
    {
        if(symbol == '^') return 3;
        if(symbol == '/'  || symbol == '*' || symbol == '%') return 2;
        if(symbol == '+'  || symbol == '-') return 1;
        return 0;
    }

    public String getPrefix() {
        return postfix;
    }

    public static boolean isValidInfix(String infix)
    {
        int lastOperator=-1;
        for(char currentChar : infix.toCharArray())
        {
            if(isOperator(currentChar) )
            {
                if(lastOperator == 1) return false;
                lastOperator = 1;
            }
            if(isBracket(currentChar))
            {
                if(lastOperator == 2 || lastOperator == 3 || (lastOperator == 4 && currentChar == '(')) return false;
                if(currentChar == '(') lastOperator = 2;
                else lastOperator = 3;
            }
            if(isOperand(currentChar))
            {
                if(lastOperator == 4 || lastOperator == 3) return false;
                lastOperator = 4;
            }

        }
        return true;
    }
}
