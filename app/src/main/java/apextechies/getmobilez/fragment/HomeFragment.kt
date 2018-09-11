package apextechies.getmobilez.fragment

import android.annotation.SuppressLint
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apextechies.getmobilez.R
import apextechies.getmobilez.activity.ProductDetailsActivity
import apextechies.getmobilez.adapter.CustomPagerAdapter
import apextechies.getmobilez.adapter.DotsAdapter
import apextechies.getmobilez.alliterface.OnItemClick
import apextechies.getmobilez.model.BannerImageModel
import kotlinx.android.synthetic.main.fragment_home.*

@SuppressLint("ValidFragment")
class HomeFragment: Fragment {
    var onItemClick: OnItemClick?= null
    constructor(onItemClick: OnItemClick){
        this.onItemClick = onItemClick;
    }

    private var previousPage: Int = 0
    private var dotsAdapter: DotsAdapter? = null
    private var mCustomPagerAdapter: CustomPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWidgit()
        getData()
    }

    private fun getData() {
        var models = ArrayList<BannerImageModel>()
//        for (i in models.indices) {
//        }
        models.add(BannerImageModel("1", "https://poorvikamobiles01.files.wordpress.com/2016/12/poorvika-logo1.jpg"))
        models.add(BannerImageModel("2", "https://www.livechennai.com/images/Mobile_offer_2017.jpg"))
        models.add(BannerImageModel("3", "https://s1.poorvikamobile.com/image/cache/data/Banner/Home%20Page%20Banner/new/Trends/Apple/iPhone-offer-1600x450.jpg"))

        mCustomPagerAdapter = CustomPagerAdapter()

        mCustomPagerAdapter!!.setData(models, activity, this@HomeFragment)
        mCustomPagerAdapter!!.isDynamic(true)
        mCustomPagerAdapter!!.setVP(pager_zoom)
        pager_zoom.adapter = mCustomPagerAdapter
        if (models.size > 1) {
            dots.setHasFixedSize(true)
            dots.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            dotsAdapter = DotsAdapter(models.size)
            dots.adapter = dotsAdapter
        }


    }

    private fun initWidgit() {

        firstmobile.setOnClickListener {
            startActivity(Intent(activity, ProductDetailsActivity::class.java))
        }
        secondProduct.setOnClickListener {
            onItemClick!!.onClick(0)
        }

            pager_zoom.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageSelected(position: Int) {
                    Log.e("onPageSelected", "position $position")
                    try {
                        if (previousPage != position) {
                            dotsAdapter!!.setSelected(position)
                            dotsAdapter!!.notifyDataSetChanged()
                        }
                        previousPage = position
                    } catch (e: NullPointerException) {
                        e.printStackTrace()
                    }

                }

                override fun onPageScrollStateChanged(state: Int) {
                    Log.e("onScrollStateChanged", "state $state")
                }
            })
    }
}