/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.work@gmail.com
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

package com.arthurivanets.sample.adapters.adapster

import android.content.Context
import com.arthurivanets.adapster.markers.ItemResources
import com.arthurivanets.adapster.model.BaseItem
import com.arthurivanets.adapster.recyclerview.TrackableRecyclerViewAdapter

/**
 *
 */
class VideoItemsRecyclerViewAdapter(
    context : Context,
    items : MutableList<BaseItem<*, *, *>>,
    private val resources : VideoItemResources
) : TrackableRecyclerViewAdapter<Long, BaseItem<*, *, *>, BaseItem.ViewHolder<*>>(context, items) {


    override fun getResources() : ItemResources? {
        return resources
    }


}