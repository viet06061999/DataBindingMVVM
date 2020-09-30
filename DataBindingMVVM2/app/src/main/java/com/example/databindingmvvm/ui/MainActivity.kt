package com.example.databindingmvvm.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.databindingmvvm.R
import com.example.databindingmvvm.utils.createProgressDialog
import com.sun.databindingmvvm.view.EmployeeDataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private val employeeDataAdapter = EmployeeDataAdapter {
        Toast.makeText(this, it.lastName, Toast.LENGTH_LONG).show()
    }
    private val progressBar by lazy {
        createProgressDialog()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewEmployees.adapter = employeeDataAdapter
        mainViewModel.isLoading.observe(this, Observer {
            if (it) progressBar.show() else progressBar.dismiss()
        })
        mainViewModel.allEmployee.observe(this, Observer {
            employeeDataAdapter.setEmployeeList(it)
        })
    }
}