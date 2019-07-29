package ar.edu.unlam.pbii.parcial2.c12019.enunciado;

public class CuentaCorriente extends Cuenta {
	private Double limiteDescuebierto;
	
	

	public CuentaCorriente(String cbu, Cliente cliente, Double saldo, Double limiteDescuebierto) {
		super(cbu, cliente, saldo);
		this.limiteDescuebierto = limiteDescuebierto;
	}



	@Override
	public void depositar(Double monto) {
		this.incrementarSaldo(monto);
	}



	@Override
	public void extraer(Double monto) {
		this.decrementarSaldo(monto);		
	}
}
