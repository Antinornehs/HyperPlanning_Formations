package fr.univtln.mgajovski482.HyperPlanning;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * <b>FormationMain est la classe principale (singleton) du package Formations.</b>
 *
 * <p>
 *     Cette classe contient un logger qui nous informe si le package a bien ete initialise
 *
 *  @author Maxime
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
