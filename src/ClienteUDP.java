import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * ClienteUDP
 */
public class ClienteUDP {

    public static void main(String[] args) throws IOException {
        // cria um socket UDP
        DatagramSocket s = new DatagramSocket();
        System.out.println("* Socket criado na porta: " + s.getLocalPort());
        byte[] m = args[0].getBytes(); // transforma arg em bytes
        InetAddress serv = InetAddress.getByName(args[1]);
        int porta = 6789;
        DatagramPacket req = new DatagramPacket(m, args[0].length(), serv, porta);
                
        // envia datagrama contendo a mensagem m
        s.send(req);
        byte[] buffer = new byte[1000];
        DatagramPacket resp = new DatagramPacket(buffer, buffer.length);
        s.setSoTimeout(10000); // timeout em ms
        
        // recebe resposta do servidor – fica em wait ateh chegada
        s.receive(resp);
        System.out.println("* Resposta do servidor:" + new String(resp.getData()));
        
        // fecha socket
        s.close();
    }
}