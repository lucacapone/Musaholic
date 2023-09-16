package logic.dao;


import logic.model.Lesson;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import logic.exception.DAOException;
import logic.dao.queries.Queries;
import logic.dao.db_connection.DbConnection;

public class LessonDAOJDBC implements LessonDAO {


    @Override
    public List<Lesson> retrieveLessonByIdStudent(String idStudent) throws DAOException, SQLException, IOException, ClassNotFoundException {

        Statement stmt = null;
        Connection conn = DbConnection.getConnection();
        List<Lesson> listOfLesson = new ArrayList<Lesson>();


        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);


        ResultSet rs = Queries.selectIdStudentLesson(stmt, idStudent);
        if (!rs.first()) { // rs empty
            throw new DAOException("No Lesson found matching with id student: " + idStudent);
        }

        //repositioning the cursor
        rs.first();
        do {

            // reading the "by is student" columns
            LocalDate date = rs.getDate("date").toLocalDate();
            String musicalInstrument = rs.getString("musicalInstrument");
            int price = rs.getInt("price");
            String idTeacher = rs.getString("idTeacher");
            String teacher = rs.getString("teacher");
            String classroom = rs.getString("classroom");
            int time = rs.getInt("time");

            Lesson lesson = new Lesson();
            lesson.setIdStudent(idStudent);
            lesson.setDate(date);
            lesson.setMusicalInstrument(musicalInstrument);
            lesson.setPrice(price);
            lesson.setIdTeacher(idTeacher);
            lesson.setTeacher(teacher);
            lesson.setClassroom(classroom);
            lesson.setTime(time);
            listOfLesson.add(lesson);


        } while (rs.next());


        rs.close();


        return listOfLesson;
    }


    @Override
    public void saveLesson(Lesson instance) throws SQLException {
        PreparedStatement pstmt = null;

        try {
            String query = Queries.insertLesson();
            pstmt = DbConnection.getConnection().prepareStatement(query);

            pstmt.setString(1, instance.getIdStudent());
            pstmt.setDate(2, Date.valueOf(instance.getDate())); //String.valueOf(instance.getDate())
            pstmt.setString(3, instance.getMusicalInstrument());
            pstmt.setInt(4, instance.getPrice());
            pstmt.setString(5, instance.getIdTeacher());
            pstmt.setString(6, instance.getTeacher());
            pstmt.setString(7, instance.getClassroom());
            pstmt.setInt(8, instance.getTime());

            pstmt.executeUpdate();


        } catch (SQLException e) {

            if (pstmt != null) {
                pstmt.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SQLException();
        } finally {
            assert pstmt != null;
            pstmt.close();
        }
    }


}
