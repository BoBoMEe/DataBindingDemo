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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bobomee.android.adapter.CommonAdapter;
import com.bobomee.android.adapter.interfaces.AdapterItem;
import com.bobomee.android.databindingdemo.EmployeeViewModel;
import java.util.List;

/**
 * Created on 2016/12/15.下午10:12.
 *
 * @author bobomee.
 */

public class MainAdapter extends CommonAdapter {
  public MainAdapter(Context context, @Nullable List data) {
    super(context, data);
  }

  @NonNull @Override public AdapterItem createItem(int viewType) {

    AdapterItem adapterItem = null;

    switch (viewType) {
      case 0:
        adapterItem = new EmployeeItem(mContext);
        break;
      case 1:
        adapterItem = new EmployerItem(mContext);
        break;
    }
    return adapterItem;
  }

  @Override public int getViewType(Object _o) {
    int result = 0;
    if (_o instanceof EmployeeViewModel) {
      EmployeeViewModel employeeViewModel = (EmployeeViewModel) _o;
      result = employeeViewModel.type;
    }

    return result;
  }
}
