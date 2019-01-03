package eu.bonzaii.arkapi.eu.bonzaii.arkapi.rcon.exceptions;

import java.io.IOException;

public class MalformedPacketException extends IOException {
    public MalformedPacketException(String message) {
        super(message);
    }
}
