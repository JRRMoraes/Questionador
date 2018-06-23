package br.com.JRRMoraes.Questionador.Spark.WebServices;


import static spark.Spark.get;
import static spark.Spark.post;
import br.com.JRRMoraes.Questionador.Dados.Beans.UsuarioBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Usuario;
import br.com.JRRMoraes.Questionador.Spark.Lib.UtilRequisicaoEResposta;
import spark.Request;
import spark.Response;
import spark.Route;


public class UsuarioWS {

	public static void ImporCaminhos() {
		get(UsuarioWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_NOVO, UsuarioWS.novo);
		get(UsuarioWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_ID, UsuarioWS.consultarPorId);
		get(UsuarioWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_TODOS, UsuarioWS.consultarTodos);
		post(UsuarioWS.CAMINHO_RAIZ + UtilRequisicaoEResposta.PARAM_SALVAR, UsuarioWS.salvar);
	}


	private static UsuarioBean _usuarioBean = new UsuarioBean();

	public final static String CAMINHO_RAIZ = "/usuario/";


	public static Route novo = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _usuarioBean.novo());
	};


	public static Route consultarPorId = (Request requisicao, Response resposta) -> {
		long __id = UtilRequisicaoEResposta.ParametroID(requisicao);
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _usuarioBean.consultarPorId(__id));
	};


	public static Route logar = (Request requisicao, Response resposta) -> {
		String __nome = requisicao.params(":N");
		String __senha = requisicao.params(":S");
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _usuarioBean.logar(__nome, __senha));
	};


	public static Route consultarTodos = (Request requisicao, Response resposta) -> {
		return UtilRequisicaoEResposta.enviarJsonNaResposta(resposta, _usuarioBean.consultarTodos());
	};


	public static Route salvar = (Request requisicao, Response resposta) -> {
		Usuario __usuario = _usuarioBean.novo();
		return _usuarioBean.salvar(__usuario);
	};
}