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

package com.bobomee.android.adapter.interfaces;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import java.util.List;

/**
 * Created on 2016/12/15.下午7:23.
 *
 * @author bobomee.
 */

public interface IAdapter<T> {

  void setData(@NonNull List<T> data);

  List<T> getData();

  int getViewType(T t);

  @Keep @NonNull AdapterItem<T> createItem(int viewType);
}
