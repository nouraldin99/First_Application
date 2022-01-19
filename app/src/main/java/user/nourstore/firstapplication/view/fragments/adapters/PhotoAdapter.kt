package user.nourstore.firstapplication.view.fragments.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import user.nourstore.firstapplication.R
import user.nourstore.firstapplication.databinding.ViewPagerContainerBinding
import user.nourstore.firstapplication.model.PhotoModel

class PhotoAdapter(private val photoModelList: MutableList<PhotoModel> ,private val viewPager: ViewPager2?) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(ViewPagerContainerBinding.inflate(LayoutInflater.from(parent.context),parent , false)
            )

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoModelList[position])
        if (position == photoModelList.size - 1){
            viewPager?.post(runnable)
        }
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

    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        photoModelList.addAll(photoModelList)
        notifyDataSetChanged()
    }




}