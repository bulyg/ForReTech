package ru.bulyg.forretech.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.bulyg.forretech.R
import ru.bulyg.forretech.mvp.presenter.adapter.SecondListPresenter
import ru.bulyg.forretech.mvp.view.item.SecondItemView

class SecondRVAdapter(val presenter: SecondListPresenter) :
    RecyclerView.Adapter<SecondRVAdapter.SecondViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SecondViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
    )

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()

    class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view), SecondItemView {
        private val factText = itemView.findViewById<TextView>(R.id.tv_item_fact)
        private val factDate = itemView.findViewById<TextView>(R.id.tv_item_date)

        override var pos = -1

        override fun setFact(text: String) {
            factText.text = text
        }

        override fun setDate(date: String) {
            factDate.text = date
        }
    }
}