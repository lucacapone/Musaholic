package logic.dao;

import logic.model.Lesson;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import logic.exception.DAOException;
import logic.dao.queries.Queries;
import logic.dao.dbConnection.DbConnection;

public class LessonDAOJDBC implements LessonDAO{


    @Override
    public List<Lesson> retrieveLessonByIdStudent(String idStudent) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = DbConnection.getConnection();
        List<Lesson> listOfLesson = new ArrayList<Lesson>();

        try {


            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
            ResultSet rs = Queries.selectIdStudentLesson(stmt,idStudent);
            if (!rs.first()){ // rs empty
                DAOException e = new DAOException("No Lesson found matching with id student: "+ idStudent);
                throw e;
            }

            // riposizionamento del cursore
            rs.first();
            do{

                // lettura delle colonne "by is student"
                LocalDate date = rs.getDate("date").toLocalDate();
                String musicalInstrument = rs.getString("musicalInstrument");
                int price =rs.getInt("price");
                String idTeacher = rs.getString("idTeacher");
                String teacher = rs.getString("teacher");
                String classroom = rs.getString("classroom");
                int time = rs.getInt("time");

                Lesson l1 = new Lesson(idStudent,date, musicalInstrument, price, idTeacher, teacher, classroom,time);

                listOfLesson.add(l1);


            }while(rs.next());

            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        } finally {
            // STEP 5.2: Clean-up dell'ambiente
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return listOfLesson;
    }

    @Override
    public void saveLesson(Lesson instance) throws Exception {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = DbConnection.getConnection();

        try {

            // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
            ResultSet rs = Queries.selectIdStudentLesson(stmt,"01");


            while (rs.next()) {
                // lettura delle colonne "by number"
                rs.getInt("number");

            }




            // STEP 4.2: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            Queries.insertLesson(stmt, instance);

            // STEP 5.1: Clean-up dell'ambiente
            rs.close();
        }
        catch (Exception e) {

            // STEP 5.2: Clean-up dell'ambiente
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
    }
   /* public static void main(String[] args) throws Exception {

       LocalDate date = LocalDate.of(2020, 1, 8);
        Lesson l1 = new Lesson("01",date,"ccc",4,"11","33","44",6);
        LessonDAOJDBC lcsv = new LessonDAOJDBC();
        lcsv.saveLesson(l1);

        List<Lesson> lessonList;
        lessonList = lcsv.retrieveLessonByIdStudent("01");

        for(int i=0;i<lessonList.size();i++){
           System.out.println(lessonList.get(i).getAll());
        }

    }

    */


}
