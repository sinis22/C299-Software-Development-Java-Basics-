import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Age {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter date in the format dd/MM/yyyy: ");
        String date = inputReader.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Bday = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.now();

        int years = Period.between(Bday, today).getYears();

        System.out.println("You are: " + years + " years old");

        LocalDate nextBDay = Bday.withYear(today.getYear());
        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long days = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                p.getDays() + " days until your next birthday. (" +
                days + " days total)");
    }
}