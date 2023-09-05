package logic.dao;

import logic.model.TeacherLesson;

import java.time.LocalDate;
import java.util.List;

public interface TeacherLessonDAO {
    List<TeacherLesson> retrieveTeacherLesson(LocalDate date, String musicalInstrument, int price, int time) throws Exception;

}