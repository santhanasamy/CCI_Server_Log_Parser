package com.santhana.logger.model;

import java.util.List;

public class Command1 extends Message {

    private List<Payload> payload;

    public List<Payload> getPayloads() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }
}

