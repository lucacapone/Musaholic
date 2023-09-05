package logic.dao;

import java.util.List;

import logic.model.Lesson;
public interface LessonDAO {
    List<Lesson> retrieveLessonByIdStudent(String idStudent) throws Exception;
    void saveLesson(Lesson instance) throws Exception;
}

