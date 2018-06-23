package br.com.JRRMoraes.Questionador.Wildfly.Principal;


import org.wildfly.swarm.datasources.DatasourcesFraction;


public class FabricaConexoes {

	public static final String bancoDados = "questionario";


	public static DatasourcesFraction conexaoMysql() {
		return new DatasourcesFraction().jdbcDriver("com.mysql", d -> {
			d.driverClassName("com.mysql.jdbc.Driver");
			d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
			d.driverModuleName("com.mysql");
		}).dataSource(bancoDados, ds -> {
			ds.driverName("com.mysql");
			ds.connectionUrl("jdbc:mysql://localhost/questionador?createDatabaseIfNotExist=true&&useSSL=false");
			ds.userName("root");
			ds.password("abc123!");
		});
	}
}
