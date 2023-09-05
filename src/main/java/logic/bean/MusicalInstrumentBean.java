package logic.bean;

import logic.exception.SyntaxBeanException;
import java.io.Serializable;

public class MusicalInstrumentBean implements Serializable {

    private String musicalInstrument;

    public String getMusicalInstrument() {
        return musicalInstrument;
    }

    public void setMusicalInstrument(String musicalInstrument) throws SyntaxBeanException {
        syntaxCheck(musicalInstrument);
        this.musicalInstrument = musicalInstrument;
    }

    private void syntaxCheck(String musicalInstrument) throws SyntaxBeanException {
        if(musicalInstrument.length()==0 || musicalInstrument.length()>50){
            throw new SyntaxBeanException("Syntax error: musical instrument invalid");
        }
    }
}
