public class Point {
    double x;
    double y;
    Point next;

    public Point(double _x, double _y) {
        x = _x;
        y = _y;
        next = null;
    }

    public Point(double _x, double _y, Point _next) {
        x = _x;
        y = _y;
        next = _next;
    }
}