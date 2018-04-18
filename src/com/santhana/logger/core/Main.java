package com.santhana.logger.core;

import com.santhana.logger.res.Strings;
import com.santhana.logger.util.FileUtils;
import com.santhana.logger.util.ImageUtils;
import com.santhana.logger.util.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TAG = Main.class.getSimpleName();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Log.initialize();

        Log.printILog(TAG, "Starting Main Screen");
        Parent root = FXMLLoader.load(FileUtils.getLayoutPath("home_screen.fxml"));
        primaryStage.setTitle(Strings.WINDOW_TITLE);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMaximized(true);
        primaryStage.show();
        ImageUtils.initImages(getClass());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
