package SistemaExames;

class Autorizacao {
    private int id;
    private String dataCadastro;
    private Usuario medico;
    private Usuario paciente;
    private Exame exameSolicitado;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario getMedico() {
        return this.medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Usuario getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Exame getExameSolicitado() {
        return this.exameSolicitado;
    }

    public void setExameSolicitado(Exame exameSolicitado) {
        this.exameSolicitado = exameSolicitado;
    }
}
