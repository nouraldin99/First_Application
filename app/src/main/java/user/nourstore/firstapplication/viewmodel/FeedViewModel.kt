package user.nourstore.firstapplication.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import user.nourstore.firstapplication.R
import user.nourstore.firstapplication.model.PhotoModel
import java.net.URL
import kotlin.concurrent.thread

class FeedViewModel(val listener : PhotosInterface) {
    companion object {
        private const val TAG = "MainActivity"
        private const val IMAGE_URL =
            "https://devstorageacco.blob.core.windows.net/pre-prod/_NOR9450_22092019153631.jpg"

    }



    fun loadPhoto(){
        thread(start = true) {
            val bitmap = downloadBitmap(IMAGE_URL)
            val models: MutableList<PhotoModel> = ArrayList()

                models.add(PhotoModel(R.string.title, R.string.sub_title, photoImg = bitmap))
            models.add(PhotoModel(R.string.title, R.string.sub_title, photoImg = bitmap))

            listener.onPhotosLoaded(models)
        }
    }



    private fun downloadBitmap(imageUrl: String): Bitmap? {

        return try {
            val conn = URL(imageUrl).openConnection()
            conn.connect()
            val inputStream = conn.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            bitmap
        } catch (e: Exception) {
            Log.e(TAG, "Exception $e")
            null
        }
    }
    interface PhotosInterface{
        fun onPhotosLoaded (list:MutableList<PhotoModel>)
    }


}