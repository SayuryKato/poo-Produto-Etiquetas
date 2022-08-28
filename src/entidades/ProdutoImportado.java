package entidades;

public class ProdutoImportado extends Produto{
	
	private Double alfadega;

	public ProdutoImportado(String nome, Double preco, Double alfadega) {
		super(nome, preco);
		this.alfadega = alfadega;
	}

	public Double getAlfadega() {
		return alfadega;
	}

	public void setAlfadega(Double alfadega) {
		this.alfadega = alfadega;
	}
	
	public Double totalPrice() {
		return getPreco() + alfadega;
	}
	
	@Override
	public String etiqueta(){
		return getNome() 
				+ " $ " 
				+ String.format("%.2f", totalPrice())
				+ " (Afandega: $ " 
				+ String.format("%.2f", alfadega)
				+ ")";
	}
}