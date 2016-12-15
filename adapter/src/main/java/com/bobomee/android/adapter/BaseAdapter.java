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
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import com.bobomee.android.adapter.interfaces.AdapterItem;
import com.bobomee.android.adapter.interfaces.IAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Base Data Binding RecyclerView Adapter.
 *
 * @author bobomee.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BindingViewHolder>
    implements IAdapter<T> {

  protected List<T> mDataList;
  protected final LayoutInflater mLayoutInflater;
  private final SparseArray<AdapterItem<T>> mAdapterItemSparseArray;
  protected  Context mContext;

  public BaseAdapter(Context context) {
    this(context, null);
  }

  public BaseAdapter(Context _context, List<T> _dataList) {
    mLayoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.mDataList = _dataList == null ? new ArrayList<T>() : new ArrayList<T>(_dataList);
    mAdapterItemSparseArray = new SparseArray<>();
    mContext = _context;
  }

  @Override public void setData(@NonNull List<T> data) {
    mDataList = new ArrayList<>(data);
    notifyDataSetChanged();
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    return getViewType(getItem(position));
  }

  protected T getItem(int _position) {
    return mDataList.get(_position);
  }

  @Override public List<T> getData() {
    return mDataList;
  }

  @Override public int getViewType(T _t) {
    return 0;
  }

  @Override public int getItemCount() {
    return mDataList.size();
  }

  public void remove(int position) {
    mDataList.remove(position);
    notifyItemRemoved(position);
  }

  public void clear() {
    mDataList.clear();
    notifyDataSetChanged();
  }

  protected LayoutInflater getLayoutInflater() {
    return mLayoutInflater;
  }

  protected AdapterItem<T> getAdapterItem(int viewType) {
    AdapterItem<T> tAdapterItem = mAdapterItemSparseArray.get(viewType);
    if (null == tAdapterItem) {
      tAdapterItem = createItem(viewType);
      mAdapterItemSparseArray.put(viewType, tAdapterItem);
    }
    return tAdapterItem;
  }
}
