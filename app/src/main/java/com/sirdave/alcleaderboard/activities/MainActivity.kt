package com.sirdave.alcleaderboard.activities

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.adapters.ViewPagerAdapter
import com.sirdave.alcleaderboard.fragments.LearningLeadersFragment
import com.sirdave.alcleaderboard.fragments.SkillIQFragment


class MainActivity : AppCompatActivity() {
    private lateinit var viewPager : ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.view_pager)
        tabs = findViewById<TabLayout>(R.id.tabs)

        setAppBarHeight()

        val btnSubmit: Button = findViewById(R.id.btn_submit)

        setAdapters()

        btnSubmit.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }

    private fun setAppBarHeight() {
        val appBarLayout: AppBarLayout = findViewById(R.id.apppbar)
        appBarLayout.layoutParams = CoordinatorLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight() + dpToPx(48 + 56)
        )
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources
            .displayMetrics
            .density
        return Math.round(dp.toFloat() * density)
    }

    private fun setAdapters() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LearningLeadersFragment(), "Learning Leaders")
        adapter.addFragment(SkillIQFragment(), "Skill IQ Leaders")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}