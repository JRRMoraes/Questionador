package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import br.com.JRRMoraes.Questionador.Dados.Beans.ProjetoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Projeto;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilCaminho;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class ProjetoWS {

	private final static String CAMINHO_RAIZ = "/projetos";

	private final static String CAMINHO_ID = UtilCaminho.caminhoId(CAMINHO_RAIZ);

	private static ProjetoBean _projetoBean = new ProjetoBean();


	public static void imporCaminhos() {
		get(CAMINHO_RAIZ, rotaConsultaRaiz);
		get(CAMINHO_ID, rotaConsultaPorId);
		post(CAMINHO_RAIZ, rotaSalva);
		put(CAMINHO_ID, rotaSalva);
	}


	private static Route rotaConsultaRaiz = (Request requisicao, Response resposta) -> {
		switch (UtilCaminho.parametroFuncao(requisicao)) {
			case UtilCaminho.FUNCAO_TODOS:
				return consultarTodos(requisicao, resposta);
			case UtilCaminho.FUNCAO_NOVO:
				return consultarNovo(requisicao, resposta);
		}
		return UtilRequisicaoEResposta.naoEncontrado(resposta);
	};


	private static Route rotaConsultaPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilCaminho.parametroId(requisicao);
		return UtilRequisicaoEResposta.responderSucesso(resposta, _projetoBean.consultarPorId(__id));
	};

	private static Route rotaSalva = (Request requisicao, Response resposta) -> {
		Projeto __projeto = _projetoBean.novo();
		return _projetoBean.salvar(__projeto);
	};


	private static String consultarNovo(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _projetoBean.novo());
	}


	private static String consultarTodos(Request requisicao, Response resposta) {
		return UtilRequisicaoEResposta.responderSucesso(resposta, _projetoBean.consultarTodos());
	}
}