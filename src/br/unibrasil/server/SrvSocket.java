package br.unibrasil.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SrvSocket {
	public void execute() {
		try {
			ServerSocket server = new ServerSocket(12345);	
			
				while(true) 
				{					
					System.out.println("Aguardando conexão");
					//Full-Duplex
					Socket client = server.accept();//Eu recebo o client podemos partir desse
					System.out.println("Conectou!!");	
					new Thread(new MultiComunication(client)).start();
				}
			//server.close();  

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
