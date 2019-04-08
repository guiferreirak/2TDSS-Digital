package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class BuscarView {

	public static void main(String[] args) {
		
		CompraRepository r = new CompraRepository();
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Pesquise pelo código"));
		
		try {
			CompraTO c = r.buscar(id);
			System.out.println("Produto: " + c.getDescricao() + "\nValor: " + c.getValor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
