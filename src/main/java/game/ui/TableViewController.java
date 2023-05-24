package game.ui;

import game.result.GameResult;
import game.result.JsonGameResultManager;
import game.result.PlayerStatistics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.nio.file.Path;

public class TableViewController {

    @FXML
    private TableView<PlayerStatistics> tableView;

    @FXML
    private TableColumn<GameResult, String> winnerName;

    @FXML
    private TableColumn<GameResult, Long> numberOfWins;

    @FXML
    private void initialize() throws IOException {
        winnerName.setCellValueFactory(new PropertyValueFactory<>("winnerName"));
        numberOfWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWins"));
        ObservableList<PlayerStatistics> observableList = FXCollections.observableArrayList();
        observableList.addAll(new JsonGameResultManager(Path.of("results.json")).getBestPlayers(10));
        tableView.setItems(observableList);
    }

}
