package eu.bonzaii.arkapi;


import eu.bonzaii.arkapi.rcon.RCON;
import org.yaml.snakeyaml.Yaml;

import java.io.File;


public class Main {

    public static void main(String[] args) throws Exception {
	    System.out.println("Hello world!");

        Yaml yaml = new Yaml();


		File configFile = new File("config.yaml");
		if (configFile.exists() && !configFile.isDirectory()) {
			/**
			 * TODO
			 * 1. create a template for config.yaml
			 * 2. save config.yaml from template
			 * 3. throw an error message
			 * 4. perhaps change it to try/catch for parsing config.yaml in first place?
			 */

		}


	    /*

			String host = "s2.bonzaii.eu";
			int port = 27020;
			String password = "topsecret";

			//test
			RCON rcon = new RCON(host, port, password);

			rcon.connect();
			rcon.sendCommand("broadcast Test broadcast");

		*/
    }
}
