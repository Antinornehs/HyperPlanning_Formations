package fr.univtln.mgajovski482.HyperPlanning;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maxime on 26/10/2015.
 */
public class JSonMethods {

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

        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(Consts.JSON_PATH));
            Formation formations[] = gson.fromJson(bufferedReader, Formation[].class);

            for(Formation currentFormation : formations){
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
