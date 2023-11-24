package com.example.lp1v03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gerenciador_de_Tarefas extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Gerenciador_de_Tarefas.class.getResource("Tarefas_view2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570, 420);
        stage.setTitle("Gerenciador de Tarefas: Cadastro");
        stage.setScene(scene);
        stage.show();
    }


}