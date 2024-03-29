package logic.dao;

import logic.dao.db_connection.DbConnection;
import logic.dao.queries.Queries;
import logic.exception.DAOException;
import logic.model.TeacherLesson;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherLessonDAOJDBC implements TeacherLessonDAO {

    @Override
    public List<TeacherLesson> retrieveTeacherLesson(String date, String musicalInstrument, int price, int time) throws SQLException, DAOException, IOException, ClassNotFoundException {
        Statement stmt;
        Connection conn = DbConnection.getConnection();
        List<TeacherLesson> listOfTeacherLesson = new ArrayList<TeacherLesson>();

        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);


        ResultSet rs = Queries.selectTeacherLesson(stmt, date, musicalInstrument, price, time);
        if (!rs.first()) { // rs empty
            throw new DAOException("No Lesson found matching with this lesson details");

        }

        //repositioning the cursor
        rs.first();
        do {


            String idTeacher = rs.getString("idTeacher");
            String name = rs.getString("name");


            TeacherLesson l1 = new TeacherLesson(idTeacher, name, LocalDate.parse(date), musicalInstrument, price, time);

            listOfTeacherLesson.add(l1);


        } while (rs.next());


        rs.close();


        return listOfTeacherLesson;
    }


}

