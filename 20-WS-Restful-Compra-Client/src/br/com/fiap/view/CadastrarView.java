package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class CadastrarView {

	public static void main(String[] args) {
		
		CompraRepository r = new CompraRepository();
		
		CompraTO c = new CompraTO("Oakley Flack Low", new GregorianCalendar(2019, Calendar.APRIL, 05), 500);
		
		try {
			r.cadastrar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
