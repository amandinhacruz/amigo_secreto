package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entity.Participante;

public class Program {

	public static  void main(String[] args) {
		Scanner leia = new Scanner(System.in);
				
		System.out.print("Digite a qauntidade de participantes e em seguida o nome de cada participante: \n");
		int n = leia.nextInt();
		leia.nextLine();
		Participante [] vect = new Participante[n];
		
		for (int i = 0; i < vect.length; i++) {
		    System.out.print("Nome " + (i + 1) + "° participante: ");
		    String nome = leia.nextLine();
		    
		    System.out.println("Digite uma senha para " + nome + ": ");
		    String senha = leia.nextLine();
		    
		    vect[i] = new Participante(nome, senha);  
		}


		Random random = new Random();		
		int indiceAleatorio = 0;
		String amigoSecreto = " ";
		ArrayList<String> amigoJaSorteado = new ArrayList<String>();
		for(int i = 0; i < vect.length; i++) {
			indiceAleatorio = random.nextInt(vect.length);
			amigoSecreto = vect[indiceAleatorio].getNome();

			// Continua tentando enquanto o amigo já tiver sido sorteado ou for ele mesmo
		    while (amigoJaSorteado.contains(amigoSecreto) || vect[i].getNome().equals(amigoSecreto)) {
		        indiceAleatorio = random.nextInt(vect.length);
		        amigoSecreto = vect[indiceAleatorio].getNome();
		    }
		    
		    // Adicione o amigo secreto à lista de sorteados
		    amigoJaSorteado.add(amigoSecreto);
		    
		    vect[i].setAmigoSecreto(amigoSecreto);
		}
		
		// Login e validação com senha
        boolean validacaoLogin = false;
        while (!validacaoLogin) {
            System.out.println("\n--- Login ---");
            System.out.print("Qual seu nome? ");
            String participanteLogin = leia.nextLine();

            // Verifica se o nome existe e a senha está correta
            Participante participanteLogado = null;
            for (Participante p : vect) {
                if (p.getNome().equals(participanteLogin)) {
                    participanteLogado = p;
                    break;
                }
            }

            // Se o participante foi encontrado, valida a senha
            if (participanteLogado != null) {
                System.out.print("Digite sua senha: ");
                String senhaLogin = leia.nextLine();

                if (participanteLogado.getSenha().equals(senhaLogin)) {
                    validacaoLogin = true;  // Senha correta, login bem-sucedido

                    // Exibe quem o participante tirou
                    System.out.println("Você tirou " + participanteLogado.getAmigoSecreto() + " como amigo secreto!");
                } else {
                    System.out.println("Senha incorreta. Tente novamente.");
                }
            } else {
                System.out.println("Participante não encontrado. Tente novamente.");
            }
        }

		
		leia.close();

	}

}
