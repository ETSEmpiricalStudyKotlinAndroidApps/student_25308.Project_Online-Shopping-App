package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Products
import kotlinx.android.synthetic.main.recycler_products.*

class ProductsAdapter (private val info: Array<Products>, private val context: Context): RecyclerView.Adapter<ProductsViewHolder>(){
   // private val picasso = Picasso.get()

    private lateinit var mListener: onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener =listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_products, parent, false)
        return ProductsViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {

        val info = info[position]
        val title =holder.itemView.findViewById<TextView>(R.id.texttest_textView)
        val id =holder.itemView.findViewById<TextView>(R.id.id_textV)
        val image =holder.itemView.findViewById<ImageView>(R.id.productAvatar_imageView)
        title.text = info.title
        id.text =info.id.toString()

       Picasso.get().load(info.image).placeholder(getDrawable(context, R.drawable.ic_baseline_error_outline_24)!!).error(
           getDrawable(context, R.drawable.ic_baseline_error_outline_24)!!).memoryPolicy(
            MemoryPolicy.NO_CACHE).into(image)

        /*
       holder.itemView.findViewById<TextView>(R.id.title_product).text = info.title
        holder.itemView.findViewById<TextView>(R.id.id_textView2).text =info.id.toString()
        holder.itemView.findViewById<TextView>(R.id.price_textView).text =info.price.toString()
        holder.itemView.findViewById<TextView>(R.id.description_textView).text=info.description
        holder.itemView.findViewById<TextView>(R.id.category_product_textView).text=info.category
        holder.itemView.findViewById<TextView>(R.id.rate_TextView).text="add"
        holder.itemView.findViewById<TextView>(R.id.count_TextView).text= "0.00"


   */

    }




    override fun getItemCount(): Int {
        return info.size


    }


}


class ProductsViewHolder( v :View , listener: ProductsAdapter.onItemClickListener) :RecyclerView.ViewHolder(v){
 init{
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)

        }
 }
}



