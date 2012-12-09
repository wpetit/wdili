package fr.min.wdili.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import fr.min.wdili.android.R;

public class AboutActivity extends Activity {

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
		setContentView(R.layout.about);
	}
}
