package br.com.JRRMoraes.Questionador.Dados.Lib;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {

	private static EntityManagerFactory _fabrica = Conexao.instanciarFabrica();


	private static EntityManagerFactory instanciarFabrica() {
		return Persistence.createEntityManagerFactory("questionador");
	}


	public static EntityManager obterGerenciador() {
		EntityManager __gerenciador = _fabrica.createEntityManager();
		return __gerenciador;
	}
}
