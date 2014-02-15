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

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.app.Activity;

public class BluetoothView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetooth_live_card);
        Switch toggle = (Switch) findViewById(R.id.bluetooth_switch);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleBluetooth(true);
                } else {
                    toggleBluetooth(false);
                }
            }
        });
    }

	public static boolean toggleBluetooth(boolean enable) {
	    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	    boolean isEnabled = bluetoothAdapter.isEnabled();
	    if (enable && !isEnabled) {
	        return bluetoothAdapter.enable(); 
	    }
	    else if(!enable && isEnabled) {
	        return bluetoothAdapter.disable();
	    }

	    return true;
	}
    }
