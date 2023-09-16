package logic.controller;


import com.opencsv.exceptions.CsvValidationException;
import logic.bean.*;
import logic.boundary.ClassroomManageSystem;
import logic.dao.LessonDAO;
import logic.dao.TeacherLessonDAO;
import logic.dao.TeacherLessonDAOJDBC;
import logic.exception.ClassroomNotFoudException;
import logic.exception.DAOException;
import logic.exception.SyntaxBeanException;
import logic.model.*;

import java.io.FileInputStream;
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
        this.lesson = new Lesson();
        lesson.setIdStudent("");
        lesson.setDate(LocalDate.now());
        lesson.setMusicalInstrument("");
        lesson.setPrice(-1);
        lesson.setIdTeacher("");
        lesson.setTeacher("");
        lesson.setClassroom("");
        lesson.setTime(-1);
        this.classroom = new FreeClassroom("");
        this.lessonList = new ArrayList<>();
    }

    public void setBooking(DateBean d, MusicalInstrumentBean m, PriceBean p, TimeBean t) throws SyntaxBeanException, SQLException, DAOException, IOException, ClassNotFoundException, ClassroomNotFoudException {
        this.setDate(d);
        this.setPrice(p);
        this.setTime(t);
        this.setMusicalInstrument(m);

        // Classroom Manage System : get free classroom
        if (findFreeClassroom()){
            // By DAO teacher : retrieveTeacherLesson
            findTeacherLessons();
        }
        else{
            throw new ClassroomNotFoudException("classroom not found");
        }


    }

    private void findTeacherLessons() throws DAOException, SQLException, IOException, ClassNotFoundException {
        String date = lesson.getDate().toString();
        String musicalInstrument = lesson.getMusicalInstrument();
        int price = lesson.getPrice();
        int time = lesson.getTime();
        TeacherLessonDAO teacherLessonDAO = new TeacherLessonDAOJDBC(); //Questo codice va sostituito in caso di cambiamento di modalità di persistenza
        this.lessonList = teacherLessonDAO.retrieveTeacherLesson(date,musicalInstrument,price,time);
    }

    private boolean findFreeClassroom() throws SyntaxBeanException {
        ClassroomAvailabilityBean classroomAvailabilityBean = new ClassroomAvailabilityBean();
        classroomAvailabilityBean.setDate(lesson.getDate().toString());
        classroomAvailabilityBean.setTime(Integer.toString(lesson.getTime()));

        ClassroomManageSystem classroomManageSystem = new ClassroomManageSystem();
        FreeClassroomBean freeClassroomBean = classroomManageSystem.findFreeClassroom(classroomAvailabilityBean);
        if(Objects.equals(freeClassroomBean.getClassroom(), "")){
            return false;
        }
        this.classroom.setClassroom(freeClassroomBean.getClassroom());
        this.lesson.setClassroom(freeClassroomBean.getClassroom());
        return true;
    }

    public boolean checkLessonDetails(DateBean dateBean, MusicalInstrumentBean musicalInstrumentBean, PriceBean priceBean, TimeBean timeBean){
        String date = dateBean.getDate();
        String musicalInstrument = musicalInstrumentBean.getMusicalInstrument();
        String price = priceBean.getPrice();
        String time = timeBean.getTime();
        Boolean alert= Objects.equals(date, "") || Objects.equals(musicalInstrument, "") || Objects.equals(price, "") || Objects.equals(time, "");
    return !alert;
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

    public  void setTeacherDetails(TeacherChoseBean indexChoseBean) {
        int index = Integer.parseInt(indexChoseBean.getIndex());
        this.lesson.setTeacher(lessonList.get(index).getName());
        this.lesson.setIdTeacher(lessonList.get(index).getIdTeacher());

    }

    public void saveLesson() throws DAOException, SQLException, CsvValidationException, IOException{
        String id="";
        FileInputStream propsInput = new FileInputStream("src/main/resources/config.properties");
        Properties prop = new Properties();
        try{
            prop.load(propsInput);
            id=prop.getProperty("id");

        }
        catch (IOException e) {
            throw new IOException();
        }
        finally {
            propsInput.close();
        }
        this.lesson.setIdStudent(id);
        LessonDAOFactory factory  = new LessonDAOFactory();
        LessonDAO lessonDAO = factory.createLessonDAO();
        lessonDAO.saveLesson(lesson);
    }
}
