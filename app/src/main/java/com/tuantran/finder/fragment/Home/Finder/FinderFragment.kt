package com.tuantran.finder.fragment.Home.Finder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.tuantran.finder.R
import com.tuantran.finder.databinding.FragmentFinderBinding
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.fragment_finder.*
import kotlin.math.log


class FinderFragment : Fragment(),CardStackListener {

    private lateinit var binding : FragmentFinderBinding
    private val manager by lazy { CardStackLayoutManager(activity, this) }
    private val adapter by lazy { CardStackAdapter(createSpots()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentFinderBinding.inflate(layoutInflater)
        setupCardStackView()
        setupButton()
        return binding.root

    }

    override fun onCardDragging(direction: Direction, ratio: Float) {
        Log.d("CardStackView", "onCardDragging: d = ${direction.name}, r = $ratio")
    }

    override fun onCardSwiped(direction: Direction) {
        Log.d("CardStackView", "onCardSwiped: p = ${manager.topPosition}, d = $direction")
        if (manager.topPosition == adapter.itemCount - 5) {
            paginate()
        }
    }

    override fun onCardRewound() {
        Log.d("CardStackView", "onCardRewound: ${manager.topPosition}")
    }

    override fun onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled: ${manager.topPosition}")
    }

    override fun onCardAppeared(view: View, position: Int) {
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardAppeared: ($position) ${textView.text}")
    }

    override fun onCardDisappeared(view: View, position: Int) {
        val textView = view.findViewById<TextView>(R.id.item_name)
        Log.d("CardStackView", "onCardDisappeared: ($position) ${textView.text}")
    }


    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        binding.cardStackView.layoutManager = manager
        binding.cardStackView.adapter = adapter
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false


            }
        }
    }
    //CardStackLayoutManager(this@FinderFragment.requireContext(), this)

    private fun setupButton() {

        binding.skipButton.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
            Log.d("AAA","Không Thích")

        }


        binding.rewindButton.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            binding.cardStackView.rewind()
            Log.d("AAA","Hồi Lại")

        }


        binding.likeButton.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.cardStackView.swipe()
            Log.d("AAA","Thích")

        }
    }
    //onCardSwipe



    private fun paginate() {
        val old = adapter.getSpots()
        val new = old.plus(createSpots())
        val callback = SpotDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setSpots(new)
        result.dispatchUpdatesTo(adapter)
    }

    private fun createSpots(): List<User> {
        val spots = ArrayList<User>()
        spots.add(User(age = 18, name =  "Yasaka Shrine", city = "Kyoto", image = R.drawable.sample1))
        spots.add(User(age = 18,name = "Fushimi Inari Shrine", city = "Kyoto", image = R.drawable.sample2))
        spots.add(User(age = 18,name = "Bamboo Forest", city = "Kyoto", image = R.drawable.sample3))
        spots.add(User(age = 18,name = "Brooklyn Bridge", city = "New York", image = R.drawable.sample4))
        spots.add(User(age = 18,name = "Empire State Building", city = "New York", image = R.drawable.sample5))
        spots.add(User(age = 18,name = "The statue of Liberty", city = "New York", image = R.drawable.sample1))
        spots.add(User(age = 18,name = "Louvre Museum", city = "Paris", image = R.drawable.sample2))
        spots.add(User(age = 18,name = "Eiffel Tower", city = "Paris", image = R.drawable.sample3))
        spots.add(User(age = 18,name = "Big Ben", city = "London", image = R.drawable.sample4))
        spots.add(User(age = 18,name = "Great Wall of China", city = "China", image = R.drawable.sample5))
        return spots
    }


}



