package vsu.cs.ru.num31;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Picture picture = new Picture(new VerticalParabola(5,1,-1), new Line(0,3,0),
                                        new Circle(-6,4,2));
        
        if (runTests(picture) == false) {
            System.out.println("\n" + "There are errors in program");
            return;
        }

        double x = readCoordinate('x');
        double y = readCoordinate('y');
        SimpleColor color = picture.getColor(x,y);
        printColorForPoint(x, y, color);
    }

    private static boolean runTests(Picture picture) {

        SimpleColor[] correctResultsArray = {SimpleColor.GREEN, SimpleColor.ORANGE, SimpleColor.WHITE,
                SimpleColor.YELLOW, SimpleColor.GREEN, SimpleColor.WHITE};

        Point[] arrayOfCoordinate = {new Point(5.3, 0.5), new Point(-6, 2.5), new Point(-7, 4),
                new Point(8, 5), new Point(3, -9), new Point(-6, 5) };

        boolean result = true;

        for (int i = 0; i < arrayOfCoordinate.length; i++) {
            SimpleColor currentResults = picture.getColor(arrayOfCoordinate[i].getX(), arrayOfCoordinate[i].getY());
            SimpleColor correctResults = correctResultsArray[i];

            if (currentResults == correctResults) {
                printTest(arrayOfCoordinate[i].getX(), arrayOfCoordinate[i].getY(), currentResults, correctResults, "successful");
            } else {
                printTest(arrayOfCoordinate[i].getX(), arrayOfCoordinate[i].getY(), currentResults, correctResults, "wrong");
                result = false;
            }
        }
        return result;
    }

    private static void printTest (double x, double y, SimpleColor currentResults, SimpleColor correctResults, String testResult) {
        System.out.printf("For coordinates (%.1f; %.1f) the result is %s: %s is %s \n", x, y, testResult, currentResults, correctResults);
    }

    private static double readCoordinate(char name){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %S: ", name);
        return scanner.nextDouble();
    }

    private static void printColorForPoint(double x, double y, SimpleColor color) {
        System.out.printf("(%.1f, %.1f) -> %S%n", x, y, color);
    }
}
