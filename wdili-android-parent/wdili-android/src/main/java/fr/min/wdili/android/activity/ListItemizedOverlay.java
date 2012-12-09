package fr.min.wdili.android.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class ListItemizedOverlay extends ItemizedOverlay<OverlayItem> {

	private List<OverlayItem> arrayListOverlayItem = new ArrayList<OverlayItem>();

	public ListItemizedOverlay(Drawable drawable) {
		super(boundCenterBottom(drawable));
	}

	@Override
	protected OverlayItem createItem(int i) {
		return arrayListOverlayItem.get(i);
	}

	@Override
	public int size() {
		return arrayListOverlayItem.size();
	}

	public void addOverlayItem(OverlayItem overlay) {
		arrayListOverlayItem.add(overlay);
		populate();
	}

}
