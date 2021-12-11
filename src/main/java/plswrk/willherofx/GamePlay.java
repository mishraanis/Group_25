package plswrk.willherofx;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    @FXML
    AnchorPane layout;

    @FXML
    Pane pauseMenuPane;

    @FXML
    ImageView pause, pauseMenu;

    @FXML
    Button resume, restart_pause, restart_end, exit_pause, exit_end, save;

    @FXML
    ImageView hero, orc1, island1, island2, island3, weapon_chest1, coin_chest1, TNT1;

    @FXML
    Pane endPane;

    private ArrayList<Island> islands;
    private Hero hero_obj;
    private Orc orc_obj;
    private Weapon_Chest weapon_chest_obj;
    private Coin_Chest coin_chest_obj;
    private TNT TNT_obj;

    public void InitialiseAll_FXML_Objects(Scene scene) {
        hero = (ImageView) scene.lookup("#hero");
        orc1 = (ImageView) scene.lookup("#orc1");
        weapon_chest1 = (ImageView) scene.lookup("#weapon_chest1");
        coin_chest1 = (ImageView) scene.lookup("#coin_chest1");
        TNT1 = (ImageView) scene.lookup("#TNT1");
        layout = (AnchorPane) scene.lookup("#layout");
        pauseMenuPane = (Pane) scene.lookup("#pauseMenuPane");
        endPane = (Pane) scene.lookup("#endPane");
        pause = (ImageView) scene.lookup("#pause");
        resume = (Button) scene.lookup("#resume");
        HelloApplication.setEffect(resume);
        restart_pause = (Button) scene.lookup("#restart_pause");
        HelloApplication.setEffect(restart_pause);
        restart_end = (Button) scene.lookup("#restart_end");
        HelloApplication.setEffect(restart_end);
        exit_pause = (Button) scene.lookup("#exit_pause");
        HelloApplication.setEffect(exit_pause);
        exit_end = (Button) scene.lookup("#exit_end");
        HelloApplication.setEffect(exit_end);
        save = (Button) scene.lookup("#save");
        HelloApplication.setEffect(save);

        island1 = (ImageView) scene.lookup("#island1");
        island2 = (ImageView) scene.lookup("#island2");
        island3 = (ImageView) scene.lookup("#island3");
        pauseMenuPane.setVisible(false);
        endPane.setVisible(false);
        BackgroundSize backgroundSize = new BackgroundSize(1000, 550, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("newBG.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background bg = new Background(backgroundImage);
        layout.setBackground(bg);
    }
    public void InitializeAll_ClassObjects() {
        hero_obj = new Hero(hero, null, 100, 1.0, 2.0, hero.getLayoutX(), hero.getLayoutY());

        Island island1_obj = new Island(island1, island1.getLayoutX(), island1.getLayoutY());
        Island island2_obj = new Island(island2, island2.getLayoutX(), island2.getLayoutY());
        Island island3_obj = new Island(island3, island3.getLayoutX(), island3.getLayoutY());
        islands = new ArrayList<>();
        islands.add(island1_obj);
        islands.add(island2_obj);
        islands.add(island3_obj);

        Image Weapon_chest_open1 = new Image("wep_0000 #50076.png");
        Image Weapon_chest_open2 = new Image("wep_0001 #18659.png");
        Image Weapon_chest_open3 = new Image("wep_0002 #18442.png");
        Image Weapon_chest_open4 = new Image("wep_0003.png");
        Image Weapon_chest_open5 = new Image("wep_0004 #36957.png");
        Image Weapon_chest_open6 = new Image("wep_0005 #37946.png");
        Image Weapon_chest_open7 = new Image("wep_0006 #42713.png");
        Image Weapon_chest_open8 = new Image("wep_0007 #45764.png");
        Image Weapon_chest_open9 = new Image("wep_0008 #32756.png");
        Image Weapon_chest_open10 = new Image("wep_0009 #50124.png");
        Image Weapon_chest_open11 = new Image("wep_0010 #21871.png");
        List<Image> Weapon_chest_List = new ArrayList<>();
        Weapon_chest_List.add(Weapon_chest_open1);
        Weapon_chest_List.add(Weapon_chest_open2);
        Weapon_chest_List.add(Weapon_chest_open3);
        Weapon_chest_List.add(Weapon_chest_open4);
        Weapon_chest_List.add(Weapon_chest_open5);
        Weapon_chest_List.add(Weapon_chest_open6);
        Weapon_chest_List.add(Weapon_chest_open7);
        Weapon_chest_List.add(Weapon_chest_open8);
        Weapon_chest_List.add(Weapon_chest_open9);
        Weapon_chest_List.add(Weapon_chest_open10);
        Weapon_chest_List.add(Weapon_chest_open11);
        weapon_chest_obj = new Weapon_Chest(weapon_chest1, Weapon_chest_List, new Weapon("Sword", 0, 30.0, new Range(3, 3)), weapon_chest1.getLayoutX(), weapon_chest1.getLayoutY());

        Image orc_death1 = new Image("orcDeath1.png");
        Image orc_death2 = new Image("orcDeath2.png");
        Image orc_death3 = new Image("orcDeath3.png");
        Image orc_death4 = new Image("orcDeath4.png");
        List<Image> orc_deathImages = new ArrayList<>();
        orc_deathImages.add(orc_death1);
        orc_deathImages.add(orc_death2);
        orc_deathImages.add(orc_death3);
        orc_deathImages.add(orc_death4);
        orc_obj = new Orc(orc1, orc_deathImages, 100, orc1.getLayoutX(), orc1.getLayoutY());

        Image Coin_chest_open1 = new Image("wep_0000 #51930.png");
        Image Coin_chest_open2 = new Image("wep_0001 #38556.png");
        Image Coin_chest_open3 = new Image("wep_0002 #57623.png");
        Image Coin_chest_open4 = new Image("wep_0003 #46880.png");
        Image Coin_chest_open5 = new Image("wep_0004 #26021.png");
        Image Coin_chest_open6 = new Image("wep_0005 #50050.png");
        Image Coin_chest_open7 = new Image("wep_0006 #56893.png");
        Image Coin_chest_open8 = new Image("wep_0007 #37947.png");
        Image Coin_chest_open9 = new Image("wep_0008 #30876.png");
        Image Coin_chest_open10 = new Image("wep_0009 #57652.png");
        Image Coin_chest_open11 = new Image("wep_0010 #129.png");
        List<Image> Coin_chest_List = new ArrayList<>();
        Coin_chest_List.add(Coin_chest_open1);
        Coin_chest_List.add(Coin_chest_open2);
        Coin_chest_List.add(Coin_chest_open3);
        Coin_chest_List.add(Coin_chest_open4);
        Coin_chest_List.add(Coin_chest_open5);
        Coin_chest_List.add(Coin_chest_open6);
        Coin_chest_List.add(Coin_chest_open7);
        Coin_chest_List.add(Coin_chest_open8);
        Coin_chest_List.add(Coin_chest_open9);
        Coin_chest_List.add(Coin_chest_open10);
        Coin_chest_List.add(Coin_chest_open11);
        coin_chest_obj = new Coin_Chest(coin_chest1, Coin_chest_List, 50, coin_chest1.getLayoutX(), coin_chest1.getLayoutY());

        Image TNT_explode1 = new Image("TNT_explode1.png");
        Image TNT_explode2 = new Image("TNT_explode2.png");
        Image TNT_explode3 = new Image("TNT_explode3.png");
        Image TNT_explode4 = new Image("TNT_explode4.png");
        Image TNT_explode5 = new Image("TNT_explode5.png");
        List<Image> TNT_explodeImages = new ArrayList<>();
        TNT_explodeImages.add(TNT_explode1);
        TNT_explodeImages.add(TNT_explode2);
        TNT_explodeImages.add(TNT_explode3);
        TNT_explodeImages.add(TNT_explode4);
        TNT_explodeImages.add(TNT_explode5);
        TNT_obj = new TNT(TNT1, TNT_explodeImages, TNT1.getLayoutX(), TNT1.getLayoutY(), new Range(30, 30));
    }
    public void start(Scene scene) throws IOException {
        InitialiseAll_FXML_Objects(scene);
        InitializeAll_ClassObjects();
        Pair<TranslateTransition, TranslateTransition> hero_hop = hop(hero_obj);
        Pair<TranslateTransition, TranslateTransition> orc_hop = hop(orc_obj);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                if(hero_hop.getFirst().getStatus()== Animation.Status.RUNNING) {
                    hero_hop.getFirst().pause();
                }
                if(hero_hop.getSecond().getStatus()== Animation.Status.RUNNING) {
                    hero_hop.getSecond().pause();
                }
                TranslateTransition hero_mov = move(hero_obj, 100);
                hero_mov.play();
                hero_mov.setOnFinished(event -> {
                    if(hero_hop.getFirst().getStatus()== Animation.Status.PAUSED) {
                        hero_hop.getFirst().play();
                    }
                    if(hero_hop.getSecond().getStatus()== Animation.Status.PAUSED) {
                        hero_hop.getSecond().play();
                    }
                });
            }
        });

        orc_obj.getImage().setOnMouseClicked(e -> {
            orc_hop.getFirst().pause();
            orc_hop.getSecond().pause();
            orc_obj.die();
        });
        Effect original_effect = pause.getEffect();
        pause.setOnMouseEntered(event -> {
            DropShadow shadow = new DropShadow(20, Color.BLACK);
            shadow.setWidth(32.68);
            shadow.setHeight(32.68);
            pause.setEffect(shadow);
        });
        pause.setOnMouseExited(event -> {
            pause.setEffect(original_effect);
        });
        pause.setOnMouseClicked(mouseEvent -> {
            if(hero_hop.getFirst().getStatus()== Animation.Status.RUNNING) {
                hero_hop.getFirst().pause();
            }
            if(hero_hop.getSecond().getStatus()== Animation.Status.RUNNING) {
                hero_hop.getSecond().pause();
            }
            if(orc_hop.getFirst().getStatus()== Animation.Status.RUNNING) {
                orc_hop.getFirst().pause();
            }
            if(orc_hop.getSecond().getStatus()== Animation.Status.RUNNING) {
                orc_hop.getSecond().pause();
            }
            pauseMenuPane.setVisible(true);
        });

        resume.setOnMouseClicked(mouseEvent -> {
            pauseMenuPane.setVisible(false);
            if(hero_hop.getFirst().getStatus()== Animation.Status.PAUSED) {
                hero_hop.getFirst().play();
            }
            if(hero_hop.getSecond().getStatus()== Animation.Status.PAUSED) {
                hero_hop.getSecond().play();
            }
            if(orc_hop.getFirst().getStatus()== Animation.Status.PAUSED) {
                orc_hop.getFirst().play();
            }
            if(orc_hop.getSecond().getStatus()== Animation.Status.PAUSED) {
                orc_hop.getSecond().play();
            }
        });

        exit_pause.setOnMouseClicked(mouseEvent -> {
//            HelloController controller = new HelloController();
            try {
                new HelloApplication().start(HelloApplication.Gstage);
//                controller.switchToStartGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        restart_pause.setOnMouseClicked(mouseEvent -> {
            HelloController controller = new HelloController();
            try {
                controller.switchToGamePlay();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        restart_end.setOnMouseClicked(mouseEvent -> {
//            HelloController controller = new HelloController();
            try {
                new HelloApplication().start(HelloApplication.Gstage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exit_end.setOnMouseClicked(mouseEvent -> {
//            HelloController controller = new HelloController();
            try {
                new HelloApplication().start(HelloApplication.Gstage);
//                controller.switchToStartGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        weapon_chest_obj.getImage().setOnMouseClicked(mouseEvent -> {
            try {
                weapon_chest_obj.open();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        coin_chest_obj.getImage().setOnMouseClicked(mouseEvent -> {
            try {
                coin_chest_obj.open();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        TNT_obj.getImage().setOnMouseClicked(mouseEvent -> {
            TNT_obj.explode();
        });

        HelloApplication.Gstage.setScene(scene);
        HelloApplication.Gstage.show();
    }

    public Pair<TranslateTransition, TranslateTransition> hop(Living character) {

        ImageView character_image = character.getImage();
        TranslateTransition jump = new TranslateTransition(Duration.millis(520), character_image);
        jump.setByY((-1)*character.getJumpHeight());
        jump.setCycleCount(1);
        jump.setAutoReverse(false);


        TranslateTransition fall = new TranslateTransition(Duration.millis(25), character_image);
        fall.setByY(5);
        fall.setCycleCount(1);
        fall.setOnFinished(actionEvent -> {
            character.setCurr_pos_y(character.getCurr_pos_y() + 5);
            boolean gameEnd = false;
            if(character == hero_obj){
                if (character.getCurr_pos_y() + character_image.getFitHeight() >= 600) {
                    endPane.setVisible(true);
                    gameEnd = true;
                }
            }
            boolean temp = false;
            Island targetIsland = null;
            for(Island island : islands){
                if((island.getCurr_pos_x() + island.getImage().getFitWidth()) >= character.getCurr_pos_x() && island.getCurr_pos_x() <= (character.getCurr_pos_x() + character_image.getFitWidth())){
                    targetIsland = island;
                    break;
                }
            }
            if(targetIsland != null){
                if((targetIsland.getCurr_pos_y() > character.getCurr_pos_y()) &&
                        ((character.getCurr_pos_y() + character_image.getFitHeight()) <= (targetIsland.getCurr_pos_y()+3)) &&
                        (targetIsland.getCurr_pos_y() <= (character.getCurr_pos_y() + character_image.getFitHeight()))){
                    fall.pause();
                    temp = true;
                    jump.play();

                }
            }
            if(!temp && !gameEnd) {
                fall.play();
            }
        });

        jump.setOnFinished(actionEvent -> {
            character.setCurr_pos_y(character.getCurr_pos_y() - character.getJumpHeight());
            fall.play();
        });

        jump.play();
        return new Pair<>(jump, fall);
    }

    public TranslateTransition move(Living character, double x) {
        ImageView character_image = character.getImage();
        TranslateTransition move = new TranslateTransition();
        move.setNode(character_image);
        move.setDuration(Duration.millis(200));
        move.setCycleCount(1);
        move.setAutoReverse(false);
        character.setCurr_pos_x(character.getCurr_pos_x() + x);
        move.setByX(x);
        return move;
    }
}