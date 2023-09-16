package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;

public class FreeClassroomBean implements Serializable {

    private String classroom;

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) throws SyntaxBeanException {
        syntaxCheck(classroom);
        this.classroom = classroom;
    }

    private void syntaxCheck(String classroom) throws SyntaxBeanException {
        if (classroom.length() == 0) {
            throw new SyntaxBeanException("Syntax error: classroom null");
        }
    }
}
