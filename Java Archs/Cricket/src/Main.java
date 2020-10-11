import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {
    Simulate simulate=new Simulate();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cricket Simulator");
        primaryStage.show();
        setSimulate(primaryStage);
    }
    public void setSimulate(Stage stage) throws InterruptedException {
        //for (int a=0;a<6;a++){
          //  try{
                simulate.starts(stage);
           // }catch (Exception e){
             //   a--;
           // }

        //    java.util.concurrent.TimeUnit.SECONDS.sleep(10);
     //   }
    }


    public static void main(String[] args) {
        launch(args);
    }
}



