package com.sun.databindingmvvm.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sun.databindingmvvm.model.Employee
import com.sun.databindingmvvm.network.EmployeeRepository


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val employeeRepository: EmployeeRepository
    val allEmployee: LiveData<List<Employee>?>
        get() = employeeRepository.getMutableLiveData()

    init {
        employeeRepository = EmployeeRepository()
    }
}