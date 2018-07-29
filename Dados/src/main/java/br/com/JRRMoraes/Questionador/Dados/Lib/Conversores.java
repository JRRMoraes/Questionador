package br.com.JRRMoraes.Questionador.Dados.Lib;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Conversores {

	public static String estenderCalendar(Calendar calendario) {
		if (calendario == null)
			return null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:nn:ss");
		return formato.format(calendario.getTime());
	}
}