package joseantoniovaliente.ejercicio4fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import joseantoniovaliente.ejercicio4fragments.databinding.ViewElementBinding

class ElementAdapter(val elements:List<Element>,
                     val listener:(Element)->Unit):
    RecyclerView.Adapter<ElementAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_element,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(elements[position])
        holder.itemView.setOnClickListener {
            listener(elements[position])
        }
    }

    override fun getItemCount()=elements.size

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding=ViewElementBinding.bind(view)
        fun bind(element: Element){

            Glide.with(binding.imageElement).load(element.image).into(binding.imageElement)
            binding.name.text=element.name
        }
    }

}