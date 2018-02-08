package com.androidtutorialpoint.googlemapsdrawroute.parse.view;

import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public interface IeDataParseView {
    void successParsePolyline(PolylineOptions lineOptions);
    void errorParsePolyline();
}
