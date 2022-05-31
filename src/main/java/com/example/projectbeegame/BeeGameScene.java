package com.example.projectbeegame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class BeeGameScene extends Application {

    //region Stage-Scene
    Stage window;
    Scene startScene, playerScene, insertScene;
    //endregion
    //region List
    ArrayList<Character> dizi2 = new ArrayList<>();
    //endregion
    //region Font
    Font buttonFont = new Font("Verdana", 24);
    Font labelFont = new Font("Verdana", 12);
    //endregion
    //region Image
    FileInputStream fileInputStream = new FileInputStream("src/main/resources/image/startPanelImage.png");//insert image
    Image background = new Image(fileInputStream);
    ImageView backgroundView = new ImageView(background);
    FileInputStream cursor = new FileInputStream("src/main/resources/image/cursor.png"); //cursor image
    Image cursorImage = new Image(cursor);//cursor image
    //endregion
    //region Object from Other Class
    GameController controllerGame = new GameController();
    //endregion
    //region Button
    Button button1 = new Button();
    Button button2 = new Button();
    Button button3 = new Button();
    Button button4 = new Button();
    Button button5 = new Button();
    Button button6 = new Button();
    Button button7 = new Button();
    Button Switch = new Button();
    //endregion

    String character = "";
    TextField text = new TextField();
    public BeeGameScene() throws FileNotFoundException {
    }

    @Override
    public void start(Stage PlayStage) throws Exception {
        window = PlayStage;

        //region StartPane
        Pane startPane = new Pane();
        Cursor(startPane); // Cursor methodu oluşturularak cursor değişimi sağlandı.

        //region StartPane sahnesindeki OYNA butonu
        Button playButton = new Button("");
        playButton.setText("OYNA");
        playButton.setMinWidth(200);
        playButton.setTranslateX(150);
        playButton.setTranslateY(180);
        playButton.setFont(buttonFont);
        playButton.setStyle("-fx-background-color: #ffd83a");
        playButton.setOnAction(actionEvent ->
        {
            window.setScene(playerScene);
            try {
                controllerGame.readFile();
                controllerGame.createPangram("", false);
                setButton();
            } catch (IOException e) {
                e.printStackTrace();

            }


        }); //play butonuna basıldığında sahne değişimi yapılır.
        //endregion

        //region StartPane sahnesindeki KELİME EKLE butonu
        Button insertButton = new Button("");
        insertButton.setText("OYUN OLUŞTUR");
        insertButton.setMinWidth(200);
        insertButton.setTranslateX(150);
        insertButton.setTranslateY(250);
        insertButton.setFont(buttonFont);
        insertButton.setStyle("-fx-background-color: #ffd83a");
        insertButton.setOnAction(actionEvent -> window.setScene(insertScene));
        //endregion


        startPane.getChildren().addAll(backgroundView, insertButton, playButton);
        startScene = new Scene(startPane, 500, 500);
        //endregion

        //region CreatePane
        Pane insertPane = new Pane();
        Cursor(insertPane);
        Label info = new Label(" ");
        info.setFont(labelFont);
        info.setTranslateX(150);
        info.setTranslateY(100);
        TextField textWord = new TextField();
        textWord.setPromptText("Lütfen 7 harflik kelimeyi giriniz.");
        textWord.setAlignment(Pos.CENTER);
        textWord.setTranslateX(150);
        textWord.setTranslateY(150);
        textWord.setPrefHeight(50);
        textWord.setPrefWidth(200);
        textWord.setBorder(Border.EMPTY);

        //region Oluştur Butonu
        Button buttonCreate = new Button("");
        buttonCreate.setText("OLUŞTUR");
        buttonCreate.setMinWidth(200);
        buttonCreate.setTranslateX(150);
        buttonCreate.setTranslateY(230);
        buttonCreate.setFont(buttonFont);
        buttonCreate.setStyle("-fx-background-color: #ffd83a");
        buttonCreate.setOnAction(actionEvent ->
        {
            window.setScene(playerScene);
            try {
                controllerGame.readFile();
                controllerGame.createPangram(textWord.getText().toLowerCase((Locale.getDefault())), true);
                setButton();
            } catch (IOException e) {
                e.printStackTrace();

            }
        });
        //endregion

        //region Geri Dön Butonu
        Button backButton = new Button("ANA SAYFA");
        backButton.setMinWidth(200);
        backButton.setTranslateX(150);
        backButton.setTranslateY(300);
        backButton.setFont(buttonFont);
        backButton.setStyle("-fx-background-color: #ffd83a");
        backButton.setOnAction(actionEvent -> window.setScene(startScene));
        //endregion
        insertPane.getChildren().addAll(backButton, info, buttonCreate, textWord);
        insertScene = new Scene(insertPane, 500, 500);
        //endregion

        //region PlayerPane
        Pane playerPane = new Pane();
        Cursor(playerPane);

        //region Button1
        button1.setShape(new Circle(40));
        button1.setMinWidth(78);
        button1.setMinHeight(78);
        button1.setTranslateX(413);
        button1.setTranslateY(285);
        button1.setFont(Font.font(25));
        button1.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Button 2
        button2.setShape(new Circle(40));
        button2.setMinWidth(78);
        button2.setMinHeight(78);
        button2.setTranslateX(510);
        button2.setTranslateY(285);
        button2.setFont(Font.font(25));
        button2.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Button 3
        button3.setShape(new Circle(40));
        button3.setMinWidth(78);
        button3.setMinHeight(78);
        button3.setTranslateX(360);
        button3.setTranslateY(365);
        button3.setFont(Font.font(25));
        button3.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Button 4
        button4.setShape(new Circle(40));
        button4.setMinWidth(78);
        button4.setMinHeight(78);
        button4.setTranslateX(461);
        button4.setTranslateY(365);
        button4.setFont(Font.font(25));
        button4.setStyle("-fx-background-color: #ffd83a");


        //endregion

        //region Button 5
        button5.setShape(new Circle(40));
        button5.setMinWidth(78);
        button5.setMinHeight(78);
        button5.setTranslateX(560);
        button5.setTranslateY(365);
        button5.setFont(Font.font(25));
        button5.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Button 6
        button6.setShape(new Circle(40));
        button6.setMinWidth(78);
        button6.setMinHeight(78);
        button6.setTranslateX(413);
        button6.setTranslateY(445);
        button6.setFont(Font.font(25));
        button6.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Button 7
        button7.setShape(new Circle(40));
        button7.setMinWidth(78);
        button7.setMinHeight(78);
        button7.setTranslateX(510);
        button7.setTranslateY(445);
        button7.setFont(Font.font(25));
        button7.setStyle("-fx-background-color: #8a8a87");
        //endregion

        //region Switch
        Switch.setShape(new Circle(40));
        Switch.setText("Switch");
        Switch.setMinWidth(50);
        Switch.setMinHeight(50);
        Switch.setTranslateX(474);
        Switch.setTranslateY(552);
        //endregion

        //region delete
        Button buttondelete = new Button("Delete");
        buttondelete.setLayoutX(370);
        buttondelete.setLayoutY(560);
        buttondelete.setPrefSize(80.0, 40.0);
        buttondelete.setStyle("-fx-background-radius: 15");
        //endregion

        //region enter
        Button buttonenter = new Button("Enter");
        buttonenter.setLayoutX(550);
        buttonenter.setLayoutY(560);
        buttonenter.setPrefSize(80.0, 40.0);
        buttonenter.setStyle("-fx-background-radius: 15");
        //endregion

        //region Text
        text.setPrefSize(277, 37);
        text.setTranslateX(363);
        text.setTranslateY(200);
        text.setFont(Font.font(25));
        //endregion

        //region ListView
        ListView<String> listView = new ListView<>();
        listView.setOrientation(Orientation.VERTICAL);
        listView.setTranslateX(850);
        listView.setTranslateY(200);
        listView.setPrefSize(450, 500);
//endregion

        //region Klavye
        text.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (!"ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefghıijklmnoöprstşuüvyz".contains(keyEvent.getCharacter())) {
                    keyEvent.consume();
                    System.out.println("deneme");
                } else {

                }
            }
        });
        //endregion

        //region Event
        button1.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {


                character += button1.getText();
                text.setText(character);


            }


        });
        button2.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button2.getText();
                text.setText(character);

            }
        });
        button3.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button3.getText();
                text.setText(character);

            }
        });
        button4.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button4.getText();
                text.setText(character);

            }
        });
        button5.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button5.getText();
                text.setText(character);

            }
        });
        button6.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button6.getText();
                text.setText(character);

            }
        });
        button7.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                character += button7.getText();
                text.setText(character);

            }
        });

        Switch.setOnAction(actionEvent -> setButton());

        buttonenter.setOnAction(actionEvent -> {
            if (text.getText().length() > 3) {

                if (controllerGame.isValid(text.getText().toLowerCase())) {
                    listView.getItems().addAll(text.getText());
                    controllerGame.calculatePoint(text.getText());
                }

            } else
                System.out.println("Hata");
            text.clear();
            character = "";

        });

        buttondelete.setOnAction(actionEvent -> {
            text.clear();
            character = "";

        });
        //endregion

        playerPane.getChildren().addAll(listView, button1, button2, button3, button4, button5, button6, button7, buttondelete, buttonenter, text, Switch);
        playerScene = new Scene(playerPane, 500, 500);
        //endregion

        window.setScene(startScene);
        window.setTitle("Bee Word Game");
        window.show();
    }


    public void Cursor(Pane pane) {
        pane.setCursor(new ImageCursor(cursorImage,
                cursorImage.getWidth() / 2,
                cursorImage.getHeight() / 2));
    }

    public void setButton() {
        dizi2 = controllerGame.separateWord(controllerGame.honeycombWord);
        Collections.shuffle(dizi2);//Diziyi karıştırdım ve butonların textine atadım.
        button1.setText(dizi2.get(0).toString().toUpperCase(Locale.getDefault()));
        button2.setText(dizi2.get(1).toString().toUpperCase(Locale.getDefault()));
        button3.setText(dizi2.get(2).toString().toUpperCase(Locale.getDefault()));
        button4.setText(dizi2.get(3).toString().toUpperCase(Locale.getDefault()));
        button5.setText(dizi2.get(4).toString().toUpperCase(Locale.getDefault()));
        button6.setText(dizi2.get(5).toString().toUpperCase(Locale.getDefault()));
        button7.setText(dizi2.get(6).toString().toUpperCase(Locale.getDefault()));
    }
}

