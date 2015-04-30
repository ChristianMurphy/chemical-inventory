package murphy.com.chemicalinventory.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Chemical extends RealmObject {
    @PrimaryKey
    private String name;

    private RealmList<Lab> labs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Lab> getLabs() {
        return labs;
    }

    public void setLabs(RealmList<Lab> labs) {
        this.labs = labs;
    }
}
