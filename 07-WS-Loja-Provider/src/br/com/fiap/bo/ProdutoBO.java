package br.com.fiap.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	
	//Regras de negócio	
	public ProdutoTO consultarProduto(int codigo) throws AxisFault {
		ProdutoTO pto = null;
		switch (codigo) {
		case 401:
			pto = new ProdutoTO(401, 20, 2, "Camiseta branca");
			break;
		case 402:
			pto = new ProdutoTO(402, 25, 1, "Camiseta preta");
			break;
		case 403:
			pto = new ProdutoTO(403, 30, 3, "Camiseta rosa");
			break;
		default:
			throw new AxisFault("Produto não encontrado");
		}
		return pto;
	}
	
}
