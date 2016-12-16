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

package com.bobomee.android.databindingdemo.model;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

public class ViewBindingAdapter {

    @BindingAdapter(value = {"url","placeholder"},requireAll = false)
    public static void loadImage(ImageView view, String url,int placeHolder) {
        DrawableTypeRequest<String> load = Glide.with(view.getContext()).load(url);
        if (0!= placeHolder){
            load.placeholder(placeHolder);
        }
        load.into(view);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView view, RecyclerView.LayoutManager manager) {
        view.setLayoutManager(manager);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
}
