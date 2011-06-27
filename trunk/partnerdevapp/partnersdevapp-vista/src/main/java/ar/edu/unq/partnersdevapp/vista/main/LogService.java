package ar.edu.unq.partnersdevapp.vista.main;

import org.apache.log4j.Logger;

/**
 ** YYY-llevarlo al proyecto de servicios. Problema de dependencias
 */
public class LogService {

    // protected static final Logger LOG = Logger.getLogger(LogService.class);
    protected static final Logger LOG = Logger.getLogger(LogService.class);

    public LogService() {
        // if (true) {
        LOG.info("se crea");
        // }

    }

    public void test() {
        LOG.info("test");
    }

    public static Logger getLog() {
        return LOG;
    }
}
