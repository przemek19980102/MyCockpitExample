package com.example.cockpitexample

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.polidea.cockpit.cockpit.Cockpit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupGeneral()
        setupCockpitButton()
        setupHeader()
        setupSubheader()
        setupGhosts()

        Cockpit.addForeverClearChangesActionRequestCallback {
            Toast.makeText(this, "MIAŁO SIE USUNĄC ALE SIE NIE DA!", Toast.LENGTH_SHORT).show()
        }
    }

    fun setupGeneral() {
        app_bg.setBackgroundColor(Color.parseColor(Cockpit.getBackgroundColor()))
        Cockpit.addForeverOnBackgroundColorChangeListener { oldValue, newValue ->
            app_bg.setBackgroundColor(Color.parseColor(newValue))
        }

        header_bg.setBackgroundColor(Color.parseColor(Cockpit.getHeaderBackgroundColor()))
        Cockpit.addForeverOnHeaderBackgroundColorChangeListener { oldValue, newValue ->
            header_bg.setBackgroundColor(Color.parseColor(newValue))
        }

        val ghost1Visible = Cockpit.isGhost1Visible()
        view.isVisible = ghost1Visible
        view.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
        view2.isVisible = ghost1Visible
        view2.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
        view3.isVisible = ghost1Visible
        view3.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))


        val ghost2Visible = Cockpit.isGhost2Visible()
        view5.isVisible = ghost2Visible
        view5.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
        view6.isVisible = ghost2Visible
        view6.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
        view7.isVisible = ghost2Visible
        view7.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))

        Cockpit.addForeverOnGhostColorChangeListener { oldValue, newValue ->
            view.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
            view2.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
            view3.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
            view5.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
            view6.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
            view7.setBackgroundColor(Color.parseColor(Cockpit.getGhostColor()))
        }

        Cockpit.addForeverOnGhost1VisibleChangeListener { oldValue, newValue ->
            view.isVisible = newValue
            view2.isVisible = newValue
            view3.isVisible = newValue
        }

        Cockpit.addForeverOnGhost2VisibleChangeListener { oldValue, newValue ->
            view5.isVisible = newValue
            view6.isVisible = newValue
            view7.isVisible = newValue
        }
    }

    fun setupCockpitButton() {
        floatingActionButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(Cockpit.getFabColor()))
        Cockpit.addForeverOnFabColorChangeListener { oldValue, newValue ->
            floatingActionButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(newValue))
        }
        floatingActionButton.setOnClickListener {
            Cockpit.showCockpit(supportFragmentManager)
        }
    }

    fun setupHeader() {
        header_title.text = Cockpit.getHeaderText()
        header_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, Cockpit.getHeaderFontSize().toFloat())
        header_title.textAlignment = when (Cockpit.getHeaderTextAlignmentSelectedValue()) {
            "left" -> TextView.TEXT_ALIGNMENT_VIEW_START
            "right" -> TextView.TEXT_ALIGNMENT_VIEW_END
            else -> TextView.TEXT_ALIGNMENT_CENTER
        }
        header_title.isVisible = Cockpit.isHeaderVisible()
        Cockpit.addForeverOnHeaderTextChangeListener { oldValue, newValue ->
            header_title.text = newValue
        }
        Cockpit.addForeverOnHeaderFontSizeChangeListener { oldValue, newValue ->
            header_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, newValue.toFloat())
        }
        Cockpit.addForeverOnHeaderTextAlignmentChangeListener { oldValue, newValue ->
            header_title.textAlignment = when (newValue) {
                "left" -> TextView.TEXT_ALIGNMENT_VIEW_START
                "right" -> TextView.TEXT_ALIGNMENT_VIEW_END
                else -> TextView.TEXT_ALIGNMENT_CENTER
            }
        }
        Cockpit.addForeverOnHeaderVisibleChangeListener { oldValue, newValue ->
            header_title.isVisible = newValue
        }
    }

    fun setupSubheader() {
        header_subtitle.text = Cockpit.getSubheaderText()
        header_subtitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, Cockpit.getSubheaderFontSize().toFloat())
        header_subtitle.textAlignment = when (Cockpit.getHeaderTextAlignmentSelectedValue()) {
            "left" -> TextView.TEXT_ALIGNMENT_VIEW_START
            "right" -> TextView.TEXT_ALIGNMENT_VIEW_END
            else -> TextView.TEXT_ALIGNMENT_CENTER
        }
        header_subtitle.isVisible = Cockpit.isSubheaderVisible()
        Cockpit.addForeverOnSubheaderTextChangeListener { oldValue, newValue ->
            header_subtitle.text = newValue
        }
        Cockpit.addForeverOnSubheaderFontSizeChangeListener { oldValue, newValue ->
            header_subtitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, newValue.toFloat())
        }
        Cockpit.addForeverOnHeaderTextAlignmentChangeListener { oldValue, newValue ->
            header_subtitle.textAlignment = when (newValue) {
                "left" -> TextView.TEXT_ALIGNMENT_VIEW_START
                "right" -> TextView.TEXT_ALIGNMENT_VIEW_END
                else -> TextView.TEXT_ALIGNMENT_CENTER
            }
        }
        Cockpit.addForeverOnSubheaderVisibleChangeListener { oldValue, newValue ->
            header_subtitle.isVisible = newValue
        }
    }

    fun setupGhosts() {

    }
}
