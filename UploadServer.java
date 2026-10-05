import java.net.*;
import java.io.*;
import java.util.concurrent.Semaphore;

public class UploadServer {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        ServerSocket serverSocket = null;


        try {
            serverSocket =
                    new ServerSocket(8082);

        } catch (IOException e) {
            System.err.println(
                    "Could not listen on port: 8082."
            );

            System.exit(-1);
        }

        while (true) {



            try {

                Socket socket =
                        serverSocket.accept();

                new UploadServerThread(
                        socket
                ).start();

            } catch (IOException e) {

                throw e;
            }
        }
    }
}