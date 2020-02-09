package modelTipoPagamento;

import models.TipoPagamento;

public class Boleto extends TipoPagamento {

	private String endereco;
	private String bairro;
	
	
    public Boleto(String dataVencimento, Double valor) {
        super(dataVencimento, valor);
    }

    public String toString(){
		String boleto;
		boleto = "\nData vencimento: "+getDataVencimento();
		boleto = "\nValor :"+getValor();
		boleto = "\n\nBairro: "+this.bairro;
		boleto += "\nEndereco: "+this.endereco;
		return boleto;
	}

    
	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
    
   

}