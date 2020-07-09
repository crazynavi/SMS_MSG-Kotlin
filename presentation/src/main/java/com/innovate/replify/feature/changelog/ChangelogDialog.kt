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
package com.innovate.replify.feature.changelog

import androidx.appcompat.app.AlertDialog
import com.innovate.replify.BuildConfig
import com.innovate.replify.R
import com.innovate.replify.databinding.ChangelogDialogBinding
import com.innovate.replify.feature.main.MainActivity
import com.innovate.replify.manager.ChangelogManager
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class ChangelogDialog(activity: MainActivity) {

    val moreClicks: Subject<Unit> = PublishSubject.create()

    private val dialog: AlertDialog
    private val adapter = ChangelogAdapter(activity)

    init {
        val binding = ChangelogDialogBinding.inflate(activity.layoutInflater)

        dialog = AlertDialog.Builder(activity)
                .setCancelable(true)
                .setView(binding.root)
                .create()

        binding.version.text = activity.getString(R.string.changelog_version, BuildConfig.VERSION_NAME)
        binding.changelog.adapter = adapter
        binding.more.setOnClickListener { dialog.dismiss(); moreClicks.onNext(Unit) }
        binding.dismiss.setOnClickListener { dialog.dismiss() }
    }

    fun show(changelog: ChangelogManager.Changelog) {
        adapter.setChangelog(changelog)
        dialog.show()
    }

}
