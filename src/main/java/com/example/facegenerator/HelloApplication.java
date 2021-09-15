package com.example.facegenerator;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static javafx.scene.paint.Color.*;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();
    static int mouthNum;
    static int noseNum;
    static int eyesNum;
    static Color faceColor;



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();
        Scanner scanner = new Scanner(System.in);
        int ColorNum = scanner.nextInt();
                stage.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            gc.clearRect(0, 0, width, height);
            Random rand = new Random();
            int randMouthNum = rand.nextInt(5-1)+1;
            int randNoseNum = rand.nextInt(3-1)+1;
            int randEyesNum = rand.nextInt(3-1)+1;

            mouthNum = randMouthNum;
            noseNum = randNoseNum;
            eyesNum = randEyesNum;

            if (ColorNum==1) {
                faceColor=ORANGE;
            } else if (ColorNum==2) {
                faceColor=BLUE;
            } else if (ColorNum==3) {
                faceColor=YELLOWGREEN;
            }
            drawPrimitiveFace();
        }));
        timeline.setCycleCount(360);
        timeline.play();
    }

    public static void drawPrimitiveFace() {
        drawShape();
        //draw mouth
        switch (mouthNum) {
            case 1:
                drawMouth1();
                break;
            case 2:
                drawMouth2();
                break;
            case 3:
                drawMouth3();
                break;
            case 4:
                drawMouth4();
                break;
            default:
                break;
        }
        drawEyeShape1();
        //drawBeard();

        switch (eyesNum){
            case 1:
                drawEyes1();
                break;
            case 2:
                drawEyes2();
                break;
            default :
                break;
        }
        switch (noseNum) {
            case 1:
                drawNose1();
                break;
            case 2:
                drawNose2();
                break;
            default:
                break;
        }


    }

    public static void drawShape() {

        gc.setFill(faceColor);
        gc.fillOval(150, 150, 300, 300);
        gc.setStroke(BLACK);
        gc.strokeOval(150,150,300,300);
    }


    public static void drawMouth1() {
        gc.setFill(WHITE);
        gc.setStroke(BLACK);
        gc.fillArc(200,300,200,120,0,-180,ArcType.ROUND);
        gc.strokeArc(200,300,200,120,0, -180, ArcType.ROUND);
    }
    public static void drawMouth2() {
        gc.setFill(WHITE);
        gc.setStroke(BLACK);
        gc.fillArc(250,300,100,120,0,-180,ArcType.ROUND);
        gc.strokeArc(250,300,100,120,0, -180, ArcType.ROUND);
    }
    public static void drawMouth3() {
        gc.setFill(WHITE);
        gc.setStroke(BLACK);
        gc.fillArc(225,350,150,120,0,180,ArcType.ROUND);
        gc.strokeArc(225,350,150,120,0, 180, ArcType.ROUND);
    }
    public static void drawMouth4() {
        gc.setFill(WHITE);
        gc.setStroke(BLACK);
        gc.fillArc(250,350,100,120,0,180,ArcType.ROUND);
        gc.strokeArc(250,350,100,120,0, 180, ArcType.ROUND);
    }
/*
   public static void drawBeard() {
        gc.setFill(DARKGREY);
        gc.setStroke(BLACK);
        gc.fillArc(220,340,160,100,0,180,ArcType.ROUND);
        gc.strokeArc(220,340,160,100,0, 180, ArcType.ROUND);
        gc.fillRect(280,420,40,50);
        gc.strokeRect(280,420,40,50);
    }
*/
    public static void drawEyeShape1() {
        gc.setStroke(BLACK);
        gc.setFill(WHITE);
        gc.fillOval(200,210,80,100);
        gc.fillOval(320,210,80,100);
        gc.strokeOval(200,210,80,100);
        gc.strokeOval(320,210,80,100);
    }

    public static void drawEyes1() {
        gc.setFill(BLUE);
        gc.setStroke(BLACK);
        gc.fillOval(230,230,50,70);
        gc.fillOval(350,230,50,70);
        gc.strokeOval(230,230,50,70);
        gc.strokeOval(350,230,50,70);
        gc.setFill(BLACK);
        gc.fillOval(250,250,30,40);
        gc.fillOval(370,250,30,40);
        gc.setFill(WHITESMOKE);
        gc.fillOval(260,255,8,8);
        gc.fillOval(380,255,8,8);

    }
    public static void drawEyes2() {
        gc.setFill(BLUE);
        gc.setStroke(BLACK);
        gc.fillOval(230,230,50,70);
        gc.fillOval(320,230,50,70);
        gc.strokeOval(230,230,50,70);
        gc.strokeOval(320,230,50,70);
        gc.setFill(BLACK);
        gc.fillOval(250,250,30,40);
        gc.fillOval(320,250,30,40);
        gc.setFill(WHITESMOKE);
        gc.fillOval(260,255,8,8);
        gc.fillOval(330,255,8,8);

    }

    public static void drawNose1() {
        gc.setStroke(BLACK);
        gc.setFill(faceColor);
        gc.fillOval(240,280,120,90);
        gc.strokeOval(240,280,120,90);
    }
    public static void drawNose2() {
        gc.setStroke(BLACK);
        gc.setFill(faceColor);
        gc.strokeOval(255,315,90,50);
        gc.strokeOval(275,265,50,90);
        gc.fillOval(275,265,50,90);
        gc.fillOval(255,315,90,50);

    }


    public static void main(String[] args) {
        System.out.println("What color would you like your face to have? \n Type in number: \n1=Orange \n2=Blue \n3=Green");



        launch();
    }
}