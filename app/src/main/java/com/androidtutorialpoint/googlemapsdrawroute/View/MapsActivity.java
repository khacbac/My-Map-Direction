package com.androidtutorialpoint.googlemapsdrawroute.View;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidtutorialpoint.googlemapsdrawroute.base.BaseMapActivity;
import com.androidtutorialpoint.googlemapsdrawroute.ultils.MapUltils;
import com.androidtutorialpoint.googlemapsdrawroute.R;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.presenter.FetchUrlPresenter;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.presenter.IeFetchUrlPresenter;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.view.IeFetchUrlView;
import com.androidtutorialpoint.googlemapsdrawroute.parse.presenter.DataParsePresenter;
import com.androidtutorialpoint.googlemapsdrawroute.parse.presenter.IeDataParsePresenter;
import com.androidtutorialpoint.googlemapsdrawroute.parse.view.IeDataParseView;
import com.androidtutorialpoint.googlemapsdrawroute.ultils.ToastUltils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends BaseMapActivity implements IeFetchUrlView, IeDataParseView {

    private GoogleMap mMap;
    private ArrayList<LatLng> markerPoints;
    boolean isClear = false;
    private IeFetchUrlPresenter ieFetchUrlPresenter;
    private IeDataParsePresenter ieDataParsePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Initializing
        markerPoints = new ArrayList<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // Dòng ni lờ khi load được map thành công.
    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);
        mMap = googleMap;
        ieFetchUrlPresenter = new FetchUrlPresenter(this);
        ieDataParsePresenter = new DataParsePresenter(this);
    }

    // Dòng ni lờ khi chọn 1 địa điệm ợ trên kì map.
    @Override
    public void onMapClick(LatLng latLng) {
        // Already two locations
        if (isClear) {
            markerPoints.clear();
            mMap.clear();
        }
        isClear = false;
        // Adding new item to the ArrayList
        markerPoints.add(latLng);
        // Creating MarkerOptions
        MarkerOptions options = new MarkerOptions();
        // Setting the position of the marker
        options.position(latLng);
        //  Dòng ni lờ chọn màu cho kì maker cụa mình.
        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        // Dòng ni lờ thêm kì maker ợ chộ mình vừa chọn.
        mMap.addMarker(options);
    }

    @Override
    public void successFetchUrl(String result) {
        // Dòng ni lờ khi lấy được dự liệu thành công,thực hiện pạt dự liệu.
        ieDataParsePresenter.parseTask(result);
    }

    @Override
    public void errorFetchUrl() {
        // Dòng ni lờ in ra lội khi mờ ko lấy được dự liệu.
        ToastUltils.showToast(this,"Cannot fetch url");
    }

    @Override
    public void successParsePolyline(PolylineOptions lineOptions) {
        // Dòng ni lờ vẹ pạt dự liệu thành công,bắt đầu vẹ đường đi dựa 2 điệm.
        mMap.addPolyline(lineOptions);
    }

    @Override
    public void errorParsePolyline() {
        // Dòng ni lờ in ra lội khi mờ ko pạt được pô ly ne.
        ToastUltils.showToast(this,"Cannot parse polyline");
    }

    // Dòng ni lờ khi bấm vu kì bất tần vẹ đường.
    public void onBtnDrawClick(View view) {
        for (int i = 0; i < markerPoints.size() - 1; i++) {
            LatLng origin = markerPoints.get(i);
            LatLng dest = markerPoints.get(i + 1);
            // Getting URL to the Google Directions API
            String url = MapUltils.getUrl(origin, dest);
            Log.d("onMapClick", url.toString());
            // Dòng ni lờ bắt đầu gửi cấy rì quét lấy dự liệu.
            ieFetchUrlPresenter.fetchUrl(url);
            // Di chuyển cấy cam mê ra.
            mMap.moveCamera(CameraUpdateFactory.newLatLng(origin));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        }
        isClear = true;
    }
}