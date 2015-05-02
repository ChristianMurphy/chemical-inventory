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
        TextView amount;
    }

    public ChemicalListAdapter(Context context, RealmResults<ChemicalModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChemicalViewHolder viewHolder;
        if (convertView == null) {
            // Create Item and Holder
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ChemicalViewHolder();

            // Attach TextAreas to Holder
            viewHolder.name = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.amount = (TextView) convertView.findViewById(android.R.id.text2);

            // Set TextArea color
            viewHolder.name.setTextColor(Color.BLACK);
            viewHolder.amount.setTextColor(Color.BLACK);

            // Tag TextArea for retrieval later
            convertView.setTag(viewHolder);
        } else {
            // Retrieve Holder information from Tag
            viewHolder = (ChemicalViewHolder) convertView.getTag();
        }

        // Get the ChemicalModel
        ChemicalModel item = realmResults.get(position);

        // Set the Holder TextAreas values
        viewHolder.name.setText(item.getName());
        viewHolder.amount.setText(item.getQuantity() + " " + item.getQuantityUnit());

        return convertView;
    }

    public RealmResults<ChemicalModel> getRealmResults() {
        return realmResults;
    }
}
