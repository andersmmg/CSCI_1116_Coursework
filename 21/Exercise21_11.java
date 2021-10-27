import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;import java.awt.event.*;



public class Exercise21_11 extends Application {
  private Map<String, String>[] mapForBoy = new HashMap[10];
  private Map<String, String>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);
    
    btFindRanking.setOnAction(e -> findRanking());

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
    mapForBoy = getNames(1);
    mapForGirl = getNames(3);
  }
  
  public Map<String, String>[] getNames(int col) {
    Map[] newMap = new HashMap[10];
    for (int year = 2001; year <= 2010; year++) {
      Map<String, String> map = new HashMap<>();
      try {
        String urlString = "http://liveexample.pearsoncmg.com/data/babynamesranking"+ year +".txt";
        java.net.URL url = new java.net.URL(urlString);
        Scanner input = new Scanner(url.openStream());
        
        while (input.hasNext()) {
          ArrayList<String> line = new ArrayList<>();
          for (int w = 0; w < 5; w++) {
            line.add(w, input.next());
          }
          map.put(line.get(col), line.get(0));
        }
      } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
      }
      newMap[year-2001] = map;
    }
    
    return newMap;
  }
  
  public void findRanking() {
    String gender = cboGender.getValue().equals("Female") ? "Girl" : "Boy";
    int searchYear = cboYear.getValue();
    String name = tfName.getText().trim();
    String rank = gender.equals("Boy") ? mapForBoy[searchYear-2001].get(name) : mapForGirl[searchYear-2001].get(name);

    if (rank == null) {
      lblResult.setText(gender +" name "+ name +" is not found");
    }else{
      lblResult.setText(gender +" name "+ name +" is ranked #"+ rank +" in "+ searchYear);
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
