/**
 * Jade Cabral
 * a1
 * Modified from - Date2TextConverter.java from http://www.c-jump.com/bcc/c257c/c257syllabus.html
 *
 * @topic T10017 Another date to words demo
 * @brief Date2TextConverter utility class This program asks user for a date in
 * format MM/DD/YYYY and Converts the date to its word representation.
 */
package a1;

public class Date2TextConverter {

    // data
    int month = 0;
    int day = 0;
    int year = 0;

    // constructors
    public Date2TextConverter(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }//Date2TextConverter

    // operations
    public String month2text() {
        switch (month) { //changes numeric month into a string 
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "Invalid Month"; // Invalid if not in range 1-12
        }
    }//month2text

    public String day2text() { //gets the day portion of the date in words from dayInWords()

        String dayInWords = day2words(day);
        return dayInWords;
    }//day2text

    public String year2text() { //gets year portion of date in words
        int century = year / 100;
        int yearInCentury = year % 100;
        String centuryText = number2words(century);
        String yearText = number2words(yearInCentury);

        if (yearInCentury < 10) {
            return centuryText + " zero " + yearText;
        } else {
            return centuryText + " " + yearText;
        }
    }//year2text

    private String day2words(int number) { //coverts day potion ints to strings from appropriate arrays
        if (number < 20) { //if the day is less than 20 get from the days array
            return days[number];

        } else if (number % 10 == 0) { 
            // 20, 30, 40, ... 90
            return decades[number / 10 - 2] + "ieth"; //add "ieth" to decade Strings to create words such as "twentieth" etc.
        } else //if ((number % 10) <= 9) // 21, 22, 23...
        {
            return decades[number / 10 - 2] + "y" + days[number % 10]; // prints dates such as "twenty fifth"
        }

    }//day2words

    private String number2words(int number) {
        // convert to text a number 0 through 99

        if (number < 20) {//if the month is less than 20 get from the days array
            // 0, 1, 2, 3, ..., 19
            return zero2nineteen[number];

        } else if (number % 10 == 0) {
            // 20, 30, 40, ... 90
            return decades[number / 10 - 2] + "y";
        } else {
            // 21, 22, 23, 24, ... 29, 31, 32, ..., 99
            return decades[number / 10 - 2] + "y" + zero2nineteen[number % 10];
        }
    } //number2words

    //---------------------------------------
    // static vocabulary
    //---------------------------------------
    private static final String[] zero2nineteen = {
        "zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fouteen", "fifteen", "sixteen",
        "seventeen",
        "eighteen", "nineteen"
    };

    private static final String[] decades = {
        "twent", "thirt", "fort", "fift", "sixt", "sevent",
        "eight", "ninet"
    };

    private static final String[] days = {
        "error", "first", "second", "third", "forth", "fifth", "sixth", "seventh", "eighth", "ninth",
        "tenth", "eleventh", "twelvth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth",
        "eighteenth", "ninteenth"
    };

}
