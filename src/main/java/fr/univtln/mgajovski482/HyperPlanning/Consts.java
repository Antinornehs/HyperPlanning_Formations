package fr.univtln.mgajovski482.HyperPlanning;

import java.io.File;

/**
 * Created by Maxime on 20/10/2015.
 */
public class Consts {

    public final static String  RESOURCES_PATH
            = System.getProperty("user.dir") + File.separator + "resources" + File.separator;


    public final static String JSON_FILE_NAME
            = "Formations.json";

    public final static String JSON_PATH
            = RESOURCES_PATH + JSON_FILE_NAME;
}
