package fr.min.wdili.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import fr.min.wdili.android.R;
import fr.min.wdili.android.business.WhereDidILeaveItBusiness;
import fr.min.wdili.android.business.impl.WhereDidILeaveItBusinessImpl;
import fr.min.wdili.android.listener.FindMyWayButtonListener;
import fr.min.wdili.android.listener.RememberButtonListener;

public class WhereDidILeaveItActivity extends Activity {

	private static String TAG = "wdili-android";

	private Button rememberButton;
	private Button findMyWayButton;

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

		rememberButton = (Button) findViewById(R.id.remember_button);
		rememberButton.setOnClickListener(new RememberButtonListener(business));
		
		findMyWayButton = (Button) findViewById(R.id.findmyway_button);
		findMyWayButton.setOnClickListener(new FindMyWayButtonListener(business));
	}

	public void displayLocation(double longitude, double latitude) {
		Intent intent = new Intent(this, FindMyWayBackActivity.class);
		intent.putExtra("longitude", longitude);
		intent.putExtra("latitude", latitude);
		startActivity(intent);
	}

	public void displayLocationStore() {
		Toast.makeText(this, R.string.locationstored_notification,Toast.LENGTH_LONG).show();
	}
}
