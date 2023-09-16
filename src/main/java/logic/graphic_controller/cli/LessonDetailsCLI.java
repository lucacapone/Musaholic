package logic.graphic_controller.cli;

import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.controller.BookingLessonController;
import logic.exception.ClassroomNotFoudException;
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static logic.graphic_controller.cli.HomeCLI.SYNTAX_ERROR;


public class LessonDetailsCLI {
    BookingLessonController controller;

    public LessonDetailsCLI(BookingLessonController controller) {
        this.controller = controller;
    }


    public void start() throws SQLException {
        DateBean dateBean = new DateBean();
        MusicalInstrumentBean musicalInstrumentBean = new MusicalInstrumentBean();
        PriceBean priceBean = new PriceBean();
        TimeBean timeBean = new TimeBean();
        System.out.println("Book Lesson / Lesson Details:\n1)Insert musical instrument");
        Scanner scanner = new Scanner(System.in);

        try {
            musicalInstrumentBean.setMusicalInstrument(scanner.nextLine());
        } catch (SyntaxBeanException exception) {
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("2)Insert date: format(YYYY-MM-DD)");
        try {
            dateBean.setDate(scanner.nextLine());
        } catch (SyntaxBeanException exception) {
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("3)Insert price");
        try {
            priceBean.setPrice(scanner.nextLine());
        } catch (SyntaxBeanException exception) {
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("4)Insert time");
        try {
            timeBean.setTime(scanner.nextLine());
        } catch (SyntaxBeanException exception) {
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();
        }
        if (controller.checkLessonDetails(dateBean, musicalInstrumentBean, priceBean, timeBean)) {
            try {
                controller.setBooking(dateBean, musicalInstrumentBean, priceBean, timeBean);
            } catch (SyntaxBeanException ex) {
                //Graphical input syntax error management
                System.out.println(SYNTAX_ERROR);
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            } catch (DAOException ex) {
                //Graphic management of the case of lesson not found
                System.out.println("Not found lesson: change the parameters");
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            } catch (SQLException ex) {
                //Graphical management of error cases in the connection database
                System.out.println("Error database connection!");
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            } catch (IOException | ClassNotFoundException e) {
                throw new SQLException();
            } catch (ClassroomNotFoudException e) {
                //Graphic management of the error case in the classroom not found
                System.out.println("Error clssroom not found!");
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            }
            (new LessonCLI(controller)).start();
        }

    }
}
