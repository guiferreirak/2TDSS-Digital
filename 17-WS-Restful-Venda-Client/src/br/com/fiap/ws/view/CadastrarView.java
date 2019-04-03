package br.com.fiap.ws.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.ws.repository.VendaRepository;
import br.com.fiap.ws.to.Venda;

public class CadastrarView {

	public static void main(String[] args) {
		
		VendaRepository r = new VendaRepository();
		Venda v = new Venda("Venda Iphone XS", 10000f, new GregorianCalendar(2019, Calendar.APRIL, 01));
		
		try {
			r.cadastrar(v);
			System.out.println("Cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
