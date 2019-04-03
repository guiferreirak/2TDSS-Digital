package br.com.fiap.ws.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.ws.repository.VendaRepository;
import br.com.fiap.ws.to.Venda;

public class AtualizarView {

	public static void main(String[] args) {
		
		VendaRepository r = new VendaRepository();
		Venda v = new Venda(3, "Venda Liquidificador", 2.000f, new GregorianCalendar(2018, Calendar.AUGUST, 06));
		
		try {
			r.atualizar(v);
			System.out.println("Atualizado");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
