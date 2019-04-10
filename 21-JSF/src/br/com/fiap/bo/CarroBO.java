package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.CarroTO;

//Simulando a BASE DE DADOS
public class CarroBO {
	
	private static List<CarroTO> carros = new ArrayList<CarroTO>();
	
	public void cadastrar(CarroTO c) {
		carros.add(c);
	}
	
	public List<CarroTO> listar() {
		return carros;
	}
	
}
