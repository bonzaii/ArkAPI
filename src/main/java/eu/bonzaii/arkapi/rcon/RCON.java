package eu.bonzaii.arkapi.rcon;

import eu.bonzaii.arkapi.rcon.exceptions.AuthenticationException;

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


    /**
     * RCON class to manage a single connection with RCON server. This is specifically made for
     * ARK: Survival Evolved
     *
     * @param address
     * @param port
     * @param password
     */
    public RCON(String address, int port, String password) {
        this.address = address;
        this.port = port;
        this.password = password;

    }

    /**
     * Establish the connection with RCON taking into account all data required for the connection
     * is already set
     *
     * @throws Exception
     */
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

        Packet res =  authorize(password);

        if (res.getRequestId() == -1) {
            disconnect();
            throw new AuthenticationException("Password rejected by server");
        }
    }

    /**
     * Internal method to generate & send packet.
     *
     * @param type
     * @param message
     * @return
     * @throws Exception
     */
    protected Packet send(int type, String message) throws Exception {
        return Packet.send(this, type, message.getBytes(charset));
    }

    /**
     * TODO
     *
     * This should be managed by a thread as asynchronous reads are required for CrossARK Chats
     * and in-game chat commands like /reward
     *
     * @return
     */
    private boolean receive() {

        return false;
    }


    /**
     * Send authorisation (password) to the RCON server.
     *
     * @param password
     * @return
     * @throws Exception
     */
    private Packet authorize(String password) throws Exception {
        return send(Packet.DATATYPE_AUTH, password);
    }

    /**
     * Send normal command to the RCON server
     *
     * @param command
     * @return
     * @throws Exception
     */
    public Packet sendCommand(String command) throws Exception {
        return send(Packet.DATATYPE_COMMAND, command);
    }


    /**
     * Close the socket on disconnection
     *
     * @throws IOException
     */
    public void disconnect() throws IOException {
        synchronized (sync) {
            this.socket.close();
        }
    }

    public String getAddress() { return address; }
    public int getPort() { return port; }
    public Socket getSocket() { return socket; }
    public int getRequestId() { return requestId; }
}
