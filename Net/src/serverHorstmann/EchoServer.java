package serverHorstmann;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * В этой программе реализуется простой сервер, прослушивающий порт
 * 8189 и посылающий обратно клиенту все полученные от него данные
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        /* установить совет на стороне сервера */
        try (ServerSocket s = new ServerSocket(8189)) {
            /* ожидание подключения клиента */
            try (Socket incoming = s.accept()) {
                /* все данные, направленные в поток вывода серверной программы
                 * поступают в поток ввода клиентской программы, и наоборот */
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                /* соответствующие потоки ввода-вывода через сокеты преобразуются
                 * в сканирующие и записывающие потоки типа Scanner и Writer*/
                try (Scanner in = new Scanner(inStream)) {
                    PrintStream out = new PrintStream(outStream, true); /* автоматическая очистка */

                    out.println("Hello! Enter BYE to exit.");

                    /* передать обратно данные, полученные от клиента в
                     * в режиме эхопередачи */
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }

}
