package fr.min.wdili.android.listener;

import fr.min.wdili.android.business.WhereDidILeaveItBusiness;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class RememberButtonListener implements OnClickListener {

	private WhereDidILeaveItBusiness business;
	
	public RememberButtonListener(WhereDidILeaveItBusiness business) {
		this.business = business;
	}

	public void onClick(View view) {
		Log.i(RememberButtonListener.class.getName(), "onClick");
		business.storeLocation();
	}

}
