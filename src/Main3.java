import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.crypto.*;



public class Main3 {

    private final static String ALGORITMO = "AES";
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el mensaje: ");
        String mensaje = scanner.nextLine();

        KeyGenerator keygen = KeyGenerator.getInstance (ALGORITMO);
        SecretKey llave = keygen.generateKey();
        
        FileOutputStream archivo = new FileOutputStream("Llave");
        ObjectOutputStream oos = new ObjectOutputStream(archivo);

        oos.writeObject(llave);
        oos.close();
        System.out.println("Llave guardada en 'Llave' ");

        byte[] textoCifrado = Simetrico.cifrar(llave, mensaje);
        System.out.println("El texto ha sido cifrado");
        imprimir(textoCifrado);

        FileOutputStream archivoTexto = new FileOutputStream("mensaje_cifrado.dat");
        ObjectOutputStream oostexto = new ObjectOutputStream(archivoTexto);

        oostexto.writeObject(textoCifrado);
        oostexto.close();
        System.out.println("Texto cifrado guardado en 'mensaje_cifrado.dat'");

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
