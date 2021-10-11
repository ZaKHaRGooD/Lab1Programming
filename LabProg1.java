import static java.lang.Math.*;


public class LabProg1 {
    // проверка наличая числа а в заданном множестве
    public static boolean checkEntry(long checkedNumber) {
        if (checkedNumber == 3 || checkedNumber == 5 || checkedNumber == 6 || checkedNumber == 8 || checkedNumber == 14 || checkedNumber == 15 || checkedNumber == 16 || checkedNumber == 17 || checkedNumber == 18) {
            return true;
        }
        else return false;
    }

    // заполнение первого массива натуральными чилами от 3 до 21
    public static long[] arrayNaturalNumbers() {
        long[] naturalNumber = new long[18];
        int k = 3;
        for (int i = 0; i < naturalNumber.length; i++) {
            naturalNumber[i] = k;
            k++;
        }
        return naturalNumber;
    }

    // заполнение массива рандомными числами от -6.0 до 8.0
    public static double[] arrayRandomNumbers() {
        double[] randomNuber = new double[17];
        for (int i = 0; i < randomNuber.length; i++) {
            randomNuber[i] =  ( (random() * (8.00 - (-6.00))) + (-6.00) );
        }
        return randomNuber;
    }

    // Двумерный массив с элементами подсчитанными через формулы
    public static double[][] arrayCalculatedNumbers(long[] arrayLine, double[] arrayColumn) {
        double[][] calculatedNumber = new double[18][17];

        for (int i = 0; i < calculatedNumber.length; i++) {
            if (arrayLine[i] == 20){
                for (int j = 0; j < calculatedNumber[i].length; j++) {
                    double x = arrayColumn[j];
                    calculatedNumber[i][j] = pow(E, pow( (0.25 / (1 - pow( (0.75 * (x + 1)), x) )), tan(x) ) );         
                }
            }

            else if (checkEntry(arrayLine[i])) {
                for (int j = 0; j < calculatedNumber[i].length; j++) {
                    double x = arrayColumn[j];
                    calculatedNumber[i][j] =  tan(log( pow(2 * (PI / (PI / 2 + abs(x))), 2) ) );
                }
            }
            else {
                for (int j = 0; j < calculatedNumber[i].length; j++) {
                    double x = arrayColumn[j];
                    calculatedNumber[i][j] = pow( ((pow( 4 / (pow(E, x)), (cos(x) * sin(log(abs(x))) * (atan(cos(x)) + 0.5)))) / 2), (cos(sin(pow((x/2), 3)))));
                }
            }
        }
        return calculatedNumber;
    }

    public static void main(String[] args) {
        long[] naturalNumbers = arrayNaturalNumbers();
        double[] randomNumbers = arrayRandomNumbers();

        // вывод первого массива
        System.out.print("Array natural numbers: ");
        for (int i = 0; i < naturalNumbers.length; i++) {
            System.out.print(naturalNumbers[i] + " ");
        }
        System.out.println("\n");

        // вывод второго массива
        System.out.print("Array random numbers:");
        for (int i = 0; i < randomNumbers.length; i++) { 
            System.out.printf("%9.5f", randomNumbers[i]);
        }
        System.out.println("\n");
        
        // вывод третьего массива
        System.out.println("Numbers calculated by the formula:");
        for (double[] i : arrayCalculatedNumbers(naturalNumbers, randomNumbers)) {
            for (double j : i) {
                System.out.printf("%8.2f", j);
            }
            System.out.println();
        }
    }
}
