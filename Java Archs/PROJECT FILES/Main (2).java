package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Random;


public class Main extends Application {
   // KeyEvent event =new KeyEvent;
    Label score=new Label("Score");
    TextField scoreText=new TextField();
    int added=0;
    int[] emptyR=new int[16];
    int[] emptyC=new int[16];
    Stage window;
    TextField[][] text = new TextField[4][4];
    TextField text2 = new TextField();
    Button right=new Button("▶");
    Button reset=new Button("⟲");
    Button left=new Button("◀︎");
    Button up=new Button("▲");
    Button down =new Button("▼");

    @Override
    public void start(Stage primaryStage) throws Exception {
        scoreText.editableProperty().set(false);
        scoreText.setMaxSize(100,50);
        scoreText.setMinSize(100,50);
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                text[a][b] = new TextField();
                text[a][b].editableProperty().set(false);
                text[a][b].setMinSize(100, 100);
                text[a][b].setMaxSize(100, 100);
                text[a][b].setAlignment(Pos.CENTER);

            }
        }
        //Inner layout
        GridPane inner = new GridPane();
        inner.setPadding(new Insets(5,5,5,5));
        GridPane.setConstraints(text[0][0], 0, 0);
        GridPane.setConstraints(text[0][1], 1, 0);
        GridPane.setConstraints(text[0][2], 2, 0);
        GridPane.setConstraints(text[0][3], 3, 0);
        GridPane.setConstraints(text[1][0], 0, 1);
        GridPane.setConstraints(text[1][1], 1, 1);
        GridPane.setConstraints(text[1][2], 2, 1);
        GridPane.setConstraints(text[1][3], 3, 1);
        GridPane.setConstraints(text[2][0], 0, 2);
        GridPane.setConstraints(text[2][1], 1, 2);
        GridPane.setConstraints(text[2][2], 2, 2);
        GridPane.setConstraints(text[2][3], 3, 2);
        GridPane.setConstraints(text[3][0], 0, 3);
        GridPane.setConstraints(text[3][1], 1, 3);
        GridPane.setConstraints(text[3][2], 2, 3);
        GridPane.setConstraints(text[3][3], 3, 3);
        inner.getChildren().addAll(text[0][0], text[0][1], text[0][2], text[0][3], text[1][0], text[1][1], text[1][2], text[1][3],
                text[2][0], text[2][1], text[2][2], text[2][3], text[3][0], text[3][1], text[3][2], text[3][3]);
        inner.setVgap(5);
        inner.setHgap(5);


        //Set Bottom layout
        HBox lower=new HBox();
        lower.getChildren().addAll(left,right,up,down);
        lower.setAlignment(Pos.CENTER);



        //Upper layout
        HBox upper=new HBox();
        upper.getChildren().addAll(score,scoreText,reset);
        upper.setAlignment(Pos.CENTER);
        //reset.setMinSize(40,40);
        //reset.setMaxSize(40,40);
        reset.setStyle("-fx-font-size: 20");


        //Outer layout
        BorderPane outer = new BorderPane();
        outer.setCenter(inner);
        outer.setTop(upper);
        outer.setBottom(lower);



        //Function Calling
        Starting();
        outer.requestFocus();
        right.setOnAction(event -> {
            sortHorizontally(3,0,-1);
            addHorizontally(3,0,-1);
            add();
            colorCheck();
            outer.requestFocus();
        });
        left.setOnAction(event -> {
            sortHorizontally(0,3,1);
            addHorizontally(0,3,1);
            add();
            colorCheck();
            outer.requestFocus();
        });
        up.setOnAction(event -> {
            sortUpAndDown(0,3,1);
            addVertically(0,3,1);
            add();
            colorCheck();
            outer.requestFocus();
            //sortVertically(0,3,1);
        });
        down.setOnAction(event -> {
            sortUpAndDown(3,0,-1);
            addVertically(3,0,-1);
            add();
            colorCheck();
            outer.requestFocus();
        });
        reset.setOnAction(event -> resetText());
        //Just chechking









        //Basic
        window = primaryStage;
        Scene scene = new Scene(outer);
        window.setScene(scene);


        outer.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case RIGHT:sortHorizontally(3,0,-1);
                    addHorizontally(3,0,-1);
                    add();
                    colorCheck();
                    break;
                case UP:sortUpAndDown(0,3,1);
                    addVertically(0,3,1);
                    add();
                    colorCheck();
                    break;
                case LEFT:sortHorizontally(0,3,1);
                    addHorizontally(0,3,1);
                    add();
                    colorCheck();
                    break;
                case DOWN:sortUpAndDown(3,0,-1);
                    addVertically(3,0,-1);
                    add();
                    colorCheck();
            }
            outer.requestFocus();
        });

        window.show();
        outer.requestFocus();


    }


    //Returns either 2 or 4 in String format
    String getRandom() {
        Random random = new Random();
        int a;
        a = random.nextInt();
        if (a % 2 == 0) {
            return "2";
        } else return "4";
        //return Integer.toString(a);
    }


    //Used to intialize first two random cells for the starting of game
    void Starting() {
        scoreText.setText("0");
        Random random = new Random();
        int a = random.nextInt(4);
        int b = random.nextInt(4);
        text[a][b].setText(getRandom());

        a = random.nextInt(4);
        b = random.nextInt(4);
        text[a][b].setText(getRandom());
        colorCheck();



    }


    //When right key is pressed
    void right() {
        //add();
        //sort();
    }


    //Sorts to right
    void sortHorizontally(int ColumnStart,int Columnend,int addingFactor){
        for(int row=0;row<=3;row++) {
            for (int y = 0; y <= 3; y++) {
                for (int column = ColumnStart; column !=Columnend; column=column+addingFactor){
                    if (text[row][column].getText().isEmpty()) {
                        text[row][column].setText(text[row][column + addingFactor].getText());
                        text[row][column + addingFactor].clear();}
                    }
            }
        }
    }

 /*   void sortVertically(int RowStart,int RowEnd,int addingFactor){
        for(int column=0;column<=3;column++) {
            for (int y = 0; y <= 3; y++) {
                for (int row = RowStart; row !=RowEnd; row=column+addingFactor){
                    if (text[row][column].getText().isEmpty()) {
                        text[row][column].setText(text[row + addingFactor][column].getText());
                        text[row + addingFactor][column].clear();}
                }
            }
        }
    }*/
 void sortUpAndDown(int rowStart,int rowEnd,int addingFactor){
     for (int column=0;column<=3;column++){
         for (int y=0;y<=3;y++){
             for (int row=rowStart;row!=rowEnd;row=row+addingFactor){
                 if(text[row][column].getText().isEmpty()){
                     text[row][column].setText(text[row+addingFactor][column].getText());
                     text[row+addingFactor][column].clear();
                 }
             }
         }
     }
 }

    void add(){
        //addHorizontally();
        check();
        if(added==0){
            text[emptyR[0]][emptyC[0]].setText(getRandom());
        }
        scoreText.setText(Integer.toString(Integer.parseInt(scoreText.getText())+(added*10)));
        added=0;
    }


    void check(){
        int x=0;
        for(int column=0;column<=3;column++){
            for(int row=0;row<=3;row++){
                if(text[row][column].getText().isEmpty()){
                    emptyR[x]=row;
                    emptyC[x]=column;
                    x++;
                }
            }
        }
        if (x==0){
            Lost l1=new Lost("YOU LOST THE GAME");
            resetText();
        }

        for(int column=0;column<=3;column++){
            for(int row=0;row<=3;row++){
                if(text[row][column].getText().equals("2048")){
                    Lost l1=new Lost("YOU WON THE GAME");
                    resetText();
                }
            }
        }
        colorCheck();
    }

    void resetText(){
            for(int column=0;column<=3;column++){
                for(int row=0;row<=3;row++){
                    text[row][column].clear();
                }
            }
            Starting();
    }
    void addHorizontally(int columnStart,int columnEnd,int factor){
        for(int row=0;row<=3;row++) {
            for (int column = columnStart; column !=columnEnd; column=column+factor) {
                if (text[row][column].getText().equals(text[row][column +factor].getText())) {
                    if (!text[row][column +factor].getText().isEmpty()) {
                        int a = Integer.parseInt(text[row][column].getText());
                        int b = Integer.parseInt(text[row][column +factor].getText());
                        b = b + a;
                        text[row][column].setText(Integer.toString(b));
                        text[row][column +factor].clear();
                        added++;
                        sortHorizontally(columnStart,columnEnd,factor);
                    }
                }
            }
        }
    }

    void addVertically(int rowStart,int rowEnd,int factor){
        for(int column=0;column<=3;column++) {
            for (int row = rowStart; row !=rowEnd; row=row+factor) {
                if (text[row][column].getText().equals(text[row +factor][column].getText())) {
                    if (!text[row +factor][column].getText().isEmpty()) {
                        int a = Integer.parseInt(text[row][column].getText());
                        int b = Integer.parseInt(text[row +factor][column].getText());
                        b = b + a;
                        text[row][column].setText(Integer.toString(b));
                        text[row +factor][column].clear();
                        added++;
                        sortUpAndDown(rowStart,rowEnd,factor);
                    }
                }
            }
        }


    }
    void colorCheck(){
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                if(!text[a][b].getText().isEmpty()){
                int x=Integer.parseInt(text[a][b].getText());
                switch (x){
                    case 2: text[a][b].setStyle("-fx-background-color: #FFA500;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 4: text[a][b].setStyle("-fx-background-color: #006600;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 8: text[a][b].setStyle("-fx-background-color: #000099;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 16: text[a][b].setStyle("-fx-background-color: #FF007F;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 32: text[a][b].setStyle("-fx-background-color: #FFD700;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 64: text[a][b].setStyle("-fx-background-color:  #FF3333;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 128: text[a][b].setStyle("-fx-background-color: #00FFFF;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                    case 256: text[a][b].setStyle("-fx-background-color: #808080;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 22pt");break;
                    case 512: text[a][b].setStyle("-fx-background-color: #000000;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 22pt");break;
                    case 1024: text[a][b].setStyle("-fx-background-color: #F1F;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 20pt");break;
                    case 2048: text[a][b].setStyle("-fx-background-color: #FFF123;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 20pt");break;
                    default:text[a][b].setStyle("-fx-background-color: #383838;" +
                            "-fx-text-fill: #FFFFFF;" +
                            "-fx-font-size: 25pt");break;
                }


                }else{text[a][b].setStyle("-fx-background-color: #383838;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-size: 25pt"); }
            }
            }
        }

    }



    //adds numbers to right
   /*  ||
   int adding() {
        int a;
        int b;
        int c = 2;

        for (int x = c; x >= 0; x--) {
            if (!text[0][x].getText().isEmpty()) {
                a = Integer.parseInt(text[0][3].getText());
                b = Integer.parseInt(text[0][x].getText());
                text[0][3].setText(Integer.toString(a + b));
                return x;
            } else {
                if (!text[0][3 - 2].getText().isEmpty()) {
                    a = Integer.parseInt(text[0][3].getText());
                    b = Integer.parseInt(text[0][3 - 2].getText());
                    text[0][3].setText(Integer.toString(a + b));
                } else {
                    if (!text[0][3 - 3].getText().isEmpty()) {
                        a = Integer.parseInt(text[0][3].getText());
                        b = Integer.parseInt(text[0][3 - 3].getText());
                        text[0][3].setText(Integer.toString(a + b));
                    }
                }
            }
        }
    return 0;}

    void shifting(int x){
        for(int y=x+1;y>=1;y--){
            text[0][y].setText(text[0][y-1].getText());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}*/
//Step 10:Desighn grid       DONE
//Step 20:Generate random number function(2 and 4 only)     DONE
//Step 30:Initialize some boxes(only 2 random boxes)        DONE
//Step 40:Make functions{Function explaination:Sort for three times than add same numbers sort again}
//Step 45:winning check and reset function*/ DONE
//Step 47:Add Score method
//Step 50:add Buttons