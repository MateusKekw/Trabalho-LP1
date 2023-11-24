package com.example.lp1v03.Controller;

import com.example.lp1v03.model.*;
import com.example.lp1v03.util.HibernateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerTarefas implements Initializable {
    @FXML
    private TableView<Tarefas> tarefasTable;
    @FXML
    private TableColumn<Tarefas, String> tituloColumn;
    @FXML
    private TableColumn<Tarefas, String> descricaoColumn;
    @FXML
    private TableColumn<Tarefas, String> dataVencimentoColumn;
    @FXML
    private TableColumn<Tarefas, String> statusColumn;

    private ObservableList<Tarefas> tarefasList = FXCollections.observableArrayList();


    // cuidado com essa parte do código, ela dá erro
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //configureTable();
        //loadTarefas();
        System.out.println("foi");
    }
/*

    private void configureTable() {
        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        descricaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        dataVencimentoColumn.setCellValueFactory(new PropertyValueFactory<>("dataDeVencimento"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        tarefasTable.setItems(tarefasList);
    }


    private void loadTarefas() {
        tarefasList.clear();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User currentUser = getCurrentUser(); // Implemente a lógica para obter o usuário logado

            if (currentUser != null) {
                tarefasList.addAll(currentUser.getTarefas());
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
*/
    // Outros métodos de controle da interface do usuário
    // Por exemplo, métodos para adicionar, editar e excluir tarefas, notificações, etc.

    private User getCurrentUser() {
        // Implemente a lógica para obter o usuário logado, por exemplo, através da autenticação.
        return null;
    }


}