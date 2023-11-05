package Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import model.User;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Controller_Tarefas {
    @FXML
    private TableView<model.Tarefas> tarefasTable;
    @FXML
    private TableColumn<model.Tarefas, String> tituloColumn;
    @FXML
    private TableColumn<model.Tarefas, String> descricaoColumn;
    @FXML
    private TableColumn<model.Tarefas, String> dataVencimentoColumn;
    @FXML
    private TableColumn<model.Tarefas, String> statusColumn;

    private ObservableList<model.Tarefas> tarefasList = FXCollections.observableArrayList();

    public void initialize() {
        configureTable();
        loadTarefas();
    }

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

    // Outros métodos de controle da interface do usuário
    // Por exemplo, métodos para adicionar, editar e excluir tarefas, notificações, etc.

    private User getCurrentUser() {
        // Implemente a lógica para obter o usuário logado, por exemplo, através da autenticação.
        return null;
    }
}