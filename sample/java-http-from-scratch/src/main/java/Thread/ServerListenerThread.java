package Thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Util.HttpParser;
import config.WebConfigManager;

public class ServerListenerThread extends Thread{

    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public ServerListenerThread(WebConfigManager config) throws IOException{
        this.port = config.getPort();
        this.webroot = config.getWebRoot();
        this.serverSocket = new ServerSocket(this.port);
    }

    public void run() {

        try {

            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                
                Socket socket = serverSocket.accept();
                System.out.println("Accepting connections...");
                
                HttpParser httpParser = new HttpParser();

                String[] statusLineParams = httpParser.parseStatusLine(socket.getInputStream());
                
                String path = statusLineParams[1];

                System.out.println(path);


                OutputStream outputStream = socket.getOutputStream();

                OutputStreamWriter writer = new OutputStreamWriter(outputStream);

                if (path.equals("/")) {
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/html\r\n");
                    writer.write("Content-Length: \r\n"); 
                    writer.write("\r\n"); 

                    writer.flush();
                } else if (path.equals("/test")){
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/html\r\n");
                    writer.write("Content-Length: \r\n"); 
                    writer.write("\r\n"); 
                    writer.write("Hello World\n");

                    writer.flush();
                } else if (path.equals("/hallo")) {
                    writer.write("HTTP/1.1 200 OK\r\n");
                    writer.write("Content-Type: text/html\r\n");
                    writer.write("Content-Length: \r\n"); 
                    writer.write("\r\n"); 
                    writer.write("Hallo Welt\n");

                    writer.flush();
                    
                }

                socket.close();
            }
            
            // close inputstreams


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
