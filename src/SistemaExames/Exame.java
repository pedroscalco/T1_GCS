package SistemaExames;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame {
    private int id;
    private String tipo;
    private boolean status;
    private Date dataRealizacao;
    private Date dataSolicitacao;

    public Exame(int id, String tipo, boolean status, String dataRealizacao, String dataSolicitacao) throws ParseException {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataRealizacao = dateFormat.parse(dataRealizacao);
        this.dataSolicitacao = dateFormat.parse(dataSolicitacao);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public boolean setStatus(boolean verificacao){
        if(verificacao == true){
            this.status = true;
        } else {
            this.status = false;
        }
        return this.status;
    }

    public void setDataRealizacao(String dataRealizacao) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataRealizacao = dateFormat.parse(dataRealizacao);
    }
}
