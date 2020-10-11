
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpPage {
    private Label nameL,emailL,passL,ageL,passingL,degreeL;
    private TextField name;
    private TextField email;
    private PasswordField pass;
    private ComboBox<Integer> age;
    private ComboBox<Integer> passing;
    private ListView<String> degree;
    private Button create,back;
    private GridPane layout;
    private Stage registerationStage;

    public SignUpPage(Main main){

        main.getMainLoginStage().hide();

        name=new TextField();
        email=new TextField();
        pass=new PasswordField();

        age=new ComboBox<>();
        age.getItems().addAll(18,19,20,21,22,23,24,25,26,27,28,29,30);

        passing=new ComboBox<>();
        passing.getItems().addAll(2019,2020,2021,2022,2023);

        degree =new ListView<>();
        degree.getItems().addAll("BSE","BEE","BCS","BBA","CHE","BAF","BAR","BDE","BCE","BET");
        degree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        nameL=new Label("Name:");
        emailL=new Label("Email:");
        passL=new Label("Password");
        ageL=new Label("age");
        passingL=new Label("Passing Year");
        degreeL=new Label("Degree");

        create=new Button("Create");
        back=new Button("Back");

        layout=new GridPane();
        layout.setPadding(new Insets(10,10,10,10));
        layout.setVgap(10);
        layout.setHgap(10);

        layout.setConstraints(nameL,0,0);
        layout.setConstraints(name,1,0);
        layout.setConstraints(emailL,0,1);
        layout.setConstraints(email,1,1);
        layout.setConstraints(passL,0,2);
        layout.setConstraints(pass,1,2);
        layout.setConstraints(ageL,0,3);
        layout.setConstraints(age,1,3);
        layout.setConstraints(passingL,0,4);
        layout.setConstraints(passing,1,4);
        layout.setConstraints(degreeL,0,5);
        layout.setConstraints(degree,1,5);
        layout.setConstraints(create,0,6);
        layout.setConstraints(back,2,6);

        layout.getChildren().addAll(nameL,name,emailL,email,passL,pass,ageL,age,passingL,passing,degreeL,degree,create,back);

        back.setOnAction(event -> {
            registerationStage.hide();
            main.getMainLoginStage().show();
        });

        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(main.getConnection().signUp(name.getText(),email.getText(),pass.getText(),age.getValue(),passing.getValue(),degree.getSelectionModel().getSelectedItem()))
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(registerationStage);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registered");
                    alert.setHeaderText("User registered");
                    alert.setContentText("You may login now");
                    alert.showAndWait();
                }
            }
        });
        registerationStage = new Stage();
        registerationStage.setScene(new Scene(layout,500,400));
        registerationStage.show();
        notifiction();
    }

    private void notifiction() {
        Label label=new Label("Fill the form to create new profile");
        Button ok=new Button("OK");
        VBox layout2=new VBox();
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label,ok);
        Stage notifictionStage=new Stage();
        notifictionStage.initOwner(registerationStage);
        ok.setOnAction(event -> {  notifictionStage.close(); });
        Scene scene =new Scene(layout2,250,75);
        notifictionStage.setScene(scene);
        notifictionStage.showAndWait();
    }
}
