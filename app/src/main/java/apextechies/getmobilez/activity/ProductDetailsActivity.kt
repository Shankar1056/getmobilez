package apextechies.getmobilez.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import apextechies.getmobilez.R
import apextechies.getmobilez.adapter.CustomPagerAdapter
import apextechies.getmobilez.adapter.DotsAdapter
import apextechies.getmobilez.adapter.ProductDetailsCustomPagerAdapter
import apextechies.getmobilez.model.BannerImageModel
import kotlinx.android.synthetic.main.activity_producttails.*

class ProductDetailsActivity : AppCompatActivity() {
    private var previousPage: Int = 0
    private var dotsAdapter: DotsAdapter? = null
    private var mCustomPagerAdapter: ProductDetailsCustomPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producttails)

        setSupportActionBar(toolbar)
//        actionBar.setDisplayShowHomeEnabled(true)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
        getData()
        initWidget()

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
    private fun initWidget() {
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

    private fun getData() {
        var models = ArrayList<BannerImageModel>()
//        for (i in models.indices) {
//        }
        models.add(BannerImageModel("1", "http://wooinvoice.webtoffee.com/wp-content/uploads/2018/01/hikeforce-mobile.jpg"))
        models.add(BannerImageModel("2", "https://teja9.kuikr.com/i6/20171228/VB201705171774173-ak_LWBP77997365-1514461008.jpeg"))
        models.add(BannerImageModel("3", "https://static.toiimg.com/photo/62900702/M-Tech-Foto3.jpg"))

        mCustomPagerAdapter = ProductDetailsCustomPagerAdapter()

        mCustomPagerAdapter!!.setData(models, this@ProductDetailsActivity, this@ProductDetailsActivity)
        mCustomPagerAdapter!!.isDynamic(true)
        mCustomPagerAdapter!!.setVP(pager_zoom)
        pager_zoom.adapter = mCustomPagerAdapter
        if (models.size > 1) {
            dots.setHasFixedSize(true)
            dots.layoutManager = LinearLayoutManager(this@ProductDetailsActivity, LinearLayoutManager.HORIZONTAL, false)
            dotsAdapter = DotsAdapter(models.size)
            dots.adapter = dotsAdapter
        }



    }
}