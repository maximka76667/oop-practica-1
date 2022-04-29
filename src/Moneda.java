
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
		setDecimales(decimales);
		this.simbolo = simbolo;
		setCambioEuro(cambioEuro);
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public int getDecimales() {
		return decimales;
	}

	public void setDecimales(int decimales) throws Exception {
		if (decimales < 0 || decimales > 4)
			throw new Exception("Decimales deben estar entre 0 y 4");
		this.decimales = decimales;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) throws Exception {
		if (simbolo == null || simbolo.equals(""))
			throw new Exception("Simbolo vacío");
		this.simbolo = simbolo;
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
