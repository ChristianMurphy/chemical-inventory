package murphy.com.chemicalinventory.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * LabModel
 * @author Christian Murphy
 * @version March 1, 2015
 * License: MIT http://opensource.org/licenses/MIT
 */
public class LabModel extends RealmObject {
    @PrimaryKey
    private String name;

    private String location;
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
