package fr.min.wdili.android.listener;

import fr.min.wdili.android.business.WhereDidILeaveItBusiness;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class FindMyWayButtonListener implements OnClickListener {

	private WhereDidILeaveItBusiness business;
	
	public FindMyWayButtonListener(WhereDidILeaveItBusiness business) {
		this.business = business;
	}

	public void onClick(View view) {
		Log.i(FindMyWayButtonListener.class.getName(), "onClick");
		business.displayLocation();
	}

}
