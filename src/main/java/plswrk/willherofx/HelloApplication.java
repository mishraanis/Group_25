package plswrk.willherofx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class HelloApplication extends Application {
    public static Stage Gstage;
    @FXML
    transient public Button gameStartButton;

    public static void serialize(String name, GamePlay gamePlay) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("src/main/resources/SavedGames/" +name+".txt"));
            out.writeObject(gamePlay);
        } finally {
            assert out != null;
            out.close();
        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        Gstage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StartGamePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Gstage.setTitle("Will Hero");
        Image icon = new Image("icon.png");
        Gstage.getIcons().add(icon);
        Gstage.setScene(scene);
        ListView<String> listView = (ListView<String>) Gstage.getScene().lookup("#savedGamesList");
        listView.setVisible(false);
        listView.setOpacity(0);
        gameStartButton = (Button) Gstage.getScene().lookup("#gameStartButton");
        setEffect(gameStartButton);
        Gstage.show();
    }

    public static void setEffect(Button button) {
        Effect original_effect = button.getEffect();
        button.setOnMouseEntered(event -> {
            DropShadow shadow = new DropShadow(20, Color.BLACK);
            shadow.setWidth(32.68);
            shadow.setHeight(32.68);
            button.setEffect(shadow);
        });
        button.setOnMouseExited(event -> button.setEffect(original_effect));
    }
    public static void main(String[] args) {
        launch();
    }
}