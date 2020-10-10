package com.example.wingdemo.demo01;

import com.ctg.ag.sdk.biz.AepDeviceManagementClient;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceRequest;

public class Main {
    public static void main(String[] args) throws Exception {
        AepDeviceManagementClient client = AepDeviceManagementClient.newClient()
  .appKey("Eo8SkZCyDJl").appSecret("ll9Pbh8ny3")
  .build();

QueryDeviceRequest request = new QueryDeviceRequest();
// set your request params here
// request.setParamMasterKey(MasterKey);	// single value
// request.addParamMasterKey(MasterKey);	// or multi values
// request.setParamDeviceId(deviceId);	// single value
// request.addParamDeviceId(deviceId);	// or multi values
// request.setParamProductId();	// single value
// request.addParamProductId(productId);	// or multi values
System.out.println(client.QueryDevice(request));

// more requests

client.shutdown();
    }
}
