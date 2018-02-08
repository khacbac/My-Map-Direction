package com.androidtutorialpoint.googlemapsdrawroute.parse.model;

import com.androidtutorialpoint.googlemapsdrawroute.helper.ParserTask;

/**
 * Created by bachk.
 * Date 2/8/2018.
 */

public class DataParseModel implements IeDataParseModel{
    @Override
    public void parseTask(String data, IeResponseDataParse ieResponseDataParse) {
        new ParserTask(ieResponseDataParse).execute(data);
    }
}
