package eu.bonzaii.arkapi;


import eu.bonzaii.arkapi.rcon.RCON;
import org.yaml.snakeyaml.Yaml;


public class Main {

    public static void main(String[] args) throws Exception {
	    System.out.println("Hello world!");

        Yaml yaml = new Yaml();



	    if (0 == 1) {

			String host = "s2.bonzaii.eu";
			int port = 27020;
			String password = "topsecret";

			//test
			RCON rcon = new RCON(host, port, password);

			rcon.connect();
			rcon.sendCommand("broadcast Test broadcast");

		}
    }
}
