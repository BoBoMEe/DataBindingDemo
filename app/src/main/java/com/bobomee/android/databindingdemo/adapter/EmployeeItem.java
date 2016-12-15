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
import android.view.View;
import android.widget.Toast;
import com.bobomee.android.adapter.BindingViewHolder;
import com.bobomee.android.adapter.interfaces.AdapterItem;
import com.bobomee.android.databindingdemo.EmployeeViewModel;
import com.bobomee.android.databindingdemo.R;

/**
 * Created on 2016/12/15.下午10:12.
 *
 * @author bobomee.
 */

public class EmployeeItem implements AdapterItem<EmployeeViewModel> {
  private final Context context;

  public EmployeeItem(Context _context) {
    this.context = _context;
  }

  @Override public int getLayoutResId() {
    return R.layout.item_employee;
  }

  @Override public Presenter getPresenter() {
    return new EmployeePresenter();
  }

  @Override public Decorator getDecorator() {
    return new Decorator() {
      @Override public void decorator(BindingViewHolder holder, int position, int viewType) {
        View itemView = holder.itemView;
        itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
      }
    };
  }

  public class EmployeePresenter implements Presenter {
    public void onItemClick(EmployeeViewModel model) {
      Toast.makeText(context, "employee " + model.name, Toast.LENGTH_SHORT).show();
    }
  }
}
