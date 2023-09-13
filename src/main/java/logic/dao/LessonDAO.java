package logic.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import logic.exception.DAOException;
import logic.model.Lesson;
public interface LessonDAO {
    //List<Lesson> retrieveLessonByIdStudent(String idStudent) throws DAOException, SQLException, CsvValidationException, IOException;
    void saveLesson(Lesson instance) throws DAOException, SQLException, CsvValidationException, IOException ;
}

