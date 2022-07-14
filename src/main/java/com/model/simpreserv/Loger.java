package com.model.simpreserv;


import org.apache.log4j.Logger;

public class Loger {
    private static Logger LogJava = Logger.getLogger(Loger.class);

    public static void createLogger() {
        LogJava.debug("LOG DEBUG");
        LogJava.info("LOG INFO");
        LogJava.warn("LOG WARNING");
        LogJava.error("LOG ERROR");
        LogJava.fatal("LOG FATAL");



    }
}
