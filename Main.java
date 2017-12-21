import java.awt.Point;

public class Main {

	static Point point = new Point(0, 0);
	static String espacoPlano[][] = new String[10][10];
	static String PONTO = ".";
	static String ESQUERDA = "<";
	static String DIREITA = ">";
	static String CIMA = "^";
	static String BAIXO = "v";
	static String robo = DIREITA;

	public static void main(String[] args) {
		limpaPlano();
		andarCasas(5);
		mostraPlano();

		limpaPlano();
		virarPara("b");
		andarCasas(6);
		mostraPlano();
	}

	private static void virarPara(String direcao) {
		switch (direcao) {
		case "e":
			robo = ESQUERDA;
			break;

		case "d":
			robo = DIREITA;
			break;

		case "b":
			robo = BAIXO;
			break;

		case "c":
			robo = CIMA;
			break;

		default:
			break;
		}
	}

	private static void andarCasas(double numCasas) {
		double totalCasas = point.getY() + numCasas;
		if (totalCasas > 9) {
			point.setLocation(point.getX(), 0);
			numCasas = totalCasas - 10;
		}
		point.setLocation(point.getX(), point.getY() + numCasas);
		espacoPlano[new Double(point.getX()).intValue()][new Double(point.getY()).intValue()] = robo;
	}

	private static void limpaPlano() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				espacoPlano[i][j] = PONTO;
			}
		}
	}

	private static void mostraPlano() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(espacoPlano[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("X: " + point.getX() + " Y: " + point.getY());
		System.out.println();
	}
}
