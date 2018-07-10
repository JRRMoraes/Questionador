package br.com.JRRMoraes.Questionador.Spark.Lib;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import br.com.JRRMoraes.Questionador.Spark.Principal.Aplicativo;
import spark.Spark;


public class BaseTestes {

	@BeforeClass
	public static void beforeClass() {
		Aplicativo.main(null);
	}


	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}
}