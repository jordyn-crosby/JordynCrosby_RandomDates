/* Name: Jordyn Crosby
   Date: 9/16/2022
   Period: 3
   Description: Lab accompanying 3.1 - Random dates
   Topics covered: declaring & initializing variables, random number generation, combining strings, integer to string, if-else statements
*/
public class Main {
    static String[] monthArray = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static String weekdayArray[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    //Prints random date (with numbers)
    public static String getNumberDate(int randomYear, int randomMonth, int randomDay) {
        return String.format("%s/%s/%s", randomMonth, randomDay, randomYear);
    }

    //Prints random date (with words month)
    public static String getWordDate(int randomYear, int randomMonth, int randomDay){
        return String.format("%s %s, %s", monthArray[randomMonth], randomDay, randomYear);
    }

    public static String getWeekDay(int randomYear, int randomMonth, int randomDay, String weekday){
        return String.format("%s, %s %s, %s", weekday, monthArray[randomMonth], randomDay, randomYear);
    }

    public static void main(String[] args) {

        //Purpose: Print out a random date from 1 CE to the end of 2022 (assume leap years don't exist) in the form 1/1/2022

        //1. Declare 3 int variables called randomYear, randomMonth, randomDay
        int randomYear = RandomGenerator.getYear();
        int randomMonth = RandomGenerator.getMonth();
        int randomDay = RandomGenerator.getDay(randomMonth);

        //2. Initialize randomYear between 1 to 2022, inclusive & randomMonth between 1 to 12, inclusive

        //3. Use an if else statement to assign the random number of days in the month to randomDay depending on the month (some months have 28, 30, or 31 days) //Remember that January, March, May, July, August, October, & December have 31 days. Every other month has 30 days with the exception of February (assume it has 28 days even on LEAP years)


        //4. Print the values into the form: "The random date is: 01/01/2022". Reminder that integers must be converted into strings to prevent errors

        String numberDateFinal = getNumberDate(randomYear,  randomMonth, randomDay);
        System.out.println("The date is: " + numberDateFinal);

        //5. For an extra challenge convert the numerical date into a date like: January 1, 2022. The only thing needed is to convert int randomNumber to the string monthString. (Hint: Use an if else statement)

        String wordDateFinal = getWordDate(randomYear,  randomMonth, randomDay);
        System.out.println("The date is: " + wordDateFinal);

        //6. For an extra, extra challenge implement and call the "dayOfWeek" method below to calculate the day of the week for your random date (example: 1/1/2021 is a Friday).

        System.out.println("The day of the week on this date is: " + dayOfWeek(randomMonth, randomDay, randomYear));

        //7. Print the string out similar to the form:
        //    "The random date in words is: Friday, January 1, 2021"
        String weekdayFinal = getWeekDay(randomYear,  randomMonth, randomDay, dayOfWeek(randomMonth, randomDay, randomYear));
        System.out.println("The date is: " + weekdayFinal);

    }

    public static String dayOfWeek(int m, int d, int y)
    {
    /*
    The day of the week (Sunday = 0, Monday = 1, etc.) is given by
    the following pseudocode:
    */
        int y0 = y - (14 - m)/12;
        int x0 = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14-m)/12) - 2;
        int dow = (d + x0 + 31 * m0 / 12) % 7;
        // write code below and return the day as a String
        return weekdayArray[dow];

    }
}