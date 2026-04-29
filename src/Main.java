import java.util.List;
import java.io.*;

public class Main {
    private BST<String, String> bst;

    public Main() {
        this.bst = new BST<>();
    }

    public void loadDictionary(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    parseAndInsert(line);
                }
            }
            System.out.println("Existen " + bst.size() + " palabras en el diccionario.\n");
        } catch (IOException e) {
            System.err.println("No se pudo cargar el diccionario: " + e.getMessage());
        }
    }

    private void parseAndInsert(String line) {
        line = line.replace("(", "").replace(")", "").trim(); // Eliminar comillas
        int separatorIndex = line.indexOf(',');
        if (separatorIndex != -1) {
            String word = line.substring(0, separatorIndex).trim().toLowerCase();
            String meaning = line.substring(separatorIndex + 1).trim();
            bst.insert(word, meaning);
        } else {
           return ;
        }
    }

    public void inOrder() {
        System.out.println("Palabras en orden alfabético:");
        List<Association<String, String>> sorted = bst.inOrder();
        for (Association<String, String> assoc : sorted) {
            System.out.println(assoc + " ");
        }
        System.out.println("\n");
    }

    public void translate(String filename) {
        System.out.println("Traducción de palabras:");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(translateLine(line));
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo de traducción: " + e.getMessage());
        }
    }

    private String translateLine(String line) {
        StringBuilder translated = new StringBuilder();
        String[] words = line.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].replaceAll("[^a-zA-Z]", "");

            Association<String, String> found = bst.search(word.toLowerCase());

            if (found != null) {
                translated.append(found.getValue());
            } else {
                translated.append(word);
            }

            if (i < words.length - 1) {
                translated.append(" ");
            }
        }
        return translated.toString();
    }

        public static void main(String[] args) {
        Main dict = new Main();
 
        // Rutas a los archivos (ajustar si es necesario)
        String dictionaryFile = "diccionario.txt";
        String textFile       = "texto.txt";
 
        // Paso 1: Cargar el diccionario en el BST
        dict.loadDictionary(dictionaryFile);
 
        // Paso 2: Imprimir el diccionario en orden in-order
        dict.inOrder();
 
        // Paso 3: Traducir el texto de entrada
        dict.translate(textFile);
    }

}
