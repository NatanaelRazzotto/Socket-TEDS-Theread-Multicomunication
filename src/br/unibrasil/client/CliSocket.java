package br.unibrasil.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CliSocket {
	private String host;
	private int port;
	
	public CliSocket() {		
		this.host = "127.0.0.1";
		this.port = 12345;		
	}

	public void execute() {		
		try {
			Socket client = new Socket(host,port);
			Scanner teclado = new Scanner(System.in);
			PrintStream saida = new PrintStream(client.getOutputStream());
			System.out.println("Cliente conectado no servidor");			
			
			//Scanner scanner = new Scanner(client.getInputStream());//			
			new Thread(new ReceiveMessages(client.getInputStream())).start();
			
			String linha = "";
			while ((!linha.toUpperCase().equals("SAIR"))&&(!linha.toUpperCase().equals("FECHAR"))) {
				linha = teclado.nextLine();
				saida.println(linha);
				//System.out.println(scanner.nextLine());					
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
