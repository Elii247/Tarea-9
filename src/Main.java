
import utils.Pass;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newCachedThreadPool();
        String password;

        System.out.println("\n-Ingrese Contraseña a validar con las siguientes caracteristicas: " +
                "\n-8 Caracteres mínimo\n-15 Caracteres máximo" +
                "\n-Utilizar mayúsculas, minúsculas, números y caracteres especiales\n" +
                "-Escriba Salir para terminar la verificacion. ");
        while (true) {
            password = scanner.nextLine();
            if (password.equalsIgnoreCase("Salir")) {
                break;
            }
            String finalPassword = password;
            executor.execute(() -> {
                if (Pass.password(finalPassword)) {
                    System.out.println("\nLa contraseña '" + finalPassword + "' es válida.");
                } else {
                    System.out.println("\nLa contraseña '" + finalPassword + "' no es válida.");
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Verificación completada");
    }
}