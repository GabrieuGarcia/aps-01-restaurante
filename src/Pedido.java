
public class Pedido {

	private Prato[] pratos;

	public Prato[] getPratos() {
		return pratos;
	}

	public void setPratos(Prato[] pratos) {
		this.pratos = pratos;
	}

	public double calculaValorTotal() {
		double valorTotal = 0;
		for (Prato prato : pratos) {
			if (prato != null)
				valorTotal += prato.getPreco();
		}
		return valorTotal;
	}

}
