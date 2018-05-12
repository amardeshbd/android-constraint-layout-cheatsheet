/*
 * Copyright (c) 2018 Hossain Khan
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

package com.hossainkhan.android.demo.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.hossainkhan.android.demo.browse.LayoutBrowseViewModel
import com.hossainkhan.android.demo.data.AppDataStore
import com.hossainkhan.android.demo.layoutpreview.LayoutInfoViewModel
import javax.inject.Inject

/**
 * The [ViewModelProvider.Factory] that provides all the ViewModels for the activities and fragments.
 */
class LayoutPreviewViewModelFactory @Inject constructor(
        private val dataStore: AppDataStore

) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LayoutInfoViewModel::class.java) -> {
                LayoutInfoViewModel(dataStore) as T
            }
            modelClass.isAssignableFrom(LayoutBrowseViewModel::class.java) -> {
                LayoutBrowseViewModel(dataStore) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}