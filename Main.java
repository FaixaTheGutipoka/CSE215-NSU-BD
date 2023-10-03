import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        populationProjection();
        //comfortIndexMath();
        //favouriteLanguageLetters();
    }

    public static void populationProjection() {
        //variable declaration

        int minutes = 60*24*365; //minutes per year
        //we are not considering the leap years

        double birth_rate = minutes ; // 1 birth per minute. Calculating birth per year
        double death_rate = minutes/2.0; // 1 death per 2 minutes. Calculating death per year
        double migration_rate = minutes/8.0; // 1 migration per 8 minutes. Calculating migration per year
        double current_population = 169356251; //Est. 2021
        double change = birth_rate-death_rate-migration_rate; //total change per year
        System.out.println(change);

        System.out.println("Year\tPopulation");
        for (int i = 1; i <= 5; i++) {
            /*
             we are calculating the net change of population per year.

             Step 1: net change = birth rate - death rate + migration rate (as migration has been declared as negative int
             Step 2: Multiply the net change with total minutes that has passed
             Step 3: Finally multiplying the net change with current population

             */
            double current_population_final = current_population*(Math.pow((1+(change/current_population)),i));
            //We have formatted the console output for better presentation
            System.out.println(" " + i + "\t\t" +  (int)(Math.round(current_population_final)));
        }
    }

    public static void comfortIndexMath() {
        Scanner a = new Scanner(System.in);

        // we are taking all the user inputs as per the variables mentioned in the question
        System.out.print("\nEnter a degree in Fahrenheit: ");
        double T = a.nextDouble(); // T = Temperature in Fahrenheit

        System.out.print("Enter the relative humidity in percentage (i.e. decimal point): ");
        double RH = a.nextDouble(); // RH = Relative Humidity

        System.out.print("Enter the wind speed (greater than or equal to 2): ");
        double V = a.nextDouble(); // V = Wind speed


        // here we used the formulae that was given in the question paper
        double Tf = 35.74 + 0.6215 * T - 35.75 * Math.pow(V, 0.16) + 0.4275 * T * Math.pow(V, 0.16); // Tf = feels like temperature
        double Comfort_Index = -42.379 + 2.04901523 * Tf + 10.14333127 * RH - 0.22475541 * Tf * RH - 6.83783e-3 * Math.pow(Tf, 2) - 5.481717e-2 * Math.pow(RH, 2) + 1.22874E-3 * Math.pow(Tf, 2) * RH + 8.5282E-4 * Tf * Math.pow(RH, 2) - 1.99E-6 * Math.pow(Tf, 2) * Math.pow(RH, 2);

        System.out.println("\nThe comfort index is: " + Comfort_Index);
    }

    public static void favouriteLanguageLetters() {
        String[] lan_array = {"Bengali","Japanese","Hindi","Chinese","Hebrew"};

        /*
        the array represents a starting point within the Unicode range of a specific language
        here we dealt with Bengali, Japanese, Hindi, Chinese and Hebrew
         */

        int[] uni_array = {0x0980, 0x3040, 0x0900, 0x4E00, 0x0590};

        /*

        Unicode of Bengali : 0x0980
        Unicode of Japanese: 0x3040
        Unicode of Hindi   : 0x0900
        Unicode of Chinese : 0x4E00
        Unicode of Hebrew  : 0x0590

         */

        System.out.println("\n5 random characters of 5 favourite languages are given below: ");
        for(int i=0; i<5;i++){
            /*

            here we are keeping the range from the 1st character to the 128th character
            of the language according to unicode.

            Step 1: We generated a random number 0 (inclusive) - 128 (exclusive)
            Step 2: We type-casted that number as integer
            Step 3: We added that number with the initial number of the unicode of that language
            Step 4: Finally we convert it into a char data type.

             */

            char character = (char)(uni_array[i] + (int)(Math.random()*128));

            //We have formatted the console output for better presentation
            System.out.println(String.format("%-10s : %s",lan_array[i],character));
        }
    }
}
