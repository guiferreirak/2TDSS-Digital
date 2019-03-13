package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNumero1;
	private Text txtNumero2;
	private Text txtResultado;
	private Text txtCepOrigem;
	private Text txtCepDestino;
	private Text txtPrazo;
	private Text txtDataMaxima;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
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
		
		Label lblNmero = new Label(shell, SWT.NONE);
		lblNmero.setBounds(10, 10, 55, 15);
		lblNmero.setText("N\u00FAmero 1");
		
		txtNumero1 = new Text(shell, SWT.BORDER);
		txtNumero1.setBounds(71, 10, 76, 21);
		
		Label lblNmero_1 = new Label(shell, SWT.NONE);
		lblNmero_1.setText("N\u00FAmero 2");
		lblNmero_1.setBounds(10, 50, 55, 15);
		
		txtNumero2 = new Text(shell, SWT.BORDER);
		txtNumero2.setBounds(71, 44, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Recuperando os valores passados
				int n1 = Integer.parseInt(txtNumero1.getText());
				int n2 = Integer.parseInt(txtNumero2.getText());
				
				//Somando os dois valores
				int resultado = n1 + n2;
				
				//Exibindo no campo txt
				txtResultado.setText(String.valueOf(resultado));
			}
		});
		btnCalcular.setBounds(10, 88, 49, 25);
		btnCalcular.setText("Calcular");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(71, 90, 76, 23);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(194, 10, 2, 177);
		
		Label lblCepOrigem = new Label(shell, SWT.NONE);
		lblCepOrigem.setBounds(224, 10, 64, 15);
		lblCepOrigem.setText("CEP Origem");
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setText("CEP Destino");
		lblCepDestino.setBounds(224, 50, 64, 15);
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setText("Prazo");
		lblPrazo.setBounds(224, 88, 64, 15);
		
		Label lblDataMaxima = new Label(shell, SWT.NONE);
		lblDataMaxima.setText("Data Maxima");
		lblDataMaxima.setBounds(224, 131, 76, 15);
		
		txtCepOrigem = new Text(shell, SWT.BORDER);
		txtCepOrigem.setBounds(315, 10, 76, 21);
		
		txtCepDestino = new Text(shell, SWT.BORDER);
		txtCepDestino.setBounds(315, 50, 76, 21);
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setEditable(false);
		txtPrazo.setBounds(315, 88, 76, 21);
		
		txtDataMaxima = new Text(shell, SWT.BORDER);
		txtDataMaxima.setEditable(false);
		txtDataMaxima.setBounds(315, 131, 76, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					CalcPrazo prazo = new CalcPrazo();
					
					prazo.setNCdServico("40010");
					
					prazo.setSCepOrigem(txtCepOrigem.getText());
					
					prazo.setSCepDestino(txtCepDestino.getText());
					
					CalcPrazoResponse resp = stub.calcPrazo(prazo);
					
					txtPrazo.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getPrazoEntrega());
					txtDataMaxima.setText(resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
										
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
								
			}
		});
		btnPesquisar.setBounds(266, 192, 75, 25);
		btnPesquisar.setText("Pesquisar");

	}
}
