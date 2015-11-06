package fr.univtln.mgajovski482.HyperPlanning;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by stephane on 06/11/15.
 */
public class Group {
    private static Logger logger = Logger.getLogger("Group.class");
    public static Map<Integer, Group> groupMap = new HashMap<Integer, Group>();

    @NotNull
    private int id;
    private String title;

    public Group(int id, String title) {
        this.id = id;
        this.title = title;
        groupMap.put(id, this);
        logger.info("Group created successfully !");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return id == group.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
