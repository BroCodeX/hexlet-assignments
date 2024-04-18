package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Вычисление окончено");
    }
}
// END
