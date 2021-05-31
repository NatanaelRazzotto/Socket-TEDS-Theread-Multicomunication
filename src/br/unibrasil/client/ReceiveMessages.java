package br.unibrasil.client;

import java.io.InputStream;
import java.util.Scanner;

public class ReceiveMessages implements Runnable{
	
	private InputStream serverSocket;

	public ReceiveMessages(InputStream serverSocket) {
		this.serverSocket = serverSocket;		
	}

	@Override
	public void run() {
		try 
		{			
			Scanner scanner = new Scanner(this.serverSocket);
			while (scanner.hasNextLine())
			{
				System.out.println(scanner.nextLine());				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
