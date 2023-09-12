package logic.graphic_controller.CLI;

import logic.bean.DateBean;
import logic.bean.MusicalInstrumentBean;
import logic.bean.PriceBean;
import logic.bean.TimeBean;
import logic.controller.BookingLessonController;
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;

import java.sql.SQLException;
import java.util.Scanner;


public class LessonDetailsCLI {
    BookingLessonController controller;

    public LessonDetailsCLI(BookingLessonController controller) {this.controller=controller;
    }

    private static final String SYNTAX_ERROR = "error syntax!\n";

    public void start() {
        System.out.println("Book Lesson / Lesson Details:\n1)Insert musical instrument");
        Scanner scanner = new Scanner(System.in);
        DateBean dateBean = new DateBean();
        MusicalInstrumentBean musicalInstrumentBean = new MusicalInstrumentBean();
        PriceBean priceBean = new PriceBean();
        TimeBean timeBean = new TimeBean();

        try {
            musicalInstrumentBean.setMusicalInstrument(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            start();
        }
        System.out.println("2)Insert date: format(YYYY-MM-DD)");
        try {
            dateBean.setDate(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            start();

        }
        System.out.println("3)Insert price");
        try {
            priceBean.setPrice(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            start();

        }
        System.out.println("4)Insert time");
        try {
            timeBean.setTime(scanner.nextLine());
        }
        catch (SyntaxBeanException exception){
            System.out.println(SYNTAX_ERROR);
            start();
        }
        if (controller.checkLessonDetails(dateBean,musicalInstrumentBean,priceBean,timeBean)) {
            try {
                controller.setBooking(dateBean, musicalInstrumentBean, priceBean, timeBean);
            } catch (SyntaxBeanException ex) {
                //gestione grafica  errore di sintassi input
            } catch (DAOException ex) {
                //gestione grafica del caso di lezione non trovata
            } catch (SQLException ex) {
                //gestione grafica del caso di errore nel db connessione
            }

        }
        (new LessonCLI(controller)).start();
    }
}
