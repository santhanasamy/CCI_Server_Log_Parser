package com.santhana.logger.util;

import com.santhana.logger.res.Strings;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtils {

    public interface FileSelectListener {
        void onFileSelected(File aSelectedFile);
    }

    public static void showFileChooser(Stage stage, FileSelectListener aListener) {
        final FileChooser lFileChooser = new FileChooser();
        lFileChooser.setTitle(Strings.FILE_CHOOSER_TITLE);
        lFileChooser.getExtensionFilters().addAll(
                //new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Logs", "*.log")
        );
        aListener.onFileSelected(lFileChooser.showOpenDialog(stage));
    }

    public static final URL getLayoutPath(String aFileName) throws MalformedURLException {

        return new File(AppConstants.UI_DIR_NAME + "/" + aFileName).toURI().toURL();
    }
}
