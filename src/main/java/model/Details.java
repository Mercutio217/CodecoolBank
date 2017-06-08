package model;

/**
 * Created by mercutio on 08.06.17.
 */
public abstract class Details {

    Integer id;
    String name;
    String description;

    public Details(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
