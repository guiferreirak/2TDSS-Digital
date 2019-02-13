package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(1, 2, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1,  3,  new GregorianCalendar(2017, Calendar.DECEMBER, 25), 200, 2);
		
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
		
		lista.add(cc);
		lista.add(new ContaCorrente(1, 3, new GregorianCalendar(2018, Calendar.DECEMBER, 5), 340, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(1, 5, new GregorianCalendar(2019, Calendar.DECEMBER, 4), 340, TipoConta.ESPECIAL));
		
		for (ContaCorrente c: lista) {
			System.out.println(c.getSaldo());
		}

	}

}
