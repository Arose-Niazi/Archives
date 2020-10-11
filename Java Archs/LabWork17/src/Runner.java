import java.util.Scanner;

public class Runner {
    public static void main(String args[])
    {
        Graph StateCaptials = new Graph(7);

        Vertice austin = StateCaptials.addVertice("Austin");
        Vertice dallas = StateCaptials.addVertice("Dallas");
        Vertice washington = StateCaptials.addVertice("Washington");
        Vertice denver = StateCaptials.addVertice("Denver");
        Vertice atlanta = StateCaptials.addVertice("Atlanta");
        Vertice houston = StateCaptials.addVertice("Houston");
        Vertice chicago = StateCaptials.addVertice("Chicago");

        StateCaptials.setAdjacent(austin,dallas,200);
        StateCaptials.setAdjacent(austin,houston,800);
        StateCaptials.setAdjacent(dallas,austin,200);
        StateCaptials.setAdjacent(dallas,chicago,900);
        StateCaptials.setAdjacent(dallas,denver,780);
        StateCaptials.setAdjacent(washington,dallas,1300);
        StateCaptials.setAdjacent(washington,atlanta,600);
        StateCaptials.setAdjacent(denver,atlanta,1400);
        StateCaptials.setAdjacent(denver,chicago,1000);
        StateCaptials.setAdjacent(atlanta,washington,600);
        StateCaptials.setAdjacent(atlanta,houston,800);
        StateCaptials.setAdjacent(houston,atlanta,800);
        StateCaptials.setAdjacent(chicago,denver,1000);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the capital name: ");
        Vertice searchedCity = StateCaptials.searchVertice(input.nextLine());

        System.out.print("Enter the capital name to go: ");
        Vertice toCity = StateCaptials.searchVertice(input.nextLine());
        StateCaptials.depthFirstSearch(searchedCity,toCity);
        StateCaptials.breathFirstSearch(searchedCity,toCity);
    }
}
