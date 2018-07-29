package br.com.JRRMoraes.Questionador.Dados.Lib;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {

	private static EntityManagerFactory fabrica;

	// = Conexao.instanciarFabrica();


	private static EntityManagerFactory obterFabrica() {
		if ((fabrica == null) || (!fabrica.isOpen()))
			fabrica = Persistence.createEntityManagerFactory("questionador");
		return fabrica;
	}


	public static EntityManager obterGerenciador() {
		EntityManager gerenciador = obterFabrica().createEntityManager();
		return gerenciador;
	}


	public static void fecharFabrica() {
		obterFabrica().close();
	}
}