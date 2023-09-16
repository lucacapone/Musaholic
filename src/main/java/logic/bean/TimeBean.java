package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;

public class TimeBean implements Serializable {

    private String time = "";

    public String getTime() {
        return time;
    }

    public void setTime(String time) throws SyntaxBeanException {

        syntaxCheck(time);
        this.time = time;
    }

    private void syntaxCheck(String time) throws SyntaxBeanException {
        try {
            int t = Integer.parseInt(time);
            if (t < 0 || t > 23) {
                throw new SyntaxBeanException("Syntax error in time");
            }
        } catch (NumberFormatException exception) {
            throw new SyntaxBeanException("number format error: input invalid");
        }
    }
}
