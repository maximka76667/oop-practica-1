import java.util.ArrayList;

public class Dinero {
	static ArrayList<Moneda> monedas;

	static {
		monedas = new ArrayList<Moneda>();
		addMoneda(TipoMoneda.EURO, 2, "?", 1);
		addMoneda(TipoMoneda.DOLAR, 2, "$", 1.08);
		addMoneda(TipoMoneda.RUBLO, 2, "R", 85.27);
		addMoneda(TipoMoneda.TENGE, 2, "T", 483.19);
	}

	private static int indexOfMoneda(TipoMoneda tipo) {
		for (int i = 0; i < monedas.size(); i++) {
			if (monedas.get(i).getTipoMoneda() == tipo) {
				return i;
			}
		}
		return -1;
	}

	// Busca moneda por nombre y devuelve moneda o null
	private static Moneda buscarMoneda(TipoMoneda tipoMonedaParaBuscar) {
		int indexOfMoneda = indexOfMoneda(tipoMonedaParaBuscar);
		if (indexOfMoneda > -1) {
			return monedas.get(indexOfMoneda);
		}
		return null;

	}

	private static Moneda createMoneda(TipoMoneda tipo, int decimales, String simbolo, double cambioEuro) {
		try {
			return new Moneda(tipo, decimales, simbolo, cambioEuro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Moneda();
	}

	private static void addMoneda(TipoMoneda tipo, int decimales, String simbolo, double cambioEuro) {
		// Check if unique
		int indexDeMoneda = indexOfMoneda(tipo);
		if (indexOfMoneda(tipo) > -1) {
			monedas.set(indexDeMoneda, createMoneda(tipo, decimales, simbolo, cambioEuro));
			return;
		}
		monedas.add(createMoneda(tipo, decimales, simbolo, cambioEuro));
	}

	public static void actualizarMoneda(TipoMoneda tipo, double cambioEuroNuevo) {
		Moneda moneda = buscarMoneda(tipo);
		if (moneda != null) {
			try {
				moneda.setCambioEuro(cambioEuroNuevo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private float cantidad;
	private TipoMoneda tipoMoneda;
	private Moneda moneda;

	// Constructores
	public Dinero(float cantidad, TipoMoneda tipoMoneda) {
		this.cantidad = cantidad;
		setTipoMoneda(tipoMoneda);
	}

	public Dinero(int cantidad, TipoMoneda tipoMoneda) {
		this((float) cantidad, tipoMoneda);
	}

	public Dinero(double cantidad, TipoMoneda tipoMoneda) {
		this((float) cantidad, tipoMoneda);
	}

	// Propiedades
	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
		this.moneda = buscarMoneda(tipoMoneda);
	}

	private float aplicarDecimales(float cantidad, int decimales) {
		double multiplicador = Math.pow(10, decimales);
		return (float) (Math.round(cantidad * multiplicador) / multiplicador);
	}

	private String buscarSimbolo(Moneda moneda) {
		return moneda.getSimbolo();
	}

	@Override
	public String toString() {
		return aplicarDecimales(this.cantidad, this.moneda.getDecimales()) + buscarSimbolo(this.moneda);
	}

	public float calcularValorEn(TipoMoneda nuevoTipoMoneda) {
		Moneda nuevaMoneda = buscarMoneda(nuevoTipoMoneda);

		return (float) (this.cantidad / moneda.getCambioEuro() * nuevaMoneda.getCambioEuro());
	}

	public Dinero convertirEn(TipoMoneda nuevoTipoMoneda) {
		float cantidad = calcularValorEn(nuevoTipoMoneda);
		return new Dinero(cantidad, nuevoTipoMoneda);
	}

	public String toString(TipoMoneda tipoMoneda) {
		Moneda nuevaMoneda = buscarMoneda(tipoMoneda);
		return aplicarDecimales(calcularValorEn(tipoMoneda), nuevaMoneda.getDecimales()) + buscarSimbolo(nuevaMoneda);
	}

	public double convertirCantidadADouble() {
		return this.cantidad;
	}

	public int convertirCantidadAEntero() {
		return (int) this.cantidad;
	}

	public Dinero sumar(Dinero dinero) {
		return new Dinero(this.cantidad + dinero.calcularValorEn(this.tipoMoneda), this.tipoMoneda);
	}

	public Dinero sustraer(Dinero dinero) {
		return new Dinero(this.cantidad - dinero.calcularValorEn(this.tipoMoneda), this.tipoMoneda);
	}

	public Dinero multiplicar(Dinero dinero) {
		return new Dinero(this.cantidad * dinero.calcularValorEn(this.tipoMoneda), this.tipoMoneda);
	}

	public Dinero dividir(Dinero dinero) {
		return new Dinero(this.cantidad / dinero.calcularValorEn(this.tipoMoneda), this.tipoMoneda);
	}

	public boolean igual(Dinero dinero) {
		return this.cantidad == dinero.calcularValorEn(this.tipoMoneda);
	}

	public boolean mayor(Dinero dinero) {
		return this.cantidad > dinero.calcularValorEn(this.tipoMoneda);
	}

	public boolean menor(Dinero dinero) {
		return this.cantidad < dinero.calcularValorEn(this.tipoMoneda);
	}

	public boolean mayorOIgual(Dinero dinero) {
		return this.cantidad >= dinero.calcularValorEn(this.tipoMoneda);
	}

	public boolean menorOIgual(Dinero dinero) {
		return this.cantidad <= dinero.calcularValorEn(this.tipoMoneda);
	}
}
