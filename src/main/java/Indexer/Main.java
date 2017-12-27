package Indexer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String... args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        GUI gui = new GUI();

        root.getChildren().add(gui.getGUI());

        scene.setFill(Color.grayRgb(240));
        primaryStage.setTitle("FX indexer");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            final int fieldWidth = 265;
            gui.addFieldCol(newSceneWidth.intValue()/fieldWidth);
            gui.removeFieldCol(newSceneWidth.intValue()/fieldWidth);
            int colCount = (newSceneWidth.intValue())/fieldWidth;
            colCount=(colCount==0)?(1):(colCount);
            gui.changeWidth((newSceneWidth.doubleValue())/(colCount)-30);

//            double colSpacing = (rowCount>1)?((newSceneWidth.intValue()%fieldWidth)/(rowCount-1)):(1);
//            gui.colSpace(colSpacing);
        });

        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            final int fieldWidth = 385;
            gui.addFieldRow(newSceneHeight.intValue()/fieldWidth);
            gui.removeFieldRow(newSceneHeight.intValue()/fieldWidth);

            int rowCount = newSceneHeight.intValue()/fieldWidth;
            rowCount=(rowCount==0)?(1):(rowCount);
            gui.changeHeight((newSceneHeight.doubleValue())/(rowCount)-30);
        });
    }
}
