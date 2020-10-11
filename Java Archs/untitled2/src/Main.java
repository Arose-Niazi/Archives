
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField name;
    private PasswordField pw;
    private Stage mainLoginStage;
    private Scene loginScene;
    private Pane layoutPane;
    private Button loginButton;
    private Button SignUPButton;

    private MySQLConnection connection;

    @Override
    public void start(Stage primaryStage){

        connection = new MySQLConnection(); //This will store the MySQL Connection.



        name = new TextField();
        name.setPromptText("NAME");

        pw = new PasswordField();
        pw.setPromptText("PASSWORD");

        loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainLoginStage);

                if(connection.checkUser(name.getText()))
                {
                    if(connection.getUser(name.getText(),new String(pw.getText())))
                    {
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("Welcome back");
                        alert.setHeaderText("Logged In!");
                        alert.setContentText("Correct Password and Username!");
                    }
                    else
                    {
                        alert.setTitle("Who are you?");
                        alert.setHeaderText("Log in failed");
                        alert.setContentText("Incorrect Password");
                    }
                }
                else
                {
                    alert.setTitle("Who are you?");
                    alert.setHeaderText("Log in failed");
                    alert.setContentText("Incorrect Username");
                }
                alert.showAndWait();
            }
        });


        SignUPButton = new Button("Sign Up");
        SignUPButton.setOnAction(event -> new SignUpPage(this));

        layoutPane = new Pane();
        layoutPane.getChildren().addAll(loginButton, SignUPButton,name,pw);
        loginScene = new Scene(layoutPane,250,250);

        name.setLayoutX(50);
        pw.setLayoutX(50);
        pw.setLayoutY(40);
        loginButton.setLayoutY(80);
        loginButton.setLayoutX(100);
        SignUPButton.setLayoutX(95);
        SignUPButton.setLayoutY(120);

        mainLoginStage = primaryStage;
        mainLoginStage.setScene(loginScene);
        mainLoginStage.setTitle("Login");
        mainLoginStage.show();

        notifiction("Arose",connection.getEmail("Hammad"));
    }

    private void notifiction(String username, String email) {
        Label label=new Label(String.format("Username: %s\nEmail: %s",username,email));
        Button ok=new Button("OK");
        VBox layout2=new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label,ok);
        Stage notifictionStage=new Stage();
        notifictionStage.initOwner(mainLoginStage);
        ok.setOnAction(event -> {  notifictionStage.close(); });
        Scene scene =new Scene(layout2,250,75);
        notifictionStage.setScene(scene);
        notifictionStage.showAndWait();
    }

    public Stage getMainLoginStage() {
        return mainLoginStage;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public MySQLConnection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
