package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.Order
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.OrderHistory


class OrdersHistoryAdapter(private val orders: Array<OrderHistory>, private val context: Context): RecyclerView.Adapter<OrdersViewHolder>() {

    private lateinit var mListener2: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener2 =listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_orders_history, parent, false)
        return OrdersViewHolder(view,mListener2)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {

        val orders = orders[position]

        val quantityO =holder.itemView.findViewById<TextView>(R.id.quantityOrder)
       val productIDo = holder.itemView.findViewById<TextView>(R.id.productId_order)
       // val idO = holder.itemView.findViewById<TextView>(R.id.idOrder)
       // val userIDo = holder.itemView.findViewById<TextView>(R.id.userOrder)
       //val dateO =holder.itemView.findViewById<TextView>(R.id.dateOrder)

       quantityO.text= orders.orderH[position].products.quantity.toString()
       productIDo.text= orders.orderH[position].products.productId.toString()
      // idO.text= orders.id.toString()
     //  userIDo.text= orders.userId.toString()
     //  dateO.text= orders.date





    }

    override fun getItemCount(): Int {
        return orders.size

    }


}



class OrdersViewHolder(v : View, listener: OrdersHistoryAdapter.onItemClickListener) :RecyclerView.ViewHolder(v){
    init{
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)

        }
    }
    }
