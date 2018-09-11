package apextechies.getmobilez.fragment

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import apextechies.getmobilez.R
import apextechies.getmobilez.alliterface.OnItemClick
import apextechies.getmobilez.model.BannerImageModel
import apextechies.pos.adapter.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_product.*

class ProductFragment: Fragment() {

    var list = ArrayList<BannerImageModel>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_product,container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWidgit()
    }

    private fun initWidgit() {

        productRV.layoutManager= GridLayoutManager(activity, 2)

        list.add(BannerImageModel("0",""))
        list.add(BannerImageModel("0",""))
        list.add(BannerImageModel("0",""))
        list.add(BannerImageModel("0",""))
        list.add(BannerImageModel("0",""))
        list.add(BannerImageModel("0",""))
        productRV.adapter = ProductListAdapter(activity, list, object : OnItemClick {
            override fun onClick(pos: Int) {

            }
        })
    }
}