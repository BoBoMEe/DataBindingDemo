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

package com.bobomee.android.databindingdemo.adapter;

import android.content.Context;
import android.widget.Toast;
import com.bobomee.android.adapter.interfaces.AdapterItem;
import com.bobomee.android.databindingdemo.BR;
import com.bobomee.android.databindingdemo.model.EmployerViewModel;
import com.bobomee.android.databindingdemo.R;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2016/12/15.下午10:12.
 *
 * @author bobomee.
 */

public class EmployerItem implements AdapterItem<EmployerViewModel> {

  private final Context context;


  public EmployerItem(Context
      _context) {
    this.context = _context;
  }

  @Override public int getLayoutResId() {
    return R.layout.item_employer;
  }

  @Override public Integer getVariableId() {
    return BR.item;
  }

  @Override public Decorator getDecorator() {
    return null;
  }

  @Override public Map<Integer, Object> getBindData() {
    Map<Integer, Object> map = new HashMap<>();
    map.put(BR.presenter, new EmployerPresenter());
    return map;
  }

  public class EmployerPresenter {
    public void onItemClick(EmployerViewModel model) {
      Toast.makeText(context, "employer " + model.name, Toast.LENGTH_SHORT).show();
    }
  }
}
