package br.com.fiap.view;

import br.com.fiap.bo.ProdutoBOStub;
import br.com.fiap.bo.ProdutoBOStub.ConsultarProduto;
import br.com.fiap.bo.ProdutoBOStub.ConsultarProdutoResponse;
import br.com.fiap.bo.ProdutoBOStub.ProdutoTO;

public class ConsoleView {

	public static void main(String[] args) {

		try {
			ProdutoBOStub stub = new ProdutoBOStub();

			ConsultarProduto valores = new ConsultarProduto();
			valores.setCodigo(405);

			ConsultarProdutoResponse resp = stub.consultarProduto(valores);
			ProdutoTO produto = resp.get_return();

			System.out.println(produto.getDescricao());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
