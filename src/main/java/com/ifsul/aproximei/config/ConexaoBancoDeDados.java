package com.ifsul.aproximei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ConexaoBancoDeDados {

    @Value("${spring.datasource.url}")
    private String server;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pass;

    @Value("${spring.jpa.properties.hibernate.default_schema:public}")
    private String schema;

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(server, user, pass);
            
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("SET search_path TO " + schema);
            }

            return connection;

        } catch (SQLException e) {
            System.err.println("Erro ao conectar no banco de dados:");
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão:");
            e.printStackTrace();
        }
    }
}
