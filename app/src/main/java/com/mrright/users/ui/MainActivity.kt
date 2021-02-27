package com.mrright.users.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrright.users.adapters.UserAdapter
import com.mrright.users.databinding.ActivityMainBinding
import com.mrright.users.models.User
import com.mrright.users.utils.*
import com.mrright.users.viewmodels.UserStateViewModel
import com.mrright.users.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
private val LOG = MainActivity::class.java.simpleName

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    private val userViewModel by viewModels<UserViewModel>()

    private lateinit var userAdapter: UserAdapter

    private var id: Int? = null
    private var name: String? = null
    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnDelete.gone()
        bind.progress.gone()

        usersObserver()

        btnClicks()

    }

    private fun btnClicks() {

        bind.btnSave.setOnClickListener {

            lifecycleScope.launchWhenStarted {

                bind.progress.visible()

                delay(2000L)
                assignValues()

                if (id == null) {
                    val user =
                        User(name = name!!, age = age!!)
                    ToastShort("Inserted ${userViewModel.insert(user)}")
                    assignNull()
                } else {
                    val user = User(id!!, name!!, age!!)
                    ToastShort("Updated ${userViewModel.update(user)}")
                    assignNull()
                    bind.btnDelete.gone()
                }


                bind.progress.gone()
            }
        }

        bind.btnDelete.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                assignValues()
                ToastShort("Deleted : ${userViewModel.delete(User(id!!, name!!, age!!))}")
                assignNull()
                bind.btnDelete.gone()
            }
        }

    }

    private fun assignValues() {
        name = bind.etUserName.text.toString()
        age = bind.etAge.text.toString().toInt()
    }

    private fun assignNull() {
        id = null
        name = null
        age = null
        bind.etUserName.text = null
        bind.etAge.text = null
    }

    private fun usersObserver() {

        userViewModel.users.observe(this, {

            userAdapter = UserAdapter(it) { user ->
                id = user.id
                bind.etUserName.setText(user.name)
                bind.etAge.setText(user.age.toString())
                bind.btnDelete.visible()
            }
            bind.rvUsers.apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
                userAdapter.notifyDataSetChanged()
            }

        })


    }
}

















