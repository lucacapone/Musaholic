package logic.model;

import logic.dao.LessonDAO;
import logic.dao.LessonDAOCSV;
import logic.dao.LessonDAOJDBC;

import java.io.IOException;
import java.time.LocalDate;

public class LessonDAOFactory {
    //PATTERN FACTORY
    public LessonDAO createLessonDAO() throws IOException {
        boolean isDb = getPersistence();
        if (isDb) //MANAGE PERSISTENCE MODE CHOICE MECHANISM
        {
            return new LessonDAOJDBC();
        }
        return new LessonDAOCSV();
    }

    public static boolean getPersistence() {
        LocalDate date = LocalDate.now();
        int number = date.getDayOfMonth() % 2;
        return number == 1;
    }
}
