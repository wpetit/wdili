package fr.min.wdili.android.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;

import fr.min.wdili.android.R;

public class FindMyWayBackActivity extends MapActivity {

	private static String TAG = "wdili-android";

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
		setContentView(R.layout.maps);
		double longitude = getIntent().getDoubleExtra("longitude", -1);
		double latitude = getIntent().getDoubleExtra("latitude", -1);
		displayLocation(longitude, latitude);
		displayMyLocation();
		Log.d(TAG, "onCreate, location to display" + longitude + ";" + latitude);
	}

	public void displayLocation(double longitude, double latitude) {
		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);
		MapController mapController = mapView.getController();
		GeoPoint geoPoint = new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
		mapController.animateTo(geoPoint);
		mapController.setCenter(geoPoint);
		mapController.setZoom(16);
		Drawable drawable = getResources().getDrawable(R.drawable.greenplacemark);
		ListItemizedOverlay itemizedOverlay = new ListItemizedOverlay(drawable);
		OverlayItem overlayItem = new OverlayItem(geoPoint, "text1", null);
		itemizedOverlay.addOverlayItem(overlayItem);
		mapView.getOverlays().add(itemizedOverlay);
	}
	
	public void displayMyLocation() {
		MapView mapView = (MapView) findViewById(R.id.mapview);
		MyLocationOverlay myLocationOverlay = new MyLocationOverlay(getApplicationContext(), mapView);
		myLocationOverlay.enableMyLocation();
		mapView.getOverlays().add(myLocationOverlay);
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
