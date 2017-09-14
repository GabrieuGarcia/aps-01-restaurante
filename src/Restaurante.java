
public class Restaurante {

	private Prato[] cardapio;

	public void mostrarCardapio() {
		for (Prato prato : cardapio) {
			System.out.println(prato.getNome() + ": R$ " + prato.getPreco());
			if (prato.getDescricao() != null) {
				System.out.println(prato.getDescricao());
			}
			if (prato.getIngredientes().length > 0) {
				for (Ingrediente ing : prato.getIngredientes()) {
					if (ing != null) {
						System.out.println(" - " + ing.getTipo() + " (" + (ing.isObrigatorio() ? "Obrigatório)" : "Opcional)"));
					}
				}
			}
			System.out.println("-------------------");
		}
	}

	public void setCardapio(Prato[] cardapio) {
		this.cardapio = cardapio;
	}

	public Prato[] getCardapio() {
		return cardapio;
	}

}
