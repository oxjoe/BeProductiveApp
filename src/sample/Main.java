import java.util.concurrent.TimeUnit;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JTextField;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Stage secondaryStage = primaryStage;
    primaryStage.setTitle("Be Productive");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Label title = new Label("Are you being productive?");
    title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(title, 0, 0, 2,1);
    grid.setHalignment(title, HPos.CENTER);

    TextField textField = new TextField("no");
    grid.add(textField, 1, 1);

    Button btn = new Button("Submit");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.CENTER);
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 1, 2);

    //    Label userName = new Label("Press Enter");
//    grid.add(userName, 0, 1);
//    Label settings = new Label("Settings");
//    grid.add(settings, 0, 0);

    btn.setOnAction(action -> {
      final String userInput = textField.getText();
      if (userInput.compareToIgnoreCase("yes") == 0) {

      } else if (userInput.compareToIgnoreCase("no") == 0) {
        notGettingStuffDone(secondaryStage);
      } else {
        // Only (Yes/No) is accepted!
      }
    });

    textField.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER) {
        final String userInput = textField.getText();
        if (userInput.compareToIgnoreCase("yes") == 0) {

        } else if (userInput.compareToIgnoreCase("no") == 0) {
          notGettingStuffDone(secondaryStage);
        } else {
          // Only (Yes/No) is accepted!
        }
      }
    });

  //  grid.setGridLinesVisible(true);
    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void notGettingStuffDone(Stage secondaryStage) {
    Stage newStage = secondaryStage;
    //secondaryStage.setTitle("Be Productive");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Label t1 = new Label("That's okay");
    t1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t1, 0, 0, 1, 1);
    grid.setHalignment(t1, HPos.CENTER);

    Label t2 = new Label("Take a deep breath");
    t2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t2, 0, 1, 1, 1);
    grid.setHalignment(t2, HPos.CENTER);

    Label t3 = new Label("and");
    t3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t3, 0, 2, 1, 1);
    grid.setHalignment(t3, HPos.CENTER);

    Label t4 = new Label("Count to 5");
    t4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t4, 0, 3, 1, 1);
    grid.setHalignment(t4, HPos.CENTER);

    FadeTransition ft1 = new FadeTransition(Duration.millis(3000), t1);
    ft1.setFromValue(0);
    ft1.setToValue(1);
    ft1.setDuration(Duration.millis(1500));
    FadeTransition ft2 = new FadeTransition(Duration.millis(2000), t2);
    ft2.setFromValue(0);
    ft2.setToValue(1);
    ft2.setDuration(Duration.millis(1500));
    FadeTransition ft3 = new FadeTransition(Duration.millis(1500), t3);
    ft3.setFromValue(0);
    ft3.setToValue(1);
    ft3.setDuration(Duration.millis(1000));
    FadeTransition ft4 = new FadeTransition(Duration.millis(1500), t4);
    ft4.setFromValue(0);
    ft4.setToValue(1);
    ft4.setDuration(Duration.millis(1500));

    Duration one = new Duration(1000);
    SequentialTransition st = new SequentialTransition();
    st.getChildren().addAll(ft1, ft2, ft3, ft4);
    st.play();

    try {
      TimeUnit.MILLISECONDS.sleep(1500);
      grid.getChildren().removeAll(t1,t2,t3,t4);
      readyScene(newStage);
    } catch (InterruptedException e) {
    }


    // grid.setGridLinesVisible(true);

    Scene scene = new Scene(grid, 300, 275);
    secondaryStage.setScene(scene);
    secondaryStage.show();
    //
  }

  public void readyScene(Stage newStage){
    System.out.println("MADDE IT");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Label t1 = new Label("That's okay");
    t1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t1, 0, 0, 1, 1);
    grid.setHalignment(t1, HPos.CENTER);

    Label t2 = new Label("Take a deep breath");
    t2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(t2, 0, 1, 1, 1);
    grid.setHalignment(t2, HPos.CENTER);


    Scene scene = new Scene(grid, 300, 275);
    newStage.setScene(scene);
    newStage.show();
  }

}
