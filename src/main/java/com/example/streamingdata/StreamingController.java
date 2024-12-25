package com.example.streamingdata;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/streams")
public class StreamingController {

    private final Map<String, Stream> streamStore = new ConcurrentHashMap<>();

    @PostMapping
    public Stream createStream(@RequestBody StreamRequest request) {
        String streamId = generateStreamId();
        Stream stream = new Stream(streamId, request.getSource(), request.getDestination(), request.getParameters());
        streamStore.put(streamId, stream);
        return stream;
    }

    @GetMapping("/{streamId}")
    public Stream getStream(@PathVariable String streamId) {
        return streamStore.get(streamId);
    }

    @PutMapping("/{streamId}/parameters")
    public Stream updateStream(@PathVariable String streamId, @RequestBody Map<String, String> parameters) {
        Stream stream = streamStore.get(streamId);
        if (stream != null) {
            stream.setParameters(parameters);
        }
        return stream;
    }

    @DeleteMapping("/{streamId}")
    public void deleteStream(@PathVariable String streamId) {
        streamStore.remove(streamId);
    }

    private String generateStreamId() {
        return "stream-" + System.currentTimeMillis();
    }
}
