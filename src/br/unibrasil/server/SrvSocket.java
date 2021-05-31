package br.unibrasil.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SrvSocket implements IMultiComunication {
	private ArrayList<PrintStream> listPrintStreams = new ArrayList<PrintStream>();
	public void execute() {
		try {
			ServerSocket server = new ServerSocket(12345);	
			
				while(true) 
				{					
					System.out.println("Aguardando conexão");
					Socket client = server.accept();//Eu recebo o client podemos partir desse
					System.out.println("Conectou!!");
					//todo client que se conecta guardamos numa lista
					//listClient.add(client);
					//ou uma lista de printstream
					listPrintStreams.add(new PrintStream(client.getOutputStream()));
					new Thread(new MultiComunication(this,client)).start();
				}
			//server.close();  

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public synchronized void SendAll(String mensage) {
		listPrintStreams.forEach(saida -> saida.println(mensage));
	}
}
