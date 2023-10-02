package SistemaExames;

import java.util.List;

class Autorizacao {
    private int id;
    private String dataCadastro;
    private String dataRealizacao;
    private Usuario medico;
    private Usuario paciente;
    private Exame exameSolicitado;
    private boolean status;

    public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public Autorizacao(int id, String dataCadastro, String dataRealizacao, Usuario medico, Usuario paciente, Exame exameSolicitado, boolean status) {
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.dataRealizacao = dataRealizacao;
		this.medico = medico;
		this.paciente = paciente;
		this.exameSolicitado = exameSolicitado;
		this.status = status;
	}

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
