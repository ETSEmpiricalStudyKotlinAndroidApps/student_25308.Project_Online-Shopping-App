package ie.dorset.student_25308.onlineshoppingapp_finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_25308.onlineshoppingapp_finalproject.models.OrderHistory


class MyCartAdapter (private val info: Array<OrderHistory>, private val context: Context): RecyclerView.Adapter<myOrdersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myOrdersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_mycart, parent, false)
        return myOrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: myOrdersViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}
class myOrdersViewHolder(v : View) :RecyclerView.ViewHolder(v){

}