package fr.min.wdili.android.business.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import fr.min.wdili.android.activity.WhereDidILeaveItActivity;
import fr.min.wdili.android.business.WhereDidILeaveItBusiness;
import fr.min.wdili.android.listener.LocationUpdateListener;
import fr.min.wdili.android.listener.SingleLocationListener;

public class WhereDidILeaveItBusinessImpl implements WhereDidILeaveItBusiness,
		LocationUpdateListener {

	private WhereDidILeaveItActivity activity;

	public WhereDidILeaveItBusinessImpl(WhereDidILeaveItActivity activity) {
		this.activity = activity;
	}

	public void storeLocation() {
		Log.d(this.getClass().getName(), "storeLocation");
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) activity
				.getSystemService(Context.LOCATION_SERVICE);
		Criteria accuracyCriteria = new Criteria();
		accuracyCriteria.setAccuracy(Criteria.ACCURACY_FINE);
		String locationProviderName = locationManager.getBestProvider(
				accuracyCriteria, true);
		if (locationProviderName != null) {
			Log.d(this.getClass().getName(),
					"locationProviderName is not null :)");
			LocationListener ll = new SingleLocationListener(this);
			locationManager.requestSingleUpdate(locationProviderName, ll, null);
		} else {
			Log.d(this.getClass().getName(), "locationProviderName is null :(");
		}
	}

	public void onLocationUpdate(Location location) {
		Log.d(this.getClass().getName(), "onLocationUpdate");
		SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putFloat("longitude", (float) location.getLongitude());
		editor.putFloat("latitude", (float) location.getLatitude());
		editor.commit();
		activity.displayLocationStored();
		Log.d(this.getClass().getName(), "onLocationUpdate: "+ location.getLongitude() + ";" + location.getLatitude());
	}

	public void displayLocation() {
		Log.d(this.getClass().getName(), "displayLocation");
		SharedPreferences preferences = activity.getPreferences(Context.MODE_PRIVATE);
		float longitude = preferences.getFloat("longitude", -1);
		float latitude = preferences.getFloat("latitude", -1);
		activity.displayLocation(longitude, latitude);
		Log.d(this.getClass().getName(), "displayLocation: "+ longitude + ";" + latitude);
	}

	public void displayAbout() {
		activity.displayAbout();
	}

}
