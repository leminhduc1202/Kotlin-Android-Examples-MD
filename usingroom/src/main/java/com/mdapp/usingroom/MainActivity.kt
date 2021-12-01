package com.mdapp.usingroom

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.mdapp.usingroom.adapters.MyAdapter
import com.mdapp.usingroom.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        lateinit var database: MyDataBase
        val log: Logger = Logger.getLogger(MainActivity::class.java.name)
    }

    lateinit var superheroList: List<SuperHero>

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(this, MyDataBase::class.java, "room-db").build()

        val superhero1 = SuperHero("SpiderMan", "Marvel", "WEB")
        val superhero2 = SuperHero("SuperMan", "DC", "KRYPTONITE")
        val superhero3 = SuperHero("BatMan", "DC", "MONEY")

        doAsync {
            database.superheroDao().insert(superhero1)
            database.superheroDao().insert(superhero2)
            database.superheroDao().insert(superhero3)
            superheroList = database.superheroDao().getAllHeroes()

            runOnUiThread {
                log.info("DATA$superheroList")
                binding.superheroListRecyclerView.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
                binding.superheroListRecyclerView.adapter =
                    MyAdapter(applicationContext, superheroList)
            }
        }
    }
}