package com.sun.databindingmvvm.view

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sun.databindingmvvm.R
import com.sun.databindingmvvm.databinding.ActivityMainBinding
import com.sun.databindingmvvm.model.Employee


class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null
    private var employeeDataAdapter: EmployeeDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        // bind RecyclerView
        val recyclerView: RecyclerView = activityMainBinding.viewEmployees
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        employeeDataAdapter = EmployeeDataAdapter()
        recyclerView.adapter = employeeDataAdapter
        getAllEmployee()
    }

    private fun getAllEmployee() {
        mainViewModel!!.allEmployee.observe(
            this,
            object : Observer<List<Employee?>?> {
                override fun onChanged(@Nullable employees: List<Employee?>?) {
                    employeeDataAdapter!!.setEmployeeList(employees as ArrayList<Employee>?)
                }
            })
    }
}