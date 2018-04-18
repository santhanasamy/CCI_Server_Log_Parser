package com.santhana.logger.model;

public abstract class Message {

    private String timestamp;

    private FlowType mFlowType;

    private String id;

    private String message_id;

    private String type;

    private String requestor_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestor_id() {
        return requestor_id;
    }

    public void setRequestor_id(String requestor_id) {
        this.requestor_id = requestor_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setFlowType(FlowType type) {
        this.mFlowType = type;
    }

    public FlowType getFlowType() {
        return mFlowType;
    }

}
