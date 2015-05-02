package murphy.com.chemicalinventory.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import murphy.com.chemicalinventory.models.LabModel;

public class LabListAdapter extends RealmBaseAdapter<LabModel> implements ListAdapter {

    private static class LabViewHolder {
        TextView name;
    }

    public LabListAdapter(Context context, RealmResults<LabModel> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LabViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new LabViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (LabViewHolder) convertView.getTag();
        }

        LabModel item = realmResults.get(position);
        viewHolder.name.setText(item.getName());
        return convertView;
    }

    public RealmResults<LabModel> getRealmResults() {
        return realmResults;
    }
}