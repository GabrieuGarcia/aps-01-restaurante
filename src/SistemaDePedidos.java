import java.util.Scanner;

public class SistemaDePedidos {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Restaurante restaurante = new Restaurante();

		Prato[] cardapio = new Prato[3];

		for (int i = 0; i < cardapio.length; i++) {
			System.out.println("=== Prato " + (i + 1) + "/3 ===");

			String nome = "";
			do {
				System.out.println("  Nome (obrigatório):");
				nome = scanner.nextLine();
			} while (nome.trim().isEmpty());

			double preco = 0;
			do {
				System.out.println("  Preço (obrigatório):");
				preco = scanner.nextDouble();
			} while (preco <= 0);

			System.out.println("  Descrição (se não possuir, digite N):");
			String descricao = scanner.next();

			Ingrediente[] ingredientes = new Ingrediente[3];

			for (int j = 0; j < ingredientes.length; j++) {
				System.out.println("  Ingrediente " + (j + 1) + "/3 (digite [0] para sair):");
				Ingrediente ingrediente = new Ingrediente();
				System.out.println("[1] Carne / [2] Legume / [3] Verdura / [4] Tempero / [5] Acompanhamento");

				int tipo = scanner.nextInt();

				if (tipo == 0) {
					break;
				} else {
					ingrediente.setTipo(tipo);
					System.out.println("É obrigatório? S/N");
					ingrediente.setObrigatorio("s".equalsIgnoreCase(scanner.next()) ? true : false);
					ingredientes[j] = ingrediente;
				}
			}

			Prato prato = new Prato(nome, preco);
			prato.setDescricao("n".equalsIgnoreCase(descricao) ? null : descricao);
			prato.setIngredientes(ingredientes);

			cardapio[i] = prato;
		}

		restaurante.setCardapio(cardapio);

		System.out.println("=== CARDÁPIO ===");
		restaurante.mostrarCardapio();

		System.out.println("Boa noite! Faça seu pedido, quando terminar, digite [0]");
		Pedido pedido = new Pedido();
		Prato[] pratos = new Prato[3];
		String nome = "";

		while (!(nome = scanner.next()).equals("0")) {
			Prato prato = null;
			System.out.println("Qual prato deseja pedir?");

			for (int i = 0; i < restaurante.getCardapio().length; i++) {
				if (nome.equalsIgnoreCase(restaurante.getCardapio()[i].getNome())) {
					prato = restaurante.getCardapio()[i];
					break;
				}
			}

			if (prato != null) {
				for (int i = 0; i < pratos.length; i++) {
					if (pratos[i] == null) {
						pratos[i] = prato;
						break;
					}
				}
				System.out.println("Adicionado [" + prato.getNome() + "]");
			} else {
				System.out.println("O prato que você digitou não existe.");
			}
		}

		pedido.setPratos(pratos);
		System.out.println("Seu pedido: ");
		for (Prato prato : pedido.getPratos()) {
			if (prato != null)
				System.out.println(" - " + prato.getNome() + "(R$ " + prato.getPreco() + ")");
		}
		double valorTotal = pedido.calculaValorTotal();
		System.out.println("========== TOTAL: " + valorTotal);
		
		System.out.println("Digite o valor que irá pagar:");
		double valor = 0;
		while (valor < valorTotal) {
			valor = scanner.nextDouble();
			if (valor < valorTotal) {
				System.out.println("Você deve pagar um valor igual ou maior que o total");
			} else {
				System.out.println("*****PAGO*****");
				System.out.println("*TROCO: R$" + (valor - valorTotal) + "*");
			}
		}
	}

}
