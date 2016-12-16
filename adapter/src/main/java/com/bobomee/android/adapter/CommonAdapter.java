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

package com.bobomee.android.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import com.bobomee.android.adapter.interfaces.AdapterItem;
import java.util.List;
import java.util.Map;

/**
 * Super simple multi-type adapter using data-binding.
 *
 * @author markzhai on 16/8/23
 *
 * modify by BoBoMEe
 */
public abstract class CommonAdapter<T> extends BaseAdapter<T> {

  public CommonAdapter(Context context) {
    super(context);
  }

  public CommonAdapter(Context context, @Nullable List<T> data) {
    super(context, data);
  }

  @Override public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    AdapterItem<T> tAdapterItem = getAdapterItem(viewType);
    return new BindingViewHolder<ViewDataBinding>(
        DataBindingUtil.inflate(mLayoutInflater, tAdapterItem.getLayoutResId(), parent, false));
  }

  @Override public void onBindViewHolder(BindingViewHolder holder, int position) {
    int itemViewType = getItemViewType(position);
    AdapterItem<T> adapterItem = getAdapterItem(itemViewType);

    //item
    Integer variableId = adapterItem.getVariableId();
    T item = getItem(position);
    holder.getBinding().setVariable(variableId, item);

    //presenter
    Map<Integer, Object> bindData = adapterItem.getBindData();
    for (Map.Entry<Integer, Object> entry : bindData.entrySet()) {
      Integer key = entry.getKey();
      Object value = entry.getValue();
      holder.getBinding().setVariable(key, value);
    }
    holder.getBinding().executePendingBindings();

    //decorator
    AdapterItem.Decorator decorator = adapterItem.getDecorator();

    if (decorator != null) {
      decorator.decorator(holder, position, getItemViewType(position));
    }
  }
}
