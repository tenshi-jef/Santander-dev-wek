package me.dio.santander_dev_week_2023.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class DatabaseInitializerConfig implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private DataSource dataSource;

    private final List<String> sqlFiles = Arrays.asList(
            "/scripts/user.sql",
            "/scripts/account.sql",
            "/scripts/card.sql",
            "/scripts/transactions.sql",
            "/scripts/limit.sql",
            "/scripts/newsfeed.sql"
    );

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try (Connection connection = dataSource.getConnection()) {
            for (String path : sqlFiles) {
                try (
                        InputStream inputStream = getClass().getResourceAsStream(path);
                        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")
                ) {
                    String sql = scanner.hasNext() ? scanner.next() : "";
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(sql);
                    }
                    System.out.println("Executado: " + path);
                }
            }
            System.out.println("Todos os scripts SQL foram executados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
