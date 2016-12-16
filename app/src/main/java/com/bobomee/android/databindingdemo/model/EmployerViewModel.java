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

public class EmployerViewModel extends EmployeeViewModel {
    public String avatarUrl;
    public String position;

    public EmployerViewModel(String name, int age, String avatarUrl, String position) {
        super(name, age);
        this.avatarUrl = avatarUrl;
        this.position = position;
        this.type = 1;
    }
}
