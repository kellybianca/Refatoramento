package modelPacoteAssinatura;

import models.Pacotes;

public class PacotesAssinatura extends Pacotes{
	
	
	
	public void basico(){
        this.descricao = "apenas uma tela por vez, sem resolucao HD";
        this.valor = 19.90;
    }
	
	public void padrao() {
		this.descricao = "duas telas simultaneas, resolucao HD (Full-HD em alguns casos)";
		this.valor = 27.90;
	}
	
	public void premium() {
		this.descricao = "quatro telas simultaneas, resolucao 4K, sem HDR";
		this.valor = 37.90;
	}

}
