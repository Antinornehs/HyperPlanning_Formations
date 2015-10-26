package fr.univtln.mgajovski482.HyperPlanning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Maxime on 20/10/2015.
 */
public class Formation implements Serializable{

    private static Logger logger = Logger.getLogger("Formation.class");

    public static Map<String, Formation> formationMap
            = new HashMap<String, Formation>();

    private List<TeachingUnit> teachingUnits
            = new ArrayList<TeachingUnit>();

    private final String id;
    private final String grade;
    private final String label;

    public Formation(String grade, String label){
        this.grade = grade;
        this.label = label;
        this.id = grade + " " + label;
        formationMap.put(id, this);
        logger.info("Formation created successfully !");
    }

    public List<TeachingUnit> getTeachingUnits() {
        return teachingUnits;
    }

    public void addTeachingUnits(TeachingUnit ... teachingUnits) {
        for(TeachingUnit currentTeachingUnit : teachingUnits){
            this.teachingUnits.add(currentTeachingUnit);
        }
    }

    public String getGrade() {
        return grade;
    }

    public String getLabel() {
        return label;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;
        Formation formation = (Formation) o;
        return id.equals(formation.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nNom de la formation : " + id + "\n");
        stringBuilder.append(teachingUnits);
        return stringBuilder.toString();

    }
}
