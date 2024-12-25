package com.example.streamingdata;

import java.util.Map;

public class Stream {
    private final String streamId;
    private final String source;
    private final String destination;
    private Map<String, String> parameters;

    public Stream(String streamId, String source, String destination, Map<String, String> parameters) {
        this.streamId = streamId;
        this.source = source;
        this.destination = destination;
        this.parameters = parameters;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
