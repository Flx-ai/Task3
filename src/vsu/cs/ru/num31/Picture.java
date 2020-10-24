package vsu.cs.ru.num31;

public class Picture {

    private VerticalParabola parabola;
    private Line line;
    private Circle circle;

    public Picture(VerticalParabola parabola, Line line, Circle circle) {
        this.parabola = parabola;
        this.line = line;
        this.circle = circle;
    }

    public SimpleColor getColor(double x, double y) {

        if (circle.isPointInside(x,y) && (!line.isPointInside(x,y))) {
            return SimpleColor.ORANGE;
        }

        if (circle.isPointInside(x,y) && line.isPointInside(x,y)
                || (!line.isPointInside(x,y) && !parabola.isPointInside(x,y))) {
            return SimpleColor.WHITE;
        }

        if (line.isPointInside(x,y) && !circle.isPointInside(x,y)) {
            return  SimpleColor.YELLOW;
        }

        return SimpleColor.GREEN;
    }

}

