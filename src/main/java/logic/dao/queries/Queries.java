package logic.dao.queries;

import logic.model.Lesson;

import java .sql.*;
import java.time.LocalDate;


public class Queries {

    public static Integer insertLesson(Statement stmt, Lesson lesson) throws SQLException  {
       // String insertStatement = String.format("INSERT INTO `musaholicdb`.`lesson` (`number`, `mode`, `date`, `musicalInstrument`, `payment`, `distance`, `teacher`, `done`) VALUES ('%s','%s',%s,'%s','%s','%s','%s',%s)" , lesson.getNumber(),lesson.getMode(),lesson.getDate(),lesson.getMusicalInstrument(),lesson.getPayment(),lesson.getDistance(),lesson.getTeacher(),lesson.getDone() );
      // return stmt.executeUpdate(insertStatement);
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
    /*INSERT INTO `musaholicdb`.`lesson` (`number`, `mode`, `date`, `musicalInstrument`, `payment`, `distance`, `teacher`, `done`) VALUES ('1', 'online', '2020-1-1', 'piano', '15', '5', 'federica verdi', '1');
        INSERT INTO `musaholicdb`.`lesson` (`number`, `mode`, `date`, `musicalInstrument`, `payment`, `distance`, `teacher`, `done`) VALUES ('2', 'face to face', '2021-2-2', 'sax', '20', '10', 'gicomo rossi', '1');
        INSERT INTO `musaholicdb`.`lesson` (`number`, `mode`, `date`, `musicalInstrument`, `payment`, `distance`, `teacher`, `done`) VALUES ('3', 'online', '2023-3-3', 'piano', '30', '15', 'ludovica bianchi', '0');
        */