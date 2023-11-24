package com.example.lp1v03.Controller;

import org.hibernate.*;
import com.example.lp1v03.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.events.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCadastro implements Initializable {

    @FXML
    private Button btNovaTarefa;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btCriarConta;

    @FXML
    private PasswordField txConfirmar;

    @FXML
    private TextField txUsername;

    @FXML
    private TextField txNome;

    @FXML
    private PasswordField txSenha;

    @FXML
    private void fecha(ActionEvent event){
        Stage stage = (Stage)btCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cadastrar(ActionEvent event) {
        String nome = txNome.getText();
        String username = txUsername.getText();
        String senha = txSenha.getText();
        String confirmacao = txConfirmar.getText();

        if (nome.isEmpty() || username.isEmpty()) {
            exibirAlertaErro("Por favor, preencha todos os campos.");
            return;
        }

        if (confirmacao.isEmpty() || senha.isEmpty() ){
            exibirAlertaErro("Crie uma senha para prosseguir");
            return;
        }

        if (!confirmacao.equals(senha)) {
            exibirAlertaErro("As Senhas estão diferentes uma da outra");
            return;
        }


        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            User usuario1 = new User();
            usuario1.setNome(nome);
            usuario1.setUsername(username);
            usuario1.setPassword(senha);

            session.save(usuario1);

            transaction.commit();

            exibirAlertaInformativo("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            exibirAlertaErro("Erro ao cadastrar usuario. Detalhes: " + e.getMessage());
        }
    }

    private void exibirAlertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void exibirAlertaInformativo(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }


        // cuidado com essa parte do código, ela dá erro
        @Override
        public void initialize(URL url, ResourceBundle rb) {

            System.out.println("foi");
        }
}
