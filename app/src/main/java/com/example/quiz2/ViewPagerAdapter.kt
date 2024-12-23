package com.example.quiz2
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(context: Context, private val fragments: List<Fragment>, private val fragmentTitles: List<String>) :
    FragmentStateAdapter(context as AppCompatActivity) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    // Optional: Override getPageTitle to show titles in TabLayout
    fun getPageTitle(position: Int): CharSequence {
        return fragmentTitles[position]
    }
}
