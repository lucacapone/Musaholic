package logic.bean;

import logic.exception.SyntaxBeanException;

import java.io.Serializable;

public class TeacherChoseBean implements Serializable {
    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) throws SyntaxBeanException {

        syntaxCheck(index);
        this.index = index;
    }

    private void syntaxCheck(String index) throws SyntaxBeanException {
        try {
            Integer.parseInt(index);

        } catch (NumberFormatException exception) {
            throw new SyntaxBeanException("index format error: input invalid");
        }
    }
}
