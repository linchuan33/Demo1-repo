import java.util.Scanner;

public class MetricConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Metric Converter!");
        System.out.println("Please input your query. For example, 1 km = m.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            System.out.print("Enter your conversion query: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit") || input.equals("-1")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                handleConversion(input);
            }
        }

        scanner.close();
    }

    private static void handleConversion(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 4 || !parts[2].equals("=")) {
            System.out.println("Invalid input format. Please use the format: 1 unit1 = unit2");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid numerical value. Please provide a valid number.");
            return;
        }

        String unitFrom = parts[1];
        String unitTo = parts[3];

        double result = convert(value, unitFrom, unitTo);
        if (result >= 0) {
            System.out.println(value + " " + unitFrom + " = " + result + " " + unitTo);
        } else {
            System.out.println("Conversion not supported or invalid units.");
        }
    }

    private static double convert(double value, String unitFrom, String unitTo) {
        // Implement your conversion logic here for supported conversions.
        if (unitFrom.equals("kg") && unitTo.equals("lb")) {
            return value * 2.20462;
        } else if (unitFrom.equals("g") && unitTo.equals("oz")) {
            return value * 0.035274;
        } else if (unitFrom.equals("km") && unitTo.equals("mi")) {
            return value * 0.621371;
        } else if (unitFrom.equals("mm") && unitTo.equals("in")) {
            return value * 0.0393701;
        }
        return -1; // Unsupported conversion or invalid units.
    }
}
