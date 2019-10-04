package br.com.chat.Models;

public class Error {

    private String message;
    private String version;

    public Error(String message, String version) {
        this.message = message;
        this.version = version;
    }
}
