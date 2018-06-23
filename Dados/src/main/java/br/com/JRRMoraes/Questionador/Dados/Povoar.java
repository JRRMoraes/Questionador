package br.com.JRRMoraes.Questionador.Dados;


import java.util.Calendar;
import br.com.JRRMoraes.Questionador.Dados.Beans.EventoBean;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Evento;
import br.com.JRRMoraes.Questionador.Dados.Entidades.Conjuntos.TipoEvento;


public class Povoar {

	public static void main(String[] args) {
		preenchendoEvento();
	}


	public static Calendar montarCalendario(int ano, int mes, int dia, int hora, int minuto, int segundo) {
		Calendar __calendar = Calendar.getInstance();
		__calendar.set(ano, mes, dia, hora, minuto, segundo);
		return __calendar;
	}


	public static void preenchendoEvento() {
		EventoBean __eventoBean = new EventoBean();

		Evento __evento1 = __eventoBean.consultarPorId(1l);
		if (__evento1 == null) {
			__evento1 = __eventoBean.novo();
			// evento1.setId(1);
			__evento1.setNome("Evento Número 1");
			__evento1.setTipoEvento(TipoEvento.PUBLICO);
			__evento1.setDataCriacao(montarCalendario(2016, Calendar.JANUARY, 12, 10, 12, 14));
			__evento1.setDataEncerramento(Calendar.getInstance());
			__eventoBean.salvar(__evento1);
		}

		Evento __evento2 = __eventoBean.consultarPorId(444l);
		if (__evento2 == null) {
			__evento2 = __eventoBean.novo();
			__evento2.setId(444l);
			__evento2.setNome("Evento Número 2 - Review Shop 6.1324");
			__eventoBean.salvar(__evento2);
		}

		Evento __evento3 = __eventoBean.consultarPorId(111l);
		if (__evento3 == null) {
			__evento3 = __eventoBean.novo();
			__evento3.setNome("Evento Número 3 - Review Shop 6.1330");
			__eventoBean.salvar(__evento3);
		}
	}
}