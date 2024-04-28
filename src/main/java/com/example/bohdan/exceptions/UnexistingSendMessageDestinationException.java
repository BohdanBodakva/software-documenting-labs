package com.example.bohdan.exceptions;

public class UnexistingSendMessageDestinationException extends Exception{
    public UnexistingSendMessageDestinationException(String message) {
        super(message);
    }
}
