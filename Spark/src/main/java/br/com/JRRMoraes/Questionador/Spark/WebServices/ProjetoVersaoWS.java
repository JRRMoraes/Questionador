package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoVersaoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.ProjetoVersao;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class ProjetoVersaoWS {

	public static void ImporCaminhos() {
		get(ProjetoVersaoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, ProjetoVersaoWS.novo);
		get(ProjetoVersaoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, ProjetoVersaoWS.consultarPorId);
		get(ProjetoVersaoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, ProjetoVersaoWS.consultarTodos);
		post(ProjetoVersaoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, ProjetoVersaoWS.salvar);
	}


	private static ProjetoVersaoBean _projetoVersaoBean = new ProjetoVersaoBean();

	protected final static String CAMINHO_RAIZ = "/projetoversao/";


	protected static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoVersaoBean.novo());
	};


	protected static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoVersaoBean.consultarPorId(__id));
	};


	protected static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoVersaoBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		ProjetoVersao __projetoVersao = _projetoVersaoBean.novo();
		return _projetoVersaoBean.salvar(__projetoVersao);
	};
}