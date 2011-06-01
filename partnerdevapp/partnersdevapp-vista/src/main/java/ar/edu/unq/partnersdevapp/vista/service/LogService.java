package ar.edu.unq.partnersdevapp.vista.service;

import org.apache.log4j.Logger;

public class LogService {

    protected static final Logger LOG = Logger.getLogger(LogService.class);

    public LogService() {
        if (true) {
            LOG.info("se crea");
        }

    }

    public void log(final String msg) {
        LOG.info(msg);
    }

    public void test() {
        LOG.info("test");
    }

}
