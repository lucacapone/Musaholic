package logic.dao;


import com.opencsv.exceptions.CsvValidationException;
import logic.model.Lesson;
import logic.exception.DAOException;

import java.io.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;




public class LessonDAOCSV implements LessonDAO {

    private static final String CSV_FILE_NAME = "src/main/resources/file/localDBFile.csv";

    private File fd;

    public LessonDAOCSV() throws IOException {
        this.fd = new File(CSV_FILE_NAME);

        if (!fd.exists()) {
            boolean a = fd.createNewFile();
            if (!a) {
                {
                    throw new IOException();
                }
            }

        }
    }


    @Override
    public List<Lesson> retrieveLessonByIdStudent(String idStudent) throws CsvValidationException, IOException, DAOException {


        List<Lesson> lst = new ArrayList<>();



        if (lst.isEmpty()) {
            lst = this.retrieveLessonByIdStudent(this.fd, idStudent);

        }

        return lst;
    }

    private static synchronized List<Lesson> retrieveLessonByIdStudent(File fd, String idStudent) throws IOException, CsvValidationException, DAOException {
        // create csvReader object passing file reader as a parameter


        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));

                String[] record;
        List<Lesson> lessonList = new ArrayList<>();

        try{
        while ((record = csvReader.readNext()) != null) {
            int posNum= LessonAttributesOrder.ID_STUDENT;

            boolean recordFound = record[posNum].equals(idStudent);
            if (recordFound) {
                String is = record[LessonAttributesOrder.ID_STUDENT];
                LocalDate d = LocalDate.parse(record[LessonAttributesOrder.DATE]);
                int t = Integer.parseInt(record[LessonAttributesOrder.TIME]);
                String mi = record[LessonAttributesOrder.MUSICAL_INSTRUMENT];
                int p = Integer.parseInt(record[LessonAttributesOrder.PRICE]);
                String it = record[LessonAttributesOrder.ID_TEACHER];
                String th = record[LessonAttributesOrder.TEACHER];
                String c = record[LessonAttributesOrder.CLASSROOM];
                Lesson lesson= new Lesson();
                lesson.setIdStudent(is);
                lesson.setDate(d);
                lesson.setMusicalInstrument(mi);
                lesson.setPrice(p);
                lesson.setIdTeacher(it);
                lesson.setTeacher(th);
                lesson.setClassroom(c);
                lesson.setTime(t);
                lessonList.add(lesson);
            }
        }  if (lessonList.isEmpty()) {
                        DAOException e = new DAOException("No Lesson found matching with id student: " + idStudent);
                        throw e;
                    }}


finally{
            csvReader.close();
            return lessonList;
        }

    }



    @Override
  public  synchronized void saveLesson(Lesson instance) throws IOException {
        // create csvWriter object passing file reader as a parameter
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(this.fd, true)));


        String[] record = new String[8];

        record[LessonAttributesOrder.ID_STUDENT] = instance.getIdStudent();
        record[LessonAttributesOrder.DATE] = String.valueOf(instance.getDate());
        record[LessonAttributesOrder.TIME] = String.valueOf(instance.getTime());
        record[LessonAttributesOrder.MUSICAL_INSTRUMENT] = instance.getMusicalInstrument();
        record[LessonAttributesOrder.PRICE] = String.valueOf(instance.getPrice());
        record[LessonAttributesOrder.ID_TEACHER] = instance.getIdTeacher();
        record[LessonAttributesOrder.TEACHER] = instance.getTeacher();
        record[LessonAttributesOrder.CLASSROOM] = instance.getClassroom();

        csvWriter.writeNext(record);
        csvWriter.flush();
        csvWriter.close();
    }

    private static class LessonAttributesOrder {
        public static final int ID_STUDENT = 0;

        public static final int DATE = 1;
        public static final int TIME = 2;
        public static final int MUSICAL_INSTRUMENT = 3;
        public static final int PRICE = 4;
        public static final int ID_TEACHER = 5;
        public static final int TEACHER = 6;
        public static final int CLASSROOM = 7;


    }

    /*
    public static void main(String[] args) throws Exception {
        LocalDate date = LocalDate.of(2020, 1, 8);
        Lesson l1 = new Lesson("01",date,"ccc",4,"11","33","44",6);
        LessonDAOCSV lcsv= new LessonDAOCSV();
        lcsv.saveLesson(l1);
        List<Lesson> lessonList;
        lessonList = lcsv.retrieveLessonByIdStudent("01");
        for(int i=0;i<lessonList.size();i++){
            System.out.println(lessonList.get(i).getAll());
        }

    }

     */

}
