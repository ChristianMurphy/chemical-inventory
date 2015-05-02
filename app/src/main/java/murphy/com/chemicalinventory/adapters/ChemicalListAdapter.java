package murphy.com.chemicalinventory.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.models.ChemicalModel;

public class ChemicalListAdapter extends RealmBaseAdapter<ChemicalModel> implements ListAdapter {

    private static class ChemicalViewHolder {
        TextView name;
        TextView chemicalAbstractServiceRegistryNumber;
    }

    public ChemicalListAdapter(Context context, RealmResults<ChemicalModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChemicalViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ChemicalViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.chemicalAbstractServiceRegistryNumber = (TextView) convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ChemicalViewHolder) convertView.getTag();
        }

        ChemicalModel item = realmResults.get(position);
        viewHolder.name.setText(item.getName());
        viewHolder.name.setTextColor(Color.BLACK);
        viewHolder.chemicalAbstractServiceRegistryNumber.setText(item.getChemicalAbstractServiceRegistryNumber());
        viewHolder.chemicalAbstractServiceRegistryNumber.setTextColor(Color.BLACK);
        return convertView;
    }

    public RealmResults<ChemicalModel> getRealmResults() {
        return realmResults;
    }
}
