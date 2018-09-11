package apextechies.pos.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import apextechies.getmobilez.R
import apextechies.getmobilez.alliterface.OnItemClick
import apextechies.getmobilez.model.BannerImageModel

class ProductListAdapter(private val context: Context, private val myCartModels: ArrayList<BannerImageModel>, private val onItemClick: OnItemClick) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var prodImage: ImageView
        var wishlist: ImageView
        var prodName: TextView
        var rating: TextView
        var selingprice: TextView
        var actualprice: TextView

        init {
            prodImage = view.findViewById<View>(R.id.prodImage) as ImageView
            wishlist = view.findViewById<View>(R.id.wishlist) as ImageView
            prodName = view.findViewById<View>(R.id.prodName) as TextView
            rating = view.findViewById<View>(R.id.rating) as TextView
            selingprice = view.findViewById<View>(R.id.selingprice) as TextView
            actualprice = view.findViewById<View>(R.id.actualprice) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragmentprouct_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sa = myCartModels!![position]

       /* holder.productIdValue.text = sa.id
        holder.productNameValue.text = sa.name
        holder.productPriceValue.text = sa.price*/

        holder.itemView.setOnClickListener {
            onItemClick.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return myCartModels!!.size
    }

}
