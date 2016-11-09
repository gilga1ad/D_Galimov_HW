package hwSockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        int port = 6666;
        InetAddress address = InetAddress.getByName("127.0.0.1");

        try (Socket socket = new Socket(address, port)) {
            InputStream inStream = socket.getInputStream();
            OutputStream outStream =  socket.getOutputStream();

            try (Scanner in = new Scanner(inStream)) {
                PrintStream out = new PrintStream(outStream, true);

                Scanner sc = new Scanner(System.in);
                boolean done = false;
                while (!done) {
                    System.out.print("> ");
                    String line = sc.nextLine();
                    out.println("Denis: " + line);
                    if(line.trim().equals("EXIT")) done = true;
                }
            }
        }
    }
}
