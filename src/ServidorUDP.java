import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ServidorUDP
 */
public class ServidorUDP {

    public static void main(String[] args) throws IOException {
        // cria um socket UDP
        DatagramSocket s = new DatagramSocket(6789);
        byte[] buffer = new byte[1000];
        System.out.println("*** Servidor aguardando request");
        
        // cria datagrama para receber request do cliente
        DatagramPacket r = new DatagramPacket(buffer, buffer.length);
        s.receive(r);
        System.out.println("*** Request recebido de: " + r.getAddress());
        
        // envia resposta
        DatagramPacket resp = new DatagramPacket(r.getData(), r.getLength(),
        r.getAddress(), r.getPort());
        s.send(resp);
        s.close();
    }
}