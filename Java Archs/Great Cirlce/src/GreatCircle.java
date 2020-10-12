public class GreatCircle {

    public static void main(String args[])
    {
        Double x1 = Math.toRadians(new Double(args[0]));
        Double y1 = Math.toRadians(new Double(args[1]));
        Double x2 = Math.toRadians(new Double(args[2]));
        Double y2 = Math.toRadians(new Double(args[3]));

        double distance = 2 * 6371 * Math.asin(Math.sqrt( Math.pow( Math.sin((x2-x1)/2),2.0) + (Math.cos(x1)*Math.cos(x2)*Math.pow( Math.sin((y2-y1)/2),2.0))));
        System.out.println(distance + " KM");
    }
}
