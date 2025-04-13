import java.util.Scanner;
import javax.crypto.*;

public class Main2 {

    private final static String ALGORITMO = "AES";
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el mensaje: ");
        String mensaje = scanner.nextLine();

        System.out.println("Mensaje original: " + mensaje);

        byte[] textoClaro = mensaje.getBytes();
        System.out.println("Texto en bytes: ");
        imprimir(textoClaro);

        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey key1 = keygen.generateKey();
        SecretKey key2 = keygen.generateKey();

        byte[] textoCifrado1 = Simetrico.cifrar(key1, mensaje);
        byte[] textoCifrado2 = Simetrico.cifrar(key2, mensaje);

        System.out.println("Texto cifrado con llave 1: ");
        imprimir(textoCifrado1);
        
        System.out.println("Texto cifrado con llave 2: ");
        imprimir(textoCifrado2);

        byte[] descifrado1 = Simetrico.descifrar(key1, textoCifrado1);
        String mensajeDescifrado1 = new String(descifrado1);
        System.out.println("Descifrado con Key1:" + mensajeDescifrado1);

        try {
            byte[] descifrado2 = Simetrico.descifrar(key2, textoCifrado1);
            String mensajeDescifrado2 = new String(descifrado2);
            System.out.println("Descifrado con Key2: "+ mensajeDescifrado2);

        } catch (Exception e) {
            System.out.println("Fallo al descifrar con la key2: " + e.getMessage());
        }
        
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
