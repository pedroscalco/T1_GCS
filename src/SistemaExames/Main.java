package SistemaExames;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {

		// Criando ArrayLists que irão funcionar como um "banco de dados
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<Medico> medicos = new ArrayList<>();
		ArrayList<Paciente> pacientes = new ArrayList<>();
		ArrayList<Administrador> administradores = new ArrayList<>();
		ArrayList<Autorizacao> autorizacoes = new ArrayList<>();
		ArrayList<Exame> exames = new ArrayList<>();

		// Populando o banco
		// Pacientes:
		Paciente paciente1 = new Paciente(usuarios.size() + 1, "João Pedro", "Paciente", pacientes.size() + 1);
		pacientes.add((Paciente) paciente1);
		usuarios.add(paciente1);

		Paciente paciente2 = new Paciente(usuarios.size() + 1, "João Silva", "Paciente", pacientes.size() + 1);
		pacientes.add((Paciente) paciente2);
		usuarios.add(paciente2);

		Paciente paciente3 = new Paciente(usuarios.size() + 1, "José Afonso", "Paciente", pacientes.size() + 1);
		pacientes.add((Paciente) paciente3);
		usuarios.add(paciente3);

		// Médicos:
		Medico medico1 = new Medico(usuarios.size() + 1, "Marco Aurélio", "Medico", medicos.size() + 1);
		medicos.add((Medico) medico1);
		usuarios.add(medico1);

		// Administradores:
		Administrador admin1 = new Administrador(usuarios.size() + 1, "Roger", "Administrador",
				administradores.size() + 1);
		administradores.add((Administrador) admin1);
		usuarios.add(admin1);

		// Exames:
		Exame exame1 = new Exame(exames.size() + 1, "Urina Tipo I");
		exames.add(exame1);

		Exame exame2 = new Exame(exames.size() + 1, "Hemograma Completo");
		exames.add(exame2);

		Exame exame3 = new Exame(exames.size() + 1, "Teste de Gravidez");
		exames.add(exame3);

		Exame exame4 = new Exame(exames.size() + 1, "Ecografia Abdominal");
		exames.add(exame4);

		Exame exame5 = new Exame(exames.size() + 1, "Eletrocardiograma (ECG)");
		exames.add(exame5);

		Exame exame6 = new Exame(exames.size() + 1, "Colonoscopia");
		exames.add(exame6);

		Exame exame7 = new Exame(exames.size() + 1, "Tomografia Computadorizada (TC):");
		exames.add(exame7);

		Exame exame8 = new Exame(exames.size() + 1, "Ressonância Magnética (RM)");
		exames.add(exame8);

		Exame exame9 = new Exame(exames.size() + 1, "Glicemia");
		exames.add(exame9);

		Exame exame10 = new Exame(exames.size() + 1, "Colesterol Total e Frações");
		exames.add(exame10);

		// Autorizações:
		Autorizacao autorizacao1 = new Autorizacao(autorizacoes.size() + 1, "01/10/2023", "Não realizado.", medico1,
				paciente1, exame1, false);
		autorizacoes.add(autorizacao1);

		Autorizacao autorizacao2 = new Autorizacao(autorizacoes.size() + 1, "30/09/2023", "Não realizado.", medico1,
				paciente1, exame1, false);
		autorizacoes.add(autorizacao2);

		// Iniciando programa

		int opcao = 5;

		while (opcao != 0) {
			exibirMenu();
			Scanner scanner = new Scanner(System.in);
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner

			switch (opcao) {
			case 1:
				exibirPacientes(pacientes);
				System.out.println("");
				System.out.println("Insira o ID do Paciente que deseja utilizar:");
				int idPaciente = scanner.nextInt();
				exibirMenuPaciente(pacientes.get(idPaciente - 1), autorizacoes);
				scanner.nextLine(); // Limpar o buffer do scanner
				break;
			case 2:
				exibirMedicos(medicos);
				System.out.println("Insira o ID do Medico que deseja utilizar:");
				int idMedico = scanner.nextInt();
				exibirMenuMedico(medicos.get(idMedico - 1), autorizacoes, pacientes, exames);
				scanner.nextLine(); // Limpar o buffer do scanner
				break;
			case 3:
				exibirAdministradores(administradores);
				System.out.println("Insira o ID do Administrador que deseja utilizar:");
				int idAdministrador = scanner.nextInt();
				exibirMenuAdministrador(administradores.get(idAdministrador - 1), medicos, autorizacoes, pacientes,
						exames, usuarios, administradores);
				scanner.nextLine(); // Limpar o buffer do scanner
				break;
			case 0:
				System.out.println("");
				System.out.println("Saindo do programa. Até mais!");
				break;
			default:
				System.out.println("");
				System.out.println("Opção inválida. Tente novamente.");
				System.out.println("");
			}
		}
	}

	private static void exibirAdministradores(ArrayList<Administrador> administradores) {
		System.out.println("");
		System.out.println("Administradores Cadastrados:");
		for (Administrador administrador : administradores) {
			System.out.println("");
			System.out.println("ID: " + administrador.getIdAdmin());
			System.out.println("Nome: " + administrador.getNome());
		}
	}

	private static void exibirMedicos(ArrayList<Medico> medicos) {
		System.out.println("");
		System.out.println("Médicos Cadastrados:");
		for (Medico medico : medicos) {
			System.out.println("");
			System.out.println("ID: " + medico.getIdMedico());
			System.out.println("Nome: " + medico.getNome());
		}
		System.out.println("");
	}

	private static void exibirMenu() {
		System.out.println("-- MENU PRINCIPAL --");
		System.out.println("Selecione o tipo de usuário a ser utilizado:");
		System.out.println("");
		System.out.println("1. Paciente");
		System.out.println("2. Médico");
		System.out.println("3. Administrador");
		System.out.println("0. Sair");
		System.out.println("");
	}

	private static void exibirPacientes(ArrayList<Paciente> pacientes) {
		System.out.println("");
		System.out.println("Pacientes Cadastrados:");
		for (Paciente paciente : pacientes) {
			System.out.println("");
			System.out.println("ID: " + paciente.getIdPaciente());
			System.out.println("Nome: " + paciente.getNome());
		}
	}

	private static void exibirMenuPaciente(Paciente paciente, ArrayList<Autorizacao> autorizacoes) {
		System.out.println("");
		System.out.println("-- MENU DO PACIENTE --");
		System.out.println("Selecione uma ação:");
		System.out.println("");
		System.out.println("1. Listar Autorizações.");
		System.out.println("0. Voltar ao Menu Principal");
		System.out.println("");

		Scanner scanner = new Scanner(System.in);

		int z = 5;
		while (z != 0) {
			z = scanner.nextInt();
			switch (z) {
			case 1:
				int contaAutorizacoes = paciente.listarAutorizacoesPorDataCadastro(autorizacoes);
				System.out.println("");
				if (contaAutorizacoes > 0) {
					System.out.println("1. Marcar um exame como realizado.");
					System.out.println("2. Reagendar um exame.");
					System.out.println("0. Retornar ao Menu do Paciente.");
					int k = 5;
					scanner.nextLine(); // Limpar o buffer do scanner
					while (k != 0) {
						k = scanner.nextInt();
						switch (k) {
						case 1:
							marcarExameRealizado(paciente, autorizacoes);
							System.out.println("");
							System.out.println("Pressione qualquer tecla para voltar ao Menu do Paciente.");
							String a = scanner.next();
							System.out.println("");
							exibirMenuPaciente(paciente, autorizacoes);
						case 2:
							reagendamento(paciente, autorizacoes);
							System.out.println("");
							System.out.println("Pressione qualquer tecla para voltar ao Menu do Paciente.");
							String b = scanner.next();
							System.out.println("");
						case 0:
							exibirMenuPaciente(paciente, autorizacoes);
						default:
							System.out.println("");
							System.out.println("Opção inválida. Tente novamente.");
						}
					}
				}
				else {
					System.out.println("Pressione qualquer tecla para voltar ao Menu do Paciente.");
					String a = scanner.next();
					System.out.println("");
					exibirMenuPaciente(paciente, autorizacoes);
				}
				break;
			case 0:
				System.out.println("");
				break;
			default:
				System.out.println("");
				System.out.println("Opção inválida. Tente novamente.");
				exibirMenuPaciente(paciente, autorizacoes);
			}
		}
	}

	private static void reagendamento(Paciente paciente, ArrayList<Autorizacao> autorizacoes) {
		System.out.println("Insira o ID da Autorização cujo Exame você deseja reagendar:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer do scanner
		System.out.println("Insira a nova data de soliticação do Exame(formato dd/MM/yyyy):");
		String novaData = scanner.next();
		scanner.nextLine(); // Limpar o buffer do scanner
		paciente.solicitarReagendamento(autorizacoes.get(id - 1), novaData);
	}

	private static void marcarExameRealizado(Paciente paciente, ArrayList<Autorizacao> autorizacoes) {

		System.out.println("Insira o ID da Autorização cujo Exame você deseja marcar como realizado:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer do scanner
		System.out.println("Insira a data em que o exame foi realizado (formato dd/MM/yyyy):");
		String dataRealizacao = scanner.next();
		scanner.nextLine(); // Limpar o buffer do scanner
		paciente.marcarExameComoRealizado(autorizacoes.get(id - 1), dataRealizacao);
	}

	private static void exibirMenuMedico(Medico medico, ArrayList<Autorizacao> autorizacoes,
			ArrayList<Paciente> pacientes, ArrayList<Exame> exames) {
		System.out.println("");
		System.out.println("-- MENU DO MÉDICO --");
		System.out.println("Selecione a ação a ser realizada:");
		System.out.println("");
		System.out.println("1. Listar Autorizações.");
		System.out.println("2. Incluir nova Autorização.");
		System.out.println("0. Sair");
		System.out.println("");

		Scanner scanner = new Scanner(System.in);

		int opcao = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer do scanner

		switch (opcao) {
		case 1:
			System.out.println("");
			System.out.println("Selecione o tipo de filtro:");
			System.out.println("1. Paciente.");
			System.out.println("2. Tipo de exame.");
			System.out.println("");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner
			if (opcao == 1) {
				exibirPacientes(pacientes);
				System.out.println("");
				System.out.println("Insira o ID do paciente a ser filtrado.");
				int p = scanner.nextInt();
				scanner.nextLine(); // Limpar o buffer do scanner
				System.out.println("");
				int contaAutorizacoes = medico.listarAutorizacao(autorizacoes, pacientes.get(p - 1));
				System.out.println("");
				if (contaAutorizacoes > 0) {
					System.out.println("Selecione uma ação:");
					System.out.println("1. Alterar tipo de Exame de uma Autorização.");
					System.out.println("0. Retornar ao Menu do Médico.");
					int y = 5;
					while (y != 0) {
						y = scanner.nextInt();
						switch (y) {
						case 1:
							alteracaoTipoExame(exames,p, autorizacoes, medico);
						case 0:
							exibirMenuMedico(medico, autorizacoes, pacientes, exames);
							break;
						default:
							System.out.println("");
							System.out.println("Erro. Tente novamente.");
						}
					}
					System.out.println("");
				} else {
				System.out.println("");
				System.out.println("Pressione qualquer tecla para voltar ao Menu do Médico.");
				String a = scanner.next();
				scanner.nextLine(); // Limpar o buffer do scanner
				}
			} else if (opcao == 2) {
				exibirExames(exames);
				System.out.println("Insira do ID do tipo de Exame a ser filtrado.");
				int e = scanner.nextInt();
				scanner.nextLine(); // Limpar o buffer do scanner
				System.out.println("");
				medico.listarAutorizacao(autorizacoes, exames.get(e - 1));
				System.out.println("");
				System.out.println("Pressione qualquer tecla para voltar ao Menu do Médico.");
				String a = scanner.next();
				scanner.nextLine(); // Limpar o buffer do scanner
			} else {
				System.out.println("Erro. Retornando ao Menu do Médico.");
			}
			exibirMenuMedico(medico, autorizacoes, pacientes, exames);
			break;
		case 2:
			System.out.println("");
			System.out.println("Insira a data de hoje:");
			String dataCadastro = scanner.next();
			scanner.nextLine(); // Limpar o buffer do scanner
			exibirPacientes(pacientes);
			System.out.println("Insira o ID do paciente a ser examinado:");
			int p = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner
			exibirExames(exames);
			System.out.println("Insira o ID do exame a ser examinado:");
			int e = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner
			Autorizacao autorizacao = new Autorizacao(autorizacoes.size() + 1, dataCadastro, "Não realizado", medico,
					pacientes.get(p - 1), exames.get(e - 1), false);
			medico.incluirAutorizacao(autorizacao, autorizacoes);
			System.out.println("Pressione qualquer tecla para voltar ao Menu do Médico.");
			String a = scanner.next();
			scanner.nextLine(); // Limpar o buffer do scanner
			exibirMenuMedico(medico, autorizacoes, pacientes, exames);
			break;
		case 0:
			System.out.println("");
			break;
		default:
			System.out.println("");
			System.out.println("Opção inválida. Tente novamente.");
			System.out.println("");
			exibirMenuMedico(medico, autorizacoes, pacientes, exames);
		}
	}

	private static void alteracaoTipoExame(ArrayList<Exame> exames, int p, ArrayList<Autorizacao> autorizacoes, Medico medico) {
		System.out.println("");
		System.out.println("Insira o ID da Autorização cujo Exame você deseja alterar:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer do scanner
		exibirExames(exames);
		System.out.println("Insira o ID do tipo de Exame que será realizado:");
		int tipoExame = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer do scanner
		medico.alterarTipoExame(autorizacoes.get(id - 1), tipoExame, exames);
	}

	private static void exibirExames(ArrayList<Exame> exames) {
		System.out.println("");
		System.out.println("EXAMES CADASTRADOS:");
		for (Exame exame : exames) {
			System.out.println("");
			System.out.println("  ID: " + exame.getId());
			System.out.println("Nome: " + exame.getTipo());
		}
	}

	private static void exibirMenuAdministrador(Administrador administrador, ArrayList<Medico> medicos,
			ArrayList<Autorizacao> autorizacoes, ArrayList<Paciente> pacientes, ArrayList<Exame> exames,
			ArrayList<Usuario> usuarios, ArrayList<Administrador> administradores) {
		System.out.println("-- MENU DO ADMINISTRADOR --");
		System.out.println("Selecione a ação a ser realizada:");
		System.out.println("");
		System.out.println("1. Incluir novo Usuário.");
		System.out.println("2. Buscar Usuário.");
		System.out.println("3. Exibir estatísticas gerais.");
		System.out.println("0. Voltar ao Menu Principal");
		System.out.println("");

		Scanner scanner = new Scanner(System.in);

		int opcao = scanner.nextInt();

		switch (opcao) {
		case 1:
			administrador.incluirUsuario(usuarios, administradores, medicos, pacientes);
			System.out.println("Pressione qualquer tecla para voltar ao Menu do Administrador.");
			int e = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner
			exibirMenuAdministrador(administrador, medicos, autorizacoes, pacientes, exames, usuarios, administradores);
			break;
		case 2:
			System.out.println("");
			System.out.println("Insira o nome a ser buscado:");
			String nome = scanner.next();
			scanner.nextLine(); // Limpar o buffer do scanner
			administrador.buscarUsuariosPorNome(nome, usuarios);
			System.out.println("Pressione qualquer tecla para voltar ao Menu do Administrador.");
			String a = scanner.nextLine();
			exibirMenuAdministrador(administrador, medicos, autorizacoes, pacientes, exames, usuarios, administradores);
		case 3:
			administrador.estatisticasGerais(medicos, autorizacoes, pacientes);
			System.out.println("Pressione qualquer tecla para voltar ao Menu do Administrador.");
			String b = scanner.next();
			exibirMenuAdministrador(administrador, medicos, autorizacoes, pacientes, exames, usuarios, administradores);
		case 0:
			System.out.println("");
			break;
		default:
			System.out.println("");
			System.out.println("Opção inválida. Tente novamente.");
			System.out.println("");
			exibirMenuAdministrador(administrador, medicos, autorizacoes, pacientes, exames, usuarios, administradores);
		}
	}
}
