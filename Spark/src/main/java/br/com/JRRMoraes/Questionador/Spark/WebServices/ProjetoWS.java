package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class ProjetoWS {

	public static void ImporCaminhos() {
		get(ProjetoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, ProjetoWS.novo);
		get(ProjetoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, ProjetoWS.consultarPorId);
		get(ProjetoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, ProjetoWS.consultarTodos);
		post(ProjetoWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, ProjetoWS.salvar);
	}


	private static ProjetoBean _projetoBean = new ProjetoBean();

	protected final static String CAMINHO_RAIZ = "/projeto/";


	protected static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoBean.novo());
	};


	protected static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoBean.consultarPorId(__id));
	};


	protected static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _projetoBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		Projeto __projeto = _projetoBean.novo();
		return _projetoBean.salvar(__projeto);
	};
}