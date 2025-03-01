/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.work@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurivanets.arvi.player.datasource;

import com.arthurivanets.arvi.player.util.HttpHeaders;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;

/**
 * An implementation of the {@link DefaultHttpDataSource} with a support
 * for the Request Authorization using a dedicated {@link RequestAuthorizer}.
 */
public class ArviHttpDataSource extends DefaultHttpDataSource {


    private RequestAuthorizer requestAuthorizer;




    public ArviHttpDataSource(String userAgent) {
        super(userAgent);
    }




    public ArviHttpDataSource(String userAgent,
                              int connectTimeoutMillis,
                              int readTimeoutMillis) {
        super(
            userAgent,
            connectTimeoutMillis,
            readTimeoutMillis
        );
    }




    public ArviHttpDataSource(String userAgent,
                              int connectTimeoutMillis,
                              int readTimeoutMillis,
                              boolean allowCrossProtocolRedirects,
                              RequestProperties defaultRequestProperties) {
        super(
            userAgent,
            connectTimeoutMillis,
            readTimeoutMillis,
            allowCrossProtocolRedirects,
            defaultRequestProperties
        );
    }




    public final ArviHttpDataSource setRequestAuthorizer(RequestAuthorizer requestAuthorizer) {
        this.requestAuthorizer = requestAuthorizer;
        return this;
    }




    @Override
    public final long open(DataSpec dataSpec) throws HttpDataSourceException {
        if(requestAuthorizer != null) {
            setRequestProperty(HttpHeaders.AUTHORIZATION, requestAuthorizer.getAuthorization());
        }

        return super.open(dataSpec);
    }




}
