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

package com.hossainkhan.android.demo.ui.resource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hossainkhan.android.demo.R
import com.hossainkhan.android.demo.databinding.ActivityLearningResourceBinding
import com.hossainkhan.android.demo.viewmodel.ViewModelProviderFactory
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class LearningResourceActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var viewModel: LearningResourceViewModel
    private lateinit var binding: ActivityLearningResourceBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_resource)

        viewModel = ViewModelProvider(this, viewModelFactory).get(LearningResourceViewModel::class.java)
        setupData(binding.recyclerView)
    }


    private fun setupData(ideaList: RecyclerView) {

        val ideaListAdapter = ResourceListAdapter { data ->
            Timber.d("Item Clicked: $data")
            viewModel.onItemClicked(data)
        }

        ideaList.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@LearningResourceActivity)
            adapter = ideaListAdapter
        }

        viewModel.data.observe(this, Observer { result ->
            ideaListAdapter.submitList(result)
        })
    }
}
