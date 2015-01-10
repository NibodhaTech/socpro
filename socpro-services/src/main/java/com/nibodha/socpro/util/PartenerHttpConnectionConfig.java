/**
 * 
 */
package com.nibodha.socpro.util;

import com.ning.http.client.AsyncHttpClientConfig;


public class PartenerHttpConnectionConfig {

    private static final int DEFAULT_TIMEOUT = 180 * 1000;// 3 min
    
    private static AsyncHttpClientConfig connectionConfig;

    public static AsyncHttpClientConfig getConnectionConfig() {

        if (connectionConfig == null) {
            AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
            builder.setAllowPoolingConnection(true).setRequestTimeoutInMs(DEFAULT_TIMEOUT).build();
            connectionConfig = builder.build();
        }

        return connectionConfig;
    }
}
