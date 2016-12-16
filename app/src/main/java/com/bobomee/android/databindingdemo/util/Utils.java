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

package com.bobomee.android.databindingdemo.util;

import java.util.Random;

/**
 * Created on 2016/12/16.上午8:54.
 *
 * @author bobomee.
 */

public class Utils {

  // 定义字符数组
  private static char[] chars = new char[] {
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
      'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
  };

  //获取随机字符串
  public static String getRandomString() {

    Random random = new Random();
    //获取随机长度
    int length = random.nextInt(chars.length) + 1;

    char[] data = new char[length];

    for (int i = 0; i < length; i++) {
      //获取随机字符
      int index = random.nextInt(chars.length);
      data[i] = chars[index];
    }
    return new String(data);
  }

  public static int getRadomInt() {
    Random random = new Random(100);

    int dex = random.nextInt();

    return dex;
  }
}
