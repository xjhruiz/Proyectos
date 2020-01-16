package entities;

/**
 * Created by user on 01/03/2018.
 */


public class Rating {
    //Para cambiar el atributo de la clase y ponerlo como en el json
    
    String source;
    String Value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
