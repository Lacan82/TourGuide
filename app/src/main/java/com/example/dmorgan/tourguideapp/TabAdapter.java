/*
 * Copyright (C) 2016 The Android Open Source Project
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
package com.example.dmorgan.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabAdapter extends FragmentPagerAdapter {

    private Context mContext;


    public TabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightFragment();
        } else if (position == 1) {
            return new EntertainFragment();
        } else if (position == 2) {
            return new HotelsFragment();
        } else {
            return new FoodFragment();
        }
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_text_1);
        } else if (position == 1 ){
            return mContext.getString(R.string.tab_text_2);
        }  else if (position == 2 ){
            return mContext.getString(R.string.tab_text_3);
        }  else {
            return mContext.getString(R.string.tab_text_4);
        }
    }
}
