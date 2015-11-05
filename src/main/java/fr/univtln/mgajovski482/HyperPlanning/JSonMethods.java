package fr.univtln.mgajovski482.HyperPlanning;

import com.google.gson.Gson;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.DirectorOfFormation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>JSonMethods est une classe disposant de méthodes permettant de :</b>
 *
 * <ul>
 *     <li>De recuperer des formations au format JSon pour les ajouter dans la Map
 *     correspondant aux formations</li>
 *     <li>De transformer les formations creees en JSon afin de les sauvegardees</li>
 * </ul>
 *
 *  @author Maxime
 */
public class JSonMethods {

    private static DirectorOfFormation[] directorOfFormations =
        DirectorOfFormation.staticDirectorOfFormationMap.values().toArray(new DirectorOfFormation[0]);

    private static Random random
            = new Random();

    private static Logger logger = Logger.getLogger("JSonMethods.class");

    public static void toJSon(Collection<Formation> formationCollection) throws IOException {
        Gson gson = new Gson();

        String jSonObject = gson.toJson(formationCollection);

        try{
            FileWriter writer = new FileWriter(Consts.JSON_PATH);
            writer.write(jSonObject);
            writer.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ecriture impossible !");
            throw new IOException();
        }
    }

    public static void toFormation() throws IOException {

        int randomDirectorIndex;
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(Consts.JSON_PATH));
            Formation formations[] = gson.fromJson(bufferedReader, Formation[].class);

            for(Formation currentFormation : formations){

                randomDirectorIndex = random.nextInt(directorOfFormations.length);
                currentFormation.setDirectorOfFormation(directorOfFormations[randomDirectorIndex]);
                Formation.formationMap.put(currentFormation.getId(), currentFormation);
                for(TeachingUnit currentTeachUnit : currentFormation.getTeachingUnits())
                    TeachingUnit.teachingUnitMap.put(currentTeachUnit.getCode(), currentTeachUnit);
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Lecture du fichier " + Consts.JSON_FILE_NAME + " impossible !\n");
            throw new IOException();
        }

    }
}
