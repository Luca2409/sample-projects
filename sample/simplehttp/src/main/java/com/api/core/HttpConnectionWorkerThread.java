package com.api.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpConnectionWorkerThread extends Thread {

    private static final Logger logger = Logger.getLogger(HttpConnectionWorkerThread.class.getName());
    private final Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            String html = "<html><head><title>Simple HTTP</title></head><body><h1>TEST</h1></body></html>";

            final String CRLF = "\r\n";

            String response =
                    "HTTP/1.1 200 OK" + CRLF +
                            "Content-Length: " + html.getBytes().length + CRLF +
                            CRLF +
                            html +
                            CRLF + CRLF;

            os.write(response.getBytes());

            logger.info("Processing finished.");
        } catch (IOException e) {
            logger.warning("Problem with connection." + e);
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {}
            }
            if (os != null) {
                try {
                    os.close();
                }catch (IOException e) {}
            }
            if (socket != null) {
                try {
                    socket.close();
                }catch (IOException e) {}
            }
        }
    }

}
