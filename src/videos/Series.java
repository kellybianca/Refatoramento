package videos;
public class Series extends Media{
	
	public int temporadas;
	
	public Series(String nome, String categoria, int temporadas) {
		super(nome, categoria);
		this.nome = nome;
		this.categoria = categoria;
		this.temporadas = temporadas;
	}


	@Override
	public String toString(){
		String serie;
		serie = "\nNome: "+this.nome;
		serie += "\nCategoria: "+this.categoria;
		serie += "\nTemporadas: "+this.temporadas;
		return serie;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getTemporadas() {
		return temporadas;
	}


	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}


	
}