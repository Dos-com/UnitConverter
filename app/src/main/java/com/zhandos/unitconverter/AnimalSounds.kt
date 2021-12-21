package com.zhandos.unitconverter

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log
import java.io.IOException
import java.lang.Exception


private const val TAG = "AnimalSounds"
private const val ACCENTOR_SOUNDS_FOLDER = "Accentor"
private const val BEAR_SOUNDS_FOLDER = "Bear"
private const val BLACKBIRD_SOUNDS_FOLDER = "Blackbird"
private const val CAT_SOUNDS_FOLDER = "Cat"
private const val CHICKEN_SOUNDS_FOLDER = "Chicken"
private const val COBRA_SOUNDS_FOLDER = "Cobra"
private const val COW_SOUNDS_FOLDER = "Cow"
private const val CROCODILE_SOUNDS_FOLDER = "Crocodile"
private const val CROW_SOUNDS_FOLDER = "Crow"
private const val DOG_SOUNDS_FOLDER = "Dog"
private const val DOLPHIN_SOUNDS_FOLDER = "Dolphin"
private const val ELEPHANT_SOUNDS_FOLDER = "Elephant"
private const val FROG_SOUNDS_FOLDER = "Frog"
private const val HORSE_SOUNDS_FOLDER = "Horse"
private const val LION_SOUNDS_FOLDER = "Lion"
private const val MONKEY_SOUNDS_FOLDER = "Monkey"
private const val OWL_SOUNDS_FOLDER = "Owl"
private const val PIG_SOUNDS_FOLDER = "Pig"
private const val SHEEP_SOUNDS_FOLDER = "Sheep"
private const val SPARROW_SOUNDS_FOLDER = "Sparrow"
private const val TIGER_SOUNDS_FOLDER = "Tiger"
private const val MAX_SOUNDS = 1

class AnimalSounds(private val assets: AssetManager, private val animalName:String, private val animalArray: Array<String>) {
    val sound: List<Sound>
    private val soundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()

    init {
        sound = loadSounds()
    }

    private fun loadSounds(): List<Sound>{
        val soundNames: Array<String>
        try {
            when(animalName){
                animalArray[0] -> soundNames = assets.list(ACCENTOR_SOUNDS_FOLDER)!!
                animalArray[1] -> soundNames = assets.list(BEAR_SOUNDS_FOLDER)!!
                animalArray[2] -> soundNames = assets.list(BLACKBIRD_SOUNDS_FOLDER)!!
                animalArray[3] -> soundNames = assets.list(CAT_SOUNDS_FOLDER)!!
                animalArray[4] -> soundNames = assets.list(CHICKEN_SOUNDS_FOLDER)!!
                animalArray[5] -> soundNames = assets.list(COBRA_SOUNDS_FOLDER)!!
                animalArray[6] -> soundNames = assets.list(COW_SOUNDS_FOLDER)!!
                animalArray[7] -> soundNames = assets.list(CROCODILE_SOUNDS_FOLDER)!!
                animalArray[8] -> soundNames = assets.list(CROW_SOUNDS_FOLDER)!!
                animalArray[9] -> soundNames = assets.list(DOG_SOUNDS_FOLDER)!!
                animalArray[10] -> soundNames = assets.list(DOLPHIN_SOUNDS_FOLDER)!!
                animalArray[11] -> soundNames = assets.list(ELEPHANT_SOUNDS_FOLDER)!!
                animalArray[12] -> soundNames = assets.list(FROG_SOUNDS_FOLDER)!!
                animalArray[13] -> soundNames = assets.list(HORSE_SOUNDS_FOLDER)!!
                animalArray[14] -> soundNames = assets.list(LION_SOUNDS_FOLDER)!!
                animalArray[15] -> soundNames = assets.list(MONKEY_SOUNDS_FOLDER)!!
                animalArray[16] -> soundNames = assets.list(OWL_SOUNDS_FOLDER)!!
                animalArray[17] -> soundNames = assets.list(PIG_SOUNDS_FOLDER)!!
                animalArray[18] -> soundNames = assets.list(SHEEP_SOUNDS_FOLDER)!!
                animalArray[19] -> soundNames = assets.list(SPARROW_SOUNDS_FOLDER)!!
                animalArray[20] -> soundNames = assets.list(TIGER_SOUNDS_FOLDER)!!
                else -> soundNames = arrayOf()
            }
        }
        catch (e: Exception){
            Log.e(TAG, "Could not list assets", e)
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundNames.forEach { fileName ->
            var assetPath = "$ACCENTOR_SOUNDS_FOLDER/$fileName"

            when(animalName){
                animalArray[0] -> assetPath = "$ACCENTOR_SOUNDS_FOLDER/$fileName"
                animalArray[1] -> assetPath = "$BEAR_SOUNDS_FOLDER/$fileName"
                animalArray[2] -> assetPath = "$BLACKBIRD_SOUNDS_FOLDER/$fileName"
                animalArray[3] -> assetPath = "$CAT_SOUNDS_FOLDER/$fileName"
                animalArray[4] -> assetPath = "$CHICKEN_SOUNDS_FOLDER/$fileName"
                animalArray[5] -> assetPath = "$COBRA_SOUNDS_FOLDER/$fileName"
                animalArray[6] -> assetPath = "$COW_SOUNDS_FOLDER/$fileName"
                animalArray[7] -> assetPath = "$CROCODILE_SOUNDS_FOLDER/$fileName"
                animalArray[8] -> assetPath = "$CROW_SOUNDS_FOLDER/$fileName"
                animalArray[9] -> assetPath = "$DOG_SOUNDS_FOLDER/$fileName"
                animalArray[10] -> assetPath = "$DOLPHIN_SOUNDS_FOLDER/$fileName"
                animalArray[11] -> assetPath = "$ELEPHANT_SOUNDS_FOLDER/$fileName"
                animalArray[12] -> assetPath = "$FROG_SOUNDS_FOLDER/$fileName"
                animalArray[13] -> assetPath = "$HORSE_SOUNDS_FOLDER/$fileName"
                animalArray[14] -> assetPath = "$LION_SOUNDS_FOLDER/$fileName"
                animalArray[15] -> assetPath = "$MONKEY_SOUNDS_FOLDER/$fileName"
                animalArray[16] -> assetPath = "$OWL_SOUNDS_FOLDER/$fileName"
                animalArray[17] -> assetPath = "$PIG_SOUNDS_FOLDER/$fileName"
                animalArray[18] -> assetPath = "$SHEEP_SOUNDS_FOLDER/$fileName"
                animalArray[19] -> assetPath = "$SPARROW_SOUNDS_FOLDER/$fileName"
                animalArray[20] -> assetPath = "$TIGER_SOUNDS_FOLDER/$fileName"
            }
            val sound = Sound(assetPath)

            try {
                load(sound)
                sounds.add(sound)
            } catch (ioe: IOException){
                Log.e(TAG, "Can't load sound $fileName", ioe)
            }

        }



        return sounds
    }

    private fun load(sound: Sound){
        val afd : AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }
    fun play(sound: Sound){
        sound.soundId?.let {
            soundPool.play(it,1.0f,1.0f,1,0,1.0f)
        }
    }

    fun release(){
        soundPool.release()
    }
}