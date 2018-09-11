package apextechies.getmobilez.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import apextechies.getmobilez.R
import apextechies.getmobilez.adapter.CustomPagerAdapter
import apextechies.getmobilez.adapter.DotsAdapter
import apextechies.getmobilez.model.BannerImageModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var previousPage: Int = 0
    private var dotsAdapter: DotsAdapter? = null
    private var mCustomPagerAdapter: CustomPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainRV.layoutManager = LinearLayoutManager(this)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        getData()
        initWidget()

        firstmobile.setOnClickListener {
            startActivity(Intent(this@MainActivity,ProductDetailsActivity::class.java))
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
        models.add(BannerImageModel("1", "https://poorvikamobiles01.files.wordpress.com/2016/12/poorvika-logo1.jpg"))
        models.add(BannerImageModel("2", "https://www.livechennai.com/images/Mobile_offer_2017.jpg"))
        models.add(BannerImageModel("3", "https://s1.poorvikamobile.com/image/cache/data/Banner/Home%20Page%20Banner/new/Trends/Apple/iPhone-offer-1600x450.jpg"))

        mCustomPagerAdapter = CustomPagerAdapter()

        mCustomPagerAdapter!!.setData(models, this@MainActivity, this@MainActivity)
        mCustomPagerAdapter!!.isDynamic(true)
        mCustomPagerAdapter!!.setVP(pager_zoom)
        pager_zoom.adapter = mCustomPagerAdapter
        if (models.size > 1) {
            dots.setHasFixedSize(true)
            dots.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            dotsAdapter = DotsAdapter(models.size)
            dots.adapter = dotsAdapter
        }



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



}