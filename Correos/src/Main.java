import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void escribirBufFichero(String ruta, String datos) throws IOException {
        Scanner tec = new Scanner(System.in);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File f = new File(ruta);
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            bw.write(datos);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        } finally {

            bw.close();
            fw.close();

        }
    }

    public static void leerBufFichero(String ruta) throws IOException {
        Scanner tec = new Scanner(System.in);
        FileReader fw = null;
        BufferedReader br = null;
        String nombre = null, ape1 = null, tit1 = null, ape2 = null, tit2 = null, telCon = null, emailCon = null;
        Equipo eq = null;
        try {
            File f = new File(ruta);
            fw = new FileReader(f);
            br = new BufferedReader(fw);

            String linea = br.readLine();

            while (linea != null) {
                if (linea.contains("nombregrupo:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    nombre = linea;
                }
                if (linea.contains("apellidos1:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    ape1 = linea;
                }
                if (linea.contains("titulacion1:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    tit1 = linea;
                }
                if (linea.contains("apellidos2:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    ape2 = linea;
                }
                if (linea.contains("titulacion2:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    tit2 = linea;
                }
                if (linea.contains("telcontacto:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    telCon = linea;
                }
                if (linea.contains("emailcontacto:")) {
                    linea = linea.substring(linea.indexOf(':') + 2, linea.length());
                    emailCon = linea;
                }

                linea = br.readLine();
            }

            eq = new Equipo(nombre, ape1, tit1, ape2, tit2, telCon, emailCon);
            escribirBufFichero("Correo.csv", eq.imprimir());


        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        } finally {
            br.close();
            fw.close();
        }
    }


    public static void leerBufFicheroVieja(String ruta) throws IOException {
        Scanner tec = new Scanner(System.in);
        FileReader fw = null;
        BufferedReader br = null;
        String nombre, ape1, tit1, ape2, tit2, telCon, emailCon;
        Equipo eq = null;
        try {
            File f = new File(ruta);
            fw = new FileReader(f);
            br = new BufferedReader(fw);

            String linea = br.readLine();

            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            nombre = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            ape1 = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            tit1 = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            ape2 = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            tit2 = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            telCon = linea;
            linea = br.readLine();
            linea = linea.substring(linea.indexOf(':') + 2, linea.length());
            emailCon = linea;

            eq = new Equipo(nombre, ape1, tit1, ape2, tit2, telCon, emailCon);
            escribirBufFichero("Correo.csv", eq.imprimir());


        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        } finally {
            br.close();
            fw.close();
        }
    }

    public static void listar(String ruta) throws IOException {
        File carpeta = new File(ruta);
        for (String archivo : carpeta.list()) {
            if (archivo.contains(".txt")&&archivo.contains("email"))
                leerBufFichero(archivo);


        }
    }

    public static void main(String[] args) throws IOException {
        
        listar("./");

    }
}