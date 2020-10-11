public class Stacktest {
    public static void main(String [] args){
        Stack stack = new Stack();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        try{
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Chal oye");
        }

    }
}
