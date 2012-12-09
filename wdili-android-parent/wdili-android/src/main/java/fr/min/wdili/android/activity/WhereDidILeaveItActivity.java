package fr.min.wdili.android.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import fr.min.wdili.android.R;
import fr.min.wdili.android.action.Action;
import fr.min.wdili.android.action.impl.DisplayAboutAction;
import fr.min.wdili.android.action.impl.DisplayLocationAction;
import fr.min.wdili.android.action.impl.RememberLocationAction;
import fr.min.wdili.android.business.WhereDidILeaveItBusiness;
import fr.min.wdili.android.business.impl.WhereDidILeaveItBusinessImpl;
import fr.min.wdili.android.listener.ItemClickListener;

public class WhereDidILeaveItActivity extends Activity {

	private static String TAG = "wdili-android";

	private WhereDidILeaveItBusiness business;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		setContentView(R.layout.main);
		business = new WhereDidILeaveItBusinessImpl(this);
		displayListItem();
	}

	public void displayLocation(double longitude, double latitude) {
		Log.d(TAG, "displayLocation");
		Intent intent = new Intent(this, FindMyWayBackActivity.class);
		intent.putExtra("longitude", longitude);
		intent.putExtra("latitude", latitude);
		startActivity(intent);
	}

	public void displayLocationStored() {
		Log.d(TAG, "displayLocationStored");
		Toast.makeText(this, R.string.locationstored_notification,
				Toast.LENGTH_LONG).show();
	}

	private void displayListItem() {
		Log.d(TAG, "displayListItem");
		fillGeneralListView();
		fillAboutListView();
	}
	
	public void displayAbout() {
		Log.d(TAG, "displayAbout");
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}

	private void fillAboutListView() {
		final ListView listViewAbout = (ListView) findViewById(R.id.listviewAbout);

		// Création de la ArrayList qui nous permettra de remplire la listView
		ArrayList<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();

		// Create store location item
		Map<String, Object> mapStoreLocation = createListItem(
				getString(R.string.information_button),
				getString(R.string.information_button_description),
				String.valueOf(R.drawable.about_45_45),
				new DisplayAboutAction(business));
		// enfin on ajoute cette hashMap dans la arrayList
		listItem.add(mapStoreLocation);

		// Création d'un SimpleAdapter qui se chargera de mettre les items
		// présent dans notre list (listItem) dans la vue affichageitem
		SimpleAdapter simpleAdapter = new SimpleAdapter(this.getBaseContext(),
				listItem, R.layout.listitem, new String[] { "img", "titre",
						"description" }, new int[] { R.id.img, R.id.titre,
						R.id.description });

		// On attribut à notre listView l'adapter que l'on vient de créer
		listViewAbout.setAdapter(simpleAdapter);

		// Enfin on met un écouteur d'évènement sur notre listView
		listViewAbout.setOnItemClickListener(new ItemClickListener(
				listViewAbout));
	}

	private void fillGeneralListView() {
		final ListView listViewGeneral = (ListView) findViewById(R.id.listviewGeneral);
		// Création de la ArrayList qui nous permettra de remplire la listView
		ArrayList<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();

		// Create store location item
		Map<String, Object> mapStoreLocation = createListItem(
				getString(R.string.remember_button),
				getString(R.string.remember_button_description),
				String.valueOf(R.drawable.notepen_45_45),
				new RememberLocationAction(business));
		// enfin on ajoute cette hashMap dans la arrayList
		listItem.add(mapStoreLocation);

		// Create display location item
		Map<String, Object> mapDisplayLocation = createListItem(
				getString(R.string.findmyway_button),
				getString(R.string.findmyway_button_description),
				String.valueOf(R.drawable.map_45_45),
				new DisplayLocationAction(business));

		listItem.add(mapDisplayLocation);

		// Display items in list
		SimpleAdapter simpleAdapter = new SimpleAdapter(this.getBaseContext(),
				listItem, R.layout.listitem, new String[] { "img", "titre",
						"description" }, new int[] { R.id.img, R.id.titre,
						R.id.description });

		// set the adapter
		listViewGeneral.setAdapter(simpleAdapter);

		// Add listener on click
		listViewGeneral.setOnItemClickListener(new ItemClickListener(
				listViewGeneral));
	}

	private Map<String, Object> createListItem(String title,
			String description, String image, Action action) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// on insère un élément titre que l'on récupérera dans le textView titre
		// créé dans le fichier affichageitem.xml
		map.put("titre", title);
		// on insère un élément description que l'on récupérera dans le textView
		// description créé dans le fichier affichageitem.xml
		map.put("description", description);
		// on insère la référence à l'image (convertit en String car normalement
		// c'est un int) que l'on récupérera dans l'imageView créé dans le
		// fichier affichageitem.xml
		map.put("img", image);
		// on insère l'action a effectuer en cas de clic
		map.put("action", action);
		return map;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
