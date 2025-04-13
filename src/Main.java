import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {

    // Constante para utilizar cifrado simetrico "AES"
    private final static String ALGORITMO = "AES";

    public static void main(String[] args) throws Exception {
        
        // Pide el mensaje por consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un mensaje: ");
        String mensaje = scanner.nextLine();

        // Se imprime el mensaje original
        System.out.println("Mensage original: "+ mensaje);

        // Se transforma el mensaje a bytes con el getBytes()
        byte[] textoClaro = mensaje.getBytes();
        System.out.println("Texto claro en bytes: ");
        imprimir(textoClaro);

        // Se genera la llave simetrica
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey secretKey = keygen.generateKey();

        // Se cifra el texto con la llave simetrica
        long inicioCifrado = System.nanoTime();
        byte[] textoCifrado = Simetrico.cifrar(secretKey, mensaje);
        long finCifrado = System.nanoTime();
        System.out.println("Texto cifrado en bytes: ");
        imprimir(textoCifrado);
        System.out.println("Texto cifrado en nanosegundos: " + (finCifrado - inicioCifrado));

        // Se descifra el texto con la lleva simetrica
        long inicioDescifrado = System.nanoTime();
        byte[] textoDescifrado = Simetrico.descifrar(secretKey, textoCifrado);
        long finDescifrado = System.nanoTime();
        System.out.println("Texto descifrado en bytes: ");
        imprimir(textoDescifrado);
        System.out.println("Texto descifrado en nanosegundos: " + (finDescifrado - inicioDescifrado));

        // Se imprime el mensaje descifrado con el método constructor 
        String mensajeDescifrado = new String(textoDescifrado);
        System.out.println("El mensaje decifrado es: "+ mensajeDescifrado);

        scanner.close();
    }

    public static void imprimir(byte[] contenido){
        int i=0;
        for (; i < contenido.length-1; i++){
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

}
