package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
public class Banco {

	
	private Set<Cuenta> listaDeCuentas;
	
	public Banco() {
		listaDeCuentas = new HashSet<Cuenta>();
	}

	
	//Lanzar las siguientes excepciones  MontoInvalidoException, MontoInsuficienteException, CuentaInvalidaException
	public void transfer(Double monto, String cbuOrigen, String cbuDestino) throws Exception {
		
		Cuenta origen = this.buscarCuentaPorCbu(cbuOrigen);
		Cuenta destino = this.buscarCuentaPorCbu(cbuDestino);
		
		origen.extraer(monto);
		destino.depositar(monto);
	}

	public Boolean existeCuenta(Cuenta cuenta) {	
		for (Cuenta a : listaDeCuentas){
				if (a.getCbu().equals(cuenta.getCbu())){
					return true;
				}
			}
		return false;
	}

	public Boolean agregarCuenta(Cuenta cuenta) {

		return listaDeCuentas.add(cuenta);
	}
	
	
	//Lanzar la excepcion CuentaInvalidaException
	public Cuenta buscarCuentaPorCbu (String cbu ) throws Exception {
		for (Cuenta a : listaDeCuentas){
			if(a.getCbu().equals(cbu)){
				return a;
			}
		}
		return null;
			
	}
	
	public Integer obtenerCantidadDeCuentas () {
		return listaDeCuentas.size();
	}
	
	
	public TreeSet <Cuenta> obtenerListaCuentasOrdenadaPorNombreCliente(Comparator ordenarCuenta) {
		
		TreeSet<Cuenta> ListaOrdenada = new TreeSet<Cuenta>(ordenarCuenta);

		return ListaOrdenada;
	}
	
	public List <CuentaCorriente> obtenerListaCuentaCorriente()  {
		ArrayList<CuentaCorriente> Ordenada = new ArrayList<CuentaCorriente>();
		
		Iterator<CuentaCorriente> iterator = Ordenada.iterator(); 
		
		while (iterator.hasNext()) {
			CuentaCorriente cuenta = null;
			
			if (cuenta instanceof CuentaCorriente) {
			Ordenada.add(cuenta);
			iterator.next();
		} }
		
		return Ordenada;

	}
}