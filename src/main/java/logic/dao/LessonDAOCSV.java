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

                throw new IOException();

            }

        }
    }


    @Override
    public List<Lesson> retrieveLessonByIdStudent(String idStudent) throws CsvValidationException, IOException, DAOException {


        List<Lesson> lst = new ArrayList<>();


        if (lst.isEmpty()) {
            lst = retrieveLessonByIdStudent(this.fd, idStudent);

        }

        return lst;
    }

    private static synchronized List<Lesson> retrieveLessonByIdStudent(File fd, String idStudent) throws IOException, CsvValidationException, DAOException {
        // create csvReader object passing file reader as a parameter


        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));

        String[] myrecord;
        List<Lesson> lessonList = new ArrayList<>();

        try {
            while ((myrecord = csvReader.readNext()) != null) {
                int posNum = LessonAttributesOrder.ID_STUDENT;

                boolean recordFound = myrecord[posNum].equals(idStudent);
                if (recordFound) {
                    String is = myrecord[LessonAttributesOrder.ID_STUDENT];
                    LocalDate d = LocalDate.parse(myrecord[LessonAttributesOrder.DATE]);
                    int t = Integer.parseInt(myrecord[LessonAttributesOrder.TIME]);
                    String mi = myrecord[LessonAttributesOrder.MUSICAL_INSTRUMENT];
                    int p = Integer.parseInt(myrecord[LessonAttributesOrder.PRICE]);
                    String it = myrecord[LessonAttributesOrder.ID_TEACHER];
                    String th = myrecord[LessonAttributesOrder.TEACHER];
                    String c = myrecord[LessonAttributesOrder.CLASSROOM];
                    Lesson lesson = new Lesson();
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
            }
            if (lessonList.isEmpty()) {
                throw new DAOException("No Lesson found matching with id student: " + idStudent);

            }
        } finally {
            csvReader.close();
        }
        return lessonList;
    }


    @Override
    public synchronized void saveLesson(Lesson instance) throws IOException {
        // create csvWriter object passing file reader as a parameter

        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(this.fd, true)));


        String[] myrecord = new String[8];
        try {
            myrecord[LessonAttributesOrder.ID_STUDENT] = instance.getIdStudent();
            myrecord[LessonAttributesOrder.DATE] = String.valueOf(instance.getDate());
            myrecord[LessonAttributesOrder.TIME] = String.valueOf(instance.getTime());
            myrecord[LessonAttributesOrder.MUSICAL_INSTRUMENT] = instance.getMusicalInstrument();
            myrecord[LessonAttributesOrder.PRICE] = String.valueOf(instance.getPrice());
            myrecord[LessonAttributesOrder.ID_TEACHER] = instance.getIdTeacher();
            myrecord[LessonAttributesOrder.TEACHER] = instance.getTeacher();
            myrecord[LessonAttributesOrder.CLASSROOM] = instance.getClassroom();
            csvWriter.writeNext(myrecord);
            csvWriter.flush();

        } finally {

            csvWriter.close();
        }

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


}
