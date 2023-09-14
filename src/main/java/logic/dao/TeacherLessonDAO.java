package logic.dao;

import logic.exception.DAOException;
import logic.model.TeacherLesson;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TeacherLessonDAO {
    List<TeacherLesson> retrieveTeacherLesson(String date, String musicalInstrument, int price, int time) throws DAOException, SQLException, IOException, ClassNotFoundException;

}