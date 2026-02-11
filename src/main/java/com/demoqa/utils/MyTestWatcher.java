package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTestWatcher implements TestWatcher {

Logger logger = LoggerFactory.getLogger(MyTestWatcher.class);

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("The method {} is PASSED",context
                .getTestMethod().toString());
        logger.info("{}",context.getDisplayName());
        logger.info("**************************************************");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error("The method !!!{}!!! is FAILED",context.getTestMethod());
        logger.error("{}",context.getDisplayName());
       // logger.error("{}",context.getDisplayName());
        logger.error("{}",cause.getMessage());
        logger.info("**************************************************");
    }
}
