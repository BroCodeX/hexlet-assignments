package exercise;

import java.lang.Math;

// BEGIN
class Circle {
    Point point;
    int radius;
    private final double PI = Math.PI;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius =radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public Double getSquare() throws NegativeRadiusException {
        if (this.radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        } else {
            return PI * (radius * radius);
        }
    }
}
// END
