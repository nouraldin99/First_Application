package user.nourstore.firstapplication.view.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import user.nourstore.firstapplication.R
import user.nourstore.firstapplication.databinding.ViewPagerContainerBinding
import user.nourstore.firstapplication.model.PhotoModel

class PhotoAdapter(private val photoModelList: List<PhotoModel>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(ViewPagerContainerBinding.inflate(LayoutInflater.from(parent.context),parent , false)
            )

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoModelList[position])
    }

    override fun getItemCount(): Int {
        return photoModelList.size
    }


    inner class PhotoViewHolder(val binding: ViewPagerContainerBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(photo: PhotoModel) {
            binding.apply {
                imageSliding.setImageBitmap(photo.photoImg)
                title.setText(photo.title)
                subTitle.setText(photo.subtitle)
            }

        }
    }

}