package fr.univtln.mgajovski482.HyperPlanning;

import java.io.File;

/**
 * <b>Consts est une classe contenant toutes les constantes propres à son package</b>
 * <p>
 * Il contient notamment des constantes liees aux:
 * <ul>
 *     <li>Jsons de formations</li>
 *     <li>Autres...</li>
 *</ul>
 *
 * @author Maxime
 */
public class Consts {

    public final static String  RESOURCES_PATH
            = System.getProperty("user.dir") + File.separator + "resources" + File.separator;


    public final static String JSON_FILE_NAME
            = "Formations.json";

    public final static String JSON_PATH
            = RESOURCES_PATH + JSON_FILE_NAME;

}
