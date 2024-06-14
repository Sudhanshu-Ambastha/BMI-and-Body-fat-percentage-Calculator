import java.util.*;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heightInches = scanner.nextDouble();
        double weightKg = scanner.nextDouble();
        double age = scanner.nextDouble();
        double neck = scanner.nextDouble();
        double waist = scanner.nextDouble();
        double hipInches = scanner.nextInt();
        String gender = scanner.next().toLowerCase();

        double bmi = calculateBMI(weightKg, heightInches);
        System.out.println("BMI: " + roundTwoDecimals(bmi));
        
        String bmiCategory = determineBMICategory(bmi);
        System.out.println("BMI Category: " + bmiCategory);
        
        double bodyFat = calculateBodyFat(gender, waist, neck, heightInches, age, hipInches);
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
    
    public static double calculateBodyFat(String gender, double waist, double neck, double heightInches, double age, double hipInches) {
        double bodyFat = 0;
        if (age >= 18) {
            if (gender.equals("male")) {
                bodyFat =  86.010 * Math.log10(waist - neck) - 70.041 * Math.log10(heightInches) + 36.76;
            } else {
                // Assuming hip measurement is also required for females, let's add it to input
                bodyFat = 163.205 * Math.log10(waist + hipInches - neck) - 97.684 * Math.log10(heightInches) - 78.387;
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
