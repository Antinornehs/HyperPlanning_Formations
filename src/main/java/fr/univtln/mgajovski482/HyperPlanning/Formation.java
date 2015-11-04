package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Teacher;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;


/**
 * Created by Maxime on 20/10/2015.
 */
public class Formation{

    private static Logger logger = Logger.getLogger("Formation.class");

    public static Map<String, Formation> formationMap = new HashMap<String, Formation>();
    private List<TeachingUnit> teachingUnits = new ArrayList<TeachingUnit>();

    private final String id;
    private final String grade;
    private final String label;
    private final Teacher teacher;

    public Formation(String grade, String label, Teacher teacher){
        this.grade = grade;
        this.label = label;
        this.id = grade + " " + label;
        this.teacher = teacher;
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

    public static String[] getFormationsLabel(){
        Set<String> formationKeySet = formationMap.keySet();
        return formationKeySet.toArray(new String[formationKeySet.size()]);
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
