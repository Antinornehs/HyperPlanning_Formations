package fr.univtln.mgajovski.d12;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Maxime on 26/10/2015.
 */
public class JSonMethods {

    public static void toJSon(Collection<Formation> formationCollection){
        Gson gson = new Gson();

        String jSonObject = gson.toJson(formationCollection);

        try{
            FileWriter writer = new FileWriter(Consts.RESOURCES_PATH + "json2.json");
            writer.write(jSonObject);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void toFormation(String jSonPath){

        Gson gson = new Gson();

        try {
            BufferedReader bufferedReader= new BufferedReader(
                    new FileReader(jSonPath));
            Formation formations[] = gson.fromJson(bufferedReader, Formation[].class);

            for(Formation currentFormation : formations){
                Formation.formationMap.put(currentFormation.getId(), currentFormation);
                for(TeachingUnit currentTeachUnit : currentFormation.getTeachingUnits())
                    TeachingUnit.teachingUnitMap.put(currentTeachUnit.getCode(), currentTeachUnit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
