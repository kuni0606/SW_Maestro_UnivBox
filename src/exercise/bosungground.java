package exercise;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay.OnStateChangeListener;

public class bosungground extends NMapActivity {

	private NMapView mMapView;
	private NMapController mMapController;
	private NMapViewerResourceProvider mMapViewerResourceProvider;
	private NMapOverlayManager mOverlayManager;
	private OnStateChangeListener onPOIdataStateChangeListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// create map view
		mMapView = new NMapView(this);

		// create resource provider
		mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

		// create overlay manager
		mOverlayManager = new NMapOverlayManager(this, mMapView, mMapViewerResourceProvider);

		int markerId = NMapPOIflagType.PIN;
		// set POI data
		NMapPOIdata poiData = new NMapPOIdata(1, mMapViewerResourceProvider);
		
		poiData.beginPOIdata(2);
		poiData.addPOIitem(127.0947969, 34.773858, "보성공설운동장", markerId, 0);
		poiData.endPOIdata();

		// create POI data overlay
		NMapPOIdataOverlay poiDataOverlay = mOverlayManager.createPOIdataOverlay(poiData, null);

		// set a registered API key for Open MapViewer Library
		mMapView.setApiKey("176021a8f021afef57d2125a4b61395a");

		// set the activity content to the map view
		setContentView(mMapView);

		// initialize map view
		mMapView.setClickable(true);

		// use built in zoom controls
		mMapView.setBuiltInZoomControls(true, null); 

		// register listener for map state changes
		mMapView.setOnMapStateChangeListener(new OnMapStateChangeListener() {
			@Override
			public void onZoomLevelChange(NMapView arg0, int arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onMapInitHandler(NMapView arg0, NMapError errorInfo) {
				// TODO Auto-generated method stub
				if (errorInfo == null) { // success
					mMapController.setMapCenter(new NGeoPoint(127.0947969, 34.773858),11);
				} else { // fail
					Log.e("NMap", "onMapInitHandler: error=" + errorInfo.toString());
					// errInfo -> errorInfo ��Ÿ ���־���
				}
			}

			@Override
			public void onMapCenterChangeFine(NMapView arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onMapCenterChange(NMapView arg0, NGeoPoint arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationStateChange(NMapView arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
			}
		});
		mMapView.setOnMapViewTouchEventListener(new OnMapViewTouchEventListener() {

			@Override
			public void onTouchUp(NMapView arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTouchDown(NMapView arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSingleTapUp(NMapView arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onScroll(NMapView arg0, MotionEvent arg1,
					MotionEvent arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onLongPressCanceled(NMapView arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onLongPress(NMapView arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
			}
		});

		// use map controller to zoom in/out, pan and set map center, zoom level
		// etc.
		mMapController = mMapView.getMapController();
	} // end onCreate()
} // end class