import java.util.Stack;

public class Graph {
    private Vertice[] VerticesArray;
    private int[][] Connections;
    private int vertices;
    private int lastIndex;

    private boolean[] visited;
    private Stack<Vertice> DepthFirstSearch;
    private Queue BreathFirstSearch;

    public Graph(int vertices) {
        this.vertices=vertices;

        lastIndex=0;
        VerticesArray = new Vertice[vertices];
        Connections = new int[vertices][vertices];
    }

    public Vertice addVertice(String name)
    {
        Vertice v = new Vertice(name);
        VerticesArray[lastIndex++] = v;
        return v;
    }

    public void setAdjacent(Vertice to,Vertice from, int distance)
    {
        int toIndex = getIndex(to);
        if(toIndex == -1)
        {
            System.out.println("Please enter valid starting vertice.");
            return;
        }
        int fromIndex = getIndex(from);
        if(fromIndex == -1)
        {
            System.out.println("Please enter valid ending vertice.");
            return;
        }
        Connections[toIndex][fromIndex] = distance;
    }

    private int getIndex(Vertice v)
    {
        for(int i=0; i<vertices; i++)
            if(VerticesArray[i] == v)
                return i;
        return -1;
    }

    public Vertice searchVertice(String name)
    {
        for(int i=0; i<vertices; i++)
        {
            if(name.equals(VerticesArray[i].name))
                return VerticesArray[i];
        }
        return null;
    }

    public void displayAdjacentVertices(Vertice v)
    {
        int index = getIndex(v);
        System.out.print("Adjacent Vertice/distance: ");
        for(int i=0; i<vertices; i++)
        {
            if(Connections[index][i] > 0)
            {
                System.out.print(VerticesArray[i].name + "/" + Connections[index][i] + "\t");
            }
        }
        System.out.println(" ");
    }


    public void depthFirstSearch(Vertice from, Vertice to)
    {
        DepthFirstSearch = new Stack<>();
        createResetVisited();
        System.out.print("\nDepth first search ** " + from.name + " --> " + to.name + " **\n\t");
        processDFS(from,to);
    }

    private void processDFS(Vertice from, Vertice to)
    {
        int index = getIndex(from);
        visited[index]=true;
        System.out.print("   --->   " + from.name);
        if(from.equals(to)) return;
        while (true)
        {
            int shortest=Integer.MAX_VALUE;
            int shortestIndex=-1;
            for(int i=0; i<vertices; i++)
            {
                if(Connections[index][i] > 0 && !visited[i] && index != i)
                {
                    if(shortest > Connections[index][i])
                    {
                        shortest = Connections[index][i];
                        shortestIndex = i;
                    }
                }
            }
            if(shortestIndex == -1) break;
            DepthFirstSearch.push(VerticesArray[shortestIndex]);
            visited[shortestIndex]=true;
        }
        processDFS(DepthFirstSearch.pop(),to);

    }

    public void breathFirstSearch(Vertice from, Vertice to)
    {
        BreathFirstSearch = new Queue(vertices);
        createResetVisited();
        System.out.print("\nBreath first search ** " + from.name + " --> " + to.name + " **\n\t");
        processBFS(from,to);
    }

    private void processBFS(Vertice from, Vertice to)
    {
        int index = getIndex(from);
        visited[index]=true;
        System.out.print("   --->   " + from.name);
        if(from.equals(to)) return;
        for(int i=0; i<vertices; i++)
        {
            if(Connections[index][i] > 0 && !visited[i])
            {
                BreathFirstSearch.enqueue(VerticesArray[i]);
                visited[i]=true;
            }
        }
        processBFS(BreathFirstSearch.dequeue(),to);
    }

    private void createResetVisited()
    {
        visited = new boolean[vertices];
        for(int i=0; i<vertices; i++)
            visited[i]=false;
    }
}
