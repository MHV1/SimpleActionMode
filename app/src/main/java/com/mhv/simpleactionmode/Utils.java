/*
 * Copyright (C) 2018 Milan Herrera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mhv.simpleactionmode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

class Utils {

    static Drawable getSelectableBackgroundDrawable(final Context context) {
        int[] attrs = new int[]{android.R.attr.selectableItemBackground};
        TypedArray ta = context.obtainStyledAttributes(attrs);

        Drawable drawableFromTheme = ta.getDrawable(0);
        ta.recycle();

        return drawableFromTheme;
    }

    static ArrayList<Model> createDummyDataSet() {
        final ArrayList<Model> dataSet = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            dataSet.add(new Model("Message " + i, System.currentTimeMillis()));
        }
        return dataSet;
    }

    public static String formatDate(long milliSeconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return dateFormat.format(calendar.getTime());
    }
}
