
public class Moneda {
	private TipoMoneda tipoMoneda;
	private int decimales;
	private String simbolo;
	private double cambioEuro;

	public Moneda() {
		this.tipoMoneda = TipoMoneda.EURO;
		this.decimales = 2;
		this.simbolo = "€";
		this.cambioEuro = 1;
	}

	public Moneda(TipoMoneda tipoMoneda, int decimales, String simbolo, double cambioEuro) throws Exception {
		this.tipoMoneda = tipoMoneda;
		this.decimales = decimales;
		this.simbolo = simbolo;
		setCambioEuro(cambioEuro);
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public int getDecimales() {
		return decimales;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public double getCambioEuro() {
		return cambioEuro;
	}

	public void setCambioEuro(double cambioEuro) throws Exception {
		if (cambioEuro < 0)
			throw new Exception("Cambio no puede ser negativo");
		this.cambioEuro = cambioEuro;
	}

	@Override
	public String toString() {
		return "Moneda [tipoMoneda=" + tipoMoneda + ", decimales=" + decimales + ", simbolo=" + simbolo
				+ ", cambioEuro=" + cambioEuro + "]";
	}

}
