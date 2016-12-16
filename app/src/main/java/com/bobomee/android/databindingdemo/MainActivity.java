/*
 * Copyright (C) 2016.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.bobomee.android.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.bobomee.android.databindingdemo.adapter.MainAdapter;
import com.bobomee.android.databindingdemo.databinding.ActivityMainBinding;
import com.bobomee.android.databindingdemo.model.EmployeeViewModel;
import com.bobomee.android.databindingdemo.model.EmployerViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding mActivityMainBinding;

  private static List mList = new ArrayList();

  static {
    EmployeeViewModel model1 = new EmployeeViewModel("markzhai", 26);
    EmployeeViewModel model2 = new EmployeeViewModel("dim", 25);
    EmployeeViewModel model3 = new EmployeeViewModel("abner", 25);
    EmployeeViewModel model4 = new EmployeeViewModel("cjj", 26);

    mList.add(model1);
    mList.add(model2);
    mList.add(model3);
    mList.add(model4);

    EmployerViewModel model5 = new EmployerViewModel("boss1", 30,
        "https://avatars2.githubusercontent.com/u/1106500?v=3&s=150", "CEO");

    EmployerViewModel model6 = new EmployerViewModel("boss2", 31,
        "https://avatars3.githubusercontent.com/u/11629640?v=3&s=150", "CTO");

    EmployerViewModel model7 = new EmployerViewModel("boss3", 38,
        "https://avatars2.githubusercontent.com/u/1468623?v=3&s=150", "CAO");

    mList.add(model5);
    mList.add(model6);
    mList.add(model7);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    mActivityMainBinding.setLayoutManager(new LinearLayoutManager(this));
    mActivityMainBinding.setAdapter(new MainAdapter(this, mList));
  }
}
