package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Category
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Products


class CategoriesAdapter(private val info: ArrayList<Category>): RecyclerView.Adapter<CategoriesViewHolder>(){

    private lateinit var mListener : onItemClickListener



    interface  onItemClickListener {

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener


    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val categoriesRow = layoutInflater.inflate(R.layout.recycler_categories, parent, false)
            return CategoriesViewHolder(categoriesRow, mListener)
        }

        override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

         // val currentItem  =categoryTitle[position]
         //val cat =holder.itemView.findViewById<TextView>(R.id.title_product)
           // cat.text =currentItem.toString()

            val currentItem = info[position]
            holder.heading.text =currentItem.heading



        }

        override fun getItemCount(): Int {
            //return categoryTitle.count()
            return info.size


        }

}


    class CategoriesViewHolder( v : View ,listener: CategoriesAdapter.onItemClickListener) : RecyclerView.ViewHolder(v){

        val heading : TextView = itemView.findViewById(R.id.title_product)

        init{
                itemView.setOnClickListener {
                    listener.onItemClick(adapterPosition)
                }
        }
    }

