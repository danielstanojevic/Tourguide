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
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //borrowed most of this from a post by ninosoft, but added check for null view:
        //https://github.com/udacity/ud839_Miwok/commit/8fae046f71ed6be3756f2abb1b5452fbeb5a5618

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        assert viewPager != null;
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        // Find the tab layout that shows the tabs
        assert tabLayout != null;
        tabLayout.setupWithViewPager(viewPager);

        //Set OnClick Listeners for each activity
//        setCustomOnClickListener(R.id.numbers, NumbersActivity.class);
//        setCustomOnClickListener(R.id.family, FamilyActivity.class);
//        setCustomOnClickListener(R.id.colors, ColorsActivity.class);
//        setCustomOnClickListener(R.id.phrases, PhrasesActivity.class);
    }

    public void setCustomOnClickListener(int resourceID, final Class className) {
        // Find the View that shows the numbers category
        View view = findViewById(resourceID);

        // Set a click listener on that View
        if (view != null) {
            view.setOnClickListener(
                    new View.OnClickListener() {
                        // The code in this method will be executed when the respective View is clicked on.
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), className);
                            startActivity(intent);
                        }
                    });
        }
    }
}
