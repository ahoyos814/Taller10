
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.crypto.SecretKey;


public class Main4 {


    public static void main(String[] args) throws Exception {
        
        FileInputStream fisLlave = new FileInputStream("Llave");
        ObjectInputStream oisLlave = new ObjectInputStream(fisLlave);
        SecretKey llave = (SecretKey) oisLlave.readObject();
        oisLlave.close();
        System.out.println("llave cargada desde 'Llave'");
        
        FileInputStream fisTexto = new FileInputStream("mensaje_cifrado.dat");
        ObjectInputStream oisTexto = new ObjectInputStream(fisTexto);
        byte[] textoCifrado = (byte[]) oisTexto.readObject();
        oisTexto.close();
        System.out.println("Texto cifrado cargado desde 'mensaje_cifrado.dat'");

        byte[] textoDescifrado= Simetrico.descifrar(llave, textoCifrado);
        String mensajeDescifrado = new String(textoDescifrado);
        System.out.println("Mensaje descifrado: "+ mensajeDescifrado);
    
    
    }

}
