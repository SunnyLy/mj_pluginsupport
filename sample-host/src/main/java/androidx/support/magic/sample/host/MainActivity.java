/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package androidx.support.magic.sample.host;


import static androidx.support.magic.sample.constant.Constant.PART_KEY_PLUGIN_BASE;
import static androidx.support.magic.sample.constant.Constant.PART_KEY_PLUGIN_MAIN_APP;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.support.magic.sample.constant.Constant;
import androidx.support.magic.sample.host.plugin_view.HostAddPluginViewActivity;


public class MainActivity extends Activity {

//    private static final String BActivity = "com.n67pf5k0y.b78d4wg.GL6dnaR54";
    private static final String BActivity = "org.eOHSx09h1.tMz2A3Cy.jQC667";
    private static final String BParKey = "Unisg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.TestHostTheme);

        LinearLayout rootView = new LinearLayout(this);
        rootView.setOrientation(LinearLayout.VERTICAL);

        TextView infoTextView = new TextView(this);
        infoTextView.setText(R.string.main_activity_info);
        rootView.addView(infoTextView);

        final Spinner partKeySpinner = new Spinner(this);
        ArrayAdapter<String> partKeysAdapter = new ArrayAdapter<>(this, R.layout.part_key_adapter);
        partKeysAdapter.addAll(
                BParKey,
                PART_KEY_PLUGIN_MAIN_APP,
                Constant.PART_KEY_PLUGIN_ANOTHER_APP,
                "AAPK"
        );
        partKeySpinner.setAdapter(partKeysAdapter);

        rootView.addView(partKeySpinner);

        Button startPluginButton = new Button(this);
        startPluginButton.setText(R.string.start_plugin);
        startPluginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String partKey = (String) partKeySpinner.getSelectedItem();
//                Log.e("sunny","-----------partKey = "+partKey);
                Intent intent = new Intent(MainActivity.this, PluginLoadActivity.class);
                switch (partKey) {
                    //为了演示多进程多插件，其实两个插件内容完全一样，除了所在进程

                    case PART_KEY_PLUGIN_MAIN_APP:
//                        Log.e("sunny","-----------partKey1 = "+partKey);
//                        intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, PART_KEY_PLUGIN_BASE);
                        intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, PART_KEY_PLUGIN_MAIN_APP);
                        break;
                    case BParKey:
                    case Constant.PART_KEY_PLUGIN_ANOTHER_APP:
//                        Log.e("sunny","-----------partKey2 = "+partKey);
                        intent.putExtra(Constant.KEY_PLUGIN_PART_KEY, partKey);
                        ;
                        break;
                }

                switch (partKey) {
                    //为了演示多进程多插件，其实两个插件内容完全一样，除了所在进程
                    case BParKey:
                    case PART_KEY_PLUGIN_MAIN_APP:
                    case Constant.PART_KEY_PLUGIN_ANOTHER_APP:
//                        intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "androidx.support.magic.sample.plugin.app.lib.gallery.splash.SplashActivity");
                        //跳转B面
                        intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, BActivity);
                        break;
                    case "AAPK":
                        intent.putExtra(Constant.KEY_ACTIVITY_CLASSNAME, "com.cocos.game.AppActivity");
                        break;

                }
                startActivity(intent);
            }
        });
        rootView.addView(startPluginButton);

        Button startHostAddPluginViewActivityButton = new Button(this);
        startHostAddPluginViewActivityButton.setText("宿主添加插件View");
        startHostAddPluginViewActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, HostAddPluginViewActivity.class);
            startActivity(intent);
        });
        rootView.addView(startHostAddPluginViewActivityButton);

        setContentView(rootView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
//                        throw new RuntimeException("必须赋予权限.");
                    }
                }
            }
        }
    }

}
