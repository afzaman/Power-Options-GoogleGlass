/**
 * Ensyr Power Options
 * Github - https://github.com/afzaman/
 * @author Asim Zaman
 * 
 * Copyright (C) 2013 OpenQuartz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ensyr.poweroptions;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.CompoundButton;
import android.widget.Switch;

public class WifiView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wifi_live_card);
        Switch toggle = (Switch) findViewById(R.id.wifi_switch);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleWiFi(true);
                } else {
                    toggleWiFi(false);
                }
            }
        });
    }
 
    public void toggleWiFi(boolean status) {
        WifiManager wifiManager = (WifiManager) this
                .getSystemService(Context.WIFI_SERVICE);
        if (status == true && !wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        } else if (status == false && wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
        }
    }

	}

	


