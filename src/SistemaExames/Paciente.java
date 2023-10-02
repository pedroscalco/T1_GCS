package SistemaExames;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Usuario {

	int idPaciente;
	
    public Paciente(int id, String nome, String tipo, int idPaciente) {
        super(id, nome, "Paciente");
        this.idPaciente = idPaciente;
    }

    // Método para listar as autorizações de exame do paciente ordenadas pela data de cadastro
    public void listarAutorizacoesPorDataCadastro(ArrayList<Autorizacao> autorizacoes) {
    	
    	List <Autorizacao> autorizacoesPaciente = new ArrayList<>();

    	for (Autorizacao autorizacao : autorizacoes) {
    		if (autorizacao.getPaciente().getId() == this.getId()) {
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
	        
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        
        	for (Autorizacao autorizacao : autorizacoesPaciente) {
    	        System.out.println("");
    	        System.out.println("ID: " + autorizacao.getId());
	        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
	        	System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
	            System.out.println("Data de solicitação:" + autorizacao.getDataCadastro());
	            System.out.println("Data de realização do exame:" + autorizacao.getDataRealizacao());
	        }
    	} else {
    		Autorizacao autorizacao = autorizacoesPaciente.get(0);
        	System.out.println("-- AUTORIZAÇÕES DO PACIENTE --");
	        System.out.println("");
	        System.out.println("ID: " + autorizacao.getId());
        	System.out.println("Médico: " + autorizacao.getMedico().getNome());
        	System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
    		System.out.println("Data de solicitação:" + autorizacao.getDataCadastro());
            System.out.println("Data de realização do exame:" + autorizacao.getDataRealizacao());

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

    // Método para marcar um exame como realizado e verificar se a ação é permitida
	public void marcarExameComoRealizado(Autorizacao autorizacao, String dataRealizacao) {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
    		System.out.println(autorizacao.getExameSolicitado().getTipo());
    		System.out.println(dataRealizacao);
            Date dataSolicitacao = dateFormat.parse(autorizacao.getDataCadastro());
            Date dataMarcacao = dateFormat.parse(dataRealizacao);

            long diferencaEmMillis = dataMarcacao.getTime() - dataSolicitacao.getTime();
            int diasDecorridos = (int) (diferencaEmMillis / (24 * 60 * 60 * 1000));

            // O paciente pode marcar como realizado antes da data de solicitação ou até 30 dias após
            if (diasDecorridos >= 0 && diasDecorridos <= 30 && !autorizacao.getStatus()) {
            	autorizacao.setDataRealizacao(dataRealizacao); // Atualiza a data de realização no Exame
            	autorizacao.setStatus(true); // Marca o exame como realizado
                System.out.println("Exame foi marcado como 'realizado' com sucesso!");
            }
        } catch (Exception e) {
        	System.out.println("O exame não pode ser marcado como 'realizado'. Verifique as condições.");
            e.printStackTrace();
        }
    }

	public int getIdPaciente() {
		return this.idPaciente;
	}
}
