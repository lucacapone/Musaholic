package logic.dao.queries;



import java .sql.*;



public class Queries {

    private Queries() {
        throw new IllegalStateException("Utility class");
    }

    static final String INSERT = "INSERT INTO lesson (`idStudent`, `date`, `musicalInstrument`, `price`, `idTeacher`, `teacher`, `classroom`, `time`)  VALUES (?,? , ?, ?, ?, ?, ?, ?)";

    public static String insertLesson()  {
        return  INSERT;

    }

    public static ResultSet selectIdStudentLesson(Statement stmt, String idStudent) throws SQLException  {
        String sql = String.format("SELECT DISTINCT * FROM lesson WHERE lesson.idStudent = '%s'",idStudent);
        return stmt.executeQuery(sql);
    }

    public static ResultSet selectTeacherLesson(Statement stmt, String date, String musicalInstrument, int price, int time) throws SQLException  {
        String sql = String.format("SELECT DISTINCT * FROM teacherLesson WHERE teacherLesson.date = '%s' AND teacherLesson.musicalInstrument = '%s' AND teacherLesson.price = %s AND teacherLesson.time = %s",date,musicalInstrument,price,time);
        return stmt.executeQuery(sql);
    }


}
