package main.java.com.cgvsu.objWriter;

public class ObjWriterException extends RuntimeException {
    public ObjWriterException(String message) {
        super(message);
    }

    public ObjWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
