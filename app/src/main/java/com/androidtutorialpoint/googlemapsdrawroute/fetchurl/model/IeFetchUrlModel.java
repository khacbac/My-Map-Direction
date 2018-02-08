package com.androidtutorialpoint.googlemapsdrawroute.fetchurl.model;

import com.androidtutorialpoint.googlemapsdrawroute.fetchurl.presenter.IeResponseFetchUrl;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public interface IeFetchUrlModel {
    void fetchUrl(String url, IeResponseFetchUrl responseFetchUrl);
}
