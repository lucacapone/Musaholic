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

public class LessonDAOJDBC implements LessonDAO{


    @Override
    public List<Lesson> retrieveLessonByIdStudent(String idStudent) throws DAOException, SQLException, IOException, ClassNotFoundException {
        // STEP 1: dichiarazioni
        Statement stmt = null;
        Connection conn = DbConnection.getConnection();
        List<Lesson> listOfLesson = new ArrayList<Lesson>();




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


            }while(rs.next());

            // STEP 5.1: Clean-up dell'ambiente
            rs.close();


        return listOfLesson;
    }



    @Override
    public void saveLesson(Lesson instance) throws SQLException {
        PreparedStatement pstmt = null;

        try {
            String query="INSERT INTO lesson (`idStudent`, `date`, `musicalInstrument`, `price`, `idTeacher`, `teacher`, `classroom`, `time`)  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = DbConnection.getConnection().prepareStatement(query);

            pstmt.setString(1, instance.getIdStudent());
            pstmt.setDate(2,Date.valueOf(instance.getDate())); //String.valueOf(instance.getDate())
            pstmt.setString(3, instance.getMusicalInstrument());
            pstmt.setInt(4, instance.getPrice());
            pstmt.setString(5, instance.getIdTeacher());
            pstmt.setString(6, instance.getTeacher());
            pstmt.setString(7, instance.getClassroom());
            pstmt.setInt(8, instance.getTime());

            pstmt.executeUpdate();



        }
        catch (SQLException e) {
System.out.println(e);
            // STEP 5.2: Clean-up dell'ambiente
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SQLException();
        }
        finally {
            pstmt.close();
        }
    }

    /*
    public static void main(String[] args) throws Exception {

       LocalDate date = LocalDate.of(2020, 1, 8);
        Lesson l1 = new Lesson("05",date,"ccc",4,"11","33","44",6);
        LessonDAOJDBC lcsv = new LessonDAOJDBC();
        lcsv.saveLesson(l1);

        List<Lesson> lessonList;
        lessonList = lcsv.retrieveLessonByIdStudent("05");

        for(int i=0;i<lessonList.size();i++){
           System.out.println(lessonList.get(i).getAll());
        }

    }


     */





}
