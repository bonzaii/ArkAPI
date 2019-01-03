package eu.bonzaii.arkapi.eu.bonzaii.arkapi.rcon;

import eu.bonzaii.arkapi.eu.bonzaii.arkapi.rcon.exceptions.AuthenticationException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.net.Socket;
import java.util.Random;

public class RCON {


    /**
     * Connection configuration
     */
    private String address;
    private int port;
    private String password;
    private Charset charset = Charset.forName("UTF-8");



    private Socket socket;


    private int requestId;
    private final Object sync = new Object();
    private final Random rand = new Random();


    public RCON(String address, int port, String password) {
        this.address = address;
        this.port = port;
        this.password = password;

    }

    public void connect() throws Exception {

        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("Port is out of range (1-65535)");
        }

        synchronized (sync) {
            // new random request ID
            this.requestId = rand.nextInt();

            // We can't reuse a socket, so we need a new one
            this.socket = new Socket(address, port);
        }

        RCONPacket res =  authorize(password);

        if (res.getRequestId() == -1) {
            throw new AuthenticationException("Password rejected by server");
        }
    }

    protected RCONPacket send(int type, String message) throws Exception {
        return RCONPacket.send(this, type, message.getBytes(charset));
    }

    private boolean receive() {

        return false;
    }



    private RCONPacket authorize(String password) throws Exception {
        return send(RCONPacket.DATATYPE_AUTH, password);
    }

    public RCONPacket sendCommand(String command) throws Exception {
        return send(RCONPacket.DATATYPE_COMMAND, command);
    }




    public String getAddress() { return address; }
    public int getPort() { return port; }
    public Socket getSocket() { return socket; }
    public int getRequestId() { return requestId; }
}
