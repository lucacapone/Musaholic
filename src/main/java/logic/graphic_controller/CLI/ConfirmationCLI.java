package logic.graphic_controller.CLI;

import logic.controller.BookingLessonController;

import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ConfirmationCLI {
    BookingLessonController controller;

    String id;

    String teacher;

    public ConfirmationCLI(BookingLessonController controller, String id, String teacher) {
        this.controller=controller;
        this.id=id;
        this.teacher=teacher;
    }

    public void start() {
        System.out.println("Confirm?\n1)yes\n2)no");
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
                    controller.setTeacherDetails(id,teacher);
                    //controller.saveLesson();
                    (new HomeCLI()).start();
                    break;
                case 2://user requires posting sale ad
                    validInput=TRUE;
                    (new LessonCLI(controller)).start();

                    break;

                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }
}
