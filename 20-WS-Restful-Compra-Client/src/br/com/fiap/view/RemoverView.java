package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.repository.CompraRepository;

public class RemoverView {
	
	public static void main(String[] args) {
		
		CompraRepository r = new CompraRepository();
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Remova pelo código"));
		
		try {
			r.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
