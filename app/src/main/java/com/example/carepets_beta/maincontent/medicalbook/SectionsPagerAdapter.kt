package com.example.carepets_beta.maincontent.medicalbook

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.carepets_beta.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OverViewFragment()
            1 -> VaccinationFragment()
            else -> NoteFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return super.getPageTitle(position)
        var title: String = when (position) {
            0 -> "Overview"
            1 -> "Vaccination"
            else -> "Note"
        }
        return context.resources.getString(TAB_TITLES[position])
    }
}