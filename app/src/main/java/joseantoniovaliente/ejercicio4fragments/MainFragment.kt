package joseantoniovaliente.ejercicio4fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import joseantoniovaliente.ejercicio4fragments.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)


        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = ElementAdapter(elements) {
                    element->
                val gmmIntentUri = Uri.parse("geo:"+element.latitud+","+element.longitud)
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")

                    startActivity(mapIntent)

            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
    }

    private val elements =
        listOf(
            Element("Osaka", "34.69374", "135.50218", "https://loremflickr.com/320/240/osaka"),
            Element(
                "Islas Maldivas",
                "3.202778",
                "73.22068",
                "https://loremflickr.com/320/240/maldives"
            ),
            Element("Petra", "30.32096", "35.47895", "https://loremflickr.com/320/240/petra"),
            Element(
                "Bahía de Kotor",
                "42.42067",
                "18.76825",
                "https://loremflickr.com/320/240/kotor"
            ),
            Element("París", "48.85341", "2.3488", "https://loremflickr.com/320/240/paris"),
            Element("Venecia", "45.43713", "12.33265", "https://loremflickr.com/320/240/venice")
        )
}