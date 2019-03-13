package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import br.com.fiap.bo.ProdutoBOStub;
import br.com.fiap.bo.ProdutoBOStub.ConsultarProduto;
import br.com.fiap.bo.ProdutoBOStub.ConsultarProdutoResponse;
import br.com.fiap.bo.ProdutoBOStub.ProdutoTO;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Loja {

	protected Shell shell;
	private Text txtIdProduto;
	private Text txtProduto;
	private Text txtPreco;
	private Text txtQtd;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Loja window = new Loja();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Comic Sans MS", 15, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(10, 10, 256, 46);
		lblNewLabel.setText("Pesquise pelo seu Produto");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setFont(SWTResourceManager.getFont("Arial", 10, SWT.NORMAL));
		lblCdigo.setBounds(10, 62, 55, 25);
		lblCdigo.setText("C\u00F3digo");
		
		txtIdProduto = new Text(shell, SWT.BORDER);
		txtIdProduto.setBounds(81, 62, 76, 21);
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setText("Pre\u00E7o");
		lblPreo.setFont(SWTResourceManager.getFont("Arial", 10, SWT.NORMAL));
		lblPreo.setBounds(10, 180, 55, 25);
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setText("Quantidade");
		lblQuantidade.setFont(SWTResourceManager.getFont("Arial", 10, SWT.NORMAL));
		lblQuantidade.setBounds(10, 213, 66, 25);
		
		Label lblProduto = new Label(shell, SWT.NONE);
		lblProduto.setText("Produto");
		lblProduto.setFont(SWTResourceManager.getFont("Arial", 10, SWT.NORMAL));
		lblProduto.setBounds(10, 149, 55, 25);
		
		Button btnPesquisar = new Button(shell, SWT.FLAT);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					ProdutoBOStub stub = new ProdutoBOStub();
					
					ConsultarProduto valores = new ConsultarProduto();
					
					int id = Integer.parseInt(txtIdProduto.getText());
					valores.setCodigo(id);
					
					ConsultarProdutoResponse resp = stub.consultarProduto(valores);
					ProdutoTO to = resp.get_return();
					
					//Exibindo os valores
					txtProduto.setText(to.getDescricao());
					txtPreco.setText(String.valueOf(to.getPreco()));
					txtQtd.setText(String.valueOf(to.getQuantidade()));
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnPesquisar.setFont(SWTResourceManager.getFont("Comic Sans MS", 10, SWT.NORMAL));
		btnPesquisar.setBounds(176, 103, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		txtProduto = new Text(shell, SWT.BORDER);
		txtProduto.setEditable(false);
		txtProduto.setBounds(81, 147, 106, 21);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setEditable(false);
		txtPreco.setBounds(81, 178, 66, 21);
		
		txtQtd = new Text(shell, SWT.BORDER);
		txtQtd.setEditable(false);
		txtQtd.setBounds(81, 211, 43, 21);

	}

}
