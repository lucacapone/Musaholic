package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class DateBean implements Serializable {

    private String date = "";

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws SyntaxBeanException {
        syntaxCheck(date);
        this.date = date;
    }

    private void syntaxCheck(String date) throws SyntaxBeanException {
        try {
            if (Objects.equals(date, "null")) {
                throw new SyntaxBeanException("date error: input null");
            }
            LocalDate.parse(date);

        } catch (DateTimeException exception) {
            throw new SyntaxBeanException("date error: input invalid");
        }
    }
}

