package br.com.JRRMoraes.Questionador.Wildfly.Principal;


import java.util.Calendar;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoEvento;


public class PovoarBanco {

	public static Calendar montarCalendario(int ano, int mes, int dia, int hora, int minuto, int segundo) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes, dia, hora, minuto, segundo);
		return calendar;
	}


	public static void preenchendoEvento() {
		EventoBean eventoBean = new EventoBean();

		Evento evento1 = eventoBean.consultarPorId(1l);
		if (evento1 != null) {
			evento1 = new Evento();
			// evento1.setId(1);
			evento1.setNome("Evento Número 1");
			evento1.setTipoEvento(TipoEvento.PUBLICO);
			evento1.setDataCriacao(montarCalendario(2016, Calendar.JANUARY, 12, 10, 12, 14));
			evento1.setDataEncerramento(Calendar.getInstance());
			eventoBean.salvar(evento1);
		}

		Evento evento2 = eventoBean.consultarPorId(2l);
		if (evento2 != null) {
			evento2 = new Evento();
			// evento2.setId(2);
			evento2.setNome("Evento Número 2 - Review Shop 6.1324");
			eventoBean.salvar(evento1);
		}
	}
}
