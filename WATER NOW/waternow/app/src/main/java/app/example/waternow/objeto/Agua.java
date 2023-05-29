package app.example.waternow.objeto;
import com.google.type.DateTime;

public class Agua {
    public String id_usuario;
    public DateTime data;
    public Float agua;

    public Agua() {
    }

    public Agua(String id_usuario, DateTime data, Float agua) {
        this.id_usuario = id_usuario;
        this.data = data;
        this.agua = agua;
    }
}
