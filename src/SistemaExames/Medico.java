package SistemaExames;
import java.util.ArrayList;

class Medico extends Usuario {
	
	Autorizacao autorizacao = new Autorizacao();
	ArrayList<Autorizacao> aut = new ArrayList<>();


	public Medico(int id, String nome, String tipo) {
		super(id, nome, tipo);
	}


	private void incluirAutorizacao(Autorizacao autorizacao) { 
		this.aut.add(autorizacao);
	}


	private void listarAutorizacao(){
		for (Autorizacao autorizacao : this.aut){
			System.out.println(autorizacao);
		}
	}
}
