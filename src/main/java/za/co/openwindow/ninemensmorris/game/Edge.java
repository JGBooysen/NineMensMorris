package za.co.openwindow.ninemensmorris.game;

public class Edge {
    
    private Point pointA;
    private Point pointB;
    
    public Edge(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }
    
    public boolean isConnectedTo(Point point) {
        return point.equals(pointA) || point.equals(pointB);
    }
    
    public Point getOpposite(Point point) {
        if (point.equals(pointA)) {
            return pointB;
        } else if (point.equals(pointB)) {
            return pointA;
        } else {
            return null;
        }
    }
}
