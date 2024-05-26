import java.util.*;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heightInches = scanner.nextDouble();
        double weightKg = scanner.nextDouble();
        double age = scanner.nextDouble();
        String gender = scanner.next().toLowerCase();

        double bmi = calculateBMI(weightKg, heightInches);
        System.out.println("BMI: " + roundTwoDecimals(bmi));
        
        String bmiCategory = determineBMICategory(bmi);
        System.out.println("BMI Category: " + bmiCategory);
        
        double bodyFat = calculateBodyFat(bmi, gender, age);
        System.out.println("Body Fat %: " + roundTwoDecimals(bodyFat) + "%");
        
        String bodyFatCategory = determineBodyFatCategory(gender, bodyFat);
        System.out.println("Body Fat Category: " + bodyFatCategory);
    }

    public static double calculateBMI(double weightKg, double heightInches) {
        // Convert height from inches to meters
        double heightMeters = heightInches / 39.37;
        return weightKg / (heightMeters * heightMeters);
    }
    
    private static String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    
    public static double calculateBodyFat(double bmi, String gender, double age) { // Change the type to double
        double bodyFat = 0;
        if (age >= 18) {
            if (gender.equals("male")) {
                bodyFat = (1.20 * bmi) + (0.23 * age) - 16.2; 
            } else {
                bodyFat = (1.20 * bmi) + (0.23 * age) - 5.4;
            }
        } else {
            if (gender.equals("male")) {
                bodyFat = (1.51 * bmi) - (0.70 * age) - 2.2; 
            } else {
                bodyFat = (1.51 * bmi) - (0.70 * age) + 1.4;
            }
        }
        return bodyFat;
    }
    
    private static String determineBodyFatCategory(String gender, double bodyFat) {
        String category = "";
        if (gender.equals("male")) {
            if (bodyFat < 5) category = "Shredded";
            else if (bodyFat >= 6 && bodyFat <= 13) category = "Athletes";
            else if (bodyFat >= 13.1 && bodyFat <= 17) category = "Fitness";
            else if (bodyFat >= 17.1 && bodyFat <= 24) category = "Average";
            else if (bodyFat >= 24.1) category = "Obese";
        } else {
            if (bodyFat < 13) category = "Shredded";
            else if (bodyFat >= 14 && bodyFat <= 20) category = "Athletes";
            else if (bodyFat >= 20.1 && bodyFat <= 24) category = "Fitness";
            else if (bodyFat >= 24.1 && bodyFat <= 31) category = "Average";
            else if (bodyFat >= 31) category = "Obese";
        }
        return category;
    }

    private static double roundTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
