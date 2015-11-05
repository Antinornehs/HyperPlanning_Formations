package fr.univtln.mgajovski482.HyperPlanning;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <b>TeachingUnit est la classe representant les unites d'enseignements.</b>
 * <p>
 * Une unite d'enseignement est caracterisee par :
 * <ul>
 *     <li>Un code unique (code)</li>
 *     <li>Un intitule (label)</li>
 *     <li>L'ECTS indiquant le coefficient de l'UE dans une formation</li>
 *     <li>Le nombre d'heures dispense pendant le semestre (hoursProvided)</li>
 *     <li>Des descriptions supplémentaires (descriptions)</li>
 * </ul>
 *
 * <p>
 * Les differentes UEs sont stockees a partir d'une Map.
 *
 *  @author Maxime
 */

public class TeachingUnit implements Serializable{


    private static Logger logger = Logger.getLogger("TeachingUnit.class");

    public static Map<String, TeachingUnit> teachingUnitMap
            = new HashMap<String, TeachingUnit>();

    @NotNull
    private final String code;
    private final String label;
    private int ects                = 0;
    private int hoursProvided       = 0;
    private String descriptions     = "Non renseigne";

    public TeachingUnit(String code,String label) {
        this.code           = code;
        this.label          = label;
        teachingUnitMap.put(code, this);
        logger.info("TeachingUnit created successfully !");

    }

    public String getLabel() {
        return label;
    }

    public int getEcts() {
        return ects;
    }

    @Min(1)
    public TeachingUnit setEcts(int ects) {
        this.ects = ects;
        return this;
    }

    @Min(1)
    public int getHoursProvided() {
        return hoursProvided;
    }

    public TeachingUnit  setHoursProvided(int hoursProvided) {
        this.hoursProvided = hoursProvided;
        return this;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public TeachingUnit setDescriptions(String descriptions) {
        this.descriptions = descriptions;
        return this;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeachingUnit)) return false;

        TeachingUnit that = (TeachingUnit) o;

        return code.equals(that.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nIntitule : "        + label         + "\n");
        stringBuilder.append("ECTS : "              + ects          + "\n");
        stringBuilder.append("Heures dispensees : " + hoursProvided + "\n");
        stringBuilder.append("Description : "       + descriptions  + "\n");
        return stringBuilder.toString();
    }


    public String htmlToString() {
        String[] descriptions       =  null;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<br><u>"  + code + " : "  + label + "</u><br>");
        stringBuilder.append("ECTS : "  + ects          + "<br>");
        stringBuilder.append("Heures dispensees : " + hoursProvided + "<br>");
        stringBuilder.append("Description : <br>");

        if(this.descriptions != null && (descriptions = this.descriptions.split(",")) != null)
            for(String description : descriptions)
                stringBuilder.append("&emsp;" + description + "<br>");

        return stringBuilder.toString();
    }
}
