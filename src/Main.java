import java.time.LocalDate;

import java.time.Month;

import java.util.Scanner;


public class MoonPhaseCalculator {

// The reference date for New Moon (January 6, 2000).

// The moon's cycle is approximately 29.530588 days.

    private static final LocalDate newMoonDate = LocalDate.of(2000, Month.JANUARY, 6);

    private static final double moonCycle = 29.530588;
}

// Array for moon phase names

private static final String[] MOON_PHASES = {
        "New Moon", "First Quarter", "Full Moon", "Last Quarter"
};

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

// Ask the user for the year

    System.out.print("Enter the year to calculate moon phases for: ");

    int year = scanner.nextInt();



// Loop through all months in the given year

    for (Month month : Month.values()) {

        System.out.println("\nMonth: " + month);

        calculateMoonPhase(year, month);

    }

    scanner.close();

}

// Method to calculate the moon phase for a given month and year

public static void calculateMoonPhase(int year, Month month) {

    // Find the first day of the given month and year

    LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);



    // Calculate the number of days since the reference New Moon date

    long daysSinceNewMoon = firstDayOfMonth.toEpochDay() - MoonPhaseCalculator.newMoonDate.toEpochDay();



    // Calculate the moon's age (the phase)

    double moonAge = daysSinceNewMoon % MoonPhaseCalculator.moonCycle;



    // Find the corresponding moon phase

    String moonPhase = determineMoonPhase(moonAge);



    // Display the result

    System.out.println("Date: " + firstDayOfMonth);

    System.out.println("Moon Phase: " + moonPhase);

}



// Method to determine the moon phase based on the moon's age

public static String determineMoonPhase(double moonAge) {

    if (moonAge < 1.84566) {

        return moonPhase[0]; // New Moon

    } else if (moonAge < 7.38293) {

        return moonPhase[1]; // First Quarter

    } else if (moonAge < 14.76661) {

        return moonPhase[2]; // Full Moon

    } else if (moonAge < 22.15129) {

        return moonPhase[3]; // Last Quarter

    } else {

        return moonPhase[0]; // New Moon

    }

}

