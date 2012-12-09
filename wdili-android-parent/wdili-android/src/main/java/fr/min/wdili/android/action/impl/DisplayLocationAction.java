package fr.min.wdili.android.action.impl;

import fr.min.wdili.android.action.Action;
import fr.min.wdili.android.business.WhereDidILeaveItBusiness;

public class DisplayLocationAction implements Action {
	
	private WhereDidILeaveItBusiness business;

	public DisplayLocationAction(WhereDidILeaveItBusiness business) {
		this.business = business;
	}
	
	public void execute() {
		business.displayLocation();
	}

}
