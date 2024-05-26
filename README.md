# BMI and body fat percentage Calculator

## Description
The BMI Calculator is a Java program designed to calculate Body Mass Index (BMI), body fat percentage, and provide corresponding BMI and body fat categories based on user input for height, weight, age, and gender.

## Usage
1. Compile the `BMICalculator.java` file.
2. Run the compiled Java program.
3. Enter the required information when prompted:
   - Height (in inches)
   - Weight (in kilograms)
   - Age (in years)
   - Gender (either "male" or "female")
4. The program will then calculate and display the following:
   - BMI (Body Mass Index)
   - BMI Category (e.g., Underweight, Normal Weight, Overweight, Obese)
   - Body Fat Percentage
   - Body Fat Category (e.g., Shredded, Athletes, Fitness, Average, Obese)

## Formulas Used
The program employs the following formulas:
- BMI Calculation: weight / (height^2), where height is in meters and weight is in kilograms.
- Body Fat Percentage Calculation:
  - For adults (age 18 and above):
    - Male: (1.20 * BMI) + (0.23 * Age) - 16.2
    - Female: (1.20 * BMI) + (0.23 * Age) - 5.4
  - For adolescents (below 18 years old):
    - Male: (1.51 * BMI) - (0.70 * Age) - 2.2
    - Female: (1.51 * BMI) - (0.70 * Age) + 1.4

## Example inputs and outputs

Input:-
```
Height (in inches): 70
Weight (in kilograms): 61
Age (in years): 17
Gender (male/female): male
```
Output:-
```
BMI: 19.30
BMI Category: Normal Weight
Body Fat %: 10.87%
Body Fat Category: Fitness
```
