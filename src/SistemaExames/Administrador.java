package SistemaExames;

import java.util.ArrayList;
import java.util.Scanner;

class Administrador extends Usuario {
	private ArrayList<Usuario> usuarios;
	private Scanner scanner;
	
	int idAdmin;

	public Administrador(int id, String nome, String tipo, int idAdmin) {
		super(id, nome, tipo);
		this.usuarios = new ArrayList<>();
		this.scanner = new Scanner(System.in);
		this.idAdmin = idAdmin;
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void incluirUsuario() {
		System.out.println("Digite o ID do novo usuário:");
		int id = scanner.nextInt();
		System.out.println("Digite o nome do novo usuário:");
		String nome = scanner.next();
		System.out.println("Digite o tipo do novo usuário:");
		String tipo = scanner.next();

		Usuario novoUsuario = new Usuario(id, nome, tipo);
		usuarios.add(novoUsuario);
	}

	public ArrayList<Usuario> buscarUsuariosPorNome(String nome) {
		ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			if (verificaNome(usuario.getNome(), nome)) {
				usuariosEncontrados.add(usuario);
			}
		}

		return usuariosEncontrados;
	}

	public void listarAutorizacoesUsuario(Usuario usuario, ArrayList<Autorizacao> autorizacoes) {
		System.out.println("Autorizações do usuário '" + usuario.getNome() + "':");
		if (usuario.getTipo().equals("médico")) {
			for (int i = 0; i < autorizacoes.size(); i++) {
				Autorizacao autorizacao = autorizacoes.get(i);
				if ((autorizacao.getMedico().getNome().equals(usuario.getNome()))) {
					System.out.println("ID: " + autorizacao.getId());
					System.out.println("Médico: " + autorizacao.getMedico().getNome());
					System.out.println("Paciente: " + autorizacao.getPaciente().getNome());
					System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
				}
			}
		} else if (usuario.getTipo().equals("paciente")) {
			for (int i = 0; i < autorizacoes.size(); i++) {
				Autorizacao autorizacao = autorizacoes.get(i);
				if ((autorizacao.getPaciente().getNome().equals(usuario.getNome()))) {
					System.out.println("ID: " + autorizacao.getId());
					System.out.println("Médico: " + autorizacao.getMedico().getNome());
					System.out.println("Paciente: " + autorizacao.getPaciente().getNome());
					System.out.println("Exame: " + autorizacao.getExameSolicitado().getTipo());
				}
			}
		}
	}

	public void estatisticasGerais(ArrayList<Medico> medicos, ArrayList<Autorizacao> autorizacoes, ArrayList<Paciente> pacientes) {
		System.out.println("Numero de medicos: " + medicos.size()); 
		System.out.println("Numero de pacientes: " + pacientes.size());
		System.out.println("Numero de autorizacoes: " + autorizacoes.size());
		
		int contador = 0;
		for (int i = 0; i < autorizacoes.size(); i++) {
			if (autorizacoes.get(i).getStatus()) {
				contador++;
			}
		}

		System.out.println("Porcentagem de exames realizados: " + ((contador / autorizacoes.size()) * 100) + "%");
	}

	private boolean verificaNome(String principal, String verificada) {
		int lenPrincipal = principal.length();
		int lenVerificada = verificada.length();

		for (int i = 0; i <= lenPrincipal - lenVerificada; i++) {
			int j;
			for (j = 0; j < lenVerificada; j++) {
				if (Character.toLowerCase(principal.charAt(i + j)) != Character.toLowerCase(verificada.charAt(j))) {
					break;
				}
			}

			if (j == lenVerificada) {
				return true;
			}
		}

		return false;
	}
}