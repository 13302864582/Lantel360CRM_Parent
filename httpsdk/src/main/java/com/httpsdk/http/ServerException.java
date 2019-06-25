package com.httpsdk.http;

public class ServerException extends RuntimeException{
    public int code;
    public String message;
}
