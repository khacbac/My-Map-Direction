package com.androidtutorialpoint.googlemapsdrawroute.fetchurl.model;

import com.androidtutorialpoint.googlemapsdrawroute.helper.FetchUrl;
import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.presenter.IeResponseFetchUrl;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public class FetchUrlModel implements IeFetchUrlModel {
    @Override
    public void fetchUrl(String url, IeResponseFetchUrl responseFetchUrl) {
        FetchUrl fetchUrl = new FetchUrl(responseFetchUrl);
        fetchUrl.execute(url);
    }
}
