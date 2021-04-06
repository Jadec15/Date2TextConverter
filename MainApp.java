/*
 * Jade Cabral
 * a1
 * modified from - MainApp.Java from http://www.c-jump.com/bcc/c257c/c257syllabus.html
 * @topic T10016 Another date to words demo
 * @brief main driver program
 * This program asks user for a date in format MM/DD/YYYY
 * and Converts the date to its word representation.
 */
package a1;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        while (true) {
            // get user input
            System.out.println("\nWelcome to the Date to Text converter! \n");
            String date = Validator.getString(Validator.sc, "Enter a date in MM/DD/YYYY format: ");

          
            String[] dateComponents = date.split("/"); //splits string by "/"
            if (dateComponents.length != 3) {    //if input is incorrect format 
                System.out.println("\t\t Error with input, please retry");
                continue;
            } // if the user did not input 3 integers then print a bad input message.

            int month = 0;
            int day = 0;
            int year = 0;
            try {
                month = Integer.parseInt(dateComponents[0]);
                day = Integer.parseInt(dateComponents[1]);
                year = Integer.parseInt(dateComponents[2]);
            } catch (java.lang.NumberFormatException ex) {
                System.out.println("\t\t Input needs to be numeric, try again"); //prints error if numeric value was not entered
                continue;
            }//catch

            Date2TextConverter converter = new Date2TextConverter(month, day, year); //create new Date2TextConverter Class

            System.out.print(converter.month2text() + " " + converter.day2text() + " " + converter.year2text() + "\n");
        }// endless while loop
    }//main
}//class MainApp
