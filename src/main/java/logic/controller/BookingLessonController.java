package logic.controller;


import com.opencsv.exceptions.CsvValidationException;
import logic.bean.*;
import logic.boundary.ClassroomManageSystem;
import logic.dao.LessonDAO;
import logic.dao.LessonDAOJDBC;
import logic.dao.TeacherLessonDAO;
import logic.dao.TeacherLessonDAOJDBC;
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;
import logic.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class BookingLessonController {
    private Lesson lesson; //L'unica vera prenotazione che alla fine salverò
    private  FreeClassroom classroom;
    private List<TeacherLesson> lessonList;

    public FreeClassroom getClassroom() {
        return classroom;
    }

    public void setClassroom(FreeClassroom classroom) {
        this.classroom = classroom;
    }

    public List<TeacherLesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<TeacherLesson> lessonList) {
        this.lessonList = lessonList;
    }

    public BookingLessonController() {
        this.lesson = new Lesson("",LocalDate.now(),"",-1,"","","",-1);
        this.classroom = new FreeClassroom("");
        this.lessonList = new ArrayList<>();
    }

    public void setBooking(DateBean d, MusicalInstrumentBean m, PriceBean p, TimeBean t) throws SyntaxBeanException, SQLException,DAOException {
        this.setDate(d);
        this.setPrice(p);
        this.setTime(t);
        this.setMusicalInstrument(m);

        // Classroom Manage System : get free classroom
        findFreeClassroom();

        // By DAO teacher : retrieveTeacherLesson
        findTeacherLessons();

    }

    private void findTeacherLessons() throws DAOException, SQLException {
        String date = lesson.getDate().toString();
        String musicalInstrument = lesson.getMusicalInstrument();
        int price = lesson.getPrice();
        int time = lesson.getTime();
        TeacherLessonDAO teacherLessonDAO = new TeacherLessonDAOJDBC(); //Questo codice va sostituito in caso di cambiamento di modalità di persistenza
        this.lessonList = teacherLessonDAO.retrieveTeacherLesson(date,musicalInstrument,price,time);
    }

    private void findFreeClassroom() throws SyntaxBeanException {
        ClassroomAvailabilityBean classroomAvailabilityBean = new ClassroomAvailabilityBean();
        classroomAvailabilityBean.setDate(lesson.getDate().toString());
        classroomAvailabilityBean.setTime(Integer.toString(lesson.getTime()));

        ClassroomManageSystem classroomManageSystem = new ClassroomManageSystem();
        FreeClassroomBean freeClassroomBean = classroomManageSystem.findFreeClassroom(classroomAvailabilityBean);
        this.classroom.setClassroom(freeClassroomBean.getClassroom());
        this.lesson.setClassroom(freeClassroomBean.getClassroom());
    }

    public boolean checkLessonDetails(DateBean dateBean, MusicalInstrumentBean musicalInstrumentBean, PriceBean priceBean, TimeBean timeBean){
        String date = dateBean.getDate();
        String musicalInstrument = musicalInstrumentBean.getMusicalInstrument();
        String price = priceBean.getPrice();
        String time = timeBean.getTime();
        return !Objects.equals(date, "") && !Objects.equals(musicalInstrument, "") && !Objects.equals(price, "") && !Objects.equals(time, "");
    }

    private void setDate(DateBean dateBean) {
        LocalDate date = LocalDate.parse(dateBean.getDate());
        this.lesson.setDate(date);
    }

    private void setMusicalInstrument(MusicalInstrumentBean musicalInstrumentBean) {
        this.lesson.setMusicalInstrument(musicalInstrumentBean.getMusicalInstrument());
    }
    private void setPrice(PriceBean priceBean) {
        int price = Integer.parseInt(priceBean.getPrice());
        this.lesson.setPrice(price);
    }

    private void setTime(TimeBean timeBean) {
        int time = Integer.parseInt(timeBean.getTime());
        this.lesson.setTime(time);
    }

    public  void setTeacherDetails(String id, String name) {
        this.lesson.setIdTeacher(id);
        this.lesson.setTeacher(name);

    }

    public void saveLesson() throws DAOException, SQLException, CsvValidationException, IOException{
        this.lesson.setIdStudent(Session.getInstance().getId());
        LessonDAOFactory factory  = new LessonDAOFactory();
        LessonDAO lessonDAO = factory.createLessonDAO();
        lessonDAO.saveLesson(lesson);
        System.out.println(lesson.getAll());
        System.out.println(lessonDAO.retrieveLessonByIdStudent("01"));
    }
}
