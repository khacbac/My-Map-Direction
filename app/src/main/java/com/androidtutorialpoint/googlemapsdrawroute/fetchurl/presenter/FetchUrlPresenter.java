package com.androidtutorialpoint.googlemapsdrawroute.fetchurl.presenter;

import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.view.IeFetchUrlView;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.model.FetchUrlModel;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.model.IeFetchUrlModel;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public class FetchUrlPresenter implements IeFetchUrlPresenter, IeResponseFetchUrl {
    private IeFetchUrlView ieFetchUrlView;
    private IeFetchUrlModel ieFetchUrlModel;

    public FetchUrlPresenter(IeFetchUrlView ieFetchUrlView) {
        this.ieFetchUrlView = ieFetchUrlView;
        ieFetchUrlModel = new FetchUrlModel();
    }

    @Override
    public void fetchUrl(String url) {
        ieFetchUrlModel.fetchUrl(url,this);
    }

    @Override
    public void onResponseFetchUrl(String result) {
        if (result.isEmpty()) {
            ieFetchUrlView.errorFetchUrl();
        } else {
            ieFetchUrlView.successFetchUrl(result);
        }
    }
}
