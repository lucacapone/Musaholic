package logic.graphic_controller.cli;

import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.controller.BookingLessonController;
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;

import java.sql.SQLException;
import java.util.Scanner;

import static logic.graphic_controller.cli.HomeCLI.SYNTAX_ERROR;


public class LessonDetailsCLI {
    BookingLessonController controller;

    public LessonDetailsCLI(BookingLessonController controller) {this.controller=controller;
    }



    public void start() {
        DateBean dateBean = new DateBean();
        MusicalInstrumentBean musicalInstrumentBean = new MusicalInstrumentBean();
        PriceBean priceBean = new PriceBean();
        TimeBean timeBean = new TimeBean();
        System.out.println("Book Lesson / Lesson Details:\n1)Insert musical instrument");
        Scanner scanner = new Scanner(System.in);

        try {
            musicalInstrumentBean.setMusicalInstrument(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("2)Insert date: format(YYYY-MM-DD)");
        try {
            dateBean.setDate(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("3)Insert price");
        try {
            priceBean.setPrice(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();

        }
        System.out.println("4)Insert time");
        try {
            timeBean.setTime(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
            lessonDetailsCLI.start();
        }
        if (controller.checkLessonDetails(dateBean,musicalInstrumentBean,priceBean,timeBean)) {
            try {
                controller.setBooking(dateBean, musicalInstrumentBean, priceBean, timeBean);
            } catch (SyntaxBeanException ex) {
                //gestione grafica  errore di sintassi input
                System.out.println(SYNTAX_ERROR);
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            } catch (DAOException ex) {
                //gestione grafica del caso di lezione non trovata
                System.out.println("Not found lesson: change th parameters");
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            } catch (SQLException ex) {
                //gestione grafica del caso di errore nel db connessione
                System.out.println("Error database connection!");
                LessonDetailsCLI lessonDetailsCLI = new LessonDetailsCLI(controller);
                lessonDetailsCLI.start();
            }
            (new LessonCLI(controller)).start();
        }

    }
}
