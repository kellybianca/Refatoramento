package repository;

import java.util.ArrayList;
import interfaceModels.IGerenciador;
import models.Pacotes;

public class GerenciadorPacotes extends Pacotes implements IGerenciador{

    ArrayList<Pacotes> listPacotes;
    
    public GerenciadorPacotes() {
    	this.listPacotes =  new ArrayList<>();
    }

    public void adicionar(Pacotes pacotes) {
    	if(listPacotes.size() > 0) {
    		System.out.println("Voce so pode ter um pacote de assinatura, remova o pacote que voce deseja");
    	}
    	else {
    		listPacotes.add(pacotes);
    		System.out.println("Pacote adicionado com sucesso");
    	}

    }

    @Override
    public void editar(String pacotes) {
       

    }

    @Override
    public void apagar(String nome) {
    	for(int i = 0; i < listPacotes.size(); i++) {
    		listPacotes.remove(i);
    	}

    }

    @Override
    public void listar() {
        for (Pacotes pacotes : listPacotes) {
            System.out.println("\n--------\n"+pacotes.toString());
        }

    }



}