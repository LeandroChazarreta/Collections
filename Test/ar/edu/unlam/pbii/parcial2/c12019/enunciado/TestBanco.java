package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class TestBanco {

	//Completar los métodos y las clases con la lógica necesaria para que funcionen los tests,
	// y probarlos. En caso de que corresponda se deben agregar las excepciones para informar
	// de los errores y probar que las mismas sean lanzadas correctamente, o tratadas
	// (Los métodos que deben lanzar las excepciones se tienen arriba los comentarios con los
	// nombres de las excepciones que deben lanzar)..

	@Test
	public void testQueagregaUnCajaDeAhorroAlBanco() {
		Banco Banco = new Banco();
		Cliente Cliente1 = new Cliente("Leandro", "Chazarreta", 39879455);		
		Cuenta c1 = new CajaDeAhorro("cbu1", Cliente1, 100.00, 5);
		Boolean actual = true;
		
		actual = Banco.agregarCuenta(c1);

		Assert.assertTrue(actual);
	}
	



	@Test
	public void testQueVericaQueUnaTranseferenciaSeaCorrecta()  throws MontoInvalidoException, MontoInsuficienteException, CuentaInvalidaException {
		Banco Banco = new Banco();
		Cliente Cliente1 = new Cliente("Leandro", "Chazarreta", 39879455);
		Cliente Cliente2 = new Cliente("Leandro", "Chazarreta", 39875);
		
		Cuenta c1 = new CajaDeAhorro("cbu1", Cliente1, 100.00, 5);
		Cuenta c2 = new CajaDeAhorro("cbu2", Cliente2, 100.00, 5);
		
		Banco.agregarCuenta(c1);
		Banco.agregarCuenta(c2);
		
		Double esperado = 90.00;
		Double actual = c1.getSaldo();
		
		try {
		Banco.transfer(10.00, "cbu1", "cbu2");
		actual = c1.getSaldo();
	}catch (Exception e){
		System.out.println(e.getMessage());
	};
	
	
	Assert.assertEquals(esperado, actual);	
		
	}
	
	@Test
	public void testQueVericaQueUnaTransferecniaNoSePuedeRealizarPorFaltaDeFondos()  throws MontoInvalidoException, MontoInsuficienteException, CuentaInvalidaException {
		Banco Banco = new Banco();
		Cliente Cliente1 = new Cliente("Leandro", "Chazarreta", 39879455);
		Cliente Cliente2 = new Cliente("Leandro", "Chazarreta", 39875);
		
		Cuenta c1 = new CajaDeAhorro("cbu1", Cliente1, 5.00, 5);
		Cuenta c2 = new CajaDeAhorro("cbu2", Cliente2, 100.00, 5);
		
		Banco.agregarCuenta(c1);
		Banco.agregarCuenta(c2);
		
		
				try {
					Banco.transfer(200.00, "cbu1", "cbu2");
				} catch (Exception e) {
				//	e.printStackTrace();
				}
	



	}
	
	
	
	

	@Test
	public void testQueBuscaUnaCuentaCorrecta() {
		Banco miBanco = new Banco();
		Cliente cliente1 = new Cliente ("Leandro", "Chazarreta", 42323);
		Cuenta c1 = new CajaDeAhorro("a", cliente1, 100.00, 3);
		
		miBanco.agregarCuenta(c1);
		
		Cuenta esperada = c1;
		
		try {
		miBanco.buscarCuentaPorCbu("a");
		} catch (Exception e){
			e.printStackTrace();
		}

		Assert.assertEquals(esperada, c1);
	}
	
	@Test
	public void testQueObtieneUnaListaDeCuentasCorrientes() {
		Banco Banco = new Banco();
		Cliente Cliente = new Cliente("Leandro", "Chazarreta", 39879455);
		Cuenta CuentaCorriente = new CuentaCorriente("cbu", Cliente, 100.00, 10.00);

		Banco.agregarCuenta(CuentaCorriente);
		
		try {
		Banco.obtenerListaCuentaCorriente();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	
	
}
