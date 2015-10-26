package fr.univtln.mgajovski.d12;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Maxime on 20/10/2015.
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nIntitule : "        + label         + "\n");
        stringBuilder.append("ECTS : "              + ects          + "\n");
        stringBuilder.append("Heures dispensees : " + hoursProvided + "\n");
        stringBuilder.append("Description : "       + descriptions  + "\n");
        return stringBuilder.toString();
    }
}
