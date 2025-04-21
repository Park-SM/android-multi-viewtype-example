package com.smparkworld.feature.mypage.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.smparkworld.common.base.extensions.collectAt
import com.smparkworld.feature.mypage.ui.base.MyPageViewType
import com.smparkworld.feature.mypage.ui.base.addItemDecorations
import com.smparkworld.feature.mypage.R
import com.smparkworld.feature.mypage.databinding.ActivityMyPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyPageBinding

    private val vm: MyPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_page)
        binding.lifecycleOwner = this

        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val binders = MyPageViewType.createViewBinders()
        binding.sections.adapter = MyPageAdapter(binders)
        binding.sections.addItemDecorations(binders)
    }

    private fun initObservers() {
        vm.title.collectAt(this) { title ->
            binding.title.text = title
        }
        vm.items.collectAt(this) { items ->
            (binding.sections.adapter as? MyPageAdapter)?.submitList(items)
        }
    }
}