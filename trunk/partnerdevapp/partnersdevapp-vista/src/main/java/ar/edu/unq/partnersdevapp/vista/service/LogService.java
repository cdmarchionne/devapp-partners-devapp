package ar.edu.unq.partnersdevapp.vista.service;

import org.apache.log4j.Logger;

/**
 * XXX, los servicios deben ir en otro proyecto, no en el de presentacion
 */
public class LogService {

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