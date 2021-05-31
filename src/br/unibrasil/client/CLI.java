package br.unibrasil.client;

public class CLI {

	public static void main(String[] args) {
		new CliSocket("127.0.0.1",12345).execute();
	}

}
