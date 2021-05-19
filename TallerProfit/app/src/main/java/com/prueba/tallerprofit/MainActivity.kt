package com.prueba.tallerprofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.prueba.tallerprofit.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: ArticleAdapter
    private val articleList = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchNews.setOnQueryTextListener(this)
        initRecyclerView()
        searchNew("general","us")

        binding.btnUSA.setOnClickListener(){
            searchNew("general", "us")
        }
        binding.btnRusia.setOnClickListener(){
            searchNew("general", "ru")
        }
        binding.btnMex.setOnClickListener(){
            searchNew("general", "mx")
        }
        binding.btnJapan.setOnClickListener(){
            searchNew("general", "jp")
        }
        binding.btnFrance.setOnClickListener(){
            searchNew("general", "fr")
        }
        binding.btnHealth.setOnClickListener(){
            searchNew("health", "us")
        }
        binding.btnTech.setOnClickListener(){
            searchNew("technology", "us")
        }
        binding.btnSports.setOnClickListener(){
            searchNew("sports", "us")
        }
        binding.btnScience.setOnClickListener(){
            searchNew("science", "us")
        }
        binding.btnEnter.setOnClickListener(){
            searchNew("entertainment", "us")
        }
    }

    private fun initRecyclerView(){

        adapter = ArticleAdapter(articleList)
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter

    }

    private fun searchNew(category: String, country:String){
        val api = Retrofit2()

        CoroutineScope(Dispatchers.IO).launch {

            val call = api.getService()?.getNewsByCategory(country,category,"4b94054dbc6b4b3b9e50d8f62cde4f6c")
            val news: NewsResponse? = call?.body()

            runOnUiThread {
                if(call!!.isSuccessful) {
                    if (news?.status.equals("ok")) {
                        val article = news?.articles ?: emptyList()
                        articleList.clear()
                        articleList.addAll(article)
                        adapter.notifyDataSetChanged()
                    }else{
                        showMessage("Error On Webservice")
                    }
                }else{
                    showMessage("Error On Webservice")
                }
                hideKeyBoard()
            }

        }
    }

    private fun hideKeyBoard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }


    private fun showMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchNew(query.toLowerCase(), query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}