package com.santhana.logger.controller;

import com.santhana.logger.factory.ListCellFactory;
import com.santhana.logger.model.Command;
import com.santhana.logger.model.Message;
import com.santhana.logger.parser.LogParser;
import com.santhana.logger.util.AppConstants;
import com.santhana.logger.util.FileUtils;
import com.santhana.logger.util.Log;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HomeController implements Initializable {

    private static final String TAG = HomeController.class.getSimpleName();
    @FXML
    private Button mClearButton;

    @FXML
    private Button mBtnBrowse;

    @FXML
    private Button mBtnParse;

    @FXML
    private ListView mListView;

    @FXML
    private TextField mFilePathTxtView;

    private Stage mStage;

    private File mSelectedFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Log.printDLog(TAG, "Initializing HomeController");
    }

    public void clearUI() {
        mListView.setItems(null);
        mFilePathTxtView.clear();
        mBtnParse.setDisable(true);
    }

    public void showFileBrowser() {

        if (null == mStage) {
            mStage = (Stage) mListView.getScene().getWindow();
        }
        FileUtils.showFileChooser(mStage, new FileUtils.FileSelectListener() {

            @Override
            public void onFileSelected(File aSelectedFile) {

                if (null != aSelectedFile && aSelectedFile.exists()) {
                    mFilePathTxtView.setText(aSelectedFile.getAbsolutePath());
                    mBtnParse.setDisable(false);
                    mSelectedFile = aSelectedFile;
                } else {
                    mBtnParse.setDisable(true);
                    mSelectedFile = null;
                }
            }
        });
    }

    public void showDateTime(ActionEvent event) {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

        // Model Data
        String dateTimeString = df.format(now);
        // Show in VIEW
        //mDateTxtView.setText(dateTimeString);
    }

    public void parseLogFile(ActionEvent actionEvent) {

        Log.printILog(TAG, "Parsing Log file ", mSelectedFile.toString());

        configureListView(LogParser.getInstance().parse(mSelectedFile));
    }

    private void configureListView(Map<Long, Message> aDataMap) {

        mListView.setOrientation(Orientation.VERTICAL);
        mListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        ObservableList<Message> lCommandList = FXCollections.observableArrayList(aDataMap.values());
        mListView.setItems(lCommandList);
        mListView.setCellFactory(new ListCellFactory());

        // Create a ListView
        mListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Command>() {
            @Override
            public void changed(ObservableValue<? extends Command> observable, Command oldValue, Command newValue) {
                mFilePathTxtView.setText("OLD: " + oldValue.getMessage_id() + ",  NEW: " + newValue.getMessage_id());
            }
        });

    }

}
