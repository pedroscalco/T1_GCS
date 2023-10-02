package SistemaExames;
import java.text.ParseException;

public class Exame {
    private int id;
    private String tipo;


    public Exame(int id, String tipo) throws ParseException {
        this.id = id;
        this.tipo = tipo;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
