package com.santhana.logger.model;

import java.util.List;

public class Command2 extends Message {

    private List<Payload1> payload;

    public List<Payload1> getPayloads() {
        return payload;
    }

    public void setPayload(List<Payload1> payload) {
        this.payload = payload;
    }
}

