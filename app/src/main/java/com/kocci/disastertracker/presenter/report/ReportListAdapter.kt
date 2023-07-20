package com.kocci.disastertracker.presenter.report

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kocci.disastertracker.databinding.ItemReportCardBinding
import com.kocci.disastertracker.domain.model.Reports

class ReportListAdapter(
    private val data: List<Reports>
) : RecyclerView.Adapter<ReportListAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemReportCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Reports) {
            binding.tvReportTitle.text = data.title
            binding.tvReportBody.text = data.body
//            binding.textView3.text = binding.root.context.getString(R.string.date_show, data.date)
            binding.textView3.text = data.date

            Glide.with(binding.root).load(data.imgUrl).into(binding.imgReport)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemReportCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position]) // data
    }

    override fun getItemCount(): Int {
        return data.size
    }
}