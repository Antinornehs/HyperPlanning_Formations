package fr.univtln.mgajovski.d12;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Maxime on 26/10/2015.
 */
public class FormationMain {

    private static Logger logger = Logger.getLogger("FormationMain.class");

    private static volatile FormationMain _instance = null;

    public FormationMain() throws IOException {

        JSonMethods.toFormation();
        logger.info("Formations Package Initialized !");
    }

    public static FormationMain getInstance() throws IOException {
        if(_instance == null) {
            synchronized (FormationMain.class) {
                if (_instance == null) {
                    _instance = new FormationMain();
                }
            }
        }
        return _instance;
    }
}
