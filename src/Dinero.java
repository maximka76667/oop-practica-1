import java.util.ArrayList;

public class Dinero {
	static ArrayList<Moneda> dinero;

	static {
		dinero = new ArrayList<Moneda>();
		addMoneda(TipoMoneda.EURO, 2, "€", 1);
		addMoneda(TipoMoneda.DOLAR, 2, "$", 1.08);
		addMoneda(TipoMoneda.RUBLO, 2, "R", 85.27);
		addMoneda(TipoMoneda.TENGE, 2, "T", 483.19);
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
		for(int i = 0; i < dinero.size(); i++) {
			if(dinero.get(i).getTipoMoneda() == tipo) {
				dinero.set(i, createMoneda(tipo, decimales, simbolo, cambioEuro));
				return;
			}
		}
		dinero.add(createMoneda(tipo, decimales, simbolo, cambioEuro));
	}
	
	public static void actualizarMoneda(TipoMoneda tipo, double cambioEuroNuevo) {
		for(int i = 0; i < dinero.size(); i++) {
			if(dinero.get(i).getTipoMoneda() == tipo) {
				try {
					dinero.get(i).setCambioEuro(cambioEuroNuevo);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
