package logic.dao.queries;

import logic.model.Lesson;

import java .sql.*;



public class Queries {

    public static Integer insertLesson(Statement stmt, Lesson lesson) throws SQLException  {
        String sql = "INSERT INTO lesson (`idStudent`, `date`, `musicalInstrument`, `price`, `idTeacher`, `teacher`, `classroom`, `time`)   VALUES ( '" + lesson.getIdStudent() + "', '" + lesson.getDate() + "', '" + lesson.getMusicalInstrument() + "','" + lesson.getPrice() + "', '" + lesson.getIdTeacher() + "', '" + lesson.getTeacher() + "','" + lesson.getClassroom() + "', '" + lesson.getTime() + "');";
        return stmt.executeUpdate(sql);
    }

    public static ResultSet selectIdStudentLesson(Statement stmt, String idStudent) throws SQLException  {
        String sql = "SELECT DISTINCT * FROM lesson WHERE lesson.idStudent = idStudent;";
        return stmt.executeQuery(sql);
    }

    public static ResultSet selectTeacherLesson(Statement stmt, String date, String musicalInstrument, int price, int time) throws SQLException  {
        String sql = String.format("SELECT DISTINCT * FROM teacherLesson WHERE teacherLesson.date = '%s' AND teacherLesson.musicalInstrument = '%s' AND teacherLesson.price = %s AND teacherLesson.time = %s",date,musicalInstrument,price,time);
        return stmt.executeQuery(sql);
    }


}
