package me.dio.santander_dev_week_2023.methods;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Random;

public class GlobalMethods {
    public static <T> T AtualizarDados(T novoObjeto, T objetoAntigo) {
        if (novoObjeto == null || objetoAntigo == null) {
            throw new IllegalArgumentException("Os objetos não podem ser nulos.");
        }

        final String IDENTIFIER_NAME = "id";

        for (Field field : novoObjeto.getClass().getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase(IDENTIFIER_NAME)) continue;

            atualizarCampoSeNecessario(field, novoObjeto, objetoAntigo);
        }

        return objetoAntigo;
    }

    private static <T> void atualizarCampoSeNecessario(Field field, T novoObjeto, T objetoAntigo) {
        try {
            field.setAccessible(true);

            Object valorNovo = field.get(novoObjeto);
            Object valorAntigo = field.get(objetoAntigo);

            if (valorNovo != null && !Objects.equals(valorNovo, valorAntigo)) {
                field.set(objetoAntigo, valorNovo);
            }

        } catch (IllegalAccessException ex) {
            throw new IllegalArgumentException("Erro ao acessar o campo: " + field.getName(), ex);
        }
    }

    public static String GerarNumeroCartao() {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int digito = random.nextInt(10);
            numeroCartao.append(digito);

            // Adiciona ponto após cada 4 dígitos, exceto no final
            if ((i + 1) % 4 == 0 && i < 15) {
                numeroCartao.append('.');
            }
        }

        return numeroCartao.toString();
    }

    public static void main(String[] args) {
        String numero = GerarNumeroCartao();
        System.out.println("Número do cartão gerado: " + numero);
    }
}
