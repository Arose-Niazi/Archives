package Another;

public class EquationChecker {

    private String equation;
    private int parenthCount;
    private char variablesName[] = new char[2];
    private char variablesValue[] = new char[2];



    public EquationChecker(String equation) {
        this.equation = equation;
        parenthCount = 0;

        variablesName[0]='p';
        variablesValue[0]='T';

        variablesName[1]='q';
        variablesValue[1]='F';

        if(!isValidExpression()) throw new IllegalArgumentException("Invalid Equation");
        simplify();
        innerMostEquation();
    }

    private static boolean isAnOperator(char c) {
        switch (c) {
            case '*':
            case '>':
            case '+':
            case '-':
            case '<':
                return true;
            default:
                return false;
        }
    }
    private static boolean isVariable(char c){
        switch (c) {
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 'T':
            case 'F':
                return true;
            default:
                return false;
        }
    }

    private boolean isValidExpression() {
        if (isAnOperator(equation.charAt(0)) || isAnOperator(equation.charAt(equation.length() - 1))) {
            return false;
        }
        int openParenthCount = 0;
        boolean lastWasOp = false;
        boolean lastWasOpen = false;

        for (char c : equation.toCharArray()) {
            if(c == ' ') continue;
            if (c == '(') {
                openParenthCount++;
                lastWasOpen = true;
                continue;
            } else if (c == ')') {
                if (openParenthCount <= 0 || lastWasOp) {
                    return false;
                }
                openParenthCount--;
                parenthCount++;
            }else if (isAnOperator(c)){
                if (lastWasOp || lastWasOpen) return false;
                lastWasOp = true;
                continue;
            }else if(!isVariable(c)){
                return false;
            }
            lastWasOp = false;
            lastWasOpen = false;
        }
        if(openParenthCount != 0) return false;
        if(lastWasOp || lastWasOpen) return false;
        return true;
    }

    private void simplify() {
        for(int i = 0; i<variablesName.length; i++)  equation = equation.replace(variablesName[i],variablesValue[i]);
        equation = equation.replaceAll("\\s+","");
        System.out.println("Simplified: " + equation);
    }


    private void innerMostEquation()
    {
       while(parenthCount > 0)
       {
           int start = 0, end;
           start = equation.lastIndexOf('(');
           end = equation.indexOf(')', start) + 1;
           if(solve(equation.substring(start,end)))
           {
               equation = equation.substring(0,start) + 'T' + equation.substring(end);
               parenthCount--;
           }
       }
       System.out.println("Solved Brackets Main: "+ equation );
       solveFunctions();
    }

    private boolean solve(String equation)
    {
        System.out.println("Main: "+ this.equation + "Part: " + equation);
        return true;
    }

    private boolean solveFunctions()
    {
        int x[] = new int[2];
        while (equation.length() > 1)
        {
            x = getNextExpression();
            if(solve(equation.substring(x[0],x[1])))
            {
                equation = equation.substring(0,x[0]) + 'T' + equation.substring(x[1]);
            }
        }
        System.out.println("After solving Main: " + equation);
        return true;
    }

    private int[] getNextExpression() {
        int[] x = new int[2];
        int y = 0;

        for (int z = 0; z < equation.length(); z++) {
            if (isVariable(equation.charAt(z))) {
                x[y++] = z;
            }
            if (y > 1) break;
        }
        x[1]++;
        return x;
    }
}
