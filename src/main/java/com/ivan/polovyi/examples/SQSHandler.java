package com.ivan.polovyi.examples;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;


public class SQSHandler implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(SQSEvent sqsEvent, Context context) {
        context.getLogger().log("\nFunction started. Processing " + sqsEvent.getRecords().size() + " messages\n");

        sqsEvent.getRecords().forEach(message -> {
            context.getLogger().log("Message id " + message.getMessageId() + "\n");
            context.getLogger().log("Message body " + message.getBody()+ "\n");
            context.getLogger().log("Pipeline!!! AFTER COMMIT #2");

        });
        return null;
    }
}
