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
        Paciente paciente1 = new Paciente(usuarios.size()+1, "João Pedro", "Paciente", pacientes.size()+1);
        pacientes.add((Paciente) paciente1);
        usuarios.add(paciente1);

        Paciente paciente2 = new Paciente(usuarios.size()+1, "João Silva", "Paciente", pacientes.size()+1);
        pacientes.add((Paciente) paciente2);
        usuarios.add(paciente2);

        Paciente paciente3 = new Paciente(usuarios.size()+1, "José Afonso", "Paciente", pacientes.size()+1);
        pacientes.add((Paciente) paciente3);
        usuarios.add(paciente3);

        // Médicos:
        Medico medico1 = new Medico(usuarios.size()+1, "Marco Aurélio", "Medico", medicos.size()+1);
        medicos.add((Medico) medico1);
        usuarios.add(medico1);
        
        //Administradores:
        
        //Exames:
        Exame exame1 = new Exame(exames.size()+1, "Urina Tipo I");
        exames.add(exame1);
        
        Exame exame2 = new Exame(exames.size()+1, "Hemograma Completo");
        exames.add(exame1);

        Exame exame3 = new Exame(exames.size()+1, "Teste de Gravidez");
        exames.add(exame1);
        
        Exame exame4 = new Exame(exames.size()+1, "Ecografia Abdominal");
        exames.add(exame1);
        
        Exame exame5 = new Exame(exames.size()+1, "Eletrocardiograma (ECG)");
        exames.add(exame1);

        Exame exame6 = new Exame(exames.size()+1, "Colonoscopia");
        exames.add(exame1);
        
        Exame exame7 = new Exame(exames.size()+1, "Tomografia Computadorizada (TC):");
        exames.add(exame1);
        
        Exame exame8 = new Exame(exames.size()+1, "Ressonância Magnética (RM)");
        exames.add(exame1);

        Exame exame9 = new Exame(exames.size()+1, "Glicemia");
        exames.add(exame1);
        
        Exame exame10 = new Exame(exames.size()+1, "Colesterol Total e Frações");
        exames.add(exame1);

        //Autorizações:
        Autorizacao autorizacao1 = new Autorizacao(autorizacoes.size()+1, "Não realizado.", "01/10/2023", medico1, paciente1, exame1, false);
        autorizacoes.add(autorizacao1);
        
        Autorizacao autorizacao2 = new Autorizacao(autorizacoes.size()+1, "Não realizado.", "30/09/2023", medico1, paciente1, exame1, false);
        autorizacoes.add(autorizacao2);
        
        //Iniciando programa
        exibirMenu();
    	Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                exibirPacientes(pacientes);
                System.out.println("");
                System.out.println("Insira o ID do Paciente que deseja utilizar:");
                opcao = scanner.nextInt();
                exibirMenuPaciente(pacientes.get(opcao-1), autorizacoes);
                scanner.nextLine(); // Limpar o buffer do scanner
                break;
            case 2:
            	exibirMedicos(medicos);
                System.out.println("Insira o ID do Medico que deseja utilizar:");
                opcao = scanner.nextInt();
            	exibirMenuMedico(medicos.get(opcao-1), autorizacoes, pacientes, exames);
                scanner.nextLine(); // Limpar o buffer do scanner
                break;
            case 3:
            	exibirMenuAdministrador();
                break;
            case 0:
            	System.out.println("");
                System.out.println("Saindo do programa. Até mais!");
                break;
            default:
            	System.out.println("");
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println("");
                exibirMenu();
        }
	}

	private static void exibirMedicos(ArrayList<Medico> medicos) {
    	System.out.println("");
        System.out.println("Usuários Cadastrados:");
        for (Medico medico : medicos) {
        	System.out.println("");
        	System.out.println("  ID: " + medico.getId());
            System.out.println("Nome: " + medico.getNome());
        }
		
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
        System.out.println("Usuários Cadastrados:");
        for (Paciente paciente : pacientes) {
        	System.out.println("");
        	System.out.println("  ID: " + paciente.getIdPaciente());
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

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
            	paciente.listarAutorizacoesPorDataCadastro(autorizacoes);
            	System.out.println("");
            	System.out.println("1. Marcar um exame como realizado.");
            	System.out.println("0. Retornar ao Menu do Paciente.");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
            	if (opcao == 1) {
            		marcarExameRealizado(paciente, autorizacoes);
            		System.out.println("");
            		System.out.println("Retornando ao Menu do Paciente...");
            		System.out.println("");
            		exibirMenuPaciente(paciente, autorizacoes);
            	} else {
            		exibirMenuPaciente(paciente,autorizacoes);
            	}
                break;
            case 0:
            	System.out.println("");
                exibirMenu();
                break;
            default:
            	System.out.println("");
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println("");
                exibirMenuPaciente(paciente, autorizacoes);
        }
    }

    private static void marcarExameRealizado(Paciente paciente, ArrayList<Autorizacao> autorizacoes) {

    	System.out.println("Insira o ID da Autorização cujo Exame você deseja marcar como realizado:");
    	Scanner scanner = new Scanner(System.in);
    	int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println("Insira a data em que o exame foi realizado (formato dd/MM/yyyy):");
		String dataRealizacao = scanner.next();
        scanner.nextLine(); // Limpar o buffer do scanner
        paciente.marcarExameComoRealizado(autorizacoes.get(id-1),dataRealizacao);
	}

	private static void exibirMenuMedico(Medico medico,  ArrayList<Autorizacao> autorizacoes, ArrayList<Paciente> pacientes, ArrayList<Exame> exames) {
    	System.out.println("-- MENU DO MÉDICO --");
        System.out.println("Selecione o tipo de usuário a ser utilizado:");
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
            		System.out.println("Insira do ID do paciente a ser filtrado.");
            		int p = scanner.nextInt();
            		scanner.nextLine(); // Limpar o buffer do scanner
            		System.out.println("");
            		medico.listarAutorizacao(autorizacoes, pacientes.get(p-1));
            		System.out.println("");
            		System.out.println("Pressione qualquer tecla para voltar ao Menu do Médico.");
            	} else if (opcao == 2) {
            		exibirExames(exames);
               		System.out.println("Insira do ID do tipo de Exame a ser filtrado.");
            		int e = scanner.nextInt();
            		scanner.nextLine(); // Limpar o buffer do scanner
            		System.out.println("");
            		medico.listarAutorizacao(autorizacoes, exames.get(e-1));
            		System.out.println("");
            		System.out.println("Pressione qualquer tecla para voltar ao Menu do Médico.");
            	} else {
            		System.out.println("Erro. Retornando ao Menu do Médico.");
            	}
            	exibirMenuMedico(medico, autorizacoes, pacientes, exames);
                break;
            case 0:
            	System.out.println("");
                exibirMenu();
                break;
            default:
            	System.out.println("");
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println("");
                exibirMenuMedico(medico, autorizacoes, pacientes, exames);
        }
    }

    private static void exibirExames(ArrayList<Exame> exames) {
    	System.out.println("");
        System.out.println("Usuários Cadastrados:");
        for (Exame exame : exames) {
        	System.out.println("");
        	System.out.println("  ID: " + exame.getId());
            System.out.println("Nome: " + exame.getTipo());
        }
	}

	private static void exibirMenuAdministrador() {
    	System.out.println("-- MENU DO ADMINISTRADOR --");
        System.out.println("Selecione o tipo de usuário a ser utilizado:");
        System.out.println("");
        System.out.println("1. Incluir novo Usuário.");
        System.out.println("2. Buscar Usuário.");
        System.out.println("3. Exibir estatísticas gerais.");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.println("");
    }
}
