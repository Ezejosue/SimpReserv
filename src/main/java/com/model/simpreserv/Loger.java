package com.model.simpreserv;


import org.apache.log4j.Logger;


public class Loger {
    private static Logger LogJava = Logger.getLogger(Loger.class);

    public void createLogger() {

        LogJava.debug("LOG DEBUG");
        LogJava.info("LOG INFO");
        LogJava.warn("LOG WARNING");
        LogJava.error("LOG ERROR");
        LogJava.fatal("LOG FATAL");



    }

    public void debug(String debug){
        LogJava.debug(debug);
    }

    public void info(String info){
        LogJava.info(info);
    }

    public void warn(String warn){
        LogJava.warn(warn);
    }

    public void error(String error){
        LogJava.error(error);
    }

    public void fatal(String fatal){
        LogJava.fatal(fatal);
    }


}
