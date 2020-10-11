public class ComplicatedCode {
    public static void main(String args[])
    {
        boolean b[] = new boolean[52];
        b[26]=true;
        while(!b[b.length/2])
        {
            System.out.print("***");
        }
        int x=0;
        while (true)
        {
            if(++x < 5) System.out.print("A");
            else break;
        }
        for(x=b.length/2-2; x<b.length; x++)
        {
            if(b[x])
            {
                System.out.print("***");
                break;
            }
            else
                System.out.print("B");
        }

    }
}
