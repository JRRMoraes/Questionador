package br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos;


public enum SelecaoExcelenteARuim {

	RUIM("Ruim"),
	MEDIO("Médio"),
	BOM("Bom"),
	EXCELENTE("Excelente");


	private String nome;


	private SelecaoExcelenteARuim(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}
}
