package logic.dao;

import logic.dao.db_connection.DbConnection;
import logic.dao.queries.Queries;
import logic.exception.DAOException;
import logic.model.TeacherLesson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherLessonDAOJDBC implements TeacherLessonDAO {

    @Override
    public List<TeacherLesson> retrieveTeacherLesson(String date, String musicalInstrument, int price, int time) throws SQLException, DAOException {
        Statement stmt;
        Connection conn = DbConnection.getConnection();
        List<TeacherLesson> listOfTeacherLesson = new ArrayList<TeacherLesson>();

        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);


        ResultSet rs = Queries.selectTeacherLesson(stmt, date, musicalInstrument, price, time);
        if (!rs.first()) { // rs empty
            DAOException e = new DAOException("No Lesson found matching with this lesson details");
            throw e;
        }

        // riposizionamento del cursore
        rs.first();
        do {


            String idTeacher = rs.getString("idTeacher");
            String name = rs.getString("name");


            TeacherLesson l1 = new TeacherLesson(idTeacher, name, LocalDate.parse(date), musicalInstrument, price, time);

            listOfTeacherLesson.add(l1);


        } while (rs.next());

        // Clean-up dell'ambiente
        rs.close();


        return listOfTeacherLesson;
    }

/*
    public static void main(String[] args) throws Exception {

        LocalDate date = LocalDate.of(2020, 1, 8);
        TeacherLesson l1 = new TeacherLesson("011","giovanna rossi",date,"sax",25,11);
        TeacherLessonDAOJDBC lcsv = new TeacherLessonDAOJDBC();

        List<TeacherLesson> lessonList;
        lessonList = lcsv.retrieveTeacherLesson(date.toString(),"sax",25,11);

        for(int i=0;i<lessonList.size();i++){
           System.out.println(lessonList.get(i).getAll());
        }
    }

 */


}

