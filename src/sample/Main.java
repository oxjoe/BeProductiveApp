import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Stage secondryStage = primaryStage;
    primaryStage.setTitle("Be Productive");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Text scenetitle = new Text("Are you procrastinating?");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 5, 1);

    Button btn = new Button("Submit");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.CENTER);
    hbBtn.getChildren().add(btn);
    grid.add(hbBtn, 2, 2);

    TextField textField = new TextField("Yes or No?");
    grid.add(textField, 2, 1);

    //    Label userName = new Label("Press Enter");
//    grid.add(userName, 0, 1);
//    Label settings = new Label("Settings");
//    grid.add(settings, 0, 0);

    btn.setOnAction(action -> {
      final String userInput = textField.getText();
      if (userInput.compareToIgnoreCase("yes") == 0) {
        notGettingStuffDone(secondryStage);
      } else if (userInput.compareToIgnoreCase("no") == 0) {
        //        gettingStuffDone();
      } else {
        // Only (Yes/No) is accepted!
      }
    });

    textField.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER) {
        final String userInput = textField.getText();
        if (userInput.compareToIgnoreCase("yes") == 0) {
          notGettingStuffDone(secondryStage);
        } else if (userInput.compareToIgnoreCase("no") == 0) {
          //        gettingStuffDone();
        } else {
          // Only (Yes/No) is accepted!
        }
      }
    });

    grid.setGridLinesVisible(true);
    Scene scene = new Scene(grid, 300, 275);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void notGettingStuffDone(Stage secondaryStage) {
    //secondaryStage.setTitle("Be Productive");
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Text scenetitle = new Text("That's okay, take a deep breath and count to 3");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
    grid.add(scenetitle, 0, 0, 4, 1);
    FadeTransition ft1 = new FadeTransition(Duration.millis(5000), scenetitle);
    ft1.setFromValue(1.0);
    ft1.setToValue(0.1);
    ft1.setCycleCount(Timeline.INDEFINITE);
    //ft.setAutoReverse(true);
    ft1.play();

    System.out.println("notGettingStuffDone");

    //grid.setGridLinesVisible(true);

    Scene scene = new Scene(grid, 300, 275);
    secondaryStage.setScene(scene);
    secondaryStage.show();

  }

}
