package br.com.JRRMoraes.Questionador.Wildfly.Principal;


import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import br.com.JRRMoraes.Questionador.Wildfly.Interceptadores.InterceptadorParaLogs;


public class Main {

	public static void main(String[] args) throws Exception {
		Swarm _swarm = new Swarm(args);
		_swarm.fraction(FabricaConexoes.conexaoMysql());
		_swarm.start();

		JAXRSArchive _arquivo = ShrinkWrap.create(JAXRSArchive.class);
		_arquivo.addPackage("br.com.JRRMoraes.Questionador.Dados");
		_arquivo.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()),
				"classes/META-INF/persistence.xml");
		////// _arquivo.addAsWebInfResource(classLoader.getResource("beans.xml"),"beans.xml");

		// List<Class<?>> _classes = ConteudoB.listarTodasAsClasses();
		// _classes.forEach(_c -> _arquivo.addClass(_c));

		// Class[] _classes = Conteudo.listarClassesDeConjuntos();
		// for (int _i = 0; _i < _classes.length; _i++)
		// _arquivo.addClass(_classes[_i]);
		// _classes = Conteudo.listarClassesDeEntidades();
		// for (int _i = 0; _i < _classes.length; _i++)
		// _arquivo.addClass(_classes[_i]);
		// _classes = Conteudo.listarClassesDeDAOs();
		// for (int _i = 0; _i < _classes.length; _i++)
		// _arquivo.addClass(_classes[_i]);
		// _classes = Conteudo.listarClassesDeBeans();
		// for (int _i = 0; _i < _classes.length; _i++)
		// _arquivo.addClass(_classes[_i]);


		// _arquivo.addClass(ObrigacaoQuestao.class);
		// _arquivo.addClass(SelecaoExcelenteARuim.class);
		// _arquivo.addClass(TipoEvento.class);
		// _arquivo.addClass(TipoQuestao.class);
		// _arquivo.addClass(TipoQuestaoEscolha.class);
		// _arquivo.addClass(Espectador.class);
		// _arquivo.addClass(Evento.class);
		// _arquivo.addClass(EventoPresenca.class);
		// _arquivo.addClass(EventoQuestionario.class);
		// _arquivo.addClass(EventoResposta.class);
		// _arquivo.addClass(Projeto.class);
		// _arquivo.addClass(ProjetoVersao.class);
		// _arquivo.addClass(Questao.class);
		// _arquivo.addClass(QuestaoEscolha.class);
		// _arquivo.addClass(Questionario.class);
		// _arquivo.addClass(Review.class);
		// _arquivo.addClass(Usuario.class);
		// _arquivo.addClass(EspectadorDAO.class);
		// _arquivo.addClass(EventoDAO.class);
		// _arquivo.addClass(EventoPresencaDAO.class);
		// _arquivo.addClass(EventoQuestionarioDAO.class);
		// _arquivo.addClass(EventoRespostaDAO.class);
		// _arquivo.addClass(ProjetoDAO.class);
		// _arquivo.addClass(ProjetoVersaoDAO.class);
		// _arquivo.addClass(QuestaoDAO.class);
		// _arquivo.addClass(QuestaoEscolhaDAO.class);
		// _arquivo.addClass(QuestionarioDAO.class);
		// _arquivo.addClass(ReviewDAO.class);
		// _arquivo.addClass(UsuarioDAO.class);
		// _arquivo.addClass(EspectadorBean.class);
		// _arquivo.addClass(EventoBean.class);
		// _arquivo.addClass(EventoPresencaBean.class);
		// _arquivo.addClass(EventoQuestionarioBean.class);
		// _arquivo.addClass(EventoRespostaBean.class);
		// _arquivo.addClass(ProjetoBean.class);
		// _arquivo.addClass(ProjetoVersaoBean.class);
		// _arquivo.addClass(QuestaoBean.class);
		// _arquivo.addClass(QuestaoEscolhaBean.class);
		// _arquivo.addClass(QuestionarioBean.class);
		// _arquivo.addClass(ReviewBean.class);
		// _arquivo.addClass(UsuarioBean.class);

		// _arquivo.addClass(EventoWS.class);
		// _arquivo.addClass(PublicoWSReview.class);

		_arquivo.addClass(InterceptadorParaLogs.class);
		_arquivo.addAllDependencies();
		_swarm.deploy(_arquivo);
	}
}