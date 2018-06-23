package br.com.JRRMoraes.Questionador.Dados.Lib;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {

	private static EntityManagerFactory _fabrica = Persistence.createEntityManagerFactory("questionador_mysql");


	public static EntityManager NovoGerenciador() {
		EntityManager __gerenciador = _fabrica.createEntityManager();
		return __gerenciador;
	}
}
