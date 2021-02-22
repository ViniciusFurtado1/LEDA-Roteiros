package recursao;

public class TestarMetodosRecursivos {
    public static void main(String[] args) {
        // preencha esse metodo com codigo para testar a classe MetodosRecursivos.

        MetodosRecursivos m = new MetodosRecursivos();

        System.out.println(m.progressaoAritmetica(2, 4, 3));     // Esperado: 10.0
        System.out.println(m.progressaoGeometrica(2, 3, 3));     // Esperado: 18:0
        System.out.println(m.calcularSomaArray(new int[]{1, 2, 3, 4}));              // Esperado: 10
        System.out.println(m.calcularFatorial(10));                               // Esperado: 3628800
        System.out.println(m.calcularFibonacci(10));                              // Esperado: 55
        System.out.println(m.countNotNull(new Object[]{1, 2, 3, 4}));                // Esperado: 4
        System.out.println(m.potenciaDe2(5));                               // Esperado: 32
    }
}
