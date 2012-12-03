package fr.min.wdili.android.test;

import android.test.ActivityInstrumentationTestCase2;
import fr.min.wdili.android.activity.WhereDidILeaveItActivity;

public class WhereDidILeaveItActivityTest extends ActivityInstrumentationTestCase2<WhereDidILeaveItActivity> {

    public WhereDidILeaveItActivityTest() {
        super(WhereDidILeaveItActivity.class); 
    }

    public void testActivity() {
        WhereDidILeaveItActivity activity = getActivity();
        assertNotNull(activity);
    }
}

