package com.sirdave.alcleaderboard.activities

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
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
        tabs = findViewById(R.id.tabs)

        setAdapters()
    }

    private fun setAdapters() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LearningLeadersFragment(), "Learning Leaders")
        adapter.addFragment(SkillIQFragment(), "Skill IQ Leaders")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}