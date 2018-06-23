package br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos;


public enum SelecaoExcelenteARuim {

	RUIM("Ruim"),
	MEDIO("Médio"),
	BOM("Bom"),
	EXCELENTE("Excelente");


	private String _nome;


	private SelecaoExcelenteARuim(String nome) {
		_nome = nome;
	}


	public String getNome() {
		return _nome;
	}
}
