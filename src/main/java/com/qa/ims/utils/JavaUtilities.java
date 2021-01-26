package com.qa.ims.utils;

import java.sql.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavaUtilities {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Scanner scanner;

    public JavaUtilities(Scanner scanner) {
        super();
        this.scanner = scanner;
    }

    public JavaUtilities() {
        scanner = new Scanner(System.in);
    }

    public Long getLong() {
        String input = null;
        Long longInput = null;
        do {
            try {
                input = getString();
                longInput = Long.parseLong(input);
            } catch (NumberFormatException nfe) {
                LOGGER.info("Error - Please enter a number");
            }
        } while (longInput == null);
        return longInput;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public Double getDouble() {
        String input = null;
        Double doubleInput = null;
        do {
            try {
                input = getString();
                doubleInput = Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                LOGGER.info("Error - Please enter a number");
            }
        } while (doubleInput == null);
        return doubleInput;
    }
    
    public Date getDate() {
        String input = null;
        Date dateInput = null;
        do {
            try {
                input = getString();
                dateInput = Date.parseDate(input);
            } catch (NumberFormatException nfe) {
                LOGGER.info("Error - Please enter a date");
            }
        } while (dateInput == null);
        return dateInput;
    }
    

}
