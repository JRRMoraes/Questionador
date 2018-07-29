package br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos;


public enum TipoQuestaoEscolha {

	FALSA((byte) 0),
	CORRETA((byte) 1),
	IRRELEVANTE((byte) 2);

	private byte id;


	private TipoQuestaoEscolha(byte id) {
		this.id = id;
	}


	public byte getId() {
		return id;
	}
}