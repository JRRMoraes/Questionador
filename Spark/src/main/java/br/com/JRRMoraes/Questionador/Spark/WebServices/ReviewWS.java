package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.ReviewBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Review;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class ReviewWS {

	public static void ImporCaminhos() {
		get(ReviewWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, ReviewWS.novo);
		get(ReviewWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, ReviewWS.consultarPorId);
		get(ReviewWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, ReviewWS.consultarTodos);
		post(ReviewWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, ReviewWS.salvar);
	}


	private static ReviewBean _reviewBean = new ReviewBean();

	public final static String CAMINHO_RAIZ = "/review/";


	public static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _reviewBean.novo());
	};


	public static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _reviewBean.consultarPorId(__id));
	};


	public static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _reviewBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		Review __review = _reviewBean.novo();
		return _reviewBean.salvar(__review);
	};
}