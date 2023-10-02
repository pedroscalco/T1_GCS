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

	public void incluirUsuario(ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores, ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
    	System.out.println("");
    	System.out.println("Insira o Nome do Usuário:");
    	String nomeUsuario = scanner.nextLine();
    	System.out.println("");
    	System.out.println("1 - Administrador   2 -  Médico   3 - Paciente");
    	System.out.println("");
    	System.out.println("Insira o ID do tipo de Usuário:");
    	int t = 5;
    	String tipo = "";
    	while (t<1 || t>3) {
    		t = scanner.nextInt();
        	scanner.nextLine(); // Limpar o buffer do scanner
        	switch (t) {
        		case 1: tipo = "Administrador";
        				Administrador novoAdmin = new Administrador(usuarios.size()+1, nomeUsuario, tipo, administradores.size()+1);
        				administradores.add(novoAdmin);
        				usuarios.add(novoAdmin);
		        		break;
        		case 2: tipo = "Médico";
        				Medico novoMedico = new Medico(usuarios.size()+1, nomeUsuario, tipo, medicos.size()+1);
		        		medicos.add(novoMedico);
        				usuarios.add(novoMedico);
		        		break;
        		case 3: tipo = "Paciente";
        				Paciente novoPaciente = new Paciente(usuarios.size()+1, nomeUsuario, tipo, pacientes.size()+1);
		        		pacientes.add(novoPaciente);
        				usuarios.add(novoPaciente);
		        		break;
        		default: System.out.println("Cógido inválido. Insira um dos IDs abaixo.");
        		System.out.println("");
        		System.out.println("1 - Administrador   2 -  Médico   3 - Paciente");
        		System.out.println("");
        		break;
        	}
    	}
    	System.out.println("");
    	System.out.println("Usuário cadastrado com sucesso!");
    	System.out.println();
	}

	public void buscarUsuariosPorNome(String nome, ArrayList<Usuario> usuarios) {
		ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			if (verificaNome(usuario.getNome(), nome)) {
				usuariosEncontrados.add(usuario);
			}
		}
		
		System.out.println("");
        System.out.println("Usuários Cadastrados:");
        for (Usuario usuario : usuariosEncontrados) {
        	System.out.println("");
        	System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Tipo: " + usuario.getTipo());
        }
        System.out.println("");
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
		System.out.println("Número de Médicos: " + medicos.size()); 
		System.out.println("Número de Pacientes: " + pacientes.size());
		System.out.println("Número de Autorizações: " + autorizacoes.size());
		
		double contador = 0;
		for (Autorizacao autorizacao : autorizacoes) {
			if (autorizacao.getStatus()) {
				contador++;
			}
		}

		System.out.println("Porcentagem de exames realizados: " + ((contador / autorizacoes.size()) * 100) + "%");
		System.out.println("");
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