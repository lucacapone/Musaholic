package logic.graphic_controller.cli;

import logic.controller.BookingLessonController;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class HomeCLI {
    public static final String SYNTAX_ERROR = "error syntax!\n";
    public void start() throws SQLException {

        System.out.println("Welcome to Musaholic!\n1)Book Lesson\n2)Musical Instrument\n3)News\n4)Scheduled Lesson\n5)Contacts\n6)Help\n7)Profile");
        Scanner scanner = new Scanner(System.in);
        boolean validInput=FALSE;
        while (!validInput) {
            System.out.println("Insert choise number:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("It's a string. Retry");
                continue;}
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput=TRUE;
                    BookingLessonController controller = new BookingLessonController();
                    (new LessonDetailsCLI(controller)).start();
                    break;
                case 2,3,4,5,6,7://user requires posting sale ad
                    validInput=TRUE;
                    HomeCLI homeCLI = new HomeCLI();
                    homeCLI.start();

                    break;

                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }
}
