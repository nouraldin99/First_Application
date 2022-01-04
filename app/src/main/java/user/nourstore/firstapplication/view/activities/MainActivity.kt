package user.nourstore.firstapplication.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import user.nourstore.firstapplication.R
import user.nourstore.firstapplication.databinding.ActivityMainBinding
import user.nourstore.firstapplication.view.fragments.DoingGoodFragment
import user.nourstore.firstapplication.view.fragments.FeedFragment
import user.nourstore.firstapplication.view.fragments.MyPreziFragment
import user.nourstore.firstapplication.view.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {


    private val feedFragment = FeedFragment()
    private val myPreziFragmentFragment = MyPreziFragment()
    private val profileFragment = ProfileFragment()
    private val doingGoodFragment = DoingGoodFragment()

    lateinit var binding:ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =  ActivityMainBinding.inflate(layoutInflater)

       setContentView(binding.root)

        replaceFragment(feedFragment)

       binding.bottomNavigationView.setOnItemSelectedListener { when (it.itemId){
           R.id.feed -> replaceFragment(feedFragment)
           R.id.doing_good -> replaceFragment(doingGoodFragment)
           R.id.my_prezi -> replaceFragment(myPreziFragmentFragment)
           R.id.profile -> replaceFragment(profileFragment)


       }
           return@setOnItemSelectedListener true
       }


   }


    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment , fragment)
            transaction.commit()
        }
    }



}