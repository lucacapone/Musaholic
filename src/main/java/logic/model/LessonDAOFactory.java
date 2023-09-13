package logic.model;

import logic.dao.LessonDAO;
import logic.dao.LessonDAOCSV;
import logic.dao.LessonDAOJDBC;

import java.io.IOException;

public class LessonDAOFactory {
    //PATTERN FACTORY
    public LessonDAO createLessonDAO() throws IOException {
    if(true) //GESTIRE MECCANISMO DI SCELTA DELLA MODALITA' DI PERSISTENZA
    {return new LessonDAOJDBC();}
    return new LessonDAOCSV();
    }
}
