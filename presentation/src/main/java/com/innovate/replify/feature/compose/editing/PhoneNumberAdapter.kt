/*
 * Copyright (C) 2017 Moez Bhatti <innovate.bhatti@gmail.com>
 *
 * This file is part of replify.
 *
 * replify is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * replify is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with replify.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.innovate.replify.feature.compose.editing

import android.view.ViewGroup
import com.innovate.replify.common.base.QkAdapter
import com.innovate.replify.common.base.QkViewHolder
import com.innovate.replify.databinding.ContactNumberListItemBinding
import com.innovate.replify.model.PhoneNumber

class PhoneNumberAdapter : QkAdapter<PhoneNumber, ContactNumberListItemBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QkViewHolder<ContactNumberListItemBinding> {
        return QkViewHolder(parent, ContactNumberListItemBinding::inflate)
    }

    override fun onBindViewHolder(holder: QkViewHolder<ContactNumberListItemBinding>, position: Int) {
        val number = getItem(position)

        holder.binding.address.text = number.address
        holder.binding.type.text = number.type
    }

    override fun areItemsTheSame(old: PhoneNumber, new: PhoneNumber): Boolean {
        return old.type == new.type && old.address == new.address
    }

    override fun areContentsTheSame(old: PhoneNumber, new: PhoneNumber): Boolean {
        return old.type == new.type && old.address == new.address
    }

}
