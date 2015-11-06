package fr.univtln.mgajovski482.HyperPlanning;

import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.DirectorOfFormation;
import fr.univtln.mgajovski482.HyperPlanning.User.RegisteredUser.Teacher;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;


/**
 * <b>Formation est la classe representant les différentes formations.</b>
 * <p>
 * Une formation est caracterisee par les informations suivantes:
 * <ul>
 *     <li>Un niveau (grade)</li>
 *     <li>Un intitule (label)</li>
 *     <li>Un id unique (qui est la concatenation des deux chaines precedantes)</li>
 *     <li>Des unites d'enseignements(teachingUnits)</li>
 *     <li>Un directeur de formation (directorOfFormation)</li>
 * </ul>
 *
 * <p>
 * Les differentes formations sont stockees à partir d'une Map.
 *
 *  @author Maxime
 */

public class Formation{

    private static Logger logger = Logger.getLogger("Formation.class");

    public static Map<String, Formation> formationMap = new HashMap<String, Formation>();
    private List<TeachingUnit> teachingUnits = new ArrayList<TeachingUnit>();
    private final String id;
    private final String grade;
    private final String label;
    private Teacher directorOfFormation;

    public Formation(
            String grade,
            String label,
            Teacher directorOfFormation){
        this.grade                  = grade;
        this.label                  = label;
        this.id                     = grade + " " + label;
        this.directorOfFormation    = directorOfFormation;
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

    public Teacher getDirector() { return directorOfFormation; }


    public void setDirectorOfFormation(DirectorOfFormation directorOfFormation) {
        this.directorOfFormation = directorOfFormation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formation)) return false;
        Formation formation = (Formation) o;
        return id.equals(formation.id);

    }
    public static Formation getRandomFormation (){
        Random random = new Random();

        List<Formation> formations =
                Arrays.asList(formationMap.values().toArray(new Formation[0]));
        return formations.get(random.nextInt(formations.size()));

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
        String lastName  = directorOfFormation.getRuPersonalLogs().getLastName();
        String firstName =  directorOfFormation.getRuPersonalLogs().getFirstName();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nNom de la formation : "     + id + "\n");
        stringBuilder.append("Directeur de formation : " + lastName  + " " + firstName);
        stringBuilder.append(teachingUnits);
        return stringBuilder.toString();

    }
}
