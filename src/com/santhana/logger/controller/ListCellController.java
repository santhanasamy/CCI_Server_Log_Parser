package com.santhana.logger.controller;

import com.santhana.logger.model.*;
import com.santhana.logger.parser.ParseConstants;
import com.santhana.logger.util.FileUtils;
import com.santhana.logger.util.ImageUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

import static com.santhana.logger.parser.ParseConstants.*;

public class ListCellController {

    @FXML
    private HBox mColumn1;
    @FXML
    private ImageView mColumn1LeftImg;
    @FXML
    private Label mColumn1Txt;
    @FXML
    private ImageView mColumn1MsgImg;
    @FXML
    private ImageView mColumn1RightImg;

    @FXML
    private HBox mColumn2;
    @FXML
    private ImageView mColumn2LeftImg;
    @FXML
    private Label mColumn2Txt;
    @FXML
    private ImageView mColumn2MsgImg;
    @FXML
    private ImageView mColumn2RightImg;

    @FXML
    private HBox mColumn3;
    @FXML
    private ImageView mColumn3LeftImg;
    @FXML
    private Label mColumn3Txt;
    @FXML
    private ImageView mColumn3MsgImg;
    @FXML
    private ImageView mColumn3RightImg;

    @FXML
    private GridPane rootContainerView;


    public ListCellController() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(FileUtils.getLayoutPath("command_cell.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(Message aCommand) {

        FlowType lCommandFlowType = aCommand.getFlowType();
        if (null == lCommandFlowType) {
            return;
        }
        mColumn1LeftImg.setImage(null);
        mColumn2LeftImg.setImage(null);
        mColumn3LeftImg.setImage(null);

        mColumn1RightImg.setImage(null);
        mColumn2RightImg.setImage(null);
        mColumn3RightImg.setImage(null);

        mColumn1MsgImg.setImage(null);
        mColumn2MsgImg.setImage(null);
        mColumn3MsgImg.setImage(null);

        mColumn1Txt.setText(null);
        mColumn2Txt.setText(null);
        mColumn3Txt.setText(null);

        String lText = "";
        if (Others.NOTIFICATION.equals(aCommand.getType())
                && Others.MSG_ID_NOTIFY_EXCEPTION.equals(aCommand.getMessage_id())) {
            lText = aCommand.getMessage_id() + "\n";

            if (aCommand instanceof Command) {
                lText += ((Command) aCommand).getPayload().getDetails();
            } else if (aCommand instanceof Command1) {
                lText += ((Command1) aCommand).getPayloads().get(0).getDetails();
            } else if (aCommand instanceof Command2) {
                lText += ((Command2) aCommand).getPayloads().get(0).getDetails();
            } else if (aCommand instanceof Command3) {
                lText += ((Command3) aCommand).getPayload().getDetails();
            } else if (aCommand instanceof Command4) {
                lText += ((Command4) aCommand).getPayload().getDetails();
            }
        } else {
            lText = aCommand.getMessage_id();
        }

        if (FlowType.FROM_DASH_TO_CCI == lCommandFlowType) {
            mColumn1LeftImg.setImage(null);
            mColumn1Txt.setText(lText);
            mColumn1MsgImg.setImage(ImageUtils.getImageForMsgType(aCommand.getMessage_id()));
            mColumn1RightImg.setImage(ImageUtils.FORWARD_IMAGE);
        } else if (FlowType.FROM_CCI_TO_DASH == lCommandFlowType) {
            mColumn1LeftImg.setImage(ImageUtils.BACKWARD_IMAGE);
            mColumn1Txt.setText(lText);
            mColumn1MsgImg.setImage(ImageUtils.getImageForMsgType(aCommand.getMessage_id()));
            mColumn1RightImg.setImage(null);
        } else if (FlowType.FROM_CCI_TO_GAME == lCommandFlowType) {
            mColumn2LeftImg.setImage(null);
            mColumn2Txt.setText(lText);
            mColumn2MsgImg.setImage(ImageUtils.getImageForMsgType(aCommand.getMessage_id()));
            mColumn2RightImg.setImage(ImageUtils.FORWARD_IMAGE);
        } else if (FlowType.FROM_GAME_TO_CCI == lCommandFlowType) {
            mColumn3LeftImg.setImage(ImageUtils.BACKWARD_IMAGE);
            mColumn3Txt.setText(lText);
            mColumn3MsgImg.setImage(ImageUtils.getImageForMsgType(aCommand.getMessage_id()));
            mColumn3RightImg.setImage(null);
        } else if (FlowType.FROM_GAME_TO_DASH == lCommandFlowType) {
            mColumn3LeftImg.setImage(ImageUtils.BACKWARD_IMAGE_TO_DASH_IMAGE);
            mColumn3Txt.setText(aCommand.getMessage_id());
            mColumn3MsgImg.setImage(ImageUtils.getImageForMsgType(aCommand.getMessage_id()));
            mColumn3RightImg.setImage(null);
        }


    }


    public Node getRoot() {
        return rootContainerView;
    }

}
