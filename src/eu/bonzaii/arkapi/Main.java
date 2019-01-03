package eu.bonzaii.arkapi;


import eu.bonzaii.arkapi.eu.bonzaii.arkapi.rcon.RCON;

public class Main {

    public static void main(String[] args) throws Exception {
	    System.out.println("Hello world!");

	    String host = "s2.bonzaii.eu";
	    int port = 27020;
	    String password = "topsecret";


	    RCON rcon = new RCON(host, port, password);

	    rcon.connect();
	    rcon.sendCommand("broadcast Test broadcast");
    }
}
