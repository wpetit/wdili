package fr.min.wdili.android.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class SingleLocationListener implements LocationListener {

	private LocationUpdateListener locationUpdateListener;

	public SingleLocationListener(LocationUpdateListener locationUpdateListener) {
		this.locationUpdateListener = locationUpdateListener;
	}

	public void onLocationChanged(Location location) {
		if (location != null) {
			locationUpdateListener.onLocationUpdate(location);
		}
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
