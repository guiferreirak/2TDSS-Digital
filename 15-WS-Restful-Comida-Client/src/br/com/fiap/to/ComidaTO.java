package br.com.fiap.to;

public class ComidaTO {
	
	private int codigo;
	
	private String nome;
	
	private boolean salgado;
	
	private float preco;
	
	public ComidaTO() {
		super();
	}
		
	public ComidaTO(String nome, boolean salgado, float preco) {
		super();
		this.nome = nome;
		this.salgado = salgado;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isSalgado() {
		return salgado;
	}

	public void setSalgado(boolean salgado) {
		this.salgado = salgado;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	} 

}
