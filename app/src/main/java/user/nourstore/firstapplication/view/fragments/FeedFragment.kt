package user.nourstore.firstapplication.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import user.nourstore.firstapplication.R
import user.nourstore.firstapplication.model.PhotoModel
import user.nourstore.firstapplication.view.fragments.adapters.PhotoAdapter
import user.nourstore.firstapplication.viewmodel.FeedViewModel
import kotlin.math.abs

class FeedFragment : Fragment(), FeedViewModel.PhotosInterface {

    private val viewModel = FeedViewModel(this)
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPhoto()


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)

    }


    override fun onPhotosLoaded(list: List<PhotoModel>) {
        val uiHandler = Handler(Looper.getMainLooper())
        uiHandler.post {
            photoAdapter = PhotoAdapter(list)
            setupViewPager()

        }
    }

    private fun setupViewPager() {

        val slidingViewPager2 = view?.findViewById<ViewPager2>(R.id.view_pager_photo)
        slidingViewPager2?.adapter = photoAdapter
        slidingViewPager2?.clipToPadding = false
        slidingViewPager2?.clipChildren = false
        slidingViewPager2?.offscreenPageLimit = 3
        slidingViewPager2?.getChildAt(0)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                val r: Float = 1 - abs(position)
                page.scaleY = .85f + r * 0.15f

            }
        })

        slidingViewPager2?.setPageTransformer(compositePageTransformer)

    }


}




