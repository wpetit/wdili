package fr.min.wdili.android.listener;

import java.util.HashMap;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import fr.min.wdili.android.action.Action;

public class ItemClickListener implements OnItemClickListener {

	private ListView listView;

	public ItemClickListener(ListView listView) {
		this.listView = listView;
	}

	@SuppressWarnings("unchecked")
	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		// Retrieve list item and launch associated action.
		HashMap<String, Object> map = (HashMap<String, Object>) listView
				.getItemAtPosition(position);
		Action action = (Action) map.get("action");
		action.execute();
	}

}
