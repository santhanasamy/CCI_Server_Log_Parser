package com.santhana.logger.factory;

import com.santhana.logger.controller.ListCellController;
import com.santhana.logger.model.Command;
import com.santhana.logger.model.Message;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class CommandCell extends ListCell<Message> {

    private final ListCellController lController = new ListCellController();
    private final Node view = lController.getRoot();

    @Override
    protected void updateItem(Message aItem, boolean empty) {
        super.updateItem(aItem, empty);

        if (empty) {
            setGraphic(null);
        } else {
            lController.setInfo(aItem);
            setGraphic(view);
        }
    }
}
