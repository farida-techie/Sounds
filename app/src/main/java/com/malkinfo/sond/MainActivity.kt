package com.malkinfo.sond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var alphaAdapter:AlphaBetAdapter
    private lateinit var mRecycler :RecyclerView
    private lateinit var numRecycler :RecyclerView
    private lateinit var vegRecycler :RecyclerView
    private lateinit var alphaList:ArrayList<AlphaBet>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set find id*/
        alphaList = ArrayList()
        mRecycler = findViewById(R.id.sRecycler)
        numRecycler = findViewById(R.id.numRecycler)
        vegRecycler = findViewById(R.id.vieRecycler)
        alphaAdapter = AlphaBetAdapter(this,alphaList)
        /**set alpha*/
        val layoutM = LinearLayoutManager(this)
        layoutM.orientation = LinearLayoutManager.HORIZONTAL
        mRecycler.layoutManager = layoutM
        mRecycler.adapter = alphaAdapter
        /**set Number*/
        val layoutMs = LinearLayoutManager(this)
        layoutMs.orientation = LinearLayoutManager.HORIZONTAL
        numRecycler.layoutManager = layoutMs
        numRecycler.adapter = alphaAdapter
        /**set Vegettable*/
        val layoutMss = LinearLayoutManager(this)
        layoutMss.orientation = LinearLayoutManager.HORIZONTAL
        vegRecycler.layoutManager = layoutMss
        vegRecycler.adapter = alphaAdapter
        alphaBetList()
    }

    private fun alphaBetList() {
        alphaList.add(AlphaBet(R.drawable.a,"A for Apple"))
        alphaList.add(AlphaBet(R.drawable.b,"B for Butterfly"))
        alphaList.add(AlphaBet(R.drawable.c,"C for Carrot"))
        alphaList.add(AlphaBet(R.drawable.d,"D for Duck"))
        alphaList.add(AlphaBet(R.drawable.e,"E for Eggplant"))
        alphaList.add(AlphaBet(R.drawable.f,"F for Fish"))
        alphaList.add(AlphaBet(R.drawable.g,"G for Gloves"))
        alphaList.add(AlphaBet(R.drawable.h,"H for Horse"))
        alphaList.add(AlphaBet(R.drawable.i,"I for Igloo"))
        alphaList.add(AlphaBet(R.drawable.j,"J for Jumping Rope"))
        alphaList.add(AlphaBet(R.drawable.k,"K for Key"))
        alphaList.add(AlphaBet(R.drawable.l,"L for Leaves"))
        alphaList.add(AlphaBet(R.drawable.m,"M for Mouse"))
        alphaList.add(AlphaBet(R.drawable.n,"N for  Nuts"))
        alphaList.add(AlphaBet(R.drawable.o,"O for Ostrich"))
        alphaList.add(AlphaBet(R.drawable.p,"P for Popcorn"))
        alphaList.add(AlphaBet(R.drawable.q,"Q for Quarter"))
        alphaList.add(AlphaBet(R.drawable.r,"R for Rabbit"))
        alphaList.add(AlphaBet(R.drawable.s,"S for Scissors"))
        alphaList.add(AlphaBet(R.drawable.t,"T for Tractor"))
        alphaList.add(AlphaBet(R.drawable.u,"U for Umbrella"))
        alphaList.add(AlphaBet(R.drawable.v,"V for Violin"))
        alphaList.add(AlphaBet(R.drawable.w,"W for Window"))
        alphaList.add(AlphaBet(R.drawable.x,"X for Xylophone"))
        alphaList.add(AlphaBet(R.drawable.y,"Y for Yak"))
        alphaList.add(AlphaBet(R.drawable.z,"z for zebra"))
    }
}