package SistemaExames;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Medico extends Usuario {
	
	int idMedico;
	
	public Medico(int id, String nome, String tipo, int idMedico) {
		super(id, nome, tipo);
		this.idMedico = idMedico;
	}

	public int getIdMedico() {
		return this.idMedico;
	}

	public ArrayList<Autorizacao> incluirAutorizacao(Autorizacao autorizacao, ArrayList <Autorizacao> autorizacoes) { 
		autorizacoes.add(autorizacao);
		return autorizacoes;
	}

	public void listarAutorizacao(ArrayList <Autorizacao> autorizacoes, Paciente paciente){
    	List <Autorizacao> autorizacoesPaciente = new ArrayList<>();

    	for (Autorizacao autorizacao : autorizacoes) {
    		if (autorizacao.getPaciente().getId() == paciente.getId()) {
    			autorizacoesPaciente.add(autorizacao);
    		}
    	}
    	
    	int n = autorizacoesPaciente.size();
        
    	if (n > 1) {
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                // Comparando as datas e trocando se necessário
	                if (compararDatas(autorizacoesPaciente.get(j).getDataCadastro(), autorizacoesPaciente.get(j + 1).getDataCadastro()) > 0) {
	                    // Trocando os objetos de posição
	                    Autorizacao temp = autorizacoesPaciente.get(j);
	                    autorizacoesPaciente.set(j, autorizacoesPaciente.get(j + 1));
	                    autorizacoesPaciente.set(j + 1, temp);
	                }
	            }
	        }

        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE " + paciente.getNome().toUpperCase() + " --");
	        
        	for (Autorizacao autorizacao : autorizacoesPaciente) {
    	        System.out.println("");
    	        System.out.println("ID: " + autorizacao.getId());
	        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
	        	System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
	            System.out.println("Data de solicitação: " + autorizacao.getDataCadastro());
	            System.out.println("Data de realização do exame: " + autorizacao.getDataRealizacao());
	        }
    	} else if (n == 1) {
    		Autorizacao autorizacao = autorizacoesPaciente.get(0);
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        System.out.println("");
	        System.out.println("ID: " + autorizacao.getId());
        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
        	System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
    		System.out.println("Data de solicitação: " + autorizacao.getDataCadastro());
            System.out.println("Data de realização do exame: " + autorizacao.getDataRealizacao());

    	} else {
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        System.out.println("");
	        System.out.println("Nenhuma autorização encontrada.");
    	}
	}

	public void listarAutorizacao(ArrayList <Autorizacao> autorizacoes, Exame exame){
    	List <Autorizacao> autorizacoesTipoExame = new ArrayList<>();

    	for (Autorizacao autorizacao : autorizacoes) {
    		if (autorizacao.getExameSolicitado().getTipo() == exame.getTipo()) {
    			autorizacoesTipoExame.add(autorizacao);
    		}
    	}
    	
    	int n = autorizacoesTipoExame.size();
        
    	if (n > 1) {
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                // Comparando as datas e trocando se necessário
	                if (compararDatas(autorizacoesTipoExame.get(j).getDataCadastro(), autorizacoesTipoExame.get(j + 1).getDataCadastro()) > 0) {
	                    // Trocando os objetos de posição
	                    Autorizacao temp = autorizacoesTipoExame.get(j);
	                    autorizacoesTipoExame.set(j, autorizacoesTipoExame.get(j + 1));
	                    autorizacoesTipoExame.set(j + 1, temp);
	                }
	            }
	        }
	        
        	System.out.println("-- AUTORIZAÇÕES DOS EXAMES " + exame.getTipo().toUpperCase() + " --");
	        
        	for (Autorizacao autorizacao : autorizacoesTipoExame) {
    	        System.out.println("");
    	        System.out.println("ID: " + autorizacao.getId());
	        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
	        	System.out.println("Paciente: " + autorizacao.getPaciente().getNome());
	            System.out.println("Data de solicitação:" + autorizacao.getDataCadastro());
	            System.out.println("Data de realização do exame:" + autorizacao.getDataRealizacao());
	        }
    	} else if (n == 1) {
    		Autorizacao autorizacao = autorizacoesTipoExame.get(0);
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        System.out.println("");
	        System.out.println("ID: " + autorizacao.getId());
        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
        	System.out.println("Paciente: " + autorizacao.getPaciente().getNome());
        	System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
    		System.out.println("Data de solicitação:" + autorizacao.getDataCadastro());
            System.out.println("Data de realização do exame:" + autorizacao.getDataRealizacao());

    	} else {
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        System.out.println("");
	        System.out.println("Nenhuma autorização encontrada.");
    	}
	}
	
    public static int compararDatas(String data1, String data2) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = format.parse(data1);
            Date date2 = format.parse(data2);
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace(); // Tratar a exceção conforme necessário
            return 0; // Retorna 0 em caso de erro, indicando que as datas são consideradas iguais
        }
    }
}
