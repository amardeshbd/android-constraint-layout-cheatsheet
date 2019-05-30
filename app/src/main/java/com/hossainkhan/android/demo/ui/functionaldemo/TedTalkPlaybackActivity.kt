/*
 * Copyright (c) 2019 Hossain Khan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hossainkhan.android.demo.ui.functionaldemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.hossainkhan.android.demo.ui.layoutpreview.LayoutPreviewBaseActivity

class TedTalkPlaybackActivity : LayoutPreviewBaseActivity() {
    private val generalClickListener = View.OnClickListener { view ->
        Toast.makeText(view.context, "You tapped on ${view}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}