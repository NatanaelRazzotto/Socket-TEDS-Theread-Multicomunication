package br.unibrasil.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiComunication implements Runnable {
	
	private Socket client;

	public MultiComunication(Socket client)
	{
		this.client = client;		
	}
	
	public void run() 
	{	
		try {
			int count = 0;
			PrintStream saida = new PrintStream(client.getOutputStream());
			Scanner scanner = new Scanner(client.getInputStream());
			String recebido = "";
			
			while((!recebido.toUpperCase().equals("SAIR"))&&(!recebido.toUpperCase().equals("FECHAR"))) 
			{
				count++; 
				try {
					recebido = scanner.nextLine();
					System.out.println(recebido);		
					saida.println(count +" - Mensagens Recebidas");
				} catch (Exception e) {
					recebido = "SAIR";
				}					
			}	
			client.close();//O server não morrer
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

