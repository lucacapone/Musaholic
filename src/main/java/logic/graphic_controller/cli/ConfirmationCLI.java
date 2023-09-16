package logic.graphic_controller.cli;

import com.opencsv.exceptions.CsvValidationException;
import logic.bean.TeacherChoseBean;
import logic.controller.BookingLessonController;
import logic.exception.DAOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ConfirmationCLI {
    BookingLessonController controller;

    TeacherChoseBean indexChoseBean;


    public ConfirmationCLI(BookingLessonController controller, TeacherChoseBean indexChoseBean) {
        this.controller = controller;
        this.indexChoseBean = indexChoseBean;

    }

    public void start() throws SQLException {
        System.out.println("Confirm?\n1)yes\n2)no");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = FALSE;
        while (!validInput) {
            System.out.println("Insert choise number:");
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("It's a string. Retry");
                continue;
            }
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    validInput = TRUE;
                    controller.setTeacherDetails(indexChoseBean);
                    try {
                        controller.saveLesson();
                        System.out.println("lesson saved");
                    } catch (DAOException exception) {
                        //Graphic management of the case of lesson not found
                        System.out.println("Not found lesson: change th parameters");
                        ConfirmationCLI confirmationCLI = new ConfirmationCLI(controller, indexChoseBean);
                        confirmationCLI.start();
                    } catch (SQLException s) {
                        //Graphical management of error cases in the connection database
                        System.out.println("Error database connection");
                        ConfirmationCLI confirmationCLI = new ConfirmationCLI(controller, indexChoseBean);
                        confirmationCLI.start();

                    } catch (CsvValidationException | IOException e) {
                        System.out.println("Error persisting in the file");
                        ConfirmationCLI confirmationCLI = new ConfirmationCLI(controller, indexChoseBean);
                        confirmationCLI.start();
                    }
                    (new HomeCLI()).start();
                    break;
                case 2:
                    validInput = TRUE;
                    (new LessonCLI(controller)).start();

                    break;

                default:
                    System.out.println("Invalid number.Retry");
                    scanner.nextLine();
            }
        }
    }
}
