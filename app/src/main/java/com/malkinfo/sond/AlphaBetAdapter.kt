package com.malkinfo.sond

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class AlphaBetAdapter(val c:Context,val alphaList:ArrayList<AlphaBet>):
RecyclerView.Adapter<AlphaBetAdapter.AlphaViewHolder>()
{
    private lateinit var mTTs : TextToSpeech
    inner class AlphaViewHolder(val v:View):RecyclerView.ViewHolder(v){
        val alphaNeme = v.findViewById<TextView>(R.id.alphaName)
        val alphaImg = v.findViewById<ImageView>(R.id.alphaImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_alphabet,parent,false)
        return AlphaViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlphaViewHolder, position: Int) {
       val alphaBetList = alphaList[position]
        /**set Speech*/
        mTTs = TextToSpeech(c){ status->
            if (status == TextToSpeech.SUCCESS){
                val result = mTTs.setLanguage(Locale.ENGLISH)
                if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED){
                    Log.e("TTs","Language is not Supported")
                }else{
                    holder.v.isEnabled = true
                }
            }
            else{
                Log.e("TTs","Initialization failed")
            }
        }
        holder.alphaNeme.text = alphaBetList.name
        holder.alphaImg.setImageResource(alphaBetList.alphaImg)
        holder.v.setOnClickListener {
            speek(holder.alphaNeme)
            shoDialog(alphaBetList.alphaImg,alphaBetList.name)
        }
    }

    private fun shoDialog(img: Int, name: String) {
       val inflater = LayoutInflater.from(c)
        val setView = inflater.inflate(R.layout.activity_new,null)
        val alphaN = setView.findViewById<TextView>(R.id.alphaNames)
        val alphaIm = setView.findViewById<ImageView>(R.id.alphaImgs)
        val cancel = setView.findViewById<ImageView>(R.id.btnCancel)
        alphaIm.setImageResource(img)
        alphaN.text = name
        val bulider = AlertDialog.Builder(c)
        bulider.setView(setView)
        bulider.setCancelable(true)
        val shoDialog = bulider.create()
        cancel.setOnClickListener { shoDialog.dismiss() }


        shoDialog.show()

    }

    fun speek(alphaName:TextView){
        val text = alphaName.text.toString()
        val pitch = 1f

        val speed = 1.1f
        mTTs.setPitch(pitch)
        mTTs.setSpeechRate(speed)
        mTTs.speak(text, TextToSpeech.QUEUE_FLUSH,null)
    }

    override fun getItemCount(): Int {
       return alphaList.size
    }
}