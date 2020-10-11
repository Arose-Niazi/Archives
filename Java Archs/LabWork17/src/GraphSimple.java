import java.util.Scanner;
import java.util.Stack;

public class GraphSimple {

    public static void main(String args[])
    {
        GraphSimple StateCaptials = new GraphSimple();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the capital name: ");
        int sc = StateCaptials.search(input.nextLine());

        System.out.print("Enter the capital name to go: ");
        int toCity = StateCaptials.search(input.nextLine());
        StateCaptials.breathFirstSearch(sc,toCity);
    }
    String cities[] = new String[7];
    int con[][] = new int[7][7];

    private boolean[] visited;
    private Stack<String> DepthFirstSearch;
    private QueueString BreathFirstSearch;

    public GraphSimple()
    {
        cities[0] = "Austin";
        cities[1] = "Dallas";
        cities[2] = "Washington";
        cities[3] = "Denver";
        cities[4] = "Atlanta";
        cities[5] = "Houstan";
        cities[6] = "Chicago";

        con[0][1]=200;con[0][5]=800;con[1][0]=200;con[1][6]=900;con[1][3]=780;con[2][1]=1300;
        con[2][4]=600;con[3][4]=1400;con[3][6]=1000;con[4][2]=600;con[4][5]=800;con[5][4]=800;
        con[6][3]=1000;
    }

    public int search(String name)
    {
        for(int i=0; i<7; i++)
        {
            if(name.equals(cities[i]))
                return i;
        }
        return -1;
    }

    public void breathFirstSearch(int from, int to)
    {
        BreathFirstSearch = new QueueString(7);
        visited = new boolean[7];
        for(int i=0; i<7; i++)
            visited[i]=false;
        System.out.println("\nBreath first search " + cities[from] + " to " + cities[to] + ":");
        processBFS(from,to);
    }

    private void processBFS(int from, int to)
    {
        visited[from]=true;
        System.out.println("\t" + cities[from]);
        if(from == to) return;
        for(int i=0; i<7; i++)
        {
            if(con[from][i] > 0 && !visited[i])
            {
                BreathFirstSearch.enqueue(cities[i]);
                visited[i]=true;
            }
        }
        processBFS(search(BreathFirstSearch.dequeue()),to);
    }

}
