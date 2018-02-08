package com.androidtutorialpoint.googlemapsdrawroute.parse.presenter;

import com.androidtutorialpoint.googlemapsdrawroute.parse.model.DataParseModel;
import com.androidtutorialpoint.googlemapsdrawroute.parse.model.IeDataParseModel;
import com.androidtutorialpoint.googlemapsdrawroute.parse.model.IeResponseDataParse;
import com.androidtutorialpoint.googlemapsdrawroute.parse.view.IeDataParseView;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public class DataParsePresenter implements IeDataParsePresenter, IeResponseDataParse{

    private IeDataParseView ieDataParseView;
    private IeDataParseModel ieDataParseModel;

    public DataParsePresenter(IeDataParseView ieDataParseView) {
        this.ieDataParseView = ieDataParseView;
        ieDataParseModel = new DataParseModel();
    }

    @Override
    public void parseTask(String data) {
        ieDataParseModel.parseTask(data,this);
    }

    @Override
    public void responsePolyline(PolylineOptions lineOptions) {
        if (lineOptions != null) {
            ieDataParseView.successParsePolyline(lineOptions);
        } else {
            ieDataParseView.errorParsePolyline();
        }
    }
}
