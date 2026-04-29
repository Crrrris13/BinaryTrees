public class BSTtest {
    public static void main(String[] args) {
 
        BST<String, String> tree = new BST<>();
 
        // Insertar elementos del ejemplo
        tree.insert("house", "casa");
        tree.insert("dog", "perro");
        tree.insert("homework", "tarea");
        tree.insert("woman", "mujer");
        tree.insert("town", "pueblo");
        tree.insert("yes", "sí");
 
        // ---- PRUEBAS DE INSERT ----
        System.out.println("=== Pruebas de INSERT ===");
 
        System.out.println("Size esperado 6: "
            + (tree.size() == 6 ? "PASS" : "FAIL"));
 
        tree.insert("dog", "can"); // duplicado
        System.out.println("Duplicado no aumenta size: "
            + (tree.size() == 6 ? "PASS" : "FAIL"));
 
        System.out.println("Duplicado actualiza valor: "
            + ("can".equals(tree.search("dog").getValue()) ? "PASS" : "FAIL"));
 
        // ---- PRUEBAS DE SEARCH ----
        System.out.println("\n=== Pruebas de SEARCH ===");
 
        System.out.println("Buscar raíz 'house': "
            + (tree.search("house") != null ? "PASS" : "FAIL"));
 
        System.out.println("Buscar 'homework' → tarea: "
            + ("tarea".equals(tree.search("homework").getValue()) ? "PASS" : "FAIL"));
 
        System.out.println("Buscar 'yes' → sí: "
            + ("sí".equals(tree.search("yes").getValue()) ? "PASS" : "FAIL"));
 
        System.out.println("Buscar inexistente 'cat' → null: "
            + (tree.search("cat") == null ? "PASS" : "FAIL"));
 
        BST<String, String> emptyTree = new BST<>();
        System.out.println("Buscar en árbol vacío → null: "
            + (emptyTree.search("house") == null ? "PASS" : "FAIL"));
    }

}
