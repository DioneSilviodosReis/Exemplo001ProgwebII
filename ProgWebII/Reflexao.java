import java.lang.reflect.*;

class Reflexao {
    public static void listar(Object o) {
        Class<?> c = o.getClass();
        System.out.println("\n=== " + c.getSimpleName() + " ===");

        // Atributos com valores
        Class<?> atual = c;
        while (atual != null) {
            Field[] campos = atual.getDeclaredFields();
            for (int i = 0; i < campos.length; i++) {
                campos[i].setAccessible(true);
                try {
                    System.out.println(campos[i].getName() + " = " + campos[i].get(o));
                } catch (Exception e) {}
            }
            atual = atual.getSuperclass();
        }

        // Métodos
        Method[] metodos = c.getMethods();
        for (int i = 0; i < metodos.length; i++) {
            System.out.println(metodos[i].getName());
        }
    }
}
