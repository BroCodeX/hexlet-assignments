package exercise;


import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class Flat implements Home {
    private double area; // жилая площадь квартиры
    private double balconyArea; // площадь балкона
    private int floor; // этаж, на котором расположена квартира

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public int compareTo(Home flat) {
        return Double.compare(this.area, flat.getArea());
    }

    public String toString() {
        return String.format("Квартира площадью %s метров на %d этаже", getArea(), this.floor);
    }
}
// END
