package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class Cottage implements Home {
    private double area; //Общая площадь коттеджа
    private int floorCount;

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home cottage) {
        return Double.compare(this.area, cottage.getArea());
    }

    public String toString() {
        return String.format("%d этажный коттедж площадью %s метров", this.floorCount, this.area);
    }
}
// END
