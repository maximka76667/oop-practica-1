
public class Main {

	public static void main(String[] args) {
		
		Dinero rublos = new Dinero(10.5645555, TipoMoneda.RUBLO);
		Dinero rublos2 = new Dinero(10.5645555, TipoMoneda.RUBLO);
		Dinero dolares = new Dinero(1.555555, TipoMoneda.DOLAR);
		
		System.out.println("Rublos toString(): " + rublos);
		System.out.println("Dolares toString(): " + dolares);
		
		System.out.println("Rublos valor en (Dolar): " + rublos.calcularValorEn(TipoMoneda.DOLAR));
		
		System.out.println("Rublos toString(dolares): " + rublos.toString(TipoMoneda.DOLAR));
		
		System.out.println("Rublos igual a su mismo: " + rublos.igual(rublos2));
		
		System.out.println("Rublos sustraer su mismo: " + rublos.sustraer(rublos));
		
		System.out.println("Sumar rublos y dolares: " + rublos.sumar(dolares));
		
		System.out.println("Rublos mayor que dolares: " + rublos.mayor(dolares));
		
		System.out.println("Rublos menor o igual a dolares: " + rublos.menorOIgual(dolares));
	}

}
