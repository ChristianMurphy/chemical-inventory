package murphy.com.chemicalinventory.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class Lab extends RealmObject {
    @PrimaryKey
    private String name;

    private RealmList<Chemical> chemicals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Chemical> getChemicals() {
        return chemicals;
    }

    public void setChemicals(RealmList<Chemical> chemicals) {
        this.chemicals = chemicals;
    }
}
