package logic.dao;

import logic.model.TeacherLesson;


import java.util.List;

public interface TeacherLessonDAO {
    List<TeacherLesson> retrieveTeacherLesson(String date, String musicalInstrument, int price, int time) throws Exception;

}