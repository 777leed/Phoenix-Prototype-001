package com.example.firstprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstprototype.R
import com.example.firstprototype.User.Fm
import com.example.firstprototype.daos.PostDao
import com.example.firstprototype.models.Post
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_feed.*


class Feed : AppCompatActivity(), IPostAdapter {
    private lateinit var postDao:PostDao
    private lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        fab.setOnClickListener{
            val intent= Intent(this,create_post::class.java)
            startActivity(intent)
        }
        setUpRecyclerView()
    }
    private fun setUpRecyclerView(){
        postDao= PostDao()
        val postsCollections=postDao.postCollections
        val query=postsCollections.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOptions=FirestoreRecyclerOptions.Builder<Post>().setQuery(query,Post::class.java).build()

        adapter= PostAdapter(recyclerViewOptions,this)

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
    override fun onStart(){
        super.onStart()
        adapter.startListening()
    }
    override fun onStop(){
        super.onStop()
        adapter.stopListening()
    }

    override fun onLikeClicked(postId: String) {
        postDao.updateLikes(postId)
    }
}