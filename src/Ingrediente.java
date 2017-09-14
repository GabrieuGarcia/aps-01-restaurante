
public class Ingrediente {

	private String[] tipos = {"Carne","Legume","Verdura","Tempero","Acompanhamento"};
	private String tipo;
	private boolean obrigatorio;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipos[tipo-1];
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	
}
