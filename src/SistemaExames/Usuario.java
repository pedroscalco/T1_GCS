package SistemaExames;

class Usuario {

	private int id;
	private String nome;
	private String tipo;
	
	public Usuario(int id, String nome, String tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	int getId() {
		return id;
	}

	String getNome() {
		return nome;
	}

	String getTipo() {
		return tipo;
	}
}
