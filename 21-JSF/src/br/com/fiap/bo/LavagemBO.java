package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.LavagemTO;

public class LavagemBO {
	
	private static List<LavagemTO> l = new ArrayList<LavagemTO>();
	
	public void cadastrar(LavagemTO lavagem) {
		l.add(lavagem);
	}
	
	public List<LavagemTO> listar() {
		return l;
	}
}
