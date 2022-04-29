
public class Main {

	public static void main(String[] args) {
		
		Moneda rublo = Dinero.dinero.get(2);
		System.out.println(rublo);
		
		Dinero.actualizarMoneda(TipoMoneda.RUBLO, 86);
		
		System.out.println(rublo);
	}

}
